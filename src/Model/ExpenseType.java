package Model;

import java.util.ArrayList;

/**
 * This class categorizes the type of expense outlined by a user.
 */
public class ExpenseType {

    /**
     * This method takes an expense and adds it to a list of all user's expenses.
     * @param expense - Name of user defined expense.
     * @return result added to list of user expenses.
     */
    public ArrayList<String> Expenses(String expense){
        ArrayList<String> result = new ArrayList<String>();
        result.add(expense);
        return result;
    }
}
