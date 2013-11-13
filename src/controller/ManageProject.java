package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Project;
import repository.ProjectDAO;


/*
 * @author Aishwarya Srinivasan
*/

/*
 * Information class that contains all the features of ManagingProjects
 */

public class ManageProject extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//Renders manageProject.jsp
		System.out.println("enters manage project servlet");
	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/JSP/manageProject.jsp");
	//dispatcher.forward(request, response);
	ArrayList<Project> allProjects;
	ArrayList<Project> activeProjects;
	ArrayList<Project> inactiveProjects;
	try {
		allProjects = ProjectDAO.getAllProjects();
		
		 activeProjects = new ArrayList<>();
		inactiveProjects = new ArrayList<>();
		
		for(Project p: allProjects){
			if(p.getEnabled().equals("t")){
				activeProjects.add(p);
			}else{
				inactiveProjects.add(p);
			}
			request.setAttribute("activeprojects", activeProjects);
			request.setAttribute("inactiveprojects", inactiveProjects);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	dispatcher.forward(request, response);
	}
	

}
