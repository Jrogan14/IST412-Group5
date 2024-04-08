package View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class allows users to create an account in the application.
 */
public class CreateAccount {

    // --------------- Create Fields -----------------
    /**
     * Create fields for user login information such as:
     * username and password
     */
    String firstName;
    String lastName;
    String emailAddress;
    String username;
    String password;

    // ------------- Create Getters -------------------
    /**
     * This is a getter for the user's first name.
     * @return entered first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This is a getter for the user's last name.
     * @return entered last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This is a getter for the user's email address.
     * @return entered email address.
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * This is a getter for the username.
     * @return username created.
     */
    public String getUsername() {
        return username;
    }

    /**
     * This is a getter for the password.
     * @return password created.
     */
    public String getPassword() {
        return password;
    }

    // ------------- Create Constructors ----------------
    /**
     * This constructor initializes the user login information created.
     * @param firstName - User's legal first name.
     * @param lastName - User's legal last name.
     * @param emailAddress - User's desired email address for communications and authentification.
     * @param username - User generated account name for identification.
     * @param password - User generated passcode for account security.
     * This constructor also passes the information into the Microsoft Access Database (bankdb.accdb)
     * This entry is handled within the try-catch block
     */
    public void createAccount(String firstName, String lastName, String emailAddress, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;

        // Optionally, you can call createAccountAPI() method here if needed
        // createAccountAPI(username, password);

        // Inserting the user data into the database
        try {
            // Establish the connection to the database
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://IST412-Group5/src/bankdb.accdb");

            // Prepare SQL statement
            String sql = "INSERT INTO Users (Username, Password, FirstName, LastName, Email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, firstName);
            statement.setString(4, lastName);
            statement.setString(5, emailAddress);

            // Execute the statement
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }

            // Close resources
            statement.close();
            connection.close();

        }
        // If inserting the data doesn't work
        catch (SQLException e) {
            System.err.println("Error inserting user into database: " + e.getMessage());
        }
    }

    // --------- MAY BE OBSOLETE NOW -----------
    // Implementation of method stubs for API
    //public boolean createAccountAPI(String username, String password) {
    //    return false;
    //}

}