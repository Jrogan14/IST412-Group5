package Model;

public class User {
    String username;
    String password;
    int accountNumber;
    int routingNumber;

    public User(String id, String pwd, int accountNo, int routingNo) {
        this.username = id;
        this.password = pwd;
        this.accountNumber = accountNo;
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
