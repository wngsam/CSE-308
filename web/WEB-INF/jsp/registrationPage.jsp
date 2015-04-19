<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- HEADER -->
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="assets\img\favicon.ico">

    <title>Samdango</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="assets/css/nav_style.css" rel="stylesheet" media="screen">
    <link href="assets/css/footer_style.css" rel="stylesheet" media="screen">
    <link href="assets/css/bootstrap.css" rel="stylesheet" media="screen">
  </head>
<!-- /HEADER -->
  
<body role="document">
<jsp:include page="header.jsp" /><hr>

<!-- REGISTER BODY -->
<div class="row row-offcanvas"><center>
    <c:if test="${confirmation eq false}">
        <p style="color:red">E-mail already taken. Please try a different e-mail.</p>
    </c:if>
        
    <legend>
        <p class="text-primary" style="font-size:55px">Registration</p>
	<p class="text-default" style="font-size:20px">JOIN SAMDANGO FOR FREE!</p>
    </legend>
    
    <form:form action="registrationPage.htm" modelAttribute="user" method="post">
        
        <div class="form-group">
            <p class="text-warning" style="font-size:20px">First Name:</P>
            <form:input path="firstName" placeholder="First Name"/>
        </div>
        
        <div class="form-group">
            <p class="text-warning" style="font-size:20px">Last Name:</P>
            <form:input path="lastName" placeholder="Last Name"/>
        </div>
        
        <div class="form-group">
            <p class="text-warning" style="font-size:20px">E-mail:</P>
            <form:input path="email" placeholder="E-mail"/>
        </div>
        
        <div class="form-group">
            <p class="text-warning" style="font-size:20px">Password:</P>
            <form:password path="password" placeholder="Password"/>
        </div>
        
        <br><button type="submit" class="btn btn-success" >Register</button></br>
        
    </form:form>
        
</center></div>
<!-- /REGISTER BODY -->
<!-- PICS -->
<br><center>
<img src="assets\img\reg1.png">
&nbsp&nbsp&nbsp&nbsp
<img src="assets\img\reg2.png">
&nbsp&nbsp&nbsp&nbsp
<img src="assets\img\reg3.png">
&nbsp&nbsp&nbsp&nbsp
<img src="assets\img\reg4.png">
<br></br>
<br><img src="assets\img\reg5.png"></br>
</center></br>
<!-- /PICS -->

<jsp:include page="footer.jsp" />
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
  </body>
</html>