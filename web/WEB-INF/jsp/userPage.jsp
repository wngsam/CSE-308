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
                            <form:input path="firstName"/>
                        </div>
                            
                        <div class="form-group">
                            <p class="text-warning" style="font-size:20px">Last Name:</P>
                            <form:input path="lastName"/>
                        </div>
                        
                        <div class="form-group">
                            <p class="text-warning" style="font-size:20px">Birth Date(dd/mm/yyyy):</P>                            
                            <form:input path="bd"/>
                        </div>
                        
                        <div class="form-group">
                            <p class="text-warning" style="font-size:20px">Zip Code:</P>
                            <form:input path="zipCode"/>
                        </div>                            
                            
                        <br><button type="submit" class="btn btn-success" >Update</button></br>                            
                    </form:form>
                        <c:choose>
                            <c:when test="${not empty wrongPwd}">
                                    <form id="login" method="POST" action="editPassword.htm">                      
                        
                                    <div class="form-group">
                                        <p class="text-warning" style="font-size:20px">Current Password:</P>
                                        <input type="password" name="currentPwd"/>
                                        <p class="text-warning" style="font-size:20px">Wrong Password!</P>
                                    </div>     
                                    <div class="form-group">
                                        <p class="text-warning" style="font-size:20px">New Password:</P>
                                        <input type="password" name="newPwd"/>
                                    </div>  
                                    <div class="form-group">
                                        <p class="text-warning" style="font-size:20px">Confirm the New Password:</P>
                                        <input type="password" name="confirmPwd"/>
                                    </div>  
                                    
                                    <br><button type="submit" class="btn btn-success" >Update Password</button></br>                            
                                </form>
                            </c:when>
                            <c:when test="${not empty pwdConflict}">
                                    <form id="login" method="POST" action="editPassword.htm">                      
                        
                                    <div class="form-group">
                                        <p class="text-warning" style="font-size:20px">Current Password:</P>
                                        <input type="password" name="currentPwd"/>                                        
                                    </div>     
                                    <div class="form-group">
                                        <p class="text-warning" style="font-size:20px">New Password:</P>
                                        <input type="password" name="newPwd"/>
                                        <p class="text-warning" style="font-size:20px">Passwords do not match!</P>
                                    </div>  
                                    <div class="form-group">
                                        <p class="text-warning" style="font-size:20px">Confirm the New Password:</P>
                                        <input type="password" name="confirmPwd"/>
                                    </div>  
                                    
                                    <br><button type="submit" class="btn btn-success" >Update Password</button></br>                            
                                </form>
                            </c:when>
                            <c:otherwise>
                                <form id="login" method="POST" action="editPassword.htm">                      
                        
                                    <div class="form-group">
                                        <p class="text-warning" style="font-size:20px">Current Password:</P>
                                        <input type="password" name="currentPwd"/>                                        
                                    </div>     
                                    <div class="form-group">
                                        <p class="text-warning" style="font-size:20px">New Password:</P>
                                        <input type="password" name="newPwd"/>                                        
                                    </div>  
                                    <div class="form-group">
                                        <p class="text-warning" style="font-size:20px">Confirm the New Password:</P>
                                        <input type="password" name="confirmPwd"/>
                                    </div>  
                                    
                                    <br><button type="submit" class="btn btn-success" >Update Password</button></br>                            
                                </form>
                            </c:otherwise>
                            
                    </c:choose>    
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
                                        <h3>    
                                        <center><p>${listVar.creditCardNum}</p></center>
                                        <center><a href="edit=${listVar.id}.htm"><p>Edit Payment Method</p></a></center>
                                        <center><a href="delete=${listVar.id}.htm"><p>Delete Payment Method</p></a></center>
                                        <center><a href="preferred=${listVar.id}.htm"><p>Set As Preferred</p></a></center>
                                        </h3>
                                        <br>
                                    </c:forEach>
                                    <c:if test="${empty payments}">
                                        <h3>No payment methods saved.</h3>
                                            <br>
                                    
                                    </c:if>
                                    <c:if test="${not empty Success}">
                                            <h3>Successfully saved payment method.</h3>
                                            <br>
                                    
                                    </c:if>
                                    <c:if test="${not empty failure}">
                                            
                                            <h3>${failure}</h3>
                                            <br>
                                    
                                    </c:if>
                                    <c:if test="${not empty InvalidZipcode}">
                                            
                                            <h3>${InvalidZipcode}</h3>
                                            <br>
                                    
                                    </c:if>
                                    <c:if test="${not empty CCLengthFailure}">
                                            
                                            <h3>${CCLengthFailure}</h3>
                                            <br>
                                    
                                    </c:if>
                                    <c:if test="${not empty InvalidCCV}">
                                            
                                            <h3>${InvalidCCV}</h3>
                                            <br>
                                    
                                    </c:if>
                                    <c:if test="${not empty delete}">
                                            <h3>Successfully deleted payment method.</h3>
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
