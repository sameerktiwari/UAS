# University Admission System
This project is aimed at developing a University Admission System Application for admissions. This is a web based application that can be accessed over the web. This system can be used for applying to programs scheduled and enroll a student for a program scheduled. This is an integrated system that contains three user components-
1.  Adminstrator
2.  Member of Admission Committee (MAC) 
3.  Applicant 

#FUNCTIONAL COMPONENTS OF THE PROJECT

Following is a list of functionalities of the system. 
There are three categories of people who would access the system viz. applicants, members of admission committee (mac) and administrators. Each one of them would have some exclusive privileges (for e.g. Applicants can apply for a program by filling up the form without any login process, members of admission committee alone will be able to view applicant details and filter the applicants for a specific program they have applied for and only the administrator has the right to keep track of the university’s program details.)

1.	Applicant is able to 

•	View all programs scheduled by the university
•	Apply for a scheduled program of the university, by filling up the application details that auto generates the application ID
•	View the application status, based on the application ID

2.	The member of admission committee (mac)is able to :

•	Login into the system using his/her credentials.
•	View applications for a specific program.
•	Accept/Reject an application on the basis of the details of the applicant. If accepted, fill in the scheduled date for an interview of the applicant before confirming the applicant to take the program. 
•	After the interview, update the status of the application to Confirmed/Rejected

3.	The administration is able to

•	login to the system using his/her credentials 
•	Update and manage (add or delete) information of the programs offer by the university
•	Manage (add or delete) schedules of the programs offered by the university
•	Generate various reports like:
	View List of applicants confirmed/ accepted (waiting for interview)/rejected for a scheduled program.
	View list of programs scheduled to commence in a give time period

Transition of Status: Applied ->Accepted/Rejected->Confirmed/Rejected