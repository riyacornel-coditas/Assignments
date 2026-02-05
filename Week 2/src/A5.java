import java.util.*;
public class A5 {

    int roll;
    String name;

    public A5(int id, String n){

        roll=id;
        name=n;
    }

    public void change(int roll,A5 name_p)
    {
        roll=roll+5;
        name_p.name="Riya";
        System.out.println("Value of id in change method:"+roll);

    }

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name and id");
        String n=sc.nextLine();
        int id=sc.nextInt();

        System.out.println("The values before method call are:");
        System.out.println("Name: "+n+" Id: "+id);
        A5 obj = new A5(id,n);
        obj.change(id,obj);
        System.out.println("The values after method call are:");
        System.out.println("Name: "+obj.name+" Id: "+id);

    }
}
