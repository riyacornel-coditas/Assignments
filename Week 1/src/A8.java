import java.util.*;
public class A8 {
    public static void main()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int rows=sc.nextInt();
        System.out.println("Enter the number of columns");
        int col=sc.nextInt();
        int[][] a = new int[rows][col];
        System.out.println("Enter the elements in 2D array");
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<col;j++)
            {
                a[i][j]=sc.nextInt();
            }
        }

        int left=0, right=col-1, top=0, bottom=rows-1;
        List<Integer> ans = new ArrayList<>();
        while(top<=bottom && left<=right)
        {
            for(int i=left; i<=right; i++)
            {
                ans.add(a[top][i]);
            }
            top++;

            for(int i=top;i<=bottom;i++)
            {
                ans.add(a[i][right]);
            }
            right--;

            if(top<=bottom)
            {
                for (int i=right;i>=left;i--)
                {
                    ans.add(a[bottom][i]);
                }
                bottom--;
            }

            if(left<=right)
            {
                for(int i=bottom;i>=top;i--)
                {
                    ans.add(a[i][left]);
                }
                left++;
            }
        }

        System.out.println(ans);
    }
}
