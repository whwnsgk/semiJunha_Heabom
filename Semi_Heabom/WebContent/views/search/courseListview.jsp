<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <title>Heabom</title>
    <style>
          .wrap{
            width: 1900px;
            height: auto;
            border: 1px solid black;
            box-sizing: border-box;
            margin: auto;
            margin-top: 30px;
        }
        div{
            border: 1px solid black;
            width: 100%;
        }
        #content-1{
            height: 300px;
            box-sizing: border-box;
            background-color: rgb(230, 204, 208);

        }
        #content-2{
            height: auto;
        }

        #content-1-1 , #content-1-2 , #content-1-3{
          float: left;
          height: 100%;
        }

        #content-1-1 {
          width: 30%;
        }
        #content-1-2{
          width: 40%;
        }
        #content-1-3{
          width: 30%;
        }

      
        #myCaroussl img{
            width: 100%;
            height: 100%;
        }
        .carousel-inner{
          width: 100%;
          height: 100%;
         
        }

        #myCarousel{
          width: 100%;
          height: 100%;
        }



        #content-2-1 , #content-2-2 , #content-2-3{
          float: left;
          height: 100%;
        }

        #content-2-1 {
          width: 30%;
        }
        #content-2-2{
          width: 40%;
        }
        #content-2-3{
          width: 30%;
        }


  
   
    </style>
</head>
<body>
<%@include file = "../common/header.jsp" %>
    <div class="wrap">

        <div id ="content-1">
          <div id="content-1-1"></div>
            <div id="content-1-2">
              
                
                <div id="myCarousel" class="carousel slide">
                
                  <!-- Indicators -->
                  <ul class="carousel-indicators">
                    <li class="item1 active"></li>
                    <li class="item2"></li>
                    <li class="item3"></li>
                  </ul>
                  
                  <!-- The slideshow -->
                  <div class="carousel-inner">
                    <div class="carousel-item active">
                      <img src="02_CSS3/resources/image/forest1.PNG" alt="Los Angeles" width="100%" height="100%" >
                    </div>
                    <div class="carousel-item">
                      <img src="02_CSS3/resources/image/flower1.PNG" alt="Chicago" width="100%" height="100%">
                    </div>
                    <div class="carousel-item">
                      <img src="02_CSS3/resources/image/iconsample.PNG" alt="New York" width="100%" height="100%">
                    </div>
                  </div>
                  
                  <!-- Left and right controls -->
                  <a class="carousel-control-prev" href="#myCarousel">
                    <span class="carousel-control-prev-icon"></span>
                  </a>
                  <a class="carousel-control-next" href="#myCarousel">
                    <span class="carousel-control-next-icon"></span>
                  </a>
                </div>
              
            </div>
          <div id="content-1-3"></div>
        </div>



        
        <div id ="content-2"><!--div2-->
          <div id="content-2-1"></div>
            <div id="content-2-2">
              jsp로 쓸꺼임 게시판 list 조회랑 같은 원리다!
              <% for (int i = 0 ; i < 코스의 개수 ; i ++){ %>

                <div style="width: 100%; height: 100%; background-color: red;">
                <input type="img">
                <br>
                이미지 파일 넣고
                <br>
                <%= db에서 가져온 음식점이름 %>
                <br>
                <%= db 에서 가져온 대충 가격 %>
                <br>
                상세보기
                <a href="">이거 서블릿으로 가는버튼인데 쿼리스트링 이용해서 값 넘길꺼임</a>
                </div>

                <br>
                <br>
              }을 반복문으로 돌려서 요소를 생성할것임 wrapper 의 height 는 auto
              content-2의 height도 auto
              contetn-1의 height 는 픽셀값이라 ㄱㅊ음


            </div>
          <div id="content-2-3"></div>


        </div>
        

    </div>
   
















    <script>
        $(document).ready(function(){
          // Activate Carousel
          $("#myCarousel").carousel();
            
          // Enable Carousel Indicators
          $(".item1").click(function(){
            $("#myCarousel").carousel(0);
          });
          $(".item2").click(function(){
            $("#myCarousel").carousel(1);
          });
          $(".item3").click(function(){
            $("#myCarousel").carousel(2);
          });
            
          // Enable Carousel Controls
          $(".carousel-control-prev").click(function(){
            $("#myCarousel").carousel("prev");
          });
          $(".carousel-control-next").click(function(){
            $("#myCarousel").carousel("next");
          });
        });
        </script>

</body>
</html>