import java.util.*;
public class A4 {
    int balance;
    String name;


    public A4(int balance, String name)
    {
        this.balance= balance;
        this.name=name;
    }
    public void transfer(A4 from, A4 to, int amt)
    {
        A4 firstlock=from;
        A4 secondlock=to;

        if(from.name.compareTo(to.name)>0)
        {
            firstlock=to;
            secondlock=from;
        }
        synchronized (firstlock)
        {
            synchronized (secondlock)
            {
                if(from.balance>=amt)
                {
                    from.balance-=amt;
                    to.balance+=amt;

                    System.out.println(Thread.currentThread().getName()+" transferred "+amt+" and balance now is Rs."+ from.balance);

                }
                else {
                    System.out.println("Insufficient balance");
                }
            }
        }
    }
    public static void main(String[] args)
    {

        A4 obj1 = new A4(1000, "Account A");
        A4 obj2 = new A4(1000, "Account B");

        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the amount to be transferred");
        int amt=sc.nextInt();

        Thread t1 = new Thread(()->{
            obj1.transfer(obj1,obj2,amt);
        });

        Thread t2 = new Thread(()->{
            obj2.transfer(obj2,obj1,amt);
        });

        t1.start();
        t2.start();
    }
}
