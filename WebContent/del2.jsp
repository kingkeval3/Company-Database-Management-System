<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@ page import="java.sql.*" %>

<%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


</head>
<body>

<center>


<%	try{
	
	Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/D","root","hhrpkpmcc");
	String eid = request.getParameter("eid");
    String query="select * from employee where eid='"+eid+"'";
	PreparedStatement ps=con.prepareStatement(query);
	ResultSet rs=ps.executeQuery();
	if(rs.next()){
	
	//out.println(n);
	         String q="delete  from employee where eid='"+eid+"'";
	     	 PreparedStatement statement=con.prepareStatement(q);
             int i=statement.executeUpdate();
             if(i>0){
            	 out.println("<body background='ddd.gif'>");
                 
                 out.println("<center><h1 style='color:red'>DELETED SUCCESSFULLY</h1><a href='del1.jsp'>BACK</a><center>");
                 out.println("</body>");
             }
	}
	else
	{
   	 out.println("<script>alert('NO RECORDS FOUND TO DELETE');window.location='del1.jsp';</script>");

	}

     }catch(Exception e){
    	 
    	 out.println("Unable to connect to database.");

     }
	%>
  </form>
    </div>
</center>

</body>
</html>