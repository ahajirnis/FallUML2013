package domain;

 

public class DiagramContext {

 

private int diagramContextID;

private String diagramContextName;

private String diagramContextDescription;

private int policyID;

private int projectID;
private boolean enabled;
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

 

public String getDiagramContextDescription() {

return diagramContextDescription;

}

 

public void setDiagramContextDescription(String diagramContextDescription) {

this.diagramContextDescription = diagramContextDescription;

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


 

public DiagramContext (int diagramContextID, String diagramContextName, String diagramContextDescription, int policyID,

                int projectID)

{

this.diagramContextID = diagramContextID;

this.diagramContextName = diagramContextName;

this.diagramContextDescription = diagramContextDescription;

this.policyID = policyID;

this.projectID = projectID;

 

}

 

public DiagramContext()

{

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



/**
 * @return the enabled
 */
public boolean getEnabled() {
	return enabled;
}



/**
 * @param enabled the enabled to set
 */
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}

 

}

 

 

 

 
