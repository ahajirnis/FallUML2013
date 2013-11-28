package domain;

/**
 * 
 * @author Jiayuan Song
 *
 */
public class Classes extends MatricsObject {
	
	private int idealNoOfClasses;
	private int maxNoOfClasses;
	private int totalClassMaxPoints;
	private int minNoOfClasses;
	
	public Classes(){
		super();
	}
	
	public int getMinNoOfClasses() {
		return minNoOfClasses;
	}
	public void setMinNoOfClasses(int minNoOfClasses) {
		this.minNoOfClasses = minNoOfClasses;
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
	 * @return the totalClassMaxPoints
	 */
	public int getTotalClassMaxPoints() {
		return totalClassMaxPoints;
	}
	/**
	 * @param totalClassMaxPoints the totalClassMaxPoints to set
	 */
	public void setTotalClassMaxPoints(int totalClassMaxPoints) {
		this.totalClassMaxPoints = totalClassMaxPoints;
	}
	
	
	
}
