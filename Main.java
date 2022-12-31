package Project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scan = new Scanner(System.in);
        int option = -1;
        int con = 0;
        double amount = 0.0;
        do {
            System.out.println("--------------------------------------------");
            System.out.println("[1]. Create account       [2]. Check balance");
            System.out.println("[3]. Deposit              [4]. Withdraw     ");
            System.out.println("[5]. Transfer             [6]. Apply interest");
            System.out.println("[7]. Close account        [0]. Quit         ");
            System.out.println("--------------------------------------------");
            System.out.print("Enter option: ");
            option = scan.nextInt();
            switch (option) {
                case 1:
                    System.out.println("--------------------------------------------");
                    System.out.print("Enter account holder: ");
                    String accountHolder = scan.next();
                    System.out.print("Enter account type: ");
                    String accountType = scan.next();
                    System.out.print("Enter interest rate: ");
                    double interestRate = scan.nextDouble();
                    BankAccount account = bank.createAccount(accountHolder, accountType, interestRate);
                    System.out.println("Account created with number: " + account.getAccountNumber());
                    break;
                case 2:
                    System.out.println("--------------------------------------------");
                    System.out.print("Enter account number: ");
                    int accountNumber = scan.nextInt();
                    account = bank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.println("Balance: " + account.getBalance());
                    } else {
                        System.out.println("Invalid account number");
                    }
                    break;
                case 3:
                    System.out.println("--------------------------------------------");
                    System.out.print("Enter account number: ");
                    accountNumber = scan.nextInt();
                    account = bank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.print("Enter amount: ");
                        amount = scan.nextDouble();
                        account.deposit(amount);
                        System.out.println("--------------------------------------------");
                        System.out.println("Deposited " + amount);
                    } else {
                        System.out.println("--------------------------------------------");
                        System.out.println("Invalid account number");
                    }
                    break;
                case 4:
                    System.out.println("--------------------------------------------");
                    System.out.print("Enter account number: ");
                    accountNumber = scan.nextInt();
                    account = bank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.print("Enter amount: ");
                        amount = scan.nextDouble();
                        if (account.withdraw(amount)) {
                            System.out.println("--------------------------------------------");
                            System.out.println("Withdrew " + amount);
                        } else {
                            System.out.println("--------------------------------------------");
                            System.out.println("Insufficient balance");
                        }
                    } else {
                        System.out.println("--------------------------------------------");
                        System.out.println("Invalid account number");
                    }
                    break;
                case 5:
                    System.out.println("--------------------------------------------");
                    System.out.print("Enter account number: ");
                    int senderAccountNumber = scan.nextInt();
                    account = bank.getAccount(senderAccountNumber);
                    if (account != null) {
                        System.out.print("Enter receiver account number: ");
                        int receiverAccountNumber = scan.nextInt();
                        BankAccount receiverAccount = bank.getAccount(receiverAccountNumber);
                        if (receiverAccount != null) {
                            System.out.print("Enter amount: ");
                            amount = scan.nextDouble();
                            if (account.withdraw(amount)) {
                                receiverAccount.deposit(amount);
                                System.out.println("--------------------------------------------");
                                System.out.println("Transferred " + amount + " from account " + senderAccountNumber
                                        + " to account " + receiverAccountNumber);
                            } else {
                                System.out.println("--------------------------------------------");
                                System.out.println("Invalid receiver account number");
                            }
                        } else {
                            System.out.println("--------------------------------------------");
                            System.out.println("Invalid sender account number");
                        }
                    } else {
                        System.out.println("--------------------------------------------");
                        System.out.println("Invalid account number");
                    }
                    break;
                case 6:
                    System.out.println("--------------------------------------------");
                    bank.applyInterestToall();
                    System.out.println("Applied interest to all accounts");
                    break;
                case 7:
                    System.out.println("--------------------------------------------");
                    System.out.print("Enter account number: ");
                    accountNumber = scan.nextInt();
                    account = bank.getAccount(accountNumber);
                    if (account != null) {
                        if (account.getBalance() > 0) {
                            System.out.println("--------------------------------------------");
                            System.out.println("Cannot close account with balance remaining");
                        } else {
                            bank.closeAccount(accountNumber);
                            System.out.println("--------------------------------------------");
                            System.out.println("Account closed successfully");
                        }
                    } else {
                        System.out.println("--------------------------------------------");
                        System.out.println("Invalid account number");
                    }
                    break;
                case 0:
                    System.out.println("--------------------------------------------");
                    System.out.println("Program close");
                    break;
                default:
                    System.out.println("--------------------------------------------");
                    System.out.println("Invalid input");
                    break;
            }
            try {
                System.out.println("--------------------------------------------");
                System.out.print("Press 1 to continue, 2 to exit: ");
                con = scan.nextInt();
                if (con == 2) {
                    System.out.println("--------------------------------------------");
                    System.out.println("Thank you for using the program :)");
                    System.exit(0);
                } else {
                    System.out.println("\u000C");
                }
            } catch (Exception e) {
                System.out.println("--------------------------------------------");
                System.out.println("Invalid input!!");
            }
        } while (con == 1);
        scan.close();
    }
}
