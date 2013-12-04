package domain;

import java.util.ArrayList;
import java.util.Iterator;

public class Policy {
	
	private int policyID;
	private String policyName;
	private String policyDescription;
	private int policyLevel;
	private ArrayList<MatricsObject> matricsObjects;
	
	public Policy (){
		matricsObjects = new ArrayList<MatricsObject>();
	}
	
	public ArrayList<MatricsObject> getMatricsObjects() {
		return matricsObjects;
	}

	public void setMatricsObjects(ArrayList<MatricsObject> matricsObjects) {
		this.matricsObjects = matricsObjects;
	}

	public void addNewMatric(MatricsObject matricsObject){
		this.matricsObjects.add(matricsObject);
	}
	public void removeMatric(int id){
		
		Iterator<MatricsObject> i = matricsObjects.iterator();
		while (i.hasNext()) {
			MatricsObject mObject = i.next(); 
			if(mObject.getMatricsId() == id)
			{
				i.remove();
			}
		}
		
	}
	
	public int getPolicyID() {
		return policyID;
	}
	
	public void setPolicyID(int policyID) {
		this.policyID = policyID;
	}
	
	public String getPolicyName() {
		return policyName;
	}
	
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	
	public String getPolicyDescription() {
		return policyDescription;
	}
	
	public void setPolicyDescription(String policyDescription) {
		this.policyDescription = policyDescription;
	}
	
	public int getPolicyLevel() {
		return policyLevel;
	}
	
	public void setPolicyLevel(int policyLevel) {
		this.policyLevel = policyLevel;
	}
	

}
