#Overview of ClubUML Diagram Comparison Algorithm#

<TABLE>
	<TR><TD>Document Type</TD><TD>Algorithm Summary</TD></TR>
	<TR><TD>Activity</TD><TD>Analysis</TD></TR>
	<TR><TD>Document Version</TD><TD>1.0</TD></TR>
	<TR><TD>Document Status</TD><TD>Draft</TD></TR>
</TABLE>

<TABLE>
	<TR><TH>Version history</TH><TH>Date</TH><TH>Version</TH><TH>Description</TH><TH>Author</TH></TR>
	<TR><TD>10.28.2013</TD><TD>1.0</TD><TD>Initial Draft</TD><TD>Seth Lee</TD></TR>
</TABLE>

##Brief Description##

The purpose of this document is to review at a high level the algorithm that will be used 
to support the 'smart policy' functionality incorporated into the ClubUML application as it 
pertains to the comparison of two Diagrams, of the same Context, in the same Project.  

'Smart policy' functionality refers to the systematic application of a set of policies, or 
rules, to the comparison of two UML diagrams (initially for UML Class diagrams) to determine
which diagram is preferred of the two diagrams.  The comparison algorithm relies on the 
definition of a set of policies that utilize the metadata that comprises the UML diagrams.  
Each policy is associated with a policy score, which provides the algorithm with a sort of
weight for the application of the policy to the diagram's metadata.  

Refactoring functionality refers to the systematic application of a set of rules to an 
individual UML diagram (Class diagram initially) to restructure the diagram at an optimized
level of abstraction.

##Preconditions##

In the spirit of comparing diagrams that are at a high level similar, it is assumed that 
the diagrams being compared belong to the same Context, a construct designed to partition
diagrams within a project based on some level of functional or technical similarity.

Configurable point values have been assigned in the database to each smart policy and refactoring rule.  
Rules have configurable point values to allow the application to be flexible and respond 
to the needs of the client organization. 

##Basic Flow##

1.  Apply smart policy rules 

1.1   For each diagram:

1.1.1   Gather metrics 
1.1.1.2	  Total number of attributes
1.1.1.3	  Total number of Classes
1.1.1.4	  Number of associations missing multiplicities
1.1.1.5	  Number of classes without associations/relationships

1.1.2   Calculate the average number of attributes per Class.  For each class:
1.1.2.2		Calculate the total number of attributes
1.1.2.3		Calculate the number of Classes
1.1.2.4		Calculate the average number of attributes / Class

1.3	  Calculate smart policy score:

1.3.1	Average number of attributes per Class 
1.3.1.2	  For each diagram, compare the average number of attributes/Class (1.1.2.4) to
	      the configuration value for the average attributes/Class rule for the ideal number of 
	      attributes/Class and the maximum number of attributes/Class.  
*			 If the average number of attributes/Class = the configuration value for the ideal
		     number of attributes/Class, averageAttributesScore is 0.
*			 If the average number of attributes/Class > the configuration value for the ideal
		     number of attributes/Class but is < the configuration value for the maximum number
		     of attributes/Class, averageAttributesScore is (average number of attributes/Class
		     - ideal number of attributes/Class) * averageAttributesPointsUnder
