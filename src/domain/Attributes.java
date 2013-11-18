package domain;

/**
 * 
 * @author Jiayuan Song
 *
 */
public class Attributes extends Metrics {
	private int metricsId;
	private int averagePointOver;
	private int idealNoOfAttributes;
	private int maxNoOfAttributes;
	/**
	 * @return the matricsId
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
	 * @return the averagePointOver
	 */
	public int getAveragePointOver() {
		return averagePointOver;
	}
	/**
	 * @param averagePointOver the averagePointOver to set
	 */
	public void setAveragePointOver(int averagePointOver) {
		this.averagePointOver = averagePointOver;
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
	
	
}

