<%@page import="com.heabom.member.model.vo.Member"%>
<%@page import="com.heabom.place.model.vo.Place"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Place> plist = (ArrayList<Place>)request.getAttribute("plist");
	// 장소번호, 장소제목, 장소 내용, 만든날짜, 조회수, 별점, 해시태그
	Member loginMember =  (Member)session.getAttribute("loginMember");
	String contextPath2 = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Heabom</title>
    <style>
    .yj_myPlace_area{
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

    .yj_myPlace_detail{
    height: auto;
    width: auto;
    border: 1px solid lightgray;
    padding: 10px;
    margin-bottom: 5px;
    }

    .yj_myPlace_detail img{
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

    .detail_tb div {
        cursor: pointer;
    }
    .detail_tb img:hover{
        cursor: pointer;
        opacity: 0.7;
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


    </style>
</head>
<body>
    <div class="yj_myPlace_area" align="cneter">
    <% if(plist.isEmpty()) { %>
        <div class="yj_myPlace_detail">
            <table border="0" class="detail_tb">
                <tr>
                    <td height="40" width="350" colspan="4">
                        <a href="<%=contextPath2%>/search.pl">
                            <p style="color: black;">
                                <strong><%=loginMember.getNickname() %>님의 핫한 장소 해봄과 함께 하세요.</strong>
                            </p>
                        </a>
                    </td>
                </tr>
            </table>
        </div>
    <% } else { %>
   	<% for(Place p : plist) { %>
        <div class="yj_myPlace_detail">
            <table border="0" class="detail_tb">
                <tr>
                    <td rowspan="4" width="300" height="130">
                    <% if(p.getImgpath().length() < 10) { %>
                        <a href="<%=contextPath2%>/myplaceView.mp?pNo=<%=p.getPlaceNo()%>"><img src="https://breffee.net/data/editor/2210/20221013104826_fd5326c8ac17c04c88d91f03a8d313d8_5r8y.jpg" alt=""></a>
                    <% }else{ %>
                    	<img src="<%=contextPath2 %><%=p.getImgpath() %>" alt="">
                    <% } %>
                    </td>
                    <td rowspan="4" width="10"></td>
                    <td height="40" width="350" colspan="4"><div class="text_limit"><a href="<%=contextPath2%>/myplaceView.mp?pNo=<%=p.getPlaceNo()%>" style="font-size: large; color: black;"><strong><%=p.getPlaceTitle() %></strong></a></div></td>
                </tr>
                <tr>
                    <td height="30" width="350" colspan="4">
                        <a href="<%=contextPath2%>/myplaceView.mp?pNo=<%=p.getPlaceNo()%>" style="color: black; text-decoration: none;"><div class="text_limit"><%=p.getPlaceContent() %></div></a>
                    </td>
                </tr>
                <tr>
                    <td height="20" width="350" colspan="4">
                        <div class="text_limit" >
                        	<% if(p.getHashtagName() != null) {%>
	                        	<% String[] hList = p.getHashtagName().split(","); %>
	                        	<% for(int i = 0; i<hList.length; i++) {%>
	                        		<a href="#">#<%= hList[i] %></a>
	                            <% } %>
                            <% }else{ %>
                            	<a href="#">#등록된 태그가 없습니다.</a>
                            <% } %>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td width="100" style="text-align: center; font-size: smaller;"><%=p.getMakeDate() %></td>
                    <td width="80" style="text-align: center; font-size: smaller;">조회수: <%=p.getStarPoint() %></td>
                    <td width="170" style="text-align: center; font-size: smaller;">
                    	별점:
                    	<% for(int i = 0; i<p.getViewCount(); i++) { %>
                    	⭐
                    	<% } %>
                    	(<%=p.getViewCount() %>)
                   	</td>
                </tr>
            </table>
        </div>
     <% } %>
     <% } %>
    </div>
</body>
</html>