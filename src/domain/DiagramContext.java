package domain;

import org.joda.time.DateTime;


/**
 * 
 * @author Aniket Hajirnis
 *
 */
public class DiagramContext 
{
	private int diagramContextId;
	private String description;
	private String name;
	private int policyId;
	private int projectId;
	private boolean enabled;
	private DateTime disabledDate;
	
	 

	public DiagramContext (int diagramContextId, String name, String description, int policyId,

	                int projectId)

	{

	this.diagramContextId = diagramContextId;

	this.name = name;

	this.description = description;

	this.policyId = policyId;

	this.projectId = projectId;

	 

	}

	 

	public DiagramContext()

	{

	}

	
	
	
	/**
	 * @return the diagramContextId
	 */
	public int getDiagramContextId() {
		return diagramContextId;
	}
	/**
	 * @param diagramContextId the diagramContextId to set
	 */
	public void setDiagramContextId(int diagramContextId) {
		this.diagramContextId = diagramContextId;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the policyId
	 */
	public int getPolicyId() {
		return policyId;
	}
	/**
	 * @param policyId the policyId to set
	 */
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	/**
	 * @return the projectId
	 */
	public int getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}
	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	/**
	 * @return the disabledDate
	 */
	public DateTime getDisabledDate() {
		return disabledDate;
	}
	/**
	 * @param disabledDate the disabledDate to set
	 */
	public void setDisabledDate(String disabledDate) {		
		this.disabledDate = new DateTime(disabledDate);
	}

}
