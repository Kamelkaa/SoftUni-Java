package lab.task_03_BankAccount;

public class BankAccount {
    private static int accountNextId = 1;
    private static double interestRate = 0.02;

    private int id;
    private double balance;

    public BankAccount() {
        this.id = accountNextId;
        accountNextId++;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int years) {
        return this.balance * interestRate * years;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return id;
    }
}
