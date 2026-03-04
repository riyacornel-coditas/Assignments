import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Week3_Test {
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        CountDownLatch latch = new CountDownLatch(8);

        for(int i=1;i<=8;i++)
        {

            int finalI = i;
            executor.submit(()->{

                try
                {
                    System.out.println(Thread.currentThread().getName()+" started report "+ finalI);
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName()+" has finished report "+finalI);
                }
                catch(InterruptedException e)
                {
                    System.out.println(Thread.currentThread().getName()+" was interrupted");
                }

                finally {
                    latch.countDown();
                }

            });


        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All reports generated. Dashboard is ready.");
        executor.shutdown();
    }
}
