import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class question2 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/nonprofit";
        String user = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password); 
             Statement stmt = conn.createStatement()) {

            // Create Donors table
            String createDonors = "CREATE TABLE Donors (" +
                    "donorID INT PRIMARY KEY," +
                    "firstName VARCHAR(50)," +
                    "lastName VARCHAR(50)," +
                    "middleInitial CHAR(1)," +
                    "dateOfBirth DATE," +
                    "address VARCHAR(100)," +
                    "city VARCHAR(50)," +
                    "postalCode VARCHAR(10)," +
                    "province VARCHAR(50)," +
                    "gender CHAR(1)," +
                    "SSN CHAR(9)," +
                    "phone VARCHAR(15)," +
                    "email VARCHAR(100))";
            stmt.execute(createDonors);

            // Create Donations table
            String createDonations = "CREATE TABLE Donations (" +
                    "dID INT PRIMARY KEY," +
                    "donorID INT," +
                    "date DATE," +
                    "type VARCHAR(10)," +
                    "amount DECIMAL(10, 2)," +
                    "FOREIGN KEY (donorID) REFERENCES Donors(donorID))";
            stmt.execute(createDonations);

            // Create Products table
            String createProducts = "CREATE TABLE Products (" +
                    "pID INT PRIMARY KEY," +
                    "description VARCHAR(255)," +
                    "date DATE," +
                    "price DECIMAL(10, 2)," +
                    "weight DECIMAL(10, 2)," +
                    "location VARCHAR(255) DEFAULT 'Unknown'," +
                    "color VARCHAR(50) DEFAULT 'Unknown')";
            stmt.execute(createProducts);

            // Create Sales table
            String createSales = "CREATE TABLE Sales (" +
                    "sID INT PRIMARY KEY," +
                    "date DATE," +
                    "amount DECIMAL(10, 2)," +
                    "deliveryFee DECIMAL(10, 2))";
            stmt.execute(createSales);

            // Create salesItems table
            String createSalesItems = "CREATE TABLE salesItems (" +
                    "sID INT," +
                    "pID INT," +
                    "PRIMARY KEY (sID, pID)," +
                    "FOREIGN KEY (sID) REFERENCES Sales(sID)," +
                    "FOREIGN KEY (pID) REFERENCES Products(pID))";
            stmt.execute(createSalesItems);

            // Insert data
            String insertDonor1 = "INSERT INTO Donors (donorID, firstName, lastName, middleInitial, dateOfBirth, address, city, postalCode, province, gender, SSN, phone, email) " +
                    "VALUES (1, 'John', 'Doe', 'A', '1980-01-01', '123 Main St', 'Montreal', 'H1A1A1', 'QC', 'M', '123456789', '123-456-7890', 'john.doe@example.com')";

            String insertDonor2 = "INSERT INTO Donors (donorID, firstName, lastName, middleInitial, dateOfBirth, address, city, postalCode, province, gender, SSN, phone, email) " +
                    "VALUES (2, 'Jane', 'Smith', 'B', '1990-02-02', '456 Elm St', 'Laval', 'H2B2B2', 'QC', 'F', '987654321', '987-654-3210', 'jane.smith@example.com')";

            String insertDonation1 = "INSERT INTO Donations (dID, donorID, date, type, amount) " +
                    "VALUES (1, 1, '2024-07-10', 'money', 100.00)";

            stmt.executeUpdate(insertDonor1);
            stmt.executeUpdate(insertDonor2);
            stmt.executeUpdate(insertDonation1);

            // Query to get information about donors who live in Brossard
            String query = "SELECT donorID, firstName, lastName, dateOfBirth, phone, email, gender, SSN " +
                           "FROM Donors " +
                           "WHERE city = 'Brossard'";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int donorID = rs.getInt("donorID");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                Date dateOfBirth = rs.getDate("dateOfBirth");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String gender = rs.getString("gender");
                String ssn = rs.getString("SSN");

                System.out.println("Donor ID: " + donorID);
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Date of Birth: " + dateOfBirth);
                System.out.println("Phone: " + phone);
                System.out.println("Email: " + email);
                System.out.println("Gender: " + gender);
                System.out.println("SSN: " + ssn);
                System.out.println();
            }

            // Clean up
            stmt.executeUpdate("DROP TABLE salesItems");
            stmt.executeUpdate("DROP TABLE Sales");
            stmt.executeUpdate("DROP TABLE Products");
            stmt.executeUpdate("DROP TABLE Donations");
            stmt.executeUpdate("DROP TABLE Donors");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
