<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <title>Heabom</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>


    <style>
        div {
            box-sizing: border-box;
            /*border: 1px solid red;*/
        }

         .wrap {
            width: 1900px;
            height: 800px;
            border: 1px solid white;
            box-sizing: border-box;
            margin: auto;
            margin-top: 30px;
            overflow: auto;
        }

        .wrap>div {
            width: 100%;
        }

        #header {
            height: 30%;
        }

        #content {
            height: 270%;
        }

        /*-----------------------------------------------------------------*/


        /*-----------------------------------------------------------------*/

        #content>#content_1 {
            height: 5%;

            border-top: 1px solid black;
        }

        #content>#content_2 {
            height: 8%;

            background-color: #FDEEEE;
        }

        #content>#content_3 {
            height: 80%;

            background-color: #FDEEEE;
        }

        #content>#content_4 {
            height: 7%;

            background-color: #FDEEEE;
        }

        /*-----------------------------------------------------------------*/

        #content_2>div {
            height: 100%;
        }

        #content_b1, #content_b2 {
            width: 50%;
            float: left;
        }

        /*-----------------------------------------------------------------*/

        
        #content_3>div {
            width: 100%;
            position: relative;
        }
        

        
        #content_e {
            height: 100%;
            display: grid;
            grid-template-columns: 1fr 1fr 1fr;
            grid-template-rows: 1fr 1fr 1fr;
            position: absolute;

            grid-column-gap: 100px;
            grid-row-gap: 100px;
            padding: 5%;
            
        }
        

        /*-----------------------------------------------------------------*/

        .pagination {

            display: flex;
            justify-content: center;
        }

        .page-link {
            font-size: 40px;
            
        }

        /*-----------------------------------------------------------------*/

        #navi {
            /*border: 1px solid green;*/
            list-style-type: none; /* 불릿 기호를 없앨 때 */
            padding: 0; /* 나열은 기본적으로 패딩 속성을 가지고 있어서 0으로 없애준다. */
            margin: 0;
            height: 100%;

            display: flex;
            justify-content: center;
        }

        #navi>li {
            float: left;
            /*border: 1px solid blue;*/
            width: 20%;
            height: 100%;
            text-align: center;
        }

        #navi a {
            /* border: 1px solid orange; */
            text-decoration: none;
            color: black;
            font-size: 40px;
            font-weight: 600;
            width: 100%;
            height: 100%;
            display: block;
            line-height: 100px;
        }

        #navi a:hover {
            color: pink;
        }

        /*-----------------------------------------------------------------*/

        #content_b1 {
            position: relative; /* 기준 잡기 */

            /*border: 1px solid purple;*/
        }

        #search_form {
            width: 60%;
            height: 50%;
        }

        #search_form {

            margin: auto;
            position: absolute; /* 기준을 중심으로 조절할 수 있는 권한 */
            top: 100px;
            bottom: 0;
            left: 0;
            right: 200px; /* 이렇게 하면 검색창이 정 가운데로 감. 네개 다 극단으로 가려고 해서 결국 가운데로 배치가 된다. 이건 공식처럼 외우면 좋다. */
        }

        #search_form>div {
            height: 100%;
            float: left;
        }

        #search_text {
            width: 80%;
        }

        #search_btn {
            width: 20%;
        }

        #search_form input {
            width: 100%;
            height: 100%;
        }

        /*-----------------------------------------------------------------*/

        #content_e {
            width: 100%;
        }

        .img {
            height: 70%;

            border: 1px solid lightgray;
            background-color: white;
        }

        .text {
            height: 30%;

            border: 1px solid lightgray;
            border-top: none;
            background-color: #F3F3F3;
        }


    </style>
</head>
<body>
<%@include file = "../common/header.jsp" %>
    <div class="wrap">
        <div id="header">
            <div id="header_1"></div>
        </div>
        <div id="content">
            <div id="content_1">
                <ul id="navi">
                    <li><a href="#">글자</a></li>
                    <li><a href="#">글자</a></li>
                    <li><a href="#">글자</a></li>
                    <li><a href="#">글자</a></li>
                    <li><a href="#">글자</a></li>
                </ul>
            </div>
            <div id="content_2">
                <div id="content_b1">
                    <form action="" id="search_form">
                        <div id="search_text">
                            <input type="text" name="keyword">
                        </div>
                        <div id="search_btn">
                            <input type="submit" value="검색">
                        </div>
                    </form>
                </div>
                <div id="content_b2">
                    
                </div>
            </div>
            <div id="content_3">
                <div id="content_e">
                    <div id="content_e1">
                        <a href="http:/www.naver.com">
                            <div id="img1" class="img"></div>
                            <div id="text1" class="text"></div>
                        </a>
                    </div>
                    <div id="content_e2">
                        <a href="http:/www.naver.com">
                            <div id="img2" class="img"></div>
                            <div id="text2" class="text"></div>
                        </a>
                    </div>
                    <div id="content_e3">
                        <a href="http:/www.naver.com">
                            <div id="img3" class="img"></div>
                            <div id="text3" class="text"></div>
                        </a>
                    </div>
                    <div id="content_f1">
                        <a href="http:/www.naver.com">
                            <div id="img4" class="img"></div>
                            <div id="text4" class="text"></div>
                        </a>
                    </div>
                    <div id="content_f2">
                        <a href="http:/www.naver.com">
                            <div id="img5" class="img"></div>
                            <div id="text5" class="text"></div>
                        </a>
                    </div>
                    <div id="content_f3">
                        <a href="http:/www.naver.com">
                            <div id="img6" class="img"></div>
                            <div id="text6" class="text"></div>
                        </a>
                    </div>
                    <div id="content_g1">
                        <a href="http:/www.naver.com">
                            <div id="img7" class="img"></div>
                            <div id="text7" class="text"></div>
                        </a>
                    </div>
                    <div id="content_g2">
                        <a href="http:/www.naver.com">
                            <div id="img8" class="img"></div>
                            <div id="text8" class="text"></div>
                        </a>
                    </div>
                    <div id="content_g3">
                        <a href="http:/www.naver.com">
                            <div id="img9" class="img"></div>
                            <div id="text9" class="text"></div>
                        </a>
                    </div>
                </div>

            </div>
            <div id="content_4">
                <nav aria-label="Page navigation example">
                    <ul class="pagination">
                      <li class="page-item">
                        <a class="page-link" href="#" aria-label="Previous">
                          <span aria-hidden="true">&laquo;</span>
                        </a>
                      </li>
                      <li class="page-item"><a class="page-link" href="#">1</a></li>
                      <li class="page-item"><a class="page-link" href="#">2</a></li>
                      <li class="page-item"><a class="page-link" href="#">3</a></li>
                      <li class="page-item"><a class="page-link" href="#">4</a></li>
                      <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                          <span aria-hidden="true">&raquo;</span>
                        </a>
                      </li>
                    </ul>
                  </nav>
            </div>
        </div>
    </div>
</body>
</html>