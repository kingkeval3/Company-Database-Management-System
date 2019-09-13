<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Update</title>
<style>
input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 2px solid green;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=date], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 2px solid green;
    border-radius: 4px;
    box-sizing: border-box;
}


input[type=submit] {
    width: 30%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
    opacity: 0.8;
    filter: alpha(opacity=80);
}


a {
    background-color: blue; /* Green */
    border: none;
    color: white;
    padding: 6px 22px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
}

a {
    background-color: white; 
    color: black; 
    border: 2px solid green;
}


a:hover {
    background-color: green;
    color: black;
}
</style>

</head>

<% 
String connectionURL ="jdbc:mysql://localhost:3306/D";

Connection connection = null;



ResultSet rs=null;

try {

	Class.forName("com.mysql.jdbc.Driver").newInstance();

	connection = DriverManager.getConnection(connectionURL,"root","hhrpkpmcc");
     
	String eid=request.getParameter("eid");
	String queryString ="select * from employee  where eid=? " ;
	PreparedStatement ps=connection.prepareStatement(queryString);
	ps.setString(1,eid);

	 HttpSession s = request.getSession();
	 
     rs= ps.executeQuery();
   
 
	
   
   while(rs.next())
   {
	%>    
	
	
	
<body background="update.gif">



<form action=update2.jsp method=post>

<div>
<h1 style="color:green"><U>EMPLOYEE DETAILS UPDATE</U></h1><BR>
<center><h3 style="color:white">EMPLOYEE ID:<br><input type="text" name="eid" value=<%=rs.getString(1) %> > </h3> <br>

<h3 style="color:white">EMPLOYEE NAME:<br><input type="text" name="en"  value=<%=rs.getString(2) %>> </h3> <br>


<h3 style="color:white">EMPLOYEE POST:<br><input type="text" name="ep"  value=<%=rs.getString(3) %>> </h3> <br>

<h3 style="color:white">DATE OF BIRTH:<br><input type="date" name="dob"  value=<%=rs.getString(4) %>> </h3> <br>

<h3 style="color:white">GENDER:<br><input type="text" name="g"  value=<%=rs.getString(5) %>> </h3> <br>








<p><input type="submit" value="UPDATE"/>  </p>



<a  href="update1.jsp"><font style=color:white>GO Back </font> </a>



</div>

 
   <%  
   }

   
}
catch(Exception e)
{
	 out.println(e);
}



	%>












<%

String eid=request.getParameter("eid");
String en=request.getParameter("en");
String ep=request.getParameter("ep");
String dob=request.getParameter("dob");
String g=request.getParameter("g");



int i=0;
if(eid!=null &&en!=null &&ep!=null  &&dob!=null  &&g!=null){
	if(eid!="" &&en!="" &&ep!="" &&dob!="" &&g!="" ){


try
 {
   Class.forName("com.mysql.jdbc.Driver");
   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/D","root","hhrpkpmcc");
   

   
   
   PreparedStatement st=con.prepareStatement("update employee set ename=?,epost=?,dob=?,gender=? where eid=? ");
  
   st.setString(1,en);
   st.setString(2,ep);
   st.setString(3,dob);
   st.setString(4,g);
   st.setString(5,eid);
   
   
   
   
   i=st.executeUpdate();
	
	if(i!=0)
	{
		
		 
			out.println("<script>alert(' Employee Details Updated Sucessfully');window.location='update1.jsp';</script>");
		
	
	
	}
	
 }
	
	
	
	catch(Exception e1)
	{
		 out.println(e1);
		 
			out.println("<script>alert(' Not Updated Sucessfully');window.location='update1.jsp';</script>");
	}
		}
}

%>

</div>
</form>

</body>

</html>