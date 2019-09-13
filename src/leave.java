import java.io.*;
import javax.servlet.*;
import java.sql.*;
public class leave extends GenericServlet
{
	Connection con;
	public void init() throws ServletException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/D","root","hhrpkpmcc");
		}
		catch(Exception e)
		{
			
		}
	}
public void service(ServletRequest request,
ServletResponse response) throws ServletException,IOException
{
	response.setContentType("text/html");
	PrintWriter pw=response.getWriter();
	
	String eid=request.getParameter("eid");
	String name=request.getParameter("name");
	String lp=request.getParameter("lp");
	String l_date=request.getParameter("l_date");
	String nod=request.getParameter("nod");
	
	
	try
	{
		String query="insert into e_leave values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,eid);
		ps.setString(2,name);
		ps.setString(3,l_date);
		ps.setString(4,lp);
		ps.setString(5,nod);
		int i=ps.executeUpdate();
		if(i>0)
		{
			
			pw.println("<center><h1>Leave of Abscence Reported</h1></center>");
			
		
			
		}
		else
		{
			pw.println("<center><h1 style='color:red'>Leave of Abscence Report Failed, Please Try Again!</h1></center>");
			
		}
	}
	catch(Exception e)
	{
		pw.println("ERROR"+e);
	}
	pw.print("<center><a href='resignation.html'>BACK</a>");
	pw.close();
}
}