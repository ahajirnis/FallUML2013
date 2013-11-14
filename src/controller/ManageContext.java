package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.DiagramContext;
import repository.ContextDAO;

public class ManageContext extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//Renders manageProject.jsp
		System.out.println("enters manage project servlet");
	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/JSP/manageContext.jsp");
	//dispatcher.forward(request, response);
	ArrayList<DiagramContext> allContexts;
	ArrayList<DiagramContext> activeContexts = new ArrayList<>();
	ArrayList<DiagramContext> inactiveContexts =  new ArrayList<>();
	try {
		allContexts = ContextDAO.getAllContexts();
		
		for(DiagramContext c: allContexts){
			if(c.getEnabled() == true){
				activeContexts.add(c);
				
			}else{
				inactiveContexts.add(c);
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	request.setAttribute("activecontexts", activeContexts);
	request.setAttribute("inactivecontexts", inactiveContexts);
	dispatcher.forward(request, response);
	}
	
	
}
