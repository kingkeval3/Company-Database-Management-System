import javax.servlet.*;  				
import javax.servlet.http.*;
import java.io.*; 	

public class login extends HttpServlet
{
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
  {
    res.setContentType("text/html");
    PrintWriter pw = res.getWriter( );
						   
    String str1 = req.getParameter("uname");
    String str2 = req.getParameter("psw");
	    						
    if(str1.equalsIgnoreCase("deepthalva") && str2.equals("hhrpkpmcc"))
    {

    	
    	pw.println("<body background='stark2.jpg' align:'center'>");
    	pw.println("<center><h1 style='color:white'><strong>Welcome to Stark Industries</strong></h1></center>");
      pw.println("<center><a href='index.html'>PROCEED</a></center>");
      pw.println("</body>");
    } 
    else
    {
      pw.println("<center><h2 style='color:red'>UNAUTHORIZED ACCESS....TRY AGAIN</h2></center>");
      pw.println("<center><a href='login.html'>BACK</a></center>");
    }
    pw.close( );
  } 
}  