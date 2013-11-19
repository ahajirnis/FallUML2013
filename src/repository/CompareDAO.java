package repository;
/**
 * @author weiqi kong
 * @author 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Compare;
import domain.Policy;
import domain.Project;
    public class CompareDAO {
	
	
	    /**
	     * Add Compare into DB 
	     * 			
	     * @param compare
	     */
	    public static Compare addCompare(Compare compare) {
	    	ResultSet rs;
	    	if (ser)
		try {
			Connection conn = DbManager.getConnection();		
		    PreparedStatement pstmt = conn.prepareStatement(
			    "insert into compare(diagramAId, diagramBId, reportId, promoteCountA,promoteCountB) values (?,?,?,?,?);");
		    pstmt.setInt(1, compare.getDiagramAId());
			pstmt.setInt(2, compare.getDiagramBId());
			pstmt.setInt(3, compare.getReportId());
			pstmt.setDouble(4, compare.getPromoteCountA());
			pstmt.setDouble(5, compare.getPromoteCountB());
			
		    // Execute the SQL statement and update database accordingly.
		    pstmt.executeUpdate();
		    rs = pstmt.getGeneratedKeys();
		    if (rs.next()) {
			int newId = rs.getInt(1);
			compare.setCompareId(newId);
		    }
		    pstmt.close();
		    rs.close();
		    conn.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		    return null;
		}
		return compare;
	    }
	     
	    /**
	     * Update Compare into DB 
	     * 			
	     * @param compare
	     */    
	 
	    public static boolean updateCompare(Compare compare) {
			
			try {
				Connection conn = DbManager.getConnection();
				PreparedStatement pstmt = conn
						.prepareStatement("UPDATE compare SET diagramAId=?,diagramBId=?,reportId=?, promoteCountA=? ,promoteCountB=? WHERE compareID=?;");
				pstmt.setInt(1, compare.getDiagramAId());
				pstmt.setInt(2, compare.getDiagramBId());
				pstmt.setInt(3, compare.getReportId());
				pstmt.setDouble(4, compare.getPromoteCountA());
				pstmt.setDouble(5, compare.getPromoteCountB());
				pstmt.setInt(6, compare.getCompareId());

				// Execute the SQL statement and update database accordingly.
				pstmt.executeUpdate();

				pstmt.close();
				conn.close();
				return true;
			} catch (SQLException e) {
				throw new IllegalArgumentException(e.getMessage(), e);
			}
		}
	    
	    /**
	     * Search Compare into DB 
	     * 			
	     * @param compare
	     */
	    
	    public static Compare searchCompare(int diagramAId,int diagramBId) {
	    	Compare compare = null;
	    	
	    	try {
	    		
	    		Connection conn = DbManager.getConnection();
	    	    PreparedStatement pstmt = conn.prepareStatement(
	    		    "SELECT * FROM clubuml.compare WHERE (diagramAId=? and diagramBId = ?) or (diagramAId = ? and diagramBId = ?) ;");
	    	    pstmt.setInt(1, diagramAId);
				pstmt.setInt(2, diagramBId);
				pstmt.setInt(3, diagramBId);
				pstmt.setInt(4, diagramAId);
				
			    // Execute the SQL statement 
				ResultSet rs = pstmt.executeQuery();
	    	    if (rs.next()) {
	    	    	compare = new Compare();
	    	    	compare.setCompareId(rs.getInt("compareId"));
	    	    	compare.setCompareId(rs.getInt("diagramAId"));
	    	    	compare.setCompareId(rs.getInt("compareId"));
	    	    }
    			rs.getString("diagramAId"),rs.getString("diagramBId"),
    			rs.getString("reportId"),rs.getString("promoteCountA"),rs.getString("promoteCountB")
	    	    return compare;
				
	    	    pstmt.close();
	    	    conn.close();
	    	} catch (SQLException e) {
	    	    e.printStackTrace();
	    	    return null;
	    	}
	    	return compare;
	        }
	    
	    
	    
	    
	}

	
	


