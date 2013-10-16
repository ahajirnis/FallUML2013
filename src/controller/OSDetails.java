package controller;

import java.io.IOException;
import java.util.Properties;

/**
 * Information class that stores the OS type of the Client and Server
 * and sets the path for Graphviz accordingly
 * @ doc author	Shrestha Prasanna
 */

public class OSDetails {
	
	static String clientOS;
	static String serverOS;
	public static String graphvizPath;
	

	public OSDetails(String serverOS) {
		setServerOS(serverOS);
		setGraphvizPath();
	}

	public static String getClientOS() {
		return clientOS;
	}
	
	public static void setClientOS(String userAgent) {
		
		if (userAgent.indexOf("win") >= 0 )
		{
			clientOS = "windows";
		}
		else if (userAgent.indexOf("mac") >= 0 )
		{
			clientOS = "mac";			
		}
		else if (userAgent.indexOf("nix") >= 0 || userAgent.indexOf("nux") >= 0 )
		{
			clientOS = "unix";
		}
	}
	
	public static String getServerOS() {
		return serverOS;
	}
	
	public static void setServerOS(String serverOSName) {
		
		if(serverOSName.indexOf("win") >= 0)
		{
			serverOS = "windows";
		}
		else if (serverOSName.indexOf("mac") >= 0)
		{
			serverOS = "mac";
		}
		else if (serverOSName.indexOf("nix") >= 0 || serverOSName.indexOf("nux") >= 0)
		{
			serverOS = "unix";
		}
	}
	
	public static String getGraphvizPath() {
		return graphvizPath;
	}

	public static void setGraphvizPath() {
		
		Properties prop = new Properties();		
		
		try {					
     	    prop.load(OSDetails.class.getClassLoader().getResourceAsStream("GraphVizPath.properties"));	 
     	    
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (serverOS.equals("windows"))
		{
			graphvizPath = prop.getProperty("WINDOWS");
		} else if (serverOS.equals("mac"))
		{
			graphvizPath = prop.getProperty("MAC");
		} else if (serverOS.equals("mac"))
		{
			graphvizPath = prop.getProperty("UNIX");
		}
	}

}
