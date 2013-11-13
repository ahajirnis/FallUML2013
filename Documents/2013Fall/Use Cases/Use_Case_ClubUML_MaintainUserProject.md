#Maintain Project Users Use Case#

<TABLE>
<TR><TD>Document Type</TD><TD>Use case</TD></TR>
<TR><TD>Activity</TD><TD>Analysis</TD></TR>
<TR><TD>Document Version</TD><TD>1.0</TD></TR>
<TR><TD>Document Status</TD><TD>Draft</TD></TR>
</TABLE>

<TABLE>
<TR><TH>Date</TH><TH>Version</TH><TH>Description</TH><TH>Author</TH></TR>
<TR><TD>11.5.2013</TD><TD>1.0</TD><TD>Initial draft</TD><TD>Seth Lee</TD></TR>
</TABLE>

##Brief Description##

This use case describes how the policy manager maintains users associated with projects 
in the application.  Users associated with a project will see the project listed on the 
welcome page, where they can proceed to the project to upload diagrams, compare diagrams,
etc.

Once a user is removed from a project, he or she is no longer able to access that project
in the application.  Please note, however, that any diagrams, comments, etc. that are 
associated with the user in the project remain in the database.

##Actors##

Policy Manager : The policy manager is the actor who maintains project, context, policy and 
project user information in the application.  The policy manager is a special type of user
 identified by the application by a policy manager role, not a typical user role.

User: The user is the actor who is assigned to a project(s), who may upload diagrams to a project,
compare diagrams or merge diagrams in a project.  Users may upload diagrams, etc. to a project
to which they are assigned, but not to projects to which they are not assigned.  Users may 
only upload diagrams, etc. to an enabled project.

##Preconditions##

The policy manager has successfully logged in to the application.

The policy manager has the appropriate user role designation in the database.

At least one user exists in the application.


##Basic Flow of Events##

1. The policy manager is directed to the application welcome page, which displays a list of the 
projects that have been defined in the application in the Project tab (default).  

2.  The policy manager identifies the project for which he or she wishes to maintain user 
associations. The policy manager clicks the 'Maintain Users' link for that project.

3.  The policy manager is directed to the project user maintenance screen.  A list of users
that have been assigned to the project is displayed.  

4.  The policy manager identifies users to be added to or removed from the project:

*  		The policy manager removes existing project users:

**			The policy manager clicks the 'Remove' link for the user to be removed.  
**			The policy manager is presented with a confirmation dialogue to confirm the 
		    changes.

***  			The policy manager clicks 'Ok' to save the changes.
****				The user is removed from the list of users associated with the project.  The
					database is updated to mark the project user association as disabled if
					any diagram or comment associations exist for the user in the project.  
					The database is updated to delete the project user assocation if no 
					diagram or comment associations exist for the user in the project. 

***				The policy manager clicks 'Cancel' to cancel the changes.
****				The user is not removed from the list of users associated with the project.
					No updates are performed in the database.

*   	The policy manager adds project users:

**			The policy manager clicks the 'Add User' link.
**			The policy manager is presented with a list of registered users that are not
			already associated with the project.
			
**			The policy manager chooses the appropriate user and clicks 'OK':

***				The user is added to the list of users associated with the project.  
				The database is updated to associate the user with the project.

**			The policy manager does not choose a user and clicks 'Cancel' to cancel any changes:

***				The user is not added to the list of users associated with the project.  
				No database updated are performed.
				
The policy manager repeats step 4 as needed to add or remove users from the project.


5.  The policy manager is taken back to the welcome page displaying the projects in the 
Project tab.  

##Alternative Flows##


##Key Scenarios##


##Post-conditions##

The list of users associated with the project is updated to reflect the policy manager's 
modifications.

Users that have been added by the policy manager are able to access the project from the 
welcome page in the application, and may upload diagrams, compare diagrams, etc. for the 
project.

Users that have been removed from a project are not able to access the project from the
welcome page in the application.

Diagrams, comments or other associations with the user in the project are retained in the 
database for the project.  


###Successful Completion###

The list of users associated with the project is updated to reflect any users that have 
been added to or removed from the project.  

The database is updated to add new associations between the project and any users that 
are added to the project. 

The database is updated to update associations between the project and any users that 
are removed from the project to mark the user as disabled in the project if the user has
uploaded diagrams or is associated with comments.  

The database is updated to delete associations between the project and any users that 
are removed from the project if the user is not associated with any diagrams or comments
for the project.


###Failure Condition###

No changes are made to the database.


##Special Requirements##

