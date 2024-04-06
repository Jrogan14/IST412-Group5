package src.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class allows users to create an account in the application.
 */

public class Register extends JDialog {
    private JPanel contentPane;
    private JButton buttonRegister;
    private JButton buttonSignIn;
    private JTextField tfUsername;
    private JTextField tfPassword;
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JTextField tfEmail;

    public Register() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonRegister);

        buttonRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonSignIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    public static void main(String[] args) {
        Register dialog = new Register();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
