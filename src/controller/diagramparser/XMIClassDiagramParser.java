package controller.diagramparser;

import java.util.ArrayList;
import java.util.List;

import domain.CD_Attribute;
import domain.CD_Class;
import domain.CD_Relationship;
import domain.Diagram;
import controller.comparer.xmi.*;

public class XMIClassDiagramParser extends ClassDiagramParser{
	
	XmiClassDiagramParser oldParser;
	
	public XMIClassDiagramParser (Diagram diagramObj){
		super(diagramObj);
		oldParser = new XmiClassDiagramParser(diagramObj.getFilePath(), diagramObj.getNotationFilePath() + diagramObj.getNotationFileName());
	}

	@Override
	public List<CD_Class> getClasses() {
		List<CD_Class> finalClassList = new ArrayList<CD_Class>();
		List<XmiClassElement> classes = oldParser.getClassElements();
		for(XmiClassElement xmiClass : classes)
		{
			CD_Class tmpClass = new CD_Class(xmiClass);
			finalClassList.add(tmpClass);
			
		}
		return null;
	}

	@Override
	public List<CD_Attribute> getAtrributes() {
		// TODO Add code to fetch data from legacy XMI parser
		return null;
	}

	@Override
	public List<CD_Relationship> getRelationships() {
		// TODO Add code to fetch data from legacy XMI parser
		return null;
	}
	
}
