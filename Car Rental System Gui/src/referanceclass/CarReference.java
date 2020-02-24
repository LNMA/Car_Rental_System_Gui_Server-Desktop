package referanceclass;

import java.io.Serializable;
import java.sql.Timestamp;

public class CarReference implements Serializable {
    private String idCar;
    private Timestamp dateCreate;
    private String type;
    private String maker;
    private String model;
    private int modelYear;
    private int numberOfSeats;
    private String registration;
    private String identification;
    private double lastMeter;
    private double costPerDay;
    private String status;
    private double costPerKmSedan;
    private double costPerKmVan;
    private double insurance;

    public CarReference(String idCar, Timestamp dateCreate, String type, String maker, String model, int modelYear, int numberOfSeats, String registration, String identification, double lastMeter, double costPerDay, String status, double costPerKmSedan, double costPerKmVan, double insurance) {
        this.idCar = idCar;
        this.dateCreate = dateCreate;
        this.type = type;
        this.maker = maker;
        this.model = model;
        this.modelYear = modelYear;
        this.numberOfSeats = numberOfSeats;
        this.registration = registration;
        this.identification = identification;
        this.lastMeter = lastMeter;
        this.costPerDay = costPerDay;
        this.status = status;
        this.costPerKmSedan = costPerKmSedan;
        this.costPerKmVan = costPerKmVan;
        this.insurance = insurance;
    }

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }

    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public double getLastMeter() {
        return lastMeter;
    }

    public void setLastMeter(double lastMeter) {
        this.lastMeter = lastMeter;
    }

    public double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(double costPerDay) {
        this.costPerDay = costPerDay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getCostPerKmSedan() {
        return costPerKmSedan;
    }

    public void setCostPerKmSedan(double costPerKmSedan) {
        this.costPerKmSedan = costPerKmSedan;
    }

    public double getCostPerKmVan() {
        return costPerKmVan;
    }

    public void setCostPerKmVan(double costPerKmVan) {
        this.costPerKmVan = costPerKmVan;
    }

    public double getInsurance() {
        return insurance;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    @Override
    public String toString() {
        return "CarReference{" +
                "idCar='" + idCar + '\'' +
                ", dateCreate=" + dateCreate +
                ", type='" + type + '\'' +
                ", maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                ", modelYear=" + modelYear +
                ", numberOfSeats=" + numberOfSeats +
                ", registration='" + registration + '\'' +
                ", identification='" + identification + '\'' +
                ", lastMeter=" + lastMeter +
                ", costPerDay=" + costPerDay +
                ", status='" + status + '\'' +
                ", costPerKmSedan=" + costPerKmSedan +
                ", costPerKmVan=" + costPerKmVan +
                ", insurance=" + insurance +
                '}';
    }
}
