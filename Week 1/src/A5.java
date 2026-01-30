import java.util.*;
public class A5 {
    public static void main()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your salary");
        int sal=sc.nextInt();
        System.out.println("Enter 1 to calculate tax using Old Tax Regime\nEnter 2 to calculate tax using New Tax Regime");
        int ch=sc.nextInt();
        double tax=0.0;
        switch(ch)
        {
            case 1: if(sal>=0 && sal<=250000)
            {
                System.out.println("Tax is Nil.");
            }
            else if(sal>250000 && sal<=500000)
            {
                tax=sal*0.05;
            }
            else if(sal>500000 && sal<=1000000)
            {
                tax=sal*0.2;
            }
            else if(sal>1000000)
            {
                tax=sal*0.3;
            }
            break;

            case 2: if(sal>=0 && sal<=250000)
            {
                System.out.println("Tax is Nil.");
            }
            else if(sal>250000 && sal<=500000)
            {
                tax=sal*0.05;
            }
            else if(sal>500000 && sal<=750000)
            {
                tax=sal*0.1;
            }
            else if(sal>750000 && sal<=1000000)
            {
                tax=sal*0.15;
            }
            else if(sal>1000000 && sal<=1250000)
            {
                tax=sal*0.2;
            }
            else if(sal>1250000 && sal<=1500000)
            {
                tax=sal*0.25;
            }
            else if(sal>1500000)
            {
                tax=sal*0.3;
            }
            break;

            default:System.out.println("Invalid input!");

        }
        System.out.println("The tax is Rs."+tax);
    }
}
