package Assign6;

import java.util.*;

// Expense class
class Expense {
    String category;
    double amount;
    String date;

    Expense(String category, double amount, String date) {
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public String toString() {
        return date + " | " + category + " | ₹" + amount;
    }
}

// Tracker class
class ExpenseManager {
    ArrayList<Expense> list = new ArrayList<>();

    // Add
    void addExpense(String c, double a, String d) {
        list.add(new Expense(c, a, d));
        System.out.println("\nAdded Expense: " + c + " - ₹" + a);
    }

    // View
    void viewExpenses() {
        System.out.println("\n===== ALL EXPENSES =====\n");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ". " + list.get(i));
            System.out.println();
        }
    }

    // Delete
    void deleteExpense(int index) {
        if (index >= 0 && index < list.size()) {
            Expense e = list.remove(index);
            System.out.println("\nDeleted Expense: " + e);
        } else {
            System.out.println("Invalid index!");
        }
    }

    // Summary
    void summary() {
        HashMap<String, Double> map = new HashMap<>();
        double total = 0;

        for (Expense e : list) {
            total += e.amount;

            map.put(e.category,
                    map.getOrDefault(e.category, 0.0) + e.amount);
        }

        System.out.println("\n===== EXPENSE SUMMARY =====\n");
        System.out.println("Total Expenses: ₹" + total);

        System.out.println("\nBy Category:\n");
        for (String key : map.keySet()) {
            System.out.println(key + " : ₹" + map.get(key));
        }
    }

    // Monthly report
    void monthlyReport(String month) {
        HashMap<String, Double> map = new HashMap<>();
        double total = 0;

        for (Expense e : list) {
            if (e.date.substring(3, 10).equals(month)) {
                total += e.amount;

                map.put(e.category,
                        map.getOrDefault(e.category, 0.0) + e.amount);
            }
        }

        System.out.println("\n===== MONTHLY REPORT: " + month + " =====\n");
        System.out.println("Total for " + month + ": ₹" + total);

        System.out.println("\nBy Category:\n");
        for (String key : map.keySet()) {
            System.out.println(key + " : ₹" + map.get(key));
        }
    }
}

// Main class
public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager m = new ExpenseManager();

        // Sample data (same as yours)
        m.addExpense("Food", 120, "12-03-2026");
        m.addExpense("Shopping", 1200, "18-04-2026");
        m.addExpense("Shopping", 1100, "10-03-2026");
        m.addExpense("Entertainment", 200, "29-03-2026");

        int choice;

        do {
            System.out.println("\n1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Generate Summary");
            System.out.println("5. Monthly Report");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter category: ");
                    String c = sc.nextLine();

                    System.out.print("Enter amount: ");
                    double a = sc.nextDouble();

                    sc.nextLine();
                    System.out.print("Enter date (DD-MM-YYYY): ");
                    String d = sc.nextLine();

                    m.addExpense(c, a, d);
                    break;

                case 2:
                    m.viewExpenses();
                    break;

                case 3:
                    System.out.print("Enter index: ");
                    int i = sc.nextInt();
                    m.deleteExpense(i);
                    break;

                case 4:
                    m.summary();
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Enter month (MM-YYYY): ");
                    String month = sc.nextLine();
                    m.monthlyReport(month);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);

        sc.close();
    }
} 
