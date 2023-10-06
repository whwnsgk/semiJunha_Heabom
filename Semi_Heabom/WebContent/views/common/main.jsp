<%@page import="com.heabom.common.model.service.MainService"%>
<%@page import="com.heabom.place.model.vo.Place"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.heabom.admin.controller.BannerListController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	ArrayList<Place> bannerList = new ArrayList<Place> ();
    
	bannerList = new MainService().selectPlaceList();//메인 배너에 띄울 장소들 가져왔어용
	int nullCheck = 0; 
	System.out.println(bannerList);
	//for (int i = 0 ; i < bannerList.size(); i++){
   	//	System.out.println(bannerList.get(i));
	//}
	String contextPath2 = request.getContextPath();
	
	
	String pNo1 = null;
	String pNo2 = null;
	String pNo3 = null;
	String titleImg1 =null;
	String titleImg2 = null;
	String titleImg3 = null;
	
	
	if(!bannerList.isEmpty()){
	
	if (bannerList.size() == 1){
		pNo1 = bannerList.get(0).getPlaceNo();
		titleImg1 = bannerList.get(0).getTitleImg();
	}
	else if (bannerList.size() == 2){
		pNo1 = bannerList.get(0).getPlaceNo();
		pNo2 = bannerList.get(1).getPlaceNo();
		titleImg1 = bannerList.get(0).getTitleImg();
		titleImg2 = bannerList.get(1).getTitleImg();
	}else if (bannerList.size() == 3){
		pNo1 = bannerList.get(0).getPlaceNo();
		pNo2 = bannerList.get(1).getPlaceNo();
		pNo3 = bannerList.get(2).getPlaceNo();
		titleImg1 = bannerList.get(0).getTitleImg();
		titleImg2 = bannerList.get(1).getTitleImg();
		titleImg3 = bannerList.get(2).getTitleImg();
	}
	nullCheck = 1 ;
	System.out.println(titleImg1);
	}

    %>
    
	

    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Heabom</title>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <style>
        *{
            /*
            box-sizing: border-box;
            border: 1px solid red;
            */
        }

         #wrap{
            width: 1900px;
            height: auto;
            /*
            border: 0px solid black;
            box-sizing: border-box;
            */
            margin-top: 1.5%;

            background-color: rgb(253, 238, 238);
           
        } 
       
        div{
            /*
            box-sizing: border-box;
            border: 0px solid black;
            */
        }
  
        #content{
            width: 100%;
            height: 90%;
            box-sizing: border-box;

        }
        #content_1{
            float: left;
            height: 600px;
            width: 100%;
            /*
            box-sizing: border-box;
            border: 1px solid red;
            */
            background-color: rgba(255, 201, 201, 0.5);

            position: relative;
            
        }
        /*
        #content_2{
            float: left;
            height: 10%;
            width: 70%;
            box-sizing: border-box;
            
          
        }
        */
        
        #div1{
    
            width: 100%;
            height: 25%;
            box-sizing: border-box;
            
        }
        #div2{
            border: 0px solid black;
            height: 25%;
            text-decoration: none;
            color: black;
            font-weight: 900;
            font-size: xx-large;
            text-align: center;
   
           
        }
        #div3{
            border: 0px solid black;
            height: 25%;
            border-radius: 10px;
            text-align: center;
        }
        #div4{
            border: 0px solid black;
            height: 25%;
            
            text-align: center;
         
            
        }
        #best{
            text-decoration: none;
            color: black;
            font-weight: 900;
            width: 500px;
            height: 500px;
            
        }
 

        img {
        width: 59%;
        height: 77.2%;
        
        cursor: pointer;

      }

      .img {
        position: absolute;

        top: 12.8%;
        left: 41%;

        border-top-left-radius: 0%;
        border-bottom-left-radius: 0%;
      }

      #main {
        width: 1500px;
        height: 720px;
        box-sizing: border-box;
      
      }

      .text{
        color: black;
        font-size: xx-large;

        position: absolute;

        top: 110%;
        left: 10%;

        font-weight: 700;
        color: black;
      }






    </style>
</head>
<body>

    <div id="wrap">

        <div id="content">
            <div id="content_1" >
                    <div id="div1" ></div>
                    <div id="div2" ></div>
                    <div id="div3"  ></div>
                    <div id="div4" ></div>
                
            </div>
            <div id="content_2">
                <div id="main"></div>
            </div>
        </div>
    </div>



    <script>
        $(function(){
            let i = 1 ; 
            
            
            
            let bests = [
            " <h1 class = 'text'>오늘의 첫번째 HEABOM 추천 장소는?&nbsp;&nbsp;>></h1>",
            " <h1 class = 'text'>오늘의 두번째 HEABOM 추천 장소는?&nbsp;&nbsp;>></h1>",
            " <h1 class = 'text'>오늘의 세번째 HEABOM 추천 장소는?&nbsp;&nbsp;>></h1>",

            ]

            $("#div2").html(bests[0]);


                setInterval (function(){
                    $("#div2").html(bests[i]);
                    i++ ; 
                    if(i == 3){
                        i = 0 ; 
                    }
                
                },3000);
        
       

		

        //형꺼
        
		//분기 개빡세누 ㅋㅋ		
       let arr = []; 

    	if (<%=nullCheck%>== 0){
 
             arr = [
              "<a href = '<%=contextPath2%>/movebest.mi?pNo=<%=pNo1%>'><img  src='' class='img'>게시글없음</a>",
              "<a href = '<%=contextPath2%>/movebest.mi?pNo=<%=pNo2%>'><img  src='' class='img'>게시글없음</a>",
              "<a href = '<%=contextPath2%>/movebest.mi?pNo=<%=pNo3%>'><img  src='' class='img'>게시글없음</a>",

            ];
    	}else{

	        arr = [
	          "<a href = '<%=contextPath2%>/movebest.mi?pNo=<%=pNo1%>'><img  src='<%=titleImg1%>' class='img'></a>",
	          "<a href = '<%=contextPath2%>/movebest.mi?pNo=<%=pNo2%>'><img  src='<%=titleImg2%>' class='img'></a>",
	          "<a href = '<%=contextPath2%>/movebest.mi?pNo=<%=pNo3%>'><img  src='<%=titleImg3%>' class='img'></a>",
	
	        ];
    	}
    	
    	 let j = 1;
        
        $("#main").html(arr[0]);
        setInterval(function () {
          $("#main").html(arr[j]);
          j++;
          if (j == arr.length) {
            j = 0;
          }
        }, 3000);

    })

    

    </script>
    	<%@ include file="footer.jsp" %>

</body>
</html>