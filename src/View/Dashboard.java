package src.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Dashboard {
    private JPanel contentPane;
    private JLabel budgetTitle;
    private JPanel budgetPanel;
    private JPanel transactionPanel;
    private JLabel transactionTitle;
    private JButton addAccButton;
    private JButton withdrawButton;
    private JButton editBudgetButton;
    private JTable budgetTable;
    private JPanel budgetViewPanel;
    private JButton depositButton;
    private JLabel accNameTitle;
    private JLabel accNumTitle;
    private JLabel routingNumTitle;
    private JLabel balanceTitle;
    private JLabel accountName;
    private JLabel accountNum;
    private JLabel routingNum;
    private JLabel totalBalance;
    private JButton refreshInfoButton;

    public void showDashboard() {

        // Create and configure the main frame for the dashboard
        JFrame frame = new JFrame("Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        // Set content pane of the frame
        frame.setContentPane(contentPane);

        // Make the frame visible
        frame.setVisible(true);

        // Add action listener for the "Edit Budget" button
        editBudgetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create and display the budget creation GUI
                BudgetCreation budgetCreation = new BudgetCreation();
                JFrame budgetFrame = new JFrame("Edit Budget");
                budgetFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                budgetFrame.setContentPane(budgetCreation.BudgetCreation);
                budgetFrame.pack();
                budgetFrame.setVisible(true);
                budgetFrame.setLocationRelativeTo(null);
            }
        });

        // Add action listener for the "Add Bank Account" button
        addAccButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddBankAccount menu = new AddBankAccount();
                menu.pack();
                menu.setVisible(true);
            }
        });

        // Add action listener for the "Refresh Info" button
        refreshInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                populateBudgetTable();
                String username = Login.getCurrentUser();

                try {
                    // Establish the connection to the database
                    Connection connection = DriverManager.getConnection("jdbc:ucanaccess://src/bankdb.accdb");

                    // Prepare SQL statement
                    String sql = "select Username, AccountName, AccountNo, RoutingNo, Balance from BankAccounts where BankAccounts.Username = ?";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, username);

                    // Execute the statement
                    ResultSet accInfoResults = statement.executeQuery();
                    if (accInfoResults.next()) {
                        String accName = accInfoResults.getString("AccountName");
                        int accNum = accInfoResults.getInt("AccountNo");
                        int routNum = accInfoResults.getInt("RoutingNo");
                        double balance = accInfoResults.getDouble("Balance");
                        System.out.println("User found!");
                        accountName.setText(accName);
                        accountNum.setText(String.valueOf(accNum));
                        routingNum.setText(String.valueOf(routNum));
                        totalBalance.setText(String.valueOf(balance));
                    } else {
                        System.err.println("No such user was found.");
                        JOptionPane.showMessageDialog(frame, "No bank account was found.");
                    }

                    // Close resources
                    statement.close();
                    connection.close();

                }
                catch (SQLException ex) {
                    System.err.println("Error: " + ex.getMessage());
                }
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Deposit menu = new Deposit();
                menu.pack();
                menu.setVisible(true);
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Withdraw menu = new Withdraw();
                menu.pack();
                menu.setVisible(true);
            }
        });
    }

    public void populateBudgetTable() {
        DefaultTableModel model = (DefaultTableModel) budgetTable.getModel();
        model.setRowCount(0); // Clear existing rows

        String username = Login.getCurrentUser(); // Get the current user

        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://src/bankdb.accdb")) {
            String sql = "SELECT Rent, Bills, Groceries, Savings, Checking FROM Budgets WHERE Username = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, username);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        Object[] rowData = {
                                rs.getDouble("Rent"),
                                rs.getDouble("Bills"),
                                rs.getDouble("Groceries"),
                                rs.getDouble("Savings"),
                                rs.getDouble("Checking")
                        };
                        model.addRow(rowData);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle any SQL exceptions
        }
    }
}