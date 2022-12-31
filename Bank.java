package Project;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {
    private Map<Integer, BankAccount> accounts;
    private int nextAccountNumber;

    public Bank() {
        accounts = new HashMap<>();
        Random random = new Random();
        nextAccountNumber = random.nextInt(10000) + 1;
    }

    public BankAccount createAccount(String accountHolder, String accountType, double interestRate) {
        BankAccount account = new BankAccount(nextAccountNumber, accountHolder, accountType, interestRate);
        accounts.put(nextAccountNumber, account);
        nextAccountNumber++;
        return account;
    }

    public BankAccount getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

    public BankAccount closeAccount(int accountNumber) {
        return accounts.remove(accountNumber);
    }

    public void applyInterestToall() {
        for (BankAccount account : accounts.values()) {
            account.applyInterestRate();
        }
    }

}
