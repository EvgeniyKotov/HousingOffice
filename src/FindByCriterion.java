import java.sql.*;
import java.util.Scanner;

/**
 * Created by evgen on 20.10.2016.
 */
public class FindByCriterion {
    public void Find() {
        Connection dbConnection = null;
        Statement statement = null;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter street: ");

        String street = in.nextLine();

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            ResultSet rs1 = statement.executeQuery("select * from \"Persons\" WHERE \"Street\"='" + street + "';");
            while (rs1.next()) {
                String name = rs1.getString("Name");
                String surname = rs1.getString("Surname");
                Integer age = rs1.getInt("Age");
                Integer numberflat = rs1.getInt("NumberFlat");
                String street_p = rs1.getString("Street");

                System.out.println("Name : " + name);
                System.out.println("Surname : " + surname);
                System.out.println("Age : " + age);
                System.out.println("Street : " + street_p);
                System.out.println("Street : " + numberflat);
            }
            System.out.println("******************************");

        } catch (SQLException e) {
            System.err.println(e);
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
