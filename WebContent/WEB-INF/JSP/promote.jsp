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
		var reportLink = link.substring(link.lastIndexOf("/"))
		report = report + reportLink;
		window.open(report,'_blank','fullscreen=yes');
		$("#button1").click(function(){
		    comment = $.trim($("#comment1").val());
		});
		$("#button2").click(function(){
		    comment = $.trim($("#comment2").val());
		});
		
		// resize images proportionally
		$('img').each(function() {
			var maxWidth = 450;
	        var maxHeight = 450;
	        
	        var ratio = 0;  // Used for aspect ratio
	        var width = $(this).width();    // Current image width
	        var height = $(this).height();  // Current image height
			
	        /* Make height/width at least the max size to begin with */
	        // Check if the current width is smaller than max
	        if(width < maxWidth){
	            ratio = maxWidth / width;   // get ratio for scaling image
	            height = height * ratio;    // Reset height to match scaled image
	            width = width * ratio;    // Reset width to match scaled image
	        }
	        // Check if current height is smaller than min
	        if(height < maxHeight){
	            ratio = maxHeight / height; // get ratio for scaling image
	            height = height * ratio;    // Reset height to match scaled image
	            width = width * ratio;    // Reset width to match scaled image
	        }
	        
	        /* Then reduce height/width to fit the max */
	        // Check if the current width is larger than the max
	        if(width > maxWidth){
	            ratio = maxWidth / width;   // get ratio for scaling image
	            height = height * ratio;    // Reset height to match scaled image
	            width = width * ratio;    // Reset width to match scaled image
	        }
	        // Check if current height is larger than max
	        if(height > maxHeight){
	            ratio = maxHeight / height; // get ratio for scaling image
	            height = height * ratio;    // Reset height to match scaled image
	            width = width * ratio;    // Reset width to match scaled image
	        }
	        
	        // Set CSS
	        $(this).css("height", height);   // Set new height
	        $(this).css("width", width);    // Scale width based on ratio
	    });
		
	    });
	    
	    function checkComments(){
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
	<div id="myContainer">
	    <div class="file1" style="float:left;">
		
		<img  src="${requestScope.path1}"/>
		   
		    <input type="hidden" name="imageId" value="${requestScope.val1}"/><br/>
			<div class="center">
			<br/>
			<button id="btn1" class="pbutton">Promote</button><br/>
		   
			<div class="comment1">
			 Comment : <br/>
			 <div class="scroll1" >this is test for diagram1 we need to get the information from database</div>
			 </div>
			 <br/> 
			 
		<div id="dialog1">	 
	    <form action="Promote" method="post" onsubmit="return checkComments()">
		Comment:<input type="text" id="comment1" name="comment"/><br/>
		<div class="sumbitbutton">
		
		<button id="button1" class="pbutton">Submit</button><br/></div>
		</form>
	    </div>
	    </div>
		</div>
	 
	    <div class="file2">
		<div class="img2pad">
		
		<img src="${requestScope.path2}" />
		</div>
		<div class="center">
		
		
		   
		    <input type="hidden" name="imageId" value="${requestScope.val2}"/>
		   <br/>
			<button id="btn2" class="pbutton">Promote</button><br/>
							<div id="dialog2">	 
									<form action="Promote" method="post" onsubmit="return checkComments()">
									Comment:<input type="text" id="comment2" name="comment"/><br/>
										<div class="sumbitbutton">
		                            <!---- <input type="submit" id="button2" value="Promote" class="pbutton"/>--->
									<button id="button2" class="pbutton">Submit</button><br/></div>
									</form>
							</div>
			<div class="comment2">
			 Comment :<br/><div class="scroll" >this is test for diagram2 we need to get the information from database</div>
			 </div>
			 
		
		</div>
	    </div>
		<br/>
		<div class="reportfile" style="float:left;">
		 <!---- <div id="reportLink" style="display: none">${requestScope.reportPath}</div>---->
		 
		<div class="scrollreport">this is test for report ,we will get the information from report</div>
		<div class="pdfbutton">
		<button  class="pbutton"  >Save PDF</button>
		<button  class="pbutton">Suggestion</button>
		<button  class="pbutton">Return</button>
		</div>
	</div></div>
	  
    </body>

</html>
