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

			     	           "INSERT into Attributes(metricId, idealNoOfAttributes, maxNoOfAttributes, minNoOfAttributes) VALUES(?,?,?,?);");

			     	         pstmt.setInt(1, newMetricId);

			     	         
			     	         pstmt.setInt(2, metrics.getIdealNoOfAttributes());
			     	         
			     	         pstmt.setInt(3, metrics.getMaxNoOfAttributes());
			     	         
			     	         pstmt.setInt(4, metrics.getMinNoOfAttributes());

			     	        pstmt.executeUpdate();
		     	         
		     	 
	      	      	metricsReturn = new Attributes();
	      	      	metricsReturn.setMetricId(newMetricId);
	      	      	metricsReturn.setMetricTypeId(metrics.getMetricTypeId());
	      	      	metricsReturn.setMetricsWeight(metrics.getMetricsWeight());
	      	      	metricsReturn.setPolicyId(metrics.getPolicyId());
	      	      	metricsReturn.setIdealNoOfAttributes(metrics.getIdealNoOfAttributes());
	      	      	metricsReturn.setMaxNoOfAttributes(metrics.getMaxNoOfAttributes());
	      	      	metricsReturn.setMinNoOfAttributes(metrics.getMinNoOfAttributes());
	      	
	         

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
		 
		 String attributesSelectStatement = "SELECT * FROM Associations WHERE metricId = ?;";
		 
		 
		 String classesSelectStatement = "SELECT * FROM Classes WHERE metricId = ?;";
		 
		 
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
					 		attribute.setIdealNoOfAttributes(innerResultSet.getInt("idealNoOfAttributes"));
					 		attribute.setMaxNoOfAttributes(innerResultSet.getInt("maxNoOfAttributes"));
					 		attribute.setMinNoOfAttributes(innerResultSet.getInt("minNoOfAttributes"));
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
	     
	     Connection conn = null;
	     
	     Connection subConnection = null;
	     
	     PreparedStatement pstmt = null;
	     
	     PreparedStatement innerPreparedStatement = null;
	     
	     ResultSet metricsResultSet = null;
	     
	     ResultSet innerResultSet = null;
	     
	     String attributesSelectStatement = "SELECT * FROM Attributes WHERE metricId = ?;";
	     
	     String classesSelectStatement = "SELECT * FROM Classes WHERE metricId = ?;";
	     
	     int thisMetricId = 0;
	     
	     int thisMetricTypeId = 0;
	    
	     try {
	    	 
	    	 conn = DbManager.getConnection();
	    	 subConnection = DbManager.getConnection();
	    	 
	    	 pstmt = conn.prepareStatement("SELECT * FROM metrics WHERE metricId = ?;");
	    	 pstmt.setInt(1, metricId);
	    	 
	    	 metricsResultSet =  pstmt.executeQuery();
	    	 
	    	 while (metricsResultSet.next()){
	    		 
	    		 // Based on metricTypeId , determine which sub Class should be returned
	    		 
	    		 thisMetricId = metricsResultSet.getInt("metricId");
	    		 thisMetricTypeId = metricsResultSet.getInt("metricTypeId");
	    		 
	    		 switch (thisMetricTypeId){
	    		 
	    		 case ATTRIBUTES_TYPE:
	    			 
	    			 Attributes attributes = new Attributes();
	    			 
	    			 innerPreparedStatement = subConnection.prepareStatement(attributesSelectStatement);
	    			 innerPreparedStatement.setInt(1, thisMetricId);
	    			 
	    			 innerResultSet = innerPreparedStatement.executeQuery();
	    			 
	    			 while (innerResultSet.next()){
	    				 
	    				 attributes.setMetricId(metricsResultSet.getInt("metricId"));
	    				 attributes.setPolicyId(metricsResultSet.getInt("policyId"));
	    				 attributes.setMetricTypeId(metricsResultSet.getInt("metricTypeId"));
	    				 attributes.setMetricsWeight(metricsResultSet.getInt("metricsWeight"));
	    				 attributes.setMetricsType(MetricsType.ATTRIBUTES);
	    				 attributes.setIdealNoOfAttributes(innerResultSet.getInt("idealNoOfAttributes"));
	    				 attributes.setMaxNoOfAttributes(innerResultSet.getInt("maxNoOfAttributes"));
	    				 attributes.setMinNoOfAttributes(innerResultSet.getInt("minNoOfAttributes"));
	    				 
	    			 }
	    			 
	    			 metrics = attributes;
	    			 
	    		 case CLASSES_TYPE:
	    			 
	    			 Classes classes = new Classes();
	    			 
	    			 innerPreparedStatement = subConnection.prepareStatement(classesSelectStatement);
	    			 innerPreparedStatement.setInt(1, thisMetricId);
	    			 
	    			 innerResultSet = innerPreparedStatement.executeQuery();
	    			 while (innerResultSet.next()){
	    				 
	    				 classes.setMetricId(metricsResultSet.getInt("metricId"));
	    				 classes.setPolicyId(metricsResultSet.getInt("policyId"));
	    				 classes.setMetricTypeId(metricsResultSet.getInt("metricTypeId"));
	    				 classes.setMetricsWeight(metricsResultSet.getInt("metricsWeight"));
	    				 classes.setMetricsType(MetricsType.CLASSES);
	    				 classes.setIdealNoOfClasses(innerResultSet.getInt("idealNoOfClasses"));
	    				 classes.setMaxNoOfClasses(innerResultSet.getInt("maxNoOfClasses"));
	    				 classes.setMinNoOfClasses(innerResultSet.getInt("minNoOfClasses"));
	    			 }
	    			 
	    			 	metrics = classes;
	    			 	
	    		 case MULTIPLICITIES_TYPE:
	    			 
	    			 Multiplicities multiplicities = new Multiplicities();
	    			 
	    			 multiplicities.setMetricId(metricsResultSet.getInt("metricId"));
	    			 multiplicities.setPolicyId(metricsResultSet.getInt("policyId"));
	    			 multiplicities.setMetricTypeId(metricsResultSet.getInt("metricTypeId"));
	    			 multiplicities.setMetricsWeight(metricsResultSet.getInt("metricsWeight"));
	    			 multiplicities.setMetricsType(MetricsType.MULTIPLICITIES);
	    			 
	    			 metrics = multiplicities;
	    			 
	    		 case ASSOCIATIONS_TYPE:
	    		 
	    			 Associations associations = new Associations();
	    			 
	    			 associations.setMetricId(metricsResultSet.getInt("metricId"));
	    			 associations.setPolicyId(metricsResultSet.getInt("policyId"));
	    			 associations.setMetricTypeId(metricsResultSet.getInt("metricTypeId"));
	    			 associations.setMetricsWeight(metricsResultSet.getInt("metricsWeight"));
	    			 associations.setMetricsType(MetricsType.ASSOCIATIONS);
	    			 
	    			 metrics = associations;
	    			 
	    		 }
	    		 
	    		 
	    		 
	    	 }
	    	 
	    	 
	     }
	     catch (SQLException sqlE){
	    	 sqlE.printStackTrace();
	     }
	     finally {
	    	 
	    	 if (pstmt != null) {pstmt.close();}
	    	 
	    	 if (innerPreparedStatement != null ) {innerPreparedStatement.close();}
	    	 
	    	 if (conn != null ) {conn.close();}
	    	 
	    	 if (subConnection != null ) {subConnection.close();}
	     }

	     return metrics;

	    }   
	 /**
	  * 
	  * @param metrics	@see Classes Metrics to be updated
	  * @return			<code>boolean</code> True if updated successfully, false if not
	  */
	 
	 public static boolean updateMetrics(Classes metrics) throws SQLException{
		 
		 boolean updated = false;
		 
		 Connection conn = null;
		 		 
		 PreparedStatement pstmt = null;
		 
		 String updateMetricsStatement = "UPDATE Metrics SET metricsWeight = ? WHERE metricId = ?;";
		 
		 String updateClassesStatement = "UPDATE Classes SET idealNoOfClasses = ? , maxNoOfClasses = ? , minNoOfClasses = ? WHERE metricId = ?;";
		 
		 try {
			 
			 conn = DbManager.getConnection();
			 
			 pstmt = conn.prepareStatement(updateMetricsStatement);
			 pstmt.setInt(1, metrics.getMetricsWeight());
			 pstmt.setInt(2, metrics.getMetricId());
			 			 
			 if (pstmt.executeUpdate() == 0){
				 	updated = true;
			 }
			 
			 pstmt = conn.prepareStatement(updateClassesStatement);
			 pstmt.setInt(1, metrics.getIdealNoOfClasses());
			 pstmt.setInt(2, metrics.getMaxNoOfClasses());
			 pstmt.setInt(3, metrics.getMinNoOfClasses());
			 pstmt.setInt(4, metrics.getMetricId());
			
			 if (pstmt.executeUpdate() == 0){
				 updated = true;
			 }
			 
		 }
		 catch (SQLException sqlE){
			 sqlE.printStackTrace();
		 }
		 finally {
			 
			 if (pstmt != null) {pstmt.close();}
			 			 
			 if (conn != null) {conn.close();}
			 			 
			 
		 }
		 
		 return updated;
	 }
	 /**
	  * 
	  * @param metrics	@see Attributes Metrics to be updated
	  * @return			<code>boolean</code> True if updated successfully, false if not
	  */
	 
	 public static boolean updateMetrics(Attributes metrics) throws SQLException {
		 
		 boolean updated = false;
		 
		 Connection conn = null;
 		 
		 PreparedStatement pstmt = null;
		 
		 String updateMetricsStatement = "UPDATE Metrics SET metricsWeight = ? WHERE metricId = ?;";
		 
		 String updateAttributesStatement = "UPDATE Attributes SET idealNoOfAttributes = ? , maxNoOfAttributes = ? , minNoOfAttributes = ? WHERE metricId = ?;";
		 
		 try {
			 
			 conn = DbManager.getConnection();
			 
			 pstmt = conn.prepareStatement(updateMetricsStatement);
			 pstmt.setInt(1, metrics.getMetricsWeight());
			 pstmt.setInt(2, metrics.getMetricId());
			 			 
			 if (pstmt.executeUpdate() == 0){
				 	updated = true;
			 }
			 
			 pstmt = conn.prepareStatement(updateAttributesStatement);
			 pstmt.setInt(1, metrics.getIdealNoOfAttributes());
			 pstmt.setInt(2, metrics.getMaxNoOfAttributes());
			 pstmt.setInt(3, metrics.getMinNoOfAttributes());
			 pstmt.setInt(4, metrics.getMetricId());
			
			 if (pstmt.executeUpdate() == 0){
				 updated = true;
			 }
			 
		 }
		 catch (SQLException sqlE){
			 sqlE.printStackTrace();
		 }
		 finally {
			 
			 if (pstmt != null) {pstmt.close();}
			 			 
			 if (conn != null) {conn.close();}
			 			 
			 
		 }
		 
		 return updated;
	 }
	 /**
	  * 
	  * @param metricId	The metricId of the @see Metric to be deleted
	  * @return 		<code>boolean</code> True if deleted successfully, false if not
	  */
	 
	 public static boolean deleteMetrics(int metricId) throws SQLException {
		 
		 boolean deleted = false;
		 
		 Connection conn = null;
		 
		 Connection subConnection = null;
		 
		 PreparedStatement pstmt = null;
		 
		 ResultSet metricsResultSet = null;
		 
		 int thisMetricId = 0;
		 
		 int thisMetricTypeId = 0;
		 
		 String deleteMetricsStatement = "DELETE FROM metrics WHERE metricId = ?;";
		 
		 String deleteAttributesStatement = "DELETE FROM attributes WHERE metricId = ?;";
		 
		 String deleteClassesStatement = "DELETE FROM classes WHERE metricId = ?;";
		 
		 
		 try {
			 
			 conn = DbManager.getConnection();
			 
			 pstmt = conn.prepareStatement("SELECT * FROM metrics WHERE metricId = ?;");
			 
			 pstmt.setInt(1, metricId);
			 
			 metricsResultSet = pstmt.executeQuery();
			 
			 while (metricsResultSet.next()) {
				 
				 thisMetricId = metricsResultSet.getInt("metricId");
				 thisMetricTypeId = metricsResultSet.getInt("metricTypeId");
				 
			 }
			 
			 // Check the metricTypeId from the retrieved metrics record
			 // Based on the metricTypeId, determine if add'l records in Classes or Attributes also need to be deleted
			 
			 switch(thisMetricTypeId){
			 
			 case ASSOCIATIONS_TYPE:			// No add'l record to delete, only metrics
				 
				 pstmt = conn.prepareStatement(deleteMetricsStatement);
				 pstmt.setInt(1, metricId);
				 
				 if (pstmt.executeUpdate() == 0){
					 deleted = true;
				 }
				 
				 
			 case MULTIPLICITIES_TYPE:			// No add'l record to delete, only metrics
				 
				 pstmt = conn.prepareStatement(deleteMetricsStatement);
				 pstmt.setInt(1, metricId);
				 
				 if (pstmt.executeUpdate() == 0){
					 deleted = true;
				 }
				 	
			 case ATTRIBUTES_TYPE:			// First delete attributes record, then metrics
				 
				 pstmt = conn.prepareStatement(deleteAttributesStatement);
				 pstmt.setInt(1, metricId);
				 
				 if (pstmt.executeUpdate() == 0){
					 deleted = true;
				 }
				 
				 pstmt = conn.prepareStatement(deleteMetricsStatement);
				 pstmt.setInt(1, metricId);
				 
				 if (pstmt.executeUpdate() == 0){
					 deleted = true;
				 }
				 
			 case CLASSES_TYPE:				// First delete classes record, then metrics
				 
				 pstmt = conn.prepareStatement(deleteClassesStatement);
				 pstmt.setInt(1, metricId);
				 
				 if (pstmt.executeUpdate() == 0){
					 deleted = true;
				 }
				 
				 pstmt = conn.prepareStatement(deleteMetricsStatement);
				 pstmt.setInt(1, metricId);
				 
				 if (pstmt.executeUpdate() == 0){
					 deleted = true;
				 }
				 
			 }
		 }
		 
		 catch (SQLException sqlE){
			 sqlE.printStackTrace();
		 }
		 
		 finally {
			 if (pstmt != null) {pstmt.close();}
			 
			 if (conn != null ) {conn.close();}
		 }
		 
		 
		 return deleted;
	 }
	 
}
