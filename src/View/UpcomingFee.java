package src.View;

import src.Model.Budget;

public class UpcomingFee {
    Budget budget;

    /**
     * @param budget The budget used to determine upcoming fees and payments.
     */
    public UpcomingFee(Budget budget) {
        this.budget = budget;
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
