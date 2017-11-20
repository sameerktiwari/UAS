<%--  
 ***************************************************************************************
 * Description  :   View all Scheduled programs which for a particular programs
 * Functionality: It is a jsp page which will show the  list of all scheduled programs.
 *					this functionality should be accessible to administrator only. 
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
<title>Admin - Programs Scheduled</title>
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
			<th></th>
		</tr>

		<c:forEach items="${programs}" var="prog">
			<tr>
				<td>${prog.scheduledProgrammeId}</td>
				<td>${prog.programName}</td>
				<td>${prog.location}</td>
				<td>${prog.startDate}</td>
				<td>${prog.endDate}</td>
				<td>${prog.sessionsPerWeek}</td>
				<td><a href="updatePrgrm.htm?pId=${prog.scheduledProgrammeId}"><input
						class="btn btn-info" type="button" value="Update"></a></td>
				<td><a href="deletePrgrm.htm?pId=${prog.scheduledProgrammeId}"><input
						class="btn btn-warning" type="button" value="Delete"></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>