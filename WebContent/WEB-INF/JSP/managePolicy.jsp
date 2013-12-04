<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<!-- BOOTSTRAP -->
<link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap.css"
	rel="stylesheet"/>
<link
	href="http://twitter.github.io/bootstrap/assets/css/bootstrap-responsive.css"
	rel="stylesheet"/>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script><link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css" />
<title>Insert title here</title>
<script type="text/javascript">

/* $(document).ready(function(){
	  $("addProj").click(function(){
	    $.get("demo_test.asp",function(data,status){
	      alert("Data: " + data + "\nStatus: " + status);
	    });
	  });
	}); */
	
 $(document).ready(function(){
	 var metric=0;
	 $("#Addattribute").click(function(){
	       metric=1;
		
	  });
	 $("#Addclass").click(function(){
	       metric=1;
		
	  });
	   $("#afteradd").click(function(event){
	       if(metric==1){
				
		     }
		   else {
				alert("please insert metric first");
	        	event.preventDefault();   
		   }
	  });
	   
	   var metric1=0;
		 $("#Updateattribute").click(function(){
		       metric1=1;
			
		  });
		 $("#Updateclass").click(function(){
		       metric1=1;
			
		  });
		   $("#afterupdate").click(function(event){
		       if(metric1==1){
					
			     }
			   else {
					alert("please insert metric first");
		        	event.preventDefault();   
			   }
		  });
	 
	 $( "#accordion" ).accordion({
		 heightStyle: "content"
	    });
	 $( "#dialogAddMetric" ).hide();
		
	  $("#btn3").click(function(even){
	    $( "#dialogAddMetric" ).dialog();
		event.preventDefault();
	  });
	  
	  $( "#accordionUpdate" ).accordion({
			 heightStyle: "content"
		    });
		 $( "#dialogUpdateMetric" ).hide();
			
		  $("#btn4").click(function(even){
		    $( "#dialogUpdateMetric" ).dialog();
			event.preventDefault();
		  });
		
	$( "#dialogUpdatePolicy" ).hide();
	
	  $("#UpdatePolicy").click(function(){
	    $( "#dialogUpdatePolicy" ).dialog();
	  });
	  
	  	$( "#dialogAddPolicy" ).hide();
		
	  $("#addPolicy").click(function(){
	    $( "#dialogAddPolicy" ).dialog();
	  });
	  
	  $(".Attributeable").attr('disabled','disabled');;
	  $("#Attribute").click(function(){
		    var thisCheck = $(this);

		    if (thisCheck.is (':checked'))
		      {
		       $("#attribute-group").css("color","black");
		       $(".Attributeable").removeAttr('disabled');
			  }
			else if (!(thisCheck.is (':checked')))
			{
			$("#attribute-group").css("color","gray");
			$(".Attributeable").attr('disabled','disabled');;
			}
		  });
		  
	  $(".Classesable").attr('disabled','disabled');;
	  $("#Classes").click(function(){
	    var thisCheck = $(this);
	    
	    if (thisCheck.is (':checked'))
	      {
	       $("#Classes-group").css("color","black");
	       $(".Classesable").removeAttr('disabled');
		  }
		else if (!(thisCheck.is (':checked')))
		{
		$("#Classes-group").css("color","gray");
		$(".Classesable").attr('disabled','disabled');;
		}
	  });
	  
	    $("#Associations").click(function(){
	    var thisCheck = $(this);

	    if (thisCheck.is (':checked'))
	      {
	       $("#Associations-group").css("color","black");
		  }
		else if (!(thisCheck.is (':checked')))
		{
		$("#Associations-group").css("color","gray");
		}
	  });
	  
	   $("#Multiplicities").click(function(){
	    var thisCheck = $(this);
	
	    if (thisCheck.is (':checked'))
	      {
	       $("#Multiplicities-group").css("color","black");
		  }
		else if (!(thisCheck.is (':checked')))
		{
		$("#Multiplicities-group").css("color","gray");
		}
	  });
	  
	   $("#submitadd").click(function(){
		   
		   if( $("#Attribute").is(":checked")){
			  
			   $( "#attribute-group" ).clone().prependTo( "#metricinformation" );
		   }
		   
		   else if ( $("#Classes").is(":checked")){
				  
			   $( "#Classes-group" ).clone().prependTo( "#metricinformation" );
			 
		   }

	   });
	  
	});
