package domain;

import java.util.List;

import controller.comparer.xmi.XmiClassElement;

public class CD_Class {
	
	private String className;
	private List<CD_Attribute> attributes;
	

	public CD_Class(XmiClassElement xmiClass){
		
		className = xmiClass.getName();
		
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
