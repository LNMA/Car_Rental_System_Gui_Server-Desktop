package clientfx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import referanceclass.UserReference;
import server.SBE;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ControllerSupervisorMainScreen {

    private boolean isExist;
    private Stage sendMassageStage = new Stage();
    private Stage showAdministrativeMassageStage = new Stage();
    private Stage showMassageStage = new Stage();
    private Stage addCarStage = new Stage();
    private Stage showAllCarStage = new Stage();
    private Stage AddAccountStageSupervisor = new Stage();
    private Stage showAllClientStage = new Stage();
    private Stage showOrderByCarIDStage = new Stage();
    private Stage showAllOrderStage = new Stage();
    public TextField removeCarId;
    public Label removeLabel;
    public TabPane tabPane;
    public Tab removeCarTab;
    public TextField editCarIDTxt;
    public Label editCarIDLabel;
    public Tab editCarIDTab;
    public TextField newCarIdTxt;
    public ComboBox editCarTypeComboBox;
    public Tab editCarTypeTab;
    public Label editCarTypeLabel;
    public TextField editCarTypeTxt;
    public Tab editCarMakerTab;
    public TextField editCarMakerCarIdTxt;
    public TextField editCarMakerMakerTxt;
    public Label editCarMakerLabel;
    public Tab editModelNameTab;
    public TextField editModelNameCarIdTxt;
    public TextField editModelNameTxt;
    public Label editModelNameLabel;
    public Tab editModelYearTab;
    public TextField editModelYearCarIdTxt;
    public ComboBox editModelYearComboBox;
    public Label editModelYearLabel;
    public TextField editNumberOfSeatsCarIdTxt;
    public ComboBox editNumberOfSeatsComboBox;
    public Label editNumberOfSeatsLabel;
    public Tab editNumberOfSeatsTab;
    public Tab editRegistrationNumberTab;
    public TextField editRegistrationNumberCarIDTxt;
    public TextField editRegistrationNumberTxt;
    public Label editRegistrationNumberLabel;
    public Tab editCarIdentificationNumberTab;
    public TextField editCarIdentificationNumberCarIdTxt;
    public TextField editCarIdentificationNumberTxt;
    public Label editCarIdentificationNumberLabel;
    public Tab editLastMeterReadingTab;
    public TextField editLastMeterReadingCarIdTxt;
    public TextField editLastMeterReadingTxt;
    public Label editLastMeterReadingLabel;
    public Tab editCostPerDayTab;
    public TextField editCostPerDayCarTxt;
    public TextField editCostPerDayTxt;
    public Label editCostPerDayLabel;
    public Tab editCostPerKmTab;
    public TextField editCostPerKmCarIDTxt;
    public TextField editCostPerKmTxt;
    public Label editCostPerKmLabel;
    public Tab editInsurancePerDayTab;
    public TextField editInsurancePerDayCarIdTxt;
    public TextField editInsurancePerDayTxt;
    public Label editInsurancePerDayLabel;
    public Tab editCarStatusTab;
    public TextField editCarStatusCarIDTxt;
    public ComboBox editCarStatusComboBox;
    public Label editCarStatusLabel;
    public Tab editCustomerDiscountPointTab;
    public Tab editCustomerLicenseValidityTab;
    public Tab editAgeTab;
    public Tab editAddressTab;
    public Tab editUserAvailabilityTab;
    public Tab editUserEmailTab;
    public Tab editUserTelephoneTab;
    public Tab editUserGenderTab;
    public Tab editUserLastNameTab;
    public Tab editUserFirstNameTab;
    public Tab changePasswordTab;
    public Tab changeUsernameTab;
    public Tab removeAccountTab;
    public TextField usernameRemoveAccountTxt;
    public Label usernameRemoveAccountLabel;
    public TextField changeUsernameOldUsernameTxt;
    public TextField changeUsernameNewUsernameTxt;
    public Label changeUsernameLabel;
    public TextField changePasswordUsernameTxt;
    public PasswordField ChangePasswordTxt;
    public Label changePasswordLabel;
    public TextField editUserFirstNameUsernameTxt;
    public TextField editUserFirstNameTxt;
    public Label editUserFirstNameLabel;
    public TextField editUserLastNameUsernameTxt;
    public TextField editUserLastNameTxt;
    public Label editUserLastNameLabel;
    public TextField editUserGenderUsernameTxt;
    public ComboBox editUserGenderComboBox;
    public Label editUserGenderLabel;
    public TextField editUserTelephoneUsernameTxt;
    public TextField editUserTelephoneTxt;
    public Label editUserTelephoneLabel;
    public TextField editUserEmailUsernameTxt;
    public TextField editUserEmailTxt;
    public Label editUserEmailLabel;
    public TextField editUserAvailabilityUsernameTxt;
    public ComboBox editUserAvailabilityComboBox;
    public Label editUserAvailabilityLabel;
    public TextField editAddressUsernameTxt;
    public TextField editAddressTxt;
    public Label editAddressLabel;
    public TextField editAgeUsernameTxt;
    public ComboBox editAgeYearComboBox;
    public ComboBox editAgeMonthComboBox;
    public ComboBox editAgeDayComboBox;
    public Label editAgeLabel;
    public ComboBox editCustomerLicenseValidityComboBox;
    public Label editCustomerLicenseValidityLabel;
    public TextField editCustomerLicenseValidityUsernameTxt;
    public TextField editCustomerDiscountPointUsernameTxt;
    public TextField editCustomerDiscountPointTxt;
    public Label editCustomerDiscountPointLabel;
    public BorderPane borderPane;
    public Label welcomeLabel;
    public TextField editCustomerTotalBillsUsernameTxt;
    public TextField editCustomerTotalBillsTxt;
    public Label editCustomerTotalBillsLabel;
    public Tab editCustomerTotalBillsTab;
    public Tab showOrderByUsernameTab;
    public TextField showOrderByUsernameTxt;
    public Label showOrderByUsernameLabel;
    public Tab showOrderByCarIDTab;
    public TextField showOrderByCarIDTxt;
    public Label showOrderByCarIDLabel;
    public Tab addOrderTab;
    public TextField addOrderTxt;
    public Label addOrderLabel;
    public Tab removeOrderTab;
    public TextField removeOrderTxt;
    public Label removeOrderLabel;
    public TextField editOrderIDOldTxt;
    public TextField editOrderIDNewTxt;
    public Label editOrderIDLabel;
    public Tab editOrderIDTab;
    public Tab editOrderDayTab;
    public TextField editOrderDayOrderIDTxt;
    public TextField editOrderDayTxt;
    public Label editOrderDayLabel;
    public Tab editOrderDistanceTab;
    public TextField editOrderDistanceOrderIdTxt;
    public TextField editOrderDistanceTxt;
    public Label editOrderDistanceLabel;
    public Tab editOrderPaymentMethodTab;
    public TextField editOrderPaymentMethodOrderIDTxt;
    public ComboBox editOrderPaymentMethodComboBox;
    public Label editOrderPaymentMethodLabel;
    public Tab editOrderBillTab;
    public TextField editOrderBillOrderIdTxt;
    public TextField editOrderBillTxt;
    public Label editOrderBillLabel;
    public Tab myInformationTab;
    public TextField usernameTxtShow;
    public TextField dateTxtShow;
    public TextField firstNameTxtShow;
    public TextField lastNameTxtShow;
    public TextField genderTxtShow;
    public TextField ageTxtShow;
    public TextField telephoneTxtShow;
    public TextField emailTxtShow;
    public TextField addressTxtShow;
    public TextField sectionTxtShow;
    public TextField rankTxtShow;
    public TextField statusTxtShow;
    public Tab editProfileFirstNameTab;
    public TextField editProfileUserFirstNameTxt;
    public Label editProfileUserFirstNameLabel;
    public Tab editProfileUserLastNameTab;
    public TextField editProfileUserLastNameTxt;
    public Label editProfileUserLastNameLabel;
    public Tab editProfileUserGenderTab;
    public ComboBox editUserProfileGenderComboBox;
    public Label editProfileUserGenderLabel;
    public Tab editProfileUserTelephoneTab;
    public TextField editProfileUserTelephoneTxt;
    public Label editProfileUserTelephoneLabel;
    public Tab editProfileUserEmailTab;
    public TextField editProfileUserEmailTxt;
    public Label editProfileUserEmailLabel;
    public Tab editProfileAddressTab;
    public TextField editProfileAddressTxt;
    public Label editProfileAddressLabel;
    public Tab editProfileAgeTab;
    public ComboBox editProfileAgeYearComboBox;
    public ComboBox editProfileAgeMonthComboBox;
    public ComboBox editProfileAgeDayComboBox;
    public Label editProfileAgeLabel;


    public void editOrderBillEvent(ActionEvent actionEvent) {
        if (editOrderBillOrderIdTxt.getText().isEmpty() || editOrderBillTxt.getText().isEmpty()){
            editOrderBillLabel.setVisible(true);
            editOrderBillLabel.setText("All field must fill");
        }else {
            int orderID = Integer.parseInt(editOrderBillOrderIdTxt.getText());
            double bill = Double.parseDouble(editOrderBillTxt.getText());
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("2ox2edit3all");
                out.writeUTF("2edit6bill");
                out.writeInt(orderID);
                out.writeDouble(bill);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editOrderBillLabel.setVisible(true);
                editOrderBillLabel.setText(isExist+". "+massage);
                editOrderBillOrderIdTxt.clear();
                editOrderBillTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editOrderPaymentMethodEvent(ActionEvent actionEvent) {
        if (editOrderPaymentMethodOrderIDTxt.getText().isEmpty() || editOrderPaymentMethodComboBox.getSelectionModel().isEmpty()){
            editOrderPaymentMethodLabel.setVisible(true);
            editOrderPaymentMethodLabel.setText("All field must fill");
        }else {
            int orderID = Integer.parseInt(editOrderPaymentMethodOrderIDTxt.getText());
            String paymentMethod = (String)editOrderPaymentMethodComboBox.getSelectionModel().getSelectedItem();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("2ox2edit3all");
                out.writeUTF("2edit5payment");
                out.writeInt(orderID);
                out.writeUTF(paymentMethod);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editOrderPaymentMethodLabel.setVisible(true);
                editOrderPaymentMethodLabel.setText(isExist+". "+massage);
                editOrderPaymentMethodOrderIDTxt.clear();
                editOrderPaymentMethodComboBox.getSelectionModel().clearSelection();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editOrderDistanceEvent(ActionEvent actionEvent) {
        if (editOrderDistanceOrderIdTxt.getText().isEmpty() || editOrderDistanceTxt.getText().isEmpty()){
            editOrderDistanceLabel.setVisible(true);
            editOrderDistanceLabel.setText("All field must fill");
        }else {
            int orderID = Integer.parseInt(editOrderDistanceOrderIdTxt.getText());
            double distance = Double.parseDouble(editOrderDistanceTxt.getText());
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("2ox2edit3all");
                out.writeUTF("2edit4distance");
                out.writeInt(orderID);
                out.writeDouble(distance);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editOrderDistanceLabel.setVisible(true);
                editOrderDistanceLabel.setText(isExist+". "+massage);
                editOrderDistanceTxt.clear();
                editOrderDistanceOrderIdTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editOrderDayEvent(ActionEvent actionEvent) {
        if (editOrderDayOrderIDTxt.getText().isEmpty() || editOrderDayTxt.getText().isEmpty()){
            editOrderDayLabel.setVisible(true);
            editOrderDayLabel.setText("All field must fill");
        }else {
            int orderID = Integer.parseInt(editOrderDayOrderIDTxt.getText());
            int day = Integer.parseInt(editOrderDayTxt.getText());
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("2ox2edit3all");
                out.writeUTF("2edit3day");
                out.writeInt(orderID);
                out.writeInt(day);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editOrderDayLabel.setVisible(true);
                editOrderDayLabel.setText(isExist+". "+massage);
                editOrderDayTxt.clear();
                editOrderDayOrderIDTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editOrderIDEvent(ActionEvent actionEvent) {
        if (editOrderIDOldTxt.getText().isEmpty() || editOrderIDNewTxt.getText().isEmpty()){
            editOrderIDLabel.setVisible(true);
            editOrderIDLabel.setText("All field must fill");
        }else {
            int orderIDOld = Integer.parseInt(editOrderIDOldTxt.getText());
            int orderIDNew = Integer.parseInt(editOrderIDNewTxt.getText());
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("2ox2edit3all");
                out.writeUTF("2edit7id");
                out.writeInt(orderIDOld);
                out.writeInt(orderIDNew);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editOrderIDLabel.setVisible(true);
                editOrderIDLabel.setText(isExist+". "+massage);
                editOrderIDNewTxt.clear();
                editOrderIDOldTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void removeOrderEvent(ActionEvent actionEvent) {
        if (removeOrderTxt.getText().isEmpty()){
            removeOrderLabel.setVisible(true);
            removeOrderLabel.setText("All field must fill");
        }else {
            int orderID = Integer.parseInt(removeOrderTxt.getText());
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("2ox2edit3all");
                out.writeUTF("1edit2remove");
                out.writeInt(orderID);
                out.flush();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                removeOrderLabel.setVisible(true);
                removeOrderLabel.setText(massage);
                removeOrderTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void addOrderEvent(ActionEvent actionEvent) {
        if (addOrderTxt.getText().isEmpty()){
            addOrderLabel.setText("username must fill");
        }else {
            ControllerClientMainScreen.OrderUsername = addOrderTxt.getText();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("0ox0add1order");
                out.writeUTF("1discount2point");
                out.writeUTF(ControllerClientMainScreen.OrderUsername);
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
                    ControllerClientMainScreen.discountPointStage.setTitle("My Point");
                    ControllerClientMainScreen.discountPointStage.setScene(new Scene(root, 800, 350));
                    ControllerClientMainScreen.discountPointStage.show();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            } else {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("makeAnOrderStage.fxml"));
                    ControllerClientMainScreen.makeAnOrderStage.setTitle("Make An Order");
                    ControllerClientMainScreen.makeAnOrderStage.setScene(new Scene(root, 1000, 700));
                    ControllerClientMainScreen.makeAnOrderStage.show();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }


    public void showAllOrder(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("showAllOrder.fxml"));
            showAllOrderStage.setTitle("All Order");
            showAllOrderStage.setScene(new Scene(root, 800, 600));
            showAllOrderStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public void showOrderByCarIDEvent(ActionEvent actionEvent) {
        ControllerShowOrderByCarID.carID = showOrderByCarIDTxt.getText();
        if (showOrderByCarIDTxt.getText().isEmpty()){
            showOrderByCarIDLabel.setText("Car ID must fill");
        }else {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("showOrderByCarID.fxml"));
                showOrderByCarIDStage.setTitle("Order By Car ID");
                showOrderByCarIDStage.setScene(new Scene(root, 800, 600));
                showOrderByCarIDStage.show();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void showOrderByUsernameEvent(ActionEvent actionEvent) {
        ControllerShowAllOrderClient.myUsername = showOrderByUsernameTxt.getText();
        if (showOrderByUsernameTxt.getText().isEmpty()){
            showOrderByUsernameLabel.setText("Username must fill");
        }else {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("showAllOrderClient.fxml"));
                ControllerClientMainScreen.showAllOrderClientStage.setTitle("Order By Car ID");
                ControllerClientMainScreen.showAllOrderClientStage.setScene(new Scene(root, 800, 600));
                ControllerClientMainScreen.showAllOrderClientStage.show();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void showAllAccount(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("showAllClient.fxml"));
            showAllClientStage.setTitle("All Account");
            showAllClientStage.setScene(new Scene(root, 800, 600));
            showAllClientStage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public void editCustomerTotalBills(ActionEvent actionEvent) {
        if (editCustomerTotalBillsUsernameTxt.getText().isEmpty() || editCustomerTotalBillsTxt.getText().isEmpty()){
            editCustomerTotalBillsLabel.setVisible(true);
            editCustomerTotalBillsLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = editCustomerTotalBillsUsernameTxt.getText();
            double totalBills = 0;
            if (!editCustomerTotalBillsTxt.getText().isEmpty()) {
                totalBills = Integer.parseInt(editCustomerTotalBillsTxt.getText());
            }
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("2ux1supervisor2edit3all");
                out.writeUTF("2edit20totalBills");
                out.writeUTF(username);
                out.writeDouble(totalBills);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editCustomerTotalBillsLabel.setVisible(true);
                editCustomerTotalBillsLabel.setText(isExist + ". " + massage);
                editCustomerTotalBillsUsernameTxt.clear();
                editCustomerTotalBillsTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editCustomerDiscountPoint(ActionEvent actionEvent) {
        if (editCustomerDiscountPointUsernameTxt.getText().isEmpty() || editCustomerDiscountPointTxt.getText().isEmpty()){
            editCustomerDiscountPointLabel.setVisible(true);
            editCustomerDiscountPointLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = editCustomerDiscountPointUsernameTxt.getText();
            Integer point = 0;
            if (!editCustomerDiscountPointTxt.getText().isEmpty()) {
                point = Integer.parseInt(editCustomerDiscountPointTxt.getText());
            }
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("2ux1supervisor2edit3all");
                out.writeUTF("1edit13point");
                out.writeUTF(username);
                out.writeInt(point);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editCustomerDiscountPointLabel.setVisible(true);
                editCustomerDiscountPointLabel.setText(isExist + ". " + massage);
                editCustomerDiscountPointTxt.clear();
                editCustomerDiscountPointUsernameTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editCustomerLicenseValidity(ActionEvent actionEvent) {
        if (editCustomerLicenseValidityUsernameTxt.getText().isEmpty() || editCustomerLicenseValidityComboBox.getSelectionModel().isEmpty()){
            editCustomerLicenseValidityLabel.setVisible(true);
            editCustomerLicenseValidityLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = editCustomerLicenseValidityUsernameTxt.getText();
            String validity = (String) editCustomerLicenseValidityComboBox.getSelectionModel().getSelectedItem();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("2ux1supervisor2edit3all");
                out.writeUTF("1edit12validity");
                out.writeUTF(username);
                out.writeUTF(validity);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editCustomerLicenseValidityLabel.setVisible(true);
                editCustomerLicenseValidityLabel.setText(isExist + ". " + massage);
                editCustomerLicenseValidityUsernameTxt.clear();
                editCustomerLicenseValidityComboBox.getSelectionModel().clearSelection();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editAge(ActionEvent actionEvent) {
        if (editAgeUsernameTxt.getText().isEmpty() || editAgeYearComboBox.getSelectionModel().isEmpty() || editAgeMonthComboBox.getSelectionModel().isEmpty() || editAgeDayComboBox.getSelectionModel().isEmpty()){
            editAgeLabel.setVisible(true);
            editAgeLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = editAgeUsernameTxt.getText();
            Integer year = (Integer) editAgeYearComboBox.getSelectionModel().getSelectedItem();
            Integer month = (Integer) editAgeMonthComboBox.getSelectionModel().getSelectedItem();
            Integer day = (Integer) editAgeDayComboBox.getSelectionModel().getSelectedItem();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("2ux1supervisor2edit3all");
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
                editAgeUsernameTxt.clear();
                editAgeYearComboBox.getSelectionModel().clearSelection();
                editAgeMonthComboBox.getSelectionModel().clearSelection();
                editAgeDayComboBox.getSelectionModel().clearSelection();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editAddress(ActionEvent actionEvent) {
        if (editAddressUsernameTxt.getText().isEmpty() || editAddressTxt.getText().isEmpty()){
            editAddressLabel.setVisible(true);
            editAddressLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = editAddressUsernameTxt.getText();
            String email = editAddressTxt.getText();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("2ux1supervisor2edit3all");
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
                editAddressUsernameTxt.clear();
                editAddressTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editUserAvailability(ActionEvent actionEvent) {
        if (editUserAvailabilityUsernameTxt.getText().isEmpty() || editUserAvailabilityComboBox.getSelectionModel().isEmpty()){
            editUserAvailabilityLabel.setVisible(true);
            editUserAvailabilityLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = editUserAvailabilityUsernameTxt.getText();
            String availability = (String) editUserAvailabilityComboBox.getSelectionModel().getSelectedItem();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("2ux1supervisor2edit3all");
                out.writeUTF("1edit9availability");
                out.writeUTF(username);
                out.writeUTF(availability);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editUserAvailabilityLabel.setVisible(true);
                editUserAvailabilityLabel.setText(isExist + ". " + massage);
                editUserAvailabilityUsernameTxt.clear();
                editUserAvailabilityComboBox.getSelectionModel().clearSelection();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editUserEmail(ActionEvent actionEvent) {
        if (editUserEmailUsernameTxt.getText().isEmpty() || editUserEmailTxt.getText().isEmpty()){
            editUserEmailLabel.setVisible(true);
            editUserEmailLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = editUserEmailUsernameTxt.getText();
            String email = editUserEmailTxt.getText();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("2ux1supervisor2edit3all");
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
                editUserEmailUsernameTxt.clear();
                editUserEmailTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editUserTelephone(ActionEvent actionEvent) {
        if (editUserTelephoneUsernameTxt.getText().isEmpty() || editUserTelephoneTxt.getText().isEmpty()){
            editUserTelephoneLabel.setVisible(true);
            editUserTelephoneLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = editUserTelephoneUsernameTxt.getText();
            int telephone = 0;
            if (!editUserTelephoneTxt.getText().isEmpty()) {
                telephone = Integer.parseInt(editUserTelephoneTxt.getText());
            }
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("2ux1supervisor2edit3all");
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
                editUserTelephoneUsernameTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editUserGender(ActionEvent actionEvent) {
        if (editUserGenderUsernameTxt.getText().isEmpty() || editUserGenderComboBox.getSelectionModel().isEmpty()){
            editUserGenderLabel.setVisible(true);
            editUserGenderLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = editUserGenderUsernameTxt.getText();
            String gender = (String) editUserGenderComboBox.getSelectionModel().getSelectedItem();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("2ux1supervisor2edit3all");
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
                editUserGenderUsernameTxt.clear();
                editUserGenderComboBox.getSelectionModel().clearSelection();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editUserLastName(ActionEvent actionEvent) {
        if (editUserLastNameUsernameTxt.getText().isEmpty() || editUserLastNameTxt.getText().isEmpty()){
            editUserLastNameLabel.setVisible(true);
            editUserLastNameLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = editUserLastNameUsernameTxt.getText();
            String lastName = editUserLastNameTxt.getText();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("2ux1supervisor2edit3all");
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
                editUserLastNameUsernameTxt.clear();
                editUserLastNameTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editUserFirstName(ActionEvent actionEvent) {
        if (editUserFirstNameUsernameTxt.getText().isEmpty() || editUserFirstNameTxt.getText().isEmpty()){
            editUserFirstNameLabel.setVisible(true);
            editUserFirstNameLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = editUserFirstNameUsernameTxt.getText();
            String firstName = editUserFirstNameTxt.getText();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("2ux1supervisor2edit3all");
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
                editUserFirstNameUsernameTxt.clear();
                editUserFirstNameTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void ChangePassword(ActionEvent actionEvent) {
        if (changePasswordUsernameTxt.getText().isEmpty() || ChangePasswordTxt.getText().isEmpty()){
            changePasswordLabel.setVisible(true);
            changePasswordLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = changePasswordUsernameTxt.getText();
            String password = ChangePasswordTxt.getText();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("2ux1supervisor2edit3all");
                out.writeUTF("1edit4password");
                out.writeUTF(username);
                out.writeUTF(password);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                changePasswordLabel.setVisible(true);
                changePasswordLabel.setText(isExist+". "+massage);
                changePasswordUsernameTxt.clear();
                ChangePasswordTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void ChangeUsername(ActionEvent actionEvent) {
        if (changeUsernameOldUsernameTxt.getText().isEmpty() || changeUsernameNewUsernameTxt.getText().isEmpty()){
            changeUsernameLabel.setVisible(true);
            changeUsernameLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = changeUsernameOldUsernameTxt.getText();
            String newUsername = changeUsernameNewUsernameTxt.getText();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("2ux1supervisor2edit3all");
                out.writeUTF("1edit3username");
                out.writeUTF(username);
                out.writeUTF(newUsername);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                changeUsernameLabel.setVisible(true);
                changeUsernameLabel.setText(isExist+". "+massage);
                changeUsernameOldUsernameTxt.clear();
                changeUsernameNewUsernameTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void removeAccount(ActionEvent actionEvent) {
        if (usernameRemoveAccountTxt.getText().isEmpty()){
            usernameRemoveAccountLabel.setVisible(true);
            usernameRemoveAccountLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = usernameRemoveAccountTxt.getText();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("2ux1supervisor2edit3all");
                out.writeUTF("1edit2delete");
                out.writeUTF(username);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                usernameRemoveAccountLabel.setVisible(true);
                usernameRemoveAccountLabel.setText(isExist+". "+massage);
                usernameRemoveAccountTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void showAddAccount(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("addAccountSupervisor.fxml"));
            AddAccountStageSupervisor.setTitle("Add Account");
            AddAccountStageSupervisor.setScene(new Scene(root, 800, 600));
            AddAccountStageSupervisor.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public void showMeAllCars(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("showAllCar.fxml"));
            showAllCarStage.setTitle("All Car");
            showAllCarStage.setScene(new Scene(root, 800, 600));
            showAllCarStage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public void editCarStatus(ActionEvent actionEvent) {
        if (editCarStatusCarIDTxt.getText().isEmpty() || editCarStatusComboBox.getSelectionModel().isEmpty()){
            editCarStatusLabel.setVisible(true);
            editCarStatusLabel.setText("ALL FIELD MUST FILL");
        }else {
            String carID = editCarStatusCarIDTxt.getText();
            String status = (String) editCarStatusComboBox.getSelectionModel().getSelectedItem();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("1cx1edit2all");
                out.writeUTF("1edit16status");
                out.writeUTF(carID);
                out.writeUTF(status);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editCarStatusLabel.setVisible(true);
                editCarStatusLabel.setText(isExist + ", " + massage);
                editCarStatusCarIDTxt.clear();
                editCarStatusComboBox.getSelectionModel().clearSelection();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editInsurancePerDay(ActionEvent actionEvent) {
        if (editInsurancePerDayCarIdTxt.getText().isEmpty() || editInsurancePerDayTxt.getText().isEmpty()){
            editInsurancePerDayLabel.setVisible(true);
            editInsurancePerDayLabel.setText("ALL FIELD MUST FILL");
        }else {
            String carID = editInsurancePerDayCarIdTxt.getText();
            double insurance = 0;
            if (!editInsurancePerDayTxt.getText().isEmpty()) {
                insurance = Double.parseDouble(editInsurancePerDayTxt.getText());
            }
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("1cx1edit2all");
                out.writeUTF("1edit15insurance");
                out.writeUTF(carID);
                out.writeDouble(insurance);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editInsurancePerDayLabel.setVisible(true);
                editInsurancePerDayLabel.setText(isExist + ". " + massage);
                editInsurancePerDayCarIdTxt.clear();
                editInsurancePerDayTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editCostPerKm(ActionEvent actionEvent) {
        if (editCostPerKmCarIDTxt.getText().isEmpty() || editCostPerKmTxt.getText().isEmpty()){
            editCostPerKmLabel.setVisible(true);
            editCostPerKmLabel.setText("ALL FIELD MUST FILL");
        }else {
            String carID = editCostPerKmCarIDTxt.getText();
            double perKm = 0;
            if (!editCostPerKmTxt.getText().isEmpty()) {
                perKm = Double.parseDouble(editCostPerKmTxt.getText());
            }
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("1cx1edit2all");
                out.writeUTF("1edit14costPerKm");
                out.writeUTF(carID);
                out.writeDouble(perKm);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editCostPerKmLabel.setVisible(true);
                editCostPerKmLabel.setText(isExist + ". " + massage);
                editCostPerKmCarIDTxt.clear();
                editCostPerKmTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editCostPerDay(ActionEvent actionEvent) {
        if (editCostPerDayCarTxt.getText().isEmpty() || editCostPerDayTxt.getText().isEmpty()){
            editCostPerDayLabel.setVisible(true);
            editCostPerDayLabel.setText("ALL FIELD MUST FILL");
        }else {
            String carID = editCostPerDayCarTxt.getText();
            double perDay = 0;
            if (!editCostPerDayTxt.getText().isEmpty()) {
                perDay = Double.parseDouble(editCostPerDayTxt.getText());
            }
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("1cx1edit2all");
                out.writeUTF("1edit13costPerDay");
                out.writeUTF(carID);
                out.writeDouble(perDay);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editCostPerDayLabel.setVisible(true);
                editCostPerDayLabel.setText(isExist + ". " + massage);
                editCostPerDayTxt.clear();
                editCostPerDayCarTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editLastMeterReading(ActionEvent actionEvent) {
        if (editLastMeterReadingCarIdTxt.getText().isEmpty() || editLastMeterReadingTxt.getText().isEmpty()){
            editLastMeterReadingLabel.setVisible(true);
            editLastMeterReadingLabel.setText("ALL FIELD MUST FILL");
        }else {
            String carID = editLastMeterReadingCarIdTxt.getText();
            double lastMeter = 0;
            if (!editLastMeterReadingTxt.getText().isEmpty()) {
                lastMeter = Double.parseDouble(editLastMeterReadingTxt.getText());
            }
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("1cx1edit2all");
                out.writeUTF("1edit12carMeter");
                out.writeUTF(carID);
                out.writeDouble(lastMeter);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editLastMeterReadingLabel.setVisible(true);
                editLastMeterReadingLabel.setText(isExist + ". " + massage);
                editLastMeterReadingCarIdTxt.clear();
                editLastMeterReadingTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editCarIdentificationNumber(ActionEvent actionEvent) {
        if (editCarIdentificationNumberCarIdTxt.getText().isEmpty() || editCarIdentificationNumberTxt.getText().isEmpty()){
            editCarIdentificationNumberLabel.setVisible(true);
            editCarIdentificationNumberLabel.setText("ALL FIELD MUST FILL");
        }else {
            String carID = editCarIdentificationNumberCarIdTxt.getText();
            String identification = editCarIdentificationNumberTxt.getText();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("1cx1edit2all");
                out.writeUTF("1edit11carIdent");
                out.writeUTF(carID);
                out.writeUTF(identification);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editCarIdentificationNumberLabel.setVisible(true);
                editCarIdentificationNumberLabel.setText(isExist + ". " + massage);
                editCarIdentificationNumberCarIdTxt.clear();
                editCarIdentificationNumberTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editRegistrationNumber(ActionEvent actionEvent) {
        if (editRegistrationNumberCarIDTxt.getText().isEmpty() || editRegistrationNumberTxt.getText().isEmpty()){
            editRegistrationNumberLabel.setVisible(true);
            editRegistrationNumberLabel.setText("ALL FIELD MUST FILL");
        }else {
            String carID = editRegistrationNumberCarIDTxt.getText();
            String registration = editRegistrationNumberTxt.getText();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("1cx1edit2all");
                out.writeUTF("1edit10carRegis");
                out.writeUTF(carID);
                out.writeUTF(registration);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editRegistrationNumberLabel.setVisible(true);
                editRegistrationNumberLabel.setText(isExist+". "+massage);
                editRegistrationNumberCarIDTxt.clear();
                editRegistrationNumberTxt.clear();
            }catch (Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editNumberOfSeats(ActionEvent actionEvent) {
        if (editNumberOfSeatsCarIdTxt.getText().isEmpty() || editNumberOfSeatsComboBox.getSelectionModel().isEmpty()){
            editNumberOfSeatsLabel.setVisible(true);
            editNumberOfSeatsLabel.setText("ALL FIELD MUST FILL");
        }else {
            String carID = editNumberOfSeatsCarIdTxt.getText();
            Integer seats = (Integer) editNumberOfSeatsComboBox.getSelectionModel().getSelectedItem();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("1cx1edit2all");
                out.writeUTF("1edit9carSeats");
                out.writeUTF(carID);
                out.writeInt(seats);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editNumberOfSeatsLabel.setVisible(true);
                editNumberOfSeatsLabel.setText(isExist + ". " + massage);
                editNumberOfSeatsCarIdTxt.clear();
                editNumberOfSeatsComboBox.getSelectionModel().clearSelection();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editModelYear(ActionEvent actionEvent) {
        if (editModelYearCarIdTxt.getText().isEmpty() || editModelYearComboBox.getSelectionModel().isEmpty()){
            editModelYearLabel.setVisible(true);
            editModelYearLabel.setText("ALL FIELD MUST FILL");
        }else {
            String carID = editModelYearCarIdTxt.getText();
            Integer year = (Integer) editModelYearComboBox.getSelectionModel().getSelectedItem();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("1cx1edit2all");
                out.writeUTF("1edit8carYear");
                out.writeUTF(carID);
                out.writeInt(year);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editModelYearLabel.setVisible(true);
                editModelYearLabel.setText(isExist + ". " + massage);
                editModelYearCarIdTxt.clear();
                editModelYearComboBox.getSelectionModel().clearSelection();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editModelName(ActionEvent actionEvent) {
        if (editModelNameCarIdTxt.getText().isEmpty() || editModelNameTxt.getText().isEmpty()){
            editModelNameLabel.setVisible(true);
            editModelNameLabel.setText("ALL FIELD MUST FILL");
        }else {
            String carID = editModelNameCarIdTxt.getText();
            String model = editModelNameTxt.getText();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("1cx1edit2all");
                out.writeUTF("1edit7carModel");
                out.writeUTF(carID);
                out.writeUTF(model);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editModelNameLabel.setVisible(true);
                editModelNameLabel.setText(isExist + ". " + massage);
                editModelNameCarIdTxt.clear();
                editModelNameTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editCarMaker(ActionEvent actionEvent) {
        if (editCarMakerCarIdTxt.getText().isEmpty() || editCarMakerMakerTxt.getText().isEmpty()){
            editCarMakerLabel.setVisible(true);
            editCarMakerLabel.setText("ALL FIELD MUST FILL");
        }else {
            String carID = editCarMakerCarIdTxt.getText();
            String maker = editCarMakerMakerTxt.getText();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("1cx1edit2all");
                out.writeUTF("1edit6carMaker");
                out.writeUTF(carID);
                out.writeUTF(maker);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editCarMakerLabel.setVisible(true);
                editCarMakerLabel.setText(isExist + ". " + massage);
                editCarMakerCarIdTxt.clear();
                editCarMakerMakerTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editCarType(ActionEvent actionEvent) {
        if (editCarTypeTxt.getText().isEmpty() || editCarTypeComboBox.getSelectionModel().isEmpty()){
            editCarTypeLabel.setVisible(true);
            editCarTypeLabel.setText("ALL FIELD MUST FILL");
        }else {
            String carID = editCarTypeTxt.getText();
            String type = (String) editCarTypeComboBox.getSelectionModel().getSelectedItem();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("1cx1edit2all");
                out.writeUTF("1edit5carType");
                out.writeUTF(carID);
                out.writeUTF(type);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editCarTypeLabel.setVisible(true);
                editCarTypeLabel.setText(isExist + ". " + massage);
                editCarTypeTxt.clear();
                editCarTypeComboBox.getSelectionModel().clearSelection();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editCarID(ActionEvent actionEvent) {
        if (editCarIDTxt.getText().isEmpty() || newCarIdTxt.getText().isEmpty()){
            editCarTypeLabel.setVisible(true);
            editCarTypeLabel.setText("ALL FIELD MUST FILL");
        }else {
            String carID = editCarIDTxt.getText();
            String newCarID = newCarIdTxt.getText();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("1cx1edit2all");
                out.writeUTF("1edit4carId");
                out.writeUTF(carID);
                out.writeUTF(newCarID);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                editCarIDLabel.setVisible(true);
                editCarIDLabel.setText(isExist+". "+massage);
                editCarIDTxt.clear();
                newCarIdTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void deleteCar(ActionEvent actionEvent) {
        if (removeCarId.getText().isEmpty() ){
            removeLabel.setVisible(true);
            removeLabel.setText("ALL FIELD MUST FILL");
        }else {
            String carID = removeCarId.getText();
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("1cx1edit2all");
                out.writeUTF("1edit3delete");
                out.writeUTF(carID);
                out.flush();
                String isExist = in.readUTF();
                String massage = in.readUTF();
                out.close();
                in.close();
                socket.close();
                removeLabel.setVisible(true);
                removeLabel.setText(isExist+". "+massage);
                removeCarId.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void showAddCarStage(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("addCarStage.fxml"));
            addCarStage.setTitle("Registration ");
            addCarStage.setScene(new Scene(root, 800, 600));
            addCarStage.show();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public void showAddOrder(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(addOrderTab)) {
            tabPane.getTabs().add(addOrderTab);
        }
    }


    public void showCarIDTab(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editCarIDTab)){
            tabPane.getTabs().add(editCarIDTab);
        }
        editCarIDTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editCarIDTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editCarIDTxt.getText().length()>30){
                    editCarIDTxt.setText(editCarIDTxt.getText(0,30));
                }
            }
        });
        newCarIdTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                newCarIdTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (newCarIdTxt.getText().length()>30){
                    newCarIdTxt.setText(newCarIdTxt.getText(0,30));
                }
            }
        });
    }


    public void showRemoveCarTab(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(removeCarTab)){
            tabPane.getTabs().add(removeCarTab);
        }
        removeCarId.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                removeCarId.setText(newValue.replaceAll("[\\s]+",""));
                if (removeCarId.getText().length()>30){
                    removeCarId.setText(removeCarId.getText(0,30));
                }
            }
        });
    }


    public void showEditCarType(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editCarTypeTab)){
            tabPane.getTabs().add(editCarTypeTab);
        }
        editCarTypeTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editCarTypeTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editCarTypeTxt.getText().length()>30){
                    editCarTypeTxt.setText(editCarTypeTxt.getText(0,30));
                }
            }
        });
    }


    public void showEditCarMaker(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editCarMakerTab)){
            tabPane.getTabs().add(editCarMakerTab);
        }
        editCarMakerCarIdTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editCarTypeTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editCarTypeTxt.getText().length()>30){
                    editCarTypeTxt.setText(editCarTypeTxt.getText(0,30));
                }
            }
        });
        editCarMakerMakerTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (editCarMakerMakerTxt.getText().length()>25){
                    editCarMakerMakerTxt.setText(editCarMakerMakerTxt.getText(0,25));
                }
            }
        });
    }


    public void showEditModelName(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editModelNameTab)){
            tabPane.getTabs().add(editModelNameTab);
        }
        editModelNameCarIdTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editModelNameCarIdTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editModelNameCarIdTxt.getText().length()>30){
                    editModelNameCarIdTxt.setText(editModelNameCarIdTxt.getText(0,30));
                }
            }
        });
        editModelNameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (editModelNameTxt.getText().length()>40){
                    editModelNameTxt.setText(editModelNameTxt.getText(0,40));
                }
            }
        });
    }


    public void showEditModelYear(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editModelYearTab)){
            tabPane.getTabs().add(editModelYearTab);
        }
        editModelYearCarIdTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editModelYearCarIdTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editModelYearCarIdTxt.getText().length()>30){
                    editModelYearCarIdTxt.setText(editModelYearCarIdTxt.getText(0,30));
                }
            }
        });
    }


    public void showEditNumberOfSeats(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editNumberOfSeatsTab)){
            tabPane.getTabs().add(editNumberOfSeatsTab);
        }
        editNumberOfSeatsCarIdTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editNumberOfSeatsCarIdTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editNumberOfSeatsCarIdTxt.getText().length()>30){
                    editNumberOfSeatsCarIdTxt.setText(editNumberOfSeatsCarIdTxt.getText(0,30));
                }
            }
        });
    }


    public void showEditRegistrationNumber(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editRegistrationNumberTab)){
            tabPane.getTabs().add(editRegistrationNumberTab);
        }
        editRegistrationNumberCarIDTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editNumberOfSeatsCarIdTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editNumberOfSeatsCarIdTxt.getText().length()>30){
                    editNumberOfSeatsCarIdTxt.setText(editNumberOfSeatsCarIdTxt.getText(0,30));
                }
            }
        });
        editRegistrationNumberTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (editRegistrationNumberTxt.getText().length()>15){
                    editRegistrationNumberTxt.setText(editRegistrationNumberTxt.getText(0,15));
                }
            }
        });
    }


    public void showEditCarIdentificationNumber(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editCarIdentificationNumberTab)){
            tabPane.getTabs().add(editCarIdentificationNumberTab);
        }
        editCarIdentificationNumberCarIdTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editCarIdentificationNumberCarIdTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editCarIdentificationNumberCarIdTxt.getText().length()>30){
                    editCarIdentificationNumberCarIdTxt.setText(editCarIdentificationNumberCarIdTxt.getText(0,30));
                }
            }
        });
        editCarIdentificationNumberTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (editCarIdentificationNumberTxt.getText().length()>25){
                    editCarIdentificationNumberTxt.setText(editCarIdentificationNumberTxt.getText(0,25));
                }
            }
        });
    }


    public void showEditLastMeterReading(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editLastMeterReadingTab)){
            tabPane.getTabs().add(editLastMeterReadingTab);
        }
        editLastMeterReadingCarIdTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editLastMeterReadingCarIdTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editLastMeterReadingCarIdTxt.getText().length()>30){
                    editLastMeterReadingCarIdTxt.setText(editLastMeterReadingCarIdTxt.getText(0,30));
                }
            }
        });
        editLastMeterReadingTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!editLastMeterReadingTxt.getText().matches("[\\d*\\.]")){
                    editLastMeterReadingTxt.setText(newValue.replaceAll("[^\\d\\.]",""));
                }
            }
        });
    }


    public void showEditCostPerDay(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editCostPerDayTab)) {
            tabPane.getTabs().add(editCostPerDayTab);
        }
        editCostPerDayCarTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editLastMeterReadingCarIdTxt.setText(newValue.replaceAll("[\\s]+", ""));
                if (editLastMeterReadingCarIdTxt.getText().length() > 30) {
                    editLastMeterReadingCarIdTxt.setText(editLastMeterReadingCarIdTxt.getText(0, 30));
                }
            }
        });
        editCostPerDayTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!editCostPerDayTxt.getText().matches("[\\d*\\.]")) {
                    editCostPerDayTxt.setText(newValue.replaceAll("[^\\d\\.]", ""));
                }
            }
        });
    }


    public void showEditCostPerKm(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editCostPerKmTab)) {
            tabPane.getTabs().add(editCostPerKmTab);
        }
        editCostPerKmCarIDTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editCostPerKmCarIDTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editCostPerKmCarIDTxt.getText().length()>30){
                    editCostPerKmCarIDTxt.setText(editCostPerKmCarIDTxt.getText(0,30));
                }
            }
        });
        editCostPerKmTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!editCostPerKmTxt.getText().matches("[\\d*\\.]")){
                    editCostPerKmTxt.setText(newValue.replaceAll("[^\\d\\.]",""));
                }
            }
        });
    }


    public void showEditInsurancePerDay(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editInsurancePerDayTab)) {
            tabPane.getTabs().add(editInsurancePerDayTab);
        }
        editInsurancePerDayCarIdTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editInsurancePerDayCarIdTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editInsurancePerDayCarIdTxt.getText().length()>30){
                    editInsurancePerDayCarIdTxt.setText(editInsurancePerDayCarIdTxt.getText(0,30));
                }
            }
        });
        editInsurancePerDayTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!editInsurancePerDayTxt.getText().matches("[\\d*\\.]")){
                    editInsurancePerDayTxt.setText(newValue.replaceAll("[^\\d\\.]",""));
                }
            }
        });
    }


    public void showEditCarStatus(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editCarStatusTab)) {
            tabPane.getTabs().add(editCarStatusTab);
        }
        editCarStatusCarIDTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editCarStatusCarIDTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editCarStatusCarIDTxt.getText().length()>30){
                    editCarStatusCarIDTxt.setText(editCarStatusCarIDTxt.getText(0,30));
                }
            }
        });
    }


    public void showRemoveAccount(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(removeAccountTab)) {
            tabPane.getTabs().add(removeAccountTab);
        }
        usernameRemoveAccountTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                usernameRemoveAccountTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (usernameRemoveAccountTxt.getText().length()>30){
                    usernameRemoveAccountTxt.setText(usernameRemoveAccountTxt.getText(0,30));
                }
            }
        });
    }


    public void showChangeUsername(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(changeUsernameTab)) {
            tabPane.getTabs().add(changeUsernameTab);
        }
        changeUsernameNewUsernameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                changeUsernameNewUsernameTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (changeUsernameNewUsernameTxt.getText().length()>30){
                    changeUsernameNewUsernameTxt.setText(changeUsernameNewUsernameTxt.getText(0,30));
                }
            }
        });
        changeUsernameOldUsernameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                changeUsernameOldUsernameTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (changeUsernameOldUsernameTxt.getText().length()>30){
                    changeUsernameOldUsernameTxt.setText(changeUsernameOldUsernameTxt.getText(0,30));
                }
            }
        });
    }


    public void showChangePassword(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(changePasswordTab)) {
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
        ChangePasswordTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                ChangePasswordTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (ChangePasswordTxt.getText().length()>30){
                    ChangePasswordTxt.setText(ChangePasswordTxt.getText(0,30));
                }
            }
        });
    }


    public void showEditUserFirstName(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editUserFirstNameTab)) {
            tabPane.getTabs().add(editUserFirstNameTab);
        }
        editUserFirstNameUsernameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editUserFirstNameUsernameTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editUserFirstNameUsernameTxt.getText().length()>30){
                    editUserFirstNameUsernameTxt.setText(editUserFirstNameUsernameTxt.getText(0,30));
                }
            }
        });
        editUserFirstNameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (editUserFirstNameTxt.getText().length()>50){
                    editUserFirstNameTxt.setText(editUserFirstNameTxt.getText(0,50));
                }
            }
        });
    }


    public void showEditUserLastName(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editUserLastNameTab)) {
            tabPane.getTabs().add(editUserLastNameTab);
        }
        editUserLastNameUsernameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editUserLastNameUsernameTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editUserLastNameUsernameTxt.getText().length()>30){
                    editUserLastNameUsernameTxt.setText(editUserLastNameUsernameTxt.getText(0,30));
                }
            }
        });
        editUserLastNameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (editUserLastNameTxt.getText().length()>50){
                    editUserLastNameTxt.setText(editUserLastNameTxt.getText(0,50));
                }
            }
        });
    }


    public void showEditUserGender(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editUserGenderTab)) {
            tabPane.getTabs().add(editUserGenderTab);
        }
        editUserGenderUsernameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editUserGenderUsernameTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editUserGenderUsernameTxt.getText().length()>30){
                    editUserGenderUsernameTxt.setText(editUserGenderUsernameTxt.getText(0,30));
                }
            }
        });
    }


    public void showEditUserTelephone(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editUserTelephoneTab)) {
            tabPane.getTabs().add(editUserTelephoneTab);
        }
        editUserTelephoneUsernameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editUserTelephoneUsernameTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editUserTelephoneUsernameTxt.getText().length()>30){
                    editUserTelephoneUsernameTxt.setText(editUserTelephoneUsernameTxt.getText(0,30));
                }
            }
        });
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


    public void showEditUserEmail(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editUserEmailTab)) {
            tabPane.getTabs().add(editUserEmailTab);
        }
        editUserEmailUsernameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editUserEmailUsernameTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editUserEmailUsernameTxt.getText().length()>30){
                    editUserEmailUsernameTxt.setText(editUserEmailUsernameTxt.getText(0,30));
                }
            }
        });
        editUserEmailTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (editUserEmailTxt.getText().length()>62){
                    editUserEmailTxt.setText(editUserEmailTxt.getText(0,62));
                }
            }
        });
    }


    public void showEditUserAvailability(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editUserAvailabilityTab)) {
            tabPane.getTabs().add(editUserAvailabilityTab);
        }
        editUserAvailabilityUsernameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editUserAvailabilityUsernameTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editUserAvailabilityUsernameTxt.getText().length()>30){
                    editUserAvailabilityUsernameTxt.setText(editUserAvailabilityUsernameTxt.getText(0,30));
                }
            }
        });
    }


    public void showEditAddress(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editAddressTab)) {
            tabPane.getTabs().add(editAddressTab);
        }
        editAddressUsernameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editAddressUsernameTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editAddressUsernameTxt.getText().length()>30){
                    editAddressUsernameTxt.setText(editAddressUsernameTxt.getText(0,30));
                }
            }
        });
        editAddressTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (editAddressTxt.getText().length()>120){
                    editAddressTxt.setText(editAddressTxt.getText(0,120));
                }
            }
        });
    }


    public void showEditAge(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editAgeTab)) {
            tabPane.getTabs().add(editAgeTab);
        }
        editAgeUsernameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editAgeUsernameTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editAgeUsernameTxt.getText().length()>30){
                    editAgeUsernameTxt.setText(editAgeUsernameTxt.getText(0,30));
                }
            }
        });
    }


    public void showEditCustomerLicenseValidity(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editCustomerLicenseValidityTab)) {
            tabPane.getTabs().add(editCustomerLicenseValidityTab);
        }
        editCustomerLicenseValidityUsernameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editCustomerLicenseValidityUsernameTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editCustomerLicenseValidityUsernameTxt.getText().length()>30){
                    editCustomerLicenseValidityUsernameTxt.setText(editCustomerLicenseValidityUsernameTxt.getText(0,30));
                }
            }
        });
    }


    public void showEditCustomerDiscountPoint(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editCustomerDiscountPointTab)) {
            tabPane.getTabs().add(editCustomerDiscountPointTab);
        }
        editCustomerDiscountPointUsernameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editCustomerDiscountPointUsernameTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editCustomerDiscountPointUsernameTxt.getText().length()>30){
                    editCustomerDiscountPointUsernameTxt.setText(editCustomerDiscountPointUsernameTxt.getText(0,30));
                }
            }
        });
        editCustomerDiscountPointTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!editCustomerDiscountPointTxt.getText().matches("[\\d*]")){
                    editCustomerDiscountPointTxt.setText(newValue.replaceAll("[^\\d]",""));
                }
                if (editCustomerDiscountPointTxt.getText().length()>11){
                    editCustomerDiscountPointTxt.setText(editCustomerDiscountPointTxt.getText(0,11));
                }
            }
        });
    }


    public void showEditTotalBills(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editCustomerTotalBillsTab)){
            tabPane.getTabs().add(editCustomerTotalBillsTab);
        }
        editCustomerTotalBillsUsernameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editCustomerTotalBillsUsernameTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editCustomerTotalBillsUsernameTxt.getText().length()>30){
                    editCustomerTotalBillsUsernameTxt.setText(editCustomerTotalBillsUsernameTxt.getText(0,30));
                }
            }
        });
        editCustomerTotalBillsTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!editCustomerTotalBillsTxt.getText().matches("[\\d*\\.]")){
                    editCustomerTotalBillsTxt.setText(newValue.replaceAll("[^\\d\\.]",""));
                }
            }
        });
    }


    public void showEditOrderTripDistance(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editOrderDistanceTab)) {
            tabPane.getTabs().add(editOrderDistanceTab);
        }
        editOrderDistanceOrderIdTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!editOrderDistanceOrderIdTxt.getText().matches("[\\d*]")){
                    editOrderDistanceOrderIdTxt.setText(newValue.replaceAll("[^\\d]",""));
                }
                if (editOrderDistanceOrderIdTxt.getText().length()>30){
                    editOrderDistanceOrderIdTxt.setText(editOrderDistanceOrderIdTxt.getText(0,30));
                }
            }
        });
        editOrderDistanceTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!editOrderDistanceTxt.getText().matches("[\\d*\\.]")){
                    editOrderDistanceTxt.setText(newValue.replaceAll("[^\\d\\.]",""));
                }
            }
        });
    }


    public void showEditOrderPaymentMethod(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editOrderPaymentMethodTab)) {
            tabPane.getTabs().add(editOrderPaymentMethodTab);
        }
        editOrderPaymentMethodOrderIDTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!editOrderPaymentMethodOrderIDTxt.getText().matches("[\\d*]")){
                    editOrderPaymentMethodOrderIDTxt.setText(newValue.replaceAll("[^\\d]",""));
                }
                if (editOrderPaymentMethodOrderIDTxt.getText().length()>30){
                    editOrderPaymentMethodOrderIDTxt.setText(editOrderPaymentMethodOrderIDTxt.getText(0,30));
                }
            }
        });
    }


    public void showEditOrderBill(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editOrderBillTab)) {
            tabPane.getTabs().add(editOrderBillTab);
        }
        editOrderBillOrderIdTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!editOrderBillOrderIdTxt.getText().matches("[\\d*]")){
                    editOrderBillOrderIdTxt.setText(newValue.replaceAll("[^\\d]",""));
                }
                if (editOrderBillOrderIdTxt.getText().length()>30){
                    editOrderBillOrderIdTxt.setText(editOrderBillOrderIdTxt.getText(0,30));
                }
            }
        });
        editOrderBillTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!editOrderBillTxt.getText().matches("[\\d*\\.]")){
                    editOrderBillTxt.setText(newValue.replaceAll("[^\\d\\.]",""));
                }
            }
        });
    }


    public void showEditOrderID(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editOrderIDTab)) {
            tabPane.getTabs().add(editOrderIDTab);
        }
        editOrderIDNewTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!editOrderIDNewTxt.getText().matches("[\\d*]")){
                    editOrderIDNewTxt.setText(newValue.replaceAll("[^\\d]",""));
                }
                if (editOrderIDNewTxt.getText().length()>30){
                    editOrderIDNewTxt.setText(editOrderIDNewTxt.getText(0,30));
                }
            }
        });
        editOrderIDOldTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!editOrderIDOldTxt.getText().matches("[\\d*]")){
                    editOrderIDOldTxt.setText(newValue.replaceAll("[^\\d]",""));
                }
                if (editOrderIDOldTxt.getText().length()>30){
                    editOrderIDOldTxt.setText(editOrderIDOldTxt.getText(0,30));
                }
            }
        });
    }


    public void showEditOrderDay(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editOrderDayTab)) {
            tabPane.getTabs().add(editOrderDayTab);
        }
        editOrderDayOrderIDTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!editOrderDayOrderIDTxt.getText().matches("[\\d*]")){
                    editOrderDayOrderIDTxt.setText(newValue.replaceAll("[^\\d]",""));
                }
                if (editOrderDayOrderIDTxt.getText().length()>30){
                    editOrderDayOrderIDTxt.setText(editOrderDayOrderIDTxt.getText(0,30));
                }
            }
        });
        editOrderDayTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!editOrderDayTxt.getText().matches("[\\d*]")){
                    editOrderDayTxt.setText(newValue.replaceAll("[^\\d]",""));
                }
                if (editOrderDayTxt.getText().length()>11){
                    editOrderDayTxt.setText(editOrderDayTxt.getText(0,11));
                }
            }
        });
    }


    public void showOrderByUsername(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(showOrderByUsernameTab)) {
            tabPane.getTabs().add(showOrderByUsernameTab);
        }
        showOrderByUsernameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                editCustomerTotalBillsUsernameTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (editCustomerTotalBillsUsernameTxt.getText().length()>30){
                    editCustomerTotalBillsUsernameTxt.setText(editCustomerTotalBillsUsernameTxt.getText(0,30));
                }
            }
        });
    }


    public void showOrderByCarId(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(showOrderByCarIDTab)) {
            tabPane.getTabs().add(showOrderByCarIDTab);
        }
        showOrderByCarIDTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showOrderByCarIDTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (showOrderByCarIDTxt.getText().length()>30){
                    showOrderByCarIDTxt.setText(showOrderByCarIDTxt.getText(0,30));
                }
            }
        });
    }


    public void showRemoveOrder(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(removeOrderTab)) {
            tabPane.getTabs().add(removeOrderTab);
        }
        removeOrderTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!removeOrderTxt.getText().matches("[\\d*]")){
                    removeOrderTxt.setText(newValue.replaceAll("[^\\d]",""));
                }
                if (removeOrderTxt.getText().length()>30){
                    removeOrderTxt.setText(removeOrderTxt.getText(0,30));
                }
            }
        });
    }


    public void initialize(){
        tabPane.getTabs().remove(removeCarTab);
        tabPane.getTabs().remove(editCarIDTab);
        tabPane.getTabs().remove(editCarTypeTab);
        tabPane.getTabs().remove(editCarMakerTab);
        tabPane.getTabs().remove(editModelNameTab);
        tabPane.getTabs().remove(editModelYearTab);
        tabPane.getTabs().remove(editNumberOfSeatsTab);
        tabPane.getTabs().remove(editRegistrationNumberTab);
        tabPane.getTabs().remove(editCarIdentificationNumberTab);
        tabPane.getTabs().remove(editLastMeterReadingTab);
        tabPane.getTabs().remove(editCostPerDayTab);
        tabPane.getTabs().remove(editCostPerKmTab);
        tabPane.getTabs().remove(editInsurancePerDayTab);
        tabPane.getTabs().remove(editCarStatusTab);
        tabPane.getTabs().remove(removeAccountTab);
        tabPane.getTabs().remove(changeUsernameTab);
        tabPane.getTabs().remove(changePasswordTab);
        tabPane.getTabs().remove(editUserFirstNameTab);
        tabPane.getTabs().remove(editUserLastNameTab);
        tabPane.getTabs().remove(editUserGenderTab);
        tabPane.getTabs().remove(editUserTelephoneTab);
        tabPane.getTabs().remove(editUserEmailTab);
        tabPane.getTabs().remove(editUserAvailabilityTab);
        tabPane.getTabs().remove(editAddressTab);
        tabPane.getTabs().remove(editAgeTab);
        tabPane.getTabs().remove(editCustomerLicenseValidityTab);
        tabPane.getTabs().remove(editCustomerDiscountPointTab);
        tabPane.getTabs().remove(editAgeTab);
        tabPane.getTabs().remove(editCustomerTotalBillsTab);
        tabPane.getTabs().remove(showOrderByUsernameTab);
        tabPane.getTabs().remove(showOrderByCarIDTab);
        tabPane.getTabs().remove(addOrderTab);
        tabPane.getTabs().remove(removeOrderTab);
        tabPane.getTabs().remove(editOrderIDTab);
        tabPane.getTabs().remove(editOrderDayTab);
        tabPane.getTabs().remove(editOrderDistanceTab);
        tabPane.getTabs().remove(editOrderPaymentMethodTab);
        tabPane.getTabs().remove(editOrderBillTab);
        tabPane.getTabs().remove(editProfileFirstNameTab);
        tabPane.getTabs().remove(editProfileUserLastNameTab);
        tabPane.getTabs().remove(editProfileUserGenderTab);
        tabPane.getTabs().remove(editProfileUserTelephoneTab);
        tabPane.getTabs().remove(editProfileUserEmailTab);
        tabPane.getTabs().remove(editProfileAddressTab);
        tabPane.getTabs().remove(editProfileAgeTab);
        tabPane.getTabs().remove(myInformationTab);
        welcomeLabel.setText("Welcome \""+ControllerRegistration.staticUsername+"\" :)");
        editUserAvailabilityComboBox.getItems().addAll("Online", "Offline");
        editCarTypeComboBox.getItems().addAll("Compact", "Sedan", "Van");
        editModelYearComboBox.getItems().addAll(1950,1951,1952,1953,1954,1955,1956,1957,1958,1959,1960,1961,1962,1963,1964,1965,1966,1967,1968,1969,1970,1971,1972,1973,1974,1975,1976,1977,1978,1979,1980,1981,1982,1983,1984,1985,1986,1987,1988,1989,1990,1991,1992,1993,1994,1995,1996,1997,1998,1999,2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,2015,2016,2017,2018,2019,2020,2021);
        editNumberOfSeatsComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,25);
        editAgeYearComboBox.getItems().addAll(1950,1951,1952,1953,1954,1955,1956,1957,1958,1959,1960,1961,1962,1963,1964,1965,1966,1967,1968,1969,1970,1971,1972,1973,1974,1975,1976,1977,1978,1979,1980,1981,1982,1983,1984,1985,1986,1987,1988,1989,1990,1991,1992,1993,1994,1995,1996,1997,1998,1999,2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,2015,2016,2017,2018,2019,2020);
        editAgeMonthComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12);
        editCarStatusComboBox.getItems().addAll("Available", "Unavailable");
        editUserGenderComboBox.getItems().addAll("Male","Female");
        editCustomerLicenseValidityComboBox.getItems().addAll("Valid", "Invalid");
        editOrderPaymentMethodComboBox.getItems().addAll("Check", "Credit Card", "Bank Transfer", "Cash");

    }


    public void clearUsernameRemoveAccount(MouseEvent mouseEvent) {
        usernameRemoveAccountLabel.setVisible(false);
    }


    public void hideChangeUsernameLabel(MouseEvent mouseEvent) {
        changeUsernameLabel.setVisible(false);
    }


    public void hideChangePasswordLabel(MouseEvent mouseEvent) {
        changePasswordLabel.setVisible(false);
    }


    public void hideEditUserFirstNameLabel(MouseEvent mouseEvent) {
        editUserFirstNameLabel.setVisible(false);
    }


    public void hideEditUserLastNameLabel(MouseEvent mouseEvent) {
        editUserLastNameLabel.setVisible(false);
    }


    public void hideEditUserGenderLabel(MouseEvent mouseEvent) {
        editUserGenderLabel.setVisible(false);
    }


    public void hideEditUserTelephoneLabel(MouseEvent mouseEvent) {
        editUserTelephoneLabel.setVisible(false);
    }


    public void hideEditUserEmailLabel(MouseEvent mouseEvent) {
        editUserEmailLabel.setVisible(false);
    }


    public void hideEditUserAvailabilityLabel(MouseEvent mouseEvent) {
        editUserAvailabilityLabel.setVisible(false);
    }


    public void hideEditAddressLabel(MouseEvent mouseEvent) {
        editAddressLabel.setVisible(false);
    }


    public void hideEditAgeLabel(MouseEvent mouseEvent) {
        editAgeLabel.setVisible(false);
    }


    public void hideEditCustomerTotalBillsTabLabel(MouseEvent mouseEvent) {
        editCustomerTotalBillsLabel.setVisible(false);
    }


    public void hideEditCustomerLicenseValidityLabel(MouseEvent mouseEvent) {
        editCustomerLicenseValidityLabel.setVisible(false);
    }


    public void hideEditCustomerDiscountPointLabel(MouseEvent mouseEvent) {
        editCustomerDiscountPointLabel.setVisible(false);
    }


    public void hideShowOrderByUsernameLabel(MouseEvent mouseEvent) {
        showOrderByUsernameLabel.setVisible(false);
    }


    public void clearEditCostPerDayLabel(MouseEvent mouseEvent) {
        editCostPerDayLabel.setVisible(false);
    }


    public void clearRemoveLabel(MouseEvent mouseEvent) {
        removeLabel.setVisible(false);
    }


    public void clearEditCarIDTxt(MouseEvent mouseEvent) {
        editCarIDLabel.setVisible(false);
    }


    public void clearEditCarTypeLabel(MouseEvent mouseEvent) {
        editCarTypeLabel.setVisible(false);
    }


    public void clearEditCarMakerLabel(MouseEvent mouseEvent) {
        editCarMakerLabel.setVisible(false);
    }


    public void clearEditModelNameLabel(MouseEvent mouseEvent) {
        editModelNameLabel.setVisible(false);
    }


    public void clearEditModelYearLabel(MouseEvent mouseEvent) {
        editModelYearLabel.setVisible(false);
    }


    public void clearEditNumberOfSeatsLabel(MouseEvent mouseEvent) {
        editNumberOfSeatsLabel.setVisible(false);
    }


    public void clearEditRegistrationNumberLabel(MouseEvent mouseEvent) {
        editRegistrationNumberLabel.setVisible(false);
    }


    public void clearEditCarIdentificationNumberLabel(MouseEvent mouseEvent) {
        editCarIdentificationNumberLabel.setVisible(false);
    }


    public void clearEditLastMeterReadingLabel(MouseEvent mouseEvent) {
        editLastMeterReadingLabel.setVisible(false);
    }


    public void clearEditCostPerKmLabel(MouseEvent mouseEvent) {
        editCostPerKmLabel.setVisible(false);
    }


    public void clearEditInsurancePerDay(MouseEvent mouseEvent) {
        editInsurancePerDayLabel.setVisible(false);
    }


    public void clearEditCarStatus(MouseEvent mouseEvent) {
        editCarStatusLabel.setVisible(false);
    }


    public void hideShowOrderByCarIDLabel(MouseEvent mouseEvent) {
        showOrderByCarIDLabel.setVisible(false);
    }


    public void hideAddOrderLabel(MouseEvent mouseEvent) {
        addOrderLabel.setVisible(false);
    }


    public void hideRemoveOrderLabel(MouseEvent mouseEvent) {
        removeOrderLabel.setVisible(false);
    }


    public void hideEditOrderIDLabel(MouseEvent mouseEvent) {
        editOrderIDLabel.setVisible(false);
    }


    public void hideEditOrderPaymentMethodLabel(MouseEvent mouseEvent) {
        editOrderPaymentMethodLabel.setVisible(false);
    }


    public void hideEditOrderDayLabel(MouseEvent mouseEvent) {
        editOrderDayLabel.setVisible(false);
    }


    public void hideEditOrderDistanceLabel(MouseEvent mouseEvent) {
        editOrderDistanceLabel.setVisible(false);
    }


    public void hideEditOrderBillLabel(MouseEvent mouseEvent) {
        editOrderBillLabel.setVisible(false);
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


    public void logOut(ActionEvent actionEvent) {
        ControllerRegistration.supervisorStage.close();
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


    public void closeRootStage(ActionEvent actionEvent) {
        ControllerRegistration.supervisorStage.close();
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
            usernameTxtShow.setText(showAll.get(0).getUsername());
            dateTxtShow.setText(showAll.get(0).getDateCreate().toString());
            firstNameTxtShow.setText(showAll.get(0).getFirstName());
            lastNameTxtShow.setText(showAll.get(0).getLastName());
            genderTxtShow.setText(showAll.get(0).getGender());
            ageTxtShow.setText(showAll.get(0).getAge());
            telephoneTxtShow.setText(new Integer(showAll.get(0).getTelephone()).toString());
            emailTxtShow.setText(showAll.get(0).getEmail());
            addressTxtShow.setText(showAll.get(0).getAddress());
            sectionTxtShow.setText(showAll.get(0).getSection());
            rankTxtShow.setText(showAll.get(0).getRank());
            statusTxtShow.setText(showAll.get(0).getStatus());
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }


    public void editFirstNameProfile(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editProfileFirstNameTab)){
            tabPane.getTabs().add(editProfileFirstNameTab);
        }
        tabPane.getSelectionModel().select(editProfileFirstNameTab);
        editProfileUserFirstNameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (editProfileUserFirstNameTxt.getText().length()>50){
                    editProfileUserFirstNameTxt.setText(editProfileUserFirstNameTxt.getText(0,50));
                }
            }
        });
    }


    public void editLastNameProfile(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editProfileUserLastNameTab)){
            tabPane.getTabs().add(editProfileUserLastNameTab);
        }
        tabPane.getSelectionModel().select(editProfileUserLastNameTab);
        editProfileUserLastNameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (editProfileUserLastNameTxt.getText().length()>50){
                    editProfileUserLastNameTxt.setText(editProfileUserLastNameTxt.getText(0,50));
                }
            }
        });
    }


    public void editGenderProfile(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editProfileUserGenderTab)){
            tabPane.getTabs().add(editProfileUserGenderTab);
        }
        tabPane.getSelectionModel().select(editProfileUserGenderTab);
        editUserProfileGenderComboBox.getItems().addAll("Male", "Female");
    }


    public void editAgeProfile(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editProfileAgeTab)){
            tabPane.getTabs().add(editProfileAgeTab);
        }
        tabPane.getSelectionModel().select(editProfileAgeTab);
        editProfileAgeYearComboBox.getItems().addAll(1950, 1951, 1952, 1953, 1954, 1955, 1956, 1957, 1958, 1959, 1960, 1961, 1962, 1963, 1964, 1965, 1966, 1967, 1968, 1969, 1970, 1971, 1972, 1973, 1974, 1975, 1976, 1977, 1978, 1979, 1980, 1981, 1982, 1983, 1984, 1985, 1986, 1987, 1988, 1989, 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020);
        editProfileAgeMonthComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    }


    public void editTelephoneProfile(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editProfileUserTelephoneTab)){
            tabPane.getTabs().add(editProfileUserTelephoneTab);
        }
        tabPane.getSelectionModel().select(editProfileUserTelephoneTab);
        editProfileUserTelephoneTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!editProfileUserTelephoneTxt.getText().matches("[\\d*]")){
                    editProfileUserTelephoneTxt.setText(newValue.replaceAll("[^\\d]",""));
                }
                if (editProfileUserTelephoneTxt.getText().length()>15){
                    editProfileUserTelephoneTxt.setText(editProfileUserTelephoneTxt.getText(0,15));
                }
            }
        });
    }


    public void editEmailProfile(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editProfileUserEmailTab)){
            tabPane.getTabs().add(editProfileUserEmailTab);
        }
        tabPane.getSelectionModel().select(editProfileUserEmailTab);
        editProfileUserEmailTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (editProfileUserEmailTxt.getText().length()>62){
                    editProfileUserEmailTxt.setText(editProfileUserEmailTxt.getText(0,62));
                }
            }
        });

    }


    public void editAddressProfile(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(editProfileAddressTab)){
            tabPane.getTabs().add(editProfileAddressTab);
        }
        tabPane.getSelectionModel().select(editProfileAddressTab);
        editProfileAddressTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (editProfileAddressTxt.getText().length()>120){
                    editProfileAddressTxt.setText(editProfileAddressTxt.getText(0,120));
                }
            }
        });
    }


    public void editProfileAgeDayMonth(ActionEvent actionEvent) {
        if (editProfileAgeMonthComboBox.getSelectionModel().isSelected(0) || editProfileAgeMonthComboBox.getSelectionModel().isSelected(2) || editProfileAgeMonthComboBox.getSelectionModel().isSelected(4) || editProfileAgeMonthComboBox.getSelectionModel().isSelected(6) || editProfileAgeMonthComboBox.getSelectionModel().isSelected(7) || editProfileAgeMonthComboBox.getSelectionModel().isSelected(9) || editProfileAgeMonthComboBox.getSelectionModel().isSelected(11)){
            editProfileAgeDayComboBox.getItems().clear();
            editProfileAgeDayComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31);
        }
        if (editProfileAgeMonthComboBox.getSelectionModel().isSelected(3) || editProfileAgeMonthComboBox.getSelectionModel().isSelected(5) || editProfileAgeMonthComboBox.getSelectionModel().isSelected(8) || editProfileAgeMonthComboBox.getSelectionModel().isSelected(10)){
            editProfileAgeDayComboBox.getItems().clear();
            editProfileAgeDayComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30);
        }
        if (editProfileAgeMonthComboBox.getSelectionModel().isSelected(1)){
            Integer year = (Integer)editProfileAgeYearComboBox.getSelectionModel().getSelectedItem();
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (gregorianCalendar.isLeapYear(year)){
                editProfileAgeDayComboBox.getItems().clear();
                editAgeDayComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29);
            }else {
                editProfileAgeDayComboBox.getItems().clear();
                editProfileAgeDayComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28);
            }
        }
    }


    public void editProfileUserAge(ActionEvent actionEvent) {
        if (editProfileAgeYearComboBox.getSelectionModel().isEmpty() || editProfileAgeMonthComboBox.getSelectionModel().isEmpty() || editProfileAgeDayComboBox.getSelectionModel().isEmpty()){
            editProfileAgeLabel.setVisible(true);
            editProfileAgeLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = ControllerRegistration.staticUsername;
            Integer year = (Integer) editProfileAgeYearComboBox.getSelectionModel().getSelectedItem();
            Integer month = (Integer) editProfileAgeMonthComboBox.getSelectionModel().getSelectedItem();
            Integer day = (Integer) editProfileAgeDayComboBox.getSelectionModel().getSelectedItem();
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
                editProfileAgeLabel.setVisible(true);
                editProfileAgeLabel.setText(isExist + ". " + massage);
                editProfileAgeYearComboBox.getSelectionModel().clearSelection();
                editProfileAgeMonthComboBox.getSelectionModel().clearSelection();
                editProfileAgeDayComboBox.getSelectionModel().clearSelection();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editProfileUserAddress(ActionEvent actionEvent) {
        if (editProfileAddressTxt.getText().isEmpty()){
            editProfileAddressLabel.setVisible(true);
            editProfileAddressLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = ControllerRegistration.staticUsername;
            String email = editProfileAddressTxt.getText();
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
                editProfileAddressLabel.setVisible(true);
                editProfileAddressLabel.setText(isExist + ". " + massage);
                editProfileAddressTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editProfileUserEmail(ActionEvent actionEvent) {
        if (editProfileUserEmailTxt.getText().isEmpty()){
            editProfileUserEmailLabel.setVisible(true);
            editProfileUserEmailLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = ControllerRegistration.staticUsername;
            String email = editProfileUserEmailTxt.getText();
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
                editProfileUserEmailLabel.setVisible(true);
                editProfileUserEmailLabel.setText(isExist + ". " + massage);
                editProfileUserEmailTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editProfileUserTelephone(ActionEvent actionEvent) {
        if (editProfileUserTelephoneTxt.getText().isEmpty()){
            editProfileUserTelephoneLabel.setVisible(true);
            editProfileUserTelephoneLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = ControllerRegistration.staticUsername;
            int telephone = 0;
            if (!editProfileUserTelephoneTxt.getText().isEmpty()) {
                telephone = Integer.parseInt(editProfileUserTelephoneTxt.getText());
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
                editProfileUserTelephoneLabel.setVisible(true);
                editProfileUserTelephoneLabel.setText(isExist + ". " + massage);
                editProfileUserTelephoneTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editProfileUserGender(ActionEvent actionEvent) {
        if (editUserProfileGenderComboBox.getSelectionModel().isEmpty()){
            editProfileUserGenderLabel.setVisible(true);
            editProfileUserGenderLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = ControllerRegistration.staticUsername;
            String gender = (String) editUserProfileGenderComboBox.getSelectionModel().getSelectedItem();
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
                editProfileUserGenderLabel.setVisible(true);
                editProfileUserGenderLabel.setText(isExist + ". " + massage);
                editUserProfileGenderComboBox.getSelectionModel().clearSelection();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editProfileUserLastName(ActionEvent actionEvent) {
        if (editProfileUserLastNameTxt.getText().isEmpty()){
            editProfileUserLastNameLabel.setVisible(true);
            editProfileUserLastNameLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = ControllerRegistration.staticUsername;
            String lastName = editProfileUserLastNameTxt.getText();
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
                editProfileUserLastNameLabel.setVisible(true);
                editProfileUserLastNameLabel.setText(isExist + ". " + massage);
                editProfileUserLastNameTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void editProfileUserFirstName(ActionEvent actionEvent) {
        if (editProfileUserFirstNameTxt.getText().isEmpty()){
            editProfileUserFirstNameLabel.setVisible(true);
            editProfileUserFirstNameLabel.setText("ALL FIELD MUST FILL");
        }else {
            String username = ControllerRegistration.staticUsername;
            String firstName = editProfileUserFirstNameTxt.getText();
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
                editProfileUserFirstNameLabel.setVisible(true);
                editProfileUserFirstNameLabel.setText(isExist + ". " + massage);
                editProfileUserFirstNameTxt.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
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

    public void showMyMassage(ActionEvent actionEvent) {
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

    public void showAdministrativeMassage(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("viewAdministrativeMassage.fxml"));
            showAdministrativeMassageStage.setTitle("Show Administrative Massage");
            showAdministrativeMassageStage.setScene(new Scene(root, 800, 600));
            showAdministrativeMassageStage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
