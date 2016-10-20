import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by evgen on 20.10.2016.
 */
public class DeletePerson {


    public void Delete(){
        Statement statement = null;
        Connection dbConnection = null;
        String deleteTableSQL = "DELETE FROM \"Persons\" WHERE \"ID\" = 2";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            // выполняем запрос delete SQL
            statement.execute(deleteTableSQL);
            System.out.println("Record is deleted from Houses table!");
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
            dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Housingoffice","postgres", "postgre");
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

}
