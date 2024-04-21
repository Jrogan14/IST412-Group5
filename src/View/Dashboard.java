package src.View;

import javax.swing.*;

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
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}