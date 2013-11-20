package compareAlgorithm;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.language.RefinedSoundex;
import org.apache.commons.codec.language.Soundex;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import controller.diagramparser.ClassDiagramParser;
import controller.diagramparser.DiagramParser;
import domain.CD_Attribute;
import domain.CD_Class;
import domain.CD_Operation;
import domain.CD_Reference;

/**
 * Algorithm class that compares all the features of a class diagram.
 * 
 * @author Gautam Ch
 * 
 * 
 */
public class UnifiedAlgorithm {

	private DiagramParser diagParser1;
	private DiagramParser diagParser2;
	private EList<EObject> firstModel; // ECore objects
	private EList<EObject> secondModel;

	private ECorePackage ePackage1; // Packages
	private ECorePackage ePackage2;


	private ArrayList<String> matchedClasses; // Records matched classes
	private ArrayList<String> comparedClasses; // Records compared classes
	private String reportText;
	
	
	
	//private ArrayList<String> similarClasses;
	//private ArrayList<String> aloneClasses;
	

	Report report; // for writing report to the pdf file

	/**
	 * Constructor to initialize necessary class members.
	 * 
	 * @param firstDiagram
	 *            first diagram to compare
	 * @param secondParser
	 *            second diagram to compare
	 * @param reportFile
	 *            path to store report
	 */
	public UnifiedAlgorithm(DiagramParser firstDiagram, DiagramParser secondParser,
			String reportFile) {
		this.diagParser1 = firstDiagram;
		this.diagParser2 = secondParser;
		report = new Report(reportFile);
		matchedClasses = new ArrayList<String>();
		comparedClasses = new ArrayList<String>();
	}
	
	public void testClasses() {
		
		List<CD_Class> classList = ((ClassDiagramParser) diagParser1).getClasses();
		for(CD_Class cdClass : classList) {
			System.out.println("Class Name: " + cdClass.getClassName());
//			System.out.println("Super Class: " + );
		}
		
	}

	/**
	 * Main dispatch function for comparing the features of a class.
	 */
	public String compare() {
		report.addToReport("Comparison Report\n\n\n");
		reportText = "\nReport \n\n";
		report.addToReport("Checking individual classes due to absence of packages");
		reportText += "Checking individual classes due to absence of packages\n\n";
		List<CD_Class> classList1 = ((ClassDiagramParser) diagParser1).getClasses();
		List<CD_Class> classList2 = ((ClassDiagramParser) diagParser2).getClasses();
		for(CD_Class cdClass1 : classList1) {
			for(CD_Class cdClass2 : classList2) {
				compareUnPackedClasses(cdClass1, cdClass2);
			}
		}
		// Reporting unmatch classes
		reportUnmatchedClasses();
		
		//********************************For testing matchedClasses, plz keep, Dong Guo
		
		report.addToReport("Matched Classes: ");
		reportText += "Matched Classes: \n\n";
		for(int i = 0; i < matchedClasses.size(); i++){
			report.addToReport(i + ": " + matchedClasses.get(i));
			reportText += i + ":" + matchedClasses.get(i) + "\n\n";
		}
		//**********************************************************
		
		// Close the report
		report.finalize();
//		if (comparePackage()) {
//			eClass1 = new ECoreClass(ePackage1);
//			eClass2 = new ECoreClass(ePackage2);
//
//			// Comparing classes entirely including the details
//			compareClasses(eClass1, eClass2);
//
//			// Reporting unmatch classes
//			reportUnmatchedClasses();
//
//		} else {
//			report.addToReport("Checking individual classes due to absence of packages");
//			for (int i = 0; i < firstModel.size(); i++) {
//				EClass firstClass = (EClass) firstModel.get(i);
//				for (int j = 0; j < secondModel.size(); j++) {
//					EClass secondClass = (EClass) secondModel.get(j);
//					compareUnPackedClasses(firstClass, secondClass);
//				}
//			}
//
//			// Reporting unmatch classes
//			reportUnmatchedClasses();
//		}
//
//		//********************************For testing matchedClasses, plz keep, Dong Guo
//		for(int i = 0; i < matchedClasses.size(); i++){
//			report.addToReport(i + ": " + matchedClasses.get(i));
//		}
//		//**********************************************************
//		
//		// Close the report
//		report.finalize();
		return reportText;

	}

