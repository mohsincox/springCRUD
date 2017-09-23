<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
 <%@page import="java.sql.ResultSet"%> 
  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="emp" items="${list}">   
   <tr>  
   <td>${emp.id}</td>  
   <td>${emp.name}</td>  
   <td>${emp.salary}</td>  
   <td>${emp.designation}</td>  
   <td><a href="edit/${emp.id}">Edit</a></td>  
   <td><a href="delete/${emp.id}">Delete</a></td> 
   </tr>  
    
   </table>  
   
   <a href="empform">Add Employee</a>  
   
   
   

<!DOCTYPE html>
<html>
<body>
<h1>Update data from database in jsp</h1>
<form method="post" action="update">
<input type="hidden" name="id" value="${emp.id}">

<br>
Name:<br>
<input type="text" name="name" value="${emp.name}">
<br>
Salary:<br>
<input type="text" name="salary" value="${emp.salary}">
<br>
Designation:<br>
<input type="text" name="designation" value="${emp.designation}">
<br>
<br>
<input type="submit" value="Update">
</form>
</c:forEach> 
</body>
</html>