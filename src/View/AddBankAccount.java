package src.View;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBankAccount extends JDialog {
    private JPanel contentPane;
    private JTextField tfAccountName;
    private JTextField tfAccountNum;
    private JTextField tfRoutingNum;
    private JTextField tfInitialBal;
    private JButton buttonConfirm;
    private JButton buttonCancel;
    private JTextField tfUsername;

    public AddBankAccount() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonConfirm);

        buttonConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onConfirm();
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

    private void onConfirm() {
        StringBuilder errors = new StringBuilder();
        String username = "", accName = "";
        int accNo = 0, routingNo = 0;
        double bal = 0;
        // verify fields
        if (tfUsername.getText().isEmpty()) {
            errors.append("Username must not be empty.\n");
        } else {
            username = tfUsername.getText();
        }
        if (tfAccountName.getText().isEmpty()) {
            errors.append("Bank Holder Name must not be empty.\n");
        } else {
            accName = tfAccountName.getText();
        }
        if (tfAccountNum.getText().isEmpty()) {
            errors.append("Account Number must not be empty.\n");
        } else {
            try {
                accNo = Integer.parseInt(tfAccountNum.getText());
            } catch (NumberFormatException ex) {
                errors.append("Account Number must be a number.\n");
            }
        }
        if (tfRoutingNum.getText().isEmpty()) {
            errors.append("Routing Number must not be empty.\n");
        } else if (tfRoutingNum.getText().length() != 9) {
            errors.append("Routing Number must be 9 digits.\n");
        }
            else {
                try {
                    routingNo = Integer.parseInt(tfRoutingNum.getText());
                } catch (NumberFormatException ex) {
                    errors.append("Routing Number must be a number.\n");
                }
            }
        if (tfInitialBal.getText().isEmpty()) {
            errors.append("Initial Balance must not be empty.\n");
        } else {
            try {
                bal = Double.parseDouble(tfInitialBal.getText());
            } catch (NumberFormatException ex) {
                errors.append("Initial Balance must be a number.\n");
            }
        }
        // display errors
        if (errors.length() > 0) {
            JOptionPane.showMessageDialog(this, errors.toString(), "Errors", JOptionPane.WARNING_MESSAGE);
        } else {
            // Inserting the user data into the database
            try {
                // Establish the connection to the database
                Connection connection = DriverManager.getConnection("jdbc:ucanaccess://src/bankdb.accdb");

                // Prepare SQL statement
                String sql = "INSERT INTO BankAccounts (Username, AccountName, AccountNo, RoutingNo, Balance) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, username);
                statement.setString(2, accName);
                statement.setInt(3, accNo);
                statement.setInt(4, routingNo);
                statement.setDouble(5, bal);

                // Execute the statement
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new bank account was inserted successfully!");
                }

                // Close resources
                statement.close();
                connection.close();

            }
            // If inserting the data doesn't work
            catch (SQLException e) {
                System.err.println("Error inserting bank account into database: " + e.getMessage());
            }
        }

        dispose();
    }

    private void onCancel() {
        dispose();
    }
}
