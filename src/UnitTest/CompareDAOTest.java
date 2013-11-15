package UnitTest;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.Test;

import domain.Compare;
import domain.Comment;
import repository.DbManager;
import repository.CompareDAO;

public class CompareDAOTest {

	



	

		@Test
		public void test() {
			System.out.println("d");
			
			
			
			//Compare compare = new Compare();
			//compare.setDiagramAId(12);
			//compare.setDiagramBId(13);
			//compare.setReportId(6);
			//compare.setPromoteCountA(11);
			//compare.setPromoteCountB(11);
			  
			//compare.setCompareId(3); //when we test update, we need to uncomment setPolicyID(3)
			//CompareDAO.updateCompare( compare );//uncomment for test update
			
			
			//CompareDAO.addCompare(compare);
			
			
			//This is for searchCompare 
			/*compare=CompareDAO.searchCompare(13,12);
			System.out.println(compare.getCompareId());
			System.out.println(compare.getDiagramAId());
			System.out.println(compare.getDiagramBId());
			System.out.println(compare.getPromoteCountA());
			System.out.println(compare.getPromoteCountB());
			System.out.println(compare.getReportId());*/
			
			
			
			//CompareDAO.getCommentList(2);//?????????
			//this is for Arraylist test
			ArrayList<Comment> comment = new ArrayList<Comment>();
			
			 comment=CompareDAO.getCommentList(10);
		
			System.out.println(comment.get(0).getCommentId());
			System.out.println(comment.get(0).getCompareId());
			System.out.println(comment.get(0).getUserId());
			System.out.println(comment.get(0).getCommentText());
			System.out.println(comment.get(0).getCommentTime());
			System.out.println(comment.get(0).getReportId());
			 
		}

	

	
	
	
	
	
	
	
	
	
	
	
}