*			 If the average number of attributes/Class > the configuration value for the ideal
			 number of attributes/Class and is >= the configuration value for the maximum number
			 of attributes/Class, averageAttributesScore is (averageAttributesMaxPoints + 
			 (the number of attributes / Class - maximum number of attributes/Class) * 
			 averagePointsOver
			 
1.3.2	Total number of Classes

1.3.2.1	 For each diagram, compare the total number of Classes (1.1.1.3) to the configuration
	     value for the total number of Classes rule for the ideal number of total Classes
	     and the maximum number of total Classes.
*		      If the total number of Classes = the configuration value for the ideal number
		      of totalClasses, totalClassesScore is 0.
*			  If the total number of Classes > the configuration value for the ideal total
			  number of Classes but is < the configuration value for the maximum total number
			  of Classes, totalClassesScore is (total number of CLasses - ideal number of
			  total Classes) * totalClassesPointsUnder
*			  If the total number of Classes > the configuration value for the ideal total
			  number of Classes and is >= the configuration value for the maximum total 
			  number of Classes, totalClassesScore is (totalClassesMaxPoints + (total number
			  of Classes - maximum total number of Classes) * totalClassesPointsOver

1.3.3	Associations that are missing multiplicities

1.3.3.1	 For each diagram, calculate the missing multiplicities (1.1.1.4) score
*			  If there are no missing multiplicities, missingMultiplicitiesScore is 0.
*			  If there are missing multiplicities, missingMultiplicitiesScore = 
			  number of missing multiplicities * missingMultiplicitiesPoints
			  
1.3.4	Classes that are missing associations

1.3.4.1	  For each diagram, calculate the missing associations (1.1.1.5) score
*		      If there are no missing associations, missingAssociationsScore is 0.
*			  If there are missing associations, missingAssociationsScore = number of
			  missing associations * missingAssociationsPoints
			  
1.3.5	Total smart policy score

1.3.5.1	  For each diagram, 
*			  smartPolicyScore = averageAttributesScore + totalClassesScore + 
								 missingMultiplicitiesScore + missingAssociationsScore

2.  Refactor each diagram to achieve an optimized model:

2.1  Syntactical validation

2.1.2   No two classes have the same name 
2.1.3 	No two types have the same name
2.1.4	No two attributes within a class have the same name
2.1.5	No attributes of a class have the same name as any attributes of its super classes

2.2	 Optimization

2.2.1	For each node, identify any attributes of children that are the same in all children 
		and bring them up to the superclass.  Remove these attributes from the children.  
2.2.2	For each node, identify any attributes that remain in the children following the previous
		step that are common between children.  Create an 'extract superclass' as a subclass 
		of the node that will be the super class of the children.  Bring the common attributes
		up to the new 'extract superclass' and remove from the children.
2.2.3	Repeat steps for each branch moving down to the leaves.

2.3 	Examine nodes for any share attributes with other nodes.  If several nodes share
		common attributes, create a super class for those nodes and bring shared attributes
		up to the new super class, removing them from the nodes.
		
2.4	 Calculate refactoring score

2.4.1 	Calculate the number of occurrences of step 2.2.1 (shared attributes of all children rolled
		up to node).  
2.4.2	Calculate the number of occurrences of step 2.2.2 (shared attributes of a subset of 
		children rolled up to new 'extract superclass').
2.4.3	Calculate the number of occurrences of step 2.2.4 (shared attributes of root nodes
		rolled up to new superclass).
2.4.4	A refactoring score is calculated for each diagram if it has passed syntactical 
		validation.
2.4.4.1	Refactoring score (refactoringScore) = (2.4.1 * refactoringPointsForRule2.2.1) + 
							(2.4.2 * refactoringPointsForRule2.2.2) + 
							(2.4.3 * refactoringPointsForRule2.3)


3.  Calculate total score

The scoring of two compared diagrams is based on two principles:

*	Achieving a lower smart policy score 
* 	Achieving a lower refactoring score

3.1  Scenario 1 : Both diagrams pass syntactical validation

3.1.1	The diagram with the lower sum of smartPolicyScore + refactoringScore is promoted

3.2	 Scenario 2 : Diagram A passes syntactical validation, Diagram B does not
3.2.1	Diagram A is promoted

3.3	 Scenario 3 : Neither diagram passes syntactical validation
3.3.1	The diagram with the lower smartPolicyScore is promoted

##References##

Algorithmic logic associated with the refactoring process is based on the following:

Lano, K. & Kolahdouz-Rahimi, S. (2013) _Case Study: Class Diagram Restructuring_
