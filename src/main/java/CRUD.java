import java.sql.*;
import java.util.ArrayList;

public class CRUD {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBCConstants.URL, JDBCConstants.USER,
                JDBCConstants.PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.execute(JDBCQueries.CREATE_TABLE);
            statement.execute(JDBCQueries.INSERT_PASSENGER);

            ResultSet resultSet = statement.executeQuery(JDBCQueries.READ_ALL_PASSENGERS);
            ArrayList<Passenger> passengers = new ArrayList<>();

            while (resultSet.next()) {
                Passenger passenger = new Passenger();
                passenger.setId(resultSet.getInt("id"));
                passenger.setFirstName(resultSet.getString("first_name"));
                passenger.setLastName(resultSet.getString("last_name"));
                passenger.setAge(resultSet.getInt("age"));
                passengers.add(passenger);
            }
            passengers.forEach(System.out::println);

            PreparedStatement preparedStatement = connection.prepareStatement(JDBCQueries.UPDATE_PASSENGER_AGE);
            preparedStatement.setInt(1, 101);
            preparedStatement.setInt(2, 3);
            preparedStatement.executeUpdate();

            statement.execute(JDBCQueries.DELETE_PASSENGER);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

