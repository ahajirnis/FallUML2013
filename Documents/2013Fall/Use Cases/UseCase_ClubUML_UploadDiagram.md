#Upload Diagram Use Case for ClubUML#

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
<TR><TD>10.23.2013</TD><TD>1.2</TD><TD>Updated for soft delete functionality.</TD><TD>Seth Lee</TD></TR>
<TR><TD>11.5.2013</TD><TD>1.3</TD><TD>Updated for disabled context functionality.</TD><TD>Seth Lee</TD></TR>
</TABLE>

##Brief Description##

This use case describes how a user uses ClubUML to upload a UML diagram encoded in Ecore data
model

##Actors##

1. User
2. Database Server
3. File System on Server

##Preconditions##

1. The user is logged in to ClubUML.
2. The user has a UML diagram encoded in Ecore or Papyrus to upload.
3. The user has selected a project from the welcome page that is enabled.
4. At least one enabled Context has been defined for the Project in which the user is working.
 
##The Basic Flow of Events##

1. The use case begins when the user selects “Upload” button
2. ClubUML displays a dialog box for the user to browse for a file.
3. The user browses and selects a file.
4. The user selects a Context from the Context drop-down box for the diagram.  Only enabled
   contexts will be displayed in the drop-down list.

5. ClubUML uploads the file to the File System on Server from the user’s computer and renames the
file by using “userId_timeStamp_originalFileName”.

6. ClubUML sends full path to the Database Server.

7. ClubUML creates an image of the UML diagram through internal parser. If successful, the image
is stored off to File System on Server, the image path is send to the Database Server.  Context
information for the diagram is also stored in the database.

8. ClubUML displays the “project page” to the user with the new created image for visual verification
by the user.  The newly uploaded diagram appears in the list of uploaded diagrams, along with 
the Context of the diagram.

9. The use case ends successfully.

##Alternative Flows##

### No UML File###

If in step 3 of the basic flow the user does not have a UML file:

1. The user selects “CANCEL” on the page to browse for a file.
2. ClubUML brings the user back to the project page (the page the user was on when he selected
“Upload” button
3. The use case ends in a failed condition.

### User does not select a Context drop-down###

ClubUML issues an error message indicating that the user must select a Context for the diagram
prior to uploading it.

### User selects a disabled project from the welcome page ###

The user is presented with the list of diagrams that have been previously uploaded in 
read-only mode.  The user is unable to upload diagrams, compare diagrams, etc.

###Wrong file extension###

If in step 3 of the basic flow the user chooses a file that does not have the correct extension, then

1. ClubUML indicates an error and reminds the user of the correct file extension.
2. The user clicks on “OK”
3. The use case resumes at step 2 of the basic use case.

###File is not able to be converted to a .PNG file###

If after step 6, the file is not able to be converted to a .PNG file, then

1. The user is prompted that the file is unable to be displayed, and is told that the ecore file cannot
be saved.
2. The “ecore” file is removed from the database and does not show up on the list of files. However
the history of this user trying to upload a file that is rejected is saved.
3. The use case resumes at step 2.

###No Response from Server###

If in step 6 of the basic there is no response from the server within 3 seconds, then

1. ClubUML will re-try, up to three times.
2. If there is still no response from the server ClubUML shall display the message "Network
unavailable – try again later".

3. The use case ends with a failure condition.

##Key Scenarios##

The basic flow of events

##Post-conditions##

###Successful Completion###

An UML diagram encoded in Ecore file and an image of the UML diagram have been stored to
ClubUML’s File System and paths are stored in Database Server.

###Failure Condition###

No file has been uploaded.

##Special Requirements##

ClubUML shall keep a history of all files that have been uploaded and processing results.