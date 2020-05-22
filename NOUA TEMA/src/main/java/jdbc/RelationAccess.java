package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RelationAccess {



    public static void relationHandler(Connection connection) {
        try {

            createTableRelation(connection);
            // insertAccomodationEntry(connection);


            Statement statement =
                    connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from accommodation_to_room_fair_relation");
            List<AccomodationToRoomFairRelation> relation_table = new ArrayList<>();

            while (resultSet.next()) {

                AccomodationToRoomFairRelation accomodationToRoomRelation = new AccomodationToRoomFairRelation();
                accomodationToRoomRelation.setId(resultSet.getInt("id"));
                accomodationToRoomRelation.setId_accomodation(resultSet.getInt("id_accomodation"));
                accomodationToRoomRelation.setId_room_fair(resultSet.getInt("id_room_fair"));


                relation_table.add(accomodationToRoomRelation);
            }

            relation_table.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void createTableRelation(Connection connection) throws SQLException {


        PreparedStatement createTable =
                connection.prepareStatement(
                        "create table accommodation_to_room_fair_relation" +
                                "(" +
                                "id SERIAL not null," +
                                "id_accomodation integer, " +
                                "id_room_fair integer" +
                                "primary key(id)" +
                                "foreign key(id_accomodation)" +
                                "foreign key(id_room_fair)" +
                                ")");

        createTable.execute();
        connection.commit();
    }

    public static void join(Connection connection) throws SQLException{

        PreparedStatement joinTables =
                connection.prepareStatement("select * from accomodation a inner join room_fair b on a.id_accomodation=b.id_room_fair");

        joinTables.execute();
        connection.commit();
    }
}
