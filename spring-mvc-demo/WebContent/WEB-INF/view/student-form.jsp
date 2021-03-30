<!-- He didn't explain this in the video, but I'm guessing it's needed to make the form work properly -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
</head>

<body>

	<!-- 	The modelAttribute name ("student") must match the name we gave it in the controller class -->
	<form:form action="processForm" modelAttribute="student"> 
	
		First Name: <form:input path="firstName" />
		
		<br><br>
		
		Last Name: <form:input path="lastName" />
		
		<br><br>
		
		<!-- DROP DOWN MENU -->
		
		Country:
		
		<%-- Manual method example
		 	
			<!-- Spring will call .setCountry when this form is submitted -->
			<form:select path="country">
				<form:option value="Brazil" label="Brazil" />
				<form:option value="France" label="France" />
				<form:option value="Germany" label="Germany" />
				<form:option value="India" label="India" />
			</form:select>
		
		 --%>
		 
		 <form:select path="country">
		 	<%-- note the pluralization of "options" --%>
		 	<form:options items="${student.countryOptions}" />
		 </form:select>
		<br><br>
		
		<!-- RADIO BUTTONS -->
		
		Favorite Language:
		
		Java <form:radiobutton path="favoriteLanguage" value="Java" />
		C# <form:radiobutton path="favoriteLanguage" value="C" />
		PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />
		
		<br><br>
		<input type="submit" value="submit" />
		
		<!-- CHECK BOXES -->
		
		<br><br>
		Operating Systems:
		
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		macOS <form:checkbox path="operatingSystems" value="macOS"/>
		Windows <form:checkbox path="operatingSystems" value="Windows"/>
	
	</form:form>
	
</body>

</html>