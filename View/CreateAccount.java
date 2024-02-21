package View;

/**
 * This class allows users to create an account in the application.
 */
public class CreateAccount {

    /**
     * Create fields for user login information such as:
     * username, password, and at minimum 1 bank account routing number
     */
    String username;
    String password;
    int routingNumber;


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

    /**
     * This is a getter for the routing number of the chosen financial institution.
     * @return routing number of financial account.
     */
    public int getRoutingNumber() {
        return routingNumber;
    }

    /**
     * This constructor initializes the user login information created.
     * @param username - User generated account name for identification.
     * @param password - User generated passcode for account security.
     * @param routingNumber - Financial institution routing number to access or preform transactions.
     */
    public void createAccount(String username, String password, int routingNumber) {
        this.username = username;
        this.password = password;
        this.routingNumber = routingNumber;
    }

}