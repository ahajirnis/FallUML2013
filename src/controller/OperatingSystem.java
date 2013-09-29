package controller;

import java.io.IOException;
import java.util.Properties;

public class OperatingSystem {
	
	static String clientOS;
	static String serverOS;
	public static String graphvizPath;
	

	public OperatingSystem(String serverOS) {
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
			System.out.println("ClietOS: " + clientOS);
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
	
	public void setServerOS(String serverOS) {
		
		if(serverOS.indexOf("win") >= 0)
		{
			this.serverOS = "windows";
		}
		else if (serverOS.indexOf("mac") >= 0)
		{
			this.serverOS = "mac";
		}
		else if (serverOS.indexOf("nix") >= 0 || serverOS.indexOf("nux") >= 0)
		{
			this.serverOS = "unix";
		}
	}
	
	public static String getGraphvizPath() {
		return graphvizPath;
	}

	public void setGraphvizPath() {
		
		Properties prop = new Properties();		
		
		try {					
     	    prop.load(this.getClass().getClassLoader().getResourceAsStream("GraphVizPath.properties"));	 
     	    
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
		System.out.println("path: " + getGraphvizPath());
	}

}
