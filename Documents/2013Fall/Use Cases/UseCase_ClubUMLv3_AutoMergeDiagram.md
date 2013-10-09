#Use Case - ClubUMLv3 – Auto Merge Diagram#

##Version History##

<table>
<tr><th>Date</th><th>Version</th><th>Description</th><th>Author</th></tr>
<tr><td>9.18.2013</td><td>3.0</td><td>Created by deriving it from the existing Use Case for MergeDiagram in Spring2013 version</td><td>Gautam Chongtham</td></tr>
<tr><td>10.7.2013</td><td>3.1</td><td>Updated to include Context functionality</td><td>Seth Lee</td></tr>
</table>

###Brief Description###
This use case describes a manual merge functionality, in which the user selects which elements to keep from two related diagrams.
###Actors###
User:  The user selects the diagrams to merge and makes decisions on merging.
###Preconditions###

1.	The user follows Login use case flow to access ClubUML.
2.	The user has already uploaded two valid diagrams of the same type (following UploadDiagram flow of events), as well as of the same Context.
3.	The uploaded diagrams to be merged are from Papyrus (no Ecore merge support).

###Basic Flow of Events###

1.	The user selects two diagrams of the same type (class or sequence) and Context, both Papyrus files, to be merged.
2.	The user clicks the “merge” button.
3.	The user is prompted to choose either ‘Auto-Merge’ or ‘Manual Merge’. The user chooses ‘Auto-Merge’.

4.	The user is given the option to change default settings and preferences for the auto-merge algorithms.
5.	The user clicks another “merge” button to merge the class.
6.	The UI displays a new merged diagram with the versions of each element combined.
7.	The user can save the merged diagram.
8.	The user can export Papyrus files of the merged diagram (see DownloadProject use case).
9.	The user can comment on the merged diagram.
10.	The user can return to the main ClubUML page after doing any combination of saving the drawing, exporting the merged diagram, or commenting.
11.	The merged diagram will appear on the main ClubUML page along with the other diagrams that have been uploaded.

###Alternative Flows###

####Auto-merge is not able to resolve conflicts####

If auto-merge is not able to resolve some conflicts, then:
1.	The user will be prompted any unresolved conflicts with associations, if any, in the newly merged. Also a message saying manual merge is necessary for such scenarios. 
2.	The use case ends here.

####Incorrect type of diagrams####

If user selects two different types of diagrams, then:
3.	An error dialog will be prompted and ask the user to select two diagrams with the same type.
4.	The use case returns to basic flow step 1.

####Number of diagrams error####

If user selects more or less than two diagrams, then:
1.	An error dialog will be prompted and ask the user to select more or less diagrams to be merged.
2.	The use case returns to basic flow step 1.

####Two exact diagrams are selected####

If user selects two diagrams that are exactly the same, then
1.	A dialog will be prompted notifying user that the two diagrams are the same.  Neither selections of merging nor saving of the diagram is allowed.
2.	The use case returns to basic flow step 1.

###Subflows ###

####No merging####

1.	The user doesn’t make the request to merge diagrams
2.	The user can return to the main ClubUML page, and the use case ends.

####No saving diagram####

1.	The user chooses not to save an image of the merged diagram.
2.	No saving will be done.

####No exporting XMI####

1.	The user chooses not to export an XMI file of the merged diagram.
2.	No exporting will be done.

####No commenting####

1.	The user chooses not to leave any comment.
2.	No comment will be added to the diagram.

###Key Scenarios###

No diagrams will be saved unless the user makes the request.

###Post-conditions###

1.	The merged diagram is saved with comments, if any.
2.	No diagrams are lost.

###Special Requirements###

The merged diagram has the same type as the two original diagrams.
The merged diagram can be merged again with other diagrams, if the user makes the request.
