import java.util.*;
public class A4 {
    public static void main()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String s = sc.nextLine();
        char[] ch = s.toCharArray();
        int ind=0;
        int count;
        for(int i=0;i<ch.length;i++)
        {
            char c=ch[i];
            count=0;
            while(i<ch.length && c==ch[i])
            {
                count++;
                i++;
            }
            if(count==1)
            {
                ch[ind++]=c;
            }
            else
            {
                ch[ind++]=c;
                String dig = Integer.toString(count);
                for(int j=0;j<dig.length();j++)
                {
                    ch[ind++]=dig.charAt(j);
                }

            }
            i--;
        }

        String str = new String(ch,0,ind);
        System.out.println("The compressed string is "+str);
    }
}
