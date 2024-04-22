//package src.View;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * This class allows users to create a budget based on their financial
// * goals and rules of healthy financial practice.
// */
//public class CreateBudget {
//
//    /**
//     * Create fields of type Integer to store numerical expense and an ArrayList to store total expenses.
//     */
//    int expenses;
//    List<Integer> totalAmount = new ArrayList<Integer>();
//
//    /**
//     * This constructor takes the created expense and list of total expenses and initializes them.
//     * @param expenses - Expense value that user inputs.
//     * @param totalAmount - List of all added expenses.
//     */
//    public CreateBudget(int expenses, List<Integer> totalAmount) {
//        this.expenses = expenses;
//        this.totalAmount = totalAmount;
//    }
//
//
//    // Implement Strategy Pattern for approach to budget creation
//    // Either uses percentages or numerical values
//    private BudgetDivision strategy;
//
//    public CreateBudget(BudgetDivision strategy) {
//        this.strategy = strategy;
//    }
//
//    public void setStrategy(BudgetDivision strategy) {
//        this.strategy = strategy;
//    }
//
//    public void createBudget() {
//        strategy.createBudget();
//    }
//}

package src.View;

import java.util.HashMap;
import java.util.Map;

/**
 * This class allows users to create a budget based on their financial
 * goals and rules of healthy financial practice.
 */
public class CreateBudget {
    // Define budget categories
    public static final String RENT = "Rent";
    public static final String BILLS = "Bills";
    public static final String GROCERIES = "Groceries";
    public static final String SAVINGS = "Savings";
    public static final String CHECKING = "Checking";

    // Create a map to store budget for each category
    private Map<String, Integer> budgetMap;

    /**
     * Constructor to initialize the budget map.
     */
    public CreateBudget() {
        budgetMap = new HashMap<>();
    }

    /**
     * Set budget for a specific category.
     * @param category The budget category.
     * @param amount The budget amount.
     */
    public void setBudget(String category, int amount) {
        budgetMap.put(category, amount);
    }

    /**
     * Get budget for a specific category.
     * @param category The budget category.
     * @return The budget amount for the specified category, or 0 if the category does not exist.
     */
    public int getBudget(String category) {
        return budgetMap.getOrDefault(category, 0);
    }

    /**
     * Add a user-specified value to the total budget amount for the specified category.
     * @param category The budget category.
     * @param value The value to add to the budget.
     */
    public void addBudgetValue(String category, int value) {
        // Get current budget for the category
        int currentBudget = budgetMap.getOrDefault(category, 0);
        // Add the value to the current budget
        currentBudget += value;
        // Update the budget for the category
        budgetMap.put(category, currentBudget);
    }
}