package src.View;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

/**
 * This class allows users to log in to application using established credentials.
 */

public class Login extends JDialog {
    private JPanel contentPane;
    private JButton buttonConfirm;
    private JButton buttonCancel;
    private JTextField tfUsername;
    private JPasswordField tfPassword;
    private JButton createAccountButton;

    public Login() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonConfirm);
        setLocationRelativeTo(null);

        buttonConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        createAccountButton.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Register dialog = new Register();
                dialog.pack();
                dialog.setVisible(true);
            }
        }));

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

    private void onOK() {
        // Get entered username and password
        String username = tfUsername.getText();
        String password = new String(tfPassword.getPassword());

        // Validate credentials
        boolean validCredentials = validateCredentials(username, password);

        if (validCredentials) {
            // Close the login dialog
            dispose();

            // Open the dashboard view
            Dashboard dashboard = new Dashboard();
            // Code to display the dashboard UI goes here
            // Assuming you have a method to display the dashboard UI, let's call it showDashboard()
            dashboard.showDashboard();
            dispose();
        } else {
            // Display error message
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private boolean validateCredentials(String username, String password) {
        String url = "jdbc:ucanaccess://src/bankdb.accdb"; // Database URL
        String sql = "SELECT * FROM Users WHERE Username = ? AND Password = ?";
        boolean validCredentials = false;

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Set parameters for the prepared statement
            stmt.setString(1, username);
            stmt.setString(2, password);

            // Execute the query
            try (ResultSet rs = stmt.executeQuery()) {
                // Check if the query returned any results
                if (rs.next()) {
                    // User exists in the database
                    validCredentials = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle any SQL exceptions
        }

        return validCredentials;
    }
}
