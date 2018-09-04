EGERTON UNIVERSITY
(NJORO CAMPUS)
 
PROJECT USERS MANUAL FOR
TITLE: STUDENT AUTOMATED ATTENDANCE SYSTEM

PREPARED BY: JACKSON KING’ORA WANGUI
REG NO: S13/21372/14


PROJECT SUPERVISOR: PROF. GITHEKO
PROJECT COORDINATOR: DR. GIKARU


DATES: 01/08/2018
VERSION: 001

 
Table of Contents
1.	GENERAL INFORMATION	3
1.1	System Overview	3
1.2	Organization of the Manual	3
1.2	Authorized Use Permission	4
1.3	Points of Contact	4
1.3.1	Information	4
2.	SYSTEM SUMMARY	4
2.1	System Configuration	4
2.2	User Access Levels	5
2.3 Contingencies and Alternate Modes of Operation	5
3.	GETTING STARTED	5
3.1	Installation	5
3.2	Extracting from the .ZIP archive	6
3.1.1	Install Application Component	6
3.1.2	Install XAMPP Database Service Component	6
3.3	Starting the Application	6
3.4	System Menu	6
4.	USING THE SYSTEM	7
4.1	Admin user interface	7
4.2	Lecturer user interface	11
4.3	Student user interface	14
5.	REPORTING	16
6.	REFERENCES	16


 
1.	GENERAL INFORMATION
General Information section explains in general terms the system and the purpose for which it is
intended.
1.1	System Overview

The Student Automated Attendance System desktop application is used in the process of taking attendance of students in Egerton University. It is used generate the attendance sheet based on the data collected. The users of the system are the admin, lecturers and students.
i.	Admin – The admin is the supreme authoritative character in the system. He/she manages the students and lecturers’ details. The admin therefore adds, updates and deletes students and lecturers’ data. Any searing issue regarding the attendance process is communicated to the admin. The admin is also able to view the reports and attendance progress as taken by the lecturers.
ii.	Lecturer – The lecturer is the main user of the system. Main tasks include taking the attendance and generating reports. The reports copycat the existing attendance registration forms. Lecturer can however authorize the trustworthy students’ representative to take or monitor the attendance on his/her behalf. The marking process is expected to be simplified in the easiest way possible.
iii.	Student – The student are the minor users of the system. They view their attendance progress from the units they are undertaking. From this perspective, the student can hence purpose to attend the unit lectures according to their accrued attendance percentage.
The application has been implemented in a one-tier service architecture. A Windows service, which executes search requests, communicates directly with a database service, which is the external façade which receives the external requests directly from variant processes.
The Student Automated Attendance application’s architecture and behavior can be broken up into two separate function-groups handling the application’s generation of tables from databases upon startup, and also the individual handling of single requests. These differences will be covered in more detail later in this document.
1.2	Organization of the Manual
The user’s manual consists of five sections: General Information, System Summary, Getting Started, Using The System, and Reporting. General Information section explains in general terms the system and the purpose for which it is intended. System Summary section provides a general overview of the system. The summary outlines the uses of the system’s hardware and software requirements, system’s configuration, user access levels and system’s behavior in case of any contingencies. Getting Started section explains how to get Student Attendance System and install it on the device. The section presents briefly system menu. Using The System section provides a detailed description of system functions. Reporting section describes in what way information collected by the application are presented and how to access the information.
1.2	Authorized Use Permission
Usage of this software is limited to its developer via the terms and condition of its development. Attendance system is wholly owned by Egerton Developer, and may not be used or referenced without his express consent.
1.3	Points of Contact
1.3.1	Information
For additional information, the developer can be contacted through Developer@gmail.com.
2.	SYSTEM SUMMARY
System Summary section provides a general overview of the system. The summary outlines the uses of the system’s hardware and software requirements, system’s configuration, user access levels and system’s behavior in case of any contingencies.
2.1	System Configuration
Student attendance system operates on windows operating system. It is compatible with version 7 and higher installed in a computer. The application does not require connection to the internet but for database updates it requires internet connection to the central database. After installation, the desktop application will require no further configurations.


