package compareAlgorithm.smartPolicy;

import controller.diagramparser.DiagramParser;
import domain.DiagramPolicyScore;
import domain.MatricsObject;
import domain.Policy;


public class ClassDiagramScoreGenerator {

	private Policy policy;
	private DiagramParser diagramParser;
	private int classScore;
	private int attributesScore;
	private int assicoationScore;
	private int multiplicityScore;
	private int finalScore;
	private DiagramPolicyScore policyScore;
	
	protected ClassDiagramScoreGenerator(Policy policyApplied, DiagramParser parser)
	{
		policy = policyApplied;
		diagramParser = parser;
		policyScore.setDiagramID(diagramParser.getDiagram().getDiagramId());
		policyScore.setPolicyID(policy.getPolicyID());
					
	}
	
	public DiagramPolicyScore generateScore(){
		
		for(MatricsObject mObj : policy.getMatricsObjects())
		{
			policyScore.setPolicyScore(GenerateMatricScore(diagramParser, mObj));
		}
		return policyScore;
	}
	
	private int GenerateMatricScore(DiagramParser diagramParser, MatricsObject mObj){
		
		switch (mObj.getMatricsType()){
		
			case CLASSES:
				classScore = scoreClasses(mObj);
			case ATTRIBUTES:
				attributesScore = scoreAttributes(mObj);
			case MULTIPLICITIES:
				multiplicityScore = scoreMultiplicity(mObj);
			case ASSOCIATIONS:
				assicoationScore = scoreAssociations(mObj);
			case NOTDEFINED:
		
		}
		
		
		return aggregateScores();
	}
	
	public int aggregateScores(){
		
		finalScore = classScore + attributesScore + multiplicityScore + assicoationScore; //TO DO - Add weights
		//Logic to total Score
		return finalScore;
		
	}
	
	private int scoreClasses(MatricsObject mObj){
		int score = 0;
		//Code here
		return score;
	}
	private int scoreAttributes(MatricsObject mObj){
		int score = 0;
		//Code here
		return score;
	}
	private int scoreMultiplicity(MatricsObject mObj){
		int score = 0;
		//Code here
		return score;
	}
	private int scoreAssociations(MatricsObject mObj){
		int score = 0;
		//Code here
		return score;
	}
}
