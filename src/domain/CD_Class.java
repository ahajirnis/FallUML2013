package domain;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;

import controller.comparer.xmi.XmiClassElement;

public class CD_Class {
	
	private String className;
	private List<CD_Attribute> attributes;
	private List<CD_Operation> operations;
	private List<CD_Reference> references;
	

	public CD_Class(XmiClassElement xmiClass){
		
		className = xmiClass.getName();
		
	}
	
	public CD_Class(EClass ecoreClass){
		
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
	
	
}
