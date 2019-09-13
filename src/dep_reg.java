import java.io.*;
import javax.servlet.*;
import java.sql.*;
public class dep_reg extends GenericServlet
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
	String ep=request.getParameter("ep");
	String did=request.getParameter("did");
	String ed=request.getParameter("ed");
	String hod=request.getParameter("hod");
	
	try
	{
		String query="insert into department values(?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,eid);
		ps.setString(2,name);
		ps.setString(3,ep);
		ps.setString(4,did);
		ps.setString(5,ed);
		ps.setString(6,hod);
		int i=ps.executeUpdate();
		if(i>0)
		{
			
			pw.println("<center><h1>Department Details Entered Successfull</h1></center>");
			
		
			
		}
		else
		{
			pw.println("<center><h1 style='color:red'>Department Details Entry Failed, Please Try Again!</h1></center>");
			
		}
	}
	catch(Exception e)
	{
		pw.println("ERROR"+e);
	}
	pw.print("<center><a href='dep.html'>BACK</a>");
	pw.close();
}
}