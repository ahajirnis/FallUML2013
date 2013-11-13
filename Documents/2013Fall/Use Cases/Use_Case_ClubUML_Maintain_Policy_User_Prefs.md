#Use Case – ClubUML – Enable/Disable ‘Smart Policy’ User Preferences #

<TABLE>
<TR><TD>Document Type</TD><TD>Use case</TD></TR>
<TR><TD>Activity</TD><TD>Analysis</TD></TR>
<TR><TD>Document Version</TD><TD>1.1</TD></TR>
<TR><TD>Document Status</TD><TD>Draft</TD></TR>
</TABLE>

<TABLE>
<TR><TH>Version history</TH><TH>Date</TH><TH>Version</TH><TH>Description</TH><TH>Author</TH></TR>
<TR><TD>09.23.2013</TD><TD>1.0</TD><TD>Initial draft</TD><TD>Seth Lee</TD></TR>
<TR><TD>10.7.2013</TD><TD>1.1</TD><TD>Updated for Context functionality</TD><TD>Seth Lee</TD></TR>
</TABLE>

#Brief Description#

This use case portrays the scenario where a user chooses which ‘smart policy’ rules they would like to enable and disable to be applied across all UML diagram comparisons and merges where the user selects the ‘Auto-Merge’ or ‘Suggest Promote’ options.

#Actors#

User: The user is the actor who enables or disables his or her ‘smart policy’ user preferences.

#Preconditions#

1.	The user follows Login use case flow to access ClubUML.
	
#Flow of events#

1.	The user follows Login use case flow to access ClubUML.
2.	The user is presented with an ‘Options’ navigation drop-down on the initial application screen, along with the Comments and upload file features.  
3.	The user clicks on ‘Options’, and is presented with a drop-down item off of ‘Options’ to “Maintain ‘Smart Policy.’”  
4.	The user clicks on “Maintain ‘Smart Policy.’”
5.	The user is presented with a list of ‘smart policy’ rules that can checked or un-checked.  These rules can be clicked for more detailed information.  
o	The user un-checks a rule to disable it.
o	The user checks a rule to disable it.  
o	The user clicks on a rule for more detailed information and is presented with a pop-up or another screen showing the details of the rule.  Rules that have configurable values associated with them (e.g. a number or Boolean setting) are editable. 
•	The user changes an editable field associated with a rule.  The user clicks ’Save’ to retain the edited value(s).  The editable value is retained and stored for the user if the rule is or becomes enabled.
•	The user clicks ‘Ok’ to exit the detailed rule information screen.
6.	With the list of ‘smart policy’ rules reviewed and appropriate rules enabled or disabled, the user clicks ‘Save’ to retain their preferences.
7.	The user is returned to the previous screen.

#Alternate Flow#

##User exits the “Maintain ‘Smart Policy’” screen without saving changes or opts to ‘Cancel’##

If the user exits the “Maintain ‘Smart Policy’” maintenance screen without saving his or her changes, or opts to ‘Cancel,’ then no changes are committed to the user’s saved list of rules.

#Key Scenarios#

If the button “save” has not been clicked, no ‘smart policy’ rule changes will be stored.

#Post-conditions#

1.	Successful Completion

The user’s ‘smart policy’ rule choices are stored for use by the ‘Auto-Merge’ and ‘Suggest Promote’ features.

2.	Failure Condition

No changes to the user’s ‘smart policy’ rule preferences.

