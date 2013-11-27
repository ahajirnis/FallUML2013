#Overview of ClubUML Diagram Comparison Algorithm#

<TABLE>
	<TR><TD>Document Type</TD><TD>Algorithm Summary</TD></TR>
	<TR><TD>Activity</TD><TD>Analysis</TD></TR>
	<TR><TD>Document Version</TD><TD>1.0</TD></TR>
	<TR><TD>Document Status</TD><TD>Draft</TD></TR>
</TABLE>

<TABLE>
	<TR><TH>Date</TH><TH>Version History</TH><TH>Version</TH><TH>Description</TH><TH>Author</TH></TR>
	<TR><TD>10.28.2013</TD><TD>1.0</TD><TD>Initial Draft</TD><TD>Create draft of comparison
	algorithm overview</TD><TD>Seth Lee</TD></TR>
	<TR><TD>11.12.2013</TD><TD>1.1</TD><TD>Updated Draft</TD><TD>Update for team feedback on 
	proposed algorithm</TD><TD>Seth Lee</TD></TR>
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

Smart policy policies may be applied either at the default or context-levels.  In the absence
of a context-level policy, the default policy will be applied to the comparison.  The algorithm
described in this document assumes that the appropriate policy level has been determined 
(e.g. default policy versus context-level policy) and is being provided to the algorithm
as an input.

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

1.1.2.5		Normalize the number of associations missing multiplicities by dividing the 
			number of missing multiplicities (1.1.1.4) by the total number of classes (1.1.2.3).
				
1.1.2.6		Normalize the number of missing associations by dividing the number of missing 
			associations (1.1.1.5) by the total number of classes (1.1.2.3).

1.3	  Calculate smart policy score:

1.3.1	Average number of attributes per Class 

1.3.1.2	  For each diagram, compare the average number of attributes/Class (1.1.2.4) to
	      the configuration value for the average attributes/Class rule for the ideal number of 
	      attributes/Class (idealNoOfAttributes), the maximum number of attributes/Class 
	      (maxNoOfAttributes) and the minimum number of attributes/Class (minNoOfAttributes).  
	      
*			 If the average number of attributes/Class = idealNoOfAttributes, 
			averageAttributesScore is 0.
		     	
*			 If the (A) average number of attributes/Class > idealNoOfAttributes < maxNoOfAttributes
			OR (B) minNoOfAttributes < average number of attributes/Class < idealNoOfAttributes, 
			then averageAttributesScore is 
			Absolute Value (idealNoOfAttributes - average number of attributes/Class) * avgAttributesBetweenPoints
		     	
*			 If the (A) average number of attributes/Class >= maxNoOfAttributes , 
			 averageAttributesScore is (avgAttributesMaxPoints + 
			 ((average Number of Attributes - maxNoOfAttributes) * 
			 avgAttributesOverMaxPoints	)
			 OR (B) average number of attributes <= minNoOfAttributes,
			 averageAttributesScore is (avgAttributesMinPoints + 
			 ((minNoOfAttributes - average number of attributes) * 
			 avgAttributesUnderMinPoints)
			 
1.3.2	Total number of Classes

1.3.2.1	 For each diagram, compare the total number of Classes (1.1.1.3) to the configuration
	     value for the total number of Classes rule for the ideal number of total Classes 
	     (idealNoOfClasses), the maximum number of total Classes (maxNoOfClasses) 
	     and the minimum number of total Classes (minNoOfClasses).
	     
*		      If the total number of Classes = idealNoOfClasses, totalClassesScore is 0.
		      	
*			  If the (A) total number of Classes > idealNoOfClasses < maxNoOfClasses 
			  OR (B) minNoOfClasses < total number of Classes < idealNoOfClasses, then 
			  totalClassesScore is 
			  Absolute Value (idealNoOfClasses - total number of Classes ) * totalClassBetweenPoints
			  	
*			  If the (A) total number of Classes >= maxNoOfClasses,
			  totalClassesScore is (totalClassMaxPoints +
			  ((total number of Classes - maxNoOfClasses) * totalClassOverMaxPoints)
			  OR (B) total number of classes <= minNoOfClasses,
			  totalClassesScore is 
			  ((minNoOfClasses - total number of Classes) * totalClassUnderPoints)

1.3.3	Associations that are missing multiplicities

1.3.3.1	 For each diagram, calculate the missing multiplicities (1.1.1.4) score

*			  If there are no missing multiplicities, missingMultiplicitiesScore is 0.
	
*			  If there are missing multiplicities, missingMultiplicitiesScore = 
			  normalized number of missing multiplicities (1.1.2.5) * missingMultiplicitiesPoints
			  	
			  
1.3.4	Classes that are missing associations

1.3.4.1	  For each diagram, calculate the missing associations (1.1.1.5) score

*		      If there are no missing associations, missingAssociationsScore is 0.
	
*			  If there are missing associations, missingAssociationsScore = 
			  normalized number of missing associations (1.1.2.6) * missingAssociationsPoints	
			  
1.3.5	Total smart policy score

1.3.5.1	  For each diagram:

			  smartPolicyScore = averageAttributesScore + totalClassesScore + 
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
		
2.4.4.1	Refactoring score (refactoringScore) = (2.4.1 * siblingAttributesAbstractionPoints) + 
							(2.4.2 * subsetSiblingAttributesAbstractionPoints) + 
							(2.4.3 * rootAttributesAbstractionPoints)


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
