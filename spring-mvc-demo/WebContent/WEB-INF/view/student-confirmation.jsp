<!-- References the JSTL tag library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<title>Student Confirmation</title>
</head>

<body>
	
	<!-- Calls student.getFirstName() and student.getLastName() -->
	The student is confirmed: ${student.firstName} ${student.lastName}
	
	<br><br>
	
	<!-- Spring calls student.getCountry() -->
	Country: ${student.country}
	
	<br><br>
	
	Favorite Language: ${student.favoriteLanguage}
	
	Operating System(s): 
	
	<ul>
		<!-- "var" is how to set the variable name we're using so that the list can be iterated through in the output -->
		<c:forEach var="temp" items="${student.operatingSystems}">
		<li> ${temp} </li>
		
		</c:forEach>
	</ul>
	
</body>

</html>