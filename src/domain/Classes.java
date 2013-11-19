package domain;

/**
 * 
 * @author Jiayuan Song
 *
 */
public class Classes extends Metrics {
	private int metricId;
	private int idealNoOfClasses;
	private int maxNoOfClasses;
	private int minNoOfClasses;
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
	 * @return the idealNoOfClasses
	 */
	public int getIdealNoOfClasses() {
		return idealNoOfClasses;
	}
	/**
	 * @param idealNoOfClasses the idealNoOfClasses to set
	 */
	public void setIdealNoOfClasses(int idealNoOfClasses) {
		this.idealNoOfClasses = idealNoOfClasses;
	}
	/**
	 * @return the maxNoOfClasses
	 */
	public int getMaxNoOfClasses() {
		return maxNoOfClasses;
	}
	/**
	 * @param maxNoOfClasses the maxNoOfClasses to set
	 */
	public void setMaxNoOfClasses(int maxNoOfClasses) {
		this.maxNoOfClasses = maxNoOfClasses;
	}
	/**
	 * 
	 * @return minNoOfClasses
	 */
	
	public int getMinNoOfClasses(){
		return minNoOfClasses;
	}
	/**
	 * 
	 * @param minNoOfClasses
	 */
	
	public void setMinNoOfClasses(int minNoOfClasses){
		this.minNoOfClasses = minNoOfClasses;
	}
	
	
}
