package clientfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import referanceclass.OrderReference;
import server.SBE;

import java.io.*;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ControllerShowOrderByCarID {
    public TableView tableView;
    public TableColumn username;
    public TableColumn carId;
    public TableColumn orderId;
    public TableColumn dateCreate;
    public TableColumn day;
    public TableColumn tripDistance;
    public TableColumn paymentMethod;
    public TableColumn bill;
    public TableColumn carType;
    public TableColumn carMaker;
    public TableColumn carModel;
    public TableColumn carModelYear;
    public TableColumn carNumberOfSeats;
    public TableColumn carRegistrationNumber;
    public TableColumn carIdentificationNumber;
    static String carID;

    public void initialize(){
        ArrayList<OrderReference> showAll = new ArrayList<>();
        try {
            Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
            DataInputStream in =new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            out.writeUTF("1ox1show2order");
            out.writeUTF("2show2byCarId");
            out.writeUTF(carID);
            out.flush();
            int size = in.readInt();
            ObjectInputStream inObject = new ObjectInputStream(in);
            for (int i = 0; i < size; i++) {
                showAll.add((OrderReference) inObject.readObject());
            }
            out.close();
            inObject.close();
            in.close();
            socket.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


        username.setCellValueFactory(new PropertyValueFactory<OrderReference,String>("username"));
        carId.setCellValueFactory(new PropertyValueFactory<OrderReference,String>("carID"));
        orderId.setCellValueFactory(new PropertyValueFactory<OrderReference,Integer>("orderID"));
        dateCreate.setCellValueFactory(new PropertyValueFactory<OrderReference, Timestamp>("dateCreate"));
        day.setCellValueFactory(new PropertyValueFactory<OrderReference,Integer>("day"));
        tripDistance.setCellValueFactory(new PropertyValueFactory<OrderReference,Double>("tripDistance"));
        paymentMethod.setCellValueFactory(new PropertyValueFactory<OrderReference,String>("paymentMethods"));
        bill.setCellValueFactory(new PropertyValueFactory<OrderReference,Integer>("bill"));
        carType.setCellValueFactory(new PropertyValueFactory<OrderReference,String>("carType"));
        carMaker.setCellValueFactory(new PropertyValueFactory<OrderReference,String>("carMaker"));
        carModel.setCellValueFactory(new PropertyValueFactory<OrderReference,String>("carModel"));
        carModelYear.setCellValueFactory(new PropertyValueFactory<OrderReference,Integer>("carModelYear"));
        carNumberOfSeats.setCellValueFactory(new PropertyValueFactory<OrderReference,Integer>("carNumberOfSeats"));
        carRegistrationNumber.setCellValueFactory(new PropertyValueFactory<OrderReference,String>("carRegistrationNumber"));
        carIdentificationNumber.setCellValueFactory(new PropertyValueFactory<OrderReference,String>("carIdentificationNumber"));


        ObservableList<OrderReference> questionObservableList = FXCollections.observableArrayList(showAll);
        tableView.setItems(questionObservableList);

    }
}
