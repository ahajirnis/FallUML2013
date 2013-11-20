package domain;

import org.eclipse.emf.ecore.EOperation;


public class CD_Operation {
	
	private String operationName;
	private String returnType;
	
	public CD_Operation(EOperation e_operation) {
		
		this.operationName = e_operation.getName();
		this.returnType = e_operation.getEType().getName();
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

}
