package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.MetricsDAO;
import repository.PolicyDAO;
import repository.ProjectDAO;
import domain.Attributes;
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
		
		String metric = request.getParameter("metric");
		
		Policy policy = new Policy();
		policy.setPolicyName(name); 
		policy.setPolicyLevel(level);
		policy.setPolicyDescription(description);
		
		PolicyDAO.addPolicy(policy);
		
		if (metric.equals("Attribute")){
			String idealAttribute = request.getParameter("addIdealAttribute");
			int ideal = Integer.parseInt(idealAttribute);
			String maxAttribute = request.getParameter("addMaxlAttribute");
			int max = Integer.parseInt(maxAttribute);
			String minAttribute = request.getParameter("addMinlAttribute");
			int min = Integer.parseInt(minAttribute);
			Attributes attribute = new Attributes();
			attribute.setIdealNoOfAttributes(ideal);
			attribute.setMaxNoOfAttributes(max);
			attribute.setMinNoOfAttributes(min);
			
			// attribute metric type id is 3 
			attribute.setMetricTypeId(3);
			
			// hard coding for test
			attribute.setMetricsWeight(1);
			attribute.setPolicyId(1);
			
	//		attribute.setPolicyId(policyId);
			try {
				MetricsDAO.addMetrics(attribute);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
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
