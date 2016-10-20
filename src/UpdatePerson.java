import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by evgen on 20.10.2016.
 */
public class UpdatePerson {

    public void Update() {
        Connection dbConnection = null;
        Statement statement = null;
        String updateTableSQL = "UPDATE \"Persons\" SET \"Name\" = 'Evgeniy' WHERE \"ID\" = 1";
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
