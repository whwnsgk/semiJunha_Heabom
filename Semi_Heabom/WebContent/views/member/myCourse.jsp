<%@page import="com.heabom.course.model.vo.Course"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.heabom.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Course> clist = (ArrayList<Course>)request.getAttribute("clist");
	String cContextPath = request.getContextPath();
%>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Heabom</title>
    <style>
    .yj_myVisit_area{
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

    .yj_myVisit_detail{
        border: 1px solid white;
        padding: 10px;
    }

    .text_limit {
        width: 130px;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;  /* 말줄임 적용 */
        font-size: medium;
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
    .thumbnail{
        border: 0px solid white;
        width: 150px;
        display: inline-block;
        margin: 5px;
    }
    .thumbnail *:hover{
    	cursor: pointer;
    	opacity: 0.7;
        color: gray;
    }
    .thumbnail p {
        margin: 0;
    }
    .yj_location{
        color: blue;
        font-weight: bolder;
        font-size: small;
    }


    </style>
</head>
<body>
    <div class="yj_myVisit_area" align="center">
    	<% if(clist.size() > 1) { %>
	    	<% for (Course c : clist) { %>
		        <div class="thumbnail" align="center">
		        	<% if(c.getTitleImg().length() > 5) { %>
		            	<a href="<%=cContextPath%>/load.cs?cNo=<%=c.getCourseNo()%>"><img src="<%=cContextPath %><%=c.getTitleImg() %>" style="height: 120px; width: 150px; border-radius: 10px;"></a>
		            <% } else { %>
		            	<img src="https://breffee.net/data/editor/2210/20221013104826_fd5326c8ac17c04c88d91f03a8d313d8_5r8y.jpg" style="height: 120px; width: 150px; border-radius: 10px;">
		            <% } %>
		            <div class="text_limit"><strong>내코스</strong></div>
		            <div class="yj_location">지역 : <%=c.getLocationName() %></div>
		        </div>
	        <% } %>
        <% } else { %>
        <div class="thumbnail" align="center">
        	<a href="<%=cContextPath%>/searchCourse.pl"><p style="color: black;" >해봄에서는 나만의 코스를 만들수 있습니다.</p></a>
        </div>
        <% } %>
    </div>
</body>
</html>