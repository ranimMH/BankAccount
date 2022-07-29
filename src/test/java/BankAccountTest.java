import static org.junit.Assert.*;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BankAccountTest {
    BankAccount bankAccount1 = new BankAccount(1000);

    @Test
    public void testWithdraw() {
        bankAccount1.withdraw(3.0);
        assertEquals(997.0, bankAccount1.getBalance(), 0);
    }

    @Test
    public void testDeposits() {
        //tester  deposits et withdraw
        bankAccount1.getBalance();

        bankAccount1.deposit(500);
        assertEquals(1500.0, bankAccount1.getBalance(), 0);

        bankAccount1.withdraw(200);
        assertEquals(1300.0, bankAccount1.getBalance(), 0);

        bankAccount1.withdraw(1400);
        assertEquals(1300.0, bankAccount1.getBalance(), 0);


    }


    @Test
    public void testGetTransactions() {

        bankAccount1.deposit(600);
        bankAccount1.withdraw(200);
        bankAccount1.deposit(50);
        bankAccount1.withdraw(50);
        ArrayList<Transaction> transactions = bankAccount1.getAllTransactions();
        assertEquals(4, transactions.size());

        //tester la date des  transactions
        assertEquals(false, LocalDateTime.now().isBefore(transactions.get(3).getTransactionTime()));

        //tester si les  transactions sont dans le bon ordre
        for (int i = 0; i < transactions.size() - 1; i++) {
            Transaction earlierTranscation = transactions.get(i);
            Transaction laterTranscation = transactions.get(i + 1);
            assertEquals(false, (laterTranscation.getTransactionTime().isBefore(earlierTranscation.getTransactionTime())));
        }


    }

}
