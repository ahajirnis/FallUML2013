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
<title>Insert title here</title>

<script type="text/javascript">

	function deleteCont(){
		
		alert("Context will be deleted if you click OK. Are you sure you want to delete the context");
		
	}
</script>

<style type="text/css">

.contextTab{

}
.contul{
	list-style: none;
	font-weight: bold;
}
.contextMenu{
	float: left;
	padding-right: 30px; 
}
.table-hover{

width:80%;
	
}
</style>
</head>
<body>


<div class="contextMenu">
		<ul class="contul">
			<li><button class="btn btn-link" onclick="deleteCont()">Add Context</button> </li> <br/>
			<li><button class="btn btn-link">Delete Selected Context</button></li>
		</ul>
</div>
	
<div class="contextTab">

	<table class="table table-hover">
		<tr>
			<th>Select</th>
			<th>Context Name</th>
			<th>Projects</th>
			
			
		</tr>
		<tr>
			<td> <input type="checkbox"> </td>
			<td>Context 1</td>
			<td>Project</td>
		</tr>
	</table>
</div>

</body>
</html>