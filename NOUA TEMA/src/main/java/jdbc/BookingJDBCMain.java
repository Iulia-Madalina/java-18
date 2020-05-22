package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingJDBCMain {
    public static void main(String[] args) throws SQLException {

        Connection connection = getConnection();

        AccomodationAccess.accomodationHandler(connection);
        RoomFairAccess.room_fairHandler(connection);
        RelationAccess.relationHandler(connection);
        RelationAccess.join(connection);

    }



    public static Connection getConnection() {
        Connection connection = newConnection(
                "postgresql",
                "localhost",
                "5432",
                // Default database => postgres
                "booking",
                "postgres",
                "postgres"
        );

        try {
            connection.setAutoCommit(false);
            //  createDatabaseBooking(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

//    private static void createDatabaseBooking(Connection connection) throws SQLException {
//
//        PreparedStatement createDatabase =
//                connection.prepareStatement("create database booking");
//    }

    private static Connection newConnection(String type, String host, String port,
                                            String dbName, String user,
                                            String password) {

//        jdbc:postgresql://localhost:5432/booking
        String url = "jdbc:" + type + "://" + host + ":" + port + "/" + dbName +
                "?user=" + user + "&password=" + password;

        System.out.println(url);

        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }









}
