#Use Case - ClubUMLv3 – Compare Diagram #

<TABLE>
<TR><TD>Document Type</TD><TD>Use case</TD></TR>
<TR><TD>Activity</TD><TD>Analysis</TD></TR>
<TR><TD>Document Version</TD><TD>3.2</TD></TR>
<TR><TD>Document Status</TD><TD>Draft</TD></TR>
</TABLE>

<TABLE>
<TR><TH>Version history</TH><TH>Date</TH><TH>Version</TH><TH>Description</TH><TH>Author</TH></TR>
<TR><TD>09.17.2013</TD><TD>3.0</TD><TD>Copied over from Spring2013</TD><TD>ClubUml</TD></TR>
<TR><TD>09.18.2013</TD><TD>3.1</TD><TD>Amended to have user choose between ClubUML
recommendation promotion or manual and accommodate only manual compare.</TD><TD>Seth</TD></TR>
<TR><TD>09.24.2013</TD><TD>3.2</TD><TD>Updated to accommodate both manual and auto promotion
 in one Use Case</TD><TD>Gautam</TD></TR>
<TR><TD>10.7.2013</TD><TD>3.3</TD><TD>Updated to include Context functionality</TD><TD>Seth</TD></TR>
<TR><TD>10.23.2013</TD><TD>3.4</TD><TD>Updated to include Project soft delete functionality.</TD><TD>Seth</TD></TR>
</TABLE>

##Brief Description##

This use case portrays the comparison of two diagrams selected by the user, with support for comments to aid in collaboration.

##Actors##

User: The user is the actor who invokes the comparison and reviews the report.

##Preconditions##

1.	The user follows Login use case flow to access ClubUML.
2.	The user has already uploaded two valid diagrams of the same type (following UploadDiagram flow of events), and also of the same Context.
3.  The user has selected a project from the welcome page that is enabled.

##Flow of events##

1.	The user follows Login use case flow to access ClubUML.
2.	The user selects two diagrams from the list of diagrams in the project, which are the same type as well as Context, and have been output by the same piece of software to ensure compatibility.
3.	The user clicks “Go to Compare” button for the selected diagram of the same type.
4.	ClubUML generates a detailed comparison report in a display panel within the web page including the Smart/Policy Scores of each diagram. 
5.	If the User clicks the ‘Suggest Promote’ button to allow ClubUML to use smart policy to identify which diagram to promote, ClubUML highlights the diagram that is suggested and the display panel indicates why the recommendation was made including the refactoring score of each diagram. 
6.	The user has the option to click the “save” button to download a PDF report of the comparison including the details of the ClubUML recommendation if it was invoked.
7.	 The user decides which diagram is preferred and adds a comment under the preferred diagram.
8.	The user then clicks the Promote button next to the comment box.
9.	The user is returned to the main ClubUML page and the comment can be seen under the promoted diagram. The comment will have an indicator to notify if it was a ClubUML ‘smart policy’ recommendation or not.

##Alternate Flow##

###User selects less than two diagrams ###

If the user selects less than two diagrams the system alerts with a pop-up saying, “Please select at least two diagrams”

###User selects more than two diagrams ###

If the user selects more than two diagrams the system alerts with a pop-up saying, “Please select at most two diagrams”

###User selects a project from the welcome page that is disabled###

If the user selects a project from the welcome page that is disabled, then he or she will be presented with 
a list of diagrams that have been previously uploaded to the project in read-only mode.  The user
will be unable to compare any diagrams, merge diagrams, or upload any diagrams.

###No Response from Server###

If in process of preparing the comparison report there is no response from the server, then:

1. ClubUML application shall display the message "Network unavailable – try again".
2. The use case ends with a failure condition.

##Key Scenarios##

If the button “save” has not been clicked, no file would be saved.

##Post-conditions##

1.	Successful Completion

A detailed comparison report will be generated.

2.	Failure Condition

No comparison report is generated.

