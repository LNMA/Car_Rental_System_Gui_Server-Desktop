package clientfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import referanceclass.UserReference;
import server.SBE;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ControllerDiscountPointStage {
    public TextField pointTxt;
    public RadioButton yesRadio;
    public RadioButton noRadio;
    public ComboBox pointComboBox;
    private int discountPoint;
    private double totalBills;
    static int myPoint = 0;

    public void letsDoIt(ActionEvent actionEvent) {
        if (yesRadio.isSelected()){
            if (!pointComboBox.getSelectionModel().isEmpty()){
                myPoint = (Integer) pointComboBox.getSelectionModel().getSelectedItem();
            }
        }else{
            myPoint =0;
        }
        ControllerClientMainScreen.discountPointStage.close();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("makeAnOrderStage.fxml"));
            ControllerClientMainScreen.makeAnOrderStage.setTitle("Make An Order");
            ControllerClientMainScreen.makeAnOrderStage.setScene(new Scene(root, 1000, 700));
            ControllerClientMainScreen.makeAnOrderStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }    }

    public void initialize(){
        ArrayList<UserReference> showAll = new ArrayList<>();
        String username = ControllerClientMainScreen.OrderUsername;
        try {
            Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
            DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            out.writeUTF("1ux1edit2all");
            out.writeUTF("2edit19showUserInfo");
            out.writeUTF(username);
            out.flush();
            int size = in.readInt();
            ObjectInputStream inObject = new ObjectInputStream(in);
            for (int i = 0; i < size; i++) {
                showAll.add((UserReference) inObject.readObject());
            }
            out.flush();
            out.close();
            inObject.close();
            in.close();
            socket.close();
            discountPoint = showAll.get(0).getDiscountPoint();
            totalBills = showAll.get(0).getTotalBills();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        pointTxt.setText(new Integer(discountPoint).toString());

        ToggleGroup toggleGroup = new ToggleGroup();
        yesRadio.setToggleGroup(toggleGroup);
        noRadio.setToggleGroup(toggleGroup);

        for (int i = 1; i < discountPoint+1; i++) {
            pointComboBox.getItems().add((Integer)i);
        }

        pointComboBox.setVisible(false);
    }

    public void yesChoose(ActionEvent actionEvent) {
        pointComboBox.setVisible(true);
    }

    public void noChoose(ActionEvent actionEvent) {
        pointComboBox.setVisible(false);
    }
}
