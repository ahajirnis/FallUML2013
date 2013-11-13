package domain;


/**
 * @author gauta_001
 * Diagram type enum to identify different diagram types supported. THis will help eliminate hardcoding of diagram types.
 */

public enum DiagramType {
	NOTDEFINED (0),
	CLASS (1),
	SEQUENCE (2),
	ACTIVITY(3),
	STATE(4);

	private int dTypeId;
	DiagramType(int diagramTypeId){
		this.dTypeId = diagramTypeId;
	}
	
	
	public static DiagramType fromString(String string) {
		if(string == null)
			return NOTDEFINED;
        for (DiagramType dt : values() ){
            if (dt.toString().equals(string)) return dt;
        }
        return null;
    }
	public static DiagramType fromInt(int value) {

        for (DiagramType mt : values() ){
            if (mt.dTypeId == value) return mt;
        }
        return null;
    }
}
