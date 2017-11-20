<%--  
 ***************************************************************************************
 * Description  :   Details of the program available
 * Functionality: It is a jsp page which display the various programs attribute which 
 *					is available in the current University Scope.
 * 
 * Models Used : UASController.java
 * Restrictions: 
 * Creation date: (09/11/2017)
 * Modifications:
 * Author: Group5       Date: 14-Nov-2017         Change Description:
 ************************************************************************************** --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Program Scheduled</title>
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
			<li><a href="apply.htm?pId">Apply Here</a></li>
			<li><a href="viewstatus.htm">View Status</a></li>
		</ul>
	</div>
	</nav>
	<table align="center" class="table table-condensed" style="width: 70%;">
		<caption style="background-color: black; text-align: center;">
			<font color="white"><b>Programs offered by the University</b></font>
		</caption>
		<tr>
			<th>Program Name</th>
			<th>Description</th>
			<th>Applicant Eligibilty</th>
			<th>Duration</th>
			<th>Degree</th>
		</tr>
		<c:if test="${prog ne null}">
			<tr>
				<td>${prog.programName}</td>
				<td>${prog.description}</td>
				<td>${prog.applicantEligibility}</td>
				<td>${prog.duration}</td>
				<td>${prog.degree}</td>
			</tr>
			<tr>
				<td colspan="5"><a href="apply.htm?pId=${pId}"><button
							class="btn btn-default">Apply here</button></a></td>
			</tr>
		</c:if>

	</table>
</body>
</html>