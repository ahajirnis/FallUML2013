package test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import domain.Policy;
import repository.DbManager;
import repository.PolicyDAO;

public class test {

	@Test
	public void test() {
		System.out.println("d");
		Connection con = DbManager.getConnection();
		
		
		Policy policy = new Policy();
		policy.setPolicyDescription("NEW1");
		policy.setPolicyName("NEWtest1");
		policy.setPolicyLevel(3);
		//policy.setPolicyID(3);
	//PolicyDAO.UpdatePolicy( policy );
		PolicyDAO.addPolicy(policy);
		//PolicyDAO.removePolicy(1);
	}

}
