package clientfx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import server.SBE;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ControllerSendMassage {
    public TextField toTxt;
    public CheckBox administrativeMessageCheckBox;
    public TextArea massage;
    public Label sendLabel;


    public void send(ActionEvent actionEvent) {
        if (administrativeMessageCheckBox.isSelected()) {
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("0mx1massage2system");
                out.writeUTF("1administrative2massage2send");
                out.flush();
                out.writeUTF(ControllerRegistration.staticUsername);
                out.writeUTF(massage.getText());
                out.flush();
                String isExist = in.readUTF();
                String result = in.readUTF();
                sendLabel.setVisible(true);
                sendLabel.setText(isExist + ". " + result);
                massage.clear();
                out.close();
                in.close();
                socket.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        if (!administrativeMessageCheckBox.isSelected()) {
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("0mx1massage2system");
                out.writeUTF("0normal1massage1send");
                out.flush();
                out.writeUTF(toTxt.getText());
                out.writeUTF(ControllerRegistration.staticUsername);
                out.writeUTF(massage.getText());
                out.flush();
                String isExist = in.readUTF();
                String result = in.readUTF();
                sendLabel.setVisible(true);
                sendLabel.setText(isExist + ". " + result);
                massage.clear();
                toTxt.clear();
                out.close();
                in.close();
                socket.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void administrativeMessageEvent(ActionEvent actionEvent) {
        if (administrativeMessageCheckBox.isSelected())
        toTxt.setDisable(true);
        if (!administrativeMessageCheckBox.isSelected())
            toTxt.setDisable(false);

    }

    public void initialize(){
        toTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                toTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (toTxt.getText().length()>30){
                    toTxt.setText(toTxt.getText(0,30));
                }
            }
        });

        massage.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (massage.getText().length()>1000){
                    massage.setText(toTxt.getText(0,1000));
                }
            }
        });
    }
}
