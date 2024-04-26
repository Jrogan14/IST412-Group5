package src.View;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Deposit extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField tfUsername;
    private JTextField tfDeposit;

    public Deposit() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setLocationRelativeTo(null);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    // Get user balance
    private double getBalance() {
        String username = tfUsername.getText();
        try {
            // Establish the connection to the database
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://src/bankdb.accdb");

            // Prepare SQL statement
            String sql = "select Username, Balance from BankAccounts where BankAccounts.Username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            // Execute the statement
            ResultSet accInfoResults = statement.executeQuery();
            if (accInfoResults.next()) {
                double balance = accInfoResults.getDouble("Balance");
                System.out.println("User's balance: " + balance);
                return balance;
            } else {
                System.err.println("No user was found.");
            }
            // Close resources
            statement.close();
            connection.close();
        }
        // If user is not found
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return 0;
    }

    private void onOK() {
        StringBuilder errors = new StringBuilder();
        String username = "";
        double deposit = 0;
        // verify fields
        if (tfUsername.getText().isEmpty()) {
            errors.append("Username must not be empty.\n");
        } else {
            username = tfUsername.getText();
        }
        if (tfDeposit.getText().isEmpty()) {
            errors.append("Deposit must not be empty.\n");
        } else {
            try {
                deposit = Double.parseDouble(tfDeposit.getText());
            } catch (NumberFormatException ex) {
                errors.append("Deposit must be a number.\n");
            }
        }

        // display errors
        if (errors.length() > 0) {
            JOptionPane.showMessageDialog(this, errors.toString(), "Errors", JOptionPane.WARNING_MESSAGE);
        } else {
            double balance = getBalance();
            balance = balance + deposit;

            // Updating balance to reflect deposit
            try {
                // Establish the connection to the database
                Connection connection = DriverManager.getConnection("jdbc:ucanaccess://src/bankdb.accdb");

                // Prepare SQL statement
                String sql = "UPDATE BankAccounts SET Balance = ? WHERE Username = ?";
                PreparedStatement updateBalance = connection.prepareStatement(sql);
                updateBalance.setDouble(1, balance);
                updateBalance.setString(2, username);
                // Execute the statement
                updateBalance.executeUpdate();
                System.out.println("New balance is " + balance);
                // Close resources
                updateBalance.close();
                connection.close();
            }
            // If inserting the data doesn't work
            catch (SQLException e) {
                System.err.println("Error updating balance: " + e.getMessage());
            }
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
