package domain;


/**
 * 
 * @author Jiayuan Song
 *
 */
public enum MetricsType {
	NOTDEFINED (0),
	ASSOCIATIONS (1),
	MULTIPLICITIES (2),
	ATTRIBUTES (3),
	CLASSES (4);
	
	private int mTypeId;
	MetricsType(int metricsTypeId){
		this.mTypeId = metricsTypeId;
	}
	
	
	public static MetricsType fromString(String string) {
        for (MetricsType mt : values() ){
            if (mt.toString().equals(string)) return mt;
        }
        return null;
    }
	public static MetricsType fromInt(int value) {

        for (MetricsType mt : values() ){
            if (mt.mTypeId == value) return mt;
        }
        return null;
    }
}
