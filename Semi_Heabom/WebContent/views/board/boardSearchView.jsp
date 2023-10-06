<%@page import="com.heabom.common.model.vo.PageInfo"%>
<%@page import="com.heabom.board.model.service.BoardService"%>
<%@page import="com.heabom.board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	String keyWord = (String)request.getAttribute("keyWord");
	System.out.println(pi+"흠냐흠냐흠냐");
	
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	System.out.println(startPage+"시작");
	System.out.println(endPage + "끝");
%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        .outer{
            padding: 10px 10px 0 10px;
            width: auto;
            height: auto;
            border: 1px solid black;
            margin: 10%;
            background-color: white; 
        }
        div{
            box-sizing: border-box;
            /*border: 1px solid black;*/
        }
        .table-header>td button{
            height: 35px;
            width: 70px;
            font-size: 14px;
  
            
        }
        .table-header>td div{
            float: right;
        }
        .table-header>td div *{
			width: auto;
        }
        .table-header a{
            color: #000;
            text-decoration: none;
        }
        .post-notice{
            border: 1px solid #ffc6c9;
            border-radius: 10px;
            background-color: #ffe3e4;
            color: #ff4e59;
            font-weight: 600;
        }
        .table-hover{
            text-align: center;
        }
        tbody>tr:hover{
            cursor: pointer;
        }
        .post-notice-area{
            background-color: rgb(249, 238, 238);
        }
        
        .post-notice-title{
            color:  #ff4e59;
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
            font-weight:bold;
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

        .btn-secondary{
   
        }
        
    </style>
</head> 
<body>
<%@ include file ="../common/header.jsp" %>
    <div class="outer">
        <br>
        <h2 align="center">자유게시판</h2>
        <br><br>
        <table class="table table-hover">
            <thead>

                        <button onclick="location.href='<%=contextPath%>/enrollForm.bo'" style="border-radius: 5px; margin-left: 89.5%;">
                            <img style="width: 20px;" src="../../resource/img/board/free-icon-writing-3945501.png" style="margin-left: 870px; border: 1px solid black; width: 80px; border-radius: 8px;">
                            글쓰기
                        </button>
       				
    
                <tr class="table-header" style="bottom:0px">
                    <td colspan="5" style="border-bottom: 1px solid gray; border-top: 0px; text-align: left;">
                        <div style="width: 100%; height: 40px;" >
                            <!-- <div style="font-size: 14px;"><a href="">최신순</a> |</div>
                            <div style="font-size: 14px;"><a href="">조회순</a></div> -->
                            <!-- <div>
                                <select name="display" class="listCountCtrl" >
                                    <option value="10">10개씩보기</option>
                                    <option value="15">15개씩보기</option>
                                    <option value="20">20개씩보기</option>
                                    <option value="25">25개씩보기</option>
                                    <option value="30">30개씩보기</option>
                                </select>
                            </div> -->
                          
                            <div>
						        <form action="<%= contextPath %>/search.bo?cpage=1&keyword" id="search_form" style="width: 300px;" method="get">
                                    <div style="width:350px">
                                        <input type="text" name="keyword" style="border-radius: 7px; height: 35px; margin-left: 13%;" placeholder="제목 입력">
                                        <input type="hidden" name="cpage" value="1">
                                        <button class="btn btn-secondary" type="submit">검색</button>
                                    </div>
                                    <!-- <div>
                                    </div> -->
						        </form>
                            </div>
					                      
                            <div style="height: 100%; width: 100px; font-size: 14px; margin-right: 65.8%; padding-top:15px;" >
                                총 <%= pi.getListCount() %>개의 글
                            </div>
                        </div>
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
            <tbody>
                <% if(list.isEmpty()){ %>
	                <tr>
						<td colspan="5">아직 게시글이 존재하지 않습니다.</td>
	                </tr>
                <% }else{ %>
                	<% for(Board b : list){ %>
                		<% if(b.getBoardNo().substring(0, 1).equals("N")){ %>
					         <tr class="post-notice-area">        
					             <input type="hidden" value="<%= b.getBoardNo().substring(1) %>">
					             <td><div class="post-notice">공지</div></td>
					             <td class="post-notice-title"><%= b.getBoardTitle() %>
					             <% if(b.getCountReply() != 0){ %>
					             	<b style="color: red"> [<%= b.getCountReply() %>]</b>
					             <% }else{ %>
					             <% } %>
					             </td>
                		<% }else{ %>
			                <tr class="post-notice-area">        
					             <input type="hidden" value="<%= b.getBoardNo().substring(1) %>">
			                    <td><%= b.getBoardNo() %></td>
			                    <td><%= b.getBoardTitle()%>
								<% if( b.getCountReply() != 0){ %>
					             	<b style="color: red"> [<%= b.getCountReply() %>]</b>
					             <% }else{ %>
					             <% } %>
					             </td>

                		
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
                            	<li class="page-item"><button class="page-link" onclick="location.href='<%= contextPath %>/search.bo?keyword=<%= keyWord %>&cpage=<%= currentPage -1 %>'">Previous</button></li>
	                        <% } %>
	                        <% for(int i = startPage; i <= endPage; i++ ){ %>
		                        <% if(i == currentPage){ %>
			                        <li class="page-item"><button class="page-link btn active" disabled><%= i %></button></li>
		                        <% }else{ %>
			                        <li class="page-item"><button class="page-link" onclick="location.href='<%= contextPath %>/search.bo?keyword=<%= keyWord %>&cpage=<%= i %>'"><%= i %></button></li>
		                        
                        		<% } %>
                        	<% } %>
	                        
	                        <% if(currentPage != maxPage){ %>
	                            <li class="page-item"><button class="page-link" onclick="location.href='<%= contextPath %>/search.bo?keyword=<%= keyWord %>&cpage=<%= currentPage +1 %>'">Next</button></li>
	                      	<% } %>
                        </ul>
                    </td>
                </tr>
            </tfoot>
        </table>
    </div>
    	<script>
		$(function(){
			$(".post-notice-area").click(function(){
				<% if(loginMember != null){ %>
					location.href='<%= contextPath %>/detail.bo?bno=' + $(this).children().eq(0).val()
				<% }else{ %>
					alert("로그인 후 이용해주세요")
				<% } %>

			})
		})

	</script>
		<%@ include file="../common/footer.jsp"%>	
	
	
</body>
</html>