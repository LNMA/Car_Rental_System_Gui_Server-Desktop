package clientfx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import server.SBE;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ControllerAddCarStage {

    public ComboBox typeComboBox;
    public ComboBox modelYearComboBox;
    public ComboBox seatsComboBox;
    public ComboBox statusComboBox;
    public Label costPerKmLabel;
    public TextField costPerKmTxt;
    public Label insurancePerDayLabel;
    public TextField insurancePerDayTxt;
    public TextField lastMeterTxt;
    public TextField costPerDayTxt;
    public TextField identifNumberTxt;
    public TextField registNumberTxt;
    public TextField modelNameTxt;
    public TextField makerTxt;
    public TextField idCarTxt;
    public Label idLabel;
    public Label typeLabel;
    public Label makerLabel;
    public Label modelLabel;
    public Label yearLabel;
    public Label seatsLabel;
    public Label registrationLabel;
    public Label identificationLabel;
    public Label meterLabel;
    public Label perDayLabel;
    public Label statusLabel;
    public Label perKmLabel;
    public Label insuranceLabel;
    public Label addCarLabel;

    public void addCar(ActionEvent actionEvent) {

        if (idCarTxt.getText().isEmpty() || typeComboBox.getSelectionModel().isEmpty() || makerTxt.getText().isEmpty() || modelNameTxt.getText().isEmpty() || modelYearComboBox.getSelectionModel().isEmpty() || seatsComboBox.getSelectionModel().isEmpty() || registNumberTxt.getText().isEmpty() || identifNumberTxt.getText().isEmpty() || lastMeterTxt.getText().isEmpty() || costPerDayTxt.getText().isEmpty() || seatsComboBox.getSelectionModel().isEmpty()){
            addCarLabel.setVisible(true);
            addCarLabel.setText("all field must fills");
        }else {
        if (((String)typeComboBox.getSelectionModel().getSelectedItem()).equals("Van")){
            if (costPerDayTxt.getText().isEmpty() || insurancePerDayTxt.getText().isEmpty()){
                addCarLabel.setVisible(true);
                addCarLabel.setText("all field must fills");
            }
        }
        if (((String)typeComboBox.getSelectionModel().getSelectedItem()).equals("Sedan")){
            if (costPerDayTxt.getText().isEmpty()){
                addCarLabel.setVisible(true);
                addCarLabel.setText("all field must fills");
            }
        }
            String carID = idCarTxt.getText();
            String type = (String) typeComboBox.getSelectionModel().getSelectedItem();
            String maker = makerTxt.getText();
            String modelName = modelNameTxt.getText();
            Integer modelYear = (Integer) modelYearComboBox.getSelectionModel().getSelectedItem();
            Integer seats = (Integer) seatsComboBox.getSelectionModel().getSelectedItem();
            String registration = registNumberTxt.getText();
            String identification = identifNumberTxt.getText();
            double lastMeter = Double.parseDouble(lastMeterTxt.getText());
            double costPerDay = Double.parseDouble(costPerDayTxt.getText());
            String status = (String) statusComboBox.getSelectionModel().getSelectedItem();
            double costPerKm = 0;
            if (!costPerKmTxt.getText().isEmpty()) {
                costPerKm = Double.parseDouble(costPerKmTxt.getText());
            }
            double insurance = 0;
            if (!insurancePerDayTxt.getText().isEmpty()) {
                insurance = Double.parseDouble(insurancePerDayTxt.getText());
            }
            try {
                Socket socket = new Socket(SBE.getServerHost(), SBE.getClientPort());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                out.writeUTF("0cx0add1all");
                out.writeUTF(carID);
                out.writeUTF(type);
                out.writeUTF(maker);
                out.writeUTF(modelName);
                out.writeInt(modelYear);
                out.writeInt(seats);
                out.writeUTF(registration);
                out.writeUTF(identification);
                out.writeDouble(lastMeter);
                out.writeDouble(costPerDay);
                out.writeUTF(status);
                out.writeDouble(costPerKm);
                out.writeDouble(insurance);
                out.flush();
                String addCarMassage = in.readUTF();
                String typeMassage = in.readUTF();
                String makerMassage = in.readUTF();
                String modelNameMassage = in.readUTF();
                String modelYearMassage = in.readUTF();
                String seatsMassage = in.readUTF();
                String registrationMassage = in.readUTF();
                String identificationMassage = in.readUTF();
                String lastMeterMassage = in.readUTF();
                String costPerDayMassage = in.readUTF();
                String statusMassage = in.readUTF();
                String costPerKmMassage = in.readUTF();
                String insuranceMassage = in.readUTF();
                out.close();
                in.close();
                socket.close();

                addCarLabel.setVisible(true);
                typeLabel.setVisible(true);
                makerLabel.setVisible(true);
                modelLabel.setVisible(true);
                seatsLabel.setVisible(true);
                yearLabel.setVisible(true);
                registrationLabel.setVisible(true);
                identificationLabel.setVisible(true);
                meterLabel.setVisible(true);
                perDayLabel.setVisible(true);
                statusLabel.setVisible(true);
                perKmLabel.setVisible(true);
                insuranceLabel.setVisible(true);

                addCarLabel.setText(addCarMassage);
                typeLabel.setText(typeMassage);
                makerLabel.setText(makerMassage);
                modelLabel.setText(modelNameMassage);
                seatsLabel.setText(seatsMassage);
                yearLabel.setText(modelYearMassage);
                registrationLabel.setText(registrationMassage);
                identificationLabel.setText(identificationMassage);
                meterLabel.setText(lastMeterMassage);
                perDayLabel.setText(costPerDayMassage);
                statusLabel.setText(statusMassage);
                perKmLabel.setText(costPerKmMassage);
                insuranceLabel.setText(insuranceMassage);

                idCarTxt.clear();
                typeComboBox.getSelectionModel().clearSelection();
                makerTxt.clear();
                modelNameTxt.clear();
                modelYearComboBox.getSelectionModel().clearSelection();
                seatsComboBox.getSelectionModel().clearSelection();
                registNumberTxt.clear();
                identifNumberTxt.clear();
                lastMeterTxt.clear();
                costPerDayTxt.clear();
                costPerKmTxt.clear();
                statusComboBox.getSelectionModel().clearSelection();
                insurancePerDayTxt.clear();
                costPerKmLabel.setVisible(false);
                costPerKmTxt.setVisible(false);
                insurancePerDayLabel.setVisible(false);
                insurancePerDayTxt.setVisible(false);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void typeChoice(ActionEvent actionEvent) {
        if (!typeComboBox.getSelectionModel().isEmpty()) {
            if (((String) typeComboBox.getSelectionModel().getSelectedItem()).equals("Van")) {
                costPerKmLabel.setVisible(true);
                costPerKmTxt.setVisible(true);
                insurancePerDayLabel.setVisible(true);
                insurancePerDayTxt.setVisible(true);
            }
            if (((String) typeComboBox.getSelectionModel().getSelectedItem()).equals("Sedan")) {
                costPerKmLabel.setVisible(true);
                costPerKmTxt.setVisible(true);
                insurancePerDayLabel.setVisible(false);
                insurancePerDayTxt.setVisible(false);
            }
            if (((String) typeComboBox.getSelectionModel().getSelectedItem()).equals("Compact")) {
                costPerKmLabel.setVisible(false);
                costPerKmTxt.setVisible(false);
                insurancePerDayLabel.setVisible(false);
                insurancePerDayTxt.setVisible(false);
            }
        }
    }

    public void initialize(){
        typeComboBox.getItems().addAll("Compact", "Sedan", "Van");
        modelYearComboBox.getItems().addAll(1950,1951,1952,1953,1954,1955,1956,1957,1958,1959,1960,1961,1962,1963,1964,1965,1966,1967,1968,1969,1970,1971,1972,1973,1974,1975,1976,1977,1978,1979,1980,1981,1982,1983,1984,1985,1986,1987,1988,1989,1990,1991,1992,1993,1994,1995,1996,1997,1998,1999,2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,2015,2016,2017,2018,2019,2020,2021);
        seatsComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,25);
        statusComboBox.getItems().addAll("Available", "Unavailable");
        insurancePerDayTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!insurancePerDayTxt.getText().matches("[\\d*\\.]")){
                    insurancePerDayTxt.setText(newValue.replaceAll("[^\\d\\.]",""));
                }
            }
        });
        costPerKmTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!costPerKmTxt.getText().matches("[\\d*\\.]")){
                    costPerKmTxt.setText(newValue.replaceAll("[^\\d\\.]",""));
                }
            }
        });
        lastMeterTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!lastMeterTxt.getText().matches("[\\d*\\.]")){
                    lastMeterTxt.setText(newValue.replaceAll("[^\\d\\.]",""));
                }
            }
        });
        costPerDayTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!costPerDayTxt.getText().matches("[\\d*\\.]")){
                    costPerDayTxt.setText(newValue.replaceAll("[^\\d\\.]",""));
                }
            }
        });
        idCarTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                idCarTxt.setText(newValue.replaceAll("[\\s]+",""));
                if (idCarTxt.getText().length()>30){
                    idCarTxt.setText(idCarTxt.getText(0,30));
                }
            }
        });
        makerTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (makerTxt.getText().length()>25){
                    makerTxt.setText(makerTxt.getText(0,25));
                }
            }
        });
        modelNameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (modelNameTxt.getText().length()>40){
                    modelNameTxt.setText(modelNameTxt.getText(0,40));
                }
            }
        });
        registNumberTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (registNumberTxt.getText().length()>15){
                    registNumberTxt.setText(registNumberTxt.getText(0,15));
                }
            }
        });
        identifNumberTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (identifNumberTxt.getText().length()>25){
                    identifNumberTxt.setText(identifNumberTxt.getText(0,25));
                }
            }
        });
    }


    public void hide1(MouseEvent mouseEvent) {
        addCarLabel.setVisible(false);
        addCarLabel.setVisible(false);
        typeLabel.setVisible(false);
        makerLabel.setVisible(false);
        modelLabel.setVisible(false);
        seatsLabel.setVisible(false);
        yearLabel.setVisible(false);
        registrationLabel.setVisible(false);
        identificationLabel.setVisible(false);
        meterLabel.setVisible(false);
        perDayLabel.setVisible(false);
        statusLabel.setVisible(false);
        perKmLabel.setVisible(false);
        insuranceLabel.setVisible(false);
    }
}
