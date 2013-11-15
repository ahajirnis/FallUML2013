

	package UnitTest;

	import static org.junit.Assert.*;

	import java.sql.Connection;
import java.util.ArrayList;

	import org.junit.Test;

	import domain.Comment;
import domain.Compare;
import repository.DbManager;
import repository.CommentDAO;

	public class CommentDAOTest {

		



		

			@Test
			public void test() {
				System.out.println("d");
				
				
				
				
				//this is for addComment test
				Comment comment = new Comment();
				comment.setCompareId(3);
				comment.setUserId(3);
				comment.setCommentText("www");
				comment.setCommentTime("101111");
				comment.setReportId(2);
				
				CommentDAO.addComment(comment);
				
				//this is for Arraylist test
			/*	ArrayList<Comment> comment = new ArrayList<Comment>();
				
				 comment=CommentDAO.getComment(10);
			
				System.out.println(comment.get(0).getCommentId());
				System.out.println(comment.get(0).getCompareId());
				System.out.println(comment.get(0).getUserId());
				System.out.println(comment.get(0).getCommentText());
				System.out.println(comment.get(0).getCommentTime());
				System.out.println(comment.get(0).getReportId());*/
				 
			}

		

		
		
		
		
		
		
		
		
		
		
		
	}

