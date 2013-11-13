#Maintain Project Use Case#

<TABLE>
<TR><TD>Document Type</TD><TD>Use case</TD></TR>
<TR><TD>Activity</TD><TD>Analysis</TD></TR>
<TR><TD>Document Version</TD><TD>1.0</TD></TR>
<TR><TD>Document Status</TD><TD>Draft</TD></TR>
</TABLE>

<TABLE>
<TR><TH>Date</TH><TH>Version</TH><TH>Description</TH><TH>Author</TH></TR>
<TR><TD>10.20.2013</TD><TD>1.0</TD><TD>Initial draft</TD><TD>Seth Lee</TD></TR>
</TABLE>

##Brief Description##

This use case describes how the policy manager maintains project information in the application.

##Actors##

Policy Manager : The policy manager is the actor who maintains project, context and policy 
information in the application.  The policy manager is a special type of user identified
by the application by a policy manager role, not a typical user role.

##Preconditions##

The policy manager has successfully logged in to the application.

The policy manager has the appropriate user role designation in the database.


##Basic Flow of Events##

1. The policy manager is directed to the application welcome page, which displays a list of the 
projects that have been defined in the application in the Project tab (default).  

2.  The policy manager highlights the project that he or she is maintaining and clicks the
'Maintain Project' button.  

3.  The policy manager is presented with a review screen that displays the project details for the 
project.  

4.  The policy manager edits the name or other project attributes.  

4.1  The policy manager edits the attributes of the project.  

OR

4.2  The policy manager disables an active project that is currently enabled.  

OR 

4.3  The policy manager enables a deactivated project that is currently disabled.

5.  The policy manager commits or aborts changes to the project.

5.1  The policy manager clicks 'Save' to save his or her changes.  

5.1.1  The changes are saved to the project table in the database.
OR  

5.2  The policy manager clicks 'Cancel' to cancel any changes to the project.

5.2.1  No changes are committed to the project table in the database.

6.  The policy manager is taken back to the welcome page displaying the projects in the 
Project tab.  Any changes that were made to project attributes that are visible in this screen
are now visible on the welcome page (e.g. project name, etc.).

##Alternative Flows##


##Key Scenarios##


##Post-conditions##

###Successful Completion###

If the policy manager made changes to a project and subsequently saved them, they appear in the 
project summary of the welcome page for the project that was maintained.  Any changes made to the 
project have also been applied in the database.

If the policy manager made changes to a project and subsequently chose to cancel the request in the 
project maintenance screen, the project appears in the welcome page as it was before the request, and 
no changes have been applied to the database.


###Failure Condition###

No changes are made to the database or the welcome page.


##Special Requirements##

