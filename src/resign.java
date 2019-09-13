import java.io.*;
import javax.servlet.*;
import java.sql.*;
public class resign extends GenericServlet
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
	String rid=request.getParameter("rid");
	String eid=request.getParameter("eid");
	String name=request.getParameter("name");
	String rp=request.getParameter("rp");
	String r_date=request.getParameter("r_date");
	
	
	try
	{
		String query="insert into resign values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,eid);
		ps.setString(2,name);
		ps.setString(3,rp);
		ps.setString(4,rid);
		ps.setString(5,r_date);
		int i=ps.executeUpdate();
		if(i>0)
		{
			
			pw.println("<center><h1>Resignation Details Entry Success</h1></center>");
			
		
			
		}
		else
		{
			pw.println("<center><h1 style='color:red'>Resignation Details Entry Failed, Please Try Again!</h1></center>");
			
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