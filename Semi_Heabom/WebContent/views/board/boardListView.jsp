<%@page import="com.heabom.common.model.vo.PageInfo"%>
<%@page import="com.heabom.board.model.service.BoardService"%>
<%@page import="com.heabom.board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
.outer {
	padding: 10px 10px 0 10px;
	border-radius: 10px;
	width: auto;
	height: auto;
	border: 1px solid black;
	margin: 5% 10% 10% 10%;
	background-color: white;
}

div {
	box-sizing: border-box;
	/*border: 1px solid black;*/
}

.post-notice {
	border: 1px solid #ffc6c9;
	border-radius: 10px;
	background-color: #ffe3e4;
	color: #ff4e59;
	font-weight: 600;
}

.table-hover {
	text-align: center;
}

tbody>tr:hover {
	cursor: pointer;
}

.post-notice-title {
	color: #ff4e59;
	font-weight: 600;
}

/* 페이지네이션 관련 */
.page-link {
	color: #000;
	background-color: #fff;
	border: 1px solid #ccc;
}

.page-item.active .page-link {
	/*z-index: 1;*/
	color: #555;
	font-weight: bold;
	background-color: #f1f1f1;
	border-color: #ccc;
}

.page-link:focus, .page-link:hover {
	color: #000;
	background-color: #fafafa;
	border-color: #ccc;
}
/* 페이지네이션 관련 끝 */
#search_form * {
	float: left;
	margin: 0;
}

tfoot td button{
	cursor: pointer;
}

</style>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<div class="outer">
		<br>
		<h2 align="center" style="border-bottom: none; padding-bottom: 40px;">자유게시판</h2>
		<br>
		<br>
		<table class="table table-hover">
			<thead>
				<% if(loginMember != null){ %>
					<tr>
						<td style="border-top: none;"></td>
						<td style="border-top: none;"></td>
						<td colspan="3" style="border-top: none; text-align: right;">
							<button class="btn btn-outline-secondary" onclick="location.href='<%=contextPath%>/enrollForm.bo'" style="height: 45px; font-size: 14px; font-weight: 800; width: 25%; border-radius: 5px;">
								<img style="height: 20px; margin-bottom: 5%;" src="<%= contextPath %>/resource/img/board/icon/writing.png">
								글쓰기
							</button>

						</td>
					</tr>

				<% } %>
				<tr class="table-header" style="border-bottom: 2px solid black; text-align: left;">
					<td colspan="2" style="border-top: 1px solid black; line-height: 45px;" >
							
									<%= pi.getListCount() %>개의 글
					</td>

					<td colspan="3" id="aa" style="border-top: 1px solid black; text-align: right;">

							<form action="<%= contextPath %>/search.bo?cpage=1&keyword" id="search_form" style="width: 100%;" method="get">
								<div style="width: 100%">
									<input type="text" name="keyword" style="width: 75%; border-radius: 7px; height: 45px;" placeholder="제목 입력"> 
									<input type="hidden" name="cpage" value="1">
									<button class="btn search" type="submit" style="font-size: 14px; font-weight: 800; width: 25%; height: 45px; border: 1px solid black;">검색
										<img style="height: 20px;" src="<%=contextPath%>/resource/img/board/icon/search.gif">
									</button>
								</div>
							</form>
					</td>

				</tr>
				<tr>
					<th style="width: 8%;">글번호</th>
					<th style="width: 57%;">제목</th>
					<th style="width: 10%;">작성자</th>
					<th style="width: 10%;">조회수</th>
					<th style="width: 15%;">작성일</th>

				</tr>

			</thead>
			<tbody id="list-area">
				<% if(list.isEmpty()){ %>
				<tr>
					<td colspan="5">아직 게시글이 존재하지 않습니다.</td>
				</tr>
				<% }else{ %>

				<% for(Board b : list){ %>
				<% if(b.getBoardNo().substring(0, 1).equals("N")){ %>
				<tr class="post-notice-area" style="background-color: rgb(249, 238, 238);">
				
					<td hidden><%= b.getBoardNo().substring(1) %></td>
					<td><div class="post-notice">공지</div></td>
					<td class="post-notice-title"><%= b.getBoardTitle() %> 
					<% if(b.getCountReply() != 0){ %>
						<b style="color: red"> [<%= b.getCountReply() %>]
					</b> <% }else{ %> <% } %></td>
					<% }else{ %>
				</tr>
				<tr>
					<td><%= b.getBoardNo().substring(1) %></td>
					<td><%= b.getBoardTitle()%> <% if( b.getCountReply() != 0){ %> <b
						style="color: red"> [<%= b.getCountReply() %>]
					</b> <% }else{ %> <% } %></td>


					<% } %>
					<td><%= b.getWriter() %></td>
					<td><%= b.getBoardCount() %></td>
					<td><%= b.getCreateDate() %></td>
				</tr>
				<% } %>

				<% } %>

			</tbody>
			<tfoot>
				<tr>
					<td colspan="5" style="border-top: 1px solid gray;">
						<ul class="pagination justify-content-center" style="margin: 0;">
							<% if(pi.getCurrentPage() != 1){ %>
								<li class="page-item"><button class="page-link" onclick="location.href='<%= contextPath %>/list.bo?cpage=<%= currentPage -1 %>'">Previous</button></li>
							<% } %>
							<% for(int i = startPage; i <= endPage; i++ ){ %>
								<% if(i == currentPage){ %>
									<li class="page-item"><button class="page-link btn active" disabled><%= i %></button></li>
								<% }else{ %>
									<li class="page-item"><button class="page-link" onclick="location.href='<%= contextPath %>/list.bo?cpage=<%= i %>'"><%= i %></button></li>

								<% } %>
							<% } %>

							<% if(currentPage != maxPage){ %>
							<li class="page-item"><button class="page-link"
									onclick="location.href='<%= contextPath %>/list.bo?cpage=<%= currentPage +1 %>'">Next</button></li>
							<% } %>
						</ul>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
	<script>
		$(function(){
			$("#list-area>tr").click(function(){
				<% if(loginMember != null){ %>
					location.href='<%= contextPath %>/detail.bo?bno=' + $(this).children().eq(0).text()
				<% }else{ %>
					alert("로그인 후 이용해주세요")
				<% } %>

			})
		})

	</script>
	<%@ include file="../common/footer.jsp"%>	
</body>
</html>