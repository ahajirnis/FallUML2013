package domain;

/**
 * 
 * @author Jiayuan Song
 *
 */
public class Attributes extends MatricsObject {
	
	private int averagePointOver;
	private int idealNoOfAttributes;
	private int maxNoOfAttributes;
	private int minNoOfAttributes;
	
	public Attributes()
	{
		super();
	}
	
	public int getMinNoOfAttributes() {
		return minNoOfAttributes;
	}
	public void setMinNoOfAttributes(int minNoOfAttributes) {
		this.minNoOfAttributes = minNoOfAttributes;
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

