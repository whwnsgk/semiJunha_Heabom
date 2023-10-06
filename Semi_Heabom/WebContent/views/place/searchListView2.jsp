<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=], initial-scale=1.0">
    <title>Heabom</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <style>
        .wrap {

            width: 1900px;
            height: auto;
            
            margin: auto;

            display: grid;
            grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
            grid-template-rows: 1fr 1fr 1fr 1fr 1fr;

            grid-column-gap: 30px;
            grid-row-gap: 30px;
            padding: 5%;

        }

        #box {
            position: relative;
        }

        #box p {
            position: absolute;
            text-align: center;

            text-shadow: 5px 3px 3px gray;

            color: white;
            font-size: 35px;
            font-weight: bolder;

            top: 40%;
	        left: 37%;
        }

        .wrap>div {
            width: 100%;
        }


        #box img {

            box-sizing: border-box;
            border: 0px solid black;
            box-shadow: 2px 2px 2px 2px gray;
            height: 95%;
            width: 95%;

            display: block;
            margin: auto;

            border-radius: 20px;
			
            background-repeat: no-repeat;
            background-position: center;
            background-size: 100%;
            filter: brightness(1);

            font-weight: 900;
            color: white;

            cursor: pointer;
        }

        img:hover {
            background-repeat: no-repeat;
            background-position: center;
            background-size: 100%;
            filter: brightness(0.5);
            opacity: 0.6;
        }
        #enrollBtn{
            margin-top: 30px;
            background-color: pink;
        }
        #plzLogin{
            margin-top: 30px;
            cursor: pointer;
        }
        
        #plzLogin:hover {
            color: red;
        }

    </style>
</head>
<body>
<%@include file = "../common/header.jsp" %>
<%if (loginMember != null){ %>
<div id = "enrollBtn" align ="center">
<button id="place-button" class="btn btn-primary" style="background-color: pink; border: none;" onclick="location.href ='<%=contextPath%>/enrollForm.pl'">장소 등록하기</button>
</div>
<%}else{ %>
<div id = "plzLogin" align ="center" >
	<h2 data-toggle="modal" data-target="#myModal">로그인 하시면 장소를 등록할수 있어용</h2>
</div>
<%} %>
        <div class="wrap">
            <div id="box" >
                <a href='<%=contextPath%>/searchListView.pl?lNo=1'><img style="width: 325px; height: 325px; ;" src="<%=contextPath%>/resource/img/place/간판없는가게.jpg"></a>
                <p>강남구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=2'><img style="width: 325px; height: 325px; ;" src="<%=contextPath%>/resource/img/place/서울앵무새.jpg"></a>
                <p>서초구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=3'><img style="width: 325px; height: 325px; ;" src="<%=contextPath%>/resource/img/place/동작2.jpg"></a>
                <p>동작구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=4'><img style="width: 325px; height: 325px ;;"src="<%=contextPath%>/resource/img/place/이태리이층집.jpg"></a>
                <p>강서구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=5'><img style="width: 325px; height: 325px;;"src="<%=contextPath%>/resource/img/place/리차드하우스 연남.jpg"></a>
                <p>양천구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=6'><img style="width: 325px; height: 325px;;"src="<%=contextPath%>/resource/img/place/바빌리안테이블.jpg"></a>
                <p>구로구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=7'><img style="width: 325px; height: 325px;; "src="<%=contextPath%>/resource/img/place/세상의모든아침.jpg"></a>
                <p>금천구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=8'><img style="width: 325px; height: 325px;;"src="<%=contextPath%>/resource/img/place/일떼라쪼당산본점.jpg"></a>
                <p>관악구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=9'><img style="width: 325px; height: 325px;;"src="<%=contextPath%>/resource/img/place/영등포구.jpg"></a>
                <p>영등포구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=10'><img style="width: 325px; height: 325px;;"src="<%=contextPath%>/resource/img/place/송파구.png"></a>
                <p>송파구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=11'><img style="width: 325px; height: 325px;;"src="<%=contextPath%>/resource/img/place/강동구.jpg"></a>
                <p>강동구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=12'><img style="width: 325px; height: 325px;;"src="<%=contextPath%>/resource/img/place/광진구.jpg"></a>
                <p>광진구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=13'><img style="width: 325px; height: 325px;;"src="<%=contextPath%>/resource/img/place/성동구.jpg"></a>
                <p>성동구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=14'><img style="width: 325px; height: 325px;;"src="<%=contextPath%>/resource/img/place/용산구.jpg"></a>
                <p>용산구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=15'><img style="width: 325px; height: 325px;"src="<%=contextPath%>/resource/img/place/마포구.jpg"></a>
                <p>마포구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=16'><img style="width: 325px; height: 325px;;"src="<%=contextPath%>/resource/img/place/서대문구.jpg"></a>
                <p>서대문구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=17'><img style="width: 325px; height: 325px;;"src="<%=contextPath%>/resource/img/place/중구.jpg"></a>
                <p>중구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=18'><img style="width: 325px; height: 325px;;"src="<%=contextPath%>/resource/img/place/동대문구.jpg"></a>
                <p>동대문구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=19'><img style="width: 325px; height: 325px;;"src="<%=contextPath%>/resource/img/place/중랑구.jpg"></a>
                <p>중랑구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=20'><img style="width: 325px; height: 325px; "src="<%=contextPath%>/resource/img/place/종로구.jpg"></a>
                <p>종로구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=21'><img style="width: 325px; height: 325px; "src="<%=contextPath%>/resource/img/place/성북구.jpg"></a>
                <p>성북구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=22'><img style="width: 325px; height: 325px; "src="<%=contextPath%>/resource/img/place/은평구.jpg"></a>
                <p>은평구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=23'><img style="width: 325px; height: 325px; "src="<%=contextPath%>/resource/img/place/강북구.jpg"></a>
                <p>강북구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=24'><img style="width: 325px; height: 325px; "src="<%=contextPath%>/resource/img/place/도봉구.jpg"></a>
                <p>도봉구</p>
            </div>
            <div id="box">
                <a href='<%=contextPath%>/searchListView.pl?lNo=25'><img style="width: 325px; height: 325px; "src="<%=contextPath%>/resource/img/place/노원구.jpg"></a>
                <p>노원구</p>
            </div>
        </div>
    <%@include file = "../common/footer.jsp" %>



</body>
</html>