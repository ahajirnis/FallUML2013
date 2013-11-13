<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
	
	<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
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
	
	  $("#UpdatePolicy").click(function(){
	    $( "#dialogUpdate" ).dialog();
	  });
	  
	  	$( "#dialogAdd" ).hide();
		
	  $("#addPolicy").click(function(){
	    $( "#dialogAdd" ).dialog();
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
.btn-info {

margin-left:40px;

}
.buttoninpopup{
margin-top:30px;
margin-left:30px;

}

#enabledTab{
	padding: 30px;
}
</style>
</head>
<body>
<div id="dialogUpdate">
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
    
      <input type="text" class="form-control" id="PolicyLevel" name="PolicyLevel" placeholder="Level"/>
    </div>
  </div>
 
  
  
<div class="buttoninpopup">
			<input class="btn btn-info"  type="submit" value="Update" />
</div>
</form>
</div>


<div id="dialogAdd">
<form class="form-horizontal" action="CreatePolicy" method="post">
    
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
      <input type="text" class="form-control" id="PolicyLevel" name="PolicyLevel" placeholder="Level"/>
    </div>
  </div>
  
<div class="buttoninpopup">
			<input class="btn btn-info"  type="submit" value="Create" />
			
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
			<tr>
				<td><input type="checkbox" /></td>
				<td>Policy ID</td>
				<td>Policy NamE</td>
				<td>Policy Level</td>
				<td>Policy Description</td>
							</tr>

		</table>
		<input type="hidden" value="disable" name="statusChangeTo">
		</form>
		
		
	</div>
	
	<div class="projectMenu">
		
		<button class="btn btn-info" id="addPolicy" onclick="">Add Policy</button> 
	    <button class="btn btn-info" id="UpdatePolicy" >Update Policy</button>
		
	
	</div>
</div>

</body>
</html>