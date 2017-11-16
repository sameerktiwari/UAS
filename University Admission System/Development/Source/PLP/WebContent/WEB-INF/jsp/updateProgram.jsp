<%--  
 ***************************************************************************************
 * Description  :   update Program details which is changed by the university.
 * Functionality: It is a jsp page which display the updation field which is required to 
 * 					change. This file should be accessible to administrator only.
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
<title>Update program</title>
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
			<li class="active"><a href="viewAdminPrgrms.htm">View
					Programmes</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="login.htm"><span
					class="glyphicon glyphicon-log-in"></span>${sessionScope.users.loginId}(Logout)</a></li>
		</ul>
	</div>
	</nav>
	<form:form action="update.htm" method="post"
		modelAttribute="programsScheduled">

		<table align="center" class="table table-condensed"
			style="width: 50%;">
			<caption style="background-color: black; text-align: center;">
				<font color="white"><b>Update program</b></font>
			</caption>
			<tr>
				<td>Program Id</td>
				<td><form:input path="scheduledProgrammeId"
						value="${prog.scheduledProgrammeId}" /></td>
			</tr>
			<tr>
				<td>Program Name</td>
				<td><form:input path="programName" value="${prog.programName}" /></td>
			</tr>
			<tr>
				<td>Location</td>
				<td><form:input path="location" value="${prog.location}" /></td>
			</tr>
			<tr>
				<td>Start Date</td>
				<td><form:input path="startDate" value="${prog.startDate}" /></td>
			</tr>
			<tr>
				<td>End date</td>
				<td><form:input path="endDate" value="${prog.endDate}" /></td>
			</tr>
			<tr>
				<td>Session Per week</td>
				<td><form:input path="sessionsPerWeek"
						value="${prog.sessionsPerWeek}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input class="btn btn-default" type="submit"
					value="Update" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>