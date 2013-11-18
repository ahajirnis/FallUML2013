package repository;

/**
 * Data Access Object to interact with the database to add, retrieve, update, delete 
 * Metrics data and its sub-classes (Associations, Attributes, Multiplicities, Classes)
 * @author Seth Lee
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import domain.Metrics;
import domain.Associations;
import domain.Attributes;
import domain.MetricsType;
import domain.Multiplicities;
import domain.Classes;

public class MetricsDAO {
	
	/**
	 * 
	 * @param metrics	@see Associations
	 * @return			@see Associations
	 * @throws SQLException
	 */
	
	 public static Metrics addMetrics(Associations metrics) throws SQLException {

		 Metrics metricsReturn = null;
		 
	     Connection conn = null;

	     PreparedStatement pstmt = null;
	     
	     PreparedStatement lastIdStatement = null;
	     
	     ResultSet lastIdResult = null;
	     
	     int newMetricsId = 0;
	     
	     String getLastIdString = "SELECT LAST_INSERT_ID();";

	     try {

	      conn = DbManager.getConnection();

	      		
	      		pstmt = conn.prepareStatement(

	     	           "INSERT into metrics(metricsTypeID, metricsWeight, policyID) VALUES(?,?,?,?);");

	     	         pstmt.setInt(1, metrics.getMetricsTypeId());

	     	         pstmt.setInt(2, metrics.getMetricsWeight());
	     	         
	     	         pstmt.setInt(3, metrics.getPolicyId());
	     	         
	     	     pstmt.executeUpdate();
	     	     
	     	     lastIdStatement = conn.prepareStatement(getLastIdString);

	     	     lastIdResult = lastIdStatement.executeQuery();
	     	     
	     	     while (lastIdResult.next()){
	     	    	 newMetricsId = lastIdResult.getInt(1);
	     	     }
	     	      
	     	     metricsReturn = new Associations();
	     	     metricsReturn.setMetricsId(newMetricsId);
	     	     metricsReturn.setMetricsTypeId(metrics.getMetricsTypeId());
	     	     metricsReturn.setMetricsWeight(metrics.getMetricsWeight());
	     	     metricsReturn.setPolicyId(metrics.getPolicyId());
	     
	      		
	      		
	      
	         

	     } catch (SQLException e) {

	         e.printStackTrace();

	     } finally {

	      if( pstmt != null) {pstmt.close();}

	      if( conn != null) {conn.close();}

	     }

	     return metricsReturn;

	    }
	 /**
	  * 
	  * @param metrics	@see Attributes
	  * @return			@see Attributes
	  * @throws SQLException
	  */
	 public static Metrics addMetrics(Attributes metrics) throws SQLException {

		 Attributes metricsReturn = null;
		 
	     Connection conn = null;

	     PreparedStatement pstmt = null;
	     
	     PreparedStatement lastIdStatement = null;
	     
	     ResultSet lastIdResult = null;
	     
	     int newMetricsId = 0;
	     
	     String getLastIdString = "SELECT LAST_INSERT_ID();";

	     try {

	      conn = DbManager.getConnection();	      		
	      		
	      		pstmt = conn.prepareStatement(

		     	           "INSERT into metrics(metricsTypeID, metricsWeight, policyID) VALUES(?,?,?,?);");

		     	         pstmt.setInt(1, metrics.getMetricsTypeId());

		     	         pstmt.setInt(2, metrics.getMetricsWeight());
		     	         
		     	         pstmt.setInt(3, metrics.getPolicyId());

		     	        pstmt.executeUpdate();
			     	     
			    lastIdStatement = conn.prepareStatement(getLastIdString);

			    lastIdResult = lastIdStatement.executeQuery();
			     	     
			    	while (lastIdResult.next()){
			     	    	 newMetricsId = lastIdResult.getInt(1);
			     	}
			     	      
			    	pstmt = conn.prepareStatement(

			     	           "INSERT into Attributes(metricsId, averagePointsOver, idealNoOfAttributes, maxNoOfAttributes) VALUES(?,?,?,?);");

			     	         pstmt.setInt(1, newMetricsId);

			     	         pstmt.setInt(2, metrics.getAveragePointOver());
			     	         
			     	         pstmt.setInt(3, metrics.getIdealNoOfAttributes());
			     	         
			     	         pstmt.setInt(4, metrics.getMaxNoOfAttributes());

			     	        pstmt.executeUpdate();
		     	         
		     	 
	      	      	metricsReturn = new Attributes();
	      	      	metricsReturn.setMetricsId(newMetricsId);
	      	      	metricsReturn.setMetricsTypeId(metrics.getMetricsTypeId());
	      	      	metricsReturn.setMetricsWeight(metrics.getMetricsWeight());
	      	      	metricsReturn.setPolicyId(metrics.getPolicyId());
	      	      	metricsReturn.setAveragePointOver(metrics.getAveragePointOver());
	      	      	metricsReturn.setIdealNoOfAttributes(metrics.getIdealNoOfAttributes());
	      	      	metricsReturn.setMaxNoOfAttributes(metrics.getMaxNoOfAttributes());
	      	
	         

	     } catch (SQLException e) {

	         e.printStackTrace();

	     } finally {

	      if( pstmt != null) {pstmt.close();}

	      if( conn != null) {conn.close();}

	     }

	     return metricsReturn;

	    }
	 /**
	  * 
	  * @param metrics	@see Classes
	  * @return		    @see Classes
	  * @throws SQLException
	  */
	 
	 public static Metrics addMetrics(Classes metrics) throws SQLException {

		 Classes metricsReturn = null;
		 
	     Connection conn = null;

	     PreparedStatement pstmt = null;
	     
	     PreparedStatement lastIdStatement = null;
	     
	     ResultSet lastIdResult = null;
	     
	     int newMetricsId = 0;
	     
	     String getLastIdString = "SELECT LAST_INSERT_ID();";

	     try {

	      conn = DbManager.getConnection();	      		
	      		
	      		pstmt = conn.prepareStatement(

		     	           "INSERT into metrics(metricsTypeID, metricsWeight, policyID) VALUES(?,?,?,?);");

		     	         pstmt.setInt(1, metrics.getMetricsTypeId());

		     	         pstmt.setInt(2, metrics.getMetricsWeight());
		     	         
		     	         pstmt.setInt(3, metrics.getPolicyId());

		     	        pstmt.executeUpdate();
			     	     
			    lastIdStatement = conn.prepareStatement(getLastIdString);

			    lastIdResult = lastIdStatement.executeQuery();
			     	     
			    	while (lastIdResult.next()){
			     	    	 newMetricsId = lastIdResult.getInt(1);
			     	}
			     	      
			    	pstmt = conn.prepareStatement(

			     	           "INSERT into Classes(metricsId, idealNoOfClasses, maxNoOfClasses, minNoOfClasses) VALUES(?,?,?,?);");

			     	         pstmt.setInt(1, newMetricsId);

			     	         pstmt.setInt(2, metrics.getIdealNoOfClasses());
			     	         
			     	         pstmt.setInt(3, metrics.getMaxNoOfClasses());
			     	         
			     	         pstmt.setInt(4, metrics.getMinNoOfClasses());

			     	        pstmt.executeUpdate();
		     	         
		     	 
	      	      	metricsReturn = new Classes();
	      	      	metricsReturn.setMetricsId(newMetricsId);
	      	      	metricsReturn.setMetricsTypeId(metrics.getMetricsTypeId());
	      	      	metricsReturn.setMetricsWeight(metrics.getMetricsWeight());
	      	      	metricsReturn.setPolicyId(metrics.getPolicyId());
	      	      	metricsReturn.setMinNoOfClasses(metrics.getMinNoOfClasses());
	      	      	metricsReturn.setMaxNoOfClasses(metrics.getMaxNoOfClasses());
	      	      	metricsReturn.setIdealNoOfClasses(metrics.getIdealNoOfClasses());
	      	
	         

	     } catch (SQLException e) {

	         e.printStackTrace();

	     } finally {

	      if( pstmt != null) {pstmt.close();}

	      if( conn != null) {conn.close();}

	     }

	     return metricsReturn;

	    }
	 /**
	  * 
	  * @param metrics	@see Multiplicities
	  * @return			@see Multiplicities 
	  * @throws SQLException
	  */
	 
	 public static Metrics addMetrics(Multiplicities metrics) throws SQLException {

		 Metrics metricsReturn = null;
		 
	     Connection conn = null;

	     PreparedStatement pstmt = null;
	     
	     PreparedStatement lastIdStatement = null;
	     
	     ResultSet lastIdResult = null;
	     
	     int newMetricsId = 0;
	     
	     String getLastIdString = "SELECT LAST_INSERT_ID();";

	     try {

	      conn = DbManager.getConnection();
	      		
	      		pstmt = conn.prepareStatement(

	     	           "INSERT into metrics(metricsTypeID, metricsWeight, policyID) VALUES(?,?,?,?);");

	     	         pstmt.setInt(1, metrics.getMetricsTypeId());

	     	         pstmt.setInt(2, metrics.getMetricsWeight());
	     	         
	     	         pstmt.setInt(3, metrics.getPolicyId());
	     	         
	     	     pstmt.executeUpdate();
	     	     
	     	     lastIdStatement = conn.prepareStatement(getLastIdString);

	     	     lastIdResult = lastIdStatement.executeQuery();
	     	     
	     	     while (lastIdResult.next()){
	     	    	 newMetricsId = lastIdResult.getInt(1);
	     	     }
	     	      
	     	     metricsReturn = new Multiplicities();
	     	     metricsReturn.setMetricsId(newMetricsId);
	     	     metricsReturn.setMetricsTypeId(metrics.getMetricsTypeId());
	     	     metricsReturn.setMetricsWeight(metrics.getMetricsWeight());
	     	     metricsReturn.setPolicyId(metrics.getPolicyId());
	     
	      		
	      		
	      	
	         

	     } catch (SQLException e) {

	         e.printStackTrace();

	     } finally {

	      if( pstmt != null) {pstmt.close();}

	      if( conn != null) {conn.close();}

	     }

	     return metricsReturn;

	    }
	 /**
	  * @param  policyId		
	  * @return	ArrayList<Metrics>  List of all Metrics sub-classes for this policyId
	  * @throws SQLException
	  */
	 public static ArrayList<Metrics> getAllMetricsByPolicy(int policyId) throws SQLException {

	  
		 ArrayList<Metrics> metricsList = null;
		 
		 
		 return metricsList;

	    }
	 
	 /**
	  * 
	  * @param metricsId	metricsId 
	  * @return	Metrics		Relevant Metrics sub-class
	  * @throws SQLException
	  */
	 
	 public static Metrics getMetrics(int metricsId) throws SQLException {

	     Metrics metrics = null;

	    

	     return metrics;

	    }   
}
