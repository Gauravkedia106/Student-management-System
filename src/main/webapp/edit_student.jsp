<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.conn.DBConnect" %>
<%@page import="com.dao.StudentDao" %>
<%@page import="com.entity.Student"%>
<%@page import="java.sql.Connection" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="all_css.jsp" %>
</head>

<body class="bg-Light">

<%@include file="navbar.jsp" %>

<div class="container p-4">
<div class="row">
<div class="col-md-6 offset-md-3 ">
<div class="card">

<div class="card-body">
<p class="fs-3 text-center">Edit Student</p>





<%
int id = Integer.parseInt(request.getParameter("id"));
StudentDao dao =new StudentDao(DBConnect.getConn());
Student s =dao.getStudentbyId(id);
%>

<form action="update" method="post">

  <div class="mb-3">
    <label  class="form-label">Full Name</label>
    <input type="text"  value="<%= s.getFullName()%>" name="name" class="form-control" >
    </div>
    
    <div class="mb-3">
    <label  class="form-label">Date of Birth</label>
    <input type="date"  value="<%= s.getDob()%>"  name="dob" class="form-control" >
    </div>
    
    <div class="mb-3">
    <label  class="form-label">Address</label>
    <input type="text"  value="<%= s.getAddress()%>" name="address" class="form-control" >
    </div>
    
    <div class="mb-3">
    <label  class="form-label">Qualification</label>
    <input type="text"  value="<%= s.getQulifaction()%>" name="qualification" class="form-control" >
    </div>
    
    
   <div class="mb-3">
    <label  class="form-label">Email address</label>
    <input type="email"  value="<%= s.getEmail()%>" name="email" class="form-control" >
    </div>
    
    <input type="hidden" name="id" value="<%=s.getId() %>">
    
    <button type="submit" class="btn btn-primary col-md-12">Update</button>
    
</form>


</div> 	 
</div>
</div>

</div>

</div>

</body>
</html>