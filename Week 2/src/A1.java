import java.util.*;
import java.io.*;
class A1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Enter two numbers");
            int a=sc.nextInt();
            int b=sc.nextInt();
            int q=a/b;
            System.out.println("The quotient is "+q);
        }
        catch(ArithmeticException e1)
        {
            System.out.println("Cannot divide number by 0.");
        }
        catch(InputMismatchException e2)
        {
            System.out.println("You have entered a non-integer input");

        }
        finally{
            System.out.println("Program execution completed");
        }
    }
}