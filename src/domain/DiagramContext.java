package domain;

public class DiagramContext {
	
	private int diagramContextID;
	private String diagramContextName;
	private String diagramContextDescripttion;
	private int policyID;
	private int projectID;
	private String enabled;
	private String disabledDate;
	
	public int getDiagramContextID() {
		return diagramContextID;
	}
	
	public void setDiagramContextID(int diagramContextID) {
		this.diagramContextID = diagramContextID;
	}
	
	public String getDiagramContextName() {
		return diagramContextName;
	}
	
	public void setDiagramContextName(String diagramContextName) {
		this.diagramContextName = diagramContextName;
	}
	
	public String getDiagramContextDescripttion() {
		return diagramContextDescripttion;
	}
	
	public void setDiagramContextDescripttion(String diagramContextDescripttion) {
		this.diagramContextDescripttion = diagramContextDescripttion;
	}
	
	public int getPolicyID() {
		return policyID;
	}
	
	public void setPolicyID(int policyID) {
		this.policyID = policyID;
	}
	
	public int getProjectID() {
		return projectID;
	}
	
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	/**
	 * @return the enabled
	 */
	public String getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the disabledDate
	 */
	public String getDisabledDate() {
		return disabledDate;
	}

	/**
	 * @param disabledDate the disabledDate to set
	 */
	public void setDisabledDate(String disabledDate) {
		this.disabledDate = disabledDate;
	}	

}
