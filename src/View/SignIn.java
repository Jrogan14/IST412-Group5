package src.View;

/**
 * This class allows users to log in to application using established credentials.
 */
public class SignIn {

    /**
     * This method takes the users login information and validates it.
     * Future: It validates their existence and credentials for sign in process.
     * @param username - Account name created by user.
     * @param password - Security key created by user.
     * @return login credentials.
     */
    public String getLoginInfo (String username, String password) {
        String loginInfo = username + " " + password;
        return loginInfo;
    }

    // Implementation of method stubs for API
    public boolean signIn(String username, String password) {
        return false;
    }
}