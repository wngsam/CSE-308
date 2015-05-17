<%-- 
    Document   : movieinfoPage
    Created on : Apr 17, 2015, 4:41:22 PM
    Author     : JaeWoong
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<body role="document" class="movieinfo_bg">
    <jsp:include page="header.jsp" />
    
    <div  style="margin-left:70px;" >
        
    <hr><h1 style="font-weight: bold">${currentMovie.title}</h1>
    <div class="fb-share-button" data-layout="button"></div>
    <br>
    <g:plus action="share"></g:plus>
    
    <br>
    <table>
        <tr>
            <td valign="top">
                <table valign="top" align="left" width="380px">
                    <tr width="380px" bgcolor="#5d6078" >
                       <td valign="middle" align="center" colspan=1 height="260px"><img src="${currentMovie.poster}" width="180" height="250"></td>
                       <td valign="top" align="center" colspan=1 height="260px"><font size="4">
                           
                            <c:if test="${didnotLogin eq true}">You need to login first!</c:if>
                            <c:if test="${starSuccess eq true}">Thank you for your rating!</c:if>
                            
                            <c:forEach begin="1" end="5" var="val">
                                <c:if test="${val <= currentMovie.starRating}">
                                    <a href="star=${val}.htm"><img src="assets\img\STARS.png" width="25" height="25"></a>
                                </c:if>
                                <c:if test="${val > currentMovie.starRating}">
                                    <a href="star=${val}.htm"><img src="assets\img\USTARS.png" width="25" height="25"></a>
                                </c:if>
                            </c:forEach>
                                    
                            <br><br>
                                <fmt:formatDate type="Date" dateStyle="Long" value="${currentMovie.releaseDate.time}"></fmt:formatDate>
                                <br>
                                <c:forEach var="genre" items="${currentMovie.genres}">
                                    <br>${genre}
                                </c:forEach>
                                
                                <br><br>Rated ${currentMovie.rating}<br>
                                
                        </font></td>
                    </tr>
                   
                    <tr width="380px">
                       <td align="left" colspan=2> 
                           <hr>
                           <font size="5">Tell us where you are</font><br>
                            Looking for movie tickets? Enter your location to see which movie theaters are playing Chappie near you.<br><br>
			    ENTER ZIP OR CITY, STATE
                            <form class="navbar-form navbar-center"><div class="form-group">
				<input type="ENTER ZIP OR CITY, STATE" placeholder="City, State or Zip Code" class="form-control"><button type="GO" class="btn btn-success">GO</button>
                                </div></form>
                            <hr>
			</td>                
                    </tr>
                   
                    <tr>
                       <td colspan=2>
                           <a href="#" class="btn btn-primary">10:30am</a>&nbsp;&nbsp;
                           <a href="#" class="btn btn-primary">1:00pmy</a>&nbsp;&nbsp;
                           <a href="#" class="btn btn-primary">3:30pm</a>&nbsp;&nbsp;
                           <a href="#" class="btn btn-primary">6:30pm</a>&nbsp;&nbsp;
                           <br><br>
                           <a href="#" class="btn btn-primary">9:00pm</a>&nbsp;&nbsp;
                           <a href="#" class="btn btn-primary">11:00pm</a>
                       </td>                          
                    </tr>
                   
                    <tr><td><br></td></tr>                   
               </table>
            </td>
            
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            
            <td valign="top" align="left">
                <table>
                    <tr>
                        <td><embed width="800" height="590"src="${currentMovie.trailer}"></td>
                    </tr>
                    <tr>
                        <td>
                        <font size="5">
                        <b>CAST:</b></font>
                        <br><br>
                        <c:if test ="${not empty currentMovie.cast}">
                        <c:forEach var="actor" items="${currentMovie.cast}" varStatus="count">
                            
                            <img src="${actor.picture}" height="150" width="85">&nbsp;
                            <font size="4"><a href="http://www.imdb.com/name/${actor.imdb}"> ${actor.firstName} ${actor.lastName} </a></font>&nbsp;
                        
                        </c:forEach>
                        </c:if>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
                    
    <hr>
    <div align="center">
        <font size="8" familey="Times New Roman" >
        <b>Synopsis</b>
        </font>
        <br>
        <font size="5" familey="Times New Roman" >
        ${currentMovie.synopsis}
        </font>
    <hr>
    <font size="8" familey="Times New Roman" >
        <p class="text-primary">Comments</p>
    </font>
    <c:if test ="${not empty currentMovie.reviews}">
        <div class="container-fluid">
        <c:forEach var="comment" items="${currentMovie.reviews}" varStatus="count">
            <font size="4" familey="Times New Roman" >
            <b>${comment.title}</b>
            
            <c:if test="${currentPerson.role == 'Admin'}">
                &nbsp;&nbsp;<a href="delcomment=${comment.title},${comment.userId}.htm" class="btn btn-danger">X</a>
            </c:if>
            
            <br>
            <i>By ${comment.name}</i><br>
            ${comment.content}<br><br>
            </font>
        </c:forEach>
        </div>
        <hr>
    </c:if>
    <c:if test="${not empty currentPerson}">
        <c:if test="${commentSuccess eq false}">Comment failed, try a different title perhaps!</c:if>
        <font size="5" familey="Times New Roman" >Leave A Message!</font>
        <br><br>
    <form class="navbar-form navbar-center" method="POST" action="comment.htm">
        <input type="text" name="title" placeholder="Title"><br><br>
        <input class="form-control input-lg" name="msg" placeholder="Comment"><br><br>
        <button type="submit" class="btn btn-success btn-sm">Submit</button>
    </form>
    </c:if>
    <br>
    </div>
        
    </div>       
		
<jsp:include page="footer.jsp" />
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <div id="fb-root"></div>
    <script>(function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.3";
    fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));</script>
    <script src="https://apis.google.com/js/platform.js" async defer></script>
  </body>

</html>
