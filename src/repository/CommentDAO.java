package repository;

/**
 * @author Yidu Liang
 * @author Xuesong Meng
 * @author yangchen
<<<<<<< HEAD
=======
 * @author Weiqi Kong
>>>>>>> master
 * 
 */
import domain.Comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommentDAO {

    /**
     * Add Comment into DB (user id, content, written time, diagram id)
     * 			
     * @param Comment object
     * 			userId, content, diagramId
     * @return true if success; false if fail
     */
<<<<<<< HEAD
    public static boolean addComment(Comment comment) {
=======
    /*public static boolean addComment(Comment comment) {
>>>>>>> master
	ResultSet rs;
	try {
	    Connection conn = DbManager.getConnection();
	    String sql = "INSERT INTO comment(userId, reportId, content) VALUES(?,?,?);";
	    PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	    pstmt.setInt(1, comment.getUserId());
	    pstmt.setInt(2, comment.getReportId());
	    pstmt.setString(3, comment.getContent());

	    pstmt.executeUpdate();

	    //Get and set the auto-generated PK
	    rs = pstmt.getGeneratedKeys();
	    if (rs.next()) {
		int newId = rs.getInt(1);
		comment.setCommentId(newId);
	    }
	    rs.close();
	    pstmt.close();
	    conn.close();

	} catch (SQLException ex) {
	    Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
	return true;
<<<<<<< HEAD
    }
=======
    }*/
	
	public static Comment addComment(Comment comment) {
		ResultSet rs;
		try {
		    Connection conn = DbManager.getConnection();
		    String sql = "INSERT INTO comment(compareId,userId,commentText,commentTime,promotedDiagramId,userName) VALUES(?,?,?,NOW(),?,?);";
		    PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		    pstmt.setInt(1, comment.getCompareId());
		    pstmt.setInt(2, comment.getUserId());
		    pstmt.setString(3, comment.getCommentText());
		    //pstmt.setString(4, comment.getCommentTime());
		    pstmt.setInt(4, comment.getPromotedDiagramId());
		    pstmt.setString(5, comment.getUserName());
		    

		    pstmt.executeUpdate();

		    //Get and set the auto-generated PK
		    rs = pstmt.getGeneratedKeys();
		    if (rs.next()) {
			int newId = rs.getInt(1);
			comment.setCommentId(newId);
		    }
		    rs.close();
		    pstmt.close();
		    conn.close();

		} catch (SQLException ex) {
		    Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return comment;
	    }
	
	
>>>>>>> master

    /**
     * Get Comment ArrayList from DB
     * 
     * @param reportId
     * 		  reportID : the merge result of 2 diagrams  
     * @return Comment ArrayList
     */
<<<<<<< HEAD
    public static ArrayList<Comment> getComment(int reportId) {
=======
    /*public static ArrayList<Comment> getComment(int reportId) {
>>>>>>> master
	ArrayList<Comment> searchResult = new ArrayList<>();
	try {
	    Connection conn = DbManager.getConnection();
	    String sql = "SELECT * FROM comment where reportId = ? ORDER BY `writenTime` DESC;";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setInt(1, reportId);

	    ResultSet rs = pstmt.executeQuery();

	    //Initiate a list to get all returned comment objects and set attributes
	    while (rs.next()) {
		Comment comt = new Comment();
		comt.setCommentId(rs.getInt("commentId"));
		comt.setContent(rs.getString("content"));
		comt.setUserId(rs.getInt("userId"));
		comt.setReportId(rs.getInt("reportId"));
		comt.setCommentTime(rs.getString("writenTime"));
		searchResult.add(comt);
	    }

	    rs.close();
	    pstmt.close();
	    conn.close();
	    return searchResult;
	} catch (SQLException ex) {
	    Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
	return null;
<<<<<<< HEAD
    }
=======
    }*/
	
	
	public static ArrayList<Comment> getComments(int compareId) {
		ArrayList<Comment> searchResult = new ArrayList<>();
		try {
		    Connection conn = DbManager.getConnection();
		    String sql = "SELECT * FROM comment where compareId = ? ORDER BY `commentTime` DESC;";
		    PreparedStatement pstmt = conn.prepareStatement(sql);
		    pstmt.setInt(1, compareId);

		    ResultSet rs = pstmt.executeQuery();

		    //Initiate a list to get all returned comment objects and set attributes
		    while (rs.next()) {
			Comment comt = new Comment();
			comt.setCommentId(rs.getInt("commentId"));
			comt.setCompareId(rs.getInt("compareId"));
			comt.setUserId(rs.getInt("userId"));
			comt.setCommentText(rs.getString("commentText"));
			comt.setCommentTime(rs.getString("commentTime"));
			//comt.setReportId(rs.getInt("reportId"));
			comt.setPromotedDiagramId(rs.getInt("promotedDiagramId"));
			comt.setUserName(rs.getString("userName"));
			searchResult.add(comt);
		    }

		    rs.close();
		    pstmt.close();
		    conn.close();
		    return searchResult;
		} catch (SQLException ex) {
		    Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	    }
>>>>>>> master

    /**
     * Update Comment from DB
     * 
     * @param Comment object
     * 			content, commentTime, commentId 
     * @return true if success; false if fail
     */
<<<<<<< HEAD
    public static boolean updateComment(Comment comment) {
=======
   /* public static boolean updateComment(Comment comment) {
>>>>>>> master
	try {
	    Connection conn = DbManager.getConnection();
	    String sql = "UPDATE comment SET content = ? , writenTime = ? WHERE commentId = ?;";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, comment.getContent());
	    pstmt.setString(2, comment.getCommentTime());
	    pstmt.setInt(3, comment.getCommentId());

	    pstmt.executeUpdate();

	    pstmt.close();
	    conn.close();
	    return true;
	} catch (SQLException ex) {
	    Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
	return false;
<<<<<<< HEAD
    }
=======
    }*/
>>>>>>> master

    
    /**
     * Delete Diagram from DB
     * 
     * @param Comment object
     * @return true if success; false if fail
     */  
<<<<<<< HEAD
    public static boolean deleteComment(Comment comment) {
=======
  /* public static boolean deleteComment(Comment comment) {
>>>>>>> master
	try {
	    Connection conn = DbManager.getConnection();
	    String sql = "DELETE FROM comment WHERE commentId = ? ;";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setInt(1, comment.getCommentId());

	    pstmt.executeUpdate();

	    pstmt.close();
	    conn.close();
	    return true;
	} catch (SQLException ex) {
	    Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
	return false;
<<<<<<< HEAD
    }
}
=======
    }*/
}
>>>>>>> master
