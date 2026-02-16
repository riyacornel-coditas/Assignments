import java.util.*;
import java.util.concurrent.CountDownLatch;

public class A6 {
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of runners");
        int n=sc.nextInt();

        CountDownLatch[] latch = new CountDownLatch[n];

        for(int i=0;i<n;i++)
        {
            latch[i]=new CountDownLatch(1);
        }

        for(int i=0;i<n;i++)
        {
            int runner = i+1;
            CountDownLatch waitt = (i==0)? null:latch[i-1];
            CountDownLatch signall=(i==n-1)?null:latch[i];

            new Thread(()->{
                try {
                    if (waitt != null)
                        waitt.await();
                    System.out.println("Runner " + runner + " has started running");
                    Thread.sleep(1000);
                    System.out.println("Runner " + runner + " has finished running");
                    if (signall != null)
                        signall.countDown();
                }catch (InterruptedException e)
                {
                    System.out.println("Runner "+runner+" was interrupted");
                }
            }).start();
        }
    }
}
