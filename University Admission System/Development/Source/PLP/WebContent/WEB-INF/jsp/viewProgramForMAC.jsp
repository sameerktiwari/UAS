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
	<h2>Program Scheduled for the Winter Session</h2>
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
					<td><input type="submit" value="View Applications"></td>
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
	<div id="footer">
		<a href="index.jsp">Home</a>
	</div>
</body>
</html>