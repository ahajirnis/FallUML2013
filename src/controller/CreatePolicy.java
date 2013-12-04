package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.PolicyDAO;
import repository.ProjectDAO;
import domain.Policy;
import domain.Project;

/**
 * Servlet implementation class CreatePolicy
 */
@WebServlet("/CreatePolicy")
public class CreatePolicy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePolicy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("PolicyName");
		String description = request.getParameter("PolicyDescription");	
		String levels = request.getParameter("PolicyLevel");
		int level = Integer.parseInt(levels);
		Policy policy = new Policy();
		policy.setPolicyName(name); 
		policy.setPolicyLevel(level);
		policy.setPolicyDescription(description);
		
		PolicyDAO.addPolicy(policy);
		try {
		Success(request, response);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	private void Success(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Successfully added project");
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/JSP/home.jsp");
	    dispatcher.forward(request, response);
	}

	private void Failed(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			System.out.println("Project Already Exist");
			response.getWriter().write("FAILED");
	}
}
