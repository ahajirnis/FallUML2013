package domain;

public enum PolicyLevelType {
	PROJECT (1),
	CONTEXT (2),
	USER(3);

	private int dTypeId;
	PolicyLevelType(int policyLevelTypeId){
		this.dTypeId = policyLevelTypeId;
	}
	
	
	public static PolicyLevelType fromString(String string) {
        for (PolicyLevelType pt : values() ){
            if (pt.toString().equals(string)) return pt;
        }
        return null;
    }
}
