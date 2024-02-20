package View;

import java.util.ArrayList;
import java.util.List;

public class CreateBudget {
    
int expenses;
List<Integer> totalAmount = new ArrayList<Integer>();

public CreateBudget(int expenses, List<Integer> totalAmount) {
    this.expenses = expenses;
    this.totalAmount = totalAmount;
    }
}