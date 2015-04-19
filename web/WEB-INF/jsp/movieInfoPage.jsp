<%-- 
    Document   : movieinfoPage
    Created on : Apr 17, 2015, 4:41:22 PM
    Author     : JaeWoong
--%>

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

    <title>Yggdrasil</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="assets/css/nav_style.css" rel="stylesheet" media="screen">
    <link href="assets/css/bootstrap.css" rel="stylesheet" media="screen">
    <link href="assets/css/footer_style.css" rel="stylesheet" media="screen">

  
  </head>
<!-- /HEADER <!-- background-size: 1200px,800px;-->


<body role="document" class="movieinfo_bg">
    <jsp:includepage="header.jsp" />
   
        1111 ${currentMovie.title}
        2222 ${currentMovie.rating}
          
    <div  style="margin-left:70px;" >
    <hr> <h1 style="font-weight: bold">RUN ALL NIGHT (2015)</h1>
    <br>
    <table>
        <tr>
            <td valign="top">
                <table valign="top" align="left" width="380px">
                    <tr width="380px" bgcolor="#5d6078" >
                       <td valign="middle" align="center" colspan=1 height="260px">
                           <a href=""><img src="http://ia.media-imdb.com/images/M/MV5BMTU2ODI3ODEyOV5BMl5BanBnXkFtZTgwMTM3NTQzNDE@._V1_SX214_AL_.jpg" width="180" height="250"></a></td>
                       <td valign="top" align="center" colspan=1 height="260px"><font size="4"><br>Opens<br>MAY 1, 2015<br>Action/Adventure<br>Sci-Fi/Fantasy<br>
                           85 Fan Ratings<br>See it in<br>IMAX 3D<br>Digital 3D</font></td>
                   </tr>
                   <tr width="380px">
                       <td align="left" colspan=2> 
                           <hr>
                           <font size="5">Tell us where you are</font><br>
                            Looking for movie tickets? Enter your location to see which movie theaters are playing Chappie near you.<br><br>
			    ENTER ZIP OR CITY, STATE
                            <form class="navbar-form navbar-center"><div class="form-group">
				<input type="ENTER ZIP OR CITY, STATE" placeholder="City, State or Zip Code" class="form-control"><button type="GO" class="btn btn-success">GO</button>
                                </div></form><hr>
			</td>                
                   </tr>
                   <tr>
                       <td colspan=2>
                           <a href="#" class="btn btn-primary">10:30am</a>&nbsp;&nbsp;<a href="#" class="btn btn-primary">1:00pmy</a>&nbsp;&nbsp;<a href="#" class="btn btn-primary">3:30pm</a>&nbsp;&nbsp;
                           <a href="#" class="btn btn-primary">6:30pm</a>&nbsp;&nbsp;<br><br><a href="#" class="btn btn-primary">9:00pm</a>&nbsp;&nbsp;<a href="#" class="btn btn-primary">11:00pm</a>
                       </td>                          
                   </tr>
                   <tr width="370px">
                       <td align="center" valign="middle"><hr><a href="registrationpage.htm" class="btn btn-warning">Favorite this Movie!</a></td> 
                       <td align="center" valign="middle"><hr><a href="checkoutpage.htm" class="btn btn-success">Purchase Tickets!</a></td>                
                   </tr>
                    <tr><td><br></td></tr>
                   
               </table>
            </td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td valign="top" align="left">
                <table>
                    <tr>
                        <td><embed width="800" height="590"src="https://www.youtube.com/embed/7uDuFh-nC-c"></td>
                    </tr>
                    <tr>
                        <td><font size="5"><br><br>RUN ALL NIGHT<br>
                            Liam Neeson, Joel Kinnaman, Vincent D'Onofrio, Bruce McGill, Genesis Rodriguez, Boyd Holbrook in Run All Night</font></td>
                    </tr>
                    <!--Picture slides -->
                </table>
            </td>
        </tr>
    </table>
    <br><br><br>
    <div align="center"><font size="6" familey="Times New Roman" >
        Run All Night Synopsis<br>
         Brooklyn mobster and prolific hit man Jimmy Conlon (Neeson), once known as The Gravedigger, has seen better days.</font>
    </div>
    <br><br><br>
</div>    
    

<!-- /MAIN MOVIE BODY -->
<br><hr>
 </body>

		
<jsp:include page="footer.jsp" />
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
 
</html>
