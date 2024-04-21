package src.Model;

public class BankAccount {
    String firstName;
    String lastName;
    int accountNo;
    int routingNo;
    String username;
    int balance;

    public BankAccount(String fname, String lname, int accountNum, int routingNum, String username, int bal) {
        this.firstName = fname;
        this.lastName = lname;
        this.accountNo = accountNum;
        this.routingNo = routingNum;
        this.username = username;
        this.balance = bal;
    }

    public BankAccount(String fname, String lname, int accountNum, int routingNum, int bal) {
        this.firstName = fname;
        this.lastName = lname;
        this.accountNo = accountNum;
        this.routingNo = routingNum;
        this.balance = bal;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public int getRoutingNo() {
        return routingNo;
    }

    public int getBalance() {
        return balance;
    }
}
