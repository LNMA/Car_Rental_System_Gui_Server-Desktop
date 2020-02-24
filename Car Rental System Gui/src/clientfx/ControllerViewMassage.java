package clientfx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import referanceclass.NormalMassageReference;
import referanceclass.OrderReference;
import server.SBE;

import java.io.*;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ControllerViewMassage {
    public TextArea textArea;
    public TableView tableView;
    public TableColumn from;
    public TableColumn date;

    public void initialize(){
        ArrayList<NormalMassageReference> showAll = new ArrayList<>();
        try {
            Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
            DataInputStream in =new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            out.writeUTF("0mx1massage2system");
            out.writeUTF("2normal3massage4show");
            out.writeUTF(ControllerRegistration.staticUsername);
            out.flush();
            int size = in.readInt();
            ObjectInputStream inObject = new ObjectInputStream(in);
            for (int i = 0; i < size; i++) {
                showAll.add((NormalMassageReference) inObject.readObject());
            }
            out.close();
            inObject.close();
            in.close();
            socket.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


        from.setCellValueFactory(new PropertyValueFactory<NormalMassageReference,String>("sender"));
        date.setCellValueFactory(new PropertyValueFactory<NormalMassageReference,Timestamp>("dateCreate"));



        ObservableList<NormalMassageReference> observableList = FXCollections.observableArrayList(showAll);
        tableView.setItems(observableList);


        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                int i = tableView.getSelectionModel().getSelectedIndex();
                textArea.clear();
                textArea.setText(showAll.get(i).getMassage());
            }
        });

    }
}
