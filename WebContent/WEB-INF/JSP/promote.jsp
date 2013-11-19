<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			var link = $("#reportLink").val();
			var reportLink = link.substring(link.lastIndexOf("/"));
			report = report + reportLink;
			$("#saveAsPdf").click(function(e){
			    window.open(report,'Download');
			});
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
	    <input type="hidden" id="reportLink" value="${requestScope.reportPath}"></input>
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
			 		<div class="scroll1" >
			 			<c:forEach items="${requestScope.diagram1comments}" var="comment">
			 			<div class="commenttime">(${comment.commentTime})</div>
			 			<div class="username">${comment.userName}&nbsp;:&nbsp;&nbsp;</div>
			 			<div class="comment">${comment.commentText}</div>
			 			</c:forEach>
			 		</div>
				</div>
				<br/> 
			 
				<div id="dialog1">	 
	    			<form action="Promote" method="post" onsubmit="return checkComments(1)">
						Comment:<input type="text" id="comment1" name="comment"/><br/>
						<div class="sumbitbutton">
						<button id="button1" class="pbutton">Submit</button><br/></div>
						<input type="hidden" name="diagramId" value="${requestScope.diagramAId}"/>
						<input type="hidden" name="compareId" value="${requestScope.compareId}"/>
						<input type="hidden" name="A" value="${requestScope.A}"/>
						<input type="hidden" name="B" value="${requestScope.B}"/>
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
							<input type="hidden" name="compareId" value="${requestScope.compareId}"/>
							<input type="hidden" name="A" value="${requestScope.A}"/>
							<input type="hidden" name="B" value="${requestScope.B}"/>
						</div>
					</form>
				</div>
				<div class="comment2">
			 		Comment :
			 		<div class="scroll" >
			 			<c:forEach items="${requestScope.diagram2comments}" var="comment">
			 			<div class="commenttime">(${comment.commentTime})</div>
			 			<div class="username">${comment.userName}&nbsp;:&nbsp;&nbsp;</div>
			 			<div class="comment">${comment.commentText}</div>
			 			</c:forEach>
			 		</div>
			 	</div>
			 
		
			</div>
	    </div>
	    <p>${requestScope.compareId}</p>
		<br/>
		<div class="reportfile" style="float:left;">
			<!---- <div id="reportLink" style="display: none">${requestScope.reportPath}</div>---->
		 
			<div  class="scrollreport">
			
			<pre>${requestScope.reportText}</pre>
			
			</div>
			<div class="promote-bottom-button-wrap">
				<div class="promote-bottom-button">
					<button id="saveAsPdf" class="pbutton">Save As PDF</button>
					<button  class="pbutton">Suggestion Promote</button>
					<button  class="pbutton">Return</button>
				</div>
			</div>
		</div>
	</div>
	  
</body>

</html>
