<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>

img {
  width: 100%;
  height: auto;
	padding: 5px;
}

.responsive{
	display:-webkit-box;
}
h2 {
  text-align:center;
	padding-bottom: 1em;
}

.slick-dots {
	text-align: center;
  margin: 0 0 10px 0;
  padding: 0;
  li {
    display:inline-block;
    margin-left: 4px;
    margin-right: 4px;
    
    }
    .slick-active {
      button { background-color:black;
      }
    }
    button {
      
      text-shadow: none;
      color: transparent;
      background-color:black;
      border:none;
      width: 15px;
      height: 15px;
      border-radius:50%;
    }
		
  }
}

/* Custom Arrow */
.prev{
	color: #999;
	position: absolute;
	top: 38%;
	left: -2em;
	font-size: 1.5em;
		:hover{
			cursor: pointer;
			color: black;
		}
}
.next{
	color: #999;
	position: absolute;
	top: 38%;
	right: -2em;
	font-size: 6.5em;
	}

@media screen and (max-width: 800px) {
    .next {
        display: none !important;
    }
}



</style>
</head>
 
 <body>
 
 <div class="container">
  <h2>Slider - Multpile Items & Responsive</h2>
    <div class="row">
      <div class="col-md-12 heroSlider-fixed">
        <div class="overlay">
      </div>
         <!-- Slider -->
        <div class="slider responsive">
          <div>
						<img src="http://placehold.it/200x150" alt="" />
					</div>
					<div>
						<img src="http://placehold.it/200x150" alt="" />
					</div>
					<div>
						<img src="http://placehold.it/200x150" alt="" />
					</div>
					<div>
						<img src="http://placehold.it/200x150" alt="" />
					</div>
					<div>
						<img src="http://placehold.it/200x150" alt="" />
					</div>
					<div>
						<img src="http://placehold.it/200x150" alt="" />
					</div>
					<div>
						<img src="http://placehold.it/200x150" alt="" />
					</div>
					<div>
						<img src="http://placehold.it/200x150" alt="" />
					</div>
        </div>
				 <!-- control arrows -->
				<div class="prev">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				</div>
				<div class="next">
					<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				</div>
				
      </div>
    </div>
  </div>

<script type="text/javascript">
$('.responsive').slick({
	  dots: true,
		prevArrow: $('.prev'),
		nextArrow: $('.next'),
	  infinite: false,
	  speed: 300,
	  slidesToShow: 4,
	  slidesToScroll: 4,
	  responsive: [
	    {
	      breakpoint: 1024,
	      settings: {
	        slidesToShow: 3,
	        slidesToScroll: 3,
	        infinite: true,
	        dots: true
	      }
	    },
	    {
	      breakpoint: 600,
	      settings: {
	        slidesToShow: 2,
	        slidesToScroll: 2
	      }
	    },
	    {
	      breakpoint: 480,
	      settings: {
	        slidesToShow: 1,
	        slidesToScroll: 1
	      }
	    }
	    // You can unslick at a given breakpoint now by adding:
	    // settings: "unslick"
	    // instead of a settings object
	  ]
	});</script>


</body>
 
 
 
 
</html>