<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMPLOYEE UPDATE</title>
<style>
background{

size: cover;

}
input[type=text], select {
    width: 20%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 2px solid black;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 20%;
    background-color: black;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: red;
    color: black;
}

input[type=text]:focus {
    background-color: blue;
    color: white;
}


div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
    opacity: 0.3;
    filter: alpha(opacity=30);
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
    background-color: brown; 
    color: white; 
         
}


a:hover {
    background-color: red;
    color: white;
}
</style>

<body background="uu.gif">

</head>
<body>
<form action="update2.jsp" >
<center> <h1 style="color:red;"><b>Employee ID:</b></h1>
    <input type="text"  name="eid" placeholder=" Employee ID to update...">
    <br><br> 

<input type=submit value="Submit">
</center>
</form> 
<br>
</div>
<center><h2><a href="modify.html"><b>GO BACK</b></a></h2></center>

</body>
</html>