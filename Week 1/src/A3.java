import java.util.*;
public class A3 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in array");
        int n=sc.nextInt();
        int[] a= new int[n];
        System.out.println("Enter the numbers in array");
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        int min=a[0];
        int max=0;
        for(int i=1;i<n;i++)
        {
            if(a[i]<min)
            {
                min=a[i];
            }
        }
        for(int i=0;i<n;i++)
        {
            if(a[i]>max)
            {
                max=a[i];
            }
        }
        System.out.println("The minimum element is "+min);
        System.out.println("The maximum element is "+max);
    }
}
