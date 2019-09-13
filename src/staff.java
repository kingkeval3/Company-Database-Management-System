import java.io.*;
import javax.servlet.*;
import java.sql.*;
public class staff extends GenericServlet
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
	String did=request.getParameter("did");
	String aid=request.getParameter("aid");
	String sname=request.getParameter("sname");
	String ad=request.getParameter("ad");
	String sal=request.getParameter("sal");
	String add=request.getParameter("add");
	
	
	try
	{
		String query="insert into recruit values(?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,did);
		ps.setString(2,sname);
		ps.setString(3,aid);
		ps.setString(4,ad);
		ps.setString(5,sal);
		ps.setString(6,add);
		int i=ps.executeUpdate();
		if(i>0)
		{
			
			pw.println("<center><h1>Recruitment Details Entry Success</h1></center>");
			
		
			
		}
		else
		{
			pw.println("<center><h1 style='color:red'>Recruitment Details Entry Failed, Please Try Again!</h1></center>");
			
		}
	}
	catch(Exception e)
	{
		pw.println("ERROR"+e);
	}
	pw.print("<center><a href='staff.html'>BACK</a>");
	pw.close();
}
}