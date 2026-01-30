import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class A9 {
    public static void main() throws FileNotFoundException
    {
        int c=0;
        String myfile="C:\\Users\\Coditas-Admin\\Documents\\A9 file.txt";
        File file = new File(myfile);
        Scanner text = new Scanner(file);
        while(text.hasNextLine())
        {
            String line=text.nextLine();
            for(int i=0;i<line.length();i++)
            {
                char ch = line.charAt(i);
                if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
                {
                    c++;
                }
            }
        }
        System.out.println("The number of lowercase vowels in file is "+c);
    }
}
