package src.Controller;

import java.util.ArrayList;
import java.util.List;
import src.Model.Budget;

import static src.Controller.Budget.setTotalExpenses;

/**
 * This class allows users to create a budget based on their financial
 * goals and rules of healthy financial practice.
 */
public class CreateBudget {
    private Budget budget;
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
    public CreateBudget(int expenses, List<Integer> totalAmount, Budget budget) {
        this.expenses = expenses;
        this.totalAmount = totalAmount;
        this.budget = budget;
    }

    public void updateBudget(){
        totalAmount.add(expenses);
        int totalExpenses = 0;
        for (Integer integer : totalAmount) {
            totalExpenses += integer;
        }
        setTotalExpenses(totalExpenses);
    }

    private int calculateTotalExpenses() {
        int sum = 0;
        for (int amount : totalAmount) {
            sum += amount;
        }
        return sum;
    }
}