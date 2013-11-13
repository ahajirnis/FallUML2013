package compareAlgorithm.smartPolicy;

import controller.diagramparser.DiagramParser;
import controller.diagramparser.ENClassDiagramParser;
import controller.diagramparser.XMIClassDiagramParser;
import domain.Diagram;
import domain.DiagramPolicyScore;
import domain.Policy;

public class PolicyScoreGenerator {

	public DiagramPolicyScore generateScore(Policy policy, DiagramParser diagramParser)
	{
		Diagram diagram = diagramParser.getDiagram();
		if(diagram != null){
			switch (diagram.getDiagramType())
			{
				case CLASS:
					ClassDiagramScoreGenerator scoreGenerator = new ClassDiagramScoreGenerator(policy, diagramParser);
					return scoreGenerator.generateScore();
				default:
					return new DiagramPolicyScore(); //Diagram Parser is an abstract class. So cannot directly instantiate it. 
			}
			
		}
		return new DiagramPolicyScore();
		
	}
	
	
}
