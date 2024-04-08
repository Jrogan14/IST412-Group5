package src.View;

import src.Model.Observer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton dashboardButton;
    int totalExpenses;
    int savingsGoal;

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
        // Retrieve user input from text fields
        String firstName = tfFirstName.getText();
        String lastName = tfLastName.getText();
        String emailAddress = tfEmail.getText();
        String username = tfUsername.getText();
        String password = tfPassword.getText();

        // Create an instance of CreateAccount and call createAccount() method
        CreateAccount createAccount = new CreateAccount();
        createAccount.createAccount(firstName, lastName, emailAddress, username, password);

        // Optionally, you can call createAccountAPI() method if needed
        // createAccount.createAccountAPI(username, password);

        // Close the registration dialog
        dispose();
    }
    @Override
    public void update(int totalExpenses, int savingsGoal) {
        this.totalExpenses = totalExpenses;
        this.savingsGoal = savingsGoal;
    }
}
