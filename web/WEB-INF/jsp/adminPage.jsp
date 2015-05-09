<%-- 
    Document   : adminPage
    Created on : May 2, 2015, 2:06:15 PM
    Author     : Sam W.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<jsp:include page="header.jsp"/>

 <!-- ADMIN NAV BAR -->
 <div class="container-fluid">
    <div class="row">
        <div class="col-lg-12">
             <div class="page-header">
                 <h1>${currentPerson.firstName}'s Account</h1>
             </div>
             <ul class="nav nav-tabs">
                 <li class="active"><a href="#overview" data-toggle="tab" aria-expanded="true">ADD</a></li>
                 <li><a href="#adduser" data-toggle="tab" aria-expanded="false">FIND USER</a></li>
                 <li><a href="#addmovie" data-toggle="tab" aria-expanded="false">FIND MOVIE</a></li>
             </ul>
            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade active in" id="overview">
                    <div class="container">                        
                        <hr><p class="text-danger">ADD USER</p>
                        <form:form action="adduser.htm" modelAttribute="user" method="post">
        
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
                            
                            
                            
                            <div class="form-group">
                                <p class="text-warning" style="font-size:20px">Zipcode:</P>
                                <form:input path="zipCode" placeholder="11790"/>
                            </div>
                            
                            <br><button type="submit" class="btn btn-success" >Add User</button></br>
                        </form:form>
                        
                        <hr><p class="text-danger">ADD MOVIE</p>
                        
                        <form:form action="addmovie.htm" modelAttribute="movie" method="post">
        
                            
                            
                            <br><button type="submit" class="btn btn-success" >Add Movie</button></br>
                        </form:form>
                        
                        <hr>
                        
                    </div>
                </div>
                <div class="tab-pane fade" id="adduser">
                    <div class="fluid-container">
                     <p>Find User</p>
                        <form id="findUser" method="POST" action="finduser.htm">
                            <input type="email" class="form-control input-sm" name="email" placeholder="E-mail">
                            <button type="submit" class="btn btn-success btn-sm">Search</button>
                        </form>
                    </div>
                </div>
                <div class="tab-pane fade" id="addmovie">
                    <div class="fluid-container">
                     <p>Find Movie</p>
                        <form id="findMovie" method="POST" action="findmovie.htm">
                            <input type="input" class="form-control input-sm" name="name" placeholder="Movie Name">
                            <button type="submit" class="btn btn-success btn-sm">Search</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
 </div>
<!--/ADMIN NAV BAR-->

<jsp:include page="footer.jsp" />
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
  </body>
</html>
