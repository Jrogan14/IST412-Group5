package src.Controller;

import src.Model.Budget;
import src.Model.Observer;

public class UpcomingFee implements Observer {
    Budget budget;
    private int totalExpenses;
    private int savingsGoal;

    /**
     * @param budget The budget used to determine upcoming fees and payments.
     */
    public UpcomingFee(Budget budget) {
        this.budget = budget;
    }

    @Override
    public void update(int totalExpenses, int savingsGoal) {
        this.totalExpenses = totalExpenses;
        this.savingsGoal = savingsGoal;
        notifyUpcomingFees();
    }
    /**
     * This method checks the budget for any upcoming fees or payments and notifies
     * the user accordingly, such as in-app notifications.
     */
    public void notifyUpcomingFees() {
        // Implementation to check for upcoming fees and notify the user
        System.out.println("Checking for upcoming fees");
    }
}
