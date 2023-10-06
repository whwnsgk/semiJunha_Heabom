<%@page import="com.heabom.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String contextPath = request.getContextPath();
	Member loginMember =  (Member)session.getAttribute("loginMember");
	
	String alertMsg = (String)session.getAttribute("alertMsg");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="wWidth=device-width, initial-scale=1.0">
    <title>Heabom</title>

    <link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=IBM+Plex+Sans+KR&display=swap" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>

    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script><!--alert-->

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"/>
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>


    <style>
    
@font-face {
    font-family: 'TheJamsil';
    font-weight: 300;
    font-style: normal;
    src: url('https://cdn.jsdelivr.net/gh/webfontworld/TheJamsil/TheJamsil-Light.eot');
    src: url('https://cdn.jsdelivr.net/gh/webfontworld/TheJamsil/TheJamsil-Light.eot?#iefix') format('embedded-opentype'),
        url('https://cdn.jsdelivr.net/gh/webfontworld/TheJamsil/TheJamsil-Light.woff2') format('woff2'),
        url('https://cdn.jsdelivr.net/gh/webfontworld/TheJamsil/TheJamsil-Light.woff') format('woff'),
        url('https://cdn.jsdelivr.net/gh/webfontworld/TheJamsil/TheJamsil-Light.ttf') format("truetype");
    font-display: swap;
}
        *{
            font-family: 'TheJamsil';
            /* font-family: 'IBM Plex Sans KR', sans-serif; */
        }

        div{box-sizing: border-box; border: 0px solid red;}
        .header_outer{
            width: auto;
            height: 90px;
            margin: auto;
            margin-top: 0px;
            /*border-bottom: 2px solid lightgray ;*/
            /* position: fixed; */

            background-color: transparent;
            
        }

        .header_outer>div{
            float: left;
        }

        .header_logo{
            height: 100%;
            width: 15%;

            /*
            box-sizing: border-box;
            border: 1px solid red;
            */

            margin-top: 0.5%;
            
        }

        .header_loginSession{
            height: 100%;
            width: 12%;

            /*
            box-sizing: border-box;
            border: 1px solid red;
            */

            margin-top: 0.5%;
            padding-top: 0.5%;
        }

        .header_navi{
            height: 100%;
            width: 60%;

            /*
            box-sizing: border-box;
            border: 1px solid red;
            */

            margin-top: 0.5%;
            padding-top: 1%;

            /*background-color: lightpink;*/
        }
        .header_left_empty{
            height: 100%;
            width: 2%;
        }
        .header_right_empty{
            height: 100%;
            width: 1%;
        }

        .navi_detail a { 
            color: rgb(77, 81, 89);
            display:inline-block; 
            margin:0;
            text-transform:uppercase; 
            height: 1px;
            text-decoration: none;
            font-weight: 900;
            font-size: 30px;
        }

        .navi_detail a:after {
            display:block;
            content: '';
            border-bottom: solid 3px rgb(255, 113, 113);  
            transform: scaleX(0);  
            transition: transform 250ms ease-in-out;
        }

        .navi_detail a:hover:after {transform:scaleX(1);}
        .navi_detail td{
            font-size: x-large;
            text-align: center;
            height: 75px;
            width: 250px;
        }
        .header_logo img{
            height: 100%;
            width: 100%;
        }
        .navi_detail div{
            width: auto;
            height: 40px;
            
        }
        .navi_detail a:hover{
            color: gray;
        }
        .header_logo img:hover{
            opacity: 0.7;
        }

    </style>
</head>
<body>
   <%@ include file="sidebar.jsp" %>
    <%if (alertMsg != null){  %>
        <script>
        swal("<%=alertMsg%>");
        </script>
        <%session.removeAttribute("alertMsg"); // invalidate 쓰면 session 이 다 날아간다 따라서 이 세션만 지울수 있게 removeattribute 를 쓴다%>
    <%} %>
    <div class="header_outer" align="center">
        <div class="header_left_empty"></div>
        <div class="header_logo">
            <a href="<%=contextPath%>"><img src="<%=contextPath%>/resource/img/mainLogo/9번로고.png" alt=""></a>
        </div>
        <div class="header_loginSession">
                <!-- 로그인 및 버튼 -->
    <div class="login_btn">
        <%if (loginMember == null ){ %>
            <!-- The Modal -->
            <div class="modal" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                
                        <!-- Modal Header -->
                        <div class="modal-header">
                        <h4 class="modal-title">로그인</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                
                        <!-- Modal body -->
                        <div class="modal-body">
                            <form action="<%=contextPath%>/login.me">
                                <div class="form-group">
                                
                                <input type="text" class="form-control" placeholder="아이디" name = "memId" value="admin">
                                </div>
                                <div class="form-group">
                                <label for="pwd">Password:</label>
                                <input type="password" class="form-control" placeholder="Enter password" name="memPwd" value="admin">
                                </div>
                                <button type="submit" class="btn btn-primary">로그인</button>
                            </form>
                            
                        </div>
                        <br>
                        <button type="button" class="btn btn-primary" onclick="enroll();">회원가입하기</button>
                
                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
                <%}else{%>
                    <div style="line-height: 35px; text-align: center;">
                    <p id="headerUser" style="margin: 0; margin-top: 10px;">
                    <%if(loginMember.getTitleImg().length() > 5) { %>
                    	<img src="<%=contextPath%><%=loginMember.getTitleImg()%>" id="viewTitleImg1" name="viewTitleImg1" style="width: 25px; height: 25px; border-radius: 50px;">
                    <% }else{ %>
                    	<img src="<%=contextPath%>/resource/img/profile/기본이미지.png" id="viewTitleImg1" name="viewTitleImg1" style="width: 25px; height: 25px; border-radius: 50px;">
                    <% } %>
                    <strong><%=loginMember.getNickname()%>님</strong> 반갑습니다.
                    </p>
                    </div>
                    <a class="btn btn-sm btn-info" href="<%=contextPath%>/myPage.me" style="background-color: pink; border: none;">나의정보</a>
                    <button  class="btn btn-sm btn-danger" onclick="location.href = '<%=contextPath%>/logout.me'" style="border: none;">로그아웃</button>
                <%}%>
    </div>
        </div>
        <div class="header_navi">
            <table class="navi_detail" border="0" align="center">
                <tr>
                    <td><a href="<%= contextPath %>/search.pl"><div>해봄검색</div></a></td>
                    <td><a href="<%= contextPath %>/searchCourse.pl"><div>해봄코스</div></a></td>
                    <td><a href="<%= contextPath %>/list.bo?cpage=1"><div>자유게시판</div></a></td>
                    <td><a href="#"><div>해봄의소리</div></a></td>
                    <%if (loginMember != null && loginMember.getMemId().equals("admin")){ %>
                        <!-- 관리자로 로그인하면 -->
                        <td><a href="<%= contextPath %>/myAdmin.ad"><div>관리자페이지</div></a></td>
                    <%} else {%>
                        <%  if(loginMember != null) { %>
                        <!-- 로그인하면 -->
                        <td><a href="<%= contextPath %>/myPage.me"><div>마이페이지</div></a></td>
                        <% } %>
                    <%}%>
                </tr>
            </table>
        </div>
        <div class="header_right_empty"></div>
    </div>
        <script>
            function enroll(){
                location.href =  "<%=contextPath%>/enrollForm.me";
            }

        </script>

</body>



</html>