package controller.diagramparser;

import java.util.ArrayList;
import java.util.List;

import domain.CD_Attribute;
import domain.CD_Class;
import domain.CD_Relationship;
import domain.Diagram;

public abstract class ClassDiagramParser extends DiagramParser{

	private final String ENCORE = "encore";
	private final String XMI = "xmi";
	
	public ClassDiagramParser (Diagram diagramObj){
		super(diagramObj);
	}
	
	public abstract List<CD_Attribute> getAtrributes();
//	{
//		
//		switch ((super.getDiagram().getFileType()))
//		{
//			case ENCORE:
//				//code here
//				break;
//			case XMI:
//				//code here
//				break;
//		}
//		
//		return new ArrayList<CD_Attribute>();
//	}
	
	public abstract List<CD_Class> getClasses();
	
	public abstract List<CD_Relationship> getRelationships();
	
}
