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
  </head>
<!-- /HEADER -->
  
<body role="document">
<jsp:include page="header.jsp" />

<!--MAINBODY-->
<div class="container">
<center><p class="text-danger" style="font-size:55px">SPOTLIGHT</p></center><hr>

      <div class="row row-offcanvas">
        
            <div class="col-xs-6 col-lg-4">
			  <a href="movieinfopage.htm" class ="highlight_footerIcon"><img src="assets\img\featured.jpg" width="350" height="622"></a>
			  
            </div><!--/.col-xs-6.col-lg-3-->
            <div class="col-lg-4">
              <iframe width="350" height="300" src="http://www.youtube.com/embed/7uDuFh-nC-c?&rel=0&loop=1&showinfo=0&controls=0&hd=1&color=white&playlist=7uDuFh-nC-c" frameborder="0" allowfullscreen></iframe>
			  <a href="http://www.imdb.com/title/tt2199571/?ref_=nv_sr_1" class ="highlight_footerIcon"><img src="assets\img\subf1.jpg" width="350" height="300"><br></br></a>
              
            </div><!--/.col-xs-6.col-lg-3-->
            <div class="col-xs-6 col-lg-4">
              
			  <a href="http://www.imdb.com/title/tt2679042/?ref_=fn_al_tt_2" class ="highlight_footerIcon"><img src="assets\img\subf2.jpg" width="350" height="300"><br></br></a>
              <iframe width="350" height="300" src="http://www.youtube.com/embed/7qhIkoUynPA?&rel=0&loop=1&showinfo=0&controls=0&hd=1&color=white&playlist=7qhIkoUynPA" frameborder="0" allowfullscreen></iframe>
            </div><!--/.col-xs-6.col-lg-3-->
			<div class="col-xs-6 col-lg-4">
              
			  <a href="http://www.imdb.com/title/tt2293640/?ref_=nv_sr_1" class ="highlight_footerIcon"><img src="assets\img\subf3.jpg" width="350" height="300"><br></br></a>
              
            </div><!--/.col-xs-6.col-lg-3-->
			<div class="col-xs-6 col-lg-4">
				<iframe width="350" height="300" src="http://www.youtube.com/embed/o8hxFE7RpSg?&rel=0&loop=1&showinfo=0&controls=0&hd=1&color=white&playlist=o8hxFE7RpSg" frameborder="0" allowfullscreen></iframe>
			</div><!--/.col-xs-6.col-lg-3-->
			<div class="col-xs-6 col-lg-4">
              
			  <a href="http://www.imdb.com/title/tt2637276/?ref_=fn_al_tt_4" class ="highlight_footerIcon"><img src="assets\img\subf4.jpg" width="350" height="300"><br></br></a>
              
            </div><!--/.col-xs-6.col-lg-3-->
			</div>
			<hr>
		<!-- 2nd half -->
		<center><p class="text-info" style="font-size:55px">POPULAR PICKS</p></center><hr>
		
			<div class="row row-offcanvas">
			<div class="col-xs-6 col-lg-4">
              <h2>The Man from Nowhere</h2>
              <a href="http://www.imdb.com/title/tt1527788/?ref_=fn_al_tt_1"><img src="assets\img\pick1.jpg" width="300" height="300"><br></br></a>
			  <p>A pawnshop keeper battles the local organ trafficking gang to save a child. Give this foreign thriller a try!</p>
              <p><button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal1">View Video</button></p>
            </div><!--/.col-xs-6.col-lg-4-->
			
			<div class="col-xs-6 col-lg-4">
              <h2>Game of Thrones</h2>
			  <a href="http://www.imdb.com/title/tt0944947/?ref_=nv_sr_1"><img src="assets\img\pick2.jpg" width="300" height="300"><br></br></a>
              <p>Due to popular demands Game of Thrones will be digitally re-mastered into the IMAX format and released in all participating theatres. Definitely check it out!</p>
              <p><button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal2">View Video</button></p>
            </div><!--/.col-xs-6.col-lg-4-->
			
			<div class="col-xs-6 col-lg-4">
              <h2>The Interview</h2>
			  <a href="http://www.imdb.com/title/tt2788710/?ref_=fn_al_tt_1"><img src="assets\img\pick3.jpg" width="300" height="300"><br></br></a>
              <p>Two celebrity tabloid showmen land an interview with North Korean dictator Kim Jong-un. However they are recruited by the CIA to assassinate him instead. Don't miss this controversial comedic action film!</p>
              <p><button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal3">View Video</button></p>
            </div><!--/.col-xs-6.col-lg-4-->

	  </div>
