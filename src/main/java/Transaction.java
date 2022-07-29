import java.time.LocalDateTime;

public class Transaction {

    LocalDateTime transactionTime;
    double amount;
    String description;
    double balance;

    public Transaction(LocalDateTime transactionTime, double amount, String description ,double balance) {
        this.transactionTime = transactionTime;
        this.amount = amount;
        this.description = description;
        this.balance= balance;
    }

    public Transaction(double amount) {
        this.transactionTime = LocalDateTime.now();
        this.amount = amount;

    }

    public Transaction(double amount, String description,double balance) {
        this.transactionTime = LocalDateTime.now();
        this.amount = amount;
        this.description = description;
        this.balance=balance;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