Data flow diagram for the system configuration structurer.
The system is contained entirely within a single system (even a single computer) provided a fingerprint scanner is connected to the system as shown to the main application. Databases, or other data sources are used by the system during startup, and the Attendance system work to realize an effective process. However, due to hardware constraint, file manager was used to load database choices from various users.
2.2	User Access Levels
No distinct user access levels are defined since under normal circumstances all activities should be completely transparent to its users (Administrators, Lecturers and Students). Messages between the system and user will be communicated using dialogs. Users should use their respective authentication to access the system and its components. Authentication mechanism available is the use of passwords.
Developers and system maintainers using or modifying the application only require access to the configuration file to make simple replacements or tweaks to the running system’s functionality, or in the case of large involved modifications, a restart of the application is necessary and updates to all users made effectively.
			2.3 Contingencies and Alternate Modes of Operation
There is a significant time cost in building and loading large features updates into the system, so in the case of an emergency or failure requiring a reboot, the system will need to spend a significant amount of time (perhaps several minutes in the extreme case) assembling its resources before it can readily receive and process searches.  Once this loading phase of the application is complete, however, normal operations can resume.
There are no secondary modes of operation in this application.  It is either not running, building its resources in preparation for processing input, or actively waiting for an input.
On the hardware factor, updates will be made to make sure that the attendance process takes a hardware for faster and smooth attendance process. The University have suggested introduction of smart cards giving it an essence to incorporate the smart card hardware instead of fingerprint recognition.
In case of a power outage or system crash, the data will be saved but the lecturer attendance module will have to be updated on the same day. 
3.	GETTING STARTED
Getting Started section explains how to get Student Automated Attendance System and install it on the device. The section presents briefly system menu. Extracting, Installing, and Running Student Automated Attendance System
3.1	Installation
The newest installation version currently available can be downloaded from https://github.com/jackson001/Programming and is a folder, which should be installed on the device. For specific instruction on how to install application on specific device refer to this manual for more details.
3.2	Extracting from the .ZIP archive
In addition to user documentation, the System .ZIP file contains installers for the Windows based application and database aspects of the application.  Both must be executed before the system can be optimized and run.
3.1.1	Install Application Component
Install the system
3.1.1.1	Unzip the StudentAttendanceSystem.zip file to a convenient location (Documents recommended).
3.1.1.2	Run StudentAttendanceSystem.jar located in StudentAttendanceSystem\dist directory.
3.1.1.3	Alternatively, run using NetBeans IDE by importing the project.
3.1.2	Install XAMPP Database Service Component
Installs XAMPP Database version 7.0 or Higher.
3.1.2.1	Copy file named Attendant.sql from StudentAttendanceSystem folder to XAMPP MySQL directory.
3.1.2.2	Open the XAMMP control panel and import the database.
3.1.2.3	Ensure the database is root with no password.
3.3	Starting the Application
3.2.1	Double click on the StudentAttendanceSystem.jar.
3.2.2	Click the applications icon or search from the Cortana icon.
3.2.3	The home page appears.
3.2.4	Choose on your role and you are good to go.
3.2.5	See the user manual for the interface help.
		3.4	System Menu
The Students Attendance System Consists of six main menus. The functions are as listed:
i.	Home – The entry frame of the system and houses all menus and has three submenus on the side bar. The user’s submenu to show the users of the system, settings submenu to configure the applications settings and updates submenu to show the available updates of the system.
ii.	Student – This menu is used by students to get to their login module.
iii.	Lecturer – This menu is used by lecturers to navigate to their module. It acts as the entry point to the module shared by administrator and lecturers.
iv.	Settings – This shows the various configurations that can be made to the system.
v.	Admin – The menu to be used by the administrators of the system. Admin and lecturers share the same navigational process
vi.	Updates – This menu checks for the system updates online. Requires connection to the internet.
The basic functionalities are shown below. 
 
