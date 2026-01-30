import java.util.*;
public class A15 {
    public static void main()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n=sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter the elements in array");
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        System.out.println("Enter the target");
        int target=sc.nextInt();
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-1-i;j++)
            {
                if(a[j]>a[j+1])
                {
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n-3;i++)
        {
            for(int j=i+1;j<n-2;j++)
            {
                for(int k=j+1;k<n-1;k++)
                {
                    for(int l=k+1;l<n;l++)
                    {
                        if(a[i]+a[j]+a[k]+a[l]==target)
                        {
                            List<Integer> quad = new ArrayList<>();
                            quad.add(a[i]);
                            quad.add(a[j]);
                            quad.add(a[k]);
                            quad.add(a[l]);
                            res.add(quad);
                        }


                    }
                }
            }
        }

        System.out.println(res);
    }
}
