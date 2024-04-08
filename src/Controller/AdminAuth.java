package Controller;

/**
 * This class establishes a code for authorization of an admin level user.
 */
public class AdminAuth {

    /**
     * Create field of type int for admin authorization code.
     */
    int adminAuthCode;

    /**
     * This constructor initializes the Admin Author with the given code.
     * @param adminAuthCode - Code associated with admin permission.
     */
    public AdminAuth(int adminAuthCode) {
        this.adminAuthCode = adminAuthCode;
    }

    /**
     * This is a getter that returns the authorization code.
     * @return the admin authorization code.
     */
    public int getAdminAuthCode() {
        return adminAuthCode;
    }

    // Implementation of method stubs for API
    public boolean authenticateAdmin(String username, String password) {
        return false;
    }
    
}