</script>
<style type="text/css">
#Description{
height:150px;


}

.table-hover{

width:100%;
	
}
.projectMenu{
	padding: 20px 350px;
	
}
.btn-link {

margin-left:40px;

}
.buttoninpopup{
margin-top:30px;
margin-left:-20px;

}

#enabledTab{
	padding: 30px;
}
.matrics-items{
margin-left: -10px;
}
#Addclass{width: 220px;
margin-left:0px;
}
 #Addattribute{width: 220px;
margin-left:0px;
}
#Updateattribute{width: 90px;
margin-left:0px;
}
#Updateclass{width: 90px;
margin-left:0px;
}
#Deleteclass 
{width: 90px;
margin-left:9px;

}
#Deleteattribute {width: 90px;
margin-left:9px;

}
#btn3{
margin-left:20px;}
#btn4{
margin-left:20px;}
#afteradd{margin-left:20px;}
#afterupdate{margin-left:20px;}
#menuPolicy li{
display: inline;;
}
.text{
text-align:left;


}

.matrics-items{
	margin:5px 0 5px 20px;
}

#attribute-group {
color:gray;}
#Classes-group{
color:gray;}
#Associations-group {
color:gray;}
#Multiplicities-group {
color:gray;}


</style>
</head>
<body>
<div id="menuPolicy">
  <ul>
    <li><button class="btn btn-link" id="addPolicy" onclick="">Add Policy</button> </li>
    <li> <button class="btn btn-link" id="UpdatePolicy" onclick="">Update Policy</button> </li>
 
  </ul>
</div>
<div id="dialogUpdatePolicy">
<form class="form-horizontal" action="UpdateProject" method="post">
    
     <h3><strong>Update Policy</strong></h3>
	 <br/>

 <div class="form-group">
    <label class="col-lg-2 control-label">Policy Name</label>
    <div class="col-lg-10">
      <input type="text" class="form-control" id="PolicyName" name ="PolicyName" placeholder="PolicyName"/>
    </div>
  </div>
   <div class="form-group">
    <label class="col-lg-2 control-label">Description</label>
    <div class="col-lg-10">
    
      <input type="text" class="form-control" id="PolicyDescription" name="PolicyDescription" placeholder="Description"/>
    </div>
  </div>
   <div class="form-group">
    <label class="col-lg-2 control-label">Policy Level</label>
   
    
    <div class="col-lg-10">
     <select class="form-control">
     
 	    <option>Context</option>
  		<option>Project</option>
 	    <option>User</option>
 
	</select>
    </div>
  </div>
 
  
  
<div class="buttoninpopup">
			<input class="btn btn-link"  type="submit" value="Update" id="afterupdate" />
			<%------------------------- update metric --%>
			 <button class="btn btn-link " id="btn4">Update Metric</button>
     <div id="dialogUpdateMetric" title="Update Metric">

  <div id="accordionUpdate">
	<h3>Attribute</h3>
  <div>
			<div class="matrics-items" ><input type="text" placeholder="IdealNo.of Attribute " class="form-control"   /></div>
			<div class="matrics-items" ><input type="text" placeholder="MaxNo.of Attribute " class="form-control"  /></div>
			<div class="matrics-items" ><input type="text" placeholder="MinNo.of Attribute " class="form-control"  /></div>
			<div>
			<input class="btn btn-link"  type="submit" value="Update" id="Updateattribute"/>
			<input class="btn btn-link"  type="button" value="Delete" id="Deleteattribute"/></div>
    </div>
  <h3>Classes</h3>
  <div>
			<div class="matrics-items" ><input type="text" placeholder="IdealNo.Of Classes" class="form-control"   /></div>
			<div class="matrics-items" ><input type="text" placeholder="MinNo.Of Classes " class="form-control"  /></div>
			<div class="matrics-items" ><input type="text" placeholder="MaxNo.Of Classes " class="form-control"  /></div>
            <div>
            <input class="btn btn-link"  type="submit" value="Update" id="Updateclass"/>
            <input class="btn btn-link"  type="button" value="Delete" id="Deleteclass"/></div>
     </div>
  <h3>Associations</h3>
  <div>
   <br/>
  </div>
  <h3>Multiplicities</h3>
  <div>
  </div>
