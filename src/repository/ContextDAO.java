package repository;

 

/**

* @author Ying Gan

* @author Aindra Misra

* @author Aniket Hajirnis

*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

 



import domain.Diagram;
import domain.DiagramContext;
import domain.DiagramType;

 

public class ContextDAO {

/**

     * Get Context by context name

     * @param contextName

     * @return context

     * @throws SQLException

     */

    public static DiagramContext getContext(int projectId) throws SQLException {

    DiagramContext context = null;

     Connection conn = null;

     PreparedStatement pstmt = null;

     ResultSet rs = null;

     try {

      conn = DbManager.getConnection();

         pstmt = conn.prepareStatement(

          "SELECT * FROM diagramContext where projectId = ? ;");

         pstmt.setInt(1, projectId);

         rs = pstmt.executeQuery();

         if (rs.next()) {

      context = new DiagramContext();

         }

         return context;

     } catch (SQLException e) {

         System.out.println("Using default model.");

     } finally {

      if( rs != null) {rs.close();}

      if( pstmt != null) {pstmt.close();}

      if( conn != null) {conn.close();}

     }

     return context;

    }

   

    /**

     * Add a new context

     * @param context

     * @return true - successfully added. false - failed

     * @throws SQLException

     */

    public static boolean addContext(DiagramContext context) throws SQLException {

     Connection conn = null;

     PreparedStatement pstmt = null;

     try {

      conn = DbManager.getConnection();

         pstmt = conn.prepareStatement(

           "INSERT into diagramContext(diagramContextId, description ,name, policyId, projectId) VALUES(?,NOW(),?);");

         pstmt.setString(1, context.getDiagramContextName());

         pstmt.setString(2, context.getDiagramContextDescription());

         if(pstmt.executeUpdate() != 0) {

          return true;

         } else {

          return false;

         }

     } catch (SQLException e) {

         e.printStackTrace();

     } finally {

      if( pstmt != null) {pstmt.close();}

      if( conn != null) {conn.close();}

     }

     return false;

    }

   

    public static boolean updateContext(DiagramContext context) throws SQLException {

     Connection conn = null;

     PreparedStatement pstmt = null;

     try {

      conn = DbManager.getConnection();

      if (context.getEnabled()) {

       pstmt = conn.prepareStatement(

               "UPDATE diagramContext SET name = ?, description = ?, policyId = ?, "

               + "projectId = ? WHERE diagramContextId = ?;");

      }

      else {

       pstmt = conn.prepareStatement(

               "UPDATE diagramContext SET name = ?, description = ?, projectId = ?, "

               + "WHERE diagramContextId = ?;");

      }     

         pstmt.setString(1, context.getDiagramContextName());

         pstmt.setString(2, context.getDiagramContextDescription());

         pstmt.setInt(3, context.getProjectID());

         pstmt.setInt(4, context.getDiagramContextID());

         if(pstmt.executeUpdate() != 0) {

          return true;

         } else {

          return false;

         }

     } catch (SQLException e) {

         e.printStackTrace();

     } finally {

      if( pstmt != null) {pstmt.close();}

      if( conn != null) {conn.close();}

     }

     return false;

    }

   

    /**

     * Disable a context

     * @param name

     * @return true - successful. false - failed.

     * @throws SQLException

     */

    public static boolean disableContext(String name) throws SQLException {

     Connection conn = null;

     PreparedStatement pstmt = null;

     try {

      conn = DbManager.getConnection();

         pstmt = conn.prepareStatement(

           "UPDATE diagramContext SET projectId = ?, description = ? WHERE name = ?;");

         pstmt.setString(1, name);

         if(pstmt.executeUpdate() != 0) {

          return true;

         } else {

          return false;

         }

     } catch (SQLException e) {

         e.printStackTrace();

     } finally {

      if( pstmt != null) {pstmt.close();}

      if( conn != null) {conn.close();}

     }

     return false;

    }

   

    /**

     * Enable a context

     * @param name

     * @return true - successful. false - failed.

     * @throws SQLException

     */

    public static boolean enableContext(String name) throws SQLException {

     Connection conn = null;

     PreparedStatement pstmt = null;

     try {

      conn = DbManager.getConnection();

         pstmt = conn.prepareStatement(

           "UPDATE diagramContext SET projectId = ?, description = ? WHERE name = ?;");

         pstmt.setString(1, name);

         if(pstmt.executeUpdate() != 0) {

          return true;

         } else {

          return false;

         }

     } catch (SQLException e) {

         e.printStackTrace();

     } finally {

      if( pstmt != null) {pstmt.close();}

      if( conn != null) {conn.close();}

     }

     return false;

    }

   

    /**

     * Check if the project which has the same project name is existed.

     * @param projectName

     * @return true - existed. false - not existed.

     * @throws SQLException

     */

    public static boolean exists(String name) throws SQLException {

     if(getContext(name) == null) {

      return false;

     }

     else {

      return true;

     }

    }

   

    /**

     * Get all contexts (enabled and disabled)

     * @return Contexts list

     * @throws SQLException

     */

    public static ArrayList<DiagramContext> getAllContexts() throws SQLException {

     ArrayList<DiagramContext> contexts = new ArrayList<DiagramContext>();

     Connection conn = null;

     PreparedStatement pstmt = null;

     ResultSet rs = null;

     try {

      conn = DbManager.getConnection();

         pstmt = conn.prepareStatement(

          "SELECT * FROM diagramContext;");

         rs = pstmt.executeQuery();

         while (rs.next()) {

      DiagramContext context = new DiagramContext(rs.getInt("diagramContextId"), rs.getString("name"),

        rs.getString("description"), rs.getInt("policyId"),

        rs.getInt("projectId"));

      contexts.add(context);

         }

         return contexts;

     } catch (SQLException e) {

      e.printStackTrace();

     } finally {

      if( rs != null) {rs.close();}

      if( pstmt != null) {pstmt.close();}

      if( conn != null) {conn.close();}

     }

     return contexts;

    }

    
    public static ArrayList <Diagram> getDiagramList (int contextId) throws SQLException
    {
    	ArrayList<Diagram> diagramList= new ArrayList <Diagram>();

         Connection conn = null;

         PreparedStatement pstmt = null;

         ResultSet rs = null;

         try {

          conn = DbManager.getConnection();

             pstmt = conn.prepareStatement(

              "SELECT * FROM diagram where contextId = ?;");         
             pstmt.setInt(1,contextId);
             rs = pstmt.executeQuery();

             while (rs.next()) {
         		Diagram diagram = new Diagram();
        		diagram.setDiagramId(rs.getInt("diagramId"));
        		diagram.setProjectId(rs.getInt("projectId"));
        		diagram.setUserId(rs.getInt("userId"));
        		//support for enum type
        		diagram.setDiagramType(DiagramType.fromString(rs.getString("diagramType")));
        		
        		diagram.setDiagramName(rs.getString("diagramName"));
        		diagram.setFilePath(rs.getString("filePath"));
        		diagram.setFileType(rs.getString("fileType"));
        		diagram.setNotationFileName(rs.getString("notationFileName"));
        		diagram.setNotationFilePath(rs.getString("notationFilePath"));
        		diagram.setDiFilepath(rs.getString("diFilePath"));
        		diagram.setCreatedTime(rs.getString("createTime"));        		
        		diagramList.add(diagram);
             }    	
         }
         catch (SQLException e) {

             e.printStackTrace();

            } finally {

             if( rs != null) {rs.close();}

             if( pstmt != null) {pstmt.close();}

             if( conn != null) {conn.close();}

            }
    	return diagramList;
    }
   

    /**

     * Delete Context from DB

     *

     * @param Context object

     * @return true if success; false if fail

     */

    public static boolean deleteContext(DiagramContext context) {

try {

    Connection conn = DbManager.getConnection();

    String sql = "DELETE FROM diagramContext WHERE diagramContextId = ?;";

    PreparedStatement pstmt = conn.prepareStatement(sql);

 

    pstmt.setInt(1, context.getDiagramContextID());

 

    pstmt.executeUpdate();

 

    pstmt.close();

    conn.close();

    return true;

} catch (SQLException ex) {

    Logger.getLogger(ContextDAO.class.getName()).log(Level.SEVERE, null, ex);

}

return false;

    }

    /**

     * Get Context by context name

     * @param contextName

     * @return context

     * @throws SQLException

     */

    public static DiagramContext getContext(String contextName) throws SQLException {

     DiagramContext context = null;

     Connection conn = null;

     PreparedStatement pstmt = null;

     ResultSet rs = null;

     try {

      conn = DbManager.getConnection();

         pstmt = conn.prepareStatement(

          "SELECT * FROM diagramContext where contextName = ? ;");

         pstmt.setString(1, contextName);

         rs = pstmt.executeQuery();

         if (rs.next()) {

      context = new DiagramContext();

         }

         return context;

     } catch (SQLException e) {

         System.out.println("Using default model.");

     } finally {

      if( rs != null) {rs.close();}

      if( pstmt != null) {pstmt.close();}

      if( conn != null) {conn.close();}

     }

     return context;

    }   
    
    
    
    public static DiagramContext getContext(int projectid, String contextName) throws SQLException {

        DiagramContext context = null;

        Connection conn = null;

        PreparedStatement pstmt = null;

        ResultSet rs = null;

        try {

         conn = DbManager.getConnection();

            pstmt = conn.prepareStatement(

             "SELECT * FROM diagramContext where contextName = ? AND projectId = ?;");

            pstmt.setString(1, contextName);
            pstmt.setInt(2, projectid);

            rs = pstmt.executeQuery();

            if (rs.next()) {

         context = new DiagramContext();

            }

            return context;

        } catch (SQLException e) {

            System.out.println("Using default model.");

        } finally {

         if( rs != null) {rs.close();}

         if( pstmt != null) {pstmt.close();}

         if( conn != null) {conn.close();}

        }

        return context;

       }   

}

 

 

  
