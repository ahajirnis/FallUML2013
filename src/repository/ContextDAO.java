package repository;

 

/**
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

 

import domain.DiagramContext;

 

public class ContextDAO {

/**

     * Get Context by context name

     * @param contextName

     * @return context

     * @throws SQLException

     */

    public static DiagramContext getContextByProject(int projectId) throws SQLException {

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

   

    /**

     * Delete Context from DB

     *

     * @param Context object

     * @return true if success; false if fail

     */

    public static boolean deleteContext(DiagramContext context) {

try {

    Connection conn = DbManager.getConnection();

    // Modified by Aindra Misra

    //String sql = "DELETE FROM diagramContext WHERE diagramContextId = ?;";

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

}