import java.util.*;
public class A13 {
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

        int res=nums[0], maxending=nums[0];
        for(int i=1;i<n;i++)
        {
            maxending=Math.max(maxending+nums[i],nums[i]);
            res=Math.max(res,maxending);
        }
        System.out.println(res);
    }
}
