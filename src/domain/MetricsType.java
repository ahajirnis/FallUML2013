package domain;

/**
 * 
 * @author Jiayuan Song
 *
 */
public enum MetricsType {
	ASSOCIATIONS (1),
	MULTIPLICITIES (2),
	ATTRIBUTES (3),
	CLASSES (4);
	
	private int mTypeId;
	MetricsType(int matricsTypeId){
		this.mTypeId = matricsTypeId;
	}
	
	
	public static MetricsType fromString(String string) {
        for (MetricsType mt : values() ){
            if (mt.toString().equals(string)) return mt;
        }
        return null;
    }
}
