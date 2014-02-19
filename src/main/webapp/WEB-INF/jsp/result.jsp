<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Galaxy</title>
</head>
<body>
	<h2>Simple CRUD using Spring MVC and MongoDB and AngularJs.</h2>
	<form action="galaxy/save" method="post">
		<input type="hidden" name="id"/>
		<label for="name">Galaxy Name</label>
		<input type="text" id="name" name="name"/>
		<input type="submit" value="Submit"/>
	</form>
	<table border="1">
		<c:forEach var="galaxy" items="${galaxyList}">
			<tr>
				<td>${galaxy.name}</td>
				<td>
					<input type="button" value="Delete" onclick="window.location='galaxy/delete?id=${galaxy.id}'"/>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>