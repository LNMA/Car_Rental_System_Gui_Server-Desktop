package database;

import referanceclass.CarReference;
import referanceclass.UserReference;
import server.SBE;

import java.sql.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class User {
    Connection connection;
    String aMassage;

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

    public String signUpClient(String username,String password){
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.account(username, password, type, dateCreate) values(?,?,?,?) ");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,"client");
            preparedStatement.setTimestamp(4,getDateCreate());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage =  "Sign Up successfully";
        }
        catch (SQLIntegrityConstraintViolationException e){
            massage = "username already used, try another one";
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

    public String signUpSupervisor(String username,String password){
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.account(username, password, type, dateCreate) values(?,?,?,?) ");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,"supervisor");
            preparedStatement.setTimestamp(4,getDateCreate());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage =  "Sign Up successfully";
        }
        catch (SQLIntegrityConstraintViolationException e){
            massage = "username already used, try another one";
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

    public String signUpRoot(String username,String password){
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.account(username, password, type, dateCreate) values(?,?,?,?) ");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,"root");
            preparedStatement.setTimestamp(4,getDateCreate());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage =  "Sign Up successfully";
        }
        catch (SQLIntegrityConstraintViolationException e){
            massage = "username already used, try another one";
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

    public String setAccountDetails(String username,String firstName,String lastName,String gender,int year,int month,int day,int telephone,String email,String address) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.account_detail(username, firstName, lastName, gender, age, telephone, email, address, status) values (?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, setAgeLocalDate(year,month,day));
            preparedStatement.setInt(6, telephone);
            preparedStatement.setString(7, email);
            preparedStatement.setString(8, address);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "inset done successfully";
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

    public String setFirstName(String username,String name) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.account_detail(username,firstName) VALUES (?,?) ON DUPLICATE KEY UPDATE firstname=? ");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, name);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "First Name insert successfully";
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

    public String setLastName(String username,String name) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.account_detail(username,lastName) VALUES (?,?) ON DUPLICATE KEY UPDATE lastName=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, name);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Last Name insert successfully";
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

    public String setGender(String username,String gender) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.account_detail(username,gender) VALUES (?,?) ON DUPLICATE KEY UPDATE gender=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, gender);
            preparedStatement.setString(3, gender);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Gender insert successfully";
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

    public String setAge(String username,int year,int month,int day) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.account_detail(username,age) VALUES (?,?) ON DUPLICATE KEY UPDATE age=?");
            preparedStatement.setString(1, username);
            String age = setAgeLocalDate(year,month,day);
            preparedStatement.setString(2, age);
            preparedStatement.setString(3, age);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Age insert successfully";
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

    private String setAgeLocalDate(int year,int month,int day) {
        String myAge = null;
        int myMonth;
        int myYear;
        LocalDate birthDate ;
        LocalDate now ;
        try {
            birthDate = LocalDate.of(year, month, day);
            now = LocalDate.now();
            myYear = birthDate.until(now).getYears();
            myMonth = birthDate.until(now).getMonths();
            int myDay = birthDate.until(now).getDays();
            myAge = myYear+ " Year, " + myMonth + " Month, " + myDay+" Day";
        }
        catch (DateTimeException e){
            myAge = e.getMessage();
        }
        System.out.println(myAge);
        return myAge;
    }

    public String setTelephone(String username,int telephone) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.account_detail(username,telephone) VALUES (?,?) ON DUPLICATE KEY UPDATE telephone=?");
            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, telephone);
            preparedStatement.setInt(3, telephone);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Telephone number insert successfully";
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

    public String setEmail(String username,String email) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.account_detail(username,email) VALUES (?,?) ON DUPLICATE KEY UPDATE email=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "email insert successfully";
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

    public String setAddress(String username,String address) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.account_detail(username,address) VALUES (?,?) ON DUPLICATE KEY UPDATE address=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, address);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Address insert successfully";
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

    public String setStatus(String username,String status) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.account_detail(username,status) VALUES (?,?) ON DUPLICATE KEY UPDATE status=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, status);
            preparedStatement.setString(3, status);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = username +" Now is: "+status;
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

    public String setLicenseValidity(String username,String licenseValidity) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.account_client_detail(username,licenseValidity) VALUES (?,?) ON DUPLICATE KEY UPDATE licenseValidity=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, licenseValidity);
            preparedStatement.setString(3, licenseValidity);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = username +" license status is: "+licenseValidity;
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

    public String setDiscountPoint(String username,int discountPoint) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.account_client_detail(username,discountPoint) VALUES (?,?) ON DUPLICATE KEY UPDATE discountPoint=?");
            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, discountPoint);
            preparedStatement.setInt(3, discountPoint);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Discount point changed successfully";
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

    public String setTotalBills(String username,double totalBills) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.account_client_detail(username,totalBills) VALUES (?,?) ON DUPLICATE KEY UPDATE totalBills=?");
            preparedStatement.setString(1, username);
            preparedStatement.setDouble(2, totalBills);
            preparedStatement.setDouble(3, totalBills);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Total Bills changed successfully";
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

    public String setRank(String username,String rank) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.account_supervisor_detail(username,`rank`) VALUES (?,?) ON DUPLICATE KEY UPDATE `rank`=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, rank);
            preparedStatement.setString(3, rank);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Rank insert successfully";
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

    public String setSection(String username,String section) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car_rental_system.account_supervisor_detail(username,section) VALUES (?,?) ON DUPLICATE KEY UPDATE section=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, section);
            preparedStatement.setString(3, section);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Section insert successfully";
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

    public String getAMassage() {
        return aMassage;
    }

    public void setAMassage(String aMassage) {
        this.aMassage = aMassage;
    }

    public boolean signIn(String username, String password){
        boolean match = false;
        String usernameSQL = null;
        String passwordSQL = null;
        try{
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select username,password from car_rental_system.account where username=? and password =?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                usernameSQL = resultSet.getString(1);
                passwordSQL = resultSet.getString(2);
                preparedStatement.close();
                resultSet.close();
                connection.close();
            }
            if (username.equalsIgnoreCase(usernameSQL) && password.equals(passwordSQL)){
                match = true;
                setAMassage("Welcome...");
            }else{
                match = false;
                setAMassage("It's seem something wrong in your username or password");
            }
        }
        catch (SQLException e){
           setAMassage(e.getMessage());
        }
        catch (Exception e) {
            setAMassage(e.getMessage());
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(getAMassage());
        return match;
    }

    public boolean isThisUser(String username, String password){
        boolean match = false;
        String usernameSQL = null;
        String passwordSQL = null;
        try{
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select username,password from car_rental_system.account where username=? and password =?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                usernameSQL = resultSet.getString(1);
                passwordSQL = resultSet.getString(2);
                preparedStatement.close();
                resultSet.close();
                connection.close();
            }
            if (username.equalsIgnoreCase(usernameSQL) && password.equals(passwordSQL)){
                match = true;
                setAMassage("No Problem");
            }else{
                match = false;
                setAMassage("It's seem something wrong in your username or password");
            }
        }
        catch (SQLException e){
            setAMassage(e.getMessage());
        }
        catch (Exception e) {
            setAMassage(e.getMessage());
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(getAMassage());
        return match;
    }

    public String getType(String username, String password){
        String type = null;
        String typeSQL = null;
        String usernameSQL = null;
        String passwordSQL = null;
        try{
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select username,password,type from car_rental_system.account where username=? and password =?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                usernameSQL = resultSet.getString(1);
                passwordSQL = resultSet.getString(2);
                typeSQL = resultSet.getString(3);
                preparedStatement.close();
                resultSet.close();
                connection.close();
            }
            if (username.equalsIgnoreCase(usernameSQL) && password.equals(passwordSQL)){
                type = typeSQL;
            }else{
                type = "Account does not exist";
            }
        }
        catch (SQLException e){
            type = e.getMessage();
        }
        catch (Exception e) {
            type = e.getMessage();
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

    public boolean isAccountExist(String username){
        boolean match = false;
        String usernameSQL = null;
        try{
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select username from car_rental_system.account where username=?");
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                usernameSQL = resultSet.getString(1);
                preparedStatement.close();
                resultSet.close();
                connection.close();
            }
            if (username.equalsIgnoreCase(usernameSQL)){
                match = true;
                setAMassage("Account exist");
            }else{
                match = false;
                setAMassage("Account not exist");
            }
        }
        catch (SQLException e){
            setAMassage(e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e) {
            setAMassage(e.getMessage());
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(getAMassage());
        return match;
    }

    public String deleteAccount(String username) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from car_rental_system.account where username =?");
            preparedStatement.setString(1, username);
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

    public String updateUsername(String oldUsername,String newUsername) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("update car_rental_system.account set username=? where username=?");
            preparedStatement.setString(1, newUsername);
            preparedStatement.setString(2, oldUsername);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Username change successfully";
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

    public String updatePassword(String username,String password) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("update car_rental_system.account set password=? where username=?");
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Password change successfully";
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

    public String updateType(String username,String type) {
        String massage = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("update car_rental_system.account set type=? where username=?");
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            massage = "Type change successfully";
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

    public String getExistType(String username){
        String usernameSQL = null;
        String typeSQL = null;
        String type = null;
        try{
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select username,type from car_rental_system.account where username=?");
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                usernameSQL = resultSet.getString(1);
                typeSQL = resultSet.getString(2);
                preparedStatement.close();
                resultSet.close();
                connection.close();
            }
            if (username.equalsIgnoreCase(usernameSQL)){
                type = typeSQL;
            }else{
                type = "Account is not exists";
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

    public ArrayList<UserReference> getAll() {
        ArrayList<UserReference> all = new ArrayList<>();
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from car_rental_system.account left join account_detail on account.username = account_detail.username left join account_client_detail on account.username = account_client_detail.username left join account_supervisor_detail on account.username = account_supervisor_detail.username");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                all.add(new UserReference(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getTimestamp(4), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getInt(10), resultSet.getString(11), resultSet.getString(12), resultSet.getString(13), resultSet.getString(15), resultSet.getInt(16), resultSet.getDouble(17),resultSet.getString(19), resultSet.getString(20)));
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

    public ArrayList<UserReference> getAllClient() {
        ArrayList<UserReference> all = new ArrayList<>();
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from car_rental_system.account left join account_detail on account.username = account_detail.username left join account_client_detail on account.username = account_client_detail.username left join account_supervisor_detail on account.username = account_supervisor_detail.username where account.type='client'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                all.add(new UserReference(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getTimestamp(4), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getInt(10), resultSet.getString(11), resultSet.getString(12), resultSet.getString(13), resultSet.getString(15), resultSet.getInt(16), resultSet.getDouble(17),resultSet.getString(19), resultSet.getString(20)));
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

    public ArrayList<UserReference> getUserInfo(String username) {
        ArrayList<UserReference> all = new ArrayList<>();
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from car_rental_system.account left join account_detail on account.username = account_detail.username left join account_client_detail on account.username = account_client_detail.username left join account_supervisor_detail on account.username = account_supervisor_detail.username where account.username=? ");
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                all.add(new UserReference(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getTimestamp(4), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getInt(10), resultSet.getString(11), resultSet.getString(12), resultSet.getString(13), resultSet.getString(15), resultSet.getInt(16), resultSet.getDouble(17),resultSet.getString(19), resultSet.getString(20)));
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

    public String getLicenseValidity(String username){
        String usernameSQL = null;
        String licenseValiditySQL = null;
        String licenseValidity = null;
        try{
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select account_client_detail.username,account_client_detail.licenseValidity from car_rental_system.account_client_detail where username=?");
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                usernameSQL = resultSet.getString(1);
                licenseValiditySQL = resultSet.getString(2);
                preparedStatement.close();
                resultSet.close();
                connection.close();
            }
            if (username.equalsIgnoreCase(usernameSQL)){
                licenseValidity = licenseValiditySQL;
            }else{
                licenseValidity = "Account is not exists";
            }
        }
        catch (SQLException e){
            licenseValidity = e.getMessage();
            e.printStackTrace();
        }
        catch (Exception e) {
            licenseValidity = e.getMessage();
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(licenseValidity);
        return licenseValidity;
    }

    public int getDiscountPoint(String username){
        String usernameSQL = null;
        int discountPointSQL = 0;
        int discountPoint = 0;
        try{
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select account_client_detail.username,account_client_detail.discountPoint from car_rental_system.account_client_detail where username=?");
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                usernameSQL = resultSet.getString(1);
                discountPointSQL = resultSet.getInt(2);
                preparedStatement.close();
                resultSet.close();
                connection.close();
            }
            if (username.equalsIgnoreCase(usernameSQL)){
                discountPoint = discountPointSQL;
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
        return discountPoint;
    }

    public double getTotalBills(String username){
        String usernameSQL = null;
        double totalBillsSQL = 0;
        double totalBills = 0;
        try{
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select account_client_detail.username,account_client_detail.totalBills from car_rental_system.account_client_detail where username=?");
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                usernameSQL = resultSet.getString(1);
                totalBillsSQL = resultSet.getInt(2);
                preparedStatement.close();
                resultSet.close();
                connection.close();
            }
            if (username.equalsIgnoreCase(usernameSQL)){
                totalBills = totalBillsSQL;
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
        return totalBills;
    }

    public String getTypeRoot(String username) {
        String type = null;
        String typeSQL = null;
        String usernameSQL = null;
        try {
            connect();
            PreparedStatement preparedStatement = connection.prepareStatement("select username,type from car_rental_system.account where username=?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                usernameSQL = resultSet.getString(1);
                typeSQL = resultSet.getString(2);
                preparedStatement.close();
                resultSet.close();
                connection.close();
            }
            if (username.equalsIgnoreCase(usernameSQL)) {
                type = typeSQL;
            } else {
                type = "Account does not exist";
            }
        } catch (SQLException e) {
            type = e.getMessage();
        } catch (Exception e) {
            type = e.getMessage();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(type);
        return type;
    }



}
