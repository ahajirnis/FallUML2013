package domain;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;


public class CD_Attribute {
	
	private String attrName;
	private EDataType attrType;

	public CD_Attribute(EAttribute e_attribute) {
		this.attrName = e_attribute.getName();
		this.attrType = e_attribute.getEAttributeType();
	}

}
