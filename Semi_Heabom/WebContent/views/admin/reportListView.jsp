<%@page import="com.heabom.admin.model.vo.Report"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.heabom.common.model.vo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Report> list = (ArrayList<Report>)request.getAttribute("list");
	
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판2</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        div, input {
            /*border: 1px solid red;*/
            box-sizing: border-box;
        }

        #p1 {
            font-size: 25px;
            font-weight: 500;

            margin-top: 25%;

            background-color: lightpink;
            border-radius: 15px;
            width: 150px;
            text-align: center;
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
            height: 15%;
        }

        #content {
            height: 75%;
        }

        #footer {
            height: 10%;
        }

        #header>div, #content>div, #footer>div {
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
        }

        #footer_1, #footer_3 {
            width: 8%;
        }

        #footer_2 {
            width: 84%;
        }

        /*-------------------테이블---------------------------------*/

        #content_2>table {
            width: 100%;

            /*margin-top: 5%;*/
        }

        table>thead {
            text-align: center;
            font-size: 20px;
            
        }

        table>#tbody {
            text-align: center;
            font-size: 15px;

            background-color: white;
        }

        th {
            padding-top: 20px;
            padding-bottom: 20px;
        }

        #tbody>tr>td {
            padding-top: 13px;
            padding-bottom: 13px;
        }

        /*----------------------------회원 아이디---------------------------------------*/

        #header_3 {
            position: relative;

            /*border: 1px solid purple;*/
        }

        .dropdown {
            position: absolute;
            margin: auto;

            width: 40%;
            height: 30%;

            top: 90px;
            bottom: 0px;
            left: 120px;
            right: 0px;

            background-color: white;
            font-weight: 900;
        }

        .dropdown>div {
            height: 100%;
        }

        .dropdown button, .dropdown a {
            width: 100%;
            height: 100%;

            font-size: 20px;

            background-color: white;
            border: 3px solid lightgray;
            color: black;
        }

        /*----------------------------검색---------------------------------------*/

        #header_4 {
            position: relative;

            /*border: 1px solid purple;*/
        }

        #search_form {
            width: 90%;
            height: 30%;

            font-size: 20px;
        }

        #search_form {

            margin: auto;
            position: absolute;
            top: 70px;
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

        /*--------------------------페이지바---------------------------------*/

        .pagination {

            display: flex;
            justify-content: center;

        }

        .page-link {

            font-size: 20px;
        }

        /*--------------------------선택 수정, 삭제---------------------------------*/
        
        #content_5>button {
            font-size: 25px;

            width: 30%;

            margin-top: 4%;

            font-size: 25px;

            color: white;
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
<%
	String userId = loginMember.getMemId();
%>

    <div class="wrap">
        <div class="background">
            <div id="header">
                <div id="header_1"></div>
                <div id="header_2">
                    <p id="p1">총 신고 수 : <%= pi.getListCount() %></p>
                </div>
                <div id="header_3"></div>
                <div id="header_4">
                    <form action="<%= contextPath %>/search.re?cpage=1&keyword" id="search_form" method="get">
                        <div id="search_text">
                            <input type="text" id="keyword" name="keyword" placeholder="피신고자 아이디 입력">
                            <input type="hidden" name="cpage" value="1">
                        </div>
                        <div id="search_btn">
                            <input type="submit" value="검색">
                        </div>
                    </form>
                </div>
                <div id="header_5"></div>
            </div>
            <div id="content">
                <div id="content_1"></div>
                <div id="content_2">
                    <table border="1" style="border-color: lightgray;">
                        <thead>
                            <th width="180">NO</th>
                            <th width="130">신고자</th>
                            <th width="130">피신고자</th>
                            <th width="130">신고사유</th>
                            <th width="130">신고시간</th>
                            <th width="130">관리</th>
                        </thead>
                        <tbody id="tbody">
                        <% for(Report r : list) { %>
                            <tr>
                                <td><%= r.getReportNo() %></td>
                                <td><%= r.getReporter() %></td>
                                <td><%= r.getReported() %></td>
                                <td><%= r.getReCategory() %></td>
                                <td><%= r.getReDate() %></td>
                                <td><button type="button" class="btn btn-info" data-toggle="modal" data-target="#deleteModal">관리</button></td>
                             </tr>
                             <% } %>
                        </tbody>
                    </table>
                </div>
                <div id="content_3"></div>
            </div>
            <div id="footer">
                <div id="footer_1"></div>
                <div id="footer_2">
                    <tr>
               <td colspan="5" style="border-top: 1px solid gray;">
                  <ul class="pagination justify-content-center" style="margin: 0;">
                     <% if(pi.getCurrentPage() != 1){ %>
                     <li class="page-item"><button class="page-link"
                           onclick="location.href='<%= contextPath %>/report.ad?cpage=<%= currentPage -1 %>'">&lt;</button></li>
                     <% } %>
                     <% for(int i = startPage; i <= endPage; i++ ){ %>
                     <% if(i == currentPage){ %>
                     <li class="page-item"><button class="page-link btn active"
                           disabled><%= i %></button></li>
                     <% }else{ %>
                     <li class="page-item"><button class="page-link"
                           onclick="location.href='<%= contextPath %>/report.ad?cpage=<%= i %>'"><%= i %></button></li>

                     <% } %>
                     <% } %>

                     <% if(currentPage != maxPage){ %>
                     <li class="page-item"><button class="page-link"
                           onclick="location.href='<%= contextPath %>/report.ad?cpage=<%= currentPage +1 %>'">&gt;</button></li>
                     <% } %>
                  </ul>
               </td>
            </tr>
                </div>
                <div id="footer_3"></div>
            </div>
        </div>
    </div>

    <!-- 회원 신고 처리용 Modal -->
			<div class="modal" id="deleteModal">
                <div class="modal-dialog">
                  <div class="modal-content">
              
                    <!-- Modal Header -->
                    <div class="modal-header">
                      <h4 class="modal-title">신고 관리</h4>
                      <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
              
                    <!-- Modal body --> 
                    <div class="modal-body" align="center">
                      <form action="<%= contextPath %>/delete.re" method="post">
                          <b>회원 추방 시 계정 및 정보가 영구 삭제 됩니다.</b> <br><br>
                          <input type="hidden" name="userId" value="<%= userId %>">
                          <input type="text" name="memId" placeholder="신고할 아이디를 입력해주세요.">
                          <button type="submit" class="btn btn-sm btn-danger">추방</button>
                          
                      </form>
  
                    </div>
</body>
</html>