import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountWithSyncUser {
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
        public synchronized void run() {
                userAccount.deposit(1);
        }
    }

    private static class Account{
        private static Lock lock = new ReentrantLock(true); // you can specify priority
        private int balance = 0;
        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {
            lock.lock();
            try {
                int newBalance = balance + amount;
                balance = newBalance;
            }
            finally {
                lock.unlock();
            }
        }

    }
}
