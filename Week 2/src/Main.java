import java.util.*;

abstract class Employee {

    abstract void calculateSalary(double sal);

    public void displayDetails(double sal)
    {
    System.out.println("Your salary after tax deduction is:" +sal);
    }
}
class FullTimeEmployee extends Employee
{
    @Override
    void calculateSalary(double sal)
    {
        double tax=0.0;
        if(sal>=0 && sal<=250000)
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
        sal=sal-tax;

        displayDetails(sal);
    }
}

class PartTimeEmployee extends Employee
{
    @Override
    void calculateSalary(double sal)
    {
        System.out.println("Tax deduction for your salary: "+ sal+ " is Rs.0");
    }
}
 public class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your salary");
        int sal=sc.nextInt();
        System.out.println("Enter 1 if you are a full time employee");
        System.out.println("Enter 2 if you are a part time employee");
        int ch=sc.nextInt();
        switch(ch) {
            case 1:FullTimeEmployee obj1 = new FullTimeEmployee();
            obj1.calculateSalary(sal);
            //obj1.displayDetails(sal);
            break;

            case 2:PartTimeEmployee obj2 = new PartTimeEmployee();
            obj2.calculateSalary(sal);
            obj2.displayDetails(sal);
            break;
        }
    }
 }