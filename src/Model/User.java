package src.Model;

public class User {
    String email;
    String username;
    String password;
    String firstName;
    String lastName;

    public User(String mail, String id, String pwd, String fname, String lname) {
        this.email = mail;
        this.username = id;
        this.password = pwd;
        this.firstName = fname;
        this.lastName = lname;
    }

    public User(String id, String pwd, String fname, String lname) {
        this.username = id;
        this.password = pwd;
        this.firstName = fname;
        this.lastName = lname;
    }

    public User(String mail, String pwd) {
        this.email = mail;
        this.password = pwd;
    }

    public void Authenticate(String id, String pwd) {

    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
