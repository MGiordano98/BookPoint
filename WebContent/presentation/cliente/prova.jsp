<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<title>Insert title here</title>
<script src="prova1.js" type="text/javascript"></script>
<style>
.multi-item-carousel
  .carousel-inner
    .item{
      transition: 500ms ease-in-out left;
    }
    .active
      .left{
        left:-33%;
      }
      .right{
        left:33%;
      }
    }
    .next{
      left: 33%;
    }
    .prev{
      left: -33%;
    }
    @media all and (transform-3d), (-webkit-transform-3d) {
      > .item{
        
        transition: 500ms ease-in-out left;
        transition: 500ms ease-in-out all;
        backface-visibility: visible;
        transform: none!important;
      }
    }
  }
  .carouse-control
    .left .right{
      background-image: none;
    }
  

body{
  background: #333;
  color: #ddd;
}
h1{
  color: white;
  font-size: 2.25em;
  text-align: center;
  margin-top: 1em;
  margin-bottom: 2em;
  text-shadow: 0px 2px 0px rgba(0, 0, 0, 1);
}

</style>



</head>
<body>
<div class="container">
  <h1>Use Bootstrap's carousel to show multiple items per slide.</h1>
  <div class="row">
    <div class="col-md-12">
      <div class="carousel slide multi-item-carousel" id="theCarousel">
        <div class="carousel-inner">
          <div class="item active">
            <div class="col-xs-4"><a href="#1"><img src="http://placehold.it/300/f44336/000000" class="img-responsive"></a></div>
          </div>
          <div class="item">
            <div class="col-xs-4"><a href="#1"><img src="http://placehold.it/300/e91e63/000000" class="img-responsive"></a></div>
          </div>
          <div class="item">
            <div class="col-xs-4"><a href="#1"><img src="http://placehold.it/300/9c27b0/000000" class="img-responsive"></a></div>
          </div>
          <div class="item">
            <div class="col-xs-4"><a href="#1"><img src="http://placehold.it/300/673ab7/000000" class="img-responsive"></a></div>
          </div>
          <div class="item">
            <div class="col-xs-4"><a href="#1"><img src="http://placehold.it/300/4caf50/000000" class="img-responsive"></a></div>
          </div>
          <div class="item">
            <div class="col-xs-4"><a href="#1"><img src="http://placehold.it/300/8bc34a/000000" class="img-responsive"></a></div>
          </div>
          <!-- add  more items here -->
          <!-- Example item start:  -->
          
          <div class="item">
            <div class="col-xs-4"><a href="#1"><img src="http://placehold.it/300/8bc34a/000000" class="img-responsive"></a></div>
          </div>
          
          <!--  Example item end -->
        </div>
        <a class="left carousel-control" href="#theCarousel" data-slide="prev"><i class="glyphicon glyphicon-chevron-left"></i></a>
        <a class="right carousel-control" href="#theCarousel" data-slide="next"><i class="glyphicon glyphicon-chevron-right"></i></a>
      </div>
    </div>
  </div>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="prova1.js" type="text/javascript"></script>

</body>
</html>