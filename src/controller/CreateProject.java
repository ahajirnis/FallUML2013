package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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

private void Success(HttpServletRequest request,
		HttpServletResponse response, RequestDispatcher dispatcher,
		Project projectObj) throws ServletException, IOException, SQLException {

	
	ProjectDAO.addProject(projectObj);
	
	System.out.println("Successfully added project");
	//HttpSession session = request.getSession(true);
	
    dispatcher.forward(request, response);
}

private void Failed(HttpServletRequest request,
		HttpServletResponse response, RequestDispatcher dispatcher) throws ServletException, IOException {
		System.out.println("Project Already Exist");
		response.getWriter().write("FAILED");
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		RequestDispatcher dispatcher = null;

		String projectname = request.getParameter("ProjectName");
		String projectid = request.getParameter("ProjectID");
		String startdate = request.getParameter("StartDate");
		String description = request.getParameter("Description");
		
		
	
			try {
				if (ProjectDAO.isExisted(projectname)) {
					Failed(request, response, dispatcher);		//project already existed
				} else {
					dispatcher= request.getRequestDispatcher("WEB-INF/JSP/manageProject.jsp");
					Project projectObj = new Project(projectid, projectname, description, startdate);
					Success(request, response, dispatcher, projectObj);	//registration succeeded
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
	}
		


