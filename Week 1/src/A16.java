import java.util.*;
public class A16 {
    public static void main(String[] args)
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
        int n=a.length;
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(a[j][0]>a[j+1][0])
                {
                    int[] temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        List<int[]> ans = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(ans.isEmpty() || a[i][0] > ans.get(ans.size()-1)[1])
            {
                ans.add(a[i]);
            }
            else
            {
                ans.get(ans.size()-1)[1]= Math.max(ans.get(ans.size()-1)[1], a[i][1]);
            }
        }

        for (int[] row : ans) {
            System.out.println(row[0] + " " + row[1]);
        }


    }
}
