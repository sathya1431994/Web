import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.*;
@WebServlet("/next")
public class Values extends HttpServlet
{
        public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
            {
              	res.setContentType("text/html");
                PrintWriter pr=res.getWriter();
                String uname=req.getParameter("user_name");
                 String pwd=req.getParameter("password");
                pr.println("<h1>Login Success</h1>");
                if(uname.equals(pwd))
                {
                  res.sendRedirect("Register.jsp");
                }
                else
                {
                  pr.println("Sorry.....invalid username/password");
                }
            
            }

}