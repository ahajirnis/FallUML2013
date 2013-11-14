package controller.diagramparser;

import java.util.ArrayList;
import java.util.List;

import domain.CD_Attribute;
import domain.CD_Class;
import domain.CD_Relationship;
import domain.Diagram;
import controller.comparer.xmi.*;
import controller.upload.FileInfo;
import controller.upload.UploadProcessorFactory;
import controller.util.FileUtil;

public class XMIClassDiagramParser extends ClassDiagramParser{
	
	XmiClassDiagramParser oldParser;
	private String umlFile;
	private String notationFile;
	
	public XMIClassDiagramParser (Diagram diagramObj){
		super(diagramObj);
		System.out.println("context Path: " + diagramObj.getConPath());
		setXmiFilePath(diagramObj);
		oldParser = new XmiClassDiagramParser(getUmlFile(), getNotationFile());
	}

	@Override
	public List<CD_Class> getClasses() {
		List<CD_Class> finalClassList = new ArrayList<CD_Class>();
		List<XmiClassElement> classes = oldParser.getClassElements();
		for(XmiClassElement xmiClass : classes)
		{
			CD_Class tmpClass = new CD_Class(xmiClass);
			
			String genName = xmiClass.getGeneralization().get(0).getName();
			finalClassList.add(tmpClass);
			
		}
		return finalClassList;
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
	
	public void setXmiFilePath(Diagram diagramObj) {
		
		// to get the .uml file names:
		String UmlFileName = diagramObj.getFilePath().substring(
				diagramObj.getFilePath().lastIndexOf("/") + 1,
				diagramObj.getFilePath().length());
		
		// to get the UML path without the file names:
		String UmlPath = diagramObj.getFilePath().substring(0,
				diagramObj.getFilePath().lastIndexOf("/") + 1);
		
		List<FileInfo> fileInfoList = new ArrayList<FileInfo>();
		
		String notationFilePath = diagramObj.getNotationFilePath().replaceAll("\\\\", "/");
		
		FileInfo fi1_not = new FileInfo(diagramObj.getConPath() + diagramObj.getNotationFilePath(), diagramObj.getNotationFileName(), "");
		FileInfo fi1_uml = new FileInfo(diagramObj.getConPath() + UmlPath, UmlFileName, "");
		
		fileInfoList.add(fi1_not); 
		fileInfoList.add(fi1_uml);
		
		FileInfo classDiagramNotation = FileUtil.getFile(
				UploadProcessorFactory.NOTATION_EXTENSION, fileInfoList);
		FileInfo classDiagramUml = FileUtil.getFile(
				UploadProcessorFactory.UML_EXTENSION, fileInfoList);
		
		umlFile = classDiagramUml.getDestFilePath() + classDiagramUml.getFileName();
		notationFile = classDiagramNotation.getDestFilePath() + classDiagramNotation.getFileName();
		
		System.out.println("Uml File: " + umlFile);
		System.out.println("Notation File: " + notationFile);
		
	}

	public String getUmlFile() {
		return umlFile;
	}


	public String getNotationFile() {
		return notationFile;
	}
	
	
	
}
