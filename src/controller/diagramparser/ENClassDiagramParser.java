package controller.diagramparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import controller.Compare;
import domain.CD_Attribute;
import domain.CD_Class;
import domain.CD_Operation;
import domain.CD_Relationship;
import domain.Diagram;

public class ENClassDiagramParser extends ClassDiagramParser{
	
	private EList<EObject> ecoreModel;
	private String ecorePath;
	
	public ENClassDiagramParser (Diagram diagramObj, String ecorePath) throws IOException{
		super(diagramObj);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new EcoreResourceFactoryImpl());
		this.ecorePath = diagramObj.getDiagramRealPath();
		System.out.println("ecorepath: " + this.ecorePath);
		this.parseModels();
	}
	
	/**
	 * Load the file into the ECore list
	 * 
	 * @throws IOException
	 */
	private void parseModels() throws IOException {
		this.setEcoreModel(this.loadModel(this.ecorePath));
	}
	
	/**
	 * Helper function to extract the contents in Ecore file
	 * 
	 * @param path
	 *            to ECore file
	 * @return EList<EObject> object
	 * @throws IOException
	 */
	private EList<EObject> loadModel(String path) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource res = new ResourceImpl();

		URI uri = URI.createFileURI(path);
		res = resourceSet.createResource(uri);
		res.load(Collections.emptyMap());
		EList<EObject> objList = (EList<EObject>) res.getContents();
		EObject pkg = objList.get(0);
		return pkg.eContents();
	}
	
	/**
	 * Returns the first model
	 * 
	 * @return EList<EObject> object
	 */
	public EList<EObject> getEcoreModel() {
		return ecoreModel;
	}

	/**
	 * Sets the model for first model reference
	 * 
	 * @param firstModel
	 */
	public void setEcoreModel(EList<EObject> ecoreModel) {
		this.ecoreModel = ecoreModel;
	}

	@Override
	public List<CD_Class> getClasses() {
		List<CD_Class> finalClassList = new ArrayList<CD_Class>();
		for (int i = 0; i < ecoreModel.size(); i++) {
			EClass ecoreClass = (EClass) ecoreModel.get(i);
			System.out.println("super Class:" + ecoreClass.getESuperTypes());
			CD_Class tmpClass = new CD_Class(ecoreClass);
			finalClassList.add(tmpClass);
		}
		return finalClassList;
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
	
	public List<CD_Operation> getOperations() {
		
		return null;
	}
	
}
