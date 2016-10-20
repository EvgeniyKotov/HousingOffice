import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by evgen on 20.10.2016.
 */
public class InsertPerson {

    public void Insert() {
        Statement statement = null;
        Connection dbConnection = null;
        String insertTableSQL = "INSERT INTO \"Persons\"" +  "(\"Name\", \"Surname\", \"Age\", \"NumberFlat\", \"Street\", \"ID\") " + "VALUES" + "('Petro', 'Petrov', 45, 25, 'Chkalova', 2 ) ;";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            statement.executeUpdate(insertTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
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
            dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Housingoffice","postgres", "postgre");
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }


}
