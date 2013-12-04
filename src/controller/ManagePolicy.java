package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.PolicyDAO;
import repository.ProjectDAO;
import domain.Policy;
import domain.Project;

public class ManagePolicy extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//Renders manageProject.jsp
		System.out.println("enters manage ManagePolicy servlet");
	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/JSP/managePolicy.jsp");
	//dispatcher.forward(request, response);
	
	//retrive all policy.
	ArrayList<Policy> allPolicy = null;

	try {
		allPolicy = PolicyDAO.getAllPolicys();
		request.setAttribute("policys", allPolicy);

		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	dispatcher.forward(request, response);
	}
	
	
}
