<%@page import="com.heabom.board.model.vo.Question"%>
<%@page import="com.heabom.board.model.vo.Answer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ArrayList<Question> qlist = (ArrayList<Question>)request.getAttribute("quArr");
	// 질문번호, 질문내용, 질문날짜, 답변자, 답변여부, 답변내용, 답변일자, 답변자닉네임
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Heabom</title>
<style>
.yj_myQnA_area {
	border: 0px solid;
	height: auto;
	width: 532px;
	margin: auto;
	margin-top: 10px;
	margin-left: 817px;
	background-color: white;
	padding: 20px;
	border-radius: 20px;
}

.yj_myQnA_detail {
	height: auto;
	width: auto;
	border: 1px solid white;
	padding: 10px;
	margin-bottom: 10px;
}

.pull {
	position: relative;
	margin-left: 10px;
	margin-right: 10px;
	margin-bottom: 20px;
	padding: 20px;
	width: 450px;
	height: auto;
	color: black;
	border-radius: 10px;
	background-color: #000;
	line-height: 30px;
	cursor: pointer;
}

.pull.gr {
	background-color: lightgray;
}

.pull.gr:after {
	content: "";
	position: absolute;
	right: 30px;
	top: 65px;
	border-left: 20px solid transparent;
	border-right: 20px solid transparent;
	border-top: 20px solid lightgray;
}

.pull.pk_complete {
	color: white;
	background-color: rgb(223, 188, 223);
	margin-bottom: 0;
}

.pull.pk_complete:after {
	content: "";
	position: absolute;
	left: 30px;
	bottom: 100px;
	border-left: 20px solid transparent;
	border-right: 20px solid transparent;
	border-bottom: 20px solid rgb(223, 188, 223);
}

.pull.pk_complete {
	color: white;
	background-color: rgb(223, 188, 223);
}

.text_limit {
	width: 400px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis; /* 말줄임 적용 */
}

.text_limit a {
	color: blue;
	font-size: small;
	font-weight: bolder;
}

.text_limit a:hover {
	color: yellowgreen;
}

.text_limit:hover {
	color: darkgray;
}

.pull.pk_unComplete {
	color: white;
	background-color: rgb(223, 188, 223);
}

.pull.pk_unComplete:after {
	content: "";
	position: absolute;
	left: 30px;
	bottom: 65px;
	border-left: 20px solid transparent;
	border-right: 20px solid transparent;
	border-bottom: 20px solid rgb(223, 188, 223);
}

.pull.pk_unComplete {
	color: white;
	background-color: rgb(223, 188, 223);
	margin-bottom: 0px;
}
</style>
</head>
<body>
	<div class="yj_myQnA_area" align="center">
	    <% if(qlist.size() == 0) { %>
			<div class="yj_myQnA_detail">
				<div class="pull gr">
					<div class="text_limit gr">
						<strong>해봄은 고객의 소리를 기다립니다.</strong>
					</div>
				</div>
			</div>        
       	<% } else { %>
        	<% for(Question q : qlist) { %>
				<div class="yj_myQnA_detail">
					<div class="pull gr">
						<div class="text_limit gr">
							<strong><%=q.getQuestionComment() %></strong>
						</div>
					</div>
				<% if(q.getAnswerContent() == null) { %>
					<!-- 답변 전 -->
					<div class="pull pk_unComplete">
						<div class="text_limit"><strong>관리자가 성실한 답변 작성중에 있습니다. 빠른시일내에 답변 드리겠습니다.</strong></div>
					</div>
				<% } else { %>
					<!-- 답변완료시 -->
						<div class="pull pk_complete">
							<table border="0">
								<tr>
									<td width="60">답변자 :</td>
									<td><strong><%=q.getAnswerNickname() %></strong></td>
									<td width="20"></td>
									<td width="70">답변일자:</td>
									<td><strong><%=q.getAnswerDate() %></strong></td>
								</tr>
								<tr>
									<td colspan="5" width="450">
										<div class="text_limit">
											<strong><%=q.getAnswerContent() %></strong>
										</div>
									</td>
								</tr>
							</table>
						</div>
					<% } %>	
				</div>    
			<% } %>        
		<% } %>
	</div>
</body>
</html>