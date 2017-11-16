<%--  
 ***************************************************************************************
 * Description  :   Error page of the application
 * Functionality: It is a jsp page which display the various error which 
 *					may be generated . 
 * Models Used : UASController.java
 * Restrictions: 
 * Creation date: (09/11/2017)
 * Modifications:
 * Author: Group5       Date: 14-Nov-2017         Change Description:
 ************************************************************************************** --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
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
			<li><a href="index.htm">Home</a></li>
			<li class="active"><a href="viewprgrms.htm">View Programmes</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="login.htm"><span
					class="glyphicon glyphicon-log-in"></span>Login</a></li>
		</ul>
	</div>
	</nav>
	<h2 class="bg-info">Error Occured: ${msg}</h2>
</body>
</html>