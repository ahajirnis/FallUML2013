package domain;

/**
 * 
 * @author Jiayuan Song
 *
 */
public enum MatricsType {
	ASSOCIATIONS (1),
	MULTIPLICITIES (2),
	ATTRIBUTES (3),
	CLASSES (4);
	
	private int mTypeId;
	MatricsType(int matricsTypeId){
		this.mTypeId = matricsTypeId;
	}
	
	
	public static MatricsType fromString(String string) {
        for (MatricsType mt : values() ){
            if (mt.toString().equals(string)) return mt;
        }
        return null;
    }
}
