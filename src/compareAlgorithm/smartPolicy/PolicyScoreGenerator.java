package compareAlgorithm.smartPolicy;

import controller.diagramparser.ClassDiagramParser;
import controller.diagramparser.DiagramParser;
import domain.Diagram;
import domain.DiagramPolicyScore;
import domain.Policy;

public class PolicyScoreGenerator {

	public DiagramPolicyScore generateScore(Policy policy, DiagramParser diagramParser) throws Exception
	{
		Diagram diagram = diagramParser.getDiagram();
		if(diagram != null){
			switch (diagram.getDiagramType())
			{
				case CLASS:
					ClassDiagramScoreGenerator scoreGenerator = new ClassDiagramScoreGenerator(policy, (ClassDiagramParser)diagramParser);
					return scoreGenerator.generateScore();
				default:
					return new DiagramPolicyScore(); //Diagram Parser is an abstract class. So cannot directly instantiate it. 
			}
			
		}
		return new DiagramPolicyScore();
		
	}
	
	
}
