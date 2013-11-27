package compareAlgorithm;

import java.io.File;
import java.io.IOException;

import controller.diagramparser.DiagramParser;
import controller.diagramparser.DiagramParserFactory;

import domain.Diagram;

public class DiagramCompare {

	private Diagram diagram1; // Path to the first diagram (E-Core file)
	private Diagram diagram2; // Path to the second diagram (E-Core file)
	private String pathToReport; // Path to the directory where the report is
									// generated
	private String reportText;
	private String DIRECTORY = "~/tmp/clubuml/reports/"; // Default directory
															// for report
															// generation
	
	public DiagramCompare(Diagram firstDiagram, Diagram secondDiagram, String reportPath){
		
		diagram1 = firstDiagram;
		diagram2 = secondDiagram;
		if (reportPath.equals("")) {
			pathToReport = DIRECTORY + new File(diagram1.getFilePath()).getName() + "_"
					+ new File(diagram2.getFilePath()).getName() + ".pdf";
			// pathToReport = DIRECTORY + "first_second.pdf";
		} else {
			pathToReport = reportPath +"/"+ new File(diagram1.getFilePath()).getName() + "_"
					+ new File(diagram2.getFilePath()).getName() + ".pdf";
			// this.pathToReport = reportPath + "first_second.pdf";
		}
	}
	
	/**
	 * Does the comparison of the specified diagrams in the initialize phase
	 *
	 * @return The path where the report has been generated
	 * @throws Exception
	 *             Mainly when the ECore files are not in proper format
	 */
	public String process() throws Exception {
		try {
			
			String conPath = diagram1.getConPath();
			System.out.println("Context Path: " + conPath);
			DiagramParserFactory factory = new DiagramParserFactory();
			DiagramParser diag1Parser = DiagramParserFactory.getDiagramParser(diagram1);
			DiagramParser diag2Parser = DiagramParserFactory.getDiagramParser(diagram2);
			// Set up the path and parse the file into ECore packages
			//MyParser parser = new MyParser(this.ecorePath1, this.ecorePath2);
			//parser.parseModels();

			// Set up the comparison algo
			UnifiedAlgorithm algoObj = new UnifiedAlgorithm(diag1Parser, diag2Parser, pathToReport);

			// Begin comparison
//			algoObj.testClasses();
			reportText = algoObj.compare();

		} catch (IOException e) {
			throw new Exception(e);
		}
		return pathToReport;
	}
	
	public String getReportText() {
		return reportText;
	}
	
	public void setReportText(String reportText) {
		this.reportText = reportText;
	}
}
