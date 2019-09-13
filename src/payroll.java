import java.io.*;
import javax.servlet.*;
import java.sql.*;
public class payroll extends GenericServlet
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
	String pid=request.getParameter("pid");
	String eid=request.getParameter("eid");
	String name=request.getParameter("name");
	String sal=request.getParameter("sal");
	String sal_date=request.getParameter("sal_date");
	
	
	try
	{
		String query="insert into payslip values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,pid);
		ps.setString(2,eid);
		ps.setString(3,name);
		ps.setString(4,sal_date);
		ps.setString(5,sal);
		int i=ps.executeUpdate();
		if(i>0)
		{
			
			pw.println("<center><h1>Payslip Details Entry Success</h1></center>");
			
		
			
		}
		else
		{
			pw.println("<center><h1 style='color:red'>Payroll Details Entry Failed, Please Try Again!</h1></center>");
			
		}
	}
	catch(Exception e)
	{
		pw.println("ERROR"+e);
	}
	pw.print("<center><a href='payroll.html'>BACK</a>");
	pw.close();
}
}