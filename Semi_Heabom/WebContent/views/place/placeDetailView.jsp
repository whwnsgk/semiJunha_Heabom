<%@page import="com.heabom.common.model.vo.File"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.heabom.place.model.vo.Place"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
     	Place place = (Place)request.getAttribute("placeInfo");
    	System.out.println("여기는 placeDetailView : "+place.getPlaceNo());
    	ArrayList<File> fileList = (ArrayList<File>)request.getAttribute("fileList");
    	System.out.println(place.getPlaceNo()); 
    	String writer = place.getWriter();
    	
    %>

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
        .wrap {
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
        margin: 0;
        padding: 0;
        width: 1900px;
        margin: 50px auto;
        background-color: #ffffff;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        display: flex;
        overflow: hidden;
    }
    .place-img {
        width: 50%;
        position: relative;
      
    }



    .place-img img {
        width: 70%;
        height: 100%;
        object-fit: cover;
        margin-left: 150px;
    }
    .place-description {
        width: 50%;
        padding: 40px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
    }
    th, td {
        border-bottom: 1px solid #e5e5e5;
        padding: 10px 0;
        text-align: left;
    }
    th {
        font-size: 16px;
        color: #777;
        padding-right: 20px;
    }
    td {
        font-size: 20px;
        color: #333;
    }
    td a {
        color: #007BFF;
        text-decoration: none;
    }
    .review-section {
            width: 1900px;
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            max-width: 800px;
            margin: 50px auto;
            background-color: #ffffff;
            padding: 20px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }
        .review {
            border-bottom: 1px solid #e5e5e5;
            padding: 20px 0;
        }
        .review:last-child {
            border-bottom: none;
        }
        .review-author {
            font-weight: bold;
            margin-bottom: 10px;
        }
        .review-text {
            color: #555;
            margin-bottom: 10px;
        }
        .review-img {
            width: 100px;
            height: 80px;
            border-radius: 8px;
            margin-bottom: 5px;
        }
        .review-date {
            font-size: 12px;
            color: #aaa;
        }
        .report {
        font-size: 12px;
        color: #007BFF;
        cursor: pointer;
        margin-top: 5px;
        text-decoration: underline;
        }

            .review-form {
            margin-bottom: 20px;
        }
        .review-form textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .review-form button {
            padding: 5px 10px;
            background-color: #007BFF;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .review-form button:hover {
            background-color: #0056b3;
        }
        .review-form {
            margin: auto;
            width: 900px;
        }
        .review-form textarea {
            resize: none;
        }
        .carousel-item active{
            width: 500px;
            height: 500px;
        }
        .carousel-item{
            width: 500px;
            height: 500px;
        }
    </style>
</head>
<body>
    <%@ include file="../common/header.jsp" %>
    <h1 align="center"><%=place.getPlaceTitle()%></h1>
    <div class="wrap">
        <div class="place-img" style="border: 0px solid black;">

            <div class="container mt-3">
               
                <div id="myCarousel" class="carousel slide">
                
                  <!-- Indicators -->
                  <ul class="carousel-indicators">
                    <li class="item1 active"></li>
                    <% for (int i = 0 ; i <fileList.size() ; i ++ ) { %>
                    <li class="item<%=i%>"></li>
                    <% } %>
                  </ul>
                  
                  <!-- The slideshow -->
                  <div class="carousel-inner">
                    <div class="carousel-item active">
                      <img src="<%=place.getTitleImg()%>"  width="100%" height="100%">
                    </div>

                    <% for (int i = 0 ; i <fileList.size() ; i ++ ) { %>
                    <div class="carousel-item">
                      <img src="<%=fileList.get(i).getFilePath()%>"  width="100%" height="100%">
                    </div>
                    <% } %>

                  </div>
                  
                  <!-- Left and right controls -->
                  <a  class="carousel-control-prev" href="#myCarousel">
                    <span class="carousel-control-prev-icon" style="background-color: red;" ></span>
                  </a>
                  <a   class="carousel-control-next" href="#myCarousel">
                    <span class="carousel-control-next-icon" style="background-color: red;"></span>
                  </a>
                </div>
                </div>


            <!-- <img src="<%=place.getTitleImg()%>"> -->
        </div>
        <div class="place-description">
            <table>
                <tr>
                    <th width = "150" >글번호</th>
                    <td id ="plNo"><%=place.getPlaceNo()%></td>
                </tr>
                <tr>
                    <th>번호</th>
                    <td><%=place.getPhone() %></td>
                </tr>
                <tr>
                    <th>주소</th>
                    <td><%=place.getAddress() %></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td><%=place.getPlaceContent() %></td>
                </tr>
                <tr>
                    <th>오픈시간</th>
                    <td><%=place.getStartTime() %>시</td>
                </tr>
                <tr>
                    <th>닫는시간</th>
                    <td><%=place.getEndTime() %>시</td>
                </tr>
                <tr>
                    <th>별점</th>
                    <td>
                    <% for (int i = 0 ; i < place.getStarPoint(); i ++){ %>
                    	⭐
                    	<%} %>
                    </td>
                </tr>
                <tr>
                    <th>홈페이지</th>
                    <td><a href="<%=place.getPlaceUrl()%>">사이트 이동</a></td>
                </tr>
                <tr>
                    <th>예상소요시간</th>
                    <td><%=place.getUseTime() %></td>
                </tr>
                <tr>
                    <th>예상소요비용</th>
                    <td><%=place.getUsePrice() %></td>
                </tr>
                <tr>
                    <th>좋아요</th>
                    <td id = "likeCount"><%=place.getLikeCount()%> 
                    
                    <%if(loginMember != null){ %>
                    <button onclick="likeup();">좋아요</button>
                    <%} %>
                    
                    </td>
                </tr>
            </table>
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
      $(".item4").click(function(){
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



    function likeup(){
        $.ajax({
                    //요청을 보내기 
                    url : "likeup.pl",
                    data : {input : $("#plNo").html() , "test": "<%=writer%>"}, //데이터 넘길때에는 무조건 중괄호 열어라
                    //키 벨류 세트로 보내야한다 데이터는 긍까 객체 안에 객체네..

                    type : "get", // 요청방식 지정
                    success : function(result){ //성공시 응답 데이터가 자동으로 매개변수로 넘어온다
                        if(result == 99999){
                        	swal("이미 좋아요를 눌렀네요");
                        }else{
                        console.log("ajax통신 성공!")
                        $("#likeCount").text(result);
                        }
                    },
                    error : function(){
                        console.log("ajax통신 실패!")
                    }

                    
                })
    }


    </script>




	<%@include file="../place/placeDetailReview.jsp"%>


</body>
</html>