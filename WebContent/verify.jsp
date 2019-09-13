

<%@ page import ="java.sql.*" %>


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
          background-color: black; 
          color: white; 
          border: skyblue; 
               
      }


      a:hover {
          background-color: skyblue;
          color: black;
      </style>


<%
    String userid = request.getParameter("uname");    
    String pwd = request.getParameter("psw");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/D",
            "root", "hhrpkpmcc");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from login where username='" + userid + "' and password='" + pwd + "'");
    if (rs.next()) {
        session.setAttribute("userid", userid);
        session.setAttribute("password", pwd);

        //out.println("welcome " + userid);
        //out.println("<a href='logout.jsp'>Log out</a>");
       
         
        
        out.println("<body background='stark.jpg'>");
      
        out.println("<center><h1 style='color:skyblue'>Welcome to Stark Industries...</h1><a href='index.html'>Proceed</a><center>");
        out.println("</body>");
    } else {
    	out.println("<body background='error.gif'>");
        
        out.println("<center><h1 style='color:red'>UNAUTHORIZED ACCESS....TRY AGAIN</h1><a href='login.html'>Click here</a><center>");
        out.println("</body>");
    }
%>