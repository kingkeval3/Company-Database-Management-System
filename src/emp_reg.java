import java.io.*;
import javax.servlet.*;
import java.sql.*;
public class emp_reg extends GenericServlet
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
	String dob=request.getParameter("dob");
	String gender=request.getParameter("gender");
	
	try
	{
		String query="insert into employee values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,eid);
		ps.setString(2,name);
		ps.setString(3,ep);
		ps.setString(4,dob);
		ps.setString(5,gender);
		int i=ps.executeUpdate();
		if(i>0)
		{
			
			pw.println("<center><h1>Employee Registration Successfull</h1></center>");
			
		
			
		}
		else
		{
			pw.println("<center><h1 style='color:red'>Employee Registration Failed, Please Try Again!</h1></center>");
			
		}
	}
	catch(Exception e)
	{
		pw.println("ERROR"+e);
	}
	pw.print("<center><a href='emp_reg.html'>BACK</a>");
	pw.close();
}
}