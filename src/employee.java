import java.io.*;
import javax.servlet.*;
import java.sql.*;
public class employee extends GenericServlet
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
	PreparedStatement st=con.prepareStatement("select * from employee");
   
   
	ResultSet rs=st.executeQuery();
	pw.print("<style>\r\n" + 
			
			"table tr:nth-child(even) {\r\n" + 
			"    background-color: orange;\r\n" + 
			"}\r\n" + 
			"table tr:nth-child(odd) {\r\n" + 
			"   background-color: orange;\r\n" + 
			"}\r\n" + 
			"table th {\r\n" + 
			"    background-color: red;\r\n" + 
			"    color: white;\r\n" + 
			"}\r\n" + 
			"</style>");
	pw.print("<body background='employee.jpg'>");
		pw.print("<center><table   width='50%'  height='50%'    border='1' >");
		pw.print("<tr>");
	pw.print("<th>"+"EMPLOYEE ID"+"</th>");
	pw.print("<th>"+"EMPLOYEE NAME"+"</th>");
	pw.print("<th>"+"DESIGNATION"+"</th>");
	pw.print("<th>"+"DATE OF BIRTH"+"</th>");
	pw.print("<th>"+"GENDER"+"</th>");
	pw.print("</tr>");
     while(rs.next())  
	{
    	 pw.print("<tr>");
	String eid=rs.getString("eid");	
	String ename=rs.getString("ename");
	
	String epost=rs.getString("epost");
	String dob=rs.getString("dob");
	String gender=rs.getString("gender");

	
	pw.print("<td>"+eid+"</td>");
	pw.print("<td>"+ename+"</td>");
	pw.print("<td>"+epost+"</td>");
	pw.print("<td>"+dob+"</td>");
	pw.print("<td>"+gender+"</td>");

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
