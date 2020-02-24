package clientfx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import referanceclass.CarReference;
import server.SBE;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

public class ControllerMakeAnOrder {

    static String massageDiscountBills;
    static String massage;
    static String massageBills;
    static Stage alertStage = new Stage();
    private ArrayList<CarReference> showAll = new ArrayList<>();
    public TextField statusTxt;
    public TextField makerTxt;
    public ProgressIndicator indicator;
    public Label notifyLabel;
    public ComboBox carIdComboBox;
    public TextField dayTxt;
    public TextField distanceTxt;
    public ComboBox paymentComboBox;
    public TextField modelTxt;
    public TextField typeTxt;



    public void booking(ActionEvent actionEvent) {
        String carId = (String) carIdComboBox.getSelectionModel().getSelectedItem();
        Integer day = Integer.parseInt(dayTxt.getText());
        Double distance = Double.parseDouble(distanceTxt.getText());
        String payment = (String) paymentComboBox.getSelectionModel().getSelectedItem();
        if (carIdComboBox.getSelectionModel().isEmpty() || dayTxt.getText().isEmpty() || distanceTxt.getText().isEmpty() || paymentComboBox.getSelectionModel().isEmpty()){
            notifyLabel.setText("All field must fill");
        }else {
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in =new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("0ox0add1order");
                out.writeUTF("1make3Order");

                out.writeUTF(ControllerClientMainScreen.OrderUsername);
                out.writeUTF(carId);
                out.writeInt(day);
                out.writeDouble(distance);
                out.writeUTF(payment);
                out.writeInt(ControllerDiscountPointStage.myPoint);
                out.flush();

                massage = in.readUTF();
                massageBills = in.readUTF();
                massageDiscountBills = in.readUTF();
                out.close();
                in.close();
                socket.close();
                notifyLabel.setText(massage);
                showAlertStage();
                ControllerClientMainScreen.makeAnOrderStage.close();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }



    private void showAlertStage(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("notifyBill.fxml"));
            alertStage.setTitle("Order Result");
            alertStage.setScene(new Scene(root, 600, 350));
            alertStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void initialize(){
        paymentComboBox.getItems().addAll("Check", "Credit Card", "Bank Transfer", "Cash");
        dayTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!dayTxt.getText().matches("[\\d*]")){
                    dayTxt.setText(newValue.replaceAll("[^\\d]",""));
                }
                if (dayTxt.getText().length()>11){
                    dayTxt.setText(dayTxt.getText(0,11));
                }
            }
        });
        distanceTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!distanceTxt.getText().matches("[\\d*\\.]")){
                    distanceTxt.setText(newValue.replaceAll("[^\\d\\.]",""));
                }
            }
        });
        int size = 0;
        try {
            Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
            DataInputStream in =new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            out.writeUTF("1cx1edit2all");
            out.writeUTF("1edit17showAll");
            out.flush();
            size = in.readInt();
            ObjectInputStream inObject = new ObjectInputStream(in);
            for (int i = 0; i < size; i++) {
                showAll.add((CarReference) inObject.readObject());
            }
            out.close();
            inObject.close();
            in.close();
            socket.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        for (int i = 0; i <size ; i++) {
            carIdComboBox.getItems().add(showAll.get(i).getIdCar());
        }
    }

    public void carIdSelect(ActionEvent actionEvent) {
        int index = carIdComboBox.getSelectionModel().getSelectedIndex();
        typeTxt.setText(showAll.get(index).getType());
        modelTxt.setText(showAll.get(index).getModel());
        statusTxt.setText(showAll.get(index).getStatus());
        makerTxt.setText(showAll.get(index).getMaker());
    }
}
