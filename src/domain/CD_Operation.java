package domain;

import org.eclipse.emf.ecore.EOperation;


public class CD_Operation {
	
	private String operationName;
	private String returnType;
	
	public CD_Operation(EOperation e_operation) {
		
		this.operationName = e_operation.getName();
		this.returnType = e_operation.getEType().getName();
	}

}
