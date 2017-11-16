<%--  
 ***************************************************************************************
 * Description  :   View all Scheduled programs which for a particular programs
 * Functionality: It is a jsp page which will show the  list of available scheduled programs.
 					this functionality should be accessible to Member of admission committee only. 
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
			<li><a href="returnHome.htm">Home</a></li>
			<li class="active"><a href="viewprgrms.htm">View Programmes</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="login.htm"><span
					class="glyphicon glyphicon-log-in"></span>${sessionScope.users.loginId}(Logout)</a></li>
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
			<form:form action="viewApplications.htm" method="post"
				modelAttribute="ProgramsScheduled">
				<tr>
					<td><form:hidden path="scheduledProgrammeId"
							value="${prog.scheduledProgrammeId}" />
						${prog.scheduledProgrammeId}</td>
					<td><form:hidden path="programName"
							value="${prog.programName}" />${prog.programName}</td>
					<td><form:hidden path="location" value="${prog.location}" />${prog.location}</td>
					<td><form:hidden path="startDate" value="${prog.startDate}" />${prog.startDate}</td>
					<td><form:hidden path="endDate" value="${prog.endDate}" />${prog.endDate}</td>
					<td><form:hidden path="sessionsPerWeek"
							value="${prog.sessionsPerWeek}" />${prog.sessionsPerWeek}</td>
					<td><input class="btn btn-default" type="submit"
						value="View Applications"></td>
				</tr>
			</form:form>
		</c:forEach>
	</table>
	<c:if test="${appList ne null}">
		<table border="2">
			<tr>
				<th>applicationId</th>
				<th>fullName</th>
				<th>dateOfBirth</th>
				<th>highestQualification</th>
				<th>marksObtained</th>
				<th>email</th>
				<th>goals</th>
				<th>status</th>
				<th>dateOfInterview</th>
			</tr>
			<c:forEach items="${appList}" var="appli">
				<form:form action="viewApplicants.htm" method="post"
					modelAttribute="Application">
					<tr>
						<td><form:hidden path="applicationId"
								value="${appli.applicationId}" /> ${appli.applicationId}</td>
						<td><form:hidden path="fullName" value="${appli.fullName}" />${appli.fullName}</td>
						<td><form:hidden path="dateOfBirth"
								value="${appli.dateOfBirth}" />${appli.dateOfBirth}</td>
						<td><form:hidden path="highestQualification"
								value="${appli.highestQualification}" />${appli.highestQualification}</td>
						<td><form:hidden path="marksObtained"
								value="${appli.marksObtained}" />${appli.marksObtained}</td>
						<td><form:hidden path="email" value="${appli.email}" />${appli.email}</td>
						<td><form:hidden path="goals" value="${appli.goals}" />${appli.goals}</td>
						<td><form:hidden path="scheduledProgramId"
								value="${appli.scheduledProgramId}" />${appli.scheduledProgramId}</td>
						<td><form:hidden path="status" value="${appli.status}" />${appli.status}</td>
						<td><form:hidden path="dateOfInterview"
								value="${appli.dateOfInterview}" />${appli.dateOfInterview}</td>
						<td><input type="submit" value="Schedule Interview"></td>
					</tr>
				</form:form>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>