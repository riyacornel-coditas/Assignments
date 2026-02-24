import java.util.*;
public class A10 {
    public static void main(String[] args)
    {
        SequencedMap<Integer,String> map = new LinkedHashMap<Integer,String>();
        map.put(1,"A");
        map.put(2,"B");
        map.put(3,"C");
        map.put(4,"D");
        map.put(5,"E");



        System.out.println("These are the elements of the list");
        for(Integer i:map.keySet())
        {
            System.out.println("Key: "+i+" Value: "+map.get(i));
        }

        SequencedMap<Integer,String> map1=map.reversed();

        System.out.println("These are the elements of the list in reversed order");
        for(Integer i:map1.keySet())
        {
            System.out.println("Key: "+i+" Value: "+map1.get(i));
        }

    }
}

