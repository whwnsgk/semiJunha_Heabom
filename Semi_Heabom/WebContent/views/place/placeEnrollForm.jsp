<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String plcontextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .place_Insert_Outer {
    width: 1900px;
    height: auto;
    background-color: #fdeeee;
    margin: auto;
    /* margin-top: 50px; */

    margin-top: 1.5%;
    }

    .insertBox tr, .insertBox tr{
        background-color: white;
    }
    .insertBox td {
        margin: 0;
        padding: 0;
    }
</style>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="place_Insert_Outer" aling="center">
    <br><br>
    <div class="placeOuter" align="center">
        <form action="<%=plcontextPath%>/insert.pl" method="post" enctype="multipart/form-data">
            <table class="insertBox" border="1" style="text-alig
         \n: center;">
                <tr>
                    <th width="85">장소명</th>
                    <td width=""><input type="text" name = "placeTitle"></td>
                    <th>카테고리</th>
                    <td>
                        <select name="category" id="">
                            <option value="호프">술집</option>
                            <option value="카페">카페</option>
                            <option value="음식">음식점</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>전화번호</th>
                    <td><input type="text" name = "phone"></td>
                    <th>지역구</th>
                    <td>
                        <select name="location" id="">
                            <option value="강남구">강남구</option>
                            <option value="서초구">서초구</option>
                            <option value="동작구">동작구</option>
                            <option value="강서구">강서구</option>
                            <option value="양천구">양천구</option>
                            <option value="구로구">구로구</option>
                            <option value="금천구">금천구</option>
                            <option value="관악구">관악구</option>
                            <option value="영등포구">영등포구</option>
                            <option value="송파구">송파구</option>
                            <option value="강동구">강동구</option>
                            <option value="광진구">광진구</option>
                            <option value="성동구">성동구</option>
                            <option value="용산구">용산구</option>
                            <option value="마포구">마포구</option>
                            <option value="서대문구">서대문구</option>
                            <option value="중구">중구구</option>
                            <option value="동대문구">동대문구</option>
                            <option value="중랑구">중랑구</option>
                            <option value="종로구">종로구</option>
                            <option value="성북구">성북구</option>
                            <option value="은평구">은평구</option>
                            <option value="강북구">강북구</option>
                            <option value="도봉구">도봉구</option>
                            <option value="노원구">노원구</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>주 소</th>
                    <td><input type="text" name = "address"></td>
                    <th>홈페이지</th>
                    <td><input type="text" name = "placeUrl"></td>
                </tr>
                <tr>
                    <th>내 용</th>
                    <td colspan="3" width="462">
                        <textarea name="content" cols="42" rows="10" style="resize: none;" required ></textarea>
                    </td>
                </tr>
                <tr>
                    <th>영업시간</th>
                    <td>
                        <select name="startTime" id="">
                            <option value="7">07시</option>
                            <option value="8">08시</option>
                            <option value="9">09시</option>
                            <option value="10">10시</option>
                            <option value="11">11시</option>
                            <option value="12">12시</option>
                            <option value="13">13시</option>
                            <option value="14">14시</option>
                            <option value="15">15시</option>
                            <option value="16">16시</option>
                            <option value="17">17시</option>
                            <option value="18">18시</option>
                        </select>
                        ~
                        <select name="endTime" id="">
                            <option value="19">19시</option>
                            <option value="20">20시</option>
                            <option value="22">21시</option>
                            <option value="22">22시</option>
                            <option value="23">23시</option>
                            <option value="24">24시</option>
                            <option value="1">01시</option>
                            <option value="2">02시</option>
                            <option value="3">03시</option>
                            <option value="4">04시</option>
                            <option value="5">05시</option>
                            <option value="6">06시</option>
                            
                        </select>
                    </td>
                    <th>별점</th>
                    <td><input type="range" value="5" min="0" max="5" name = "starPoint"> 
                    </td>
                </tr>
                <tr>
                    <th>소요시간</th>
                    <td><input type="number" name = "useTime" style="width: 100px;"></td>
                    <th>예상비용</th>
                    <td><input type="number" name = "usePrice" style="width: 100px;">원</td>
                </tr>
                <tr>
                    <th>대표이미지</th>
                    <td colspan="3" align="center"><img id = "titleImg" width="250" height="170" onclick="chooseFile(1);"></td>
                </tr>
                <tr>
                    <th>상세이미지</th>
                    <td align="center" style="width: 182px;"><img id="contentImg1" width="182" height="120" onclick="chooseFile(2);"></td>
                    <td align="center" style="width: 182px;"><img id="contentImg2" width="182" height="120" onclick="chooseFile(3);"></td>
                    <td align="center" style="width: 182px;"><img id="contentImg3" width="182" height="120" onclick="chooseFile(4);"></td>
                </tr>
            </table>

            <div id="file-area" style = "display:none">
                <input type="file" name="file1" id = "file1" onchange ="loadImg(this,1)" required>
                <input type="file" name="file2" id = "file2" onchange ="loadImg(this,2)" required>
                <input type="file" name="file3" id = "file3" onchange ="loadImg(this,3)">
                <input type="file" name="file4" id = "file4" onchange ="loadImg(this,4)">
            </div>

            <br>
            <div class="insertSubmitReset" align="center">
                <button class="btn btn-sm btn-success" type="submit">장소등록</button>
                <a class="btn btn-sm btn-danger" href="<%=plcontextPath%>/search.pl">뒤로가기</a>
            </div>

        <br><br><br><br><br>
    </div>
</div>

<%@include file="../common/footer.jsp"%>
        
        <script >
            function chooseFile(num){
                $("#file"+num).click();
            }
            function loadImg(inputFile , num){
                //inputFile 에는 현재 변화가 생긴 input type ="file" 요소객체
                //num 에는 몇변째 input 요소인지 알수 있다.
                //미리보기 하기 위해 전달받는 숫자이다.
                //선택된 파일이 있으면 input 파일이라는거에 inputfile.files[0]여기에 선택된 파일이 담겨있을것임.
                //inputFile.file.length 또한 1이될꺼임
                if (inputFile.files.length == 1){//파일이 선택된경우 => 파일읽어들여서 미리보기
                    //파일을 읽어들일FileReader 객체생성
                    const reader = new FileReader();
                    reader.readAsDataURL(inputFile.files[0]);
                    //해당파일을 읽어들이는 순간 해당 파일만이 가지고 있는 url 을 부여해줌
                    //파일 읽어들이기가 완료가 되었다면 실행할 함수는?
                    reader.onload = function(e){
                    //e.target.result -> 읽어들인 파일의 고유한 url 이 들어가 있다   
                        switch (num){
                            case 1: $("#titleImg").attr("src",e.target.result);
                            break;
                            case 2: $("#contentImg1").attr("src",e.target.result);
                            break;
                            case 3: $("#contentImg2").attr("src",e.target.result);
                            break;
                            case 4: $("#contentImg3").attr("src",e.target.result);
                            break;
                        }
                    }
                }else{//파일이 빠졌을경우
                    switch (num){
                            case 1: $("#titleImg").attr("src",null);
                            break;
                            case 2: $("#contentImg1").attr("src",null);
                            break;
                            case 3: $("#contentImg2").attr("src",null);
                            break;
                            case 4: $("#contentImg3").attr("src",null);
                            break;
                        }
                }
                
                
                
            }
        </script>
</form>
</body>
</html>

