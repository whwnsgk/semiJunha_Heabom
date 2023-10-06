<%@page import="com.heabom.member.model.vo.ReviewReply"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<ReviewReply> relist = (ArrayList<ReviewReply>)request.getAttribute("relist");
	String reContextPaht = request.getContextPath();

%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Heabom</title>
    <style>
        .yj_myReview_area{
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
        .yj_myReview_detail{
            height: auto;
            width: auto;
            border: 1px solid lightgray;
            padding: 10px;
            margin-bottom: 5px;
        }
        .yj_myReview_detail img{
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
    </style>
</head>

<body>
    <div class="yj_myReview_area" align="cneter">
        <% if(relist.isEmpty()) { %>
            <div class="text_limit" style="font-size: small;">내 글에 리뷰 및 댓글이 없습니다.</div>
        <% } else { %>
        <% for(ReviewReply re : relist) { %>
            <div class="yj_myReview_detail">
                <table border="0" class="detail_tb">
                    <tr>
                        <td height="80" width="80">
                        <% if(re.getImgPath().length() < 5) { %>
                            <img src="<%=reContextPaht %>/resource/img/profile/기본이미지.png" alt="" style="width: 70%; height: 70%; border-radius: 50px;">
                        <% } else { %>
                        	<img src="<%=reContextPaht %><%=re.getImgPath() %>" alt="" style="width: 70%; height: 70%; border-radius: 50px;">
                        <% } %>
                        </td>
                        <td width="3"></td>
                        <td width="250">

                            
                            <% if(re.getReNo().substring(0,2).equals("RV")) { %>
                            	<a href="<%=reContextPaht %>/myplaceView.mp?pNo=<%=re.getReRefNo()%>" style="text-align: left; color: black;">
                            		<div style="font-size: medium; margin-bottom: 5px;"><strong><%=re.getNickname() %>님께서</strong>내 게시물에 리뷰를 작성하였습니다.</div>
                            		<div class="text_limit" style="font-size: medium;"><%=re.getReContent() %></div>
                           		</a>
                                <% } else { %>
                            	<a href="<%=reContextPaht %>/detail.bo?bno=<%=re.getReRefNo().substring(1) %>" style="text-align: left; color: black;">
	                               	<div style="font-size: medium; margin-bottom: 5px;"><strong><%=re.getNickname() %>님께서</strong>내 게시물에 댓글을 작성하였습니다.</div>
                            		<div class="text_limit" style="font-size: medium;"><%=re.getReContent() %></div>
                           		</a>
                                <% } %>
                            
                            
                        </td>
                    </tr>
                </table>
            </div>
        <% } %>
        <% } %>
    </div>
</body>

</html>