package Model;

/**
 * This class establishes the creation on screen for user budgeting.
 */
public class Budget {
    // Fields for budget details
    int totalExpenses;
    int savingsGoal;

    /**
     * @param totalExpenses Total expenses calculated or entered by the user.
     * @param savingsGoal Desired savings goal set by the user.
     */
    public Budget(int totalExpenses, int savingsGoal) {
        this.totalExpenses = totalExpenses;
        this.savingsGoal = savingsGoal;
    }
}
