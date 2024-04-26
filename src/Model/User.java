//package src.Model;
//public class User implements Observer{
//    String email;
//    String username;
//    String password;
//    String firstName;
//    String lastName;
//    public int totalExpenses;
//    public int savingsGoal;
//    public User(String mail, String id, String pwd, String fname, String lname) {
//        this.email = mail;
//        this.username = id;
//        this.password = pwd;
//        this.firstName = fname;
//        this.lastName = lname;
//    }
//    public User(String id, String pwd, String fname, String lname) {
//        this.username = id;
//        this.password = pwd;
//        this.firstName = fname;
//        this.lastName = lname;
//    }
//    public User(String mail, String pwd) {
//        this.email = mail;
//        this.password = pwd;
//    }
//    public void Authenticate(String id, String pwd) {
//        if (id.equals(this.username)) {
//            if (pwd.equals(this.password)) {
//                System.out.println("You are authenticated");
//            }
//            else {
//                System.out.println("Your password is incorrect");
//            }
//        }
//        else {
//            System.out.println("Your username is incorrect");
//        }
//    }
//    public String getUsername() {
//        return this.username;
//    }
//    public String getPassword() {
//        return this.password;
//    }
//    public String getFirstName() {
//        return this.firstName;
//    }
//    public String getLastName() {
//        return this.lastName;
//    }
//    @Override
//    public void update(int totalExpenses, int savingsGoal) {
//        this.totalExpenses = totalExpenses;
//        this.savingsGoal = savingsGoal;
//    }
//}

package src.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private static User currentUser;

    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public User(String email, String username, String password, String firstName, String lastName) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // New constructor to create a User object with username and password only
    public User(String id, String pwd) {
        this.username = id;
        this.password = pwd;
    }

    public static User authenticate(String username, String password) {
        // Connect to the database and authenticate user
        String url = "jdbc:ucanaccess://src/bankdb.accdb";
        String sql = "SELECT * FROM Users WHERE Username = ? AND Password = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String email = rs.getString("Email");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                currentUser = new User(email, username, password, firstName, lastName);
                return currentUser;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
