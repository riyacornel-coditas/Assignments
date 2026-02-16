import java.util.*;
public class A2 {
    volatile static int count=0;

    public static void main(String[] args)
    {
        Thread t1 = new Thread(()->{
            for(int i=0;i<5;i++)
            {
                count++;
                System.out.println("Value incremented:"+count);
            }
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+"interrupted");
            }
        });

        Thread t2 = new Thread(()->{
            for(int i=0;i<5;i++)
            {

                System.out.println("Value read:"+count);
            }
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+"interrupted");
            }
        });

        t1.start();
        t2.start();

    }
}
