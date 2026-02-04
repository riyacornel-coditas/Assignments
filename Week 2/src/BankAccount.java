import java.util.*;
public class BankAccount {
    private double balance=10000;

    class Transaction {
        public void deposit(double amt) {
            balance = balance + amt;
            System.out.println("The balance is Rs." + balance);
        }

        public void withdraw(double amt) {
            balance = balance - amt;
            System.out.println("The balance is Rs." + balance);
        }
    }
        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the amount");
            double amt=sc.nextInt();
            System.out.println("Enter 1 to deposit\nEnter 2 to withdraw");
            int ch=sc.nextInt();
            BankAccount obj1 = new BankAccount();
            Transaction obj2 = obj1.new Transaction();
            switch(ch)
            {
                case 1:obj2.deposit(amt);
                break;
                case 2:obj2.withdraw(amt);
                break;
                default:System.out.println("Invalid input");
            }



    }

}
