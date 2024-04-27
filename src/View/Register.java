package src.View;

import src.Model.Observer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * This class allows users to create an account in the application.
 */

public class Register extends JDialog implements Observer {
    private JPanel contentPane;
    private JButton buttonRegister;
    private JButton buttonSignIn;
    private JTextField tfUsername;
    private JTextField tfPassword;
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JTextField tfEmail;
    int totalExpenses;
    int savingsGoal;

    public Register() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonRegister);
        setLocationRelativeTo(null);

        buttonRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRegister();
            }
        });

        buttonSignIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onSignIn();
            }
        });
    }

    private void onRegister() {
        // Retrieve user input from text fields
        String firstName = tfFirstName.getText();
        String lastName = tfLastName.getText();
        String emailAddress = tfEmail.getText();
        String username = tfUsername.getText();
        String password = encrypt(tfPassword.getText());

        // Create an instance of CreateAccount and call createAccount() method
        CreateAccount createAccount = new CreateAccount();
        createAccount.createAccount(firstName, lastName, emailAddress, username, password);

        // Optionally, you can call createAccountAPI() method if needed
        // createAccount.createAccountAPI(username, password);

        // Close the registration dialog
        dispose();
    }

    private void onSignIn() {
        dispose();
        Login dialog = new Login();
        dialog.pack();
        dialog.setVisible(true);
    }
    @Override
    public void update(int totalExpenses, int savingsGoal) {
        this.totalExpenses = totalExpenses;
        this.savingsGoal = savingsGoal;
    }

    public static String encrypt(String plaintext) {
        String key = "5a1f63f8d568876d85e3f6bafec6d63c";
        try {
            byte[] keyBytes = key.getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte[] plaintextBytes = plaintext.getBytes();
            byte[] ciphertextBytes = cipher.doFinal(plaintextBytes);

            return Base64.getEncoder().encodeToString(ciphertextBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
