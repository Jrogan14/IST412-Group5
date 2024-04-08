package src.Controller;

import src.Model.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * This class establishes the creation on screen for user budgeting.
 */
public class Budget {
    // Fields for budget details
    static int totalExpenses;
    static int savingsGoal;
    static List<Observer> observers = new ArrayList<Observer>();

    /**
     * @param totalExpenses Total expenses calculated or entered by the user.
     * @param savingsGoal Desired savings goal set by the user.
     */
    public Budget(int totalExpenses, int savingsGoal) {
        Budget.totalExpenses = totalExpenses;
        Budget.savingsGoal = savingsGoal;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public static void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(totalExpenses, savingsGoal);
        }
    }

    public static void setTotalExpenses(int totalExpenses) {
        Budget.totalExpenses = totalExpenses;
        notifyObservers();
    }

    public void setSavingsGoal(int savingsGoal) {
        Budget.savingsGoal = savingsGoal;
        notifyObservers();
    }
}
