import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class Product {
    int id;
    String name;
    double price;
    double gst;
    int quantity;

    Product(int id, String name, double price, double gst, int quantity)
    {
        this.id=id;
        this.name=name;
        this.price=price;
        this.gst=gst;
        this.quantity=quantity;

    }
    public static void main(String[] args) throws FileNotFoundException
    {


        Scanner sc = new Scanner(System.in);
        Product[] p = new Product[10];
        int c = 0;

        String myfile = "C:\\Users\\Coditas-Admin\\Documents\\A10 file.txt";
        File file = new File(myfile);
        Scanner text = new Scanner(file);
        while(text.hasNext()) {
            int id = text.nextInt();
            String name = text.next();
            double price = text.nextDouble();
            double gst = text.nextDouble();
            int quantity = text.nextInt();

            p[c++] = new Product(id, name, price, gst, quantity);
        }
        for(int i=0;i<c;i++)
        {
            System.out.println("ID: "+p[i].id+"\nName: "+p[i].name+"\nPrice: "+p[i].price+"\nGST: "+p[i].gst+"\nQuantity: "+p[i].quantity);
        }

        double total=0.0;

        System.out.println("Enter 0 to checkout");
        System.out.println("Enter the product id");
        int ch=sc.nextInt();

        System.out.println("Enter the quantity you want to purchase");
        int q=sc.nextInt();

        for(int i=0;i<c;i++)
        {
            if(ch==p[i].id)
            {
                if(q<=p[i].quantity)
                {
                    total= (p[i].price*q) + ((p[i].gst/100)* p[i].price)*q;
                    p[i].quantity=p[i].quantity -q;
                }
            }
            else
            {
                System.out.println("Item not found");
            }
        }

        System.out.println("The price with gst is Rs. "+total);
    }
}

