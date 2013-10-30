#Add Project Use Case#

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

This use case describes how the policy manager adds project information in the application.

##Actors##

Policy Manager : The policy manager is the actor who maintains project, context and policy 
information in the application.  The policy manager is a special type of user identified
by the application by a policy manager role, not a typical user role.

User: The user is the actor who is assigned to a project(s), who may upload diagrams to a project,
compare diagrams or merge diagrams in a project.  Users may upload diagrams, etc. to a project
to which they are assigned, but not to projects to which they are not assigned.  Users may 
only upload diagrams, etc. to an enabled project.

##Preconditions##

The policy manager has successfully logged in to the application.

The policy manager has the appropriate user role designation in the database.


##Basic Flow of Events##

1. The policy manager is directed to the application welcome page, which displays a list of the 
projects that have been defined in the application in the Project tab (default).  

2.  The policy manager clicks the 'Add Project' button to add a new project.  

3.  The policy manager is presented with an entry screen that includes input fields for the
project detail.  

4.  The policy manager enters the project name, description, and other project details.    

5.  The policy manager chooses the project's enabled status.

5.1 The policy manager chooses the 'Enabled' option if the project is immediately enabled, allowing
users to add diagrams to the project.

OR 

5.2 The policy manager chooses the 'Disabled' option if the project is being added but is not 
being enabled to allow users to upload diagrams to the project.

6.  The policy manager decides to save or abort the addition of the new project.

6.1  The policy manager clicks the 'Save' button to save the project. The new project is added to the 
database.

OR

6.2  The policy manager clicks the 'Cancel' button to abort saving the project.  The new project is not 
added to the database. 

7.  The policy manager is taken back to the welcome page displaying the projects in the 
Project tab.  The new project and its attributes are visible on the welcome page (e.g. project name, etc.).

##Alternative Flows##


##Key Scenarios##


##Post-conditions##

###Successful Completion###

If the policy manager added a project and subsequently saved the new project, it appears in the 
project summary of the welcome page for the project that was added.  The new project is saved 
to the database.  Users and policy managers may now choose the new project from the welcome page
to upload diagrams, merge diagrams, etc.

If the policy manager added a project and subsequently chose to cancel the request in the add
project screen, the new project does not appear in the welcome page, nor is it saved in the database.


###Failure Condition###

No changes are made to the database or the welcome page.


##Special Requirements##

