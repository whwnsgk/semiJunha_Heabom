<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList searchKey = (ArrayList)request.getAttribute("searchKey");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Heabom</title>
<style>
    #form{
        margin-top: 500px;
        margin: auto;
        background-color: pink;
        width: 500px;
    }
</style>
</head>
<body>	
<%@include file = "../common/header.jsp" %>
        <div id = "form" >
	    <form action="<%=contextPath%>/courseSelect.pl" align ="center">
        <input type="checkbox" name = "check" value = "1">술한잔
        <input type="checkbox" name = "check" value = "2">커피한잔 하실래요? 
        <input type="checkbox" name = "check" value = "3">배고파요!
        <br>
        <button type="submit">가볼까요?</button>
   		</form>
        </div>
       
	
	
</body>
</html>