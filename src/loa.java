import java.io.*;
import javax.servlet.*;
import java.sql.*;
public class loa extends GenericServlet
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
			System.out.print(e);
		}
	}
public void service(ServletRequest request,
ServletResponse response) throws ServletException,IOException
{
	response.setContentType("text/html");
	PrintWriter pw=response.getWriter();
	
	try
	{
	PreparedStatement st=con.prepareStatement("select * from e_leave");
   
   
	ResultSet rs=st.executeQuery();
	pw.print("<style>\r\n" + 
			
			"table tr:nth-child(even) {\r\n" + 
			"    background-color: pink;\r\n" + 
			"}\r\n" + 
			"table tr:nth-child(odd) {\r\n" + 
			"   background-color: pink;\r\n" + 
			"}\r\n" + 
			"table th {\r\n" + 
			"    background-color: blue;\r\n" + 
			"    color: white;\r\n" + 
			"}\r\n" + 
			"</style>");
	pw.print("<body background='leave.jpg'>");
		pw.print("<center><table   width='50%'  height='50%'    border='1' >");
		pw.print("<tr>");
	pw.print("<th>"+"EMPLOYEE ID"+"</th>");
	pw.print("<th>"+"EMPLOYEE NAME"+"</th>");
	pw.print("<th>"+"LEAVE DATE"+"</th>");
	pw.print("<th>"+"LEAVE PURPOSE"+"</th>");
	pw.print("<th>"+"NO OF DAYS"+"</th>");

	pw.print("</tr>");
     while(rs.next())  
	{
    	 pw.print("<tr>");
	
	String eid=rs.getString("eid");
	
	String ename=rs.getString("ename");
		
	String leave_date=rs.getString("leave_date");
	String leave_purpose=rs.getString("leave_purpose");
	String no_of_days=rs.getString("no_of_days");


	
	
	pw.print("<td>"+eid+"</td>");
	pw.print("<td>"+ename+"</td>");

	pw.print("<td>"+leave_date+"</td>");
	pw.print("<td>"+leave_purpose+"</td>");
	pw.print("<td>"+no_of_days+"</td>");


	pw.print("</tr>");
	   
	}
     
     pw.print("</table></center>");
     pw.print("</body>");
}catch(Exception e)
{
	
	pw.println(e);
}

pw.print("<center><a href='company_status.html'>BACK</a>");
pw.close();
}

}
