#Display Diagram Use Case#

<TABLE>
<TR><TD>Document Type</TD><TD>Use case</TD></TR>
<TR><TD>Activity</TD><TD>Analysis</TD></TR>
<TR><TD>Document Version</TD><TD>1.1</TD></TR>
<TR><TD>Document Status</TD><TD>Draft</TD></TR>
</TABLE>

<TABLE>
<TR><TH>Date</TH><TH>Version</TH><TH>Description</TH><TH>Author</TH></TR>
<TR><TD>Spring 2013</TD><TD>1.0</TD><TD>Initial draft</TD><TD>Spring 2013 Team</TD></TR>
<TR><TD>10.14.2013</TD><TD>1.1</TD><TD>Updated for Context functionality.</TD><TD>Seth Lee</TD></TR>
</TABLE>

##Brief Description##

This use case describes how the application display diagrams to the user.

##Actors##

1 User : The user is the actor who reviews previously uploaded UML diagrams to be displayed.

##Preconditions##

The user has successfully logged in to the application.

The user is assigned to at least one project.

The project must contain at least one diagram.

##Basic Flow of Events##

1. The app shows a 'Diagram List'.  Along with the name of the diagrams that are available for display,
each diagram will include the identifier of the Context with which the diagram is associated.	
	
2. The user clicks one diagram from that list.
3. The app retrieves the path of png. file related to this diagram from Database.
4. The app finds the file on server according to the path.
5. The app displays the Diagram to the user.
6. The use case ends in successful completion.

##Alternative Flows##

###No diagram assigned to the project###

During 4.2, if the project has no diagrams, then

1. The user will see an empty 'Diagram List'.
2. The app prompts the user to upload a diagram first.
3. The use case will end in failure condition.

###The app fails to display the selected diagram###

If in basic step 5, the app fails to display the selected diagram:

1. The user refreshes the webpage or selects another diagram.
2. If the problem remains, the use case will end in failure condition and the user
would start over the procedure.

##Key Scenarios##

###No Response from the app###

##Post-conditions##

###Successful Completion###

The user sees the selected diagram.

###Failure Condition###

The app fails to display the diagram.

##Special Requirements##

If the selected diagram has comments, the app should display comments as well.

The app should also display the information of the version and uploaded time.