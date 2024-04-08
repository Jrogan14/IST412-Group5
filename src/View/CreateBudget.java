package src.View;

import java.util.ArrayList;
import java.util.List;

/**
 * This class allows users to create a budget based on their financial
 * goals and rules of healthy financial practice.
 */
public class CreateBudget {

    /**
     * Create fields of type Integer to store numerical expense and an ArrayList to store total expenses.
     */
    int expenses;
    List<Integer> totalAmount = new ArrayList<Integer>();

    /**
     * This constructor takes the created expense and list of total expenses and initializes them.
     * @param expenses - Expense value that user inputs.
     * @param totalAmount - List of all added expenses.
     */
    public CreateBudget(int expenses, List<Integer> totalAmount) {
        this.expenses = expenses;
        this.totalAmount = totalAmount;
    }


    // Implement Strategy Pattern for approach to budget creation
    // Either uses percentages or numerical values
    private BudgetDivision strategy;

    public CreateBudget(BudgetDivision strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(BudgetDivision strategy) {
        this.strategy = strategy;
    }

    public void createBudget() {
        strategy.createBudget();
    }
}