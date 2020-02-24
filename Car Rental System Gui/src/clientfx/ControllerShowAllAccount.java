package clientfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import referanceclass.CarReference;
import referanceclass.UserReference;
import server.SBE;

import java.io.*;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ControllerShowAllAccount {
    public TableView tableView;
    public TableColumn username;
    public TableColumn password;
    public TableColumn type;
    public TableColumn dateCreate;
    public TableColumn firstName;
    public TableColumn lastName;
    public TableColumn gender;
    public TableColumn age;
    public TableColumn telephone;
    public TableColumn email;
    public TableColumn address;
    public TableColumn status;
    public TableColumn licenseValidity;
    public TableColumn discountPoint;
    public TableColumn section;
    public TableColumn rank;
    public TableColumn totalBills;

    public void initialize(){
        ArrayList<UserReference> showAll = new ArrayList<>();
        try {
            Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
            DataInputStream in =new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            out.writeUTF("1ux1edit2all");
            out.writeUTF("1edit17showAll");
            out.flush();
            int size = in.readInt();
            ObjectInputStream inObject = new ObjectInputStream(in);
            for (int i = 0; i < size; i++) {
                showAll.add((UserReference) inObject.readObject());
            }
            out.close();
            inObject.close();
            in.close();
            socket.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        username.setCellValueFactory(new PropertyValueFactory<UserReference,String>("username"));
        password.setCellValueFactory(new PropertyValueFactory<UserReference,String>("password"));
        type.setCellValueFactory(new PropertyValueFactory<UserReference,String>("type"));
        dateCreate.setCellValueFactory(new PropertyValueFactory<UserReference,Timestamp>("dateCreate"));
        firstName.setCellValueFactory(new PropertyValueFactory<UserReference,String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<UserReference,String>("lastName"));
        gender.setCellValueFactory(new PropertyValueFactory<UserReference,String>("gender"));
        age.setCellValueFactory(new PropertyValueFactory<UserReference,String>("age"));
        telephone.setCellValueFactory(new PropertyValueFactory<UserReference,Integer>("telephone"));
        email.setCellValueFactory(new PropertyValueFactory<UserReference,String>("email"));
        address.setCellValueFactory(new PropertyValueFactory<UserReference,String>("address"));
        status.setCellValueFactory(new PropertyValueFactory<UserReference,String>("status"));
        licenseValidity.setCellValueFactory(new PropertyValueFactory<UserReference,String>("licenseValidity"));
        discountPoint.setCellValueFactory(new PropertyValueFactory<UserReference,Integer>("discountPoint"));
        totalBills.setCellValueFactory(new PropertyValueFactory<UserReference,Double>("totalBills"));
        section.setCellValueFactory(new PropertyValueFactory<UserReference,String>("section"));
        rank.setCellValueFactory(new PropertyValueFactory<UserReference,String>("rank"));

        ObservableList<UserReference> questionObservableList = FXCollections.observableArrayList(showAll);
        tableView.setItems(questionObservableList);
    }
}
