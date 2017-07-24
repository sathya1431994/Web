import java.io.*;  
import java.sql.*;  
import java.sql.Connection;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
import javax.servlet.annotation.*; 
import connection.DB_connect;
import javax.servlet.RequestDispatcher;
import java.util.*;
@WebServlet("/pass")
public class Pass extends HttpServlet
{

     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
        {  
               List<String> l1=new ArrayList<String>();
               l1.add("vengat");
               l1.add("vijay");
        request.setAttribute("name", l1);
        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);     
        //response.sendRedirect("index.jsp");

        }
}
