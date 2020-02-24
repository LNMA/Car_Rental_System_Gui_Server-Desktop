package referanceclass;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderReference implements Serializable {
    private String username;
    private String carID;
    private int orderID;
    private Timestamp dateCreate;
    private int day;
    private double tripDistance;
    private String paymentMethods;
    private double bill;
    private String carType;
    private String carMaker;
    private String carModel;
    private int carModelYear;
    private int carNumberOfSeats;
    private String carRegistrationNumber;
    private String carIdentificationNumber;

    public OrderReference(String username, String carID, int orderID, Timestamp dateCreate, int day, double tripDistance, String paymentMethods, double bill, String carType, String carMaker, String carModel, int carModelYear, int carNumberOfSeats, String carRegistrationNumber, String carIdentificationNumber) {
        this.username = username;
        this.carID = carID;
        this.orderID = orderID;
        this.dateCreate = dateCreate;
        this.day = day;
        this.tripDistance = tripDistance;
        this.paymentMethods = paymentMethods;
        this.bill = bill;
        this.carType = carType;
        this.carMaker = carMaker;
        this.carModel = carModel;
        this.carModelYear = carModelYear;
        this.carNumberOfSeats = carNumberOfSeats;
        this.carRegistrationNumber = carRegistrationNumber;
        this.carIdentificationNumber = carIdentificationNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public double getTripDistance() {
        return tripDistance;
    }

    public void setTripDistance(double tripDistance) {
        this.tripDistance = tripDistance;
    }

    public String getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(String paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarMaker() {
        return carMaker;
    }

    public void setCarMaker(String carMaker) {
        this.carMaker = carMaker;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarModelYear() {
        return carModelYear;
    }

    public void setCarModelYear(int carModelYear) {
        this.carModelYear = carModelYear;
    }

    public int getCarNumberOfSeats() {
        return carNumberOfSeats;
    }

    public void setCarNumberOfSeats(int carNumberOfSeats) {
        this.carNumberOfSeats = carNumberOfSeats;
    }

    public String getCarRegistrationNumber() {
        return carRegistrationNumber;
    }

    public void setCarRegistrationNumber(String carRegistrationNumber) {
        this.carRegistrationNumber = carRegistrationNumber;
    }

    public String getCarIdentificationNumber() {
        return carIdentificationNumber;
    }

    public void setCarIdentificationNumber(String carIdentificationNumber) {
        this.carIdentificationNumber = carIdentificationNumber;
    }

    @Override
    public String toString() {
        return "OrderReference{" +
                "username='" + username + '\'' +
                ", carID='" + carID + '\'' +
                ", orderID=" + orderID +
                ", dateCreate=" + dateCreate +
                ", day=" + day +
                ", tripDistance=" + tripDistance +
                ", paymentMethods='" + paymentMethods + '\'' +
                ", bill=" + bill +
                ", carType='" + carType + '\'' +
                ", carMaker='" + carMaker + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carModelYear=" + carModelYear +
                ", carNumberOfSeats=" + carNumberOfSeats +
                ", carRegistrationNumber='" + carRegistrationNumber + '\'' +
                ", carIdentificationNumber='" + carIdentificationNumber + '\'' +
                '}';
    }
}
