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
	
	public static final int ASSOCIATIONS_TYPE = 1;
	public static final int MULTIPLICITIES_TYPE = 2;
	public static final int ATTRIBUTES_TYPE = 3;
	public static final int CLASSES_TYPE = 4;
	
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
	     
	     int newMetricId = 0;
	     
	     String getLastIdString = "SELECT LAST_INSERT_ID();";

	     try {

	      conn = DbManager.getConnection();

	      		
	      		pstmt = conn.prepareStatement(

	     	           "INSERT into metrics(metricTypeID, metricsWeight, policyID) VALUES(?,?,?,?);");

	     	         pstmt.setInt(1, metrics.getMetricTypeId());

	     	         pstmt.setInt(2, metrics.getMetricsWeight());
	     	         
	     	         pstmt.setInt(3, metrics.getPolicyId());
	     	         
	     	     pstmt.executeUpdate();
	     	     
	     	     lastIdStatement = conn.prepareStatement(getLastIdString);

	     	     lastIdResult = lastIdStatement.executeQuery();
	     	     
	     	     while (lastIdResult.next()){
	     	    	 newMetricId = lastIdResult.getInt(1);
	     	     }
	     	      
	     	     metricsReturn = new Associations();
	     	     metricsReturn.setMetricId(newMetricId);
	     	     metricsReturn.setMetricTypeId(metrics.getMetricTypeId());
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
	     
	     int newMetricId = 0;
	     
	     String getLastIdString = "SELECT LAST_INSERT_ID();";

	     try {

	      conn = DbManager.getConnection();	      		
	      		
	      		pstmt = conn.prepareStatement(

		     	           "INSERT into metrics(metricTypeID, metricsWeight, policyID) VALUES(?,?,?,?);");

		     	         pstmt.setInt(1, metrics.getMetricTypeId());

		     	         pstmt.setInt(2, metrics.getMetricsWeight());
		     	         
		     	         pstmt.setInt(3, metrics.getPolicyId());

		     	        pstmt.executeUpdate();
			     	     
			    lastIdStatement = conn.prepareStatement(getLastIdString);

			    lastIdResult = lastIdStatement.executeQuery();
			     	     
			    	while (lastIdResult.next()){
			     	    	 newMetricId = lastIdResult.getInt(1);
			     	}
			     	      
			    	pstmt = conn.prepareStatement(

			     	           "INSERT into Attributes(metricId, averagePointOver, idealNoOfAttributes, maxNoOfAttributes) VALUES(?,?,?,?);");

			     	         pstmt.setInt(1, newMetricId);

			     	         pstmt.setInt(2, metrics.getAveragePointOver());
			     	         
			     	         pstmt.setInt(3, metrics.getIdealNoOfAttributes());
			     	         
			     	         pstmt.setInt(4, metrics.getMaxNoOfAttributes());

			     	        pstmt.executeUpdate();
		     	         
		     	 
	      	      	metricsReturn = new Attributes();
	      	      	metricsReturn.setMetricId(newMetricId);
	      	      	metricsReturn.setMetricTypeId(metrics.getMetricTypeId());
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
	     
	     int newMetricId = 0;
	     
	     String getLastIdString = "SELECT LAST_INSERT_ID();";

	     try {

	      conn = DbManager.getConnection();	      		
	      		
	      		pstmt = conn.prepareStatement(

		     	           "INSERT into metrics(metricTypeID, metricsWeight, policyID) VALUES(?,?,?,?);");

		     	         pstmt.setInt(1, metrics.getMetricTypeId());

		     	         pstmt.setInt(2, metrics.getMetricsWeight());
		     	         
		     	         pstmt.setInt(3, metrics.getPolicyId());

		     	        pstmt.executeUpdate();
			     	     
			    lastIdStatement = conn.prepareStatement(getLastIdString);

			    lastIdResult = lastIdStatement.executeQuery();
			     	     
			    	while (lastIdResult.next()){
			     	    	 newMetricId = lastIdResult.getInt(1);
			     	}
			     	      
			    	pstmt = conn.prepareStatement(

			     	           "INSERT into Classes(metricId, idealNoOfClasses, maxNoOfClasses, minNoOfClasses) VALUES(?,?,?,?);");

			     	         pstmt.setInt(1, newMetricId);

			     	         pstmt.setInt(2, metrics.getIdealNoOfClasses());
			     	         
			     	         pstmt.setInt(3, metrics.getMaxNoOfClasses());
			     	         
			     	         pstmt.setInt(4, metrics.getMinNoOfClasses());

			     	        pstmt.executeUpdate();
		     	         
		     	 
	      	      	metricsReturn = new Classes();
	      	      	metricsReturn.setMetricId(newMetricId);
	      	      	metricsReturn.setMetricTypeId(metrics.getMetricTypeId());
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
	     
	     int newMetricId = 0;
	     
	     String getLastIdString = "SELECT LAST_INSERT_ID();";

	     try {

	      conn = DbManager.getConnection();
	      		
	      		pstmt = conn.prepareStatement(

	     	           "INSERT into metrics(metricTypeID, metricsWeight, policyID) VALUES(?,?,?,?);");

	     	         pstmt.setInt(1, metrics.getMetricTypeId());

	     	         pstmt.setInt(2, metrics.getMetricsWeight());
	     	         
	     	         pstmt.setInt(3, metrics.getPolicyId());
	     	         
	     	     pstmt.executeUpdate();
	     	     
	     	     lastIdStatement = conn.prepareStatement(getLastIdString);

	     	     lastIdResult = lastIdStatement.executeQuery();
	     	     
	     	     while (lastIdResult.next()){
	     	    	 newMetricId = lastIdResult.getInt(1);
	     	     }
	     	      
	     	     metricsReturn = new Multiplicities();
	     	     metricsReturn.setMetricId(newMetricId);
	     	     metricsReturn.setMetricTypeId(metrics.getMetricTypeId());
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
		 
		 Connection conn = null;
		 
		 Connection subConnection = null;
		 
		 PreparedStatement pstmt = null;
		 
		 PreparedStatement innerPreparedStatement = null;
		 
		 ResultSet metricsResultSet = null;
		 
		 ResultSet innerResultSet = null;
		 
		 int thisMetricId = 0;
		 int thisMetricTypeId = 0;
		 
		 String attributesSelectStatement = "SELECT * FROM Associations WHERE metricId = ?";
		 
		 
		 String classesSelectStatement = "SELECT * FROM Classes WHERE metricId = ?";
		 
		 
		 try {
			 conn = DbManager.getConnection();
			 subConnection = DbManager.getConnection();
			 
			 pstmt = conn.prepareStatement("SELECT * FROM metrics WHERE policyId = ?;");
			 pstmt.setInt(1, policyId);
			 
			 metricsResultSet = pstmt.executeQuery();
			 
			 while (metricsResultSet.next()){
				 
				 if (metricsList == null){
					 metricsList = new ArrayList<Metrics>();
				 }
				 
				 thisMetricId = metricsResultSet.getInt("metricId");
				 thisMetricTypeId = metricsResultSet.getInt("metricTypeId");
				 
				// Check metricsTypeId for this metrics entity
				 // Based on metricsTypeId, retrieve related Classes or Attributes row as needed
				 
				 try {
					 
					 switch (thisMetricTypeId){
					 
					 case ATTRIBUTES_TYPE:				// Retrieve the attributes record
						 
						Attributes attribute = new Attributes();
					 	innerPreparedStatement = subConnection.prepareStatement(attributesSelectStatement);
					 	innerPreparedStatement.setInt(1, policyId);
					 	
					 	innerResultSet = innerPreparedStatement.executeQuery();
					 	
					 	while (innerResultSet.next()){
					 		
					 		attribute.setMetricId(metricsResultSet.getInt("metricId"));
					 		attribute.setPolicyId(metricsResultSet.getInt("policyId"));
					 		attribute.setMetricsWeight(metricsResultSet.getInt("metricsWeight"));
					 		attribute.setMetricTypeId(metricsResultSet.getInt("metricTypeId"));
					 		attribute.setAveragePointOver(innerResultSet.getInt("averagePointOver"));
					 		attribute.setIdealNoOfAttributes(innerResultSet.getInt("idealNoOfAttributes"));
					 		attribute.setMaxNoOfAttributes(innerResultSet.getInt("maxNoOfAttributes"));
					 		attribute.setMetricsType(MetricsType.ATTRIBUTES);
					 		
					 		metricsList.add(attribute);
					 	}
					 	
					 	
					 case CLASSES_TYPE:					// Retrieve the classes record
						 
						 Classes classes = new Classes();
						 innerPreparedStatement = subConnection.prepareStatement(classesSelectStatement);
						 innerPreparedStatement.setInt(1, policyId);
						
						 innerResultSet = innerPreparedStatement.executeQuery();
						 
						 while (innerResultSet.next()){
							 
							 classes.setMetricId(metricsResultSet.getInt("metricId"));
							 classes.setPolicyId(metricsResultSet.getInt("policyId"));
							 classes.setMetricsWeight(metricsResultSet.getInt("metricsWeight"));
							 classes.setMetricTypeId(metricsResultSet.getInt("metricTypeId"));
							 classes.setIdealNoOfClasses(innerResultSet.getInt("idealNoOfClasses"));
							 classes.setMaxNoOfClasses(innerResultSet.getInt("maxNoOfClasses"));
							 classes.setMinNoOfClasses(innerResultSet.getInt("minNoOfClasses"));
							 classes.setMetricsType(MetricsType.CLASSES);
							 
							 metricsList.add(classes);
						 }
						 
					 case ASSOCIATIONS_TYPE:			// No add'l record to retrieve
						 
						 Associations associations = new Associations();
						 associations.setMetricId(metricsResultSet.getInt("metricId"));
						 associations.setPolicyId(metricsResultSet.getInt("policyId"));
						 associations.setMetricsWeight(metricsResultSet.getInt("metricsWeight"));
						 associations.setMetricTypeId(metricsResultSet.getInt("metricTypeId"));
						 associations.setMetricsType(MetricsType.ASSOCIATIONS);
						 
						 metricsList.add(associations);
						 
					 case MULTIPLICITIES_TYPE:			// No add'l record to retrieve
						 
						 Multiplicities multiplicities = new Multiplicities();
						 multiplicities.setMetricId(metricsResultSet.getInt("metricId"));
						 multiplicities.setMetricTypeId(metricsResultSet.getInt("metricTypeId"));
						 multiplicities.setMetricsWeight(metricsResultSet.getInt("metricsWeight"));
						 multiplicities.setPolicyId(metricsResultSet.getInt("policyId"));
						 multiplicities.setMetricsType(MetricsType.MULTIPLICITIES);
						
						 metricsList.add(multiplicities);
						 
					 }
					 
				 }
				 catch (SQLException innerSqlE){
					 innerSqlE.printStackTrace();
				 }
				
				 
			 }
			 
			 
			 
		 }
		 catch (SQLException sqlE){
			 sqlE.printStackTrace();
		 }
		 finally{
			 
			  if( pstmt != null) {pstmt.close();}

		      if( conn != null) {conn.close();}
		      
		      if ( innerPreparedStatement != null) {innerPreparedStatement.close();}
		      
		      if ( subConnection != null) {subConnection.close();}

		 }
		 
		 
		 return metricsList;

	    }
	 
	 /**
	  * 
	  * @param metricId	metricId 
	  * @return	Metrics		Relevant Metrics sub-class
	  * @throws SQLException
	  */
	 
	 public static Metrics getMetrics(int metricId) throws SQLException {

	     Metrics metrics = null;

	    

	     return metrics;

	    }   
}
