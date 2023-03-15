import java.sql.*;

public class AirportService {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBCConstants.URL, JDBCConstants.USER,
                JDBCConstants.PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(JDBCQueries.NUMBER_OF_SEATS);

            int seats = 0;
            while (resultSet.next()) {
                seats += resultSet.getInt("seats");
            }
            System.out.println("Quantity of all passengers airport can service " + seats);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
