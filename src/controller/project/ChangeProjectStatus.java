package controller.project;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * This servlet is used to change the status of the project that is either enable or disable it depending whathas been selected
 */

public class ChangeProjectStatus extends HttpServlet{
	
	/*
	 * doPOst
	 * Check if the value of statusChangeTo by using request.getParam\
	 * enable-> project.setStatus("enable");
	 * else disable
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
	
		String status_State = request.getParameter("statusChangeTo");
		// if status change to enable
		if(status_State.equals("enable")){
			
			
		// if status change to disable	
		}else{
			
			
		}
		}
	}

