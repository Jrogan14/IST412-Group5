package src.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import src.Model.User;

public class BudgetCreation {
    JPanel BudgetCreation;
    private JTable editBudget;
    private JButton saveBudgetButton;
    private JButton clearBudgetButton;

    // Connection details for your database
    private static final String DB_URL = "jdbc:ucanaccess://src/bankdb.accdb";
    //private static final String USERNAME = getCurrentUser().getUsername();
    private static final User USER = new User("abc@gmail.com", "abc", "bank_account",
                "new", "user");
    private static final String USERNAME = USER.getUsername();
    private static final String PASSWORD = USER.getPassword();
    public String getUsername() {
        String userName = USER.getUsername();
        return userName;
    }
    public BudgetCreation() {
        // Create table model and set it to the JTable
        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[][]{{"Rent", 0.0}, {"Bills", 0.0}, {"Groceries", 0.0},
                        {"Savings", 0.0}, {"Checking", 0.0}},
                new String[]{"Category", "Amount"});
        editBudget.setModel(tableModel);

        // Add action listener for the "Save Budget" button
        saveBudgetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Save the budget data to the database
                saveBudgetDataToDatabase();
            }
        });

        // Add action listener for the "Clear Budget" button
        clearBudgetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear the budget data
                clearBudgetData();
            }
        });
    }

    // Method to save the budget data to the database
    private void saveBudgetDataToDatabase() {
        DefaultTableModel tableModel = (DefaultTableModel) editBudget.getModel();
        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO Budgets (Category, Amount, Username) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                // Iterate through rows and save data to database
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    String category = (String) tableModel.getValueAt(i, 0);
                    Double amount = (Double) tableModel.getValueAt(i, 1);
                    pstmt.setString(1, category);
                    pstmt.setDouble(2, amount);
                    pstmt.setString(3, getUsername());
                    pstmt.executeUpdate();
                }
                JOptionPane.showMessageDialog(BudgetCreation, "Budget saved successfully to the database!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(BudgetCreation, "Error saving budget to the database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to clear the budget data
    private void clearBudgetData() {
        DefaultTableModel tableModel = (DefaultTableModel) editBudget.getModel();
        // Iterate over each row and set the amount value to 0.0
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            tableModel.setValueAt(0.0, i, 1);
        }
    }

    // You may add more methods as needed

    public JPanel getBudgetCreationPanel() {
        return BudgetCreation;
    }
}
