<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css"> 
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
</head>
 
 <body>
 
 <div class="container">
  <div class="row">
    <div id="carousel" class="carousel slide" data-ride="carousel">
      <ol class="carousel-indicators">
        <li data-target="#carousel" data-slide-to="0" class="active"></li>
        <li data-target="#carousel" data-slide-to="1"></li>
      </ol>
      <div class="carousel-inner">
        <div class="carousel-item active">
          <div class="d-none d-lg-block">
            <div class="slide-box">
              <img src="https://picsum.photos/285/200/?image=0&random" alt="First slide">
              <img src="https://picsum.photos/285/200/?image=1&random" alt="First slide">
              <img src="https://picsum.photos/285/200/?image=2&random" alt="First slide">
              <img src="https://picsum.photos/285/200/?image=3&random" alt="First slide">
            </div>
          </div>
          <div class="d-none d-md-block d-lg-none">
            <div class="slide-box">
              <img src="https://picsum.photos/240/200/?image=0&random" alt="First slide">
              <img src="https://picsum.photos/240/200/?image=1&random" alt="First slide">
              <img src="https://picsum.photos/240/200/?image=2&random" alt="First slide">
            </div>
          </div>
          <div class="d-none d-sm-block d-md-none">
            <div class="slide-box">
              <img src="https://picsum.photos/270/200/?image=0&random" alt="First slide">
              <img src="https://picsum.photos/270/200/?image=1&random" alt="First slide">
            </div>
          </div>
          <div class="d-block d-sm-none">
            <img class="d-block w-100" src="https://picsum.photos/600/400/?image=0&random" alt="First slide">
          </div>
        </div>
        <div class="carousel-item">
          <div class="d-none d-lg-block">
            <div class="slide-box">
              <img src="https://picsum.photos/285/200/?image=4&random" alt="Second slide">
              <img src="https://picsum.photos/285/200/?image=5&random" alt="Second slide">
              <img src="https://picsum.photos/285/200/?image=6&random" alt="Second slide">
              <img src="https://picsum.photos/285/200/?image=7&random" alt="Second slide">
            </div>
          </div>
          <div class="d-none d-md-block d-lg-none">
            <div class="slide-box">
              <img src="https://picsum.photos/240/200/?image=3&random" alt="Second slide">
              <img src="https://picsum.photos/240/200/?image=4&random" alt="Second slide">
              <img src="https://picsum.photos/240/200/?image=5&random" alt="Second slide">
            </div>
          </div>
          <div class="d-none d-sm-block d-md-none">
            <div class="slide-box">
              <img src="https://picsum.photos/270/200/?image=2&random" alt="Second slide">
              <img src="https://picsum.photos/270/200/?image=3&random" alt="Second slide">
            </div>
          </div>
          <div class="d-block d-sm-none">
            <img class="d-block w-100" src="https://picsum.photos/600/400/?image=1&random" alt="Second slide">
          </div>
        </div>
      </div>
      <a class="carousel-control-prev" href="#carousel" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="carousel-control-next" href="#carousel" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
  </div>
</div>

</body>
 
</html>