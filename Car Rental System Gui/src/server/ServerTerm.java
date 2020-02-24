package server;

import database.Car;
import database.Massage;
import database.Order;
import database.User;
import referanceclass.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.RandomAccess;

public class ServerTerm {
    private static Socket socket;
    private static ServerSocket server;
    private static User user = new User();
    private static Car car = new Car();
    private static Order order = new Order();
    private static Massage massage = new Massage();

    public static void main(String[] args) {
        Thread tBase = new Thread(() -> {
            try {
                server = new ServerSocket(SBE.getServerPort());
                while (true) {
                    socket = server.accept();
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    String operation = in.readUTF();
                    switch (operation) {
                        case "0rx0s1u":
                            SignUp signUp = new SignUp(socket, user);
                            Thread t1 = new Thread(signUp);
                            t1.start();
                            break;
                        case "1rx1s2i":
                            SignIn signIn = new SignIn(socket, user);
                            Thread t2 = new Thread(signIn);
                            t2.start();
                            break;
                        case "0cx0add1all":
                            AddCar addCar = new AddCar(socket, car);
                            Thread t3 = new Thread(addCar);
                            t3.start();
                            break;
                        case "1cx1edit2all":
                            EditCar editCar = new EditCar(socket, car);
                            Thread t4 = new Thread(editCar);
                            t4.start();
                            break;
                        case "0ux0add1all":
                            AddAccount addAccount = new AddAccount(socket, user);
                            Thread t5 = new Thread(addAccount);
                            t5.start();
                            break;
                        case "1ux1edit2all":
                            EditAccount editAccount = new EditAccount(socket, user);
                            Thread t6 = new Thread(editAccount);
                            t6.start();
                            break;
                        case "0ox0add1order":
                            AddOrder addOrder = new AddOrder(socket, order, car, user);
                            Thread t7 = new Thread(addOrder);
                            t7.start();
                            break;
                        case "1ox1show2order":
                            ShowOrder showOrder = new ShowOrder(socket, order);
                            Thread t8 = new Thread(showOrder);
                            t8.start();
                            break;
                        case "2ox2edit3all":
                            EditOrder editOrder = new EditOrder(socket, order);
                            Thread t9 = new Thread(editOrder);
                            t9.start();
                            break;
                        case "2ux1supervisor2edit3all":
                            EditAccountSupervisor editAccountSupervisor = new EditAccountSupervisor(socket, user);
                            Thread t10 = new Thread(editAccountSupervisor);
                            t10.start();
                            break;
                        case "2rx3change4client":
                            ClientChangeMainKey clientChangeMainKey = new ClientChangeMainKey(socket, user);
                            Thread t11 = new Thread(clientChangeMainKey);
                            t11.start();
                            break;
                        case "0mx1massage2system":
                            MassageSystem massageSystem = new MassageSystem(socket, massage, user);
                            Thread t12 = new Thread(massageSystem);
                            t12.start();
                            break;
                        case "00xxxserver":
                            BackEndServer backEndServer = new BackEndServer(socket);
                            Thread t13 = new Thread(backEndServer);
                            t13.start();
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        });
        tBase.start();
    }
}

class BackEndServer implements Runnable{
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public BackEndServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            String operation = in.readUTF();
            switch (operation) {
                case "xx0server0port":
                    int port = in.readInt();
                    SBE.setServerPort(port);
                    break;
                case "xx0db0url":
                    String url = in.readUTF();
                    SBE.setDbUrl(url);
                    break;
                case "xx0db0user":
                    String user = in.readUTF();
                    SBE.setDbUser(user);
                    break;
                case "xx0db0password":
                    String password = in.readUTF();
                    SBE.setDbPassword(password);
                    break;
                case "gx0server0port":
                    out.writeInt(SBE.getServerPort());
                    break;
                case "gx0db0url":
                    out.writeUTF(SBE.getDbUrl());
                    break;
                case "gx0db0user":
                    out.writeUTF(SBE.getDbUser());
                    break;
                case "gx0db0password":
                    out.writeUTF(SBE.getDbPassword());
                    break;
            }
            out.flush();
            in.close();
            out.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally{
            try{
                in.close();
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}

class MassageSystem implements Runnable {
    private Socket socket;
    private Massage massage;
    private User user;
    private DataInputStream in;
    private DataOutputStream out;

    public MassageSystem(Socket socket, Massage massage, User user) {
        this.socket = socket;
        this.massage = massage;
        this.user = user;
    }

    @Override
    public void run() {
        String username;
        String isExistMassage;
        boolean isExist;
        String myMassage ;
        String sender;
        String receiver;
        try {
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            String operation = in.readUTF();
            switch (operation) {
                case "0normal1massage1send":
                    receiver = in.readUTF();
                    sender = in.readUTF();
                    myMassage = in.readUTF();
                    isExist = user.isAccountExist(receiver);
                    isExistMassage = user.getAMassage();
                    if (isExist){
                        out.writeUTF(isExistMassage);
                        out.writeUTF(massage.sendMassage(myMassage,sender,receiver));
                    }else {
                        out.writeUTF(isExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "1administrative2massage2send":
                    sender = in.readUTF();
                    myMassage = in.readUTF();
                    out.writeUTF("");
                    out.writeUTF(massage.sendAdministrativeMassage(myMassage,sender));
                    break;
                case "2normal3massage4show":
                    receiver = in.readUTF();
                    ArrayList<NormalMassageReference> showAllMassage = new ArrayList<>(massage.getAllMassage(receiver));
                    out.writeInt(showAllMassage.size());
                    ObjectOutputStream outObject = new ObjectOutputStream(out);
                    for (NormalMassageReference ref:showAllMassage) {
                        outObject.writeObject(ref);
                    }
                    outObject.flush();
                    outObject.close();
                    break;
                case "3administrative4massage5show":
                    ArrayList<AdministrativeMassageReference> showAllAdministrative = new ArrayList<>(massage.getAllAdministrativeMassage());
                    out.writeInt(showAllAdministrative.size());
                    ObjectOutputStream outObject1 = new ObjectOutputStream(out);
                    for (AdministrativeMassageReference ref:showAllAdministrative) {
                        outObject1.writeObject(ref);
                    }
                    outObject1.flush();
                    outObject1.close();
                    break;
            }

            out.flush();
            in.close();
            out.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            try{
                in.close();
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

class ClientChangeMainKey implements Runnable{
    private Socket socket;
    private User user;
    private DataInputStream in;
    private DataOutputStream out;

    public ClientChangeMainKey(Socket socket, User user) {
        this.socket = socket;
        this.user = user;
    }

    @Override
    public void run() {
        String username;
        String password;
        String isExistMassage;
        boolean isExist;
        try{
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            String operation = in.readUTF();
            switch (operation) {
                case "1change2username":
                    username = in.readUTF();
                    String newUsername = in.readUTF();
                    password = in.readUTF();
                    isExist = user.isThisUser(username,password);
                    isExistMassage = user.getAMassage();
                    if (isExist){
                        out.writeUTF(isExistMassage);
                        out.writeUTF(user.updateUsername(username,newUsername));
                    }else{
                        out.writeUTF(isExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "2change3password":
                    username = in.readUTF();
                    password = in.readUTF();
                    String newPassword = in.readUTF();
                    isExist = user.isThisUser(username,password);
                    isExistMassage = user.getAMassage();
                    if (isExist){
                        out.writeUTF(isExistMassage);
                        out.writeUTF(user.updatePassword(username,newPassword));
                    }else{
                        out.writeUTF(isExistMassage);
                        out.writeUTF("");
                    }
                    break;

            }
            out.flush();
            in.close();
            out.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            try{
                in.close();
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

class EditAccountSupervisor implements Runnable {
    private Socket socket;
    private User user;
    private DataInputStream in;
    private DataOutputStream out;

    public EditAccountSupervisor(Socket socket, User user) {
        this.socket = socket;
        this.user = user;
    }

    @Override
    public void run() {
        String username;
        boolean isAccountExist;
        String isAccountExistMassage;
        String typeExist;
        try {
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            String operation = in.readUTF();
            switch (operation) {
                case "1edit2delete":
                    username = in.readUTF();
                    typeExist = user.getExistType(username);
                    if (typeExist.equals("client")) {
                        out.writeUTF(typeExist);
                        out.writeUTF(user.deleteAccount(username));
                    } else {
                        out.writeUTF("Something wrong Or you do not have permission to perform this operation");
                        out.writeUTF("");
                    }
                    break;
                case "1edit3username":
                    username = in.readUTF();
                    String newUsername = in.readUTF();
                    typeExist = user.getExistType(username);
                    if (typeExist.equals("client")) {
                        out.writeUTF(typeExist);
                        out.writeUTF(user.updateUsername(username, newUsername));
                    } else {
                        out.writeUTF("Something wrong Or you do not have permission to perform this operation");
                        out.writeUTF("");
                    }
                    break;
                case "1edit4password":
                    username = in.readUTF();
                    String password = in.readUTF();
                    typeExist = user.getExistType(username);
                    if (typeExist.equals("client")) {
                        out.writeUTF(typeExist);
                        out.writeUTF(user.updatePassword(username, password));
                    } else {
                        out.writeUTF("Something wrong Or you do not have permission to perform this operation");
                        out.writeUTF("");
                    }
                    break;
                case "1edit5firstName":
                    username = in.readUTF();
                    String firstName = in.readUTF();
                    typeExist = user.getExistType(username);
                    if (typeExist.equals("client")) {
                        out.writeUTF(typeExist);
                        out.writeUTF(user.setFirstName(username, firstName));
                    } else {
                        out.writeUTF("Something wrong Or you do not have permission to perform this operation");
                        out.writeUTF("");
                    }
                    break;
                case "1edit6lastName":
                    username = in.readUTF();
                    String lastName = in.readUTF();
                    typeExist = user.getExistType(username);
                    if (typeExist.equals("client")) {
                        out.writeUTF(typeExist);
                        out.writeUTF(user.setLastName(username, lastName));
                    } else {
                        out.writeUTF("Something wrong Or you do not have permission to perform this operation");
                        out.writeUTF("");
                    }
                    break;
                case "1edit7gender":
                    username = in.readUTF();
                    String gender = in.readUTF();
                    typeExist = user.getExistType(username);
                    if (typeExist.equals("client")) {
                        out.writeUTF(typeExist);
                        out.writeUTF(user.setGender(username, gender));
                    } else {
                        out.writeUTF("Something wrong Or you do not have permission to perform this operation");
                        out.writeUTF("");
                    }
                    break;
                case "1edit8telephone":
                    username = in.readUTF();
                    int telephone = in.readInt();
                    typeExist = user.getExistType(username);
                    if (typeExist.equals("client")) {
                        out.writeUTF(typeExist);
                        out.writeUTF(user.setTelephone(username, telephone));
                    } else {
                        out.writeUTF("Something wrong Or you do not have permission to perform this operation");
                        out.writeUTF("");
                    }
                    break;
                case "1edit9availability":
                    username = in.readUTF();
                    String availability = in.readUTF();
                    typeExist = user.getExistType(username);
                    if (typeExist.equals("client")) {
                        out.writeUTF(typeExist);
                        out.writeUTF(user.setStatus(username, availability));
                    } else {
                        out.writeUTF("Something wrong Or you do not have permission to perform this operation");
                        out.writeUTF("");
                    }
                    break;
                case "1edit10address":
                    username = in.readUTF();
                    String address = in.readUTF();
                    typeExist = user.getExistType(username);
                    if (typeExist.equals("client")) {
                        out.writeUTF(typeExist);
                        out.writeUTF(user.setAddress(username, address));
                    } else {
                        out.writeUTF("Something wrong Or you do not havepermission to perform this operation");
                        out.writeUTF("");
                    }
                    break;
                case "1edit11age":
                    username = in.readUTF();
                    int year = in.readInt();
                    int month = in.readInt();
                    int day = in.readInt();
                    typeExist = user.getExistType(username);
                    if (typeExist.equals("client")) {
                        out.writeUTF(typeExist);
                        out.writeUTF(user.setAge(username, year, month, day));
                    } else {
                        out.writeUTF("Something wrong Or you do not have permission to perform this operation");
                        out.writeUTF("");
                    }
                    break;
                case "1edit12validity":
                    username = in.readUTF();
                    String validity = in.readUTF();
                    typeExist = user.getExistType(username);
                    if (typeExist.equals("client")) {
                        out.writeUTF(typeExist);
                        out.writeUTF(user.setLicenseValidity(username, validity));
                    } else {
                        out.writeUTF("Something wrong Or you do not have permission to perform this operation");
                        out.writeUTF("");
                    }
                    break;
                case "1edit13point":
                    username = in.readUTF();
                    int point = in.readInt();
                    typeExist = user.getExistType(username);
                    if (typeExist.equals("client")) {
                        out.writeUTF(typeExist);
                        out.writeUTF(user.setDiscountPoint(username, point));
                    } else {
                        out.writeUTF("Something wrong Or you do not have permission to perform this operation");
                        out.writeUTF("");
                    }
                    break;
                case "1edit17showAllClient":
                    ArrayList<UserReference> showAll = new ArrayList<>(user.getAllClient());
                    out.writeInt(showAll.size());
                    ObjectOutputStream outObject = new ObjectOutputStream(out);
                    for (UserReference ref:showAll) {
                        outObject.writeObject(ref);
                    }
                    outObject.flush();
                    outObject.close();
                    break;
                case "2edit20totalBills":
                    username = in.readUTF();
                    double totalBills = in.readDouble();
                    typeExist = user.getExistType(username);
                    if (typeExist.equals("client")) {
                        out.writeUTF(typeExist);
                        out.writeUTF(user.setTotalBills(username, totalBills));
                    } else {
                        out.writeUTF("Something wrong Or you do not have permission to perform this operation");
                        out.writeUTF("");
                    }
                    break;
            }
            out.flush();
            in.close();
            out.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


class EditOrder implements Runnable{
    private Socket socket;
    private Order order;
    private DataInputStream in;
    private DataOutputStream out;

    public EditOrder(Socket socket, Order order) {
        this.socket = socket;
        this.order = order;
    }

    @Override
    public void run() {
        int orderId = -1;
        boolean isOrderExist;
        String isOrderExistMassage;
        try{
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            String operation = in.readUTF();
            switch (operation){
                case "1edit2remove":
                    orderId = in.readInt();
                    out.writeUTF(order.deleteOrder(orderId));
                    break;
                case "2edit3day":
                    orderId = in.readInt();
                    int day = in.readInt();
                    isOrderExist = order.isOrderExist(orderId);
                    isOrderExistMassage = order.getMassage();
                    if (isOrderExist) {
                        out.writeUTF(isOrderExistMassage);
                        out.writeUTF(order.setDay(orderId,day));
                    } else {
                        out.writeUTF(isOrderExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "2edit4distance":
                    orderId = in.readInt();
                    double distance = in.readDouble();
                    isOrderExist = order.isOrderExist(orderId);
                    isOrderExistMassage = order.getMassage();
                    if (isOrderExist) {
                        out.writeUTF(isOrderExistMassage);
                        out.writeUTF(order.setDistance(orderId,distance));
                    } else {
                        out.writeUTF(isOrderExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "2edit5payment":
                    orderId = in.readInt();
                    String paymentMethods = in.readUTF();
                    isOrderExist = order.isOrderExist(orderId);
                    isOrderExistMassage = order.getMassage();
                    if (isOrderExist) {
                        out.writeUTF(isOrderExistMassage);
                        out.writeUTF(order.setPaymentMethods(orderId,paymentMethods));
                    } else {
                        out.writeUTF(isOrderExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "2edit6bill":
                    orderId = in.readInt();
                    double bill = in.readDouble();
                    isOrderExist = order.isOrderExist(orderId);
                    isOrderExistMassage = order.getMassage();
                    if (isOrderExist) {
                        out.writeUTF(isOrderExistMassage);
                        out.writeUTF(order.setBill(orderId,bill));
                    } else {
                        out.writeUTF(isOrderExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "2edit7id":
                    orderId = in.readInt();
                    int newOrderId = in.readInt();
                    isOrderExist = order.isOrderExist(orderId);
                    isOrderExistMassage = order.getMassage();
                    if (isOrderExist) {
                        out.writeUTF(isOrderExistMassage);
                        out.writeUTF(order.setOrderID(orderId,newOrderId));
                    } else {
                        out.writeUTF(isOrderExistMassage);
                        out.writeUTF("");
                    }
                    break;
            }
            out.flush();
            in.close();
            out.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

class ShowOrder implements Runnable{
    private Socket socket;
    private Order order;
    private DataInputStream in;
    private DataOutputStream out;

    public ShowOrder(Socket socket, Order order) {
        this.socket = socket;
        this.order = order;
    }

    @Override
    public void run() {
        String username;
        String carID;
        try{
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            String operation = in.readUTF();
            switch (operation){
                case "1show1byUsername":
                    username = in.readUTF();
                    ArrayList<OrderReference> showByUsername = new ArrayList<>(order.getOrderByUsername(username));
                    int showByUsernameSize= showByUsername.size();
                    out.writeInt(showByUsernameSize);
                    ObjectOutputStream outObjectInfo = new ObjectOutputStream(out);
                    for (OrderReference ref:showByUsername) {
                        outObjectInfo.writeObject(ref);
                    }
                    outObjectInfo.flush();
                    outObjectInfo.close();
                    break;
                case "2show2byCarId":
                    carID = in.readUTF();
                    ArrayList<OrderReference> showByCarID = new ArrayList<>(order.getOrderByCarID(carID));
                    int showByCarIDSize= showByCarID.size();
                    out.writeInt(showByCarIDSize);
                    ObjectOutputStream outObjectByCarInfo = new ObjectOutputStream(out);
                    for (OrderReference ref:showByCarID) {
                        outObjectByCarInfo.writeObject(ref);
                    }
                    outObjectByCarInfo.flush();
                    outObjectByCarInfo.close();
                    break;
                case "3show3all":
                    ArrayList<OrderReference> showAll= new ArrayList<>(order.getAll());
                    int showAllSize= showAll.size();
                    out.writeInt(showAllSize);
                    ObjectOutputStream outObjectAll = new ObjectOutputStream(out);
                    for (OrderReference ref:showAll) {
                        outObjectAll.writeObject(ref);
                    }
                    outObjectAll.flush();
                    outObjectAll.close();
                    break;
            }
            out.flush();
            in.close();
            out.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}


class AddOrder implements Runnable {
    private Socket socket;
    private Order order;
    private Car car;
    private User user;
    private DataInputStream in;
    private DataOutputStream out;

    public AddOrder(Socket socket, Order order, Car car, User user) {
        this.socket = socket;
        this.order = order;
        this.car = car;
        this.user = user;
    }

    @Override
    public void run() {
        String username;
        String carID;
        int day;
        double distance;
        String paymentMethod;
        double discount;
        double pointPercentage;
        double bill;
        double newBills;
        int myPoint;
        String type;
        String operation;
        String status;
        String userType;
        String licenseValidity;
        int discountPoint;
        double totalBills;
        double costPerDay;
        double costPerKm;
        double lastMeter;
        double netLastMeter;
        double insurancePerDay;
        try {
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            operation = in.readUTF();
            switch (operation) {
                case "1discount2point":
                    username = in.readUTF();
                    discountPoint = user.getDiscountPoint(username);
                    if (discountPoint > 0) {
                        out.writeBoolean(true);
                    } else {
                        out.writeBoolean(false);
                    }
                    out.flush();
                    break;

                case "1make3Order":
                    username = in.readUTF();
                    carID = in.readUTF();
                    day = in.readInt();
                    distance = in.readDouble();
                    paymentMethod = in.readUTF();
                    myPoint = in.readInt();
                    System.out.println(myPoint);
                    type = car.getType(carID);
                    status = car.getStatus(carID);
                    userType = user.getTypeRoot(username);
                    licenseValidity = user.getLicenseValidity(username);
                    totalBills = user.getTotalBills(username);
                    discountPoint = user.getDiscountPoint(username);
                    if (userType.equals("client")) {
                        if (licenseValidity.equals("Valid")) {
                            if (status.equals("Available")) {
                                if (type.equals("Compact") || type.equals("Sedan") || type.equals("Van")) {
                                    if (type.equals("Compact")) {
                                        costPerDay = car.getCostPerDay(carID);
                                        lastMeter = car.getLastMeterReading(carID);
                                        netLastMeter = lastMeter + distance;
                                        car.setLastMeterReading(carID, netLastMeter);
                                        car.setStatus(carID, "Unavailable");
                                        bill = costPerDay * day;
                                        newBills = bill;
                                        if ((myPoint > 0) && (myPoint <= discountPoint)) {
                                            discountPoint -= myPoint;
                                            user.setDiscountPoint(username, discountPoint);
                                            pointPercentage = ((double)myPoint) / 100;
                                            discount = pointPercentage * bill;
                                            newBills -= discount;
                                            totalBills += newBills;
                                            user.setTotalBills(username, totalBills);
                                            setDiscountPoint(username, totalBills, discountPoint);
                                            out.writeUTF(order.addOrder(username, carID, day, distance, paymentMethod, bill));
                                            out.writeUTF("Order Bill was: " + bill + " $");
                                            out.writeUTF("Order Bill Becomes after using your Point is: " + newBills + " $");
                                            out.flush();
                                        } else {
                                            totalBills += bill;
                                            user.setTotalBills(username, totalBills);
                                            setDiscountPoint(username, totalBills, discountPoint);
                                            out.writeUTF(order.addOrder(username, carID, day, distance, paymentMethod, bill));
                                            out.writeUTF("Order Bill is: " + bill + " $");
                                            out.writeUTF("");
                                            out.flush();
                                        }
                                    }
                                    if (type.equals("Sedan")) {
                                        costPerKm = car.getCostPerKmSedan(carID);
                                        costPerDay = car.getCostPerDay(carID);
                                        lastMeter = car.getLastMeterReading(carID);
                                        netLastMeter = lastMeter + distance;
                                        car.setLastMeterReading(carID, netLastMeter);
                                        car.setStatus(carID, "Unavailable");
                                        bill = (costPerDay * day) + (distance * costPerKm);
                                        newBills = bill;
                                        if ((myPoint > 0) && (myPoint <= discountPoint)) {
                                            discountPoint -= myPoint;
                                            user.setDiscountPoint(username, discountPoint);
                                            pointPercentage = ((double)myPoint) / 100;
                                            discount = pointPercentage * bill;
                                            newBills -= discount;
                                            totalBills += newBills;
                                            user.setTotalBills(username, totalBills);
                                            setDiscountPoint(username, totalBills, discountPoint);
                                            out.writeUTF(order.addOrder(username, carID, day, distance, paymentMethod, bill));
                                            out.writeUTF("Order Bill was: " + bill + " $");
                                            out.writeUTF("Order Bill Becomes after using your Point is: " + newBills + " $");
                                            out.flush();
                                        } else {
                                            totalBills += bill;
                                            user.setTotalBills(username, totalBills);
                                            setDiscountPoint(username, totalBills, discountPoint);
                                            out.writeUTF(order.addOrder(username, carID, day, distance, paymentMethod, bill));
                                            out.writeUTF("Order Bill is: " + bill + " $");
                                            out.writeUTF("");
                                            out.flush();
                                        }
                                    }
                                    if (type.equals("Van")) {
                                        insurancePerDay = car.getInsurancePerDayVan(carID);
                                        costPerKm = car.getCostPerKmVan(carID);
                                        costPerDay = car.getCostPerDay(carID);
                                        lastMeter = car.getLastMeterReading(carID);
                                        netLastMeter = lastMeter + distance;
                                        car.setLastMeterReading(carID, netLastMeter);
                                        car.setStatus(carID, "Unavailable");
                                        bill = (costPerDay * day) + (distance * costPerKm) + (day * insurancePerDay);
                                        newBills = bill;
                                        if ((myPoint > 0) && (myPoint <= discountPoint)) {
                                            discountPoint -= myPoint;
                                            user.setDiscountPoint(username, discountPoint);
                                            pointPercentage = ((double)myPoint) / 100;
                                            discount = pointPercentage * bill;
                                            newBills -= discount;
                                            totalBills += newBills;
                                            user.setTotalBills(username, totalBills);
                                            setDiscountPoint(username, totalBills, discountPoint);
                                            out.writeUTF(order.addOrder(username, carID, day, distance, paymentMethod, bill));
                                            out.writeUTF("Order Bill was: " + bill + " $");
                                            out.writeUTF("Order Bill Becomes after using your Point is: " + newBills + " $");
                                            out.flush();
                                        } else {
                                            totalBills += bill;
                                            user.setTotalBills(username, totalBills);
                                            setDiscountPoint(username, totalBills, discountPoint);
                                            out.writeUTF(order.addOrder(username, carID, day, distance, paymentMethod, bill));
                                            out.writeUTF("Order Bill is: " + bill + " $");
                                            out.writeUTF("");
                                            out.flush();
                                        }
                                    }
                                } else {
                                    out.writeUTF("There is something wrong");
                                    out.writeUTF("");
                                    out.writeUTF("");
                                    out.flush();
                                }
                            } else {
                                out.writeUTF("Sorry..But the car now is unavailable try another one");
                                out.writeUTF("");
                                out.writeUTF("");
                                out.flush();
                            }
                        } else {
                            out.writeUTF("Sorry..But your license validity now is INVALID, Please contact out team to solve this issue");
                            out.writeUTF("");
                            out.writeUTF("");
                            out.flush();

                        }
                    } else {
                        out.writeUTF("Sorry..But you are not client");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.flush();
                    }
                    break;
            }
            out.flush();
            in.close();
            out.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    private void setDiscountPoint(String username, double totalBills, int discountPoint) {
        if (totalBills > 100 && totalBills < 500) {
            discountPoint += 2;
            user.setDiscountPoint(username, discountPoint);
        }
        if (totalBills > 500 && totalBills < 1000) {
            discountPoint += 5;
            user.setDiscountPoint(username, discountPoint);
        }
        if (totalBills > 1000) {
            discountPoint += 7;
            user.setDiscountPoint(username, discountPoint);
        }
    }
}


class EditAccount implements Runnable {
    private Socket socket;
    private User user;
    private DataInputStream in;
    private DataOutputStream out;

    public EditAccount(Socket socket, User user) {
        this.socket = socket;
        this.user = user;
    }

    @Override
    public void run() {
        String username;
        boolean isAccountExist;
        String isAccountExistMassage;
        String typeExist;
        try {
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            String operation = in.readUTF();
            switch (operation) {
                case "1edit2delete":
                    username = in.readUTF();
                    isAccountExist = user.isAccountExist(username);
                    isAccountExistMassage = user.getAMassage();
                    if (isAccountExist) {
                        out.writeUTF(isAccountExistMassage);
                        out.writeUTF(user.deleteAccount(username));
                    } else {
                        out.writeUTF(isAccountExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "1edit3username":
                    username = in.readUTF();
                    String newUsername = in.readUTF();
                    isAccountExist = user.isAccountExist(username);
                    isAccountExistMassage = user.getAMassage();
                    if (isAccountExist) {
                        out.writeUTF(isAccountExistMassage);
                        out.writeUTF(user.updateUsername(username, newUsername));
                    } else {
                        out.writeUTF(isAccountExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "1edit4password":
                    username = in.readUTF();
                    String password = in.readUTF();
                    isAccountExist = user.isAccountExist(username);
                    isAccountExistMassage = user.getAMassage();
                    if (isAccountExist) {
                        out.writeUTF(isAccountExistMassage);
                        out.writeUTF(user.updatePassword(username, password));
                    } else {
                        out.writeUTF(isAccountExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "1edit5firstName":
                    username = in.readUTF();
                    String firstName = in.readUTF();
                    isAccountExist = user.isAccountExist(username);
                    isAccountExistMassage = user.getAMassage();
                    if (isAccountExist) {
                        out.writeUTF(isAccountExistMassage);
                        out.writeUTF(user.setFirstName(username, firstName));
                    } else {
                        out.writeUTF(isAccountExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "1edit6lastName":
                    username = in.readUTF();
                    String lastName = in.readUTF();
                    isAccountExist = user.isAccountExist(username);
                    isAccountExistMassage = user.getAMassage();
                    if (isAccountExist) {
                        out.writeUTF(isAccountExistMassage);
                        out.writeUTF(user.setLastName(username, lastName));
                    } else {
                        out.writeUTF(isAccountExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "1edit7gender":
                    username = in.readUTF();
                    String gender = in.readUTF();
                    isAccountExist = user.isAccountExist(username);
                    isAccountExistMassage = user.getAMassage();
                    if (isAccountExist) {
                        out.writeUTF(isAccountExistMassage);
                        out.writeUTF(user.setGender(username, gender));
                    } else {
                        out.writeUTF(isAccountExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "1edit8telephone":
                    username = in.readUTF();
                    int telephone = in.readInt();
                    isAccountExist = user.isAccountExist(username);
                    isAccountExistMassage = user.getAMassage();
                    if (isAccountExist) {
                        out.writeUTF(isAccountExistMassage);
                        out.writeUTF(user.setTelephone(username, telephone));
                    } else {
                        out.writeUTF(isAccountExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "1edit9availability":
                    username = in.readUTF();
                    String availability = in.readUTF();
                    isAccountExist = user.isAccountExist(username);
                    isAccountExistMassage = user.getAMassage();
                    if (isAccountExist) {
                        out.writeUTF(isAccountExistMassage);
                        out.writeUTF(user.setStatus(username, availability));
                    } else {
                        out.writeUTF(isAccountExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "1edit10address":
                    username = in.readUTF();
                    String address = in.readUTF();
                    isAccountExist = user.isAccountExist(username);
                    isAccountExistMassage = user.getAMassage();
                    if (isAccountExist) {
                        out.writeUTF(isAccountExistMassage);
                        out.writeUTF(user.setAddress(username, address));
                    } else {
                        out.writeUTF(isAccountExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "1edit11age":
                    username = in.readUTF();
                    int year = in.readInt();
                    int month = in.readInt();
                    int day = in.readInt();
                    isAccountExist = user.isAccountExist(username);
                    isAccountExistMassage = user.getAMassage();
                    if (isAccountExist) {
                        out.writeUTF(isAccountExistMassage);
                        out.writeUTF(user.setAge(username, year, month, day));
                    } else {
                        out.writeUTF(isAccountExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "1edit12validity":
                    username = in.readUTF();
                    String validity = in.readUTF();
                    typeExist = user.getExistType(username);
                    if (typeExist.equals("client")) {
                        out.writeUTF(typeExist);
                        out.writeUTF(user.setLicenseValidity(username, validity));
                    } else {
                        out.writeUTF(typeExist);
                        out.writeUTF("");
                    }
                    break;
                case "1edit13point":
                    username = in.readUTF();
                    int point = in.readInt();
                    typeExist = user.getExistType(username);
                    if (typeExist.equals("client")) {
                        out.writeUTF(typeExist);
                        out.writeUTF(user.setDiscountPoint(username, point));
                    } else {
                        out.writeUTF(typeExist);
                        out.writeUTF("");
                    }
                    break;
                case "1edit14type":
                    username = in.readUTF();
                    String typeEdit = in.readUTF();
                    isAccountExist = user.isAccountExist(username);
                    isAccountExistMassage = user.getAMassage();
                    if (isAccountExist) {
                        out.writeUTF(isAccountExistMassage);
                        out.writeUTF(user.updateType(username, typeEdit));
                    } else {
                        out.writeUTF(isAccountExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "1edit15rank":
                    username = in.readUTF();
                    String rank = in.readUTF();
                    typeExist = user.getExistType(username);
                    if (typeExist.equals("supervisor")) {
                        out.writeUTF(typeExist);
                        out.writeUTF(user.setRank(username, rank));
                    } else {
                        out.writeUTF(typeExist);
                        out.writeUTF("");
                    }
                    break;
                case "1edit16section":
                    username = in.readUTF();
                    String section = in.readUTF();
                    typeExist = user.getExistType(username);
                    if (typeExist.equals("supervisor")) {
                        out.writeUTF(typeExist);
                        out.writeUTF(user.setSection(username, section));
                    } else {
                        out.writeUTF(typeExist);
                        out.writeUTF("");
                    }
                    break;
                case "1edit17showAll":
                    ArrayList<UserReference> showAll = new ArrayList<>(user.getAll());
                    out.writeInt(showAll.size());
                    ObjectOutputStream outObject = new ObjectOutputStream(out);
                    for (UserReference ref:showAll) {
                        outObject.writeObject(ref);
                    }
                    outObject.flush();
                    outObject.close();
                    break;
                case "2edit18AccountOnline":
                    username = in.readUTF();
                    user.setStatus(username,"Online");
                    break;
                case "2edit18AccountOffline":
                    username = in.readUTF();
                    user.setStatus(username,"Offline");
                    break;
                case "2edit19showUserInfo":
                    username = in.readUTF();
                    ArrayList<UserReference> showInfo = new ArrayList<>(user.getUserInfo(username));
                    int infoSize= showInfo.size();
                    out.writeInt(infoSize);
                    ObjectOutputStream outObjectInfo = new ObjectOutputStream(out);
                    for (UserReference ref:showInfo) {
                        outObjectInfo.writeObject(ref);
                    }
                    outObjectInfo.flush();
                    outObjectInfo.close();
                    break;
                case "2edit20totalBills":
                    username = in.readUTF();
                    double totalBills = in.readDouble();
                    typeExist = user.getExistType(username);
                    if (typeExist.equals("client")) {
                        out.writeUTF(typeExist);
                        out.writeUTF(user.setTotalBills(username, totalBills));
                    } else {
                        out.writeUTF(typeExist);
                        out.writeUTF("");
                    }
                    break;
            }
            out.flush();
            in.close();
            out.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}



class AddAccount implements Runnable{
    private Socket socket;
    private User user;
    private DataInputStream in;
    private DataOutputStream out;

    public AddAccount(Socket socket, User user) {
        this.socket = socket;
        this.user = user;
    }

    @Override
    public void run() {
        try{
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            String username = in.readUTF();
            String password = in.readUTF();
            String type = in.readUTF();
            String firstName = in.readUTF();
            String lastName = in.readUTF();
            String gender = in.readUTF();
            int year = in.readInt();
            int month = in.readInt();
            int day = in.readInt();
            int telephone = in.readInt();
            String email = in.readUTF();
            String address = in.readUTF();
            String status = in.readUTF();
            String rank = in.readUTF();
            String section = in.readUTF();
            String license = in.readUTF();
            int point = in.readInt();
            double totalBills = in.readDouble();

            if (!type.isEmpty()) {
                if (type.equals("root")) {
                    String usernameMassage = user.signUpRoot(username, password);
                    out.writeUTF(usernameMassage);
                    if (usernameMassage.equals("Sign Up successfully")) {
                        out.writeUTF(user.setFirstName(username, firstName));
                        out.writeUTF(user.setLastName(username, lastName));
                        out.writeUTF(user.setGender(username, gender));
                        out.writeUTF(user.setAge(username, year, month, day));
                        out.writeUTF(user.setTelephone(username, telephone));
                        out.writeUTF(user.setEmail(username, email));
                        out.writeUTF(user.setAddress(username, address));
                        out.writeUTF(user.setStatus(username, status));
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                    }else {
                        out.writeUTF("Something wrong");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                    }
                }
                if (type.equals("supervisor")) {
                    String usernameMassage = user.signUpSupervisor(username, password);
                    out.writeUTF(usernameMassage);
                    if (usernameMassage.equals("Sign Up successfully")) {
                        out.writeUTF(user.setFirstName(username, firstName));
                        out.writeUTF(user.setLastName(username, lastName));
                        out.writeUTF(user.setGender(username, gender));
                        out.writeUTF(user.setAge(username, year, month, day));
                        out.writeUTF(user.setTelephone(username, telephone));
                        out.writeUTF(user.setEmail(username, email));
                        out.writeUTF(user.setAddress(username, address));
                        out.writeUTF(user.setStatus(username, status));
                        out.writeUTF(user.setRank(username, rank));
                        out.writeUTF(user.setSection(username, section));
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                    }else {
                        out.writeUTF("Something wrong");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                    }
                }
                if (type.equals("client")) {
                    String usernameMassage = user.signUpClient(username, password);
                    out.writeUTF(usernameMassage);
                    if (usernameMassage.equals("Sign Up successfully")) {
                        out.writeUTF(user.setFirstName(username, firstName));
                        out.writeUTF(user.setLastName(username, lastName));
                        out.writeUTF(user.setGender(username, gender));
                        out.writeUTF(user.setAge(username, year, month, day));
                        out.writeUTF(user.setTelephone(username, telephone));
                        out.writeUTF(user.setEmail(username, email));
                        out.writeUTF(user.setAddress(username, address));
                        out.writeUTF(user.setStatus(username, status));
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF(user.setLicenseValidity(username, license));
                        out.writeUTF(user.setDiscountPoint(username, point));
                        out.writeUTF(user.setTotalBills(username,totalBills));

                    }else {
                        out.writeUTF("Something wrong");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                        out.writeUTF("");
                    }
                }
            }else {
                out.writeUTF("Type not Found");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
            }
            out.flush();
            in.close();
            out.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        finally {
            try {
                out.close();
                in.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class EditCar implements Runnable{
    private Socket socket;
    private Car car;
    private DataInputStream in;
    private DataOutputStream out;

    public EditCar(Socket socket, Car car) {
        this.socket = socket;
        this.car = car;
    }

    @Override
    public void run() {
        try{
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            String operation = in.readUTF();
            String carID;
            boolean isCarExist;
            String isCarExistMassage;
            String typeExist;
            switch (operation) {
                case "1edit3delete":
                    carID = in.readUTF();
                    isCarExist = car.isCarExist_car(carID);
                    isCarExistMassage = car.getTheMassage();
                    if (isCarExist) {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF(car.deleteCar(carID));
                    } else {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF("");
                    }
                    out.writeUTF(car.deleteCar(carID));
                    break;
                case "1edit4carId":
                    carID = in.readUTF();
                    String newCarID = in.readUTF();
                    isCarExist = car.isCarExist_car(carID);
                    isCarExistMassage = car.getTheMassage();
                    if (isCarExist) {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF(car.updateCarID(carID, newCarID));
                    } else {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "1edit5carType":
                    carID = in.readUTF();
                    String type = in.readUTF();
                    isCarExist = car.isCarExist_car(carID);
                    isCarExistMassage = car.getTheMassage();
                    if (isCarExist) {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF(car.setType(carID, type));
                    } else {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "1edit6carMaker":
                    carID = in.readUTF();
                    String maker = in.readUTF();
                    isCarExist = car.isCarExist_car(carID);
                    isCarExistMassage = car.getTheMassage();
                    if (isCarExist) {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF(car.setMaker(carID, maker));
                    } else {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "1edit7carModel":
                    carID = in.readUTF();
                    String model = in.readUTF();
                    isCarExist = car.isCarExist_car(carID);
                    isCarExistMassage = car.getTheMassage();
                    if (isCarExist) {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF(car.setModelName(carID, model));
                    } else {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "1edit8carYear":
                    carID = in.readUTF();
                    int year = in.readInt();
                    isCarExist = car.isCarExist_car(carID);
                    isCarExistMassage = car.getTheMassage();
                    if (isCarExist) {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF(car.setModelYear(carID, year));
                    } else {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "1edit9carSeats":
                    carID = in.readUTF();
                    int seats = in.readInt();
                    isCarExist = car.isCarExist_car(carID);
                    isCarExistMassage = car.getTheMassage();
                    if (isCarExist) {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF(car.setNumberOfSeats(carID, seats));
                    } else {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "1edit10carRegis":
                    carID = in.readUTF();
                    String registration = in.readUTF();
                    isCarExist = car.isCarExist_car(carID);
                    isCarExistMassage = car.getTheMassage();
                    if (isCarExist) {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF(car.setRegistrationNumber(carID, registration));
                    } else {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "1edit11carIdent":
                    carID = in.readUTF();
                    String identification = in.readUTF();
                    isCarExist = car.isCarExist_car(carID);
                    isCarExistMassage = car.getTheMassage();
                    if (isCarExist) {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF(car.setIdentificationNumber(carID, identification));
                    } else {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "1edit12carMeter":
                    carID = in.readUTF();
                    double lastMeter = in.readDouble();
                    isCarExist = car.isCarExist_car(carID);
                    isCarExistMassage = car.getTheMassage();
                    if (isCarExist) {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF(car.setLastMeterReading(carID, lastMeter));
                    } else {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "1edit13costPerDay":
                    carID = in.readUTF();
                    double costPerDay = in.readDouble();
                    isCarExist = car.isCarExist_car(carID);
                    isCarExistMassage = car.getTheMassage();
                    if (isCarExist) {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF(car.setCostPerDay(carID, costPerDay));
                    } else {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "1edit14costPerKm":
                    carID = in.readUTF();
                    double costPerKm = in.readDouble();
                    typeExist = car.getType(carID);
                    if (typeExist.equals("Sedan") || typeExist.equals("Van")) {
                        if (typeExist.equals("Sedan")) {
                            out.writeUTF(typeExist);
                            out.writeUTF(car.setCostPerKmSedan(carID, costPerKm));
                        }
                        if (typeExist.equals("Van")) {
                            out.writeUTF(typeExist);
                            out.writeUTF(car.setCostPerKmVan(carID, costPerKm));
                        }
                    } else {
                        out.writeUTF(typeExist);
                        out.writeUTF("");
                    }
                    break;
                case "1edit15insurance":
                    carID = in.readUTF();
                    double insurance = in.readDouble();
                    typeExist = car.getType(carID);
                    if (typeExist.equals("Van")) {
                        out.writeUTF(typeExist);
                        out.writeUTF(car.setInsurancePerDayVan(carID, insurance));
                    } else {
                        out.writeUTF(typeExist);
                        out.writeUTF("");
                    }
                    break;
                case "1edit16status":
                    carID = in.readUTF();
                    String status = in.readUTF();
                    isCarExist = car.isCarExist_car(carID);
                    isCarExistMassage = car.getTheMassage();
                    if (isCarExist) {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF(car.setStatus(carID, status));
                    } else {
                        out.writeUTF(isCarExistMassage);
                        out.writeUTF("");
                    }
                    break;
                case "1edit17showAll":
                    ArrayList<CarReference> showAll = new ArrayList<>(car.getAll());
                    out.writeInt(showAll.size());
                    ObjectOutputStream outObject = new ObjectOutputStream(out);
                    for (CarReference ref:showAll) {
                        outObject.writeObject(ref);
                    }
                    outObject.flush();
                    outObject.close();
                    break;
            }
            out.flush();
            in.close();
            out.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        finally {
            try {
                out.close();
                in.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class AddCar implements Runnable{
    private Socket socket;
    private Car car;
    private DataInputStream in;
    private DataOutputStream out;

    public AddCar(Socket socket, Car car) {
        this.socket = socket;
        this.car = car;
    }

    @Override
    public void run() {
        try{
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            String carID = in.readUTF();
            String type = in.readUTF();
            String maker = in.readUTF();
            String modelName = in.readUTF();
            int modelYear = in.readInt();
            int seats = in.readInt();
            String registration = in.readUTF();
            String identification = in.readUTF();
            double lastMeter = in.readDouble();
            double costPerDay = in.readDouble();
            String status = in.readUTF();
            double costPerKm = in.readDouble();
            double insurance = in.readDouble();
            String carIdMassage = car.insertCarID(carID);
            out.writeUTF(carIdMassage);
            if (carIdMassage.equals("Car ID insert successfully")){
                if (type.equals("Compact")) {
                    out.writeUTF(car.setType(carID, type));
                    out.writeUTF(car.setMaker(carID, maker));
                    out.writeUTF(car.setModelName(carID, modelName));
                    out.writeUTF(car.setModelYear(carID, modelYear));
                    out.writeUTF(car.setNumberOfSeats(carID, seats));
                    out.writeUTF(car.setRegistrationNumber(carID, registration));
                    out.writeUTF(car.setIdentificationNumber(carID, identification));
                    out.writeUTF(car.setLastMeterReading(carID, lastMeter));
                    out.writeUTF(car.setCostPerDay(carID, costPerDay));
                    out.writeUTF(car.setStatus(carID, status));
                    out.writeUTF("");
                    out.writeUTF("");
                }
                if (type.equals("Sedan")){
                    out.writeUTF(car.setType(carID, type));
                    out.writeUTF(car.setMaker(carID, maker));
                    out.writeUTF(car.setModelName(carID, modelName));
                    out.writeUTF(car.setModelYear(carID, modelYear));
                    out.writeUTF(car.setNumberOfSeats(carID, seats));
                    out.writeUTF(car.setRegistrationNumber(carID, registration));
                    out.writeUTF(car.setIdentificationNumber(carID, identification));
                    out.writeUTF(car.setLastMeterReading(carID, lastMeter));
                    out.writeUTF(car.setCostPerDay(carID, costPerDay));
                    out.writeUTF(car.setStatus(carID, status));
                    out.writeUTF(car.setCostPerKmSedan(carID,costPerKm));
                    out.writeUTF("");
                }
                if (type.equals("Van")){
                    out.writeUTF(car.setType(carID, type));
                    out.writeUTF(car.setMaker(carID, maker));
                    out.writeUTF(car.setModelName(carID, modelName));
                    out.writeUTF(car.setModelYear(carID, modelYear));
                    out.writeUTF(car.setNumberOfSeats(carID, seats));
                    out.writeUTF(car.setRegistrationNumber(carID, registration));
                    out.writeUTF(car.setIdentificationNumber(carID, identification));
                    out.writeUTF(car.setLastMeterReading(carID, lastMeter));
                    out.writeUTF(car.setCostPerDay(carID, costPerDay));
                    out.writeUTF(car.setStatus(carID, status));
                    out.writeUTF(car.setCostPerKmVan(carID,costPerKm));
                    out.writeUTF(car.setInsurancePerDayVan(carID,insurance));
                }
            }else {
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
            }
            out.flush();
            in.close();
            out.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        finally {
            try {
                out.close();
                in.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class SignIn implements Runnable{
    private Socket socket;
    private User user;
    private DataInputStream in;
    private DataOutputStream out;

    public SignIn(Socket socket, User user) {
        this.socket = socket;
        this.user = user;
    }

    @Override
    public void run() {
        try{
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            String username = in.readUTF();
            String password = in.readUTF();
            out.writeBoolean(user.signIn(username,password));
            out.writeUTF(user.getAMassage());
            out.writeUTF(user.getType(username,password));
            out.flush();
            in.close();
            out.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        finally {
            try {
                out.close();
                in.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class SignUp implements Runnable{
    private Socket socket;
    private User user;
    private DataInputStream in;
    private DataOutputStream out;

    public SignUp(Socket socket,User user) {
        this.socket = socket;
        this.user = user;
    }

    @Override
    public void run() {
        try {
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            String username = in.readUTF();
            String password = in.readUTF();
            String firstName = in.readUTF();
            String lastName = in.readUTF();
            String gender = in.readUTF();
            int year = in.readInt();
            int month = in.readInt();
            int day = in.readInt();
            int telephone = in.readInt();
            String email = in.readUTF();
            String address = in.readUTF();
            String signItUp = user.signUpClient(username, password);
            out.writeUTF(signItUp);
            if (signItUp.equals("Sign Up successfully")) {
                out.writeUTF(user.setFirstName(username, firstName));
                out.writeUTF(user.setLastName(username, lastName));
                out.writeUTF(user.setGender(username, gender));
                out.writeUTF(user.setAge(username, year, month, day));
                out.writeUTF(user.setTelephone(username, telephone));
                out.writeUTF(user.setEmail(username, email));
                out.writeUTF(user.setAddress(username, address));
            } else {
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
                out.writeUTF("");
            }
            out.flush();
            in.close();
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
