package src.Controller;

import src.View.Login;
import src.View.Register;

public class App {
    public static void main(String[] args) {
        Register dialog = new Register();
        Login dialog2 = new Login();
        dialog.pack();
        dialog2.pack();
        dialog.setVisible(true);
        dialog2.setVisible(true);
        //System.exit(0);
    }
}
