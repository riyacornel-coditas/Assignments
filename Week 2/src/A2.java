import java.util.*;
import java.io.*;
class InvalidAgeException extends RuntimeException
{
    public InvalidAgeException(String m)
    {
        super(m);
    }
}
public class A2 {
    public static void main (String[] args) throws InvalidAgeException{
        Scanner sc = new Scanner(System.in);
        try
        {
            System.out.println("Enter your age");
            int age=sc.nextInt();
            if(age<18)
            {
                throw new InvalidAgeException("You are not eligible to vote.");
            }
            else
            {
                System.out.println("You are eligible to vote");
            }
        }
        catch(InvalidAgeException e)
        {
            System.out.println("Exception caught:" + e.getMessage());
        }
    }

}
