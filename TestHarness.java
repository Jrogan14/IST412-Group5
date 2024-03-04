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