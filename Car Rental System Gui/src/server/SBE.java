package server;

public class SBE {
    private static int serverPort = 6000;
    private static int clientPort = 6000;
    private static String dbUrl = "jdbc:mysql://localhost/car_rental_system";
    private static String dbUser = "root";
    private static String dbPassword = "1729384#General";
    private static String serverHost = "localhost";



    public static int getServerPort() {
        return serverPort;
    }

    public static void setServerPort(int serverPort) {
        SBE.serverPort = serverPort;
    }

    public static int getClientPort() {
        return clientPort;
    }

    public static void setClientPort(int clientPort) {
        SBE.clientPort = clientPort;
    }

    public static String getDbUrl() {
        return dbUrl;
    }

    public static void setDbUrl(String dbUrl) {
        SBE.dbUrl = dbUrl;
    }

    public static String getDbUser() {
        return dbUser;
    }

    public static void setDbUser(String dbUser) {
        SBE.dbUser = dbUser;
    }

    public static String getDbPassword() {
        return dbPassword;
    }

    public static void setDbPassword(String dbPassword) {
        SBE.dbPassword = dbPassword;
    }

    public static String getServerHost() {
        return serverHost;
    }

    public static void setServerHost(String serverHost) {
        SBE.serverHost = serverHost;
    }
}
