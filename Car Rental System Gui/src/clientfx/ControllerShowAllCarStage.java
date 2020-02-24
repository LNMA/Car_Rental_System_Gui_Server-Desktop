package clientfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import referanceclass.CarReference;
import server.SBE;

import java.io.*;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ControllerShowAllCarStage {


    public TableView tableView;
    public TableColumn carID;
    public TableColumn dateCreate;
    public TableColumn type;
    public TableColumn maker;
    public TableColumn model;
    public TableColumn modelYear;
    public TableColumn numberOfSeats;
    public TableColumn registration;
    public TableColumn identification;
    public TableColumn lastMeter;
    public TableColumn costPerDay;
    public TableColumn status;
    public TableColumn costPerKmSedan;
    public TableColumn costPerKmVan;
    public TableColumn insurance;

    public void initialize(){
        ArrayList<CarReference> showAll = new ArrayList<>();
        try {
            Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
            DataInputStream in =new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            out.writeUTF("1cx1edit2all");
            out.writeUTF("1edit17showAll");
            out.flush();
            int size = in.readInt();
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
        carID.setCellValueFactory(new PropertyValueFactory<CarReference,String>("idCar"));
        dateCreate.setCellValueFactory(new PropertyValueFactory<CarReference, Timestamp>("dateCreate"));
        type.setCellValueFactory(new PropertyValueFactory<CarReference,String>("type"));
        maker.setCellValueFactory(new PropertyValueFactory<CarReference,String>("maker"));
        model.setCellValueFactory(new PropertyValueFactory<CarReference,String>("model"));
        modelYear.setCellValueFactory(new PropertyValueFactory<CarReference,Integer>("modelYear"));
        numberOfSeats.setCellValueFactory(new PropertyValueFactory<CarReference,Integer>("numberOfSeats"));
        registration.setCellValueFactory(new PropertyValueFactory<CarReference,String>("registration"));
        identification.setCellValueFactory(new PropertyValueFactory<CarReference,String>("identification"));
        lastMeter.setCellValueFactory(new PropertyValueFactory<CarReference,Double>("lastMeter"));
        costPerDay.setCellValueFactory(new PropertyValueFactory<CarReference,Double>("costPerDay"));
        costPerKmSedan.setCellValueFactory(new PropertyValueFactory<CarReference,Double>("costPerKmSedan"));
        costPerKmVan.setCellValueFactory(new PropertyValueFactory<CarReference,Double>("costPerKmVan"));
        insurance.setCellValueFactory(new PropertyValueFactory<CarReference,Double>("insurance"));
        status.setCellValueFactory(new PropertyValueFactory<CarReference,String>("status"));

        ObservableList<CarReference> questionObservableList = FXCollections.observableArrayList(showAll);
        tableView.setItems(questionObservableList);
    }
}
