package domain;

/**
 * Information class that contains all the features of one project
 * @ doc author	Dong Guo
 */

public class Project {

	private String projectId;
	private String projectName;
	private String description;
	private byte achived = 0;// Default
	private String startDate;
	private String enabled;
	private String disabledDate;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * Constructor to initialize necessary class members
	 *
	 * @param projectName
	 * 			The name of the project
	 */
	public Project(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * Constructor to initialize necessary class members
	 *
	 * @param projectId
	 * 			The ID of the project
	 * @param projectName
	 * 			The name of the project 
	 * @param description
	 * 			The description of the project			
	 * @param achived
	 * 			This value indicates whether the project is achived or not
	 */
	public Project(String projectId, String projectName, String description,
			byte achived) { 
		this.projectId = projectId;
		this.projectName = projectName;
		this.description = description;
		this.achived = achived;
	}
	

	
	/**
	 * 
	 * @param projectId
	 * @param projectName
	 * @param description
	 * @param startDate
	 * @param enabled
	 * @param disabledDate
	 */
	public Project(String projectId, String projectName, String description, String startDate,
			String enabled, String disabledDate) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.description = description;
		this.startDate = startDate;
		this.setEnabled(enabled);
		this.setDisabledDate(disabledDate);
	}
	

	/**
	 * Constructor to initialize necessary class members
	 *
	 * @param projectId
	 * 			The ID of the project
	 * @param projectName
	 * 			The name of the project 
	 * @param description
	 * 			The description of the project			
	 * @param startDate
	 * 			The startDate of this project
	 */
	public Project(String projectId, String projectName, String description,
			String startDate) {
		
		this.projectId = projectId;
		this.projectName = projectName;
		this.description = description;
		this.startDate = startDate;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gete the projectId
	 * 
	 * @return projectId int
	 */
	public String getProjectId() {
		return projectId;
	}
	
	/**
	 * Set projectId
	 * 
	 * @param projectId
	 * 			The ID of the project
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	/**
	 * Gete the projectName
	 * 
	 * @return projectName String
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * Set projectName
	 * 
	 * @param projectName
	 * 			The name of the project
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * Gete the description
	 * 
	 * @return description String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set description
	 * 
	 * @param description
	 * 			The description of the project
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Gete the achived
	 * 
	 * @return achived byte
	 */
	public byte isAchived() {
		return achived;
	}

	/**
	 * Set achived
	 * 
	 * @param achived
	 * 			It indicates whether the project is achived or not.
	 */
	public void setAchived(byte achived) {
		this.achived = achived;
	}

	public String getDisabledDate() {
		return disabledDate;
	}

	public void setDisabledDate(String disabledDate) {
		this.disabledDate = disabledDate;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

}
