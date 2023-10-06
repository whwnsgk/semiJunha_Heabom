<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Heabom</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
	<h2>장소 추가화면</h2>
    <form action="<%=contextPath%>/insert.pl" method="post" enctype="multipart/form-data">
        이름<input type="text" name = "placeTitle"><br>
        <select name="category" id="">
            <option value="호프">술집</option>
            <option value="카페">카페</option>
            <option value="음식">음식점</option>
        </select><br>
        장소<select name="location" id="">
            <option value="강남구">강남</option>
            <option value="서초구">서초</option>
            <option value="동작구">동작</option>
            <option value="강서구">강서</option>
            <option value="양천구">양천</option>
            <option value="구로구">구로</option>
            <option value="금천구">금천</option>
            <option value="관악구">관악</option>
            <option value="영등포구">영등포</option>
            <option value="송파구">송파</option>
            <option value="강동구">강동</option>
            <option value="광진구">광진</option>
            <option value="성동구">성동</option>
            <option value="용산구">용산</option>
            <option value="마포구">마포</option>
            <option value="서대문구">서대문</option>
            <option value="중구">중구</option>
            <option value="동대문구">동대문구</option>
            <option value="중랑구">중랑</option>
            <option value="종로구">종로</option>
            <option value="성북구">성북</option>
            <option value="은평구">은평</option>
            <option value="강북구">강북</option>
            <option value="도봉구">도봉</option>
            <option value="노원구">노원</option>
        </select>
        전화번호-<input type="text" name = "phone"><br>
        주소<input type="text" name = "address"><br>
        내용<textarea name="content" rows="10" style="resize: none;" required ></textarea><br>
        영업시간 :
        <select name="startTime" id="">
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
            <option value="13">13</option>
            <option value="14">14</option>
            <option value="15">15</option>
            <option value="16">16</option>
            <option value="17">17</option>
            <option value="18">18</option>
        </select>
        시부터
        <select name="endTime" id="">
            <option value="19">19</option>
            <option value="20">20</option>
            <option value="22">21</option>
            <option value="22">22</option>
            <option value="23">23</option>
            <option value="24">24</option>
            <option value="1">01</option>
            <option value="2">02</option>
            <option value="3">03</option>
            <option value="4">04</option>
            <option value="5">05</option>
            <option value="6">06</option>
            
        </select>
        시까지 <br>

        별점 <input type="range" value="5" min="0" max="5" name = "starPoint"> <br>
        홈페이지 <input type="text" name = "placeUrl"><br>
        예상소요시간 <input type="number" name = "useTime"> <br>
        예상소요비용 <input type="number" name = "usePrice">








        <table align="" border="1">
            <tr>
                <th>대표이미지</th>
                <td colspan="3" align="center">
                    <img id = "titleImg" width="250" height="170" onclick="chooseFile(1);">
                </td>
            </tr>
            <tr>
                <th>상세이미지</th>
                <td><img id="contentImg1" width="150" height="120" onclick="chooseFile(2);"></td>
                <td><img id="contentImg2" width="150" height="120" onclick="chooseFile(3);"></td>
                <td><img id="contentImg3" width="150" height="120" onclick="chooseFile(4);"></td>
            </tr>
        </table>

        <div id="file-area" style = "display:none">
            <input type="file" name="file1" id = "file1" onchange ="loadImg(this,1)" required>
            <input type="file" name="file2" id = "file2" onchange ="loadImg(this,2)" required>
            <input type="file" name="file3" id = "file3" onchange ="loadImg(this,3)">
            <input type="file" name="file4" id = "file4" onchange ="loadImg(this,4)">
        </div>
        <br>
        
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








        <button type="submit">등록</button>








    </form>
    
</body>
</html>


