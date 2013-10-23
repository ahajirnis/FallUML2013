<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
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
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">\
</script><link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css" />
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	

	$("#pop-up").hide();
	
	$("#addProj").click(function(){
		
		$("#pop-up").dialog();
	});
	
});
</script>
<style type="text/css">

.table-hover{

width:80%;
	
}
.projectMenu{
	margin:0px;
	float: left;
	padding-right: 20px;
	
}
.projul{
	list-style: none;
	font-weight: bold;
}
</style>
</head>
<body>
<div id="pop-up">
<form  class="form-horizontal" >
    
     <h1><strong>Add Project</strong></h1>
	 <br/>

 <div class="form-group">
    <label class="col-lg-2 control-label">ProjectName</label>
    <div class="col-lg-10">
      <input type="text" class="form-control" id="ProjectName" placeholder="ProjectName">
    </div>
  </div>
  <div class="form-group">
    <label class="col-lg-2 control-label">ProjectID</label>
    <div class="col-lg-10">
      <input type="text" class="form-control" id="ProjectID" placeholder="ProjectID">
    </div>
  </div>
 <div class="form-group">
    <label class="col-lg-2 control-label">StartDate</label>
    <div class="col-lg-10">
      <input type="text" class="form-control" id="StartDate" placeholder="StartDate">
    </div>
  </div>
   <div class="form-group">
    <label class="col-lg-2 control-label">Description</label>
    <div class="col-lg-10">
      <input type="text" class="form-control" id="Description" placeholder="Description">
    </div>
  </div>
<div >
			<input class="btn btn-primary"  type="submit" value="Add" />
</div>
</form>
</div>

<div class="outer">
	<div class="projectMenu">
		<ul class="projul">
			<li><button class="btn btn-link" id="addProj" onclick="">Add Project</button></li> <br/>
			<li><button class="btn btn-link">Delete Selected Project</button></li>
		</ul>
	
	</div>
	<div class="projectTab">
		<table class="table table-hover"> 
			<tr>
				<th>Select</th>
				<th>Project ID</th>
				<th>Project Name</th>
				<th>Start Date</th>
				<th>Description</th>
				
			</tr>
			<tr>
				<td><input type="checkbox" /></td>
				<td>projectId</td>
				<td><a href="Display" style="color:gray; ;">Project Name</a></td>
				<td>starDate</td>
				<td>description</td>
				<td></font></td>
						
			</tr>

		</table>
	</div>
</div>

</body>
</html>