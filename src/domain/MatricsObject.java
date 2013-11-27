package domain;

/**
 * 
 * @author Jiayuan Song
 *
 */
public class MatricsObject {
	private int matricsId;
	private MatricsType matricsType;
	private int matricsWeight;
	private int policyId;
	
	
	
	
	public MatricsType getMatricsType() {
		return matricsType == null? MatricsType.NOTDEFINED: matricsType;
	}
	public void setMatricsType(MatricsType matricsType) {
		
		this.matricsType = matricsType;
	}
	/**
	 * @return the matricsId
	 */
	public int getMatricsId() {
		return matricsId;
	}
	/**
	 * @param matricsId the matricsId to set
	 */
	public void setMatricsId(int matricsId) {
		this.matricsId = matricsId;
	}
	
	/**
	 * @return the matricsWeight
	 */
	public int getMatricsWeight() {
		return matricsWeight;
	}
	/**
	 * @param matricsWeight the matricsWeight to set
	 */
	public void setMatricsWeight(int matricsWeight) {
		this.matricsWeight = matricsWeight;
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
	
	
	
}
