<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.sql.*" %>
      <%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DEPARTMENT REGISTER</title>
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
 
 <form action="dep.html" method="post">

  
        
        
<%


String emp_id=request.getParameter("eid");
String ename=request.getParameter("name");
String did=request.getParameter("did");
String ed=request.getParameter("ed");
String eds=request.getParameter("ep");
String hod=request.getParameter("hod");




String connectionURL ="jdbc:mysql://localhost:3306/D";

Connection connection = null;

PreparedStatement pstatement = null;

Class.forName("com.mysql.jdbc.Driver");

int updateQuery = 0;

if( emp_id!=null && ename!=null && did!=null && ed!=null && eds!=null && hod!=null){

if( emp_id!="" && ename!="" && did!="" && ed!=""&& eds!="" && hod!="") {

try {

connection = DriverManager.getConnection(connectionURL,"root","hhrpkpmcc");

String queryString = "insert into department values( ?, ? , ? ,?, ?, ?)";

pstatement = connection.prepareStatement(queryString);


pstatement.setString(1,emp_id);
pstatement.setString(2,ename);

pstatement.setString(3,eds);

pstatement.setString(4,did);
pstatement.setString(5,ed);
pstatement.setString(6,hod);



updateQuery = pstatement.executeUpdate();

if (updateQuery != 0) { %>

<br>

<body background='suc3.jpg'>
      
        <center><h1 style='color:green'>Department Details Registered</h1><a href='dep.html'>BACK</a><center>
        </body>

<%

}

}

catch (Exception ex) {
%>
<script type="text/javascript">
alert("<%= ex %> ");
window.location="dep.html";
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