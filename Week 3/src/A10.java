import java.util.*;
public class A10 {
    private int capacity;
    private Queue<Integer> queue = new LinkedList<Integer>();

    public A10(int capacity){
        this.capacity=capacity;
    }

    public synchronized void producer(int item) throws InterruptedException
    {
        if(queue.size()==capacity)
        {
            wait();
        }
        queue.add(item);
        System.out.println("Produced item: "+item);
        notify();
    }

    public synchronized int consumer() throws InterruptedException
    {
        if(queue.isEmpty())
        {
            wait();
        }
        int item= queue.poll();
        System.out.println("Consumed item: "+item);
        notify();
        return item;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the capacity of queue");
        int c=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the number of items to be produced and consumed");
        int n=sc.nextInt();
        sc.nextLine();

        A10 obj = new A10(c);

        new Thread(()->{
            try
            {
                for(int i=0;i<n;i++)
                {
                    obj.producer(i);
                    Thread.sleep(1000);
                }
            }
            catch(InterruptedException e)
            {
                System.out.println("Producer interrupted");
            }
        }).start();

        new Thread(()->{
            try
            {
                for(int i=0;i<n;i++)
                {
                    obj.consumer();
                    Thread.sleep(1000);
                }
            }
            catch(InterruptedException e)
            {
                System.out.println("Producer interrupted");
            }
        }).start();
    }


}
