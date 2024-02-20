package View;

public class SignIn{

    public String getLoginInfo (String email, String password) {
        String loginInfo = email + " " + password;
        return loginInfo;
    }
}