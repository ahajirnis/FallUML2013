<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html style="background-color: #F3F3F3" xmlns="http://www.w3.org/1999/xhtml">
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<link rel="stylesheet" type="text/css" href="css/display.css"/>
	 <link rel="stylesheet" type="text/css" href="style.css"/>
	<link rel="stylesheet" type="text/css" href="promote.css"/>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
	<title>Promote a Diagram</title>
	<script type="text/javascript">
	    var comment = "";
	    $(document).ready(function(){
			
			$( "#dialog1" ).hide();
	
 			 $("#btn1").click(function(){
   			 $( "#dialog1" ).dialog();
 			 });
 			 $( "#dialog2" ).hide();
	
 			$("#btn2").click(function(){
   			 $( "#dialog2" ).dialog();
  		});

		var report = "reports/";
		var link = $("#reportLink").html();
		var reportLink = link.substring(link.lastIndexOf("/"));
		report = report + reportLink;
	    });
	    
	    function checkComments(dialog){
	    	switch(dialog) {
	    		case(1):comment = $("#comment1").val();
	    				break;
	    		case(2):comment = $("#comment2").val();
	    				break;
	    	}
		if(comment == ""){
		    alert("Please enter comment before promoting");
		    return false;
		}
		return true;
	    }
	</script>
	<style>
	
</style>
    </head>

    <body style="background-color: #F3F3F3">
	<div id="myHeader">
	    <h1 id="banner">Promote Diagram</h1>
	</div>
	<div id="promote-container">
	    <div class="file1" style="float:left;">
		
			<div class="image-wrap">
				<img  src="${requestScope.path1}"/>
			</div>		   
			
			<div class="center">
				<div class="promote-button-wrap">
					<button id="btn1" class="pbutton">Promote</button>
				</div>
		   
				<div class="comment1">
			 		Comment : 
			 		<div class="scroll1" >this is test for diagram1 we need to get the information from database</div>
				</div>
				<br/> 
			 
				<div id="dialog1">	 
	    			<form action="Promote" method="post" onsubmit="return checkComments(1)">
						Comment:<input type="text" id="comment1" name="comment"/><br/>
						<div class="sumbitbutton">
						<button id="button1" class="pbutton">Submit</button><br/></div>
						<input type="hidden" name="diagramId" value="${requestScope.diagramAId}"/>
					</form>
	    		</div>
	    	</div>
		</div>
	 
	    <div class="file2">
			<div class="image-wrap">
				<img src="${requestScope.path2}" />
			</div>
			<div class="center">
				
				<div class="promote-button-wrap">
					<button id="btn2" class="pbutton">Promote</button>
				</div>
				<div id="dialog2">	 
					<form action="Promote" method="post" onsubmit="return checkComments(2)">
						Comment:<input type="text" id="comment2" name="comment"/><br/>
						<div class="sumbitbutton">
		                	<!---- <input type="submit" id="button2" value="Promote" class="pbutton"/>--->
							<button id="button2" class="pbutton">Submit</button><br/>
							<input type="hidden" name="diagramId" value="${requestScope.diagramBId}"/>
						</div>
					</form>
				</div>
				<div class="comment2">
			 		Comment :
			 		<div class="scroll" >this is test for diagram2 we need to get the information from database</div>
			 	</div>
			 
		
			</div>
	    </div>
		<br/>
		<div class="reportfile" style="float:left;">
			<!---- <div id="reportLink" style="display: none">${requestScope.reportPath}</div>---->
		 
			<div  class="scrollreport">
			
			<pre>${requestScope.reportText}</pre>
			
			</div>
			<div class="promote-bottom-button-wrap">
				<div class="promote-bottom-button">
					<button  class="pbutton">Save As PDF</button>
					<button  class="pbutton">Suggestion Promote</button>
					<button  class="pbutton">Return</button>
				</div>
			</div>
		</div>
	</div>
	  
</body>

</html>
