package connection;
import java.util.*;
import java.sql.*;
public class DB_connect
{
    static Connection conn;
    public static Connection getCon()
    {
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","");
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
    }
     return conn;
    }
}
