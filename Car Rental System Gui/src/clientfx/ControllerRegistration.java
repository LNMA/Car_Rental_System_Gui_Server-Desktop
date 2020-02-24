package clientfx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import server.SBE;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.GregorianCalendar;

public class ControllerRegistration  {

    static String staticUsername;
    static Stage rootStage = new Stage();
    static Stage clientStage = new Stage();
    static Stage supervisorStage = new Stage();
    public Tab signUpMenuItem;
    public Tab signInMenuItem;
    public TabPane tabPane;
    public ComboBox genderComboBox;
    public ComboBox yearComboBox;
    public ComboBox monthComboBox;
    public ComboBox dayComboBox;
    public TextField usernameUp;
    public PasswordField passwordUp;
    public TextField firstNameUp;
    public TextField lastNameUp;
    public TextField telephoneUp;
    public TextField emailUp;
    public TextField addressUp;
    public Label notifySignUp;
    public Label usernameLabel;
    public Label passwordLabel;
    public Label firstNameLabel;
    public Label lastNameLabel;
    public Label genderLabel;
    public Label ageLabel;
    public Label telephoneLabel;
    public Label emailLabel;
    public Label addressLabel;
    public TextField usernameIn;
    public TextField passwordIn;
    public Label notifySignIn;
    public ProgressIndicator indicator;
    public Tab changeUsernameTab;
    public Tab changePasswordTab;
    public TextField changeUsernameOldUsernameTxt;
    public TextField changeUsernameNewUsernameTxt;
    public PasswordField changeUsernamePasswordTxt;
    public Label changeUsernameLabel;
    public TextField changePasswordUsernameTxt;
    public PasswordField changePasswordOldPasswordTxt;
    public PasswordField changePasswordOldPasswordTxt1;
    public PasswordField changePasswordNewPasswordTxt;
    public PasswordField changePasswordNewPasswordTxt1;
    public Label changePasswordLabel;



