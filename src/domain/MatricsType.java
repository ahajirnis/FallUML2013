package domain;


/**
 * 
 * @author Jiayuan Song
 *
 */
public enum MatricsType {
	NOTDEFINED (0),
	ASSOCIATIONS (1),
	MULTIPLICITIES (2),
	ATTRIBUTES (3),
	CLASSES (4);
	
	private int mTypeId;
	MatricsType(int matricsTypeId){
		this.mTypeId = matricsTypeId;
	}
	
	
	public static MatricsType fromString(String string) {
		if(string == null)
			return NOTDEFINED;
        for (MatricsType mt : values() ){
            if (mt.toString().equals(string)) return mt;
        }
        return null;
    }
	public static MatricsType fromInt(int value) {

        for (MatricsType mt : values() ){
            if (mt.mTypeId == value) return mt;
        }
        return null;
    }
}
