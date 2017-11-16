<%--  
 ***************************************************************************************
 * Description  :   Administrator page of the application
 * Functionality: It is a jsp page which display the various option for Administrator
 * 
 * Models Used : UASController.java
 * Restrictions: 
 * Creation date: (09/11/2017)
 * Modifications:
 * Author: Group5       Date: 14-Nov-2017         Change Description:
 ************************************************************************************** --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<script src="js/bootstrap.min.js">
	
</script>
<script src="js/jquery-3.2.1.min.js">
	
</script>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="index.htm">University Admission
				System</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="returnHome.htm">Home</a></li>
			<li><a href="viewAdminPrgrms.htm">View Programmes</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="login.htm"><span
					class="glyphicon glyphicon-log-in"></span>${sessionScope.users.loginId}(Logout)</a></li>
		</ul>
	</div>
	</nav>
	<h1>Welcome ${sessionScope.users.loginId},</h1>
	<h3>Logged in as ${sessionScope.users.role}</h3>
	<h3>Kindly logout when you are done</h3>
	<h2 class="bg-success">${message}</h2>
</body>
</html>