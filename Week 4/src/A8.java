import java.util.*;
public class A8 {
    public static void main(String[] args)
    {
        SequencedCollection<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("These are the elements of the list");
        for(Integer i:list)
        {
            System.out.println(i);
        }

        SequencedCollection<Integer> list1=list.reversed();

        System.out.println("These are the elements of the list in reversed order");
        for(Integer i:list1)
        {
            System.out.println(i);
        }

    }
}
