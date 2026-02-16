import java.util.*;
import java.util.concurrent.Semaphore;

public class A8 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Semaphore tunnel = new Semaphore(3);
        System.out.println("Enter the number of cars");
        int n=sc.nextInt();
        for(int i=1;i<=n;i++)
        {
            int no=i;
            new Thread(()-> {
                try {
                    System.out.println("Car " + no + " is waiting to go in tunnel");
                    tunnel.acquire();
                    System.out.println("Car " + no + " is passing through tunnel");
                    Thread.sleep(1000);
                    System.out.println("Car " + no + " has exited the tunnel");
                    tunnel.release();
                } catch (InterruptedException e) {
                    System.out.println("Car " + no + " has been interrupted");
                }
            }).start();

        }
    }
}