</div>
<!-- VIDEO POPUP MODALS -->
<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">The Man From Nowhere</h4>
      </div>
      <div class="modal-body">
        <iframe width="560" height="315" src="http://www.youtube.com/embed/38rPoGSr19U?&rel=0&showinfo=0&modestbranding=1&controls=0&hd=1&color=white" frameborder="0" allowfullscreen></iframe>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Game Of Thrones</h4>
      </div>
      <div class="modal-body">
        <iframe width="560" height="315" src="http://www.youtube.com/embed/pwyUQG_Gv5s?&rel=0&showinfo=0&modestbranding=1&controls=0&hd=1&color=white" frameborder="0" allowfullscreen></iframe>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">The Interview</h4>
      </div>
      <div class="modal-body">
        <iframe width="560" height="315" src="http://www.youtube.com/embed/frsvWVEHowg?&rel=0&showinfo=0&modestbranding=1&controls=0&hd=1&color=white" frameborder="0" allowfullscreen></iframe>
	  </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<!-- /VIDEO POPUP MODALS -->
<!--/MAINBODY--><hr>



<!-- COUPONS -->
<center><a href="offerspage.htm"><p class="text-success" style="font-size:55px">OFFERS</p></a><hr>
<div class="row">
			<div class="col-xs-6 col-lg-3">
			  <img src="assets\img\offer1.jpg" width="275" height="275"><br></br>
              <center><p>Sign Up for our Daily Newsletter for the latest movie news and great deals!</p></center>
              <center><p><button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal4">View details &raquo;</button></p></center>
            </div><!--/.col-xs-6.col-lg-4-->
			
			<div class="col-xs-6 col-lg-3">
			  <img src="assets\img\offer2.jpg" width="275" height="275"><br></br>
              <center><p>Enter Today for a chance to win a trip to Australia!</p><p><h6> Offer ends Jan 20, 2016. </h6></p></center>
              <center><p><button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal5">View details &raquo;</button></p></center>
            </div><!--/.col-xs-6.col-lg-4-->
			
			<div class="col-xs-6 col-lg-3">
			  <img src="assets\img\offer3.jpg" width="275" height="275"><br></br>
				<center><p>Family Deal! Purchase 2 or more tickets and get the next ticket 50% off!</p></center>
              <center><p><button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal6">View details &raquo;</button></p></center>
            </div><!--/.col-xs-6.col-lg-4-->
			
			<div class="col-xs-6 col-lg-3">
			  <img src="assets\img\offer4.jpg" width="275" height="275"><br></br>
              <center> <p>Go to any theater in Stony Brook and mention us to get a free large soda!</p></center>
              <center><p><button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal7">View details &raquo;</button></p></center>
            </div><!--/.col-xs-6.col-lg-4-->
	  </div></center>
<!-- INFO POPUP MODALS -->
<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Daily Newsletter</h4>
      </div>
      <div class="modal-body">
      <!-- REGISTER BODY -->
        <div class="row row-offcanvas">
        <form class="form-horizontal">
          <fieldset>

            <legend><center><h1><p class="text-info" style="font-size:55px">Registration</p></h1></center></legend>

            <div class="form-group">
              <label for="inputEmail" class="col-lg-4 control-label">Email</label>
              <div class="col-xs-6 col-lg-4">
                <input type="text" class="form-control" id="inputEmail" placeholder="Email">
              </div>
            </div>

                <div class="form-group">
              <label for="inputName" class="col-lg-4 control-label">Name</label>
              <div class="col-xs-6 col-lg-4">
                <input type="text" class="form-control" id="inputName" placeholder="Name">
              </div>
            </div>


                <div class="form-group">
              <center>
                <button type="submit" class="btn btn-success">SIGN UP</button>
              </center>
            </div>

          </fieldset>
        </form>
        </div>
        <!-- /REGISTER BODY -->
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="myModal5" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Win a Trip to Australia!</h4>
      </div>
      <div class="modal-body">
          
        <!-- REGISTER BODY -->
        <div class="row row-offcanvas">
        <form class="form-horizontal">
          <fieldset>

            <legend><center><h1><p class="text-info" style="font-size:55px">Registration</p></h1></center></legend>

            <div class="form-group">
              <label for="inputEmail" class="col-lg-4 control-label">Email</label>
              <div class="col-xs-6 col-lg-4">
                <input type="text" class="form-control" id="inputEmail" placeholder="Email">
              </div>
            </div>

                <div class="form-group">
              <label for="inputName" class="col-lg-4 control-label">Name</label>
              <div class="col-xs-6 col-lg-4">
                <input type="text" class="form-control" id="inputName" placeholder="Name">
              </div>
            </div>


                <div class="form-group">
              <center>
                <button type="submit" class="btn btn-success">JOIN NOW!</button>
              </center>
            </div>

          </fieldset>
        </form>
        </div>
        <!-- /REGISTER BODY -->
          
        </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="myModal6" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Purchase 2 or more tickets and get the next ticket 50% off!</h4>
      </div>
      <div class="modal-body">
          <p>Offer valid only between 8AM to 10PM. Tickets must be purchased at full pricing. </p>
        </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="myModal7" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Free Large Soda!</h4>
      </div>
      <div class="modal-body">
          <p>Sign in to the theatre on your smartphone through Yelp and show it to the cashier to receive a free large soda!</p>
        </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<!-- /COUPONS -->



<hr><jsp:include page="footer.jsp" />
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
  </body>
</html>
