//package src.View;
//
//import javax.swing.*;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Dashboard {
//    private JPanel contentPane;
//    private JLabel dashboardTitle;
//    private JLabel budgetTitle;
//    private JPanel budgetPanel;
//    private JPanel transactionPanel;
//    private JLabel transactionTitle;
//    private JButton acctDetailsButton;
//    private JButton withdrawButton;
//    private JButton editBudgetButton;
//    private JTable budgetTable;
//    private JPanel budgetViewPanel;
//    private JButton depositButton;
//    private JLabel accNameTitle;
//    private JLabel accNumTitle;
//    private JLabel routingNumTitle;
//    private JLabel balanceTitle;
//    private JLabel accountName;
//    private JLabel accountNum;
//    private JLabel routingNum;
//    private JLabel totalBalance;
//
//    public void showDashboard() {
//
//        // Create and configure the main frame for the dashboard
//        JFrame frame = new JFrame("Dashboard");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(800, 600);
//        frame.setLocationRelativeTo(null);
//
//        // Create and add components to the frame
//        JPanel mainPanel = new JPanel();
//        JLabel titleLabel = new JLabel("Dashboard");
//        mainPanel.add(titleLabel);
//
//        // Set the main panel as the content pane of the frame
//        frame.setContentPane(contentPane);
//
//        // Make the frame visible
//        frame.setVisible(true);
//
//        // Add action listener for the "Edit Budget" button
//        editBudgetButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                // Create and display the budget creation GUI
//                BudgetCreation budgetCreation = new BudgetCreation();
//                JFrame budgetFrame = new JFrame("Edit Budget");
//                budgetFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                budgetFrame.setContentPane(budgetCreation.BudgetCreation);
//                budgetFrame.pack();
//                budgetFrame.setVisible(true);
//            }
//        });
//    }
//}

package src.View;

import src.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard {
    private JPanel contentPane;
    private JLabel dashboardTitle;
    private JLabel budgetTitle;
    private JPanel budgetPanel;
    private JPanel transactionPanel;
    private JLabel transactionTitle;
    private JButton acctDetailsButton;
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

    private User currentUser; // Add a field to store the currentUser

    // Constructor modified to accept the current user
    public Dashboard(User currentUser) {
        this.currentUser = currentUser;
    }

    public void showDashboard () {
        this.currentUser = currentUser; // Set the currentUser field

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
                BudgetCreation budgetCreation = new BudgetCreation(currentUser);
                JFrame budgetFrame = new JFrame("Edit Budget");
                budgetFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                budgetFrame.setContentPane(budgetCreation.BudgetCreation);
                budgetFrame.pack();
                budgetFrame.setVisible(true);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
