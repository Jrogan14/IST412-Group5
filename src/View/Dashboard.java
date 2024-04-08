package src.View;

import javax.swing.*;

public class Dashboard {
    private JLabel dashboardTitle;
    private JLabel budgetTitle;
    private JPanel budgetPanel;
    private JPanel transactionPanel;
    private JLabel transactionTitle;
    private JButton acctDetailsButton;
    private JButton settingsButton;
    private JScrollPane bankInfoPanel;
    private JButton editBudgetButton;
    private JButton budgetPreferencesButton;
    private JTable budgetTable;
    private JPanel budgetViewPanel;

    public void showDashboard() {
        // Create and configure the main frame for the dashboard
        JFrame frame = new JFrame("Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Adjust as needed
        frame.setSize(800, 600); // Adjust the size as needed
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        // Create and add components to the frame
        JPanel mainPanel = new JPanel();
        JLabel titleLabel = new JLabel("Dashboard");
        mainPanel.add(titleLabel);

        // Add more components as needed

        // Set the main panel as the content pane of the frame
        frame.setContentPane(mainPanel);

        // Make the frame visible
        frame.setVisible(true);
    }
}