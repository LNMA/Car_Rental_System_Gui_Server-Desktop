package database;

import referanceclass.AdministrativeMassageReference;
import referanceclass.NormalMassageReference;
import referanceclass.OrderReference;
import server.SBE;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Massage {
    Connection connection;


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

    public String sendMassage(String massage,String sender,String receiver){
        String notify = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.massage(massage, dateCreate, sender, receiver) values(?,?,?,?) ");
            preparedStatement.setString(1,massage);
            preparedStatement.setTimestamp(2,getDateCreate());
            preparedStatement.setString(3,sender);
            preparedStatement.setString(4,receiver);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            notify =  "Your massage was successfully sent to "+receiver;
        }
        catch (SQLException e){
            notify = e.getMessage();
        }
        catch (Exception e){
            notify = e.getMessage();
        }
        finally {
            try {
                connection.close();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(notify);
        return notify;
    }

    public String sendAdministrativeMassage(String massage,String sender){
        String notify = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.administrative_message(dateCreate, massage, sender) values(?,?,?) ");
            preparedStatement.setTimestamp(1,getDateCreate());
            preparedStatement.setString(2,massage);
            preparedStatement.setString(3,sender);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            notify =  "Your massage was successfully sent";
        }
        catch (SQLException e){
            notify = e.getMessage();
        }
        catch (Exception e){
            notify = e.getMessage();
        }
        finally {
            try {
                connection.close();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(notify);
        return notify;
    }


    private java.sql.Timestamp getDateCreate(){
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        java.sql.Timestamp dateSQL = new java.sql.Timestamp(date.getTime());
        return dateSQL;
    }

    public ArrayList<NormalMassageReference> getAllMassage(String receiver) {
        ArrayList<NormalMassageReference> all = new ArrayList<>();
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from car_rental_system.massage where receiver=? ");
            preparedStatement.setString(1,receiver);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                all.add(new NormalMassageReference(resultSet.getInt(1),resultSet.getTimestamp(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
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

    public ArrayList<AdministrativeMassageReference> getAllAdministrativeMassage() {
        ArrayList<AdministrativeMassageReference> all = new ArrayList<>();
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from car_rental_system.administrative_message");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                all.add(new AdministrativeMassageReference(resultSet.getInt(1),resultSet.getTimestamp(2),resultSet.getString(3),resultSet.getString(4)));
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

}
