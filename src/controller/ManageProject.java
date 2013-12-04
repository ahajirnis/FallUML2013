package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Project;
import domain.User;
import repository.ProjectDAO;
import repository.UserDAO;


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
	
	private <T> ArrayList<T> subtract(ArrayList<T> list1, ArrayList<T> list2) {  
		ArrayList<T> result = new ArrayList<T>();  
        Set<T> set2 = new HashSet<T>(list2);  
        for (T t1 : list1) {  
            if( !set2.contains(t1) ) {  
                result.add(t1);  
            }  
        }  
        return result;  
    }  
	
	
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
	ArrayList<Integer> inactiveUsers;
	try {
		allProjects = ProjectDAO.getAllProjects();
		
		 activeProjects = new ArrayList<>();
		inactiveProjects = new ArrayList<>();
		inactiveUsers = new ArrayList<>();
		
		inactiveUsers = this.subtract(UserDAO.getAllUser("user"),UserDAO.getAllUser("userproject"));
		
		
		for(Project p: allProjects){
			if(p.getEnabled()){
				activeProjects.add(p);
			}else{
				inactiveProjects.add(p);
			}
			request.setAttribute("inactiveusers", inactiveUsers);
			request.setAttribute("activeprojects", activeProjects);
			request.setAttribute("inactiveprojects", inactiveProjects);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	// sends list of users to manage project.jsp
	ArrayList<User> allUser;
	
	try {
		allUser = UserDAO.getAllUser();
		
		 ArrayList<Object> activeUsers = new ArrayList<>();

		
		for(User u: allUser){
			
				activeUsers.add(u);
	
			}
			request.setAttribute("activeusers", activeUsers);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	dispatcher.forward(request, response);
	}
	

}
