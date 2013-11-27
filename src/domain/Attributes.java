package domain;

/**
 * 
 * @author Jiayuan Song
 *
 */
public class Attributes extends MatricsObject {
	private int matricsId;
	private int averagePointOver;
	private int idealNoOfAttributes;
	private int maxNoOfAttributes;
	private int minNoOfAttributes;
	
	public int getMinNoOfAttributes() {
		return minNoOfAttributes;
	}
	public void setMinNoOfAttributes(int minNoOfAttributes) {
		this.minNoOfAttributes = minNoOfAttributes;
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

