package controller.diagramparser;

import domain.Diagram;
import domain.DiagramType;


/**
 * @author gauta_001
 * Factory class to create DiagramParser objects according to the diagramType and fileType properties.
 */
public class DiagramParserFactory {

	private final String ENCORE = "encore";
	private final String XMI = "xmi";
	private final String CLASS = "class";
	
	//Use this method to create appropriate DiagramParser by supplying the Diagram object. The diagram object should have the diagramType and fileType properties
	// defined  in order for this factory method to be able to return the appropriate varient of the DiagramParser Object
	
	/**
	 * @param diagram
	 * @return
	 * Use this method to create appropriate DiagramParser by supplying the Diagram object. The diagram object should have the diagramType and fileType properties
	 * defined  in order for this factory method to be able to return the appropriate variant of the DiagramParser Object
	 */
	public DiagramParser getDiagramParser(Diagram diagram){
		
		switch (diagram.getDiagramType())
		{
			case CLASS:
				switch ((diagram.getFileType()))
				{
					case XMI:
						return new XMIClassDiagramParser(diagram);
					
					//ENCORE
					default :
						return new ENClassDiagramParser(diagram);
				}
			default:
				return new DiagramParser(diagram){}; //Diagram Parser is an abstract class. So cannot directly instantiate it. 
		}
		
		
	}
}
