import java.util.*;
public class A7 {
        enum OrderStatus{

            PLACED, SHIPPED, DELIVERED, CANCELLED;

            public String display()
            {
                return "The order has been "+ this ;
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter PLACED or SHIPPED or DELIVERED or CANCELLED to know the details");
            String ch = sc.nextLine();

            OrderStatus os1 = OrderStatus.PLACED;
            OrderStatus os2 = OrderStatus.SHIPPED;
            OrderStatus os3 = OrderStatus.DELIVERED;
            OrderStatus os4 = OrderStatus.CANCELLED;

            switch (ch) {
                case "PLACED":
                    String a = os1.display();
                    System.out.println(a);
                    break;

                case "SHIPPED":
                    String b = os2.display();
                    System.out.println(b);
                    break;

                case "DELIVERED":
                    String c = os3.display();
                    System.out.println(c);
                    break;

                case "CANCELLED":
                    String d = os4.display();
                    System.out.println(d);
                    break;

            }


        }
}

