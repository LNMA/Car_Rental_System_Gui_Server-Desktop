package clientfx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import referanceclass.UserReference;
import server.SBE;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ControllerClientMainScreen {

    private Stage sendMassageStage = new Stage();
    private Stage showMassageStage = new Stage();
    static Stage showAllOrderClientStage = new Stage();
    static Stage makeAnOrderStage = new Stage();
    static Stage discountPointStage = new Stage();
    static String OrderUsername = ControllerRegistration.staticUsername;
    private boolean isExist;
    public Label welcomeLabel;
    public TabPane tabPane;
    public Tab myInformationTab;
    public TextField usernameShow;
    public TextField dateShow;
    public TextField firstNameShow;
    public TextField lastNameShow;
    public TextField genderShow;
    public TextField ageShow;
    public TextField telephoneShow;
    public TextField emailShow;
    public TextField addressShow;
    public TextField licenseShow;
    public TextField pointShow;
    public TextField statusShow;
    public TextField editUserFirstNameTxt;
    public Label editUserFirstNameLabel;
    public Tab editFirstNameTab;
    public Tab editUserLastNameTab;
    public TextField editUserLastNameTxt;
    public Label editUserLastNameLabel;
    public Tab editUserGenderTab;
    public ComboBox editUserGenderComboBox;
    public Label editUserGenderLabel;
    public Tab editUserTelephoneTab;
    public TextField editUserTelephoneTxt;
    public Label editUserTelephoneLabel;
    public Tab editUserEmailTab;
    public TextField editUserEmailTxt;
    public Label editUserEmailLabel;
    public Tab editAddressTab;
    public TextField editAddressTxt;
    public Label editAddressLabel;
    public Tab editAgeTab;
    public ComboBox editAgeYearComboBox;
    public ComboBox editAgeMonthComboBox;
    public ComboBox editAgeDayComboBox;
    public Label editAgeLabel;
    public TextField myTotalBillsTxt;


    public void welcomeMakeARent(ActionEvent actionEvent) {
        try {
            Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
            DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            out.writeUTF("0ox0add1order");
            out.writeUTF("1discount2point");
            out.writeUTF(OrderUsername);
            out.flush();
            isExist = in.readBoolean();
            out.close();
            in.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        if (isExist) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("discountPointStage.fxml"));
                discountPointStage.setTitle("My Point");
                discountPointStage.setScene(new Scene(root, 800, 350));
                discountPointStage.show();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        } else {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("makeAnOrderStage.fxml"));
                makeAnOrderStage.setTitle("Make An Order");
                makeAnOrderStage.setScene(new Scene(root, 1000, 700));
                makeAnOrderStage.show();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void showAllCars(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("showAllCar.fxml"));
            ControllerRootMainScreen.showAllCarStage.setTitle("All Car");
            ControllerRootMainScreen.showAllCarStage.setScene(new Scene(root, 800, 600));
            ControllerRootMainScreen.showAllCarStage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public void showAllOrder(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("showAllOrderClient.fxml"));
            showAllOrderClientStage.setTitle("All Order");
            showAllOrderClientStage.setScene(new Scene(root, 800, 600));
            showAllOrderClientStage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public void makeAnOrder(ActionEvent actionEvent) {
        try {
            Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
            DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            out.writeUTF("0ox0add1order");
            out.writeUTF("1discount2point");
            out.writeUTF(OrderUsername);
            out.flush();
            isExist = in.readBoolean();
            out.close();
            in.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


        if (isExist) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("discountPointStage.fxml"));
                discountPointStage.setTitle("My Point");
                discountPointStage.setScene(new Scene(root, 800, 350));
                discountPointStage.show();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        } else {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("makeAnOrderStage.fxml"));
                makeAnOrderStage.setTitle("Make An Order");
                makeAnOrderStage.setScene(new Scene(root, 1000, 700));
                makeAnOrderStage.show();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void initialize() {
        welcomeLabel.setText("Welcome \'" + ControllerRegistration.staticUsername + "\"");
        tabPane.getTabs().remove(myInformationTab);
        tabPane.getTabs().remove(editFirstNameTab);
        tabPane.getTabs().remove(editUserLastNameTab);
        tabPane.getTabs().remove(editUserGenderTab);
        tabPane.getTabs().remove(editUserTelephoneTab);
        tabPane.getTabs().remove(editUserEmailTab);
        tabPane.getTabs().remove(editAddressTab);
        tabPane.getTabs().remove(editAgeTab);
        editUserGenderComboBox.getItems().addAll("Male", "Female");
        editAgeYearComboBox.getItems().addAll(1950, 1951, 1952, 1953, 1954, 1955, 1956, 1957, 1958, 1959, 1960, 1961, 1962, 1963, 1964, 1965, 1966, 1967, 1968, 1969, 1970, 1971, 1972, 1973, 1974, 1975, 1976, 1977, 1978, 1979, 1980, 1981, 1982, 1983, 1984, 1985, 1986, 1987, 1988, 1989, 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020);
        editAgeMonthComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);


    }


    public void logOut(ActionEvent actionEvent) {
        ControllerRegistration.clientStage.close();
        Main.registrationStage.show();
        String username = ControllerRegistration.staticUsername;
        if (!username.equals(null)) {
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("1ux1edit2all");
                out.writeUTF("2edit18AccountOffline");
                out.writeUTF(username);
                out.flush();
                out.close();
                in.close();
                socket.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void closeMenuItem(ActionEvent actionEvent) {
        ControllerRegistration.clientStage.close();
        Main.registrationStage.show();
        String username = ControllerRegistration.staticUsername;
        if (!username.equals(null)) {
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("1ux1edit2all");
                out.writeUTF("2edit18AccountOffline");
                out.writeUTF(username);
                out.flush();
                out.close();
                in.close();
                socket.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void myInformationShow(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(myInformationTab)){
            tabPane.getTabs().add(myInformationTab);
        }
        tabPane.getSelectionModel().select(myInformationTab);
        ArrayList<UserReference> showAll = new ArrayList<>();
        try {
            Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
            DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            out.writeUTF("1ux1edit2all");
            out.writeUTF("2edit19showUserInfo");
            out.writeUTF(ControllerRegistration.staticUsername);
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
            usernameShow.setText(showAll.get(0).getUsername());
            dateShow.setText(showAll.get(0).getDateCreate().toString());
            firstNameShow.setText(showAll.get(0).getFirstName());
            lastNameShow.setText(showAll.get(0).getLastName());
            genderShow.setText(showAll.get(0).getGender());
            ageShow.setText(showAll.get(0).getAge());
            telephoneShow.setText(new Integer(showAll.get(0).getTelephone()).toString());
            emailShow.setText(showAll.get(0).getEmail());
            addressShow.setText(showAll.get(0).getAddress());
            licenseShow.setText(showAll.get(0).getLicenseValidity());
            pointShow.setText(new Integer(showAll.get(0).getDiscountPoint()).toString());
            statusShow.setText(showAll.get(0).getStatus());
            myTotalBillsTxt.setText(new Double(showAll.get(0).getTotalBills()).toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public void editUserFirstName(ActionEvent actionEvent) {
        if (editUserFirstNameTxt.getText().isEmpty()){
            editUserFirstNameLabel.setVisible(true);
            editUserFirstNameLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = ControllerRegistration.staticUsername;
            String firstName = editUserFirstNameTxt.getText();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("1ux1edit2all");
                out.writeUTF("1edit5firstName");
                out.writeUTF(username);
                out.writeUTF(firstName);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editUserFirstNameLabel.setVisible(true);
                editUserFirstNameLabel.setText(isExist + ". " + massage);
                editUserFirstNameTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editUserLastName(ActionEvent actionEvent) {
        if (editUserLastNameTxt.getText().isEmpty()){
            editUserLastNameLabel.setVisible(true);
            editUserLastNameLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = ControllerRegistration.staticUsername;
            String lastName = editUserLastNameTxt.getText();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("1ux1edit2all");
                out.writeUTF("1edit6lastName");
                out.writeUTF(username);
                out.writeUTF(lastName);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editUserLastNameLabel.setVisible(true);
                editUserLastNameLabel.setText(isExist + ". " + massage);
                editUserLastNameTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editUserGender(ActionEvent actionEvent) {
        if (editUserGenderComboBox.getSelectionModel().isEmpty()){
            editUserGenderLabel.setVisible(true);
            editUserGenderLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = ControllerRegistration.staticUsername;
            String gender = (String) editUserGenderComboBox.getSelectionModel().getSelectedItem();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("1ux1edit2all");
                out.writeUTF("1edit7gender");
                out.writeUTF(username);
                out.writeUTF(gender);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editUserGenderLabel.setVisible(true);
                editUserGenderLabel.setText(isExist + ". " + massage);
                editUserGenderComboBox.getSelectionModel().clearSelection();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editUserTelephone(ActionEvent actionEvent) {
        if (editUserTelephoneTxt.getText().isEmpty()){
            editUserTelephoneLabel.setVisible(true);
            editUserTelephoneLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = ControllerRegistration.staticUsername;
            int telephone = 0;
            if (!editUserTelephoneTxt.getText().isEmpty()) {
                telephone = Integer.parseInt(editUserTelephoneTxt.getText());
            }
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("1ux1edit2all");
                out.writeUTF("1edit8telephone");
                out.writeUTF(username);
                out.writeInt(telephone);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editUserTelephoneLabel.setVisible(true);
                editUserTelephoneLabel.setText(isExist + ". " + massage);
                editUserTelephoneTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editUserEmail(ActionEvent actionEvent) {
        if (editUserEmailTxt.getText().isEmpty()){
            editUserEmailLabel.setVisible(true);
            editUserEmailLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = ControllerRegistration.staticUsername;
            String email = editUserEmailTxt.getText();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("1ux1edit2all");
                out.writeUTF("1edit8email");
                out.writeUTF(username);
                out.writeUTF(email);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editUserEmailLabel.setVisible(true);
                editUserEmailLabel.setText(isExist + ". " + massage);
                editUserEmailTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editUserAddress(ActionEvent actionEvent) {
        if (editAddressTxt.getText().isEmpty()){
            editAddressLabel.setVisible(true);
            editAddressLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = ControllerRegistration.staticUsername;
            String email = editAddressTxt.getText();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("1ux1edit2all");
                out.writeUTF("1edit10address");
                out.writeUTF(username);
                out.writeUTF(email);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editAddressLabel.setVisible(true);
                editAddressLabel.setText(isExist + ". " + massage);
                editAddressTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editAgeDayMonth(ActionEvent actionEvent) {
        if (editAgeMonthComboBox.getSelectionModel().isSelected(0) || editAgeMonthComboBox.getSelectionModel().isSelected(2) || editAgeMonthComboBox.getSelectionModel().isSelected(4) || editAgeMonthComboBox.getSelectionModel().isSelected(6) || editAgeMonthComboBox.getSelectionModel().isSelected(7) || editAgeMonthComboBox.getSelectionModel().isSelected(9) || editAgeMonthComboBox.getSelectionModel().isSelected(11)){
            editAgeDayComboBox.getItems().clear();
            editAgeDayComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31);
        }
        if (editAgeMonthComboBox.getSelectionModel().isSelected(3) || editAgeMonthComboBox.getSelectionModel().isSelected(5) || editAgeMonthComboBox.getSelectionModel().isSelected(8) || editAgeMonthComboBox.getSelectionModel().isSelected(10)){
            editAgeDayComboBox.getItems().clear();
            editAgeDayComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30);
        }
        if (editAgeMonthComboBox.getSelectionModel().isSelected(1)){
            Integer year = (Integer)editAgeYearComboBox.getSelectionModel().getSelectedItem();
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (gregorianCalendar.isLeapYear(year)){
                editAgeDayComboBox.getItems().clear();
                editAgeDayComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29);
            }else {
                editAgeDayComboBox.getItems().clear();
                editAgeDayComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28);
            }
        }
    }


    public void editUserAge(ActionEvent actionEvent) {
        if (editAgeYearComboBox.getSelectionModel().isEmpty() || editAgeMonthComboBox.getSelectionModel().isEmpty() || editAgeDayComboBox.getSelectionModel().isEmpty()){
            editAgeLabel.setVisible(true);
            editAgeLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = ControllerRegistration.staticUsername;
            Integer year = (Integer) editAgeYearComboBox.getSelectionModel().getSelectedItem();
            Integer month = (Integer) editAgeMonthComboBox.getSelectionModel().getSelectedItem();
            Integer day = (Integer) editAgeDayComboBox.getSelectionModel().getSelectedItem();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("1ux1edit2all");
                out.writeUTF("1edit11age");
                out.writeUTF(username);
                out.writeInt(year);
                out.writeInt(month);
                out.writeInt(day);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editAgeLabel.setVisible(true);
                editAgeLabel.setText(isExist + ". " + massage);
                editAgeYearComboBox.getSelectionModel().clearSelection();
                editAgeMonthComboBox.getSelectionModel().clearSelection();
                editAgeDayComboBox.getSelectionModel().clearSelection();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editFirstName(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editFirstNameTab)){
            tabPane.getTabs().add(editFirstNameTab);
        }
        tabPane.getSelectionModel().select(editFirstNameTab);
        editUserFirstNameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (editUserFirstNameTxt.getText().length()>50){
                    editUserFirstNameTxt.setText(editUserFirstNameTxt.getText(0,50));
                }
            }
        });
    }


    public void editLastName(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editUserLastNameTab)){
            tabPane.getTabs().add(editUserLastNameTab);
        }
        tabPane.getSelectionModel().select(editUserLastNameTab);
        editUserLastNameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (editUserLastNameTxt.getText().length()>50){
                    editUserLastNameTxt.setText(editUserLastNameTxt.getText(0,50));
                }
            }
        });
    }


    public void editGender(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editUserGenderTab)){
            tabPane.getTabs().add(editUserGenderTab);
        }
        tabPane.getSelectionModel().select(editUserGenderTab);
    }


    public void editAge(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editAgeTab)){
            tabPane.getTabs().add(editAgeTab);
        }
        tabPane.getSelectionModel().select(editAgeTab);
    }


    public void editTelephone(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editUserTelephoneTab)){
            tabPane.getTabs().add(editUserTelephoneTab);
        }
        tabPane.getSelectionModel().select(editUserTelephoneTab);
        editUserTelephoneTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!editUserTelephoneTxt.getText().matches("[\\d*]")){
                    editUserTelephoneTxt.setText(newValue.replaceAll("[^\\d]",""));
                }
                if (editUserTelephoneTxt.getText().length()>15){
                    editUserTelephoneTxt.setText(editUserTelephoneTxt.getText(0,15));
                }
            }
        });
    }


    public void editEmail(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editUserEmailTab)){
            tabPane.getTabs().add(editUserEmailTab);
        }
        tabPane.getSelectionModel().select(editUserEmailTab);
        editUserEmailTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (editUserEmailTxt.getText().length()>62){
                    editUserEmailTxt.setText(editUserEmailTxt.getText(0,62));
                }
            }
        });
    }


    public void editAddress(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editAddressTab)){
            tabPane.getTabs().add(editAddressTab);
        }
        tabPane.getSelectionModel().select(editAddressTab);
        editAddressTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (editAddressTxt.getText().length()>120){
                    editAddressTxt.setText(editAddressTxt.getText(0,120));
                }
            }
        });
    }

    public void showMassage(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("viewMassage.fxml"));
            showMassageStage.setTitle("Show Massage");
            showMassageStage.setScene(new Scene(root, 800, 600));
            showMassageStage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void sendMassage(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sendMassage.fxml"));
            sendMassageStage.setTitle("Send Massage");
            sendMassageStage.setScene(new Scene(root, 800, 600));
            sendMassageStage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
