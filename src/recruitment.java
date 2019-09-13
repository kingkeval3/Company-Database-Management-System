import java.io.*;
import javax.servlet.*;
import java.sql.*;
public class recruitment extends GenericServlet
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
	PreparedStatement st=con.prepareStatement("select * from recruit");
   
   
	ResultSet rs=st.executeQuery();
	pw.print("<style>\r\n" + 
			
			"table tr:nth-child(even) {\r\n" + 
			"    background-color: orange;\r\n" + 
			"}\r\n" + 
			"table tr:nth-child(odd) {\r\n" + 
			"   background-color: orange;\r\n" + 
			"}\r\n" + 
			"table th {\r\n" + 
			"    background-color: brown;\r\n" + 
			"    color: white;\r\n" + 
			"}\r\n" + 
			"</style>");
	pw.print("<body background='rec.jpg'>");
		pw.print("<center><table   width='50%'  height='50%'    border='1' >");
		pw.print("<tr>");
	pw.print("<th>"+"DEPARTMENT CODE"+"</th>");
	pw.print("<th>"+"STAFF NAME"+"</th>");
	pw.print("<th>"+"APPOINTMENT ID"+"</th>");
	pw.print("<th>"+"APPOINTMENT DATE"+"</th>");
	pw.print("<th>"+"SALARY"+"</th>");
	pw.print("<th>"+"ADDRESS"+"</th>");
	pw.print("</tr>");
     while(rs.next())  
	{
    	 pw.print("<tr>");
	String did=rs.getString("did");	
	String sname=rs.getString("sname");
	
	String app_id=rs.getString("app_id");
	String app_date=rs.getString("app_date");
	String salary=rs.getString("salary");
	String address=rs.getString("address");

	
	pw.print("<td>"+did+"</td>");
	pw.print("<td>"+sname+"</td>");
	pw.print("<td>"+app_id+"</td>");
	pw.print("<td>"+app_date+"</td>");
	pw.print("<td>"+salary+"</td>");

	pw.print("<td>"+address+"</td>");
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
