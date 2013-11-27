package domain;

/**
 * 
 * @author Jiayuan Song
 *
 */
public class Attributes extends Metrics {
	private int metricId;
	private int idealNoOfAttributes;
	private int maxNoOfAttributes;
	private int minNoOfAttributes;
	/**
	 * @return the metricId
	 */
	public int getMetricId() {
		return metricId;
	}
	/**
	 * @param metricId the metricId to set
	 */
	public void setMetricId(int metricId) {
		this.metricId = metricId;
	}
	
	/**
	 * @return the idealNoOfAttributes
	 */
	public int getIdealNoOfAttributes() {
		return idealNoOfAttributes;
	}
	/**
	 * @param idealNoOfAttributes the idealNoOfAttributes to set
	 */
	public void setIdealNoOfAttributes(int idealNoOfAttributes) {
		this.idealNoOfAttributes = idealNoOfAttributes;
	}
	/**
	 * @return the maxNoOfAttributes
	 */
	public int getMaxNoOfAttributes() {
		return maxNoOfAttributes;
	}
	/**
	 * @param maxNoOfAttributes the maxNoOfAttributes to set
	 */
	public void setMaxNoOfAttributes(int maxNoOfAttributes) {
		this.maxNoOfAttributes = maxNoOfAttributes;
	}
	/**
	 * 
	 * @return minNoOfAttributes
	 */
	public int getMinNoOfAttributes(){
		return minNoOfAttributes;
	}
	/**
	 * 
	 * @param minNoOfAttributes the minimum # of attributes
	 */
	
	public void setMinNoOfAttributes(int minNoOfAttributes){
		this.minNoOfAttributes = minNoOfAttributes;
	}
	
	
}

