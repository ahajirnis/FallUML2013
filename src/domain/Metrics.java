package domain;

/**
 * 
 * @author Jiayuan Song
 *
 */
public class Metrics {
	private int metricsId;
	private int metricsTypeId;
	private int metricsWeight;
	private int policyId;
	private MetricsType metricsType;
	/**
	 * @return the metricsId
	 */
	public int getMetricsId() {
		return metricsId;
	}
	/**
	 * @param metricsId the metricsId to set
	 */
	public void setMetricsId(int metricsId) {
		this.metricsId = metricsId;
	}
	/**
	 * @return the metricsTypeId
	 */
	public int getMetricsTypeId() {
		return metricsTypeId;
	}
	/**
	 * @param metricsTypeId the metricsTypeId to set
	 */
	public void setMetricsTypeId(int metricsTypeId) {
		this.metricsTypeId = metricsTypeId;
	}
	/**
	 * @return the matricsWeight
	 */
	public int getMetricsWeight() {
		return metricsWeight;
	}
	/**
	 * @param metricsWeight the metricsWeight to set
	 */
	public void setMetricsWeight(int metricsWeight) {
		this.metricsWeight = metricsWeight;
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
	
	public MetricsType getMetricsType(){
		return metricsType;
	}
	
	public void setMetricsType(MetricsType metricsType){
		this.metricsType = metricsType;
	}
	
}
