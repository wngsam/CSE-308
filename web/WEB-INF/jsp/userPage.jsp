<%-- 
    Document   : userPage
    Created on : Apr 10, 2015, 11:21:11 PM
    Author     : Sam W.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<jsp:include page="header.jsp"/>

 <!-- USER NAV BAR -->
 <div class="container-fluid">
    <div class="row">
        <div class="col-lg-12">
             <div class="page-header">
                 <h1>${currentPerson.firstName}'s Account</h1>
             </div>
             <ul class="nav nav-tabs">
                 <li class="active"><a href="#overview" data-toggle="tab" aria-expanded="true">OVERVIEW</a></li>
                 <li><a href="#history" data-toggle="tab" aria-expanded="false">PURCHASE HISTORY</a></li>
                 <li><a href="#settings" data-toggle="tab" aria-expanded="false">ACCOUNT SETTINGS</a></li>
                 <li><a href="#payment" data-toggle="tab" aria-expanded="false">PAYMENT METHOD</a></li>
             </ul>
            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade active in" id="overview">
                    <div class="container">                        
                        <center><p class="text-danger">MY THEATERS</p></center><hr>
                        <center><p class="text-danger">MY MOVIES</p></center><hr>
                        <center><p class="text-danger">MY REVIEWS</p></center><hr>                           
                    </div>
                </div>
                <div class="tab-pane fade" id="history">
                     <p>Purchase History</p>
                </div>
                <div class="tab-pane fade" id="settings">                    
                    <form:form action="editUser.htm" modelAttribute="user" method="post">                        
                        <div class="form-group">
                            <p class="text-warning" style="font-size:20px">First Name:</P>
                            <form:input path="firstName" placeholder="First Name"/>
                        </div>
                            
                        <div class="form-group">
                            <p class="text-warning" style="font-size:20px">Last Name:</P>
                            <form:input path="lastName" placeholder="Last Name"/>
                        </div>
                        
                        <div class="form-group">
                            <p class="text-warning" style="font-size:20px">Birth Date:</P>
                            <fmt:formatDate type="Date" dateStyle="Long" var="birthDateString" value="${currentPerson.birthDate.time}" pattern="dd/MM/yyyy"></fmt:formatDate>
                            <form:input path="birthDate" value="${birthDateString}"/>
                        </div>
                            
                            
                        <br><button type="submit" class="btn btn-success" >Update</button></br>                            
                    </form:form>
                </div>
                <div class="tab-pane fade" id="payment">
                    <h1>Payment Methods</h1>
                    <div  style="margin-left:70px;" >
                    
                        <table>
                            <tr>
                                <td  valign = "top">

                                    <h2>Add Payment Method</h2>

                                    <form:form action="userPage.htm" method="post" modelAttribute="paymentMethod">


                                        <div class="form-group">
                                            <p class="text-warning" style="font-size:20px">First Name:</P>
                                            <form:input path="firstName" placeholder="First Name"/>
                                        </div>
                                        <div class="form-group">
                                            <p class="text-warning" style="font-size:20px">Last Name:</P>
                                            <form:input path="lastName" placeholder="Last Name"/>
                                        </div>
                                        <div class="form-group">
                                            <p class="text-warning" style="font-size:20px">Credit Card Number:</P>
                                            <form:input path="creditCardNum" placeholder="Credit Card Number"/>
                                        </div>
                                        <div class="form-group">
                                            <p class="text-warning" style="font-size:20px">CCV:</P>
                                            <form:input path="ccv" placeholder="CCV"/>
                                        </div>
                                        <div class="form-group">
                                            <p class="text-warning" style="font-size:20px">Address:</P>
                                            <form:input path="address" placeholder="Address"/>
                                        </div>
                                        <div class="form-group">
                                            <p class="text-warning" style="font-size:20px">Zip Code</P>
                                            <form:input path="zipCode" placeholder="Zip Code"/>
                                        </div>


                                        <p class="text-warning" style="font-size:20px">Preferred Payment? 
                                            <form:checkbox width="100px" height="100px" path="isPreferred"/></p>

                                        <br><button type="submit" class="btn btn-success" >Add Payment</button></br>

                                    </form:form>

                                </td>
                                
                                <td valign = "top">
                                    <div  style="margin-left:70px;" >
                                    <h2>Current Payment Methods</h2>
                                    
                                    
                                    <c:forEach var="listVar" items="${payments}">     
                                            
                                        <center><p>${listVar.creditCardNum}</p></center>
                                        <center><a href="edit=${listVar.id}.htm"><p>Edit Payment</p></a></center>
                                        <br>
                                    </c:forEach>
                                    <c:if test="${empty payments}">
                                            No payments saved.
                                            <br>
                                    
                                    </c:if>
                                    
                                    </div>
                                </td>
                                
                            </tr>
                                
                        </table>
                    
                    </div>
                        <br><br>














                </div>
                
                
                
                
            </div>
        </div>
    </div>
 </div>
<!--/USER NAV BAR-->

<jsp:include page="footer.jsp" />
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
  </body>
</html>
