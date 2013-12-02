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
<title>Insert title here</title>

<script type="text/javascript">

	
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
#menu li{
display: inline;
}
</style>
</head>
<body>


<div id="menu">
		<ul class="contul">
			<li><button class="btn btn-link" onclick="()">Add Context</button> </li> 
			<li><button class="btn btn-link">Delete Selected Context</button></li>
		</ul>
</div>
	
<div class="contextTab">
<h2>Current Contexts</h2>
	<table class="table table-hover">
		<tr>
			<th>Select</th>
			<th>Context Name</th>
			<th>Description</th>
			<th>Projects</th>
			
			
		</tr>
		<c:forEach items="${activecontexts}" var="contexts">
			<tr>
			<td> <input type="checkbox"> </td>
			<td>${contexts.diagramContextName }</td>
			<td>${contexts.diagramContextDescription }</td>
			<td>Project</td>
		</tr>
		</c:forEach>
		
	</table>
	
	
	<h2>Deactive Contexts</h2>
	<table class="table table-hover">
		<tr>
			<th>Select</th>
			<th>Context Name</th>
			<th>Description</th>
			<th>Projects</th>
			
			
		</tr>
		<c:forEach items="${activecontexts}" var="contexts">
			<tr>
			<td> <input type="checkbox"> </td>
			<td>${contexts.diagramContextName }</td>
			<td>${contexts.diagramContextDescription }</td>
			<td>Project</td>
		</tr>
		</c:forEach>
		
	</table>
</div>


</body>
</html>