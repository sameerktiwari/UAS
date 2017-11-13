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
</head>
<body>
	<h1>University Admission System - Programmes Scheduled</h1>
	<h2>Programmes Scheduled for the Winter Session</h2>
	<table align="center">
		<tr>
			<th>Program Id</th>
			<th>Program Name</th>
			<th>Location</th>
			<th>Start Date</th>
			<th>End date</th>
			<th>Session Per week</th>
			<th></th>
		</tr>

		<c:forEach items="${programList}" var="prog">

			<form:form action="apply.htm?pId=${prog.scheduledProgrammeId}"
				method="post" modelAttribute="ProgramsScheduled">

				<tr>
					<td><form:hidden path="scheduledProgrammeId"
							value="${prog.scheduledProgrammeId}" />
						${prog.scheduledProgrammeId}</td>
					<td><form:hidden path="programName"
							value="${prog.programName}" /><a
						href="programDetails.htm?pName=${prog.programName}&pId=${prog.scheduledProgrammeId}" style="color:green;text-decoration: underline;">${prog.programName}</a></td>
					<td><form:hidden path="location" value="${prog.location}" />${prog.location}</td>
					<td><form:hidden path="startDate" value="${prog.startDate}" />${prog.startDate}</td>
					<td><form:hidden path="endDate" value="${prog.endDate}" />${prog.endDate}</td>
					<td><form:hidden path="sessionsPerWeek"
							value="${prog.sessionsPerWeek}" />${prog.sessionsPerWeek}</td>
					<td><input type="submit" value="Apply"></td>
				</tr>
			</form:form>
		</c:forEach>

	</table>
	<div id="footer">
		<a href="index.jsp">Home</a>
	</div>
	
</body>
</html>