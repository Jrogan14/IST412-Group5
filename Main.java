package TestHarness;

import com.auth0.example.CallbackServlet;
import com.auth0.example.Auth0Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Instantiate the controllers:
        Auth0Filter auth0Filter = new Auth0Filter();
        CallbackServlet callbackServlet = new CallbackServlet();
        // Testing:
        testFilter(auth0Filter);
        testCallBack(callbackServlet);
        // Mock data for testing
        String adminUsername = "admin";
        String adminPassword = "password";
        String userUsername = "user";
        String userPassword = "userpassword";
        int adminAuthCode = 1234;
        
        // Instantiate controllers with mock data
        AdminAuth adminAuth = new AdminAuth(adminAuthCode);
        UpdatePassword updatePassword = new UpdatePassword();
        
        // Instantiate views with mock data
        CreateAccount createAccount = new CreateAccount();
        SignIn signIn = new SignIn();
        CreateBudget createBudget = new CreateBudget();
        ViewBudget viewBudget = new ViewBudget();
        ViewInfo viewInfo = new ViewInfo();
        UpcomingFee upcomingFee = new UpcomingFee();
        
        // Test AdminAuth controller
        System.out.println("Testing Admin Authentication:");
        boolean adminAuthResult = adminAuth.authenticateAdmin(adminUsername, adminPassword);
        System.out.println("Expected: true | Actual: " + adminAuthResult);
        
        // Test UpdatePassword controller
        System.out.println("Testing Update Password:");
        boolean updatePasswordResult = updatePassword.updateUserPassword(userUsername, userPassword, "newPassword");
        System.out.println("Expected: true | Actual: " + updatePasswordResult);
        
        // Test SignIn view
        System.out.println("Testing Sign In:");
        boolean signInResult = signIn.displaySignIn(userUsername, userPassword);
        System.out.println("Expected: true | Actual: " + signInResult);
        
        // Test CreateAccount view
        System.out.println("Testing Create Account:");
        boolean createAccountResult = createAccount.displayCreateAccount(userUsername, userPassword, "user@email.com");
        System.out.println("Expected: true | Actual: " + createAccountResult);
        
        // Test CreateBudget view
        System.out.println("Testing Create Budget:");
        boolean createBudgetResult = createBudget.displayCreateBudget();
        System.out.println("Expected: true | Actual: " + createBudgetResult);
        
        // Test ViewBudget view
        System.out.println("Testing View Budget:");
        boolean viewBudgetResult = viewBudget.displayBudgetDetails();
        System.out.println("Expected: true | Actual: " + viewBudgetResult);
        
        // Test ViewInfo view
        System.out.println("Testing View Information:");
        boolean viewInfoResult = viewInfo.displayUserInfo();
        System.out.println("Expected: true | Actual: " + viewInfoResult);
        
        // Test UpcomingFee view
        System.out.println("Testing Upcoming Fees:");
        boolean upcomingFeeResult = upcomingFee.displayUpcomingFees();
        System.out.println("Expected: true | Actual: " + upcomingFeeResult);
        
        // Indicate the end of tests
        System.out.println("All tests completed.");
    }
    private static void testFilter(Auth0Filter filter) {
        // Instantiate Http objects:
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        FilterChain filterChain = new FilterChain() {
            public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException {
                // test the filter chain behavior
                System.out.println("Filter chain executed successfully.");
            }
        };
        try {
            filter.doFilter(request, response, filterChain);
            System.out.println("Auth0Filter test has passed.");
        } catch (IOException | ServletException e) {
            System.out.println("Auth0Filter test failed: " + e.getMessage());
        }
    }
    private static void testCallback(CallbackServlet callbackServlet) {
        // Same as filter but for callback:
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        try {
            callbackServlet.doGet(request, response);
            System.out.println("CallbackServlet test passed.");
        } catch (IOException | ServletException e) {
            System.out.println("CallbackServlet test failed: " + e.getMessage());
        }
    }
}