<%@page import="com.heabom.common.model.vo.PageInfo"%>
<%@page import="com.heabom.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   PageInfo pi = (PageInfo)request.getAttribute("pi");
   ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
   String keyWord = (String)request.getAttribute("keyWord");
   
   int startPage = pi.getStartPage();
   int endPage = pi.getEndPage();
   int currentPage = pi.getCurrentPage();
   int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판1</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        div, input {
            /* border: 1px solid red;
            box-sizing: border-box; */
        }

        #p1 {
            margin-left: 5%;
            font-size: 20px;
            font-weight: 900;
            margin-top: 20%;

            color: orange;
        }


        .wrap {
            width: 1900px;
            height: auto;
            /* border: 1px solid black; */
            box-sizing: border-box;
            margin: auto;

            background-color: white;

            padding-top: 1%;
            padding-bottom: 1%;

            margin-top: 1.5%;
        }

        .background {
            box-sizing: border-box;
            width: 70%;
            height: 1000px;
            margin: auto;
            margin-top: 4%;
            margin-bottom: 4%;
            
            background-color: #F2F2F2;
            /*border: 1px solid black;*/
            border-radius: 30px 30px 30px 30px;

            position: relative;
        }

        #header {
            height: 12%;
        }

        #content1 {
            height: 70%;
        }

        #content2 {
            height: 8%;
        }

        #footer {
            height: 10%;
        }

        #header>div, #content1>div, #content2>div, #footer>div {
            height: 100%;
            float: left;
        }

        #header_1, #header_5 {
            width: 8%;
        }

        #header_2 {
            width: 30%;
        }

        #header_3 {
            width: 24%;
        }

        #header_4 {
            width: 30%;
        }

        #content_1, #content_3 {
            width: 8%;
        }

        #content_2 {
            width: 84%;

            background-color: white;
            border-top-left-radius: 30px;
            border-top-right-radius: 30px;
        }

        #content_4, #content_8 {
            width: 8%;
        }

        #content_5 {
            width: 28%;

            background-color: white;
            border-bottom-left-radius: 30px;
        }

        #content_6 {
            width: 28%;

            background-color: white;
        }

        #content_7 {
            width: 28%;

            background-color: white;
            border-bottom-right-radius: 30px;
        }

        /*-------------------테이블---------------------------------*/

        #content_2>form {
            width: 100%;

            margin-top: 4%;
        }

        table>thead {
            text-align: center;
            font-size: 30px;

            
            border: none;
            border-color: white;
            border-bottom: 2px solid lightgray;
            
        }

        table>.listInner {
            text-align: center;
            font-size: 25px;

            
            border: none;
            border-color: white;
            border-bottom: 1px solid lightgray;
            
        }

        th {
            padding-top: 10px;
            padding-bottom: 10px;

            font-size: 17px;
        }

        td {
            padding-top: 15px;
            padding-bottom: 15px;

            font-size: 15px;
        }

        /*---------------------------- 아코디언 ----------------------------------*/

        #header_3 {
            position: relative;

            /*border: 1px solid purple;*/
        }

        #search_date {
            position: absolute;
            margin: auto;

            width: 40%;
            height: 30%;

            top: 50px;
            bottom: 0px;
            left: 170px;
            right: 0px;

            background-color: white;
            border-width: 3px;
            border-radius: 5px;
            border-color: lightgray;
            font-weight: 900;
        }

        #search_date option {
            text-align: center;
        }

        #search_date2 {
            background-color: white;
            border-width: 3px;
            border-radius: 5px;

            border-color: lightgray;
        }

        #search_date2 option {
            text-align: center;
        }

        #search_date3 {

            background-color: white;
            border-width: 3px;
            border-radius: 5px;

            border-color: lightgray;

        }

        #search_date3 option {
            text-align: center;
        }

        /*----------------------------검색---------------------------------------*/

        #header_4 {
            position: relative;

            /*border: 1px solid purple;*/
        }

        #search_form {
            width: 90%;
            height: 30%;

            font-size: 15px;
        }

        #search_form {

            margin: auto;
            position: absolute;
            top: 50px;
            bottom: 0px;
            left: 200;
            right: 0px;
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

        #search_text input {
            border-color: lightgray;
        }

        #search_btn input {

            border-color: lightgray;
        }

        /*--------------------------페이지바---------------------------------*/

        .page-item {
            display: flex;
            justify-content: center;

            margin-top: 3%;
        }

        .page-link {
            font-size: 20px;
        }

        /*--------------------------선택 수정, 삭제---------------------------------*/
        
        #content_5>button {

            width: 30%;

            margin-top: 4%;

            font-size: 15px;

            color: white;
            font-weight: 900;
        }

        #button1 {
            margin-left: 15%;
        }

        #button2 {
            margin-left: 3%;
        }
    </style>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<%@include file = "../common/header.jsp" %>
    <div class="wrap">
        <div class="background">
            <div id="header">
                <div id="header_1"></div>
                <div id="header_2">
                	<p id="p1">검색 된 회원 수 : <%= (keyWord != null && !keyWord.isEmpty()) ? list.size() : pi.getListCount() %>명</p>
                </div>
                <div id="header_3"></div>
                <div id="header_4">
                    <form action="<%= contextPath %>/search.ck?cpage=1&keyword" id="search_form" method="get">
                        <div id="search_text">
                            <input type="text" id="keyword" name="keyword" placeholder="회원 이름 입력">
                            <input type="hidden" name="cpage" value="1">
                        </div>
                        <div id="search_btn">
                            <input type="submit" value="검색">
                        </div>
                    </form>
                </div>
                <div id="header_5"></div>
            </div>
            <div id="content1">
                <div id="content_1"></div>
                <div id="content_2">
                    <form id="ckeckListView-form" action="<%= contextPath %>/update.ck" method="post">
                        <table border="1">
                            <thead>
                                <th width="130">번호</th>
                                <th width="130">회원 아이디</th>
                                <th width="130">이름</th>
                                <th width="130">별명</th>
                                <th width="120">등급</th>
                                <th></th>
                                <th width="120">포인트</th>
                                <th width="160">최종 접속</th>
                                <th width="120">이메일</th>
                                <th width="160"><button type="button" style="width: 60px; height: 40px; font-size: 15px; background-color: rgb(148, 226, 165); border: none; border-radius: 5px;">변경</button>
                            </thead>
                            <tbody class="listInner">
                            <input type="hidden" name="listSize" value="<%=list.size()%>">
                                <% for (int i = 0; i<list.size(); i++) { %>
                                    <form action="update.ck">
                                    <tr>
                                        <td><%= list.get(i).getMemNo() %></td>
                                        <td><%= list.get(i).getMemId() %></td>
                                        <td><%= list.get(i).getMemName() %></td>
                                        <td><%= list.get(i).getNickname() %></td>
                                        <td><%= list.get(i).getGrade() %></td>
                                        <td><input type="hidden" name="memId" value="<%= list.get(i).getMemId() %>"></td>
                                        <td><input type="number" name="memPoint" style="width: 50%;"></td>
                                        <td><%= list.get(i).getMemVisit() %></td>
                                        <td><%= list.get(i).getEmail() %></td>
                                        <td>
                                            <input type="submit" id="commentbtn<%=i%>" value="변경">
                                        </td>
                                    </tr>
                                    </form>
                                  <% } %>
                            </tbody>
                        </table>
                    </form>
                </div>
                <div id="content_3"></div>
            </div>
            <div id="content2">
                <div id="content_4"></div>
                <div id="content_5"></div>
                <div id="content_6">
                    <tr>
					    <td colspan="5" style="border-top: 1px solid gray;">
					        <ul class="pagination justify-content-center" style="margin: 0;">
					        
					        <% if (list.isEmpty() || list.size() < 10) { %>
					            <li class="page-item"><button class="page-link btn active" disabled>1</button></li>
					        <% } else { %>
					            <% if (pi.getCurrentPage() != 1) { %>
					                <li class="page-item"><button class="page-link" onclick="location.href='<%= contextPath %>/search.ck?keyword=<%= keyWord %>&cpage=<%= currentPage - 1 %>'">&lt;</button></li>
					            <% } %>
					            <% for (int i = startPage; i <= endPage; i++) { %>
					                <% if (i == currentPage) { %>
					                    <li class="page-item"><button class="page-link btn active" disabled><%= i %></button></li>
					                <% } else { %>
					                    <li class="page-item"><button class="page-link" onclick="location.href='<%= contextPath %>/search.ck?keyword=<%= keyWord %>&cpage=<%= i %>'"><%= i %></button></li>
					                <% } %>
					            <% } %>
					            <% if (currentPage != maxPage) { %>
					                <li class="page-item"><button class="page-link" onclick="location.href='<%= contextPath %>/search.ck?keyword=<%= keyWord %>&cpage=<%= currentPage + 1 %>'">&gt;</button></li>
					            <% } %>
					        <% } %>
					        </ul>
					    </td>
					</tr>
                </div>
                <div id="content_7"></div>
                <div id="content_8"></div>
            </div>
            <div id="footer"></div>
        </div>
    </div>

    <!-- 회원 등급 수정 -->
    <script>
    </script>
    <%@include file = "../common/footer.jsp" %>
</body>
</html>