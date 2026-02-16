import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class A7 {
    private int balance=0;
    private ReentrantLock lock = new ReentrantLock();

    public void deposit(int amt)
    {
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" is depositing Rs."+amt);
            balance+=amt;
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" balance is Rs."+balance);
        }
        catch(InterruptedException e)
        {
            System.out.println(Thread.currentThread().getName()+"was interrupted");
        }
        finally{
            lock.unlock();
        }
    }
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        A7 obj = new A7();

        System.out.println("Enter the number of people depositing money");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter amount");
            int amt = sc.nextInt();

            new Thread(()->{
                obj.deposit(amt);
            }).start();

        }
    }
}
