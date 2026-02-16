import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class A5 {
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of workers");
        int w= sc.nextInt();
        sc.nextLine();
        ExecutorService executor = Executors.newFixedThreadPool(w);
        System.out.println("Enter the number of tasks");
        int n=sc.nextInt();
        sc.nextLine();
        String[] arr= new String[n];
        System.out.println("Enter the tasks line by line");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextLine();
        }

        for(int i=0;i<n;i++)
        {
            String task=arr[i];
            executor.submit(()->{
                System.out.println(Thread.currentThread().getName()+" is doing "+task);
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e)
                {
                    System.out.println(Thread.currentThread().getName()+" was interrupted");
                }
                System.out.println(Thread.currentThread().getName()+" has finished "+task);
            });


        }
        executor.shutdown();
    }
}
