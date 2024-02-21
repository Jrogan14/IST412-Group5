package View;

import java.util.ArrayList;
import java.util.List;

/**
 * This class allows users to create a budget based on their financial
 * goals and rules of healthy financial practice.
 */
public class CreateBudget {

    /**
     * Create field of type Integer to store numerical expense and an ArrayList to store total expenses.
     */
    int expenses;
    List<Integer> totalAmount = new ArrayList<Integer>();

    /**
     * This object takes
     * @param expenses
     * @param totalAmount
     */
    public CreateBudget(int expenses, List<Integer> totalAmount) {
        this.expenses = expenses;
        this.totalAmount = totalAmount;
    }
}