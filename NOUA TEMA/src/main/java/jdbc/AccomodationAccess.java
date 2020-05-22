package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccomodationAccess {


    private static void createTableAccomodation(Connection connection) throws SQLException {

        // varchar by default is 255
        PreparedStatement createTable =
                connection.prepareStatement(
                        "create table accommodation" +
                                "(" +
                                "id SERIAL not null," +
                                "type varchar(32), " +
                                "bedType varchar(32)," +
                                "maxGuests integer," +
                                "description varchar(512)" +
                                "primary key (id)" +
                                ")");

        createTable.execute();
        connection.commit();
    }

    public static void accomodationHandler(Connection connection) {
        try {

            createTableAccomodation(connection);
            insertAccomodationEntry(connection);


            Statement statement =
                    connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from accomodation");
            List<Accomodation> accomodations = new ArrayList<>();

            while (resultSet.next()) {

                Accomodation accomodation = new Accomodation();
                accomodation.setId(resultSet.getInt("id"));
                accomodation.setType(resultSet.getString("type"));
                accomodation.setBedType(resultSet.getString("bedType"));
                accomodation.setMaxGuests(resultSet.getInt("maxGuests"));
                accomodation.setDescription(resultSet.getString("description"));

                accomodations.add(accomodation);
            }

            accomodations.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void insertAccomodationEntry(Connection connection) throws SQLException {

        PreparedStatement insertAccomodation =
                connection.prepareStatement("insert into accomodation " +
                        "(id, type, bedType, maxGuests, description) values (1, 'Single', " +
                        "'Single', 1, 'ceva')");

        insertAccomodation.execute();
        connection.commit();
    }

}
