import java.io.*;  
import java.sql.*;  
import java.sql.Connection;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
import javax.servlet.annotation.*; 
import connection.DB_connect;
@WebServlet("/show")
public class Table extends HttpServlet
 {
     Connection con=DB_connect.getCon(); 
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
        {  
            try
                {  
    PrintWriter pw=response.getWriter();
    response.setContentType("text/html");
   String name=request.getParameter("name");
Statement st=con.createStatement();
ResultSet r=st.executeQuery("select * from user_details");
        pw.println("<table border=3>");
        while(r.next())
        {
          //  String url="<a href=edit?fname="+r.getString(1)+">Delete</a>"
            pw.println("<tr><td>"+r.getString(1)+"</td><td>"+r.getString(2)+"</td><td>"+r.getString(3)+"</td><td>"+r.getString(4)+"</td><td>"+r.getString(5)+"</td><td>"+r.getString(6)+"</td><td>"+r.getString(7)+"</td><td>"+"<a href=delete?id="+r.getString(1)+">Delete</a>");
        }
        pw.println("</table>");
        pw.close();
}
catch (Exception ex) 
{
    System.out.println(ex);
}  
          
}  
  
 }