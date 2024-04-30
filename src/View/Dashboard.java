package src.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class Dashboard {
    private JPanel contentPane;
    private JLabel budgetTitle;
    private JPanel budgetFrame;
    private JPanel transactionPanel;
    private JLabel transactionTitle;
    private JButton addAccButton;
    private JButton withdrawButton;
    private JButton addBudgetButton;
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
    private JButton refreshBudgetButton;
    private JButton editBudgetButton;
    private JPanel budgetPanel;
    private JLabel rentLabel;
    private JLabel rentAmountLabel;
    private JLabel billsLabel;
    private JLabel billsAmountLabel;
    private JLabel groceriesLabel;
    private JLabel groceriesAmountLabel;
    private JLabel savingsLabel;
    private JLabel savingsAmountLabel;
    private JLabel checkingsLabel;
    private JLabel checkingsAmountLabel;

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
        addBudgetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create and display the budget creation GUI
                BudgetCreation budgetCreation = new BudgetCreation();
                JFrame budgetFrame = new JFrame("Budget");
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
        editBudgetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel = new DefaultTableModel(
                        new Object[][]{{"Test", 0.0}, {"Test", 0.0}, {"Test", 0.0},
                        {"Test", 0.0}, {"Test", 0.0}}, new String[]{"Category", "Amount"});
            }
        });
        refreshBudgetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = Login.getCurrentUser();
                try {
                    Connection connection = DriverManager.getConnection("jdbc:ucanaccess://src/bankdb.accdb");
                    String sql = "select Rent, Bills, Groceries, Savings, Checking from Budgets where Budgets.Username = ?";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, userName);
                    ResultSet budgetInfoResults = statement.executeQuery();
                    if (budgetInfoResults.next()) {
                        int rentAmount = budgetInfoResults.getInt("Rent");
                        int billsAmount = budgetInfoResults.getInt("Bills");
                        int groceriesAmount = budgetInfoResults.getInt("Groceries");
                        int savingsAmount = budgetInfoResults.getInt("Savings");
                        int checkingAmount = budgetInfoResults.getInt("Checking");
                        System.out.println("User found!");
                        rentAmountLabel.setText(String.valueOf(rentAmount));
                        billsAmountLabel.setText(String.valueOf(billsAmount));
                        groceriesAmountLabel.setText(String.valueOf(groceriesAmount));
                        savingsAmountLabel.setText(String.valueOf(savingsAmount));
                        checkingsAmountLabel.setText(String.valueOf(checkingAmount));
                    }
                    else {
                        System.err.println("No such user was found.");
                        JOptionPane.showMessageDialog(frame, "No budget was found.");
                    }
                }
                catch (SQLException ex){
                    System.err.println("Error: " + ex.getMessage());
                }
            }
        });
    }

    public void populateBudgetTable() {
        String username = Login.getCurrentUser(); // Get the current user

        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://src/bankdb.accdb")) {
            String sql = "select Rent, Bills, Groceries, Savings, Checking from Budgets where Budgets.Username = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, username);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        budgetTable.setModel(buildTableModel(rs));
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle any SQL exceptions
        }
    }

    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        // names of columns
        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }
        // data of the table
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }
}