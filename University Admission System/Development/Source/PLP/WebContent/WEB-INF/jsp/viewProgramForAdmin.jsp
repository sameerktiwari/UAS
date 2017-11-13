<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin - Programs Scheduled</title>
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
			<th></th>
		</tr>

		<c:forEach items="${programList}" var="prog">
				<tr>
					<td>${prog.scheduledProgrammeId}</td>
					<td>${prog.programName}</td>
					<td>${prog.location}</td>
					<td>${prog.startDate}</td>
					<td>${prog.endDate}</td>
					<td>${prog.sessionsPerWeek}</td>
					<td><a href="updatePrgrm.htm?pId=${prog.scheduledProgrammeId}"><input type="button" value="Update" style="background-color:blue;color:white"></a></td>
					<td><a href="deletePrgrm.htm?pId=${prog.scheduledProgrammeId}"><input type="button" value="Delete" style="background-color:blue;color:white"></a></td>
				</tr>
		</c:forEach>
	</table>
<div id="footer">
		<a href="index.jsp">Home</a>
</div>	
</body>
</html>