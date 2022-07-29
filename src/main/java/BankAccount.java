import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BankAccount {

    double balance;
    String description;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:m");


    public double getBalance() {
        return balance;
    }

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public ArrayList<Transaction> transactionArrayList = new ArrayList<Transaction>();

    public void deposit(double amount) {
        this.balance = balance + amount;
        this.description = "Deposit";
        transactionArrayList.add(new Transaction(amount, description,balance));
    }


    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance = balance - amount;
            this.description = "Withdraw";
            transactionArrayList.add(new Transaction(amount, description,balance));
        } else {
            System.out.println("Your balance is less than " + amount + "\tTransaction failed...!!");


        }
    }

    public ArrayList<Transaction> getAllTransactions() {
        transactionArrayList.forEach(transaction -> {
            System.out.println("Operation Type : " + transaction.description + "\tDate of Operation " +
                    transaction.transactionTime.format(formatter) + "\t Amount :" + transaction.amount+
                    "Balance :" +transaction.balance);
        });
        return transactionArrayList;

    }


}