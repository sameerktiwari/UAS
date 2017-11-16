<%--  
 ***************************************************************************************
 * Description  :   View status of application which was submitted earlier
 * Functionality: It is a jsp page which will show status of application if you know the 
 					application number. This is public accessible 
 * Models Used : UASController.java,ProgramsScheduled.java
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
<title>View Status</title>
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
			<li><a href="index.jsp">Home</a></li>
			<li><a href="viewprgrms.htm">View Programmes</a></li>
			<li><a href="apply.htm?pId">Apply Here</a></li>
			<li class="active"><a href="viewstatus.htm">View Status</a></li>
		</ul>
	</div>
	</nav>
	<form action="getStatus.htm">
		<table align="center" class="table table-condensed"
			style="width: 50%;">
			<caption style="background-color: black; text-align: center;">
				<font color="white"><b>Application Status</b></font>
			</caption>
			<tr>
				<td>Enter your Application ID:</td>
				<td><input type="text" name="appId"></td>
			</tr>
			<tr>
				<td colspan="2"><input class="btn btn-default" type="submit"
					value="Get Status"></td>
			</tr>
		</table>
		<c:if test="${applicant ne null}">
			<h3 class="bg-success">Your Application status:
				${applicant.status}</h3>
			<table align="center" class="table table-striped" style="width: 60%;">
				<tr>
					<td>Application ID:</td>
					<td>${applicant.applicationId}</td>
				</tr>
				<tr>
					<td>Full Name:</td>
					<td>${applicant.fullName}</td>
				</tr>
				<tr>
					<td>Date of Birth:</td>
					<td>${applicant.dateOfBirth}</td>
				</tr>
				<tr>
					<td>Highest Qualification:</td>
					<td>${applicant.highestQualification}</td>
				</tr>
				<tr>
					<td>Marks Obtained:</td>
					<td>${applicant.marksObtained}</td>
				</tr>
				<tr>
					<td>Email:</td>
					<td>${applicant.email}</td>
				</tr>
				<tr>
					<td>Goals:</td>
					<td>${applicant.goals}</td>
				</tr>
				<tr>
					<td>Scheduled Programmed ID:</td>
					<td>${applicant.scheduledProgramId}</td>
				</tr>
				<tr>
					<td>Status:</td>
					<td>${applicant.status}</td>
				</tr>
				<tr>
					<td>Date of Interview:</td>
					<td>${applicant.dateOfInterview}</td>
				</tr>
			</table>
		</c:if>
	</form>
</body>
</html>