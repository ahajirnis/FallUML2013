/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repository.DiagramDAO;

/**
 *
 * @author wintor12
 */

/**
 * Information class that contains all the features of one Display
 * @ doc author	Rui Hou
 */
public class Display extends HttpServlet {

	// Comparer object
		private final static String COMPARE_OBJECT = "CompareObject";
		
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request
     * 			servlet request
     * @param response
     * 			servlet response
     * @throws ServletException
     * 			if a servlet-specific error occurs
     * @throws IOException
     * 			if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	// retrieve diagram list from database.

    	
    	// Always clear the comparer object when we're on the display page
    	// in case the user wants to perform a different merge.
    	HttpSession session = request.getSession();
    	session.setAttribute(COMPARE_OBJECT, null);
    	
    	int ProjectID;
    	if ((request.getParameter("ProjectID") != null))
    	{
    		ProjectID = Integer.parseInt(request.getParameter("ProjectID"));
    		session.setAttribute("projId", ProjectID);
    	}
    	else
    	{
    		ProjectID = Integer.parseInt(session.getAttribute("projId").toString());
    	}
    	
    	
    //Modified by Xuesong Meng
    	try{
    	ArrayList<domain.Diagram> diagrams = DiagramDAO.getDiagramList(ProjectID);
	    if (!diagrams.isEmpty()) {
		request.setAttribute("diagrams", diagrams);
		//set the first diagram in diagram list as the default display diagram..
		request.setAttribute("firstPath", diagrams.get(0).getFilePath() + ".png");
		request.setAttribute("diagramId1", diagrams.get(0).getDiagramId());
	    }
    	} catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    	
    	String userAgent = request.getHeader("User-Agent").toLowerCase();
    	OSDetails.setClientOS(userAgent);
    	
    	request.setAttribute("ProjectID", ProjectID);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/JSP/display.jsp");
    	dispatcher.forward(request, response);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request
     * 			servlet request
     * @param response
     * 			servlet response
     * @throws ServletException
     * 			if a servlet-specific error occurs
     * @throws IOException
     * 			if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request
     * 			servlet request
     * @param response
     * 			servlet response
     * @throws ServletException
     * 			if a servlet-specific error occurs
     * @throws IOException
     * 			if an I/O error occurss
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }
    
    public void init() throws ServletException {    	
    	
    	String serverOS = System.getProperty("os.name").toLowerCase();       	
    	OSDetails os = new OSDetails(serverOS);
    }
}
