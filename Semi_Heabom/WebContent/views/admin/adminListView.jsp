<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    table,div{
        box-sizing: border-box;
    } 
    .outer_yj{
        width: 1900px;
        height: 660px;
        background-color: #fdeeee;
        margin: auto;

        margin-top: 1.5%;
    }
    .adminpage-left{
        background-color: gray;
        height: 100%;
        width: 100%;
        border-radius: 20px;
    }
    .adminpage-right{
        background-color: white;
        margin-left: 3%;
        height: 100%;
        width: 97%;
        border-radius: 20px;
    }
    .left-table, a {
        text-align: center;
        color: white;
    }
    .adminpage-right-p{margin: 0;}
    .adminpage-detail img, .adminpage-detail{
        border-radius: 20px; box-shadow: 2px 2px 1px gray;
        width: 100px;
        height: 90px;
        cursor: pointer;
    }
    .adminpage-detail .img-wrap {overflow: hidden;}
    .thumb {width: 100%; height: auto;}
    .adminpage-detail img:hover {transform: scale(1.1, 1.1); transition-duration: 0.2s;}
    .adminpage-detail img {transition-duration: 0.2s;}
    .myprofile:hover {color: lightgray;}
    .outer_yj{
        position: relative;
    }
    .adminpage-nameTag{
        position: absolute;
        top: 85px;
        left: 850px;
        background-color: rgb(87, 86, 86);
        color: white;
        border-radius: 10px;
        width: 120px;
        height: 50px;
        line-height: 50px;
        font-size: large;
        box-shadow: 3px 3px 3px lightgray;
    }

    </style>
</head>
<body>
<%@include file="../common/header.jsp"%>
<div class="outer_yj" align="center">
    <div class="adminpage-nameTag"><strong>관리자기능</strong></div>
    <div class="adminpage-area" >
        <table border="0">
            <tr>
                <td rowspan="2" width="250" height="420">
                    <div class="adminpage-left">
                        <br><br><br>
                        <table border="0" align="center" class="left-table">
                            <tr>
                                <td height="120" width="200">
                                    <div style="width: 100px; height: 100px; margin: auto;">
                                        <img src="https://tse1.mm.bing.net/th?id=OIP.bcPW77h3l7ZG8_rqFbsIKwHaHj&pid=Api&P=0&h=220" alt="" style="width: 100px; height: 100px; border-radius: 50px; cursor: pointer;">
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td height="20"></td>
                            </tr>
                            <tr>
                                <td height="20" style="font-size: large;"><strong>이곳은 관리자 <br> 페이지입니다.</strong></td>
                            </tr>
                            <tr>
                                <td height="65" style="font-size: xx-large;"><strong>관리자 전용</strong></td>
                            </tr>
                        </table>
                    </div>
                </td>
                <td width="400" height="100"></td>
            </tr>
            <tr>
                <td width="550" height="320">
                    <div class="adminpage-right">
                       <br><br>
                       <table border="0" align="center">
                        <!--
                        <tr>
                            <td width="150" height="110" align="center">
                                <div class="adminpage-detail" align="center">
                                    <a href="<%= contextPath %>/banner.ad"><img src="<%=contextPath%>/resource/img/admin/배너.png"></a>
                                    <p class="adminpage-right-p"><strong>배너수정</strong></p>
                                </div>
                            </td>
                            <td width="30"></td>
                            <td width="150" height="110" align="center">
                                <div class="adminpage-detail" align="center">
                                    <a href="<%= contextPath %>/logo.ad"><img src="<%=contextPath%>/resource/img/admin/로고.png"></a>
                                    <p class="adminpage-right-p"><strong>로고수정</strong></p>
                                </div>
                            </td>
                        </tr>
                    -->
                        <tr>
                            <td colspan="3" height="5"></td>
                        </tr>
                        <tr>
                            <td width="150" height="110" align="center">
                                <div class="adminpage-detail" align="center">
                                    <a href="<%= contextPath %>/report.ad?cpage=1"><img src="<%=contextPath%>/resource/img/admin/신고.png"></a>
                                    <p class="adminpage-right-p"><strong>신고관리</strong></p>
                                </div>
                            </td>
                            <td width="30"></td>
                            <td width="150" height="110" align="center">
                                <div class="adminpage-detail" align="center">
                                    <a href="<%= contextPath %>/check.ad?cpage=1"><img src="<%=contextPath%>/resource/img/admin/회원.png"></a>
                                    <p class="adminpage-right-p"><strong>회원조회</strong></p>
                                </div>
                            </td>
                        </tr>
                       </table>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</div>
<%@include file="../common/footer.jsp"%>
</body>
</html>