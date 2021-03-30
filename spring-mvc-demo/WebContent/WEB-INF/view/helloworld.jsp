<!DOCTYPE html>
<html>
<body>

Hello World of Spring!
<br><br>

Student name: ${param.studentName} <!--  studentName is the name of HTML form field -->

<br><br>

<!-- Read data from the model. "message" is the attribute name added in the model.addAttribute("message", result) line in the Controller -->
The message: ${message}

</body>
</html>