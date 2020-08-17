import java.util.concurrent.*;
public class AccountWithoutSyncUser {
    private static Account userAccount = new Account();
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i = 0; i < 100; i++) {
            executor.execute(new AddAPenny());
        }
        executor.shutdown();
        while(!executor.isShutdown()) {

        }
        System.out.println("What is balance? " + userAccount.getBalance());
    }
    private static class AddAPenny implements Runnable{
        public void run() {
            userAccount.deposit(1);
        }
    }

    private static class Account{
        private int balance = 0;

        public void deposit(int amount) {
            int newBalance = balance + amount;

            balance = newBalance;
        }

        public int getBalance() {
            return balance;
        }
    }
}