	/**
	 * Checks packages and returns if the packages are similar or not.
	 * 
	 * @return true if similar else false
	 */
	private boolean comparePackage() {
		// report.startRoutine("packages");
		try {
			if (checkPackages()) {
				ePackage1 = new ECorePackage(firstModel);
				ePackage2 = new ECorePackage(secondModel);

				if (packageNameSimilar(ePackage1.getName(), ePackage2.getName()) > 0) {

					report.addToReport("Packages match : "
							+ ePackage1.getName() + " and "
							+ ePackage2.getName());
					reportText += "Packages match : "
							+ ePackage1.getName() + " and "
							+ ePackage2.getName() + "\n\n";
					return true;
				} else {
					report.addToReport("Packages don't match\n"
							+ "\nName of first Package : "
							+ ePackage1.getName()
							+ "\n Name of second Package : "
							+ ePackage1.getName());
					reportText += "Packages don't match\n\n"
							+ "\nName of first Package : "
							+ ePackage1.getName()
							+ "\n Name of second Package : "
							+ ePackage1.getName() + "\n\n";

					return false;
				}
			} else {
				return false;
			}
		} catch (Exception ex) {
			// ex.printStackTrace();
		} finally {
			// report.terminateRoutine("Packages");
		}
		return false;
	}

	/**
	 * Checking if files are in proper format
	 * 
	 * @return true if files are valid, false otherwise
	 */
	private boolean checkPackages() {
		if (firstModel.get(0) instanceof EPackage) {
			if (secondModel.get(0) instanceof EPackage) {

			} else {
				report.addToReport("Could not find packages in second model");
				reportText += "Could not find packages in second model\n\n";
				return false;
			}
		} else {
			report.addToReport("Could not find packages in first model");
			reportText += "Could not find packages in first model\n\n";
			return false;
		}
		return true;
	}

	/**
	 * Compares package names.
	 * 
	 * @param firstName
	 *            first name to compare
	 * @param secondName
	 *            second name to compare
	 * @return true if names match else false
	 */
	private int packageNameSimilar(String firstName, String secondName) {
		return this.compareNames(firstName, secondName);
	}

	/**
	 * General method for comparing any pair of names.
	 * 
	 * @param name1
	 *            - first name to compare
	 * @param name2
	 *            - second name to compare
	 * @return PERFECT_MATCH if same names
	 * @return PARTIAL_MATCH if names are similar based on soundex comparison
	 * @return NOT_MATCH if names not matched at all
	 */
	private int compareNames(String name1, String name2) {
		try {
//			boolean firstStringLonger = name1.length() > name2.length();
//			int maxCount = 0;
//			if(firstStringLonger)
//				maxCount = name2.length();
//			else
//			
			Soundex soundex = new Soundex();
//			new RefinedSoundex().difference(name1, name2) == 
			if (soundex.difference(soundex.encode(name1), soundex.encode(name2)) == 4) {
				return Constants.PERFECT_MATCH;
			}
			if (soundex.difference(soundex.encode(name1), soundex.encode(name2)) > 2) {
				return Constants.PARTIAL_MATCH;
			}
//			if (new Soundex().difference(name1.toString(), name2.toString()) == 4) {
//				return Constants.PERFECT_MATCH;
//			}
//			if (new Soundex().difference(name1, name2) > 2) {
//				return Constants.PARTIAL_MATCH;
//			}
		} catch (EncoderException e) {
			return Constants.NOT_MATCH;
		}
		return Constants.NOT_MATCH;
	}

	/**
	 * Compare package information. If package are the same, compare class
	 * details. If package are not the same, compare structure details. Adds
	 * comments to report.
	 * 
	 * @param cdClass1
	 *            first class to compare
	 * @param cdClass2
	 *            second class to compare
	 */
	private void compareUnPackedClasses(CD_Class cdClass1, CD_Class cdClass2) {
		// report.startRoutine("classes");
		try {

			// compare class names by soundex
			int comparedValue = compareNames(cdClass1.getClassName(), cdClass2.getClassName());

			if (comparedValue == Constants.PERFECT_MATCH) {
				// add classes to the list of matched classes
				matchedClasses.add(cdClass1.getClassName());
				matchedClasses.add(cdClass2.getClassName());

				// add to the report
				report.addToReport("Perfect Match : " + cdClass1.getClassName()
						+ " : " + cdClass2.getClassName());
				reportText += "Perfect Match: " + cdClass1.getClassName()
						+ " : " + cdClass2.getClassName() + "\n\n";

				// send the classes for comparing details
				compareClassDetails(cdClass1, cdClass2);

			} else {
				// Pass the two classes for structural class comparison
				this.structuralComparison(cdClass1, cdClass2);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// report.terminateRoutine("Unpacked Classes");
		}
	}

	/**
	 * Compares Classes. Finds perfect and partial match. Adds comments to
	 * report object.
	 * 
	 * @param firstEClass
	 *            first class to compare
	 * @param secondEClass
	 *            second class to compare
	 */
	/*private void compareClasses(ECoreClass firstEClass, ECoreClass secondEClass) {
		// report.startRoutine("classes");
		try {
			for (int x = 0; x < firstEClass.size(); x++) {
				// flag for determining whether a class is found
				boolean classFound = false;

				EClass class1 = firstEClass.getEClass(x);

				for (int y = 0; y < secondEClass.size(); y++) {
					EClass class2 = secondEClass.getEClass(y);

					// compare class names by soundex
					int comparedValue = compareNames(class1.getName(),
							class2.getName());

					if (comparedValue == Constants.PERFECT_MATCH) {
						// add classes to the list of matched classes
						matchedClasses.add(class1.getName());
						matchedClasses.add(class2.getName());

						// add to the report
						report.addToReport("Perfect Match : "
								+ class1.getName() + " : " + class2.getName());

						// send the classes for comparing details
						compareClassDetails(class1, class2);

						// set the flag
						classFound = true;
					} else {
						// Pass the two classes for structural class comparison
						this.structuralComparison(class1, class2);

						// set the flag
						classFound = true;
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// report.terminateRoutine("Classes");
		}
	}*/

	/**
	 * Compare classes details after classes match.
	 * 
	 * @param cdClass1
	 *            first class to compare
	 * @param cdClass2
	 *            second class to compare
	 */
	private void compareClassDetails(CD_Class cdClass1, CD_Class cdClass2) {
		compareSuperClass(cdClass1, cdClass2);
		compareAttributes(cdClass1, cdClass2);
		compareMethods(cdClass1, cdClass2);
		compareReferences(cdClass1, cdClass2);
		
		/*
		 * If the classes match each other,
		 * they will be added into matchedClasses in compareClasses()
		 * These two lines are duplicated.
		 * 
		 * Dong Guo 02/17/2013
		 */
		//matchedClasses.add(cls1.getName());
		//matchedClasses.add(cls2.getName());
	}

	/**
	 * Compares super classes of designated classes and adds comments to report
	 * object.
	 * 
	 * @param cdClass1
	 *            first class to compare super class
	 * @param cdClass2
	 *            second class to compare super class
	 */
	private void compareSuperClass(CD_Class cdClass1, CD_Class cdClass2) {
		// report.startRoutine("super classes");
		try {
			// Get super class list from classes
			List<CD_Class> superClassList1 = cdClass1.getSuperClasses();
			List<CD_Class> superClassList2 = cdClass2.getSuperClasses();

			// Select classes one by one and compare
			for (CD_Class superClass1 : superClassList1) {
				for (CD_Class superClass2 : superClassList2) {
					if (compareNames(superClass1.getClassName(),
							superClass2.getClassName()) > 0) {
						report.addToReport("Super Classes matched : "
								+ "first " + superClass1.getClassName()
								+ " with " + "second "
								+ superClass2.getClassName());
						reportText += "Super Classes matched : " + "first " + superClass1.getClassName()
										+ " with " + "second " + superClass2.getClassName() + "\n\n";
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// report.terminateRoutine("Super classes");
		}
	}

	/**
	 * Compare class attributes and adds comments to report object.
	 * 
	 * @param cdClass1
	 *            first class containing attribute to compare
	 * @param cdClass2
	 *            second class containing attributes to compare
	 */
	private void compareAttributes(CD_Class cdClass1, CD_Class cdClass2) {
		// report.startRoutine("attributes");
		try {
			List<CD_Attribute> attrList1 = cdClass1.getAttributes();
			List<CD_Attribute> attrList2 = cdClass2.getAttributes();

			for (int i = 0; i < attrList1.size(); i++) {
				// flag set if attribute found
				boolean attrFound = false;

				for (int j = 0; j < attrList2.size(); j++) {
					if (compareNames(attrList1.get(i).getAttrName(),
							attrList2.get(j).getAttrName()) > 1) {
						// set the flag
						attrFound = true;
						report.addToReport("Attributes name matches : "
								+ "first " + attrList1.get(i).getAttrName()
								+ " with " + "second "
								+ attrList2.get(i).getAttrName());
						reportText += "Attributes name matches : " + "first " + attrList1.get(i).getAttrName()
								+ " with " + "second " + attrList2.get(i).getAttrName() + "\n\n";

						// compare attribute type
						if (compareETypes(attrList1.get(i).getAttrType(),
								attrList2.get(j).getAttrType())) {
							report.addToReport("Attributes type matches : "
									+ "first "
									+ attrList1.get(j).getAttrType()
									+ " with " + "second "
									+ attrList2.get(j).getAttrType());
							reportText += "  Attributes type matches : " + "first " + attrList1.get(j).getAttrType()
									+ " with " + "second " + attrList2.get(j).getAttrType() + "\n\n";
						}
					}
				}
				// add to report the unmatched attribute
				if (!attrFound) {
					report.addToReport("Attributes from first that don't match : "
							+ attrList1.get(i).getAttrName());
					reportText += "Attributes from first that don't match : "
							+ attrList1.get(i).getAttrName() + "\n\n";
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// report.terminateRoutine("Attributes");
		}
	}

	/**
	 * Compare methods by method name and type and adds comments to report
	 * object.
	 * 
	 * @param cdClass1
	 *            first class containing operations to compare
	 * @param cdClass2
	 *            second class containing operations to compare
	 */
	private void compareMethods(CD_Class cdClass1, CD_Class cdClass2) {
		// report.startRoutine("methods");
		try {
//			EList<EOperation> methodList1 = cdClass1.getEAllOperations();
//			EList<EOperation> methodList2 = cdClass2.getEAllOperations();
			List<CD_Operation> methodList1 = cdClass1.getOperations();
			List<CD_Operation> methodList2 = cdClass2.getOperations();

			for(CD_Operation operation1 : methodList1) {
				for (CD_Operation operation2 : methodList2) {
					if (compareNames(operation1.getOperationName(), operation2.getOperationName()) > 0) {
						report.addToReport("Methods name matches : " + "first "
								+ operation1.getOperationName() + " with "
								+ "second " +operation2.getOperationName());
						reportText += "Methods name matches : " + "first " + operation1.getOperationName() + " with "
								+ "second " +operation2.getOperationName() + "\n\n";

						if (this.compareETypes(operation1.getReturnType(),
								operation2.getReturnType())) {
							report.addToReport("Methods return type matches : "
									+ "first "
									+ operation1.getReturnType()
									+ " with " + "second "
									+ operation2.getReturnType());
							reportText += "Methods return type matches : " + "first " + operation1.getReturnType()
									+ " with " + "second " + operation2.getReturnType() + "\n\n";
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// report.terminateRoutine("Methods");
		}
	}

	/**
	 * Compare references of a class. Adds comments to report object if
	 * references match or not.
	 * 
	 * @param cdClass1
	 *            first class containing references to compare
	 * @param cdClass2
	 *            second class containing references to compare
	 */
	private void compareReferences(CD_Class cdClass1, CD_Class cdClass2) {
		// report.addToReport("references");
		try {
			List<CD_Reference> refList1 = cdClass1.getReferences();
			List<CD_Reference> refList2 = cdClass2.getReferences();

			for (CD_Reference reference1 : refList1) {
				// flag set if references match
				boolean refFound = false;

				for (CD_Reference reference2 : refList2) {
					if (this.compareNames(reference1.getReferenceTypeName(),
							reference2.getReferenceTypeName()) > 0) {
						// add to report
						report.addToReport("Reference Name match : "
								+ reference1.getReferenceName());
						reportText += "Reference Name match : " + reference1.getReferenceName() + "\n\n";

						String refName1 = reference1.getReferenceTypeName().toString();
						String refName2 = reference2.getReferenceTypeName().toString();
								

						// compare opposite reference
						if (compareNames(refName1, refName2) == 2) {
							report.addToReport("Opposite Reference match : "
									+ refName1);
							reportText += "Opposite Reference match : "	+ refName1 + "\n\n";
							refFound = true;
						}
					}
				}
				if (!refFound) {
					report.addToReport("Reference from first diagram "
							+ reference1.getReferenceName() + " -->"
							+ reference1.getReferenceTypeName()
							+ " not found in second diagram");
					reportText += "Reference from first diagram "
							+ reference1.getReferenceName() + " -->"
							+ reference1.getReferenceTypeName()
							+ " not found in second diagram\n\n"; 
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// report.terminateRoutine("References");
		}
	}

	/**
	 * Compare ETypes
	 * 
	 * @param etype1
	 *            first classifier to compare
	 * @param etype2
	 *            second classifier to compare
	 * @return true if equals else false
	 */
	private boolean compareETypes(String etype1, String etype2) {
		return etype1.equals(etype2);
	}

	/**
	 * Structurally compare the two classes ie reference attribute n methods
	 * 
	 * @param cdClass1
	 *            first class to compare
	 * @param cdClass2
	 *            second class to compare
	 */
	private void structuralComparison(CD_Class cdClass1, CD_Class cdClass2) {
		// report.startRoutine("structural class");
		try {
			// check if any of the class already in list of matched classes
			if (!(this.matchedClasses.contains(cdClass1.getClassName()) || this.matchedClasses
					.contains(cdClass2.getClassName()))) {
				report.addToReport("Comparing classes.." + cdClass1.getClassName()
						+ " : " + cdClass2.getClassName());
				reportText += "Comparing classes: " + cdClass1.getClassName()
						+ " : " + cdClass2.getClassName() + "\n\n";

				// Check if structurally the similarity is greater than 50 %
				if (this.structAttrCompare(cdClass1, cdClass2) >= 0.5
						&& structMethodCompare(cdClass1, cdClass2) >= 0.5
						&& structRefCompare(cdClass1, cdClass2) >= 0.5) {
					report.addToReport("Structural Match " + cdClass1.getClassName()
							+ " : " + cdClass2.getClassName());
					reportText += "Structural Match: " + cdClass1.getClassName()
							+ " : " + cdClass2.getClassName() + "\n\n";
					
					/*
					 * set list of classes with different names but might be same 
					 * Dong Guo
					 * 
					 * similarClasses.add(cls1.getName());
					 * similarClasses.add(cls2.getName());
					 */
					
					this.compareClassDetails(cdClass1, cdClass2);
				} else {
					// Add the unmatched classes to the list of classes compared
					listComparedClasses(cdClass1, cdClass2);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// report.terminateRoutine("Structural class");
		}
	}

	/**
	 * Compare attributes based on name.
	 * 
	 * @param cls1
	 *            first class containing attributes to compare
	 * @param cls2
	 *            second class containing attributes to compare
	 * @return float between 0 and 1. Percentage of attributes matching.
	 */
	private float structAttrCompare(CD_Class cls1, CD_Class cls2) {
		// report.startRoutine("structural attributes");
		try {
			List<CD_Attribute> attrList1 = cls1.getAttributes();
			List<CD_Attribute> attrList2 = cls2.getAttributes();

			// If attribute list of both classes is empty then return 1
			// This allows comparison based on method and reference similarities
			if (attrList1.size() == 0 && attrList2.size() == 0)
				return 1;

			float attrScore = 0;

			for (CD_Attribute attribute1 : attrList1) {
				for (CD_Attribute attribute2 : attrList2) {
					if (compareNames(attribute1.getAttrName(),
							attribute2.getAttrName()) == 2) {
						// debug code
						report.addToReport("Attribute match "
								+ attribute1.getAttrName());
						reportText += "Attribute match "
								+ attribute1.getAttrName() + "\n\n";
						attrScore += 1;
					}
				}
			}
			// If attribute list is not empty then return, percentage of the
			// matched attribute
			// In this case a value between 0 and 1
			if (attrList1.size() != 0)
				return attrScore / attrList1.size();

			// Return 0 if attribute list of class 1 is empty and other is not
			return attrScore;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// report.terminateRoutine("Structural attributes");
		}
		return 0;
	}

	/**
	 * Compare methods structurally based on name and return type
	 * 
	 * @param cls1
	 *            first class containing operations to compare
	 * @param cls2
	 *            second class containing operations to compare
	 * @return float between 0 to 1. Percentage of operations matching.
	 */
	private float structMethodCompare(CD_Class cls1, CD_Class cls2) {
		// report.startRoutine("structural methods");
		try {
			List<CD_Operation> methodList1 = cls1.getOperations();
			List<CD_Operation> methodList2 = cls2.getOperations();

			if (methodList1.size() == 0 && methodList2.size() == 0)
				return 1;

			float methodScore = 0;

			for (CD_Operation operation1 : methodList1) {
				for (CD_Operation operation2 : methodList2) {
					// Compare method name
					if (this.compareNames(operation1.getOperationName(),
							operation2.getOperationName()) > 0) {
						// Compare method return type
						if (this.compareETypes(operation1.getReturnType(),
								operation2.getReturnType())) {
							// method params not compared
							report.addToReport("Method match "
									+ operation1.getOperationName());
							reportText += "Method match " + operation1.getOperationName() + "\n\n";
							methodScore += 1;
						}
					}
				}
			}
			// Return a percentage of the matched methods
			// In this case a decimal value between 0 & 1
			if (methodList1.size() != 0)
				return methodScore / methodList1.size();

			// Return 0 if the method list of class1 is empty and other class is
			// not
			return methodScore;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// report.terminateRoutine("Structural methods");
		}
		return 0;
	}

	/**
	 * Compare two classes structure
	 * 
	 * @param cls1
	 *            first class containing references to compare
	 * @param cls2
	 *            second class containing references to compare
	 * @return a float value between 1 and 0. 1 is perfect match and 0
	 *         completely different
	 * 
	 */
	private float structRefCompare(CD_Class cls1, CD_Class cls2) {
		// report.startRoutine("structural references");
		try {
			List<CD_Reference> refList1 = cls1.getReferences();
			List<CD_Reference> refList2 = cls2.getReferences();

			// If both classes do not hav any references return 1
			// This allows comparison to be continued on the basis of matched
			// attributes and methods
			if (refList1.size() == 0 && refList2.size() == 0)
				return 1;

			float refScore = 0;

			for (CD_Reference reference1 : refList1) {
				for (CD_Reference reference2 : refList2) {
					// Compare if the referenced class is same
					if (this.compareNames(reference1.getReferenceTypeName(),
							reference2.getReferenceTypeName()) > 0) {
						String refName1 = reference1.getReferenceTypeName().toString();
						String refName2 = reference1.getReferenceTypeName().toString();

						// Check if the relationship name is same
						if (this.compareNames(refName1, refName2) == 2) {
							report.addToReport("Reference match "
									+ reference1.getReferenceName());
							reportText += "Reference match "
									+ reference1.getReferenceName() + "\n\n";
							refScore += 1;
						}
					}
				}
			}
			// Return a percentage of the matched references
			if (refList1.size() != 0)
				return refScore / refList1.size();
			return refScore;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// report.terminateRoutine("Structural references");
		}
		return 0;
	}

	/**
	 * Add classes to the list of compared classes
	 * 
	 * @param cls1
	 *            first class that was compared
	 * @param cls2
	 *            second class that was compared
	 */
	private void listComparedClasses(CD_Class cls1, CD_Class cls2) {
		if (!comparedClasses.contains(cls1.getClassName()))
			comparedClasses.add(cls1.getClassName());
		if (!comparedClasses.contains(cls2.getClassName()))
			comparedClasses.add(cls2.getClassName());
	}

	/**
	 * Add to report the list of unmatched classes by seperating the classes
	 * already present in matched classes
	 */
	private void reportUnmatchedClasses() {
		
		report.addToReport("Unmatched Classes: ");
		reportText += "Unmatched Classes: \n\n";
		for (int i = 0; i < comparedClasses.size(); i++) {
			if (!matchedClasses.contains(comparedClasses.get(i))) {
				report.addToReport(comparedClasses.get(i));
				reportText += comparedClasses.get(i) + "\n\n";
			}
		}
	}
	
	/*
	 * The aloneClasses list that might be useful
	 * 
	 * private void setAloneClasses(){
	 * 		for(int i = 0; i < comparedClasses.size(); i++) {
	 * 			if(!matchedClasses.contains(comparedClasses.get(i)) 
	 * 				&& !similarClasses.contains(comparedClasses.get(i))){
	 * 					aloneClasses.add(comparedClasses.get(i));
	 * 			}
	 * 		}
	 * }
	 */
}
