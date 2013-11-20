package domain;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;

import controller.comparer.xmi.XmiAttributeElement;


public class CD_Attribute {
	
	private String attrName;
	private String attrType;
//	private EDataType attrType;

	public CD_Attribute(EAttribute eAttribute) {
		this.attrName = eAttribute.getName();
		this.attrType = eAttribute.getEAttributeType().getName();
	}

	public CD_Attribute(XmiAttributeElement eAttribute) {
		this.attrName = eAttribute.getName();
		this.attrType = eAttribute.getTypeName();
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getAttrType() {
		return attrType;
	}

	public void setAttrType(String attrType) {
		this.attrType = attrType;
	}
	

}
