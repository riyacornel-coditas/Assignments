import java.io.*;
import java.util.*;
public class User implements Serializable{
    String username;
    String email;
    transient String password;

    public User(String username,String email,String password){
        this.username=username;
        this.email=email;
        this.password=password;
    }

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username");
        String username=sc.nextLine();
        System.out.println("Enter your email");
        String email=sc.nextLine();
        System.out.println("Enter your password");
        String password=sc.nextLine();

        User obj1 = new User(username,email,password);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Coditas-Admin\\Documents\\Serializable.txt"));
        oos.writeObject(obj1);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Coditas-Admin\\Documents\\Serializable.txt"));
        User obj2 = (User) ois.readObject();
        ois.close();

        System.out.println("The username is: "+obj2.username);
        System.out.println("The email is: "+obj2.email);
        System.out.println("The password is: "+obj2.password);
    }
}
