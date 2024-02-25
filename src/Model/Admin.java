package Model;

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
