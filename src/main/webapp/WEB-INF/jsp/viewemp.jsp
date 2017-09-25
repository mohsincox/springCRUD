<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Browser</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.15/datatables.min.css"/>
	<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.15/datatables.min.js"></script>
</head>
<body> 
<div class="container">
<table class="table table-bordered table-hover table-striped" id="myTable">  
<thead>
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Salary</th>
		<th>Designation</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr> 
	</thead>
	<tbody>
   <c:forEach var="emp" items="${list}">   
    <tr>  
	    <td>${emp.id}</td>  
	    <td>${emp.name}</td>  
	    <td>${emp.salary}</td>  
	    <td>${emp.designation}</td>  
	    <td><a href="edit/${emp.id}" class="btn btn-success btn-xs">Edit</a></td>  
	   	<td><a href="delete/${emp.id}" class="btn btn-danger btn-xs">Delete</a></td> 
    </tr>  
   </c:forEach>  
   </tbody> 
</table>  
   
<a href="empform" class="btn btn-primary btn-xs">Add Employee</a> 
 </div>
</body>
<script type="text/javascript">
$(document).ready(function(){
    $('#myTable').DataTable();
});
</script>
</html>