<%--  
 ***************************************************************************************
 * Description  :   View Scheduled programs which for a particular programs
 * Functionality: It is a jsp page which will show the  list of scheduled programs 
 * Models Used : UASController.java,ProgramsScheduled.java
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
	<table align="center" class="table table-condensed" style="width: 60%;">
		<caption style="background-color: black; text-align: center;">
			<font color="white"><b>Programmes Scheduled for the Winter
					Session</b></font>
		</caption>
		<tr>
			<th>Program Id</th>
			<th>Program Name</th>
			<th>Location</th>
			<th>Start Date</th>
			<th>End date</th>
			<th>Session Per week</th>
			<th></th>
		</tr>

		<c:forEach items="${programs}" var="prog">

			<form:form action="apply.htm?pId=${prog.scheduledProgrammeId}"
				method="post" modelAttribute="ProgramsScheduled">

				<tr>
					<td><form:hidden path="scheduledProgrammeId"
							value="${prog.scheduledProgrammeId}" />
						${prog.scheduledProgrammeId}</td>
					<td><form:hidden path="programName"
							value="${prog.programName}" /><a
						href="programDetails.htm?pName=${prog.programName}&pId=${prog.scheduledProgrammeId}"
						style="color: green; text-decoration: underline;">${prog.programName}</a></td>
					<td><form:hidden path="location" value="${prog.location}" />${prog.location}</td>
					<td><form:hidden path="startDate" value="${prog.startDate}" />${prog.startDate}</td>
					<td><form:hidden path="endDate" value="${prog.endDate}" />${prog.endDate}</td>
					<td><form:hidden path="sessionsPerWeek"
							value="${prog.sessionsPerWeek}" />${prog.sessionsPerWeek}</td>
					<td><input type="submit" value="Apply" class="btn btn-default"></td>
				</tr>
			</form:form>
		</c:forEach>

	</table>
	<h3>Click on Program name to get the details of the program
		scheduled</h3>
</body>
</html>