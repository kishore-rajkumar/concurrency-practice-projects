package concurrency.general;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrancyExample {
//    private static final Lock lock = new ReentrantLock(); // Reentrant lock
    
    private static final Lock lock = new ReentrantLock(); // Reentrant lock

    // Recursive method that requires reentrant locking
    public static void recursiveMethod(int level) {
        lock.lock(); // Acquire the lock
//        System.out.println(lock+ " >> lock acquired at :" + new Date());
        try {
            System.out.println("Lock acquired at recursion level: " + level);

            // Base case for recursion
            if (level > 0) {
                // Recursive call with reduced level
                recursiveMethod(level - 1);
            }

            System.out.println("Lock released at recursion level: " + level);
        } finally {
        	
        	System.out.println(lock+ " >> "+"lock UNLOCK (finally) at :" + new Date());
            lock.unlock(); // Ensure the lock is released
        }
    }

    public static void main(String[] args) {
        // Start a thread to demonstrate reentrancy
        Thread t = new Thread(() -> recursiveMethod(3)); // Starting at level 3
        t.start();

        try {
            t.join(); // Wait for the thread to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Handle interruption
        }
    }
}
