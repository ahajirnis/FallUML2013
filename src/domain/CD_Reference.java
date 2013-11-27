package domain;

import org.eclipse.emf.ecore.EReference;

public class CD_Reference {
	
	private String referenceName;
	private String referenceTypeName;

	public CD_Reference(EReference eReference) {
		
		this.referenceName = eReference.getName();
		this.referenceTypeName = eReference.getEType().getName();
	}

	public String getReferenceName() {
		return referenceName;
	}

	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}

	public String getReferenceTypeName() {
		return referenceTypeName;
	}

	public void setReferenceTypeName(String referenceType) {
		this.referenceTypeName = referenceType;
	}

}
