package database;

import referanceclass.OrderReference;
import referanceclass.UserReference;
import server.SBE;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Order {
    Connection connection;
    String massage;

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
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

    public String addOrder(String username,String idCar,int day,double tripDistance,String paymentMethods,double bill){
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.order(username, idCar, dateCreate, day, tripDistance, paymentMethods, bill) values(?,?,?,?,?,?,?) ");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,idCar);
            preparedStatement.setTimestamp(3,getDateCreate());
            preparedStatement.setInt(4,day);
            preparedStatement.setDouble(5,tripDistance);
            preparedStatement.setString(6,paymentMethods);
            preparedStatement.setDouble(7,bill);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage =  "Order done successfully";
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
            }
            catch (Exception e){
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

    public String deleteOrder(int idOrder) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from car_rental_system.`order` where `order`.idOrder = ?");
            preparedStatement.setInt(1, idOrder);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Delete order done successfully";
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

    public String setOrderID(int oldIdOrder,int newIdOrder) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("update car_rental_system.`order` set idOrder = ? where idOrder = ?");
            preparedStatement.setInt(1, newIdOrder);
            preparedStatement.setInt(2, oldIdOrder);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Order ID Change successfully";
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

    public String setDay(int idOrder,int day) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("update car_rental_system.`order` set day = ? where idOrder = ? ");
            preparedStatement.setInt(1, day);
            preparedStatement.setInt(2, idOrder);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Day Change successfully";
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

    public String setDistance(int idOrder,double distance) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("update car_rental_system.`order` set tripDistance = ? where idOrder = ? ");
            preparedStatement.setDouble(1, distance);
            preparedStatement.setInt(2, idOrder);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Trip Distance Change successfully";
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

    public String setPaymentMethods(int idOrder,String paymentMethod) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("update car_rental_system.`order` set paymentMethods = ? where idOrder = ? ");
            preparedStatement.setString(1, paymentMethod);
            preparedStatement.setInt(2, idOrder);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Payment Methods Change successfully";
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

    public String setBill(int idOrder,double bill) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("update car_rental_system.`order` set bill = ? where idOrder = ? ");
            preparedStatement.setDouble(1, bill);
            preparedStatement.setInt(2, idOrder);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Bill Change successfully";
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



    public ArrayList<OrderReference> getAll() {
        ArrayList<OrderReference> all = new ArrayList<>();
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from car_rental_system.order left join car_rental_system.car on car.idCar = `order`.idcar ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                all.add(new OrderReference(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getTimestamp(4), resultSet.getInt(5), resultSet.getDouble(6), resultSet.getString(7), resultSet.getDouble(8), resultSet.getString(11), resultSet.getString(12), resultSet.getString(13), resultSet.getInt(14), resultSet.getInt(15), resultSet.getString(16), resultSet.getString(17)));
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

    public ArrayList<OrderReference> getOrderByUsername(String username) {
        ArrayList<OrderReference> all = new ArrayList<>();
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from car_rental_system.order left join car_rental_system.car on car.idCar = `order`.idcar where `order`.username=? ");
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                all.add(new OrderReference(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getTimestamp(4), resultSet.getInt(5), resultSet.getDouble(6), resultSet.getString(7), resultSet.getDouble(8), resultSet.getString(11), resultSet.getString(12), resultSet.getString(13), resultSet.getInt(14), resultSet.getInt(15), resultSet.getString(16), resultSet.getString(17)));
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

    public ArrayList<OrderReference> getOrderByCarID(String carID) {
        ArrayList<OrderReference> all = new ArrayList<>();
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from car_rental_system.order left join car_rental_system.car on car.idCar = `order`.idcar where `order`.idCar=? ");
            preparedStatement.setString(1,carID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                all.add(new OrderReference(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getTimestamp(4), resultSet.getInt(5), resultSet.getDouble(6), resultSet.getString(7), resultSet.getDouble(8), resultSet.getString(11), resultSet.getString(12), resultSet.getString(13), resultSet.getInt(14), resultSet.getInt(15), resultSet.getString(16), resultSet.getString(17)));
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

    public boolean isOrderExist(int orderID){
        boolean match = false;
        int orderIDSQL = 0;
        try{
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select idOrder from car_rental_system.order where idOrder=?");
            preparedStatement.setInt(1,orderID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                orderIDSQL = resultSet.getInt(1);
                preparedStatement.close();
                resultSet.close();
                connection.close();
            }
            if (orderID == (orderIDSQL)){
                match = true;
                setMassage("Order exist");
            }else{
                match = false;
                setMassage("Order not exist");
            }
        }
        catch (SQLException e){
            setMassage(e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e) {
            setMassage(e.getMessage());
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(getMassage());
        return match;
    }
}
