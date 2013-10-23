ClubUML - User Scenario

Scenario 1: Register New User: 

1.	New User clicks on the register link on the login page which redirects the user to registration page.
2.	User enters all the required information and selects user type:
a.	User
b.	Policy manager(to be implemented)
3.	User clicks on the Create Account button, system will validate the information enter by User and throws an error for any invalid entry else system redirects the user to the Welcome page

Scenario 2: Register/Login as User: 

1.	User registers/Login as Normal User, system redirects the user to the Welcome page.
2.	The Welcome page for User displays the list of available projects
3.	User can select any one of the listed project and click on Proceed to Project button
4.	User clicks on proceed to Project button, System redirects to Display page with the lists of diagrams uploaded for that project.

Scenario 3: Register/Login as Policy Manager:

1.	User registers/Login as Policy Manager, system redirects the user to the Welcome page 
2.	The Welcome Page for the Policy Manager displays the list of the available project and  tabs for context and Policy view, and the option for the policy manager to create new project or delete existing ones and can add, copy context by clicking on the context tab, User can select any one of the listed project and click on Proceed to Project button
3.	User clicks on proceed to Project button, System redirects to Display page with the lists of Diagram under each Context for that project.

Scenario 4: Create/Edit Context for Policy Manager:

1.	Policy Manager navigates to the Context Tab.
2.	Policy Manager can see the list of Contexts with corresponding project and click on any contexts, which navigate to the Context page with the policy and the metrics used to formulate that policy listed.
3.	Policy Manager has option to add new Context or copy the existing ones

Scenario 5: Upload Diagram:

1.	User Selects Diagram Format type (currently support: ecore and XMI) and the Context from the drop-down list and click on Browse button.
2.	Windows dialog box opens up allowing the user to browse and select the diagram from his local system.
3.	User selects the diagram and click on upload button
4.	If the User tries to uploads the diagram format other than the one selected from dropdown, system should throw pop error message saying: “Incorrect format”
5.	If user selects the correct format, then system should upload the diagram correctly and save the diagram in the server under Uploads folder, list the diagram in the display page and display the diagram in the display box on the right side
 
Scenario 6: Download Diagram:

1.	User Clicks on Download Diagram button without selecting any diagram from the list, system throws a pop up error message saying “select at least one diagram”.
2.	User selects any diagram and Clicks on the Download Diagram button, selected diagram should be downloaded to the user local system in a zip file.

Scenario 7: Download Project:

1.	User Clicks on Download Project, all the diagram under that project should be downloaded to the user local system in a zip file. 

Scenario 8: Compare Diagram:

1.	User Clicks on Go to Compare button without selecting any diagram or selecting only one or more than two diagrams, System should through pop error message select two Diagrams.
2.	User selects two diagram of same format and click on Go to Compare, system should navigate to compare page and display the two selected diagram side by side, and the list of comparison metrics applicable to that comparison and a compare button.
3.	User clicks on the compare button, System does the comparison of the 2 diagrams based on the comparison metrics under the context selected.
4.	System list the reports of the comparison made, showing the pros and cons of each diagram and the aggregated policy score for each of them.
5.	System provides the user with the option of selecting any one of the diagram based on the report or request the system to suggest the better one based on the policy score it calculated.
6.	User can select any diagram and promote it with the appropriate comment, which ass to the promote count for that diagram.
7.	User can request the system to suggest the better diagram

Scenario 9: Promote already compared Diagram:

1.	User can view the compare history, with the list of compared diagrams, the compared date, and diagrams being selected or promoted for each comparison
2.	User can promote the individual without going through comparison scenario.

Scenario 10: Merge Diagram:

1.	User Clicks on Go to Merge button without selecting any diagram or selecting only one or more than two diagrams, System should through pop error message select two Diagrams.
2.	User selects two diagram of same format and click on Go to Merge, system should navigate to Merge page and display the two selected diagram side by side, and the list the classes, attributes unique to each diagram and common to both.
3.	User can select the classes to merge and the attributes to be included from each diagram, or add the classes which are in one diagram and not in other and select the relationship to be used between classes.
4.	After adding and merging the required classes and attributes user clicks on next, System generates the merged diagram based on the user’s Merge Activity, and redirects the user to the Display page and displays the new merged diagram.
5.	Instead of manually merging the diagrams, user can request system to merge the diagrams, based on the smart policy, system picks the best features of both the diagram provides the user with merged diagram. 


Scenario 11: Metrics for Smart Policy:

1.	Based on the context selected the, different metrics might be used.
2.	Metrics like the max and Average no of classes which are predefined and compared to the no of classes in the diagram selected. 
3.	These values for max and avg. no of classes might be different for different context, and policy manager decides on this values.
4.	Other metrics could be the hierarchy level, or the no. of parent child relationships, no of properties and operations per each class.
5.	Parse the requirement document for the class diagram and count the no. of noun to be set as max no of classes.









