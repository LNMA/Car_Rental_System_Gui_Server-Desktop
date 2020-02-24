package database;

import referanceclass.CarReference;
import server.SBE;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Car {
    Connection connection;
    String theMassage;

    public String getTheMassage() {
        return theMassage;
    }

    public void setTheMassage(String theMassage) {
        this.theMassage = theMassage;
    }

    private void connect(){
        try {
            connection = DriverManager.getConnection(SBE.getDbUrl(),SBE.getDbUser(),SBE.getDbPassword());
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String insertCarID(String carID) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.car(idCar,dateCreate) VALUES (?,?)");
            preparedStatement.setString(1, carID);
            preparedStatement.setTimestamp(2, getDateCreate());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Car ID insert successfully";
        }
        catch (SQLIntegrityConstraintViolationException e){
                massage = "Car ID already used, try another one";
            }
        catch (SQLException e){
                massage = e.getMessage();
            }
        catch (Exception e){
                massage = e.getMessage();
            }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(massage);
        return massage;
    }

    public String updateCarID(String carID,String newCarID) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("update car_rental_system.car set idCar=? where idCar=?");
            preparedStatement.setString(1, newCarID);
            preparedStatement.setString(2, carID);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Car ID update successfully";
        }
        catch (SQLException e){
            massage = e.getMessage();
        }
        catch (Exception e){
            massage = e.getMessage();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(massage);
        return massage;
    }

    private java.sql.Timestamp getDateCreate(){
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        java.sql.Timestamp dateSQL = new java.sql.Timestamp(date.getTime());
        return dateSQL;
    }

    public String setType(String carID,String type) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.car(idCar,type) VALUES (?,?) ON DUPLICATE KEY UPDATE car.type=? ");
            preparedStatement.setString(1, carID);
            preparedStatement.setString(2, type);
            preparedStatement.setString(3, type);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Type insert successfully";
        }
        catch (SQLException e){
            massage = e.getMessage();
        }
        catch (Exception e) {
            massage = e.getMessage();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(massage);
        return massage;
    }

    public String setMaker(String carID,String maker) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.car(idCar,maker) VALUES (?,?) ON DUPLICATE KEY UPDATE maker=? ");
            preparedStatement.setString(1, carID);
            preparedStatement.setString(2, maker);
            preparedStatement.setString(3, maker);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Maker insert successfully";
        }
        catch (SQLException e){
            massage = e.getMessage();
        }
        catch (Exception e) {
            massage = e.getMessage();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(massage);
        return massage;
    }

    public String setModelName(String carID,String modelName) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.car(idCar,model) VALUES (?,?) ON DUPLICATE KEY UPDATE model=? ");
            preparedStatement.setString(1, carID);
            preparedStatement.setString(2, modelName);
            preparedStatement.setString(3, modelName);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Model Name insert successfully";
        }
        catch (SQLException e){
            massage = e.getMessage();
        }
        catch (Exception e) {
            massage = e.getMessage();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(massage);
        return massage;
    }

    public String setModelYear(String carID,int modelYear) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.car(idCar,modelYear) VALUES (?,?) ON DUPLICATE KEY UPDATE modelYear=? ");
            preparedStatement.setString(1, carID);
            preparedStatement.setInt(2, modelYear);
            preparedStatement.setInt(3, modelYear);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Model year insert successfully";
        }
        catch (SQLException e){
            massage = e.getMessage();
        }
        catch (Exception e) {
            massage = e.getMessage();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(massage);
        return massage;
    }

    public String setNumberOfSeats(String carID,int numberOfSeats) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.car(idCar,numberOfSeats) VALUES (?,?) ON DUPLICATE KEY UPDATE numberOfSeats=? ");
            preparedStatement.setString(1, carID);
            preparedStatement.setInt(2, numberOfSeats);
            preparedStatement.setInt(3, numberOfSeats);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Number Of Seats insert successfully";
        }
        catch (SQLException e){
            massage = e.getMessage();
        }
        catch (Exception e) {
            massage = e.getMessage();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(massage);
        return massage;
    }

    public String setRegistrationNumber(String carID,String registrationNumber) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.car(idCar,registrationNumber) VALUES (?,?) ON DUPLICATE KEY UPDATE registrationNumber=? ");
            preparedStatement.setString(1, carID);
            preparedStatement.setString(2, registrationNumber);
            preparedStatement.setString(3, registrationNumber);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Registration Number insert successfully";
        }
        catch (SQLException e){
            massage = e.getMessage();
        }
        catch (Exception e) {
            massage = e.getMessage();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(massage);
        return massage;
    }

    public String setIdentificationNumber(String carID,String identificationNumber) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.car(idCar,identificationNumber) VALUES (?,?) ON DUPLICATE KEY UPDATE identificationNumber=? ");
            preparedStatement.setString(1, carID);
            preparedStatement.setString(2, identificationNumber);
            preparedStatement.setString(3, identificationNumber);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Identification Number insert successfully";
        }
        catch (SQLException e){
            massage = e.getMessage();
        }
        catch (Exception e) {
            massage = e.getMessage();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(massage);
        return massage;
    }

    public String setLastMeterReading(String carID,double lastMeterReading) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.car(idCar,lastMeterReading) VALUES (?,?) ON DUPLICATE KEY UPDATE lastMeterReading=? ");
            preparedStatement.setString(1, carID);
            preparedStatement.setDouble(2, lastMeterReading);
            preparedStatement.setDouble(3, lastMeterReading);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "LastMeter Reading insert successfully";
        }
        catch (SQLException e){
            massage = e.getMessage();
        }
        catch (Exception e) {
            massage = e.getMessage();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(massage);
        return massage;
    }

    public String setCostPerDay(String carID,double costPerDay) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.car(idCar,costPerDay) VALUES (?,?) ON DUPLICATE KEY UPDATE costPerDay=? ");
            preparedStatement.setString(1, carID);
            preparedStatement.setDouble(2, costPerDay);
            preparedStatement.setDouble(3, costPerDay);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Cost Per Day insert successfully";
        }
        catch (SQLException e){
            massage = e.getMessage();
        }
        catch (Exception e) {
            massage = e.getMessage();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(massage);
        return massage;
    }

    public String setStatus(String carID,String status) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.car(idCar,status) VALUES (?,?) ON DUPLICATE KEY UPDATE status=? ");
            preparedStatement.setString(1, carID);
            preparedStatement.setString(2, status);
            preparedStatement.setString(3, status);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Status insert successfully";
        }
        catch (SQLException e){
            massage = e.getMessage();
        }
        catch (Exception e) {
            massage = e.getMessage();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(massage);
        return massage;
    }

    public String setCostPerKmSedan(String carID,double costPerKm) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.car_sedan(idCar,costPerKm) VALUES (?,?) ON DUPLICATE KEY UPDATE costPerKm=? ");
            preparedStatement.setString(1, carID);
            preparedStatement.setDouble(2, costPerKm);
            preparedStatement.setDouble(3, costPerKm);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Cost Per Km insert successfully";
        }
        catch (SQLException e){
            massage = e.getMessage();
        }
        catch (Exception e) {
            massage = e.getMessage();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(massage);
        return massage;
    }

    public String setCostPerKmVan(String carID,double costPerKm) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.car_van(idCar,costPerKm) VALUES (?,?) ON DUPLICATE KEY UPDATE costPerKm=? ");
            preparedStatement.setString(1, carID);
            preparedStatement.setDouble(2, costPerKm);
            preparedStatement.setDouble(3, costPerKm);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Cost Per Km insert successfully";
        }
        catch (SQLException e){
            massage = e.getMessage();
        }
        catch (Exception e) {
            massage = e.getMessage();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(massage);
        return massage;
    }

    public String setInsurancePerDayVan(String carID,double insurancePerDay) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.car_van(idCar,insurancePerDay) VALUES (?,?) ON DUPLICATE KEY UPDATE insurancePerDay=? ");
            preparedStatement.setString(1, carID);
            preparedStatement.setDouble(2, insurancePerDay);
            preparedStatement.setDouble(3, insurancePerDay);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Insurance Per Day insert successfully";
        }
        catch (SQLException e){
            massage = e.getMessage();
        }
        catch (Exception e) {
            massage = e.getMessage();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(massage);
        return massage;
    }

    public String deleteCar(String carID) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from car_rental_system.car where idCar =?");
            preparedStatement.setString(1, carID);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Delete done successfully";
        }
        catch (SQLException e){
            massage = e.getMessage();
        }
        catch (Exception e) {
            massage = e.getMessage();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(massage);
        return massage;
    }

    public boolean isCarExist_car_van(String carID){
        boolean match = false;
        String carIdSQL = null;
        try{
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select idCar from car_rental_system.car_van where idCar=?");
            preparedStatement.setString(1,carID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                carIdSQL = resultSet.getString(1);
                preparedStatement.close();
                resultSet.close();
                connection.close();
            }
            if (carID.equalsIgnoreCase(carIdSQL)){
                match = true;
                setTheMassage("car exist");
            }else{
                match = false;
                setTheMassage("car not exist");
            }
        }
        catch (SQLException e){
            setTheMassage(e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e) {
            setTheMassage(e.getMessage());
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(getTheMassage());
        return match;
    }

    public boolean isCarExist_car_sedan(String carID){
        boolean match = false;
        String carIdSQL = null;
        try{
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select car_sedan.idCar from car_rental_system.car_sedan where idCar=?");
            preparedStatement.setString(1,carID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                carIdSQL = resultSet.getString(1);
                preparedStatement.close();
                resultSet.close();
                connection.close();
            }
            if (carID.equalsIgnoreCase(carIdSQL)){
                match = true;
                setTheMassage("car exist");
            }else{
                match = false;
                setTheMassage("car not exist");
            }
        }
        catch (SQLException e){
            setTheMassage(e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e) {
            setTheMassage(e.getMessage());
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(getTheMassage());
        return match;
    }

    public boolean isCarExist_car(String carID){
        boolean match = false;
        String carIdSQL = null;
        try{
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select car.idCar from car_rental_system.car where idCar=?");
            preparedStatement.setString(1,carID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                carIdSQL = resultSet.getString(1);
                preparedStatement.close();
                resultSet.close();
                connection.close();
            }
            if (carID.equalsIgnoreCase(carIdSQL)){
                match = true;
                setTheMassage("car exist");
            }else{
                match = false;
                setTheMassage("car not exist");
            }
        }
        catch (SQLException e){
            setTheMassage(e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e) {
            setTheMassage(e.getMessage());
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(getTheMassage());
        return match;
    }

    public String getType(String carID){
        String carIdSQL = null;
        String typeSQL = null;
        String type = null;
        try{
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select car.idCar,car.type from car_rental_system.car where idCar=?");
            preparedStatement.setString(1,carID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                carIdSQL = resultSet.getString(1);
                typeSQL = resultSet.getString(2);
                preparedStatement.close();
                resultSet.close();
                connection.close();
            }
            if (carID.equalsIgnoreCase(carIdSQL)){
                type = typeSQL;
            }else{
                type = "car not exist";
            }
        }
        catch (SQLException e){
            type = e.getMessage();
            e.printStackTrace();
        }
        catch (Exception e) {
            type = e.getMessage();
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(type);
        return type;
    }

    public String getStatus(String carID){
        String carIdSQL = null;
        String statusSQL = null;
        String status = null;
        try{
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select car.idCar,car.status from car_rental_system.car where idCar=?");
            preparedStatement.setString(1,carID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                carIdSQL = resultSet.getString(1);
                statusSQL = resultSet.getString(2);
                preparedStatement.close();
                resultSet.close();
                connection.close();
            }
            if (carID.equalsIgnoreCase(carIdSQL)){
                status = statusSQL;
            }else{
                status = "car not exist";
            }
        }
        catch (SQLException e){
            status = e.getMessage();
            e.printStackTrace();
        }
        catch (Exception e) {
            status = e.getMessage();
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(status);
        return status;
    }

    public ArrayList<CarReference> getAll() {
        ArrayList<CarReference> all = new ArrayList<>();
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from car left join car_sedan on car.idCar = car_sedan.idCar left join car_van on car.idCar = car_van.idCar ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                all.add(new CarReference(resultSet.getString(1), resultSet.getTimestamp(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getInt(7), resultSet.getString(8), resultSet.getString(9), resultSet.getDouble(10), resultSet.getDouble(11), resultSet.getString(12), resultSet.getDouble(14), resultSet.getDouble(16), resultSet.getDouble(17)));
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return all;
    }

    public ArrayList<CarReference> getCarInfo(String carID) {
        ArrayList<CarReference> all = new ArrayList<>();
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from car left join car_sedan on car.idCar = car_sedan.idCar left join car_van on car.idCar = car_van.idCar where car.idCar=?");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                all.add(new CarReference(resultSet.getString(1), resultSet.getTimestamp(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getInt(7), resultSet.getString(8), resultSet.getString(9), resultSet.getDouble(10), resultSet.getDouble(11), resultSet.getString(12), resultSet.getDouble(14), resultSet.getDouble(16), resultSet.getDouble(17)));
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return all;
    }


    public double getCostPerDay(String carID){
        String carIdSQL = null;
        double costPerDaySQL=0 ;
        double costPerDay=0;
        try{
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select car.idCar,car.costPerDay from car_rental_system.car where idCar=?");
            preparedStatement.setString(1,carID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                carIdSQL = resultSet.getString(1);
                costPerDaySQL = resultSet.getDouble(2);
                preparedStatement.close();
                resultSet.close();
                connection.close();
            }
            if (carID.equalsIgnoreCase(carIdSQL)){
                costPerDay = costPerDaySQL;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return costPerDay;
    }

    public double getLastMeterReading(String carID){
        String carIdSQL = null;
        double lastMeterReadingSQL=0 ;
        double lastMeterReading=0;
        try{
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select car.idCar,car.lastMeterReading from car_rental_system.car where idCar=?");
            preparedStatement.setString(1,carID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                carIdSQL = resultSet.getString(1);
                lastMeterReadingSQL = resultSet.getDouble(2);
                preparedStatement.close();
                resultSet.close();
                connection.close();
            }
            if (carID.equalsIgnoreCase(carIdSQL)){
                lastMeterReading = lastMeterReadingSQL;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return lastMeterReading;
    }

    public double getCostPerKmSedan(String carID){
        String carIdSQL = null;
        double costPerKmSQL=0 ;
        double costPerKm=0;
        try{
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select car_sedan.idCar,car_sedan.costPerKm from car_rental_system.car_sedan where idCar=? ");
            preparedStatement.setString(1,carID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                carIdSQL = resultSet.getString(1);
                costPerKmSQL = resultSet.getDouble(2);
                preparedStatement.close();
                resultSet.close();
                connection.close();
            }
            if (carID.equalsIgnoreCase(carIdSQL)){
                costPerKm = costPerKmSQL;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return costPerKm;
    }
    public double getCostPerKmVan(String carID){
        String carIdSQL = null;
        double costPerKmSQL=0 ;
        double costPerKm=0;
        try{
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select car_van.idCar,car_van.costPerKm from car_rental_system.car_van where idCar=? ");
            preparedStatement.setString(1,carID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                carIdSQL = resultSet.getString(1);
                costPerKmSQL = resultSet.getDouble(2);
                preparedStatement.close();
                resultSet.close();
                connection.close();
            }
            if (carID.equalsIgnoreCase(carIdSQL)){
                costPerKm = costPerKmSQL;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return costPerKm;
    }

    public double getInsurancePerDayVan(String carID){
        String carIdSQL = null;
        double insurancePerDaySQL=0 ;
        double insurancePerDay=0;
        try{
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select car_van.idCar,car_van.insurancePerDay from car_rental_system.car_van where idCar=? ");
            preparedStatement.setString(1,carID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                carIdSQL = resultSet.getString(1);
                insurancePerDaySQL = resultSet.getDouble(2);
                preparedStatement.close();
                resultSet.close();
                connection.close();
            }
            if (carID.equalsIgnoreCase(carIdSQL)){
                insurancePerDay = insurancePerDaySQL;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return insurancePerDay;
    }
}
