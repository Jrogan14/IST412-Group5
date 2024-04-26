package src.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Dashboard {
    private JPanel contentPane;
    private JLabel dashboardTitle;
    private JLabel budgetTitle;
    private JPanel budgetPanel;
    private JPanel transactionPanel;
    private JLabel transactionTitle;
    private JButton addAccButton;
    private JButton withdrawButton;
    private JButton editBudgetButton;
    private JButton budgetPreferencesButton;
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

        // Create and add components to the frame
        JPanel mainPanel = new JPanel();
        JLabel titleLabel = new JLabel("Dashboard");
        mainPanel.add(titleLabel);

        // Set the main panel as the content pane of the frame
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
                String username = JOptionPane.showInputDialog("Please confirm your username");

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
                    }

                    // Close resources
                    statement.close();
                    connection.close();

                }
                // If user is not found
                catch (SQLException ex) {
                    System.err.println("Error finding user: " + ex.getMessage());
                }
            }
        });
    }
}