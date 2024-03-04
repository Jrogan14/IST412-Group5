package src.Model;

public class User {
    String email;
    String username;
    String password;
    int accountNumber;
    int routingNumber;

    public User(String mail, String id, String pwd, int accountNo, int routingNo) {
        this.email = mail;
        this.username = id;
        this.password = pwd;
        this.accountNumber = accountNo;
        this.routingNumber = routingNo;
    }

    public User(String id, String pwd, int accountNo, int routingNo) {
        this.username = id;
        this.password = pwd;
        this.accountNumber = accountNo;
        this.routingNumber = routingNo;
    }

    public User(String mail, String pwd, int routingNo) {
        this.email = mail;
        this.password = pwd;
        this.routingNumber = routingNo;
    }

    public void Authenticate(String id, String pwd) {

    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public int getRoutingNumber() {
        return this.routingNumber;
    }
}
