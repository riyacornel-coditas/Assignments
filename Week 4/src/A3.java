import java.util.*;
public class A3 {
    public static void main(String[] args)
    {
        String SqlQuery = """ 
        UPDATE Customers
        SET ContactName = 'Riya Cornel', City= 'Pune'
        WHERE CustomerID = 13;
                """;

        System.out.println("The sql query is:");
        System.out.println(SqlQuery);
    }
}
