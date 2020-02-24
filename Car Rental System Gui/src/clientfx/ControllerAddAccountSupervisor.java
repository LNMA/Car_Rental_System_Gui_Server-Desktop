package clientfx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import server.SBE;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.GregorianCalendar;

public class ControllerAddAccountSupervisor {
    public Label addAccountLabel;
    public Label pointLabel;
    public Label licenseLabel;
    public Label statusLabel;
    public Label emailLabel;
    public Label telephoneLabel;
    public Label ageLabel;
    public Label genderLabel;
    public Label lastNameLabel;
    public Label firstNameLabel;
    public Label passwordLabel;
    public Label usernameLabel;
    public TextField usernameTxt;
    public PasswordField passwordTxt;
    public TextField firstNameTxt;
    public TextField lastNameTxt;
    public ComboBox genderComboBox;
    public ComboBox yearComboBox;
    public ComboBox monthComboBox;
    public ComboBox dayComboBox;
    public TextField telephoneTxt;
    public TextField emailTxt;
    public ComboBox statusComboBox;
    public ComboBox validityComboBox;
    public TextField pointTxt;
    public Label addressLabel;
    public TextField addressTxt;
    public Label licenseMainLabel;
    public Label pointMainLabel;
    public Label totalBillsMainLabel;
    public TextField totalBillsTxt;
    public Label totalBillsLabel;

