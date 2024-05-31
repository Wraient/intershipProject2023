import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class database {
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/garagedatabase";
	
	static String USERNAME="root";
	
	static String PASSWORD="tiger";


    public static void display() {
    	final String SELECT_SQL = "SELECT * FROM service";
        try{
        	Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // Retrieve values from the result set and print them
                int id = resultSet.getInt("id");
                String name = resultSet.getString("Name");
                String mobileNumber = resultSet.getString("Mobile Number");
                String email = resultSet.getString("Email");
                String vehicleNumber = resultSet.getString("Vehicle Number");
                String model = resultSet.getString("Model");
                int washing = resultSet.getInt("Washing");
                int oilChange = resultSet.getInt("Oil Change");
                int fitting = resultSet.getInt("Fitting");
                int cleaning = resultSet.getInt("Cleaning");
                int extra = resultSet.getInt("Extra");

                // Print all values in one line
                System.out.printf("ID: %d, Name: %s, Mobile Number: %s, Email: %s, Vehicle Number: %s, Model: %s, Washing: %d, Oil Change: %d, Fitting: %d, Cleaning: %d, Extra: %d%n",
                        id, name, mobileNumber, email, vehicleNumber, model, washing, oilChange, fitting, cleaning, extra);
            }
        } catch (SQLException e) {
            System.out.println("Error displaying data: " + e.getMessage());
        }
    }
    
    private static final String INSERT_SQL = "INSERT INTO service (Name, `Mobile Number`, Email, `Vehicle Number`, Model, Washing, `Oil Change`, Fitting, Cleaning, Extra) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static void insertData(String name, String mobileNumber, String email, String vehicleNumber, String model,
                                   int washing, int oilChange, int fitting, int cleaning, int extra) {
        try {
        	Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);
            // Set parameters
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, mobileNumber);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, vehicleNumber);
            preparedStatement.setString(5, model);
            preparedStatement.setInt(6, washing);
            preparedStatement.setInt(7, oilChange);
            preparedStatement.setInt(8, fitting);
            preparedStatement.setInt(9, cleaning);
            preparedStatement.setInt(10, extra);

            // Execute the INSERT statement
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Failed to insert data.");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting data: " + e.getMessage());
        }
    }
    
    
    
    
}