#Add Context Use Case#

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

This use case describes how the policy manager adds context information in the application.

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

2.  The policy manager clicks the 'Context' tab to display a list of existing contexts.

3.  The policy manager clicks the 'Add Context' button to add a new context.  

4.  The policy manager is presented with an entry screen that includes input fields for the
context detail.  

5.  The policy manager enters the context name, description, and other context details.    

6.  The policy manager chooses the project with which the context will be associated.  

6.1	 The policy manager clicks the Project drop-down list and selects an **enabled** project.  
Only **enabled** projects are displayed in the list of projects to which the context may be 
assigned.

7.  The policy manager decides to save or abort the addition of the new context.

6.1  The policy manager clicks the 'Save' button to save the context. The new context is added to the 
database.

OR

6.2  The policy manager clicks the 'Cancel' button to abort saving the context.  The new context is not 
added to the database. 

7.  The policy manager is taken back to the welcome page displaying the contexts in the 
Context tab.  The new context and its attributes are visible on the welcome page (e.g. context name, etc.).

##Alternative Flows##


##Key Scenarios##


##Post-conditions##

###Successful Completion###

If the policy manager added a context and subsequently saved the new context, it appears in the 
context summary of the welcome page for the context that was added.  The new context is saved 
to the database.  Users and policy managers may now choose the new context from the project 
screen as a drop-down option when they upload new diagrams.

If the policy manager added a context and subsequently chose to cancel the request in the add
context screen, the new context does not appear in the welcome page in the Context, nor is it saved in the database.
Users and policy managers do not see the context listed in the project screen as a drop-down option
when uploading new diagrams.


###Failure Condition###

No changes are made to the database or the welcome page in the Context tab.  The new context is not available
in the project screen as a drop-down option when users or policy managers upload new diagrams.


##Special Requirements##

