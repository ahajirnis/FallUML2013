<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<!-- BOOTSTRAP -->
<link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap.css"
	rel="stylesheet">
	
<link
	href="http://twitter.github.io/bootstrap/assets/css/bootstrap-responsive.css"
	rel="stylesheet">
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

	
	$( "#dialogUpdate" ).hide();
	
	  $("#UpdateProj").click(function(){
		  
		  var form = document.getElementById("ChangeProjectStatus");
		  var valueSelected ;
		  for(var i = 0; i < form.projIdradio.length; i++){
			  if(form.projIdradio[i].checked)
			  {
	                        valueSelected = form.projIdradio[i].value;
			  }
		  }
		
		 console.log("this is selected "+valueSelected);
		 
		 $( "#dialogUpdate" ).dialog();
	    
	  });
	  
	  	$( "#dialogAdd" ).hide();
		
	  $("#addProj").click(function(){
	    $( "#dialogAdd" ).dialog();
	  });
	
}); 
</script>


<script type="text/javascript">

function submitToDisplay(){
	var a = document.getElementById("ProjectIdBtn").value;
	document.getElementById("submitprojid").value = a;
	document.getElementById("sendtodisplay").submit();
	
}
</script>
<style type="text/css">
#Description{
height:150px;


}
.control-label{


font-size: 14px;
font-weight: bold;

}

label {text-align:left;}

.table-hover{

width:100%;
	
}
.projectMenu{
	padding: 20px 350px;
	
}
.btn-info {

margin-left:40px;


}

#enabledTab{
	padding: 30px;
}
.buttoninpopup{
margin-top:30px;
margin-left:30px;

}
#menu li{
display: inline;;
}
</style>
</head>
<body>
<div id="dialogUpdate">
<form class="form-horizontal" action="UpdateProject" method="post">
    
     <h3><strong>Update Project</strong></h3>
	 <br/>

 <div class="form-group">
    <label class="col-lg-2 control-label">Project Name</label>
    <div class="col-lg-10">
      <input type="text" class="form-control" id="ProjectName" name ="ProjectName" placeholder="ProjectName"/>
    </div>
  </div>
   <div class="form-group">
    <label class="col-lg-2 control-label">Description</label>
    <div class="col-lg-10">
    
      <input type="text" class="form-control" id="Description" name="Description" placeholder="Description"/>
    </div>
  </div>
 
  <div class="form-group">
    <label class="col-lg-2 control-label">Project Status</label>
    <div class="col-lg-10">
     <select name="updateststus">
     	<option value="true">Active Project</option>
     	<option value="true">Disabled Project</option>
     </select>
    </div>
  </div>
  
  
  <div id="dialogAddUser">
  	
  </div>
  
  
<div class="buttoninpopup">
			<input class="btn btn-info"  type="submit" value="Update" />
</div>

<input type="hidden" id="projectID" >

</form>
</div>


<div id="dialogAdd">
<form class="form-horizontal" action="CreateProject" method="post">
    
    

 <div class="form-group">
    <label class="col-lg-2 control-label">Project Name</label>
    <div class="col-lg-10">
      <input type="text" class="form-control" id="ProjectName" name ="ProjectName" placeholder="ProjectName"/>
    </div>
  </div>
  

 
  
   <div class="form-group">
    <label class="col-lg-2 control-label">Description</label>
    <div class="col-lg-10">
    
      <input type="text" class="form-control" id="Description" name="Description" placeholder="Description"/>
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-lg-2 control-label">Project Status</label>
    <div class="col-lg-10">
     <select name="selectstatus">
     	<option value="true">Active Project</option>
     	<option value="false">Disabled Project</option>
     </select>
    </div>
  </div>
  
<div class="buttoninpopup">
			<input class="btn btn-info"  type="submit" value="Add Project" />
			
</div>
</form>
</div>


	 
	  
		
<div id="menu">
  <ul>
    <li><button class="btn btn-link" id="addProj" onclick="">Add Project</button> </li>
    <li> <button class="btn btn-link" id="UpdateProj" onclick="">Update Project</button> </li>
    <li><button class="btn btn-link">Add User</button></li>
  </ul>
</div>
		
<!--   Active Project Table-->


<div class="outer">
	<form action="ChangeProjectStatus" method="post" id="ChangeProjectStatus">
	<div class="projectTab">
	<h2>Current Projects</h2>
		<table class="table table-hover" id="enabledTab"> 
			<tr>
				<th>Select</th>
				<th>Project ID</th>
				<th>Project Name</th>
				<th>Start Date</th>
				<th>Description<th>Status</th>
				<th></th>
			</tr>
			<c:forEach items="${activeprojects}" var="project">
			<tr>
				<td><input type="radio" value="${project.projectId }" id="projIdradio" name="projIdradio"/></td>
				<td>${project.projectId}</td>
				<td><button  type="button" class="btn btn-link" value="${project.projectId }" onclick="submitToDisplay()" name="ProjectIdBtn">${project.projectName }</button></td>
				<td>${project.startDate}</td>
				<td>${projetct.description}</td>
				
				<td><button class="btn btn-link" type="submit">Disable</button></td> 
					
			</tr>
	</c:forEach>
		</table>
<!-- 	sid changed from disable to false to match boolean value -->
		<input type="hidden" value= false name="statusChangeTo">
		<input type="hidden" name="ProjectId" value="${project.projectId }">
		<input type="hidden" name="redirect" value="false">
		</form>
		
		
		<form action="Display" method="get" id="sendtodisplay">
			<input type="hidden" name="ProjectID" id="submitprojid">
		</form>

<!--  inactive Project Table -->


	<form action="ChangeProjectStatus" method="post">
		<h2>Disabled Projects</h2>
		<table class="table table-hover" id="disabledTab"> 
		
		
			<tr>
				<th>Select</th>
				<th>Project ID</th>
				<th>Project Name</th>
				<th>Start Date</th>
				<th>Description</th>
				<th></th>
			</tr>
		<c:forEach items="${inactiveprojects}" var="project">
			<tr>
				<td><input type="checkbox" /></td>
				<td>${project.projectId}</td>
				<td><a  style="color:gray ;">${project.projectName }</a></td>
				<td>${project.startDate}</td>
				<td>${projetct.description}</td>
				
				<td><button class="btn btn-link" type="submit">Enable</button></td>
						
			</tr>
	</c:forEach>
	
		</table>
		<!-- 	sid changed from enabled to true to match boolean value -->
		<input type="hidden" value= false name="statusChangeTo">
		
		<input type="hidden" name="ProjectId" value="${project.projectId }">
		<input type="hidden" name="redirect" value="false">
		</form>
	</div>
	
	<div class="projectMenu">
		
		
	
	</div>
</div>

</body>
</html>
