import java.sql.*;

/**
 * Created by evgen on 20.10.2016.
 */
public class ReadHouses {
    public void Read() {
        Connection dbConnection = null;
        Statement statement = null;

        try {

        dbConnection = getDBConnection();
        statement = dbConnection.createStatement();

        // выбираем данные с БД

        System.out.println("///////////////Houses////////////////////////////");
        String selectTableHouses = "SELECT * from \"Houses\";";
        ResultSet rs = null;

            rs = statement.executeQuery(selectTableHouses);

        // И если что то было получено то цикл while сработает
        while (rs.next()) {
            Integer number = rs.getInt("Number");
            String street = rs.getString("Street");
            String floors = rs.getString("Floors");
            Integer flat_count = rs.getInt("Flat_count");

            System.out.println("Number : " + number);
            System.out.println("Street : " + street);
            System.out.println("Floors : " + floors);
            System.out.println("Flat_count : " + flat_count);
        }
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
