package src.Controller;

/**
 * This class establishes a code for authorization of an admin level user.
 */
public class AdminAuth {

    /**
     * Create field of type int for admin authorization code.
     */
    int adminAuthCode;
    String adminUsername;
    String adminPassword;
    public static boolean authenticated = false;

    /**
     * This constructor initializes the Admin Author with the given code.
     * @param adminAuthCode - Code associated with admin permission.
     */
    public AdminAuth(int adminAuthCode) {
        this.adminAuthCode = adminAuthCode;
    }
    public AdminAuth(int adminAuthCode, String username, String password) {
        this.adminAuthCode = adminAuthCode;
        this.adminUsername = username;
        this.adminPassword = password;
    }
    /**
     * This is a getter that returns the authorization code.
     * @return the admin authorization code.
     */
    public int getAdminAuthCode() {
        return adminAuthCode;
    }
    public void setAdminAuthCode(int authCode) {
        this.adminAuthCode = authCode;
    }
    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
    // Implementation of method stubs for API
    public boolean authenticateAdmin(int adminAuthCode, String username, String password) {
        if (adminAuthCode == this.adminAuthCode) {
            if (username.equals(this.adminUsername)) {
                if (password.equals(this.adminPassword)) {
                    authenticated = true;
                }
                else {
                    authenticated = false;
                }
            }
            else {
                authenticated = false;
            }
        }
        else {
            authenticated = false;
        }
        return authenticated;
    }
    
}
