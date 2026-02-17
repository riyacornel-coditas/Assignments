import java.util.*;
abstract class SalaryCalculation {

    static final double pf = 0.12;
    double gross_sal;
    double bonus;
    double tax;
    double attend_ded;
    double net;
    double pf_c;

    public void pf_cal(double gross)
    {
        pf_c=pf*gross;
    }

    abstract void gross(double base, double value);

    public void attend_deduction(double attendance,double base)
    {
        double daily_sal=(double)base/30;
        double abs_days=30-attendance;
        double attend_ded=abs_days*daily_sal;
    }

    public void performance(double rate, double gross)
    {
        ;
        if(rate==5)
        {
            bonus=gross*0.2;
        }
        else if(rate==4)
        {
            bonus=gross*0.15;
        }
        else if(rate==3)
        {
            bonus=gross*0.1;
        }
        else if(rate==2)
        {
            bonus=gross*0.05;
        }
        else if(rate==1)
        {
            bonus=gross*0.0;
        }

    }

    public void tax_cal(double gross_sal,double bonus)
    {
        double taxable_inc= gross_sal+bonus;
        if(taxable_inc<=50000)
        {
            tax=taxable_inc*0.05;
        }
        else if(taxable_inc>=50001 && taxable_inc<=100000)
        {
            tax=taxable_inc*0.1;
        }
        if(taxable_inc>=100001 && taxable_inc<=150000)
        {
            tax=taxable_inc*0.15;
        }
        if(taxable_inc>150000)
        {
            tax=taxable_inc*0.2;
        }

    }
    public void net_sal()
    {
        net=gross_sal+bonus-tax-pf_c-attend_ded;
        System.out.println("Your net salary is:"+net);
    }

}

class Developer extends SalaryCalculation {

    @Override
    public void gross(double base, double hours)
    {
        gross_sal=base + (hours*500);
    }
}

class Manager extends SalaryCalculation {

    @Override
    public void gross(double base, double team)
    {
        gross_sal=base + (team*1000);
    }
}

class Intern extends SalaryCalculation {

    @Override
    public void gross(double base, double attendance)
    {
        double attend_per = (attendance/30)*100;
        if(attend_per<70)
        {
            gross_sal=base - (base*0.2);
        }
        else
        {
            gross_sal=(double)base;
        }
    }


}

public class Test{
    public static void main()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter salary");
        double sal=sc.nextDouble();


        SalaryCalculation obj1= new Developer();
        SalaryCalculation obj2= new Manager();
        SalaryCalculation obj3=new Intern();

        System.out.println("Enter 1 if you are a developer\nEnter 2 if you are manager\nEnter 3 if you are Intern");
        int ch= sc.nextInt();
        switch(ch)
        {
            case 1:
                System.out.println("Enter hours");
                double h=sc.nextDouble();
                obj1.gross(sal,h);
                System.out.println("Enter your attendance");
                double a=sc.nextDouble();
                obj1.attend_deduction(a,sal);
                System.out.println("Enter your rating");
                double r=sc.nextDouble();
                obj1.performance(r,sal);
                obj1.tax_cal(obj1.gross_sal, obj1.bonus);
                obj1.net_sal();

                break;

            case 2:
                System.out.println("Enter team size");
                int s=sc.nextInt();
                obj2.gross(sal,s);
                System.out.println("Enter your attendance");
                a=sc.nextDouble();
                obj2.attend_deduction(a,(int)sal);
                System.out.println("Enter your rating");
                r=sc.nextInt();
                obj2.performance(r,(int)sal);
                obj2.tax_cal(obj2.gross_sal, obj2.bonus);
                obj2.net_sal();

                break;

            case 3:


                System.out.println("Enter your attendance");
                a=sc.nextDouble();
                obj3.gross((int)sal,a);
                obj3.attend_deduction(a,(int)sal);
                System.out.println("Enter your rating");
                r=sc.nextInt();
                obj3.performance(r,sal);
                obj3.tax_cal(obj3.gross_sal, obj3.bonus);
                obj3.net_sal();

                break;

            default:System.out.println("Invalid input");

        }
    }
}
