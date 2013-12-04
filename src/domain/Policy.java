package domain;

import java.util.ArrayList;
import java.util.Iterator;

public class Policy {
	
	private int policyID;
	private String policyName;
	private String policyDescription;
	private int policyLevel;
	private ArrayList<Metrics> metrics;
	
	public Policy (){
		metrics = new ArrayList<Metrics>();
	}
	
	public ArrayList<Metrics> getMetrics() {
		return metrics;
	}

	public void setmetrics(ArrayList<Metrics> metrics) {
		this.metrics= metrics;
	}

	public void addNewMatric(Metrics Metrics){
		this.metrics.add(Metrics);
	}
	public void removeMatric(int id){
		
		Iterator<Metrics> i = metrics.iterator();
		while (i.hasNext()) {
			Metrics mObject = i.next(); 
			if(mObject.getMetricId() == id)
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
