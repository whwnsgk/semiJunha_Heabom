<%@page import="com.heabom.board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Board> mblist = (ArrayList<Board>)request.getAttribute("blist");
	String bContextPath = request.getContextPath();
%>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Heabom</title>
    <style>
    .yj_myBoard_area{
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

    .yj_myBoard_detail{
    height: auto;
    width: auto;
    border: 1px solid lightgray;
    padding: 10px;
    margin-bottom: 5px;
    }

    .yj_myBoard_detail img{
        height: 100%;
        width: 100%;
    }

    .text_limit {
        width: 300px;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;  /* 말줄임 적용 */
        font-size: larger;
    }

    .detail_tb div, .detail_tb img{
        cursor: pointer;
    }

    .text_limit a {
        color: blue;
        font-size: small;
        font-weight: bolder;
    }
    .text_limit a:hover {
        color: yellowgreen;
    }
    .text_limit:hover{
        color: darkgray;
    }
    #notMyboard{
        color: black;
        text-decoration: none;
    }
    #notMyBoard:hover{
        color: red;
    }


    </style>
</head>
<body>
    <div class="yj_myBoard_area" align="cneter">
    <% if(mblist.size() > 0) { %>
    	<% for(Board b : mblist) { %>
        <div class="yj_myBoard_detail">
            <table border="0" class="detail_tb">
                <tr>
                    <td rowspan="4" width="300" height="130">
                    <% if( b.getBoardImg().length() > 5) {%>
                        <a href="<%=bContextPath%>/detail.bo?bno=<%=b.getBoardNo().substring(1)%>"><img src="<%=bContextPath %><%=b.getBoardImg() %>" alt=""></a>
                    <% }else{ %>
                    	<img src="https://breffee.net/data/editor/2210/20221013104826_fd5326c8ac17c04c88d91f03a8d313d8_5r8y.jpg" alt="">
                    <% } %>    
                    </td>
                    <td rowspan="4" width="10"></td>
                    <td height="40" width="350" colspan="4"><div class="text_limit"><strong><a style="font-size: large; color: black; font-weight: bolder;" href="<%=bContextPath%>/detail.bo?bno=<%=b.getBoardNo().substring(1)%>"><%=b.getBoardTitle() %></a></strong></div></td>
                </tr>
                <tr>
                    <td height="30" width="350" colspan="4"><div class="text_limit"><a style="font-size: large; color: black; font-weight: normal;" href="<%=bContextPath%>/detail.bo?bno=<%=b.getBoardNo().substring(1)%>"><%=b.getBoardContent() %></a></div></td>
                </tr>
                <tr>
                <% if(b.getHashTagName() == null ) { %>
                	<td height="20" width="350" colspan="4">
                		<div class="text_limit" >
                			<a href="#">#용산</a> <a href="#">#불꽃축제</a> <a href="#">#서울데이트</a> <a href="#">#야경</a> <a href="#">#우리동네뷰맛집</a>
               			</div>
            		</td>
           		<% }else{ %>
	                <% if((b.getHashTagName().length() - b.getHashTagName().replace(",", "").length()) > 0) { %>
	                	<% String[] hashlist = b.getHashTagName().split(",");%>
	                    <td height="20" width="350" colspan="4">
	                    	<div class="text_limit" >
	                    	<% for(int i = 0 ; i<hashlist.length; i++) { %>
	                    		<a href="#">#<%=hashlist[i] %></a></td>
	  	                	<% } %>
	  	                	</div>
	                <% }else{ %>
	                	<td height="20" width="350" colspan="4">
	                		<div class="text_limit" >
	                			<a href="#">#<%=b.getHashTagName() %></a>
	               			</div>
	            		</td>
	                <% } %>
                <% } %>
                </tr>
                <tr>
                    <td width="120" style="text-align: center; font-size: smaller;">작성일: <%=b.getCreateDate() %></td>
                    <td width="80" style="text-align: center; font-size: smaller;">조회수: <%=b.getBoardCount() %></td>
                    <td width="150" style="text-align: center; font-size: smaller;"></td>
                </tr>
            </table>
        </div>
        <% } %>
    <% }else{ %>
            <div class="yj_myBoard_detail">
                <a id="notMyBoard" href="<%=bContextPath%>/list.bo?cpage=1" style="color: black;" >자유게시판에서 글을 작성해 보세요.</a>
            </div>
   	<% } %>
    </div>
</body>
</html>