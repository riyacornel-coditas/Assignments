import java.util.*;
public class A9 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of employees");
        int n=sc.nextInt();
        HashMap<Integer,String> map = new HashMap<Integer, String>(n);
        LinkedHashMap<Integer,String> linkedmap = new LinkedHashMap<Integer,String>(n);
        TreeMap<Integer,String> treemap = new TreeMap<Integer,String>();

        sc.nextLine();

        System.out.println("Enter employee ID along with name separated by a space");
        for(int i=0;i<n;i++)
        {

            String line = sc.nextLine();
            String[] parts = line.split(" ",2);

            int id= Integer.parseInt(parts[0]);
            String name=parts[1];
            map.put(id,name);
            linkedmap.put(id,name);
            treemap.put(id,name);
        }
        System.out.println("Output using HashMap:");
        for(int i:map.keySet())
        {
            System.out.println("ID: "+i+"\t"+"Name: "+map.get(i));
        }

        System.out.println("Output using LinkedHashMap:");
        for(int i:linkedmap.keySet())
        {
            System.out.println("ID: "+i+"\t"+"Name: "+linkedmap.get(i));
        }

        System.out.println("Output using TreeMap:");
        for(int i:treemap.keySet())
        {
            System.out.println("ID: "+i+"\t"+"Name: "+treemap.get(i));
        }



    }
}
