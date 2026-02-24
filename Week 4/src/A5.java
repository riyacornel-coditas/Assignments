import java.io.IOException;
import java.util.*;

record Person(String name, int age) {
    public Person(String name, int age) {
        this.name=name;
        this.age=age;

        if (name.length() < 2) {
            throw new IllegalArgumentException("The name length must be 2 characters or more");
        } else {
            System.out.println("The name is: " + this.name);
        }


    }
}
public class A5 {
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        String name=sc.nextLine();
        System.out.println("Enter your age");
        int age=sc.nextInt();
        Person p1 = new Person(name,age);
        System.out.println("The age is: "+p1.age());
        System.out.println(p1.toString());

    }
    }

