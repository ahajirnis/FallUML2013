#Display comments#

<TABLE>
<TR><TD>Document Type</TD><TD>Use case</TD></TR>
<TR><TD>Activity</TD><TD>Analysis</TD></TR>
<TR><TD>Document Version</TD><TD>1.1</TD></TR>
<TR><TD>Document Status</TD><TD>Draft</TD></TR>
</TABLE>

<TABLE>
<TR><TH>Date</TH><TH>Version</TH><TH>Description</TH><TH>Author</TH></TR>
<TR><TD>Spring 2013</TD><TD>1.0</TD><TD>Initial draft</TD><TD>Spring 2013 Team</TD></TR>
<TR><TD>10.14.2013</TD><TD>1.1</TD><TD>Updated for user roles.</TD><TD>Seth Lee</TD></TR>
</TABLE>

##Brief Description##

This use case describes how the app display comments (if there are any) to the user
who has chosen to display a previously commented diagram.

##Actors##

1 Users
2 App server

##Preconditions##

In the project, there is at least one diagram and one comment to display.

Users login in and has chosen the desired project.

Users choose a diagram and then the app display it.

##Flow of Events##

1) User logins in successfully.
2) The “Display diagram” use case is performed.
3) App displays the default diagram’s comments.
4) User chooses other diagram to display.
5) App displays the relative diagram comments automatically.
6) The use case ends successfully.

##Alternative Flows##

###No comments###

If the diagram has no comments, it shows an empty chat window.

###No response from server###

If in step 3 of events, there is no response from the app. The app shall
retry, if still no response, it shows an empty chat window.

##Post conditions##

###Display successfully###

The user can just review the comments and do nothing. Or he/her can also
reply other comments.

###No comment to display###

The user can add a new comment for the diagram.

##Special requirements##

1 The app shall display all comments as default.
2 There shall be a post time follow every comment.