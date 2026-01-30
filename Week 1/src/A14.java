import java.util.*;
public class A14 {
    public static void main()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in array");
        int n=sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter the numbers in array\n0 represents red\n1 represents white\n2 represents blue");
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }

        int low=0,mid=0,high=n-1;
        while(mid<=high)
        {
            if(a[mid]==0)
            {
                int temp=a[low];
                a[low]=a[mid];
                a[mid]=temp;
                low++;
                mid++;
            }
            else if (a[mid]==1)
            {
                mid++;
            }
            else if(a[mid]==2)
            {
                int temp=a[mid];
                a[mid]=a[high];
                a[high]=temp;
                high--;

            }
        }
        System.out.println("The sorted array is "+Arrays.toString(a));

    }
}
