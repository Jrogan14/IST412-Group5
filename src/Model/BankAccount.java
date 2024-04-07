package src.Model;

public class BankAccount {
    int accountNo;
    int routingNo;
    String username;
    int balance;

    public BankAccount(int accountNum, int routingNum, String username, int bal) {
        this.accountNo = accountNum;
        this.routingNo = routingNum;
        this.username = username;
        this.balance = bal;
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
