package controller.diagramparser;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import domain.CD_Class;
import domain.Diagram;

//This class will be used to parse the file being uploaded. It will server as an "adapter" for parsing both kinds of files - Encore and XMI
//There are child classes to this class to handle Specific types for clases. For example, ClassDiagramParser inherits DiagramParser
public abstract class DiagramParser {

	private Diagram diagram;
	private EList<EObject> ecoreModel;
	//Constructor to load the Diagram 
	public DiagramParser(Diagram diagramObj){
		diagram = diagramObj;
		loadFileBinary();
	}
		
	public Diagram getDiagram() {
		return diagram;
	}


	private DiagramParser(){
		diagram = new Diagram();
	}
	//load the file from the fileLocation to the appropriate binary
	private void loadFileBinary(){
		//pick up the file from the location defined in the Diagram object
	}
	
	
}
