import java.util.*;

public class A6 extends Thread {
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " has started working");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " has stopped working");
        };


        Thread virtualThread = Thread.ofVirtual().name("my-virtual-thread").start(task);


        System.out.println("The main method is working");

        try {
            virtualThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main has stopped. Virtual thread has terminated");


    }
}
