
<%@page import="java.sql.*"%>

<%

String eid = request.getParameter("eid");
String name=request.getParameter("name");
String ep=request.getParameter("ep");
String dob=request.getParameter("dob");
String gender=request.getParameter("gender");try{
Connection conn = null;
Class.forName("com.mysql.jdbc.Driver").newInstance();
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/D","root", "hhrpkpmcc");
Statement st=null;
st=conn.createStatement();




String sqlEDIT="UPDATE INTO employee VALUES(?,?,?,?,?)";
java.sql.PreparedStatement ps=conn.prepareStatement(sqlEDIT);
ps.setString(1,eid);
ps.setString(2,name);
ps.setString(3, ep);
ps.setString(4,dob);
ps.setString(5,gender);
ps.executeUpdate();
   int i=ps.executeUpdate();
if(i>0)
        {
            out.print("project added into database");
            response.sendRedirect("demo1.jsp");
        }
}
catch(Exception e){
System.out.println(e);
    }
%>
