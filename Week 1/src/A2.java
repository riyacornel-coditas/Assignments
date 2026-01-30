import java.util.*;
public class A2 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter three numbers");
        double a=sc.nextDouble();
        double b=sc.nextDouble();
        double c=sc.nextDouble();
        double sum=a+b+c;
        double avg=sum/3.0;
        System.out.println("The average of the three numbers is "+avg);
    }
}
