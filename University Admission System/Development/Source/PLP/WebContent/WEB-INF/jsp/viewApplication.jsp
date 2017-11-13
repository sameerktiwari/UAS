<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application ${applicant.applicationId}</title>
<script><%@include file="/WEB-INF/js/validateDate.js" %></script>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<h1>University Admission System - Application ${applicant.applicationId}</h1>
	<table  align="center">
		<tr>
			<th>Application ID</th>
			<th>Full Name</th>
			<th>Date of Birth</th>
			<th>Highest Qualification</th>
			<th>Marks Obtained</th>
			<th>Email</th>
			<th>Goals</th>
			<th>Scheduled Programme ID</th>
			<th>Status</th>
			<th>Date of Interview</th>
		</tr>
				<tr>
					<td>${applicant.applicationId}</td>
					<td>${applicant.fullName}</td>
					<td>${applicant.dateOfBirth}</td>
					<td>${applicant.highestQualification}</td>
					<td>${applicant.marksObtained}</td>
					<td>${applicant.email}</td>
					<td>${applicant.goals}</td>
					<td>${applicant.scheduledProgramId}</td>
					<td>${applicant.status}</td>
					<td>${applicant.dateOfInterview}</td>
				</tr>
				</table>
	<a href="updateStatus.htm?appId=${applicant.applicationId}&status=Accepted"><input type="button" value="Accept" style="background-color:blue;color:white"></a>
	<a href="updateStatus.htm?appId=${applicant.applicationId}&status=Rejected"><input type="button" value="Reject" style="background-color:green;color:white"></a>
	<a href="updateStatus.htm?appId=${applicant.applicationId}&status=Confirmed"><input type="button" value="Confirm" style="background-color:red;color:white"></a>
	<c:if test="${msg ne null}">"${msg}"</c:if>
	<c:if test="${showDOI ne null}"><form:form action="setInterview.htm" modelAttribute="Application" method="post">
	<form:hidden path="applicationId"
							value="${applicant.applicationId}" />
					<form:hidden path="fullName" value="${applicant.fullName}" />
					<form:hidden path="dateOfBirth"
							value="${applicant.dateOfBirth}" />
					<form:hidden path="highestQualification"
							value="${applicant.highestQualification}" />
					<form:hidden path="marksObtained"
							value="${applicant.marksObtained}" />
					<form:hidden path="email" value="${applicant.email}" />
					<form:hidden path="goals" value="${applicant.goals}" />
					<form:hidden path="scheduledProgramId"
							value="${applicant.scheduledProgramId}" />
					<form:hidden path="status" value="${applicant.status}" />
	<p>Enter Date of Interview: <form:input  id="dateOfInterview" path="dateOfInterview"/><input type="submit" value="Schedule Interview" onclick="return isAfter()"><form:errors path="dateOfInterview"/></p>
	</form:form></c:if>
<div id="footer">
		<a href="index.jsp">Home</a>
	</div>
</body>
</html>