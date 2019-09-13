<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.sql.*" %>
      <%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payroll Listing</title>
<style>


h1{ font-size:50} 
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
          background-color: yellow; 
          color: white; 
          border: skyblue; 
               
      }


      a:hover {
          background-color: green;
          color: black;

</style>
</head>
<body>
 
 <form action="leave.html" method="post">

  
        
        
<%


String eid=request.getParameter("eid");
String name=request.getParameter("name");
String lp=request.getParameter("lp");
String l_date=request.getParameter("l_date");
String nod=request.getParameter("nod");





String connectionURL ="jdbc:mysql://localhost:3306/D";

Connection connection = null;

PreparedStatement pstatement = null;

Class.forName("com.mysql.jdbc.Driver");

int updateQuery = 0;

if( eid!=null && name!=null && lp!=null && l_date!=null && nod!=null ){

if( eid!="" && name!="" && lp!="" && l_date!=""&& nod!="" ) {

try {

connection = DriverManager.getConnection(connectionURL,"root","hhrpkpmcc");

String queryString = "insert into e_leave values( ?, ? , ? ,?, ?)";

pstatement = connection.prepareStatement(queryString);


pstatement.setString(1,eid);
pstatement.setString(2,name);

pstatement.setString(3,l_date);

pstatement.setString(4,lp);
pstatement.setString(5,nod);




updateQuery = pstatement.executeUpdate();

if (updateQuery != 0) { %>

<br>

<body background='suc3.jpg'>
      
        <center><h1 style='color:green'>Leave of Absence Entered Successfully</h1><a href='staff.html'>BACK</a><center>
        </body>

<%

}

}

catch (Exception ex) {
%>
<script type="text/javascript">
alert("<%= ex %> ");
window.location="staff.html";
</script>



<% 
}

finally {

pstatement.close();

connection.close();

}

}

}

%>

  </form>

 
</body>
</html>