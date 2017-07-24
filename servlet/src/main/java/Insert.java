import java.io.*;  
import java.sql.*;  
import java.sql.Connection;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
import javax.servlet.annotation.*; 
import connection.DB_connect;
import javax.servlet.RequestDispatcher;
@WebServlet("/insert")
public class Insert extends HttpServlet
{
    Connection con=DB_connect.getCon(); 
    public void init()
    {
      /*  try {
            
            PrintWriter pw=response.getWriter();
             response.setContentType("text/html");
              Statement st=con.createStatement();
         ResultSet r=st.executeQuery("select * from details");
        pw.println("<table border=3>");
        while(r.next())
        {
            String url="<a href=edit?fname="+r.getString(1)+"&"+"lname="+r.getString(2)+"&"+"email="+r.getString(3)+"&"+"date="+r.getString(4)+"&"+"time="+r.getString(5)+"&"+"topic="+r.getString(6)+"&"+"location="+r.getString(7)+">Edit</a>";
            pw.println("<tr><td>"+r.getString(1)+"</td><td>"+r.getString(2)+"</td><td>"+r.getString(3)+"</td><td>"+r.getString(4)+"</td><td>"+r.getString(5)+"</td><td>"+r.getString(6)+"</td><td>"+r.getString(7)+"</td><td>"+"<a href=delete?id="+r.getString(1)+">Delete</a>"+"</td><td>"+url);
        }
        pw.println("</table>");
        pw.close();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    */
    }
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {  
           try
                { 
                    //insert data 
    PrintWriter pw=response.getWriter();
    response.setContentType("text/html");
    String fname=request.getParameter("firstname");
    String lname=request.getParameter("lastname");
    String email=request.getParameter("email");
    String date=request.getParameter("date");
    String time=request.getParameter("time");
    String topic=request.getParameter("topic");
    String location=request.getParameter("location");
    PreparedStatement st=con.prepareStatement("insert into details(firstname,lastname,email,date,time,topic,location) values(?,?,?,?,?,?,?)");
    st.setString(1,fname);
    st.setString(2,lname);
    st.setString(3,email);
    st.setString(4,date);
    st.setString(5,time);
    st.setString(6,topic);
    st.setString(7,location);
    st.executeUpdate();
    //show data
    //Statement st=con.createStatement();
    ResultSet r=st.executeQuery("select * from details");
        pw.println("<table border=3>");
        while(r.next())
        {
            String url="<a href=edit?fname="+r.getString(1)+"&"+"lname="+r.getString(2)+"&"+"email="+r.getString(3)+"&"+"date="+r.getString(4)+"&"+"time="+r.getString(5)+"&"+"topic="+r.getString(6)+"&"+"location="+r.getString(7)+">Edit</a>";
            pw.println("<tr><td>"+r.getString(1)+"</td><td>"+r.getString(2)+"</td><td>"+r.getString(3)+"</td><td>"+r.getString(4)+"</td><td>"+r.getString(5)+"</td><td>"+r.getString(6)+"</td><td>"+r.getString(7)+"</td><td>"+"<a href=delete?id="+r.getString(1)+">Delete</a>"+"</td><td>"+url);
        }
        pw.println("</table>");
        pw.close();
                }
  catch (Exception ex) 
   {
    System.out.println(ex);
      } 
}

public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {  
               PrintWriter pw=response.getWriter();
              response.setContentType("text/html");
              pw.println("vengat");  
      }

}