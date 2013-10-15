package UnitTest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import domain.User;
import repository.ProjectDAO;

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

}
