<%@page import="com.heabom.place.model.vo.Place"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<Place> list = (ArrayList<Place>)request.getAttribute("coursePlaceList");
       	session.setAttribute("placeSearchList", list);
 
    	//젠장 place 에 카테고리가 int 로 되어있어서 고생좀 합니다.
    	//vo 수정하기도 귀찮고 join 쿼리 돌리기는 더 귀찮으니까 걍 이없으면 잇몸으로 씹습니다. 시간도 없고; 
    	String category = null ; 
    	int locationNo = list.get(0).getLocationNo();
    	
    	int totalTime = 0 ;
    	int totalMoney = 0 ; 
    	for(int i =0; i<list.size() ; i++){
    		totalMoney += list.get(i).getUsePrice();
    		totalTime += list.get(i).getUseTime();
    	}
    	
    	//ArrayList <String> saveList  = new ArrayList<String>();
    	//String [] saveList = new String [3];
    	//for(int i =0; i<list.size() ; i++){
    	//	saveList[i] = list.get(i).getPlaceNo();
    	//}
    	String str1 = null;
    	String str2 = null;
    	String str3 = null;
    	
    	if(list.size() == 1){
    	 str1 = list.get(0).getPlaceNo();
    	}else if (list.size() == 2){
    	 str1 = list.get(0).getPlaceNo();
    	 str2 = list.get(1).getPlaceNo();
    		}else{
	    	str1 = list.get(0).getPlaceNo();
	       	str2 = list.get(1).getPlaceNo();
	    	str3 = list.get(2).getPlaceNo();
    		}
    %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Heabom</title>
    <style>
#catagory-bar {
  display: flex;
  gap: 32px;
  padding: 20px 40px 0;
  overflow: auto;
}
#catagory-bar::-webkit-scrollbar {
  display: none;
}
.active-img {
  display: none;
}
.catagory-button{
  color: #717171;
  font-size: 12px;
  font-weight: 600;
  cursor: pointer;
}
.catagory-button img {
  width: 28px;
}
.catagory-button:hover {
  color: #000000;
  border-bottom: 0px solid #DDDDDD;
}
#active-catagory-button{
  color: #000000;
  border-bottom: 0px solid #000000;
}
#active-catagory-button .active-img {
  display: inline-block;
}
#active-catagory-button .inactive-img {
  display: none;
}  

.wrap {
  width: 1900px;
  text-align: center;
  border: 0px solid black;
  margin: auto;
}

main {
    display: flex;
    justify-content: center;
    padding: 20px 80px;
}

/* section {
    display: grid;
    grid-template-columns: repeat(4, 308px);
    justify-content: center;
    align-items: center;
    box-sizing: border-box;
    gap: 40px 24px;
} */

.item {
    cursor: pointer;
    border: 0px solid black;
    text-align: center;
    
}

.img {

  width: 308px;
  height: 293px;
  overflow: hidden;
  border-radius: 23px;
  border: 1px solid black;
  margin: auto;
  
  
}

.img img {
    width: 100%;
    height: 100%;
    transition: color 0.25s, border-color 0.25s, box-shadow 0.25s, transform 0.25s;
    
    
}

.img img:hover {
  box-shadow: 0 0.5em 0.5em -0.4em #6b6b6b;
  transform: translateY(-0.2em);
}

.description {
  margin-top: 13px;
  display: flex;
  flex-direction: column;
  gap: 3px;
  font-size: 15px;
  color: rgb(34, 34, 34);
  border: 1px solid black;
}

.description>.description_title {
    font-weight: bold;
}

#plzLogin{
            margin-top: 30px;
            cursor: pointer;
        }
        
        #plzLogin:hover {
            color: red;
        }

    </style>
</head>
<body>
	
    <%@include file = "../common/header.jsp" %>
    <h1 align="center">코스조회</h1>
    <%if (loginMember != null){ %>
   		<div>
   		 <%=loginMember.getNickname() %> 님이 저장하신 코스입니다
   		</div>
    <%}%>
    
    <div class="wrap">
    
    
       <section>
              코스 정보 조회
              <ul style="list-style-type: none;">
                <li>총 예상 소요 시간 : <%=totalTime %></li>
                <li>총 예상 비용 :<%=totalMoney %> </li>
              </ul>
            </section>
          <%for (int i = 0 ; i <list.size() ; i ++ ) {%>
	          <%if (list.get(i).getCategoryNo() == 1){ 
	          		category = "주점";
	          }else if(list.get(i).getCategoryNo() == 2) {
	        	  	category = "카페";
	          }else{
	        	  category = "음식점";
	          }  %>
            
         
	          	
	        
            <section>
                <div class="item" style="width: 300px; height: 300px; float: left; margin-top: 50px;  margin-bottom: 50px; margin-left: 100px;">
                    <div class="img" >
                        <a href="<%=contextPath%>/placeDetailView.pl?index=<%=i%>"><img src="<%=contextPath%>/<%=list.get(i).getTitleImg()%>"></a>
                    </div>
                    <div class="description">
                        <div class="description_title">제목 : <%=list.get(i).getPlaceTitle() %></div>
                        <div class="description_sub1">분류 : <%=category %></div>
                        <div class="description_sub2">좋아요 <%=list.get(i).getLikeCount() %></div>
                    </div>
                </div>
            </section>
        <%} %>
    </div>
</body>
</html>