    public void addAccountEvent(ActionEvent actionEvent) {
        if (usernameTxt.getText().isEmpty() || passwordTxt.getText().isEmpty() || firstNameTxt.getText().isEmpty() || lastNameTxt.getText().isEmpty() || genderComboBox.getSelectionModel().isEmpty() || yearComboBox.getSelectionModel().isEmpty() || monthComboBox.getSelectionModel().isEmpty() || dayComboBox.getSelectionModel().isEmpty() || telephoneTxt.getText().isEmpty() || emailTxt.getText().isEmpty() || addressTxt.getText().isEmpty() || statusComboBox.getSelectionModel().isEmpty() || pointTxt.getText().isEmpty() || validityComboBox.getSelectionModel().isEmpty() || totalBillsTxt.getText().isEmpty()) {
            addAccountLabel.setVisible(true);
            addAccountLabel.setText("all field must fill");
        } else {
            String username = usernameTxt.getText();
            String password = passwordTxt.getText();
            String firstName = firstNameTxt.getText();
            String lastName = lastNameTxt.getText();
            String gender = (String) genderComboBox.getSelectionModel().getSelectedItem();
            Integer year = (Integer) yearComboBox.getSelectionModel().getSelectedItem();
            Integer month = (Integer) monthComboBox.getSelectionModel().getSelectedItem();
            Integer day = (Integer) dayComboBox.getSelectionModel().getSelectedItem();
            int telephone = Integer.parseInt(telephoneTxt.getText());
            String email = emailTxt.getText();
            String address = addressTxt.getText();
            String status = (String) statusComboBox.getSelectionModel().getSelectedItem();
            String license = "null";
            if (!validityComboBox.getSelectionModel().isEmpty()) {
                license = (String) validityComboBox.getSelectionModel().getSelectedItem();
            }
            int point = 0;
            if (!pointTxt.getText().isEmpty()) {
                point = Integer.parseInt(pointTxt.getText());
            }
            double totalBills = 0;
            if (!totalBillsTxt.getText().isEmpty()) {
                totalBills = Double.parseDouble(totalBillsTxt.getText());
            }
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("0ux0add1all");
                out.writeUTF(username);
                out.writeUTF(password);
                out.writeUTF("client");
                out.writeUTF(firstName);
                out.writeUTF(lastName);
                out.writeUTF(gender);
                out.writeInt(year);
                out.writeInt(month);
                out.writeInt(day);
                out.writeInt(telephone);
                out.writeUTF(email);
                out.writeUTF(address);
                out.writeUTF(status);
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF(license);
                out.writeInt(point);
                out.writeDouble(totalBills);
                out.flush();

                String addUserMassage = in.readUTF();
                String firstNameMassage = in.readUTF();
                String lastNameMassage = in.readUTF();
                String genderMassage = in.readUTF();
                String ageMassage = in.readUTF();
                String telephoneMassage = in.readUTF();
                String emailMassage = in.readUTF();
                String addressMassage = in.readUTF();
                String statusMassage = in.readUTF();
                String rankMassage = in.readUTF();
                String sectionMassage = in.readUTF();
                String licenseMassage = in.readUTF();
                String pointMassage = in.readUTF();
                String totalBillsMassage = in.readUTF();
                out.close();
                in.close();
                socket.close();

                addAccountLabel.setVisible(true);
                firstNameLabel.setVisible(true);
                lastNameLabel.setVisible(true);
                genderLabel.setVisible(true);
                ageLabel.setVisible(true);
                telephoneLabel.setVisible(true);
                emailLabel.setVisible(true);
                addressLabel.setVisible(true);
                statusLabel.setVisible(true);
                licenseLabel.setVisible(true);
                pointLabel.setVisible(true);
                totalBillsLabel.setVisible(true);

                addAccountLabel.setText(addUserMassage);
                firstNameLabel.setText(firstNameMassage);
                lastNameLabel.setText(lastNameMassage);
                genderLabel.setText(genderMassage);
                ageLabel.setText(ageMassage);
                telephoneLabel.setText(telephoneMassage);
                emailLabel.setText(emailMassage);
                addressLabel.setText(addressMassage);
                statusLabel.setText(statusMassage);
                licenseLabel.setText(licenseMassage);
                pointLabel.setText(pointMassage);
                totalBillsLabel.setText(totalBillsMassage);

                usernameTxt.clear();
                passwordTxt.clear();
                genderComboBox.getSelectionModel().clearSelection();
                firstNameTxt.clear();
                lastNameTxt.clear();
                yearComboBox.getSelectionModel().clearSelection();
                monthComboBox.getSelectionModel().clearSelection();
                dayComboBox.getSelectionModel().clearSelection();
                telephoneTxt.clear();
                emailTxt.clear();
                statusComboBox.getSelectionModel().clearSelection();
                addressTxt.clear();
                validityComboBox.getSelectionModel().clearSelection();
                pointTxt.clear();
                totalBillsTxt.clear();
                pointTxt.setVisible(false);
                pointMainLabel.setVisible(false);
                licenseMainLabel.setVisible(false);
                validityComboBox.setVisible(false);
                totalBillsTxt.setVisible(false);
                totalBillsMainLabel.setVisible(false);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }




    public void initialize(){
        validityComboBox.getItems().addAll("Valid", "Invalid");
        statusComboBox.getItems().addAll("Online", "Offline");
        genderComboBox.getItems().addAll("Male","Female");
        yearComboBox.getItems().addAll(1950,1951,1952,1953,1954,1955,1956,1957,1958,1959,1960,1961,1962,1963,1964,1965,1966,1967,1968,1969,1970,1971,1972,1973,1974,1975,1976,1977,1978,1979,1980,1981,1982,1983,1984,1985,1986,1987,1988,1989,1990,1991,1992,1993,1994,1995,1996,1997,1998,1999,2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,2015,2016,2017,2018,2019,2020);
        monthComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12);
        usernameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                usernameTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (usernameTxt.getText().length()>30){
                    usernameTxt.setText(usernameTxt.getText(0,30));
                }
            }
        });
        passwordTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                passwordTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (passwordTxt.getText().length()>30){
                    passwordTxt.setText(passwordTxt.getText(0,30));
                }
            }
        });
        firstNameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (firstNameTxt.getText().length()>50){
                    firstNameTxt.setText(firstNameTxt.getText(0,50));
                }
            }
        });
        lastNameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (lastNameTxt.getText().length()>50){
                    lastNameTxt.setText(lastNameTxt.getText(0,50));
                }
            }
        });
        telephoneTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!telephoneTxt.getText().matches("[\\d*]")){
                    telephoneTxt.setText(newValue.replaceAll("[^\\d]",""));
                }
                if (telephoneTxt.getText().length()>15){
                    telephoneTxt.setText(telephoneTxt.getText(0,15));
                }
            }
        });
        pointTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!pointTxt.getText().matches("[\\d*]")){
                    pointTxt.setText(newValue.replaceAll("[^\\d]",""));
                }
                if (pointTxt.getText().length()>11){
                    pointTxt.setText(pointTxt.getText(0,11));
                }
            }
        });
        totalBillsTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!totalBillsTxt.getText().matches("[\\d*\\.]")){
                    totalBillsTxt.setText(newValue.replaceAll("[^\\d\\.]",""));
                }
            }
        });

        emailTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (emailTxt.getText().length()>62){
                    emailTxt.setText(emailTxt.getText(0,62));
                }
            }
        });
        addressTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (addressTxt.getText().length()>120){
                    addressTxt.setText(addressTxt.getText(0,120));
                }
            }
        });
    }

    public void setDay(ActionEvent actionEvent) {
        if (monthComboBox.getSelectionModel().isSelected(0) || monthComboBox.getSelectionModel().isSelected(2) || monthComboBox.getSelectionModel().isSelected(4) || monthComboBox.getSelectionModel().isSelected(6) || monthComboBox.getSelectionModel().isSelected(7) || monthComboBox.getSelectionModel().isSelected(9) || monthComboBox.getSelectionModel().isSelected(11)){
            dayComboBox.getItems().clear();
            dayComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31);
        }
        if (monthComboBox.getSelectionModel().isSelected(3) || monthComboBox.getSelectionModel().isSelected(5) || monthComboBox.getSelectionModel().isSelected(8) || monthComboBox.getSelectionModel().isSelected(10)){
            dayComboBox.getItems().clear();
            dayComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30);
        }
        if (monthComboBox.getSelectionModel().isSelected(1)){
            Integer year = (Integer)yearComboBox.getSelectionModel().getSelectedItem();
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (gregorianCalendar.isLeapYear(year)){
                dayComboBox.getItems().clear();
                dayComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29);
            }else {
                dayComboBox.getItems().clear();
                dayComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28);
            }
        }
    }



    public void clear1(MouseEvent mouseEvent) {
        usernameLabel.setVisible(false);
        passwordLabel.setVisible(false);
        addAccountLabel.setVisible(false);
        firstNameLabel.setVisible(false);
        lastNameLabel.setVisible(false);
        genderLabel.setVisible(false);
        ageLabel.setVisible(false);
        telephoneLabel.setVisible(false);
        emailLabel.setVisible(false);
        addressLabel.setVisible(false);
        statusLabel.setVisible(false);
        licenseLabel.setVisible(false);
        pointLabel.setVisible(false);
        totalBillsLabel.setVisible(false);
    }

    public void clear2(MouseEvent mouseEvent) {
        usernameLabel.setVisible(false);
        passwordLabel.setVisible(false);
        addAccountLabel.setVisible(false);
        firstNameLabel.setVisible(false);
        lastNameLabel.setVisible(false);
        genderLabel.setVisible(false);
        ageLabel.setVisible(false);
        telephoneLabel.setVisible(false);
        emailLabel.setVisible(false);
        addressLabel.setVisible(false);
        statusLabel.setVisible(false);
        licenseLabel.setVisible(false);
        pointLabel.setVisible(false);
        totalBillsLabel.setVisible(false);
    }
}
