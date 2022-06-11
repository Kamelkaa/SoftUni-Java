package lab.task_03_BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Integer, BankAccount> accountsMap = new HashMap<>();

        while (!input.equals("End")) {
            String[] inputInfo = input.split("\\s+");
            String command = inputInfo[0];
            String output = "";

            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    accountsMap.put(bankAccount.getId(), bankAccount);

                    output = String.format("Account ID%d created%n", bankAccount.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(inputInfo[1]);
                    int amount = Integer.parseInt(inputInfo[2]);
                    BankAccount account = accountsMap.get(id);

                    output = executeIfNotNull(account, b -> {
                        b.deposit(amount);
                        return String.format("Deposited %d to ID%d%n", amount, id);
                    });
                    break;
                case "SetInterest":
                    double interestAmount = Double.parseDouble(inputInfo[1]);
                    BankAccount.setInterestRate(interestAmount);
                    break;
                case "GetInterest":
                    int theId = Integer.parseInt(inputInfo[1]);
                    int years = Integer.parseInt(inputInfo[2]);
                    BankAccount theAccount = accountsMap.get(theId);

                    output = executeIfNotNull(theAccount, b -> {
                        double interest = b.getInterest(years);
                        return String.format("%.2f%n", interest);
                    });
                    break;
            }

            System.out.print(output);
            input = scanner.nextLine();
        }
    }

    public static String executeIfNotNull(BankAccount bankAccount, Function<BankAccount, String> function) {
        if (bankAccount == null) {
            return "Account does not exist\n";
        }
        return function.apply(bankAccount);
    }
}
