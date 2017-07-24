import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import connection.DB_connect;
import connection.DB_connect.*;
@WebServlet("/edit")
public class Edit extends HttpServlet
{
     
     static String fname,lname,email,date,time,topic,location;
    static  Connection conn=DB_connect.getCon();
            public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
            {
                String fname=req.getParameter("fname");
                String lname=req.getParameter("lname");
                String email=req.getParameter("email");
                String date=req.getParameter("date");
                String time=req.getParameter("time");
                 String topic=req.getParameter("topic");
                 String location=req.getParameter("location");
                PrintWriter p=res.getWriter();
                res.setContentType("text/html");
                p.println(fname);
               p.println("<html>"+"<head>"+"<body>");
               p.println("<form action='show' method='GET'>");
                p.println("name<input type='text'"+ "value="+fname+"</br>");
                 p.println("<input type='submit'"+ "value=Update");
                 p.println("</body>"+"</head>"+"</html>");
                     Edit.update();
            }
            public static void update()
{
    try
    {
        PreparedStatement ps=conn.prepareStatement("update user_details set fname=? where fname="+fname);
       ps.setString(1,fname);
       ps.executeUpdate();
      
        
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
    }
}
}