    public void changePasswordEvent(ActionEvent actionEvent) {
        if (changePasswordUsernameTxt.getText().isEmpty() || changePasswordOldPasswordTxt.getText().isEmpty() || changePasswordOldPasswordTxt1.getText().isEmpty() || changePasswordNewPasswordTxt.getText().isEmpty() || changePasswordNewPasswordTxt1.getText().isEmpty()){
            changePasswordLabel.setVisible(true);
            changePasswordLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = changePasswordUsernameTxt.getText();
            String oldPassword = changePasswordOldPasswordTxt.getText();
            String oldPassword1 = changePasswordOldPasswordTxt1.getText();
            String newPassword = changePasswordNewPasswordTxt.getText();
            String newPassword1 = changePasswordNewPasswordTxt1.getText();
            if (!(oldPassword.equals(oldPassword1) || newPassword.equals(newPassword1))) {
                changePasswordLabel.setVisible(true);
                changePasswordLabel.setText("your new password or old password does not match");
            } else {
                if (newPassword.length() < 6) {
                    changePasswordLabel.setVisible(true);
                    changePasswordLabel.setText("password must be at least 6 character");
                } else {
                    try {
                        Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                        DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                        out.writeUTF("2rx3change4client");
                        out.writeUTF("2change3password");
                        out.writeUTF(username);
                        out.writeUTF(oldPassword1);
                        out.writeUTF(newPassword1);
                        out.flush();
                        String isExist = in.readUTF();
                        String massage = in.readUTF();
                        out.close();
                        in.close();
                        socket.close();
                        changePasswordLabel.setVisible(true);
                        changePasswordLabel.setText(isExist + ". " + massage);
                        changePasswordUsernameTxt.clear();
                        changePasswordOldPasswordTxt.clear();
                        changePasswordOldPasswordTxt1.clear();
                        changePasswordNewPasswordTxt.clear();
                        changePasswordNewPasswordTxt1.clear();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public void changeUsernameOldUsernameEvent(ActionEvent actionEvent) {
        if (changeUsernameOldUsernameTxt.getText().isEmpty() || changeUsernameNewUsernameTxt.getText().isEmpty() || changeUsernamePasswordTxt.getText().isEmpty()) {
            changeUsernameLabel.setVisible(true);
            changeUsernameLabel.setText("ALL FIELD MUST FILL");
        } else {
            String username = changeUsernameOldUsernameTxt.getText();
            String newUsername = changeUsernameNewUsernameTxt.getText();
            String password = changeUsernamePasswordTxt.getText();
            if (newUsername.length() < 5) {
                changeUsernameLabel.setVisible(true);
                changeUsernameLabel.setText("username must be at least 5 character");
            } else {
                try {
                    Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                    DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                    DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                    out.writeUTF("2rx3change4client");
                    out.writeUTF("1change2username");
                    out.writeUTF(username);
                    out.writeUTF(newUsername);
                    out.writeUTF(password);
                    out.flush();
                    String isExist = in.readUTF();
                    String massage = in.readUTF();
                    out.close();
                    in.close();
                    socket.close();
                    changeUsernameLabel.setVisible(true);
                    changeUsernameLabel.setText(isExist + ". " + massage);
                    changeUsernameOldUsernameTxt.clear();
                    changeUsernameNewUsernameTxt.clear();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public void signIn(ActionEvent actionEvent) {
        String username = usernameIn.getText();
        String password = passwordIn.getText();
        try{
            Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
            DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            out.writeUTF("1rx1s2i");
            out.writeUTF(username);
            out.writeUTF(password);
            out.flush();
            boolean isAllow = in.readBoolean();
            String massage = in.readUTF();
            String type = in.readUTF();
            out.flush();
            out.close();
            in.close();
            socket.close();
            if (isAllow){
                notifySignIn.setVisible(true);
                notifySignIn.setText(massage);
                staticUsername = username;
                try {
                    Socket socketOn = new Socket(SBE.getServerHost(), SBE.getClientPort());
                    DataInputStream inOn = new DataInputStream(new BufferedInputStream(socketOn.getInputStream()));
                    DataOutputStream outOn = new DataOutputStream(new BufferedOutputStream(socketOn.getOutputStream()));
                    outOn.writeUTF("1ux1edit2all");
                    outOn.writeUTF("2edit18AccountOnline");
                    outOn.writeUTF(staticUsername);
                    outOn.flush();
                    outOn.close();
                    inOn.close();
                    socketOn.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }

                if (type.equals("client")){
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("clientMainScreen.fxml"));
                        clientStage.setTitle("Client");
                        clientStage.setScene(new Scene(root, 1000, 600));
                        clientStage.show();
                        usernameIn.clear();
                        passwordIn.clear();
                        Main.registrationStage.hide();

                        clientStage.setOnCloseRequest(event ->{
                            Main.registrationStage.show();
                            if (!staticUsername.equals(null)) {
                                try {
                                    Socket socketOff = new Socket(SBE.getServerHost(), SBE.getClientPort());
                                    DataInputStream inOff = new DataInputStream(new BufferedInputStream(socketOff.getInputStream()));
                                    DataOutputStream outOff = new DataOutputStream(new BufferedOutputStream(socketOff.getOutputStream()));
                                    outOff.writeUTF("1ux1edit2all");
                                    outOff.writeUTF("2edit18AccountOffline");
                                    outOff.writeUTF(staticUsername);
                                    outOff.flush();
                                    outOff.close();
                                    inOff.close();
                                    socketOff.close();
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                    e.printStackTrace();
                                }
                            }
                        });

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }

                }

                if (type.equals("supervisor")){
                        try {
                            Parent root = FXMLLoader.load(getClass().getResource("supervisorMainScreen.fxml"));
                            supervisorStage.setTitle("Supervisor");
                            supervisorStage.setScene(new Scene(root, 1000, 600));
                            supervisorStage.show();
                            usernameIn.clear();
                            passwordIn.clear();
                            Main.registrationStage.hide();

                            supervisorStage.setOnCloseRequest(event ->{
                                Main.registrationStage.show();
                                if (!staticUsername.equals(null)) {
                                    try {
                                        Socket socketOff = new Socket(SBE.getServerHost(), SBE.getClientPort());
                                        DataInputStream inOff = new DataInputStream(new BufferedInputStream(socketOff.getInputStream()));
                                        DataOutputStream outOff = new DataOutputStream(new BufferedOutputStream(socketOff.getOutputStream()));
                                        outOff.writeUTF("1ux1edit2all");
                                        outOff.writeUTF("2edit18AccountOffline");
                                        outOff.writeUTF(staticUsername);
                                        outOff.flush();
                                        outOff.close();
                                        inOff.close();
                                        socketOff.close();
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                            e.printStackTrace();
                        }
                    }


                if (type.equals("root")){
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("rootMainScreen .fxml"));
                        rootStage.setTitle("Root");
                        rootStage.setScene(new Scene(root, 1000, 600));
                        rootStage.show();
                        usernameIn.clear();
                        passwordIn.clear();
                        Main.registrationStage.hide();

                        rootStage.setOnCloseRequest(event ->{
                            Main.registrationStage.show();
                            if (!staticUsername.equals(null)) {
                                try {
                                    Socket socketOff = new Socket(SBE.getServerHost(), SBE.getClientPort());
                                    DataInputStream inOff = new DataInputStream(new BufferedInputStream(socketOff.getInputStream()));
                                    DataOutputStream outOff = new DataOutputStream(new BufferedOutputStream(socketOff.getOutputStream()));
                                    outOff.writeUTF("1ux1edit2all");
                                    outOff.writeUTF("2edit18AccountOffline");
                                    outOff.writeUTF(staticUsername);
                                    outOff.flush();
                                    outOff.close();
                                    inOff.close();
                                    socketOff.close();
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                    e.printStackTrace();
                                }
                            }
                        });

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                }
            }else {
                notifySignIn.setVisible(true);
                notifySignIn.setText(massage);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void signUp(ActionEvent actionEvent) {
        if (usernameUp.getText().length()<4){
            usernameLabel.setVisible(true);
            usernameLabel.setText("Username must at least 4 character");
        }
        if (passwordUp.getText().length()<6){
            passwordLabel.setVisible(true);
            passwordLabel.setText("Password must be at least 6 character");
        }
        if (usernameUp.getText().length()>3 && passwordUp.getText().length()>5) {
            String username = usernameUp.getText();
            String password = passwordUp.getText();
            String firstName = firstNameUp.getText();
            String lastName = lastNameUp.getText();
            String gender = null;
            if (genderComboBox.getSelectionModel().getSelectedItem() == null){
                gender = "Male";
            }else {
                gender = (String) genderComboBox.getSelectionModel().getSelectedItem();
            }
            Integer year;
            Integer month;
            Integer day;
            if (yearComboBox.getSelectionModel().getSelectedItem() == null || monthComboBox.getSelectionModel().getSelectedItem() == null || dayComboBox.getSelectionModel().getSelectedItem()==null){
                year = 1950;
                month = 1;
                day = 1;
            }else {
                year = (Integer) yearComboBox.getSelectionModel().getSelectedItem();
                month = (Integer) monthComboBox.getSelectionModel().getSelectedItem();
                day = (Integer) dayComboBox.getSelectionModel().getSelectedItem();
            }
            int telephone = 0;
            if (!telephoneUp.getText().isEmpty()) {
                telephone = Integer.parseInt(telephoneUp.getText());
            }
            String email = emailUp.getText();
            String address = addressUp.getText();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("0rx0s1u");
                out.writeUTF(username);
                out.writeUTF(password);
                out.writeUTF(firstName);
                out.writeUTF(lastName);
                out.writeUTF(gender);
                out.writeInt(year);
                out.writeInt(month);
                out.writeInt(day);
                out.writeInt(telephone);
                out.writeUTF(email);
                out.writeUTF(address);
                out.flush();
                String signUp = in.readUTF();
                String firstNameMassage = in.readUTF();
                String lastNameMassage = in.readUTF();
                String genderMassage = in.readUTF();
                String ageMassage = in.readUTF();
                String telephoneMassage = in.readUTF();
                String emailMassage = in.readUTF();
                String addressMassage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                notifySignUp.setVisible(true);
                firstNameLabel.setVisible(true);
                lastNameLabel.setVisible(true);
                genderLabel.setVisible(true);
                ageLabel.setVisible(true);
                telephoneLabel.setVisible(true);
                emailLabel.setVisible(true);
                addressLabel.setVisible(true);
                notifySignUp.setText(signUp);
                firstNameLabel.setText(firstNameMassage);
                lastNameLabel.setText(lastNameMassage);
                genderLabel.setText(genderMassage);
                ageLabel.setText(ageMassage);
                telephoneLabel.setText(telephoneMassage);
                emailLabel.setText(emailMassage);
                addressLabel.setText(addressMassage);
                usernameUp.clear();
                passwordUp.clear();
                firstNameUp.clear();
                lastNameUp.clear();
                genderComboBox.getSelectionModel().clearSelection();
                yearComboBox.getSelectionModel().clearSelection();
                monthComboBox.getSelectionModel().clearSelection();
                dayComboBox.getSelectionModel().clearSelection();
                telephoneUp.clear();
                emailUp.clear();
                addressUp.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void signInTapShow(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(signInMenuItem)){
            tabPane.getTabs().add(signInMenuItem);
        }
    }

    public void signUpTapShow(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(signUpMenuItem)){
            tabPane.getTabs().add(signUpMenuItem);
        }
    }

    public void closeRegistrationStage(ActionEvent actionEvent) {
        Main.registrationStage.close();
    }

    public void initialize(){
        genderComboBox.getItems().addAll("Male","Female");
        yearComboBox.getItems().addAll(1950,1951,1952,1953,1954,1955,1956,1957,1958,1959,1960,1961,1962,1963,1964,1965,1966,1967,1968,1969,1970,1971,1972,1973,1974,1975,1976,1977,1978,1979,1980,1981,1982,1983,1984,1985,1986,1987,1988,1989,1990,1991,1992,1993,1994,1995,1996,1997,1998,1999,2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,2015,2016,2017,2018,2019,2020);
        monthComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12);
        usernameUp.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                usernameUp.setText(newValue.replaceAll("[\\s]+",""));
                if (usernameUp.getText().length()>30){
                    usernameUp.setText(usernameUp.getText(0,30));
                }
            }
        });
        passwordUp.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                passwordUp.setText(newValue.replaceAll("[\\s]+",""));
                if (passwordUp.getText().length()>30){
                    passwordUp.setText(passwordUp.getText(0,30));
                }
            }
        });
        firstNameUp.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (firstNameUp.getText().length()>50){
                    firstNameUp.setText(firstNameUp.getText(0,50));
                }
            }
        });
        lastNameUp.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (lastNameUp.getText().length()>50){
                    lastNameUp.setText(lastNameUp.getText(0,50));
                }
            }
        });
        telephoneUp.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!telephoneUp.getText().matches("[\\d*]")){
                    telephoneUp.setText(newValue.replaceAll("[^\\d]",""));
                }
                if (telephoneUp.getText().length()>15){
                    telephoneUp.setText(telephoneUp.getText(0,15));
                }
            }
        });
        emailUp.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (emailUp.getText().length()>62){
                    emailUp.setText(emailUp.getText(0,62));
                }
            }
        });
        addressUp.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (addressUp.getText().length()>120){
                    addressUp.setText(addressUp.getText(0,120));
                }
            }
        });
        usernameIn.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                usernameIn.setText(newValue.replaceAll("[\\s]+",""));
                if (usernameIn.getText().length()>30){
                    usernameIn.setText(usernameIn.getText(0,30));
                }
            }
        });
        passwordIn.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                passwordIn.setText(newValue.replaceAll("[\\s]+",""));
                if (passwordIn.getText().length()>30){
                    passwordIn.setText(passwordIn.getText(0,30));
                }
            }
        });

        tabPane.getTabs().remove(changeUsernameTab);
        tabPane.getTabs().remove(changePasswordTab);
    }
    public void about(ActionEvent actionEvent) {
        Stage stage = new Stage();
        StackPane stackPane = new StackPane();
        Label label = new Label(" ______\t\t\t\t\t\t\t\t  \t         \n" +
                "|      |\t\t\t\t\t\t          \t       \n" +
                "|      |\t\t _______________\t____\t     ____  \t      __________       \t    ____\t ____\n" +
                "|      |\t\t/\t\t\\      |    |       |\t |\t     /    __    \\\t   |    |       |    |\n" +
                "|      |\t       |     _______\t |     |    |       |\t |    \t    /    /  \\    \\\t   |    |       |    |\n" +
                "|      |\t       |    |       |\t |     |    |       |\t |     \t   /    /    \\    \\\t   |    |       |    |\n" +
                "|      |\t       |    |\t    |\t |     |    |\t    |\t |\t  /    /______\\    \\\t   |    |       |    |\n" +
                "|      |________       |    |\t    |\t |     |    |\t    |\t | \t /    __________    \\\t   |    |       |    |\n" +
                "|               |      |    |_______|\t |     |    |_______|\t |      /    /          \\    \\     |    |_______|    |\n" +
                "|               |      |   \t\t |     |   \t\t |     /    /\t         \\    \\    |                 |\n" +
                "|_______________|\t\\_______________/\t\\_______________/     /____/\t\t  \\____\\    \\___________     |\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t|    |\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t        |    |\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t        |    |\n" +
                " ______________________________________________________________________________________________________________/     |\n" +
                "|\t\t\t\t\t\t\t\t\t\t\t\t\t\t     |\n" +
                "|___________________________________________________________________________________________________________________/  \n"+
                "\n\n                  Author: Louay Amr ----- Email: louay_amr@outlook.com ----- phone: 00962780977566");
        stackPane.getChildren().add(label);
        label.setStyle("-fx-text-fill:crimson;-fx-font-family: Consolas; -fx-font-weight: bolder; -fx-font-size: 14; -fx-background-color: black");
        stackPane.setStyle("-fx-background-color:linear-gradient(darkblue,darkred)");
        stage.setTitle("About");
        stage.setScene(new Scene(stackPane, 1100, 700));
        stage.show();
    }

    public void monthDay(ActionEvent actionEvent) {
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
        notifySignUp.setVisible(false);
        usernameLabel.setVisible(false);
        passwordLabel.setVisible(false);
        firstNameLabel.setVisible(false);
        lastNameLabel.setVisible(false);
        genderLabel.setVisible(false);
        ageLabel.setVisible(false);
        telephoneLabel.setVisible(false);
        emailLabel.setVisible(false);
        addressLabel.setVisible(false);
    }

    public void clear2(MouseEvent mouseEvent) {
        notifySignUp.setVisible(false);
        usernameLabel.setVisible(false);
        passwordLabel.setVisible(false);
        firstNameLabel.setVisible(false);
        lastNameLabel.setVisible(false);
        genderLabel.setVisible(false);
        ageLabel.setVisible(false);
        telephoneLabel.setVisible(false);
        emailLabel.setVisible(false);
        addressLabel.setVisible(false);
    }

    public void clear3(MouseEvent mouseEvent) {
        notifySignIn.setVisible(false);
    }

    public void clear4(MouseEvent mouseEvent) {
        notifySignIn.setVisible(false);
    }

    public void showChangeUsername(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(changeUsernameTab)){
            tabPane.getTabs().add(changeUsernameTab);
        }
        changeUsernameOldUsernameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                changeUsernameOldUsernameTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (changeUsernameOldUsernameTxt.getText().length()>30){
                    changeUsernameOldUsernameTxt.setText(changeUsernameOldUsernameTxt.getText(0,30));
                }
            }
        });
        changeUsernameNewUsernameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                changeUsernameNewUsernameTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (changeUsernameNewUsernameTxt.getText().length()>30){
                    changeUsernameNewUsernameTxt.setText(changeUsernameNewUsernameTxt.getText(0,30));
                }
            }
        });
        changeUsernamePasswordTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                changeUsernamePasswordTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (changeUsernamePasswordTxt.getText().length()>30){
                    changeUsernamePasswordTxt.setText(changeUsernamePasswordTxt.getText(0,30));
                }
            }
        });
    }

    public void showChangePassword(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(changePasswordTab)){
            tabPane.getTabs().add(changePasswordTab);
        }
        changePasswordUsernameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                changePasswordUsernameTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (changePasswordUsernameTxt.getText().length()>30){
                    changePasswordUsernameTxt.setText(changePasswordUsernameTxt.getText(0,30));
                }
            }
        });
        changePasswordOldPasswordTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                changePasswordOldPasswordTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (changePasswordOldPasswordTxt.getText().length()>30){
                    changePasswordOldPasswordTxt.setText(changePasswordOldPasswordTxt.getText(0,30));
                }
            }
        });
        changePasswordOldPasswordTxt1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                changePasswordOldPasswordTxt1.setText(newValue.replaceAll("[\\s]+",""));
                if (changePasswordOldPasswordTxt1.getText().length()>30){
                    changePasswordOldPasswordTxt1.setText(changePasswordOldPasswordTxt1.getText(0,30));
                }
            }
        });
        changePasswordNewPasswordTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                changePasswordNewPasswordTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (changePasswordNewPasswordTxt.getText().length()>30){
                    changePasswordNewPasswordTxt.setText(changePasswordNewPasswordTxt.getText(0,30));
                }
            }
        });
        changePasswordNewPasswordTxt1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                changePasswordNewPasswordTxt1.setText(newValue.replaceAll("[\\s]+",""));
                if (changePasswordNewPasswordTxt1.getText().length()>30){
                    changePasswordNewPasswordTxt1.setText(changePasswordNewPasswordTxt1.getText(0,30));
                }
            }
        });
    }

    public void hideChangeUsernameLabel2(MouseEvent mouseEvent) {
        changeUsernameLabel.setVisible(false);
    }

    public void hideChangeUsernameLabel1(MouseEvent mouseEvent) {
        changeUsernameLabel.setVisible(false);

    }


    public void hideChangePasswordLabel(MouseEvent mouseEvent) {
        changePasswordLabel.setVisible(false);
    }

    public void hideChangePasswordLabel1(MouseEvent mouseEvent) {
        changePasswordLabel.setVisible(false);
    }




}
