<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retrieve status of application</title>
</head>
<body>
	<div>

		<h1>Status</h1>

		<form action="getStatus.htm">
			<table border="2">
				<tr>
					<td>Please enter Application ID</td>
					<td><input type="text" name="appId" /></td>
				</tr>

				<tr>
					<td colspan="2" align="right"><input type="submit"
						value="Fetch" /></td>
				</tr>
			</table>
		</form>

		<c:if test="${appList ne null}">
			<h3>Application Info</h3>
			<table border="2">
				<tr>
					<th>Application Id</th>
					<th>Status</th>
					<th>full name</th>
					<th>dateOfBirth</th>
					<th>highestQualification</th>
					<th>marksObtained</th>
					<th>email</th>
					<th>goals</th>
					<th>scheduledProgramId</th>
					<th>DatteOfInterview</th>

				</tr>
				<c:forEach items="${appList}" var="appSheet">
					<tr>
						<td>${appSheet.applicationId}</td>
						<td>${appSheet.status}</td>
						<td>${appSheet.fullname}</td>
						<td>${appSheet.dateOfBirth}</td>
						<td>${appSheet.highestQualification}</td>
						<td>${appSheet.marksObtained}</td>
						<td>${appSheet.email}</td>
						<td>${appSheet.goals}</td>
						<td>${appSheet.scheduledProgramId}</td>
						<td>${appSheet.DatteOfInterview}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>