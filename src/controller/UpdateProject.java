package controller;

/**
* @author Siddhesh Jaiswal
*/

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Project;
import repository.ProjectDAO;

@WebServlet(name= "UpdateProject", urlPatterns = { "/UpdateProject"} )
public class UpdateProject extends HttpServlet{

	private static final long serialVersionUID = 1L;

/*
 * This servlet is used to update various fields of the project
 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("enters update project servlet");
		System.out.println(request.getParameter("projectID"));
		try {
			processRequest(request, response);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	try {
		processRequest(request, response);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}

	
}

private void processRequest(HttpServletRequest request,
		HttpServletResponse response) throws SQLException, ServletException, IOException {
	
	
	Boolean projectstatus = Boolean.valueOf(request.getParameter("selectstatus"));
	String projectname = request.getParameter("ProjectName");
	String description = request.getParameter("Description");
	
	//System.out.println(Integer.parseInt(request.getParameter("ProjectID")));
	
	int projectId = Integer.parseInt(request.getParameter("ProjectID"));
	//int projectId=1;
	
	try {
		if (ProjectDAO.exists(projectname)) {
			Failed(request, response);		//project already existed
		} else {
			
			Project projectObj = new Project(projectname, description, projectstatus, projectId);
			Success(request, response, projectObj);	//registration succeeded
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	} catch (ServletException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
}
	
	
private void Success(HttpServletRequest request,
		HttpServletResponse response,
		Project projectObj) throws ServletException, IOException, SQLException {
	
		ProjectDAO.updateProject(projectObj);
		System.out.println("Successfully updated project");
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/JSP/home.jsp");
	    dispatcher.forward(request, response);
}

private void Failed(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Project Already Exist");
		response.getWriter().write("FAILED");
}

	
}


