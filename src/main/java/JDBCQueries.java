public final class JDBCQueries {

    public static final String NUMBER_OF_SEATS = "SELECT seats FROM planes";

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS passengers (" +
            "id int PRIMARY KEY AUTO_INCREMENT," +
            "first_name varchar(50)," +
            "last_name varchar(50)," +
            "age int)";

    public static final String INSERT_PASSENGER = "INSERT INTO  passengers (" +
            "first_name, last_name, age)" + "VALUES ('Sam', 'Snow', 42), ('Jack', 'Smith', 36),('Emma', " +
            "'Wilson', 24)";

    public static final String READ_ALL_PASSENGERS = "SELECT * FROM passengers";

    public static final String UPDATE_PASSENGER_AGE = "UPDATE passengers SET age =? WHERE id =?";

    public static final String DELETE_PASSENGER = "DELETE FROM passengers WHERE last_name = 'Snow'";


}
