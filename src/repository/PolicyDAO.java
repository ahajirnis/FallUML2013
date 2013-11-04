package repository;

/**
 * @author weiqi kong
 * @author 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Policy;
import domain.User;

public class PolicyDAO {

    public final static String Policy_NAME = "ClubUML";
    public final static String Policy_Desc = "ClubUML First Policy";
    public final static String Policy_Level = "1";

    
  

    /**
     * Add our default Policy into DB (policyName, policyDescription,policyLevel)
     * 			
     * @param conn
     * 			Established connection
     * @return true if success; false if fail
     */
    public static boolean addPolicy(Policy policy) {
    	
	try {
		Connection conn = DbManager.getConnection();
		
	    PreparedStatement pstmt = conn.prepareStatement(
		    "INSERT into policy(policyName, policyDescription,policyLevel) VALUES(?,?,?);");
	    pstmt.setString(1, policy.getPolicyName());
		pstmt.setString(2, policy.getPolicyDescription());
		pstmt.setInt(3, policy.getPolicyLevel());
		

	    // Execute the SQL statement and update database accordingly.
	    pstmt.executeUpdate();
	    pstmt.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}
	return true;
    }
    
    
    
    
    /**
     * Update our default Policy into DB (policyName, policyDescription,policyLevel)
     * 			
     * @param conn
     * 			Established connection
     * @return true if success; false if fail
     */
    
    
    
    
    
    public static boolean UpdatePolicy(Policy policy) {
    	try {
    		
    		Connection conn = DbManager.getConnection();
    	    PreparedStatement pstmt = conn.prepareStatement(
    		    "UPDATE policy SET policyName=?,policyDescription=?,policyLevel=? WHERE policyID=?;");
    	    pstmt.setString(1, policy.getPolicyName());
			pstmt.setString(2, policy.getPolicyDescription());
			pstmt.setInt(3, policy.getPolicyLevel());
			pstmt.setInt(4, policy.getPolicyID());
			

    	    // Execute the SQL statement and update database accordingly.
    	    pstmt.executeUpdate();
    	    pstmt.close();
    	} catch (SQLException e) {
    	    e.printStackTrace();
    	    return false;
    	}
    	return true;
        }

    /**
     * Remove a Policy from DB
     * 
     * @return true if success; false if fail  
     */
    public static boolean removePolicy(int policyID) {
		
		try {
			Connection conn = DbManager.getConnection();
			PreparedStatement pstmt = conn
					.prepareStatement("DELETE FROM Policy where policyID = ?;");
			pstmt.setInt(1, policyID );

			// Execute the SQL statement and update database accordingly.
			pstmt.executeUpdate();

			pstmt.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			throw new IllegalArgumentException(e.getMessage(), e);
		}
	}
}
