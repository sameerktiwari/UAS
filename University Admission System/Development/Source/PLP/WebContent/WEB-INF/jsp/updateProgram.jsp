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
</head>
<body>
<h1>University Admission System - Programs Updation</h1>
		<form:form action="update.htm"
				method="post" modelAttribute="programsScheduled">

<table align="center">

<tr><td>Program Id</td><td><form:input path="scheduledProgrammeId"
							value="${prog.scheduledProgrammeId}" /></td></tr>
			<tr><td>Program Name</td><td><form:input path="programName"value="${prog.programName}" /></td></tr>
			<tr><td>Location</td><td><form:input path="location"value="${prog.location}" /></td></tr>
			<tr><td>Start Date</td><td><form:input path="startDate" value="${prog.startDate}" /></td></tr>
			<tr><td>End date</td><td><form:input path="endDate" value="${prog.endDate}" /></td></tr>
			<tr><td>Session Per week</td><td><form:input path="sessionsPerWeek"value="${prog.sessionsPerWeek}"/></td></tr>
			<tr><td colspan="2"><input type="submit" value="update"/></td></tr>
					</table>
			</form:form>

</body>
</html>