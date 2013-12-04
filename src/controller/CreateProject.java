package controller;

/**
* @author Siddhesh Jaiswal
*/

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.ProjectDAO;
import domain.Project;

/*
 * This class is used to create new projects and persist it in the database
 */
@WebServlet(name= "CreateProject", urlPatterns = { "/CreateProject"} )
public class CreateProject extends HttpServlet{
	private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	processRequest(request, response);
	
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		processRequest(request, response);

		System.out.println("enters create project servlet");
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String projectname = request.getParameter("ProjectName");
		String description = request.getParameter("Description");
		
		// statusChangesTo needs to be replaced with appropriate parameter (talk to Aish)
		Boolean enabled = Boolean.valueOf(request.getParameter("selectstatus"));
		
	
			try {
				if (ProjectDAO.exists(projectname)) {
					Failed(request, response);		//project already existed
				} else {
					
					Project projectObj = new Project(projectname, description, enabled);
					Success(request, response, projectObj);	//registration succeeded
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

private void Success(HttpServletRequest request,
		HttpServletResponse response,
		Project projectObj) throws ServletException, IOException, SQLException {

	
	ProjectDAO.addProject(projectObj);
	
	System.out.println("Successfully added project");
	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/JSP/home.jsp");
    dispatcher.forward(request, response);
    
//    ServletContext context = this.getServletContext();
//    RequestDispatcher dispatcher = context.getRequestDispatcher("/Home");
//    dispatcher.forward(request, response);
}

private void Failed(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Project Already Exist");
		response.getWriter().write("FAILED");
}
	}
		


