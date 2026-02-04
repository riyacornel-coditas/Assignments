import java.util.*;
import java.io.*;
public class A6 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        List<String> names = new ArrayList<String>();
        System.out.println("Enter the number of students");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter their names");
        for(int i=0;i<n;i++)
        {
            String s=sc.nextLine();
            names.add(s);
        }

        System.out.println("The names are:");
        names.forEach(name->System.out.println(name));

        System.out.println("The names starting with A are:");
        names.stream()
                .filter(name->name.startsWith("A"))
                .forEach(name->System.out.println(name));

        class SortInAlphabeticalOrder implements Comparator<String>
        {
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        }

        System.out.println("The names in alphabetical order are:");
        Collections.sort(names,new SortInAlphabeticalOrder());
        names.forEach(name->System.out.println(name));

    }
}
