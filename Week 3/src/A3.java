import java.util.*;
public class A3 {
    private int balance = 10000;

    public synchronized void deposit(int amt)
    {
        balance+=amt;
        System.out.println("Balance after deposit is Rs."+balance);
    }

    public synchronized void withdraw(int amt)
    {
        if(balance>=amt){
        balance-=amt;}
        else
        {
            System.out.println("Insufficient balance!");
        }
        System.out.println("Balance after withdrawal is Rs."+balance);
    }

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount to be deposited ");
        int dep=sc.nextInt();

        A3 obj = new A3();

        Thread t1 = new Thread(()->{
            obj.deposit(dep);
        });

        System.out.println("Enter the amount to be withdrawn ");
        int wit=sc.nextInt();

        Thread t2 = new Thread(()->{
            obj.withdraw(wit);
        });

        t1.start();
        t2.start();
    }
}
