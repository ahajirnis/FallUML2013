package UnitTest;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import domain.Policy;
import repository.DbManager;
import repository.PolicyDAO;

public class PolicyDAOTest {

	



	

		@Test
		public void test() {
			System.out.println("d");
			
			
			
			Policy policy = new Policy();
			policy.setPolicyDescription("NEWtest");
			policy.setPolicyName("NEWtest");
			policy.setPolicyLevel(3);
			//policy.setPolicyID(3); //when we test updatePolicy, we need to uncomment setPolicyID(3)
		    //PolicyDAO.UpdatePolicy( policy );//uncomment for test update
			
			
			PolicyDAO.addPolicy(policy);
			//PolicyDAO.removePolicy(1);// it will remove policyID=1;
			 
		}

	

	
	
	
	
	
	
	
	
	
	
	
}
