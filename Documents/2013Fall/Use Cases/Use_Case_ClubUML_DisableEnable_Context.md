#Enable or Disable Context Use Case#

<TABLE>
<TR><TD>Document Type</TD><TD>Use case</TD></TR>
<TR><TD>Activity</TD><TD>Analysis</TD></TR>
<TR><TD>Document Version</TD><TD>1.0</TD></TR>
<TR><TD>Document Status</TD><TD>Draft</TD></TR>
</TABLE>

<TABLE>
<TR><TH>Date</TH><TH>Version</TH><TH>Description</TH><TH>Author</TH></TR>
<TR><TD>11.4.2013</TD><TD>1.0</TD><TD>Initial draft</TD><TD>Seth Lee</TD></TR>
</TABLE>

##Brief Description##

This use case describes how the policy manager enables disabled contexts in the application,
or disables enabled contexts in the application.

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

There is at least one Context associated with a Project to be enabled or disabled.


##Basic Flow of Events##

1. The policy manager is directed to the application welcome page, which displays a list of the 
projects that have been defined in the application in the Project tab (default).  Contexts appear
as either enabled or disabled.  Enabled Contexts appear in the enabled Contexts (upper) portion of the 
screen.  Disabled Contexts appear in the disabled Context (lower) portion of the screen.

2.  The policy manager clicks the 'Context' tab to display a list of existing contexts.

3.  The policy manager chooses an enabled Context to disable, or a disabled Context to enable:

3.1	The policy manager selects an enabled Context to disable:

3.1.1 	The policy manager clicks the 'Disable' link on the row containing the desired Context:

*	If there are no Diagrams associated with the Context, the Context is marked as disabled 
	in the database.  
*	If there are Diagrams associated with the Context, the Context cannot be disabled.  The
	policy manager receives an error message from the application indicating that the 
	Context cannot be disabled because there are Diagrams associated with the Context.
	
3.1.2	The policy manager clicks the 'Enable' link on the row containing the desired Context:

*	The Context is marked as enabled in the database.

4.  The Context shows as either enabled or disabled in the Context panel.  If the Context 
was enabled, it appears in the upper portion of the screen in the enabled Contexts list.  If the 
Context was disabled (successfully), it appears in the lower portion of the screen in the 
disabled Contexts list.

##Alternative Flows##


##Key Scenarios##


##Post-conditions##

###Successful Completion###

If the Policy Manager disabled an enabled Context and there are no Diagrams associated with the
Context, then the Context appears in the lower portion of the Context panel in the 
disabled Contexts list.  The database is updated for the Context to reflect that it has
been disabled.

If the Policy Manager enabled a disabled Context, it appears in the upper portion of the 
Context panel in the enabled Contexts list.  The database is updated for the Context to reflect
that it has been enabled.

###Failure Condition###

No changes are made to the database or the welcome page in the Context tab.  


##Special Requirements##

