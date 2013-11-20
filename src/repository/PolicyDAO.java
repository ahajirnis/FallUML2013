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

    /**
     * Add Policy into DB 
     * 			
     * @param policy
     */
    public static Policy addPolicy(Policy policy) {
    	ResultSet rs;
	try {
		Connection conn = DbManager.getConnection();		
	    PreparedStatement pstmt = conn.prepareStatement(
		    "INSERT into policy(policyName, policyDescription,policyLevel) VALUES(?,?,?);");
	    pstmt.setString(1, policy.getPolicyName());
		pstmt.setString(2, policy.getPolicyDescription());
		pstmt.setInt(3, policy.getPolicyLevel());
		
	    // Execute the SQL statement and update database accordingly.
	    pstmt.executeUpdate();
	    rs = pstmt.getGeneratedKeys();
	    if (rs.next()) {
		int newId = rs.getInt(1);
		policy.setPolicyID(newId);
	    }
	    pstmt.close();
	    rs.close();
	    conn.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	    return null;
	}
	return policy;
    }
     
    /**
     * Update  Policy into DB 
     * 			
     * @param policy
     */    
    public static Policy UpdatePolicy(Policy policy) {
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
    	    conn.close();
    	} catch (SQLException e) {
    	    e.printStackTrace();
    	    return policy;
    	}
    	return policy;
        }

    /**
     * Remove a Policy from DB
     * 
     * @param policyID  
     */
    public static boolean deletePolicy(int policyID) {
		
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
