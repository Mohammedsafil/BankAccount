package BankAccount;

import java.util.Scanner;

public class main {
    public  static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        BankAccount[] accounts = new BankAccount[n];

        while(n>0){
            int choice;
            System.out.println("Enter Your Choice \n1.Savings Account \n2.Current Account\n");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the account number");
                    sc.nextLine();
                    String accNum = sc.nextLine();
                    System.out.println("Enter the balance");
                    double balance = sc.nextDouble();
                    System.out.println("Enter the Savings account minimum balance");
                    double minBalance = sc.nextDouble();
                    accounts[choice-1] = new SavingAccount(accNum, balance, minBalance);
                    break;
            
                case 2:
                    System.out.println("Enter the account number");
                    sc.nextLine();
                    String accNumC = sc.nextLine();
                    System.out.println("Enter the balance");
                    double balanceC = sc.nextDouble();
                    accounts[choice-1] = new CurrentAccount(accNumC, balanceC);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            n--;
        }

        for(BankAccount bc : accounts){
            bc.accountDetails();
        }
    }

}

abstract class BankAccount{
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    abstract void withdraw(double amount);
    abstract void accountDetails();
    abstract void deposit(double amount);
}

class SavingAccount extends BankAccount{
    private double minBalance;

    public SavingAccount(String accountNumber, double balance, double minBalance){
        super(accountNumber,balance);
        this.minBalance = minBalance;
    }

    @Override
    public void withdraw(double amount){
        if (balance >= amount && balance - amount >= minBalance) {
            balance -= amount;
            System.out.println("Withdrawal successful");
        }
        else{
            System.out.println("Insufficient balance");
        }
    }

    @Override
    public void deposit(double amount){
        if(amount>0){
            balance += amount;
            System.out.println("Amount Deposited Successfully");
        }
        else{
            System.out.println("Invalid amount");
        }
    }

    public void accountDetails(){
        System.out.println("Savings Account Number: "+accountNumber);
        System.out.println("Savings Account Balance: "+super.balance);
    }
}

class CurrentAccount extends BankAccount{
    public CurrentAccount(String accountNumber,double balance){
        super(accountNumber,balance);
    }

    @Override
    public void withdraw(double amount){
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful");
        }else{
            System.out.println("Insufficient balance");
        }
    }

    @Override
    public void deposit(double amount){
        if(amount>0){
            balance += amount;
            System.out.println("Amount Deposited Successfully");
        }
        else{
            System.out.println("Invalid amount");
        }
    }

    @Override
    public void accountDetails(){
        System.out.println("Current Account Number: "+accountNumber);
        System.out.println("Current Account Balance: "+balance);
    }
}
