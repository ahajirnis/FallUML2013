package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.ProjectDAO;

/*
 * This servlet is used to change the status of the project that is either enable or disable it depending whathas been selected
 */
@WebServlet(name= "ChangeProjectStatus", urlPatterns = { "/ChangeProjectStatus"} )
public class ChangeProjectStatus extends HttpServlet{

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	processRequest(request, response);
}

private void processRequest(HttpServletRequest request,
		HttpServletResponse response) {
	
	
	/*
	 * doPOst
	 * Check if the value of statusChangeTo by using request.getParam\
	 * enable-> project.setStatus("enable");
	 * else disable
	 */
	String projectstatus = request.getParameter("statusChangeto");
	
	if (projectstatus.equals("enable")){
		
	//	ProjectDAO.enableProject(projectName);
	}else{
		
	//	ProjectDAO.disableProject(projectName);
	}
	
	
}

}