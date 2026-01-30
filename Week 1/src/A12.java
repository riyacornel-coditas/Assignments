import java.util.*;
public class A12 {
    public static void main()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in array");
        int n=sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the numbers in array");
        for(int i=0;i<n;i++)
        {
            nums[i]=sc.nextInt();
        }
        System.out.println("Enter the target");
        int target=sc.nextInt();
        int sum=0;
        int[] a = new int[2];
        int k=0;
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                sum=nums[i]+nums[j];
                if(sum==target)
                {
                    a[k]=i;
                    a[k+1]=j;
                }
            }
        }


        System.out.println(Arrays.toString(a));

    }
}