Figure 1. Home page after a successful installation of the application
3.5	Exit System
The desktop application’s frame provides an icon that looks like a cross on the top right corner which can be used to perform a system exit. Alternatively, a user can press a white cross sign icon on the top right corner of the frame.
4.	USING THE SYSTEM
This section provides a detailed description of system functions.
		4.1	Admin user interface

The admin enters the correct username and password in the login page. Otherwise, an error message will appear as a message dialog. Once the admin enters the correct username, password and role combination, message dialog prompts on the frame as shown below.
 
Figure 2: Admin Login Page. Note the User Type (Role) is selected as the Administrator

Administrator is then directed to the homepage below.
 
Figure 3: The admin homepage. Various roles are available. Note the blue menu above the frame.

i.	Home
The current frame.
ii.	Students
Manages (Add, delete and update) student details.
 
Figure 4: Manage students’ details frame. The admin adds the fingerprint from the file manager.
iii.	Lecturers
Manages (Add, deletes and updates) lecturers’ details.
 
Figure 5: Manage lecturer’s details.
iv.	Profile
Manages admin’s profile.
 
Figure 6: Manage admins profile.
v.	Delete student and delete lecturer panel deletes students or lecturer one after the other.
 
Figure 7: Delete student details:
 
Figure 8: Delete lecturer details. Use their login username please.
iv.	Logout button
 
Figure 9: Logout dialog to exit the admin frame and return to the login page shown by Figure 1.
		4.2	Lecturer user interface
The lecturer enters the correct username and password in the login page. Otherwise, an error message will appear as a message dialog. Once the lecturer enters the correct username, password and role combination, message dialog prompts on the frame as shown below.
 
Figure 10: Lecturer login page. Note the User Type (Role) selected is lecturer.
i.	Home
After the lecturer successfully logins in the system, the following frame is displayed.
 
Figure 11: Lecturer home page. Note the blue menu on top. The main functionalities are take attendance and generate report.
ii.	Add class
The second menu item provides the capabilities of adding a class. Ensure the lecturer gives the correct details since the user will not repeat this step in the course of semester.
 
Figure 12: Add class to take attendance and generate report.
iii.	Take attendance
The main function of the application. The lecturer takes attendance by loading fingerprint from file manager or using check boxes. Alternatively, you can manually enter the registration number at the Registration No: text field.
 
Figure 13: Attendance module.
iv.	Generate Report.
This module generates reports in form of attendance sheet. Printing can be in terms of complete or not complete. The following prints the complete students’ registration form.
 
Figure 14: Registration form for students above 75 %. 
v.	Logout button
Enables the lecturer to sign off the system.
 
Figure 15: Logging out to return to the login page.
		4.3	Student user interface
The student is the minor user meaning that the students have a few functionalities. This user interface is also different from that of the admin and lecturers. The student uses username and password the students’ module. The username is the student’s registration number.
 
Figure 16: Students login page.
i.	Home
After a successful login, the following page is displayed.
 
Figure 17: Students’ home page.
ii.	View attendance
This button queries the attendance of the student for a particular subject displayed on the combo box named Subject Id.
 
Figure 18: Attendance information displayed for a particular subject.
iii.	Add profile
Displays the students profile.
 
Figure 19: Displays the profile of the student.
5.	REPORTING
Reporting section describes in what way information collected by the application are presented and how to access the information.
All the report generated from the activities of the application and any data queries will be sent directly to the developer or admin.
The other form of report will be printed by the lecturers or the admin. This will be in the form of an attendance registration form. The process will require a printer.

6.	REFERENCES
Sharma, S. (2018, August 24). Software Systems Manual. Retrieved from Software Systems Manual: https://www.projectmanagement.com/deliverables/60297/Software-Systems-Manual
Team AZP, D. (2018, August 24). TCN Spell Cheker User Manual. TCN Spell Cheker User Manual, pp. 1-12.
Wikipedia. (2018, August 24). User Guide. Retrieved from Wikipedia: https://en.wikipedia.org/wiki/User_guide

