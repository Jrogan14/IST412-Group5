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
     * Constructs an Admin Author object with the given code.
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
    
}
