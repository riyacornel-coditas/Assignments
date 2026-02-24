import java.util.*;
class A1{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the month in capital letters");
        String month = sc.nextLine();
        System.out.println("Enter the year");
        int y=sc.nextInt();

        int days;

        days=switch(month){
            case "JANUARY" -> 31;
            case "FEBRUARY" ->{
            int d=0;
            if(y%4==0)
            {
                d=29;
            }
            else
            {
                d=28;
            }
            yield d;
            }
            case "MARCH" -> 31;
            case "APRIL" -> 30;
            case "MAY" -> 31;
            case "JUNE" -> 30;
            case "JULY" -> 31;
            case "AUGUST" -> 31;
            case "SEPTEMBER" -> 30;
            case "OCTOBER" -> 31;
            case "NOVEMBER" -> 30;
            case "DECEMBER" -> 31;
            default -> {
                System.out.println("Invalid month has been entered");
                yield 0;
            }
        };

        System.out.println("The number of days are: "+days);

    }
}