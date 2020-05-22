package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomFairAccess {

    public RoomFairAccess() {
    }

    private static void createTableRoomFair(Connection connection) throws SQLException {

        PreparedStatement createTable =
                connection.prepareStatement(
                        "create table room_fair" +
                                "(" +
                                "id SERIAL not null," +
                                "value double precision, " +
                                "season varchar(32)" +
                                "primary key(id)" +
                                ")");

        createTable.execute();
        connection.commit();
    }

    public static void room_fairHandler(Connection connection) {
        try {

            createTableRoomFair(connection);
            insertRoomFairEntry(connection);

            Statement statement =
                    connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from room_fair");
            List<RoomFair> room_fair = new ArrayList<>();

            while (resultSet.next()) {

                RoomFair roomFair = new RoomFair();
                roomFair.setId(resultSet.getInt("id"));
                roomFair.setValue(resultSet.getDouble("value"));
                roomFair.setSeason(resultSet.getString("season"));

                room_fair.add(roomFair);
            }

            room_fair.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertRoomFairEntry(Connection connection) throws SQLException {

        PreparedStatement insert_room_fair =
                connection.prepareStatement("insert into room_fair " +
                        "(id, value, season) values (1, 222.2, " +
                        " 'autumn')");

        insert_room_fair.execute();
        connection.commit();
    }
}
