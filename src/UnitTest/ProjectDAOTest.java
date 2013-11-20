package UnitTest;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import repository.DbManager;
import repository.ProjectDAO;
import domain.Project;
import domain.User;

public class ProjectDAOTest {

	@Test
	public void testGetUsers() throws SQLException {
		
		/*To run this test successfully, you should have a project who has projectId as 1 and has 2 users under it
		 * in your database.
		*/
		int projectId = 1;
		ArrayList<User> users = ProjectDAO.getUsers(projectId);		
		assertTrue(users.size() == 2);
	}
	
	@Test
	public void testGetProjectByProjectName() throws SQLException {
		//You have a project clubuml2 in your db
		Project project = ProjectDAO.getProject("clubuml2");
		Project expected = new Project("2","clubuml2","des2","2013-09-22 23:50:31");
		Assert.assertEquals(expected.getProjectId(), project.getProjectId());
		Assert.assertEquals(expected.getDescription(), project.getDescription());
		Assert.assertEquals(expected.getStartDate(), project.getStartDate());
	}
	
	@Test
	public void testAddProject() throws SQLException {
		//add project clubuml3, make sure the clubuml3 is not existed before you run the test
		Project project = new Project("0","clubuml3","des33",null);
		Project result = ProjectDAO.addProject(project);
		
		/*Project p = null;
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	try {
    		conn = DbManager.getConnection();
    		pstmt = conn.prepareStatement(
    				"SELECT * FROM project where projectName = ?;"
    				);
    		pstmt.setString(1, project.getProjectName());
    		rs = pstmt.executeQuery();
    		if (rs.next()) {
    			p = new Project(rs.getString("projectId"),rs.getString("projectName"),
    					rs.getString("description"), rs.getString("startDate"));
    		}
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} finally {
    		if(rs != null) {rs.close();}
    		if(pstmt != null) {pstmt.close();}
    		if(conn != null) {conn.close();}
    	} */
    	deleteProject("clubuml3");
    	Assert.assertEquals(project.getProjectName(), result.getProjectName());
		Assert.assertEquals(project.getDescription(), result.getDescription());
	}
	
	@Test
	public void testDisableProject() throws SQLException {
		//clubuml5 is existed and enabled
		String projectName = "clubuml5";
		boolean result = ProjectDAO.disableProject(projectName);
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void testEnableProject() throws SQLException {
		//clubuml2 is existed and disabled
		String projectName = "clubuml2";
		boolean result = ProjectDAO.enableProject(projectName);
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void testIsExisted() throws SQLException {
		Assert.assertEquals(false, ProjectDAO.exists("clubuml7"));
		Assert.assertEquals(true, ProjectDAO.exists("clubuml1"));
	}
	
	@Test
	public void testGetAllProjects() throws SQLException {
		ArrayList<Project> projects = ProjectDAO.getAllProjects();
		Assert.assertEquals(4, projects.size());
	}
	
	@Test
	public void testUpdateProject() throws SQLException {
		Project project = new Project("21","clubuml6-new","des6","","N","");
		boolean result = ProjectDAO.updateProject(project);
		Assert.assertEquals(true, result);
	}
	
	private boolean deleteProject(String projectName) throws SQLException {
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	try {
    		conn = DbManager.getConnection();
    		pstmt = conn.prepareStatement(
        	    		"DELETE from project where projectName = ?");
    		   	    
    	    pstmt.setString(1, projectName);
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

}
