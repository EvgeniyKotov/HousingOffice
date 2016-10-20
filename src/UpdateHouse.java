import java.sql.*;

/**
 * Created by evgen on 20.10.2016.
 */
public class UpdateHouse {
    public void Update() {
        Connection dbConnection = null;
        Statement statement = null;
        String updateTableSQL = "UPDATE \"Houses\" SET \"Number\" = 18 WHERE \"ID\" = 1";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполняем запрос update SQL
            statement.execute(updateTableSQL);

            System.out.println("Record is updated to Houses table!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Housingoffice", "postgres", "postgre");
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }


}
