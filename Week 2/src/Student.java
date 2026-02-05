import java.util.*;
import java.io.*;
public class Student {
    int id;
    String name;
    int marks;

    public Student(int id, String name, int marks)
    {
        this.id=id;
        this.name=name;
        this.marks=marks;
    }

    static class SortMarks implements Comparator<Student>
    {
        @Override
        public int compare(Student m1,Student m2)
        {
            return Integer.compare(m1.marks,m2.marks);
        }

    }

    static class SortNames implements Comparator<Student>
    {
        @Override
        public int compare(Student n1,Student n2)
        {
            return n1.name.compareTo(n2.name);
        }

    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> stud = new ArrayList<Student>();

        System.out.println("Enter the number of records");
        int n=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the id, name and marks separated by space");
        for(int i=0;i<n;i++)
        {
            String line = sc.nextLine();
            String[] parts=line.split(" ",3);

            int id=Integer.parseInt(parts[0]);
            String name=parts[1];
            int marks=Integer.parseInt(parts[2]);

            stud.add(new Student(id,name,marks));
        }

        System.out.println("Records sorted by marks are:");
        Collections.sort(stud, new SortMarks());
        for(Student s:stud)
        {
            System.out.println(s.id + "\t"+ s.name +"\t"+s.marks);
        }

        System.out.println("Records sorted by names are:");
        Collections.sort(stud, new SortNames());
        for(Student s:stud)
        {
            System.out.println(s.id + "\t"+ s.name +"\t"+s.marks);
        }

    }

}
