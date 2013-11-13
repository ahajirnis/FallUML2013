package controller.diagramparser;

import java.util.List;

import domain.CD_Attribute;
import domain.CD_Class;
import domain.CD_Relationship;
import domain.Diagram;

public class ENClassDiagramParser extends ClassDiagramParser{
	
	public ENClassDiagramParser (Diagram diagramObj){
		super(diagramObj);
	}

	@Override
	public List<CD_Class> getClasses() {
		// TODO Add code to fetch data from legacy ENCORE parser
		return null;
	}

	@Override
	public List<CD_Attribute> getAtrributes() {
		// TODO Add code to fetch data from legacy ENCORE parser
		return null;
	}

	@Override
	public List<CD_Relationship> getRelationships() {
		// TODO Add code to fetch data from legacy ENCORE parser
		return null;
	}
	
}
