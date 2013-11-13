#Maintain Context Use Case#

<TABLE>
<TR><TD>Document Type</TD><TD>Use case</TD></TR>
<TR><TD>Activity</TD><TD>Analysis</TD></TR>
<TR><TD>Document Version</TD><TD>1.0</TD></TR>
<TR><TD>Document Status</TD><TD>Draft</TD></TR>
</TABLE>

<TABLE>
<TR><TH>Date</TH><TH>Version</TH><TH>Description</TH><TH>Author</TH></TR>
<TR><TD>10.22.2013</TD><TD>1.0</TD><TD>Initial draft</TD><TD>Seth Lee</TD></TR>
<TR><TD>11.6.2013</TD><TD>1.1</TD><TD>Updated for disabled context functionality.</TD><TD>Seth Lee</TD></TR>
</TABLE>

##Brief Description##

This use case describes how the policy manager maintains context information in the application.

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

There is at least one enabled Context associated with a Project to be maintained.


##Basic Flow of Events##

1. The policy manager is directed to the application welcome page, which displays a list of the 
projects that have been defined in the application in the Project tab (default).  Contexts appear
as either enabled or disabled.

2.  The policy manager clicks the 'Context' tab to display a list of existing enabled contexts.

3.  The policy manager highlights the Context he or she is maintaining and clicks the 'Maintain Context' 
button to maintain an existing context.  

4.  The policy manager is presented with an entry screen that displays the details for the Context
being maintained.  

5.  The policy manager modifies the context information:

5.1  The policy manager modifies the context name, description, other other context details as desired.    

5.2  The policy manager chooses the project with which the context will be associated.  

5.2.1	 The Project drop-down list defaults to the Project with which the context is currently associated.
The policy manager clicks the Project drop-down list and selects an **enabled** project.  
Only **enabled** projects are displayed in the list of projects to which the context may be 
assigned.

7.  The policy manager decides to save or abort the addition of the new context.

6.1  The policy manager clicks the 'Save' button to save the context modifications. The modified context 
information is updated in the database.

OR

6.2  The policy manager clicks the 'Cancel' button to abort saving the context modifications.  The updated
 context is not applied to the database. 

7.  The policy manager is taken back to the welcome page displaying the contexts in the 
Context tab.  The context and its attributes are visible on the welcome page (e.g. context name, etc.).

##Alternative Flows##


##Key Scenarios##


##Post-conditions##

###Successful Completion###

If the policy manager modified context information and subsequently saved the modified context, it appears in the 
context summary of the welcome page for the context that was modified.  Any changes to the context such as name or 
description that are visible in the welcome page Context tab are reflected in the summary.  The updated context
 information is saved to the database.  If the context modification included a change to the project with 
 which the context is associated, then users and policy managers see the context as a drop-down in the project
 screen for the newly associated project when uploading diagrams.

If the policy manager modified context information and subsequently chose to cancel the request in the maintain
context screen, the updated context information does not appear in the welcome page in the Context tab, 
nor is it saved in the database.

###Failure Condition###

No changes are made to the database or the welcome page in the Context tab.  


##Special Requirements##

