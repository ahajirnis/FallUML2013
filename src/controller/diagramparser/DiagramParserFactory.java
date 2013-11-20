package controller.diagramparser;

import java.io.IOException;

import domain.Diagram;
import domain.DiagramType;


/**
 * @author gauta_001
 * Factory class to create DiagramParser objects according to the diagramType and fileType properties.
 */
public class DiagramParserFactory {

	private final static String ENCORE = "ECORE";
	private final static String XMI = "XMI";

	
	//Use this method to create appropriate DiagramParser by supplying the Diagram object. The diagram object should have the diagramType and fileType properties
	// defined  in order for this factory method to be able to return the appropriate varient of the DiagramParser Object
	
	/**
	 * @param diagram
	 * @return
	 * Use this method to create appropriate DiagramParser by supplying the Diagram object. The diagram object should have the diagramType and fileType properties
	 * defined  in order for this factory method to be able to return the appropriate variant of the DiagramParser Object
	 * @throws IOException 
	 */
	public static DiagramParser getDiagramParser(Diagram diagram) throws IOException{
		
		switch (diagram.getDiagramType())
		{
			case CLASS:
				switch ((diagram.getFileType()))
				{
					case XMI:
						return new XMIClassDiagramParser(diagram);
					
					//ENCORE
					default :
						return new ENClassDiagramParser(diagram, diagram.getFilePath()); //Eliminate use of filepath
				}
			default:
				return new DiagramParser(diagram){}; //Diagram Parser is an abstract class. So cannot directly instantiate it. 
		}
		
		
	}
}
