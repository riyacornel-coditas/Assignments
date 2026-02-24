import java.util.*;
public class A9 {
    public static void main(String[] args)
    {
        SequencedSet<Integer> set = new LinkedHashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(5);
        set.add(6);


        System.out.println("These are the elements of the list");
        for(Integer i:set)
        {
            System.out.println(i);
        }

        SequencedSet<Integer> set1=set.reversed();

        System.out.println("These are the elements of the list in reversed order");
        for(Integer i:set1)
        {
            System.out.println(i);
        }

    }
}
