<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<!DOCTYPE html>
<html>
<body>
<h1>Update data from database in jsp</h1>
<c:forEach var="emp" items="${list}"> 
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