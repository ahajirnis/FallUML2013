package domain;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;

import controller.comparer.xmi.XmiAttributeElement;
import controller.comparer.xmi.XmiClassElement;

public class CD_Class {
	
	private String className;
	private List<CD_Attribute> attributes;
	private List<CD_Operation> operations;
	private List<CD_Reference> references;
	private List<CD_Class> superClasses;
	

	public CD_Class(XmiClassElement xmiClass){
		
		attributes = new ArrayList<CD_Attribute>();
		operations = new ArrayList<CD_Operation>();
		references = new ArrayList<CD_Reference>();
		
		className = xmiClass.getName();
		for(XmiAttributeElement eAttribute : xmiClass.getAttributes())
		{
			CD_Attribute attr = new CD_Attribute(eAttribute);
			attributes.add(attr);
		}
		
	}
	
	public CD_Class(EClass ecoreClass){
		
		attributes = new ArrayList<CD_Attribute>();
		operations = new ArrayList<CD_Operation>();
		references = new ArrayList<CD_Reference>();
		superClasses = new ArrayList<CD_Class>();
		className = ecoreClass.getName();
		
		for(EAttribute eAttribute : ecoreClass.getEAttributes())
		{
			CD_Attribute attr = new CD_Attribute(eAttribute);
			attributes.add(attr);
		}
		
		for( EOperation eOperation : ecoreClass.getEAllOperations())
		{
			CD_Operation op = new CD_Operation(eOperation);
			operations.add(op);
		}
		
		for( EReference eReference : ecoreClass.getEAllReferences())
		{
			CD_Reference ref = new CD_Reference(eReference);
			references.add(ref);
		}
		
		for(EClass superClass : ecoreClass.getESuperTypes())
		{
			superClasses.add(new CD_Class(superClass));
		}
		
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public List<CD_Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<CD_Attribute> attributes) {
		this.attributes = attributes;
	}

	public List<CD_Class> getSuperClasses() {
		return superClasses;
	}

	public void setSuperClasses(List<CD_Class> superClasses) {
		this.superClasses = superClasses;
	}

	public List<CD_Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<CD_Operation> operations) {
		this.operations = operations;
	}

	public List<CD_Reference> getReferences() {
		return references;
	}

	public void setReferences(List<CD_Reference> references) {
		this.references = references;
	}
	
	
}
