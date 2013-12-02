package domain;

public class DiagramPolicyScore {
	
	private int diagramID;
	private int policyID;
	private int policyScore;
	private String justification;
	
	
//	public DiagramPolicyScore(Diagram diagram, Policy policy) {
//		super();
//		this.diagramID = diagram.getDiagramId();
//		this.policyID = policy.getPolicyID();
//		//this.policyScore = policyScore;
//		//this.justification = justification;
//	}

	public int getDiagramID() {
		return diagramID;
	}
	
	public void setDiagramID(int diagramID) {
		this.diagramID = diagramID;
	}
	
	public int getPolicyID() {
		return policyID;
	}
	
	public void setPolicyID(int policyID) {
		this.policyID = policyID;
	}
	
	public int getPolicyScore() {
		return policyScore;
	}
	
	public void setPolicyScore(int policyScore) {
		this.policyScore = policyScore;
	}
	
	public String getJustification() {
		return justification;
	}
	
	public void setJustification(String justification) {
		this.justification = justification;
	}
	

}
