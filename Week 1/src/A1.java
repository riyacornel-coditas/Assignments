import java.util.*;
class A1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter side of square in cm");
        double s=sc.nextDouble();
        double a=Math.pow(s,2);
        System.out.println("The area of the square is "+a+" sq. cm.");
    }
}