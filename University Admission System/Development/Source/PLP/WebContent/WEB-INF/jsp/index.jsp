s<%--  
 ***************************************************************************************
 * Description  :   Home page of the application
 * Functionality: It is a jsp page which display the various option for different users 
 				 .Applicant does not need to login where as Member of admission committee
 				 and administrator needs to login.
 * 
 * Models Used : 
 * Restrictions: 
 * Creation date: (09/11/2017)
 * Modifications:
 * Author: Group5       Date: 14-Nov-2017         Change Description:
 ************************************************************************************** --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js">
	
</script>
<script src="js/jquery-3.2.1.min.js">
	
</script>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="index.jsp">University Admission
					System</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="index.jsp">Home</a></li>
				<li><a href="viewprgrms.htm">View Programmes</a></li>
				<li><a href="apply.htm?pId">Apply Here</a></li>
				<li><a href="viewstatus.htm">View Status</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="login.htm"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
		</div>
	</nav>

	<div class="container" align="center">
		<h1>Welcome to Central University</h1>
		<img src="images/bckgrnd.jpg" class="img-rounded" alt="Cinque Terre"
			width="900" height="400" />
		<hr />
		<p style="width: 80%;">The Central University is a autonomous
			public institute of higher education, located in India. It is
			governed by the National Institutes of Technology Act, 2007, which
			declared it as institute of national importance alongside Indian
			Institutes of Technology and National Institute of Technology. These
			institutes of national importance receive special recognition from
			the Government of India. The NIT Council is the supreme governing
			body of India's National Institutes of Technology (NIT) system and
			all 31 NITs are funded by the Government of India. These institutes
			are among the top ranked engineering colleges in India and have one
			of the lowest acceptance rates for engineering institutes, of around
			2 to 3 percent, second only to the Indian Institutes of Technology
			(IITs) in India. All NITs are autonomous which enables them to set up
			their own curriculum. Central University offers degree courses at
			bachelors and masters levels in various branches of engineering and
			management. Admission to the under-graduate courses such as Bachelor
			of Technology (B.Tech.) in the university is through the highly
			competitive Joint Entrance Examination (Main). Admission to
			postgraduate courses are through the Graduate Aptitude Test in
			Engineering for Master of Technology (M.Tech.) program and Common
			Admission Test for Master of Business Administration (MBA) program.</p>
	</div>
</body>
</html>
