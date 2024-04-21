package src.Controller;

import src.View.Login;
import src.View.Register;

public class App {
    public static void main(String[] args) {
        Login dialog = new Login();
        dialog.pack();
        dialog.setVisible(true);
    }
}
