import java.util.*;
public class A9 {
    boolean pingchance = true;

    public synchronized void ping() throws InterruptedException
    {
        while(!pingchance)
        {
            wait();
        }
        System.out.println("Ping");
        pingchance=false;
        notify();
    }

    public synchronized void pong() throws InterruptedException
    {
        while(pingchance)
        {
            wait();
        }
        System.out.println("Pong");
        pingchance=true;
        notify();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of ping pong pairs");
        int n=sc.nextInt();

        A9 obj = new A9();

        new Thread(()->{
            try{
                for(int i=0;i<n;i++)
                    obj.ping();
            }
            catch(InterruptedException e)
            {
                System.out.println("Interrupted");
            }
        }).start();

        new Thread(()->{
            try{
                for(int i=0;i<n;i++)
                    obj.pong();
            }
            catch(InterruptedException e)
            {
                System.out.println("Interrupted");
            }
        }).start();

    }


}