</div>
 
  
</div>
			
			
			
			
			
			
			
			
			
</div>
</form>
</div>


<div id="dialogAddPolicy">
<form class="form-horizontal" action="CreatePolicy" method="get"> 
	     <h3><strong>Create Policy</strong></h3>
		 <br/>
	
	 <div class="form-group">
	    <label class="col-lg-2 control-label">Policy Name</label>
	    <div class="col-lg-10">
	      <input type="text" class="form-control" id="PolicyName" name ="PolicyName" placeholder="PolicyName"/>
	    </div>
	  </div>
 	  
	   <div class="form-group">
	    <label class="col-lg-2 control-label">Description</label>
	    <div class="col-lg-10">
	    
	      <input type="text" class="form-control" id="PolicyDescription" name="PolicyDescription" placeholder="Description"/>
	    </div>
	  </div>
	  
	  <div class="form-group">
	    <label class="col-lg-2 control-label">Policy Level</label>
	      <div class="col-lg-10">
	     <select name="PolicyLevel" class="form-control">
	 	    <option value="1">Context</option>
	  		<option value="1">Project</option>
	 	    <option value="1">User</option>
	 
		</select>
	    </div>
	  </div>
	  <br/>
	  <div id="metricinformation"></div>
	  
	<div class="buttoninpopup">
				<input class="btn btn-link"  type="submit" value="Create" id="afteradd" />

		<%------------------------- Add metric --%>
	 <button class="btn btn-link " id="btn3">ADD Metric</button>
	     <div id="dialogAddMetric" title="ADD Metric">
	
	

  
  <div class="text" id="attribute-group">
     <input type="checkbox" name="metric" value="Attribute" id="Attribute"/>Attribute<br/>
            <div class="matrics-items">Ideal No.of Attribute  <input type="text" maxlength="4" size="4" id="addIdealAttribute" class="Attributeable" ></div>
			<div class="matrics-items">Max No.of Attribute  <input type="text" maxlength="4" size="4"   id="addMaxlAttribute"class="Attributeable"></div>
			<div class="matrics-items"> Min No.of Attribute <input type="text"  maxlength="4" size="4" id="addMinlAttribute" class="Attributeable"></div>
  </div>
  
  
   <div class="text" id="Classes-group">
     <input type="checkbox"  name="metric" value="Classes" id="Classes"/>Classes<br/>
            <div class="matrics-items">Ideal No.of Classes  <input type="text" maxlength="4" size="4" class="Classesable" ></div>
			<div class="matrics-items"> Max No.of Classes  <input type="text"  maxlength="4" size="4" class="Classesable" ></div>
			<div class="matrics-items"> Min No.of Classes<input type="text" maxlength="4" size="4" class="Classesable" ></div>
  </div>
  
   <div class="text" id="Associations-group">
     <input type="checkbox" name="metric" id="Associations" />Associations<br/>
           
  </div>
  <div class="text" id="Multiplicities-group">
     <input type="checkbox" name="metric" id="Multiplicities"/>Multiplicities<br/>
           
  </div>
  <input class="btn btn-primary " id="submitadd" type="submit" value="Add" />
</div>			
	</div>
</form>
</div>

<div class="outer">
	<form action="" method="post">
	<div class="projectTab">
	<h2>Policy</h2>
		<table class="table table-hover" id=""> 
			<tr>
				<th>Select</th>
				<th>Policy ID</th>
				<th>Policy Name</th>
				<th>Policy level</th>
				<th>Policy Description</th>
				
				
			</tr>
			<c:forEach items="${policys}" var="policy">
				<tr>
					<td><input type="checkbox" /></td>
					<td>${policy.policyID}</td>
					<td>${policy.policyName}</td>
					<td>${policy.policyLevel}</td>
					<td>${policy.policyDescription}</td>						
				</tr>
			</c:forEach>

		</table>
		<input type="hidden" value="disable" name="statusChangeTo">
		</form>
		
		
	</div>
			

</div>


</body>
</html>