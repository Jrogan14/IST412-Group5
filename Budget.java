package src.Model;

/**
 * This class establishes the creation on screen for user budgeting.
 */
public class Budget {
    // Fields for budget details
    int totalExpenses;
    int savingsGoal;
    List<Observer> observers = new ArrayList<Observer>();

    /**
     * @param totalExpenses Total expenses calculated or entered by the user.
     * @param savingsGoal Desired savings goal set by the user.
     */
    public Budget(int totalExpenses, int savingsGoal) {
        this.totalExpenses = totalExpenses;
        this.savingsGoal = savingsGoal;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(totalExpenses, savingsGoal);
        }
    }

    public void setTotalExpenses(int totalExpenses) {
        this.totalExpenses = totalExpenses;
        notifyObservers();
    }

    public void setSavingsGoal(int savingsGoal) {
        this.savingsGoal = savingsGoal;
        notifyObservers();
    }
}
