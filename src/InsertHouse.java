import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by evgen on 20.10.2016.
 */
public class InsertHouse {

    public void Insert() {
        Statement statement = null;
        Connection dbConnection = null;
        String insertTableSQL = "INSERT INTO \"Houses\"" +  "(\"Number\", \"Street\", \"Floors\", \"Flat_count\", \"ID\") " + "VALUES" + "(45, 'Chkalova', '9', 56, 2 ) ;";
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
