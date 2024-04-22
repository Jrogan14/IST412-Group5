package src.Model;

public class Admin {
    String username;
    String password;
    int authCode;

    public Admin(String id, String pwd) {
        this.username = id;
        this.password = pwd;
    }

    public Admin(String id, String pwd, int code) {
        this.username = id;
        this.password = pwd;
        this.authCode = code;
    }

    public void Authenticate(String id, String pwd, int code) {
        if (id.equals(this.username)) {
            if (pwd.equals(this.password)) {
                if (code == this.authCode) {
                    System.out.println("Your admin access has been authenticated");
                }
                else {
                    System.out.println("Your code is incorrect");
                }
            }
            else {
                System.out.println("Your password is incorrect");
            }
        }
        else {
            System.out.println("Your username is incorrect");
        }
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public int getAuthCode() {
        return this.authCode;
    }
}
