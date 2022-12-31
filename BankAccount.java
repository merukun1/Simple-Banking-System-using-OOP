package Project;

public class BankAccount{
    private int accountNumber;
    private double balance;
    private String accountHolder;
    private String accountType;
    private double interestRate;
    private double overdraftLimit;
    public BankAccount(int accountNumber, String accountHolder, String accountType, double interestRate) {
        this.setAccountNumber(accountNumber);
        this.setBalance(balance);
        this.setAccountHolder(accountHolder);
        this.setAccountType(accountType);
        this.setInterestRate(interestRate);
        this.setOverdraftLimit(overdraftLimit);
    }
    public int getAccountNumber(){
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = 0.0;
    }
    public String getAccountHolder(){
        return accountHolder;
    }
    public void setAccountHolder(String accountHolder){
        this.accountHolder = accountHolder;
    }
    public String getAccountType(){
        return accountType;
    }
    public void setAccountType(String accountType){
        this.accountType = accountType;
    }
    public double getInterestRate(){
        return interestRate;
    }
    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }
    public double getOverdraftLimit(){
        return overdraftLimit;
    }
    public void setOverdraftLimit(double overdraftLimit){
        this.overdraftLimit = 5000.0;
    }
    public void deposit(double amount){
        balance += amount;
    }
    public boolean withdraw(double amount){
        if(balance - amount >= -overdraftLimit){
            balance -= amount;
            return true;
        } 
        return false;
    }
    public boolean transfer(BankAccount recipient, double amount){
        if(balance >= amount){
            balance -= amount;
            recipient.deposit(amount);
            return true;
        }
        return false;
    }
    public void applyInterestRate(){
        balance *= (1 + interestRate);
    }


}
