package src.View;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Base64;

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

        // Authentication
        if (password.equals(getDecryptedPassword(username))) {
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

    // Gets user's password from database and decrypts it
    private String getDecryptedPassword(String username) {
        String decryptedPassword = "";
        String url = "jdbc:ucanaccess://src/bankdb.accdb"; // Database URL
        String sql = "SELECT Password FROM Users WHERE Username = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Set parameters for the prepared statement
            stmt.setString(1, username);

            // Execute the query
            try (ResultSet rs = stmt.executeQuery()) {
                // Check if the query returned any results
                if (rs.next()) {
                    decryptedPassword = decrypt(rs.getString("Password"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle any SQL exceptions
        }

        return decryptedPassword;
    }

    public static String decrypt(String ciphertext) {
        String key = "5a1f63f8d568876d85e3f6bafec6d63c";
        try {
            byte[] keyBytes = key.getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

            byte[] ciphertextBytes = Base64.getDecoder().decode(ciphertext);
            byte[] plaintextBytes = cipher.doFinal(ciphertextBytes);

            return new String(plaintextBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
