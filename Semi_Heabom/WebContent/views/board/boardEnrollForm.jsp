<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>

    <style>
        div {
            box-sizing: border-box;
        }

        .wrap {
            width: 1000px;
            margin: auto;
            height: auto;
        }

        /* 캐러셀 관련 */
        .carousel {
            width: 1000px;
            height: 500px;

        }

        .carousel-inner {
            width: 100%;
            height: 100%;

        }

        .carousel-item {
            text-align: center;
            width: 100%;
            height: 100%;
            background-color: lightgray;

        }

        .carousel-inner>div>img {
            width: auto;
            height: 100%;
        }

        /* 캐러셀 관련 끝*/

        /* 글쓰기 글자 폼 */
        #write-text {
            width: 1000px;
            height: 60px;
            font-size: 30px;
            line-height: 19px;
        }

        #write-text>div {
            padding-top: 10px;
            width: 100%;
            height: 100%;
            border-bottom: 3px solid gray;
        }

        /* 글쓰기 글자 폼 끝 */



        /* 글쓰기 폼 */

        .write-post-area {
            width: auto;
            height: auto;
        }

        #write-post-header {
            width: 100%;
            height: 50px;
        }

        #write-post-header>div {
            float: left;
            height: 100%;
            text-align: center;
            padding-bottom: 10px;
        }

        #write-post-header>div>* {
            height: 100%;
            width: 100%;
        }

        #write-post-title-area {
            width: 70%;
            padding-right: 10px;
        }

        #select-category-area {
            width: 30%;
        }

        #write-poster-footer {
            height: 35px;
            width: 100%;
        }

        #write-poster-footer>div {
            float: right;
        }

        #writer-poster-submit {
            height: 100%;
        }

        #admin-private {
            height: 100%;
            margin-right: 10px;
        }

        #notice-check {
            position: relative;
            top: 2px;

        }

        #notice-check-text {
            position: relative;

        }

        .note-resizebar {
            display: none;
        }

        .note-statusbar {
            display: none;
        }

        /* 해시태그 관련 */
        span {
            box-sizing: border-box;
            /*border: 1px solid black;*/
            float: left;
        }

        #input-tag {
            height: auto;
            overflow: auto;
        }

        #input-tag>span {
            height: 100%;
            width: auto;
        }

        #input-tag>span>* {
            float: left;
            line-height: 22px;
        }

        #input-tag>span>span {
            font-size: 14px;
            height: 100%;
            margin-left: 5px;
        }

        #input-tag>span>div input {
            height: 20px;
            border: 0px;
            width: 70px;

        }

        #input-tag>span>div input:focus {
            outline: none;
        }

        .tag-input-area button {
            background-color: white;
            border: 0px;

        }
        .parent-span{
        	padding-right: 10px;
            border: 0px;

        }

        /* 해시태그 관련 끝 */

        /* 글쓰기 폼 끝 */
        /* 파일 테이블 */
        #fileTable{
            width: 100%;
            margin-top: 10px;
            /* border: 1px solid red */ 
        }

    </style>
</head>

<body>
    <%@ include file ="../common/header.jsp" %>
    <% System.out.println(loginMember); %>
    <div class="wrap">
        
        <div id="demo" class="carousel slide" data-ride="carousel" style="padding: 20px 10px ;">
            
            <!-- Indicators -->
            <ul class="carousel-indicators">
                <li data-target="#demo" data-slide-to="0" class="active"></li>
                <li data-target="#demo" data-slide-to="1"></li>
                <li data-target="#demo" data-slide-to="2"></li>
            </ul>
            
            <!-- The slideshow -->
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="resource/img/1mj3112000b8kyfpd5FC3_Z_640_10000_R5.png_.webp" alt="Los Angeles">
                    <div class="carousel-caption">
                        <h3>워터밤</h3>
                        <p>놀러와~~~~~</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="resource/img/285632_356327_475.jpg" alt="Chicago">
                    <div class="carousel-caption">
                        <h3>화로축제</h3>
                        <p>흠냐링~</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="resource/img/5n90r48nlara9vx.png" alt="New York">
                    <div class="carousel-caption">
                        <h3>뮤직축제</h3>
                        <p></p>
                    </div>
                </div>
            </div>
            
            <!-- Left and right controls -->
            <a class="carousel-control-prev" href="#demo" data-slide="prev">
                <span class="carousel-control-prev-icon"></span>
            </a>
            <a class="carousel-control-next" href="#demo" data-slide="next">
                <span class="carousel-control-next-icon"></span>
            </a>
            
        </div>
        
        
        
        <div id="write-text" style="padding: 10px;">
            <div>
                글쓰기
            </div>
        </div>
        <form action="insert.bo" method="post" enctype="multipart/form-data">
            <input type="hidden" name="userNo" value="<%= loginMember.getMemNo()%>">
            <div class="write-post-area" style="padding: 10px;">
                <div id="write-post-header">
                    <div id="write-post-title-area">
                        <input type="text" id="write-post-title" name="title" placeholder="제목을 입력하세요." required>
                    </div>
                    <div id="select-category-area">
                        <select name="category" id="select-category" onchange="clickNoticeOption(this.value);">
                            <option value="F">자유게시판</option>
                            <% if(loginMember.getGrade().equals("태양")){ %>
                                <option value="N">공지사항</option>
                                <% } %>
                            </select>
                        </div>
                    </div>
                    
                    <textarea name="content" id="write-post" style="width: 100%; height: 500px; resize: none;" placeholder="내용을 입력하세요" required></textarea>
                    
                    
                <div id="input-tag" style="margin-top: 10px;">
                    <span class="parent-span">
                        <span>#</span>
                        <div class="tag-input-area">
                            <input class="tag-input" type="text" maxlength="50" placeholder="태그입력">
                            <button type="button" class='delete-tag'>x</button>
                        </div>
                    </span>
                </div>
                <div>
                    <table align="center" id="fileTable">
                        <tr>
                            <td width="20%" height="120" style="border: 1px solid gray;"><img src="" id="contentImg1" width="100%" height="100%" onclick="chooseFile(1)"></td>
                            <td width="20%" height="120" style="border: 1px solid gray;"><img src="" id="contentImg2" width="100%" height="100%" onclick="chooseFile(2)"></td>
                            <td width="20%" height="120" style="border: 1px solid gray;"><img src="" id="contentImg3" width="100%" height="100%" onclick="chooseFile(3)"></td>
                            <td width="20%" height="120" style="border: 1px solid gray;"><img src="" id="contentImg4" width="100%" height="100%" onclick="chooseFile(4)"></td>
                            <td width="20%" height="120" style="border: 1px solid gray;"><img src="" id="contentImg5" width="100%" height="100%" onclick="chooseFile(5)"></td>
                        </tr>
                    </table>
                    <div id="file-area" style="display:none;">
                        <input type="file" name="file1" id="file1" onchange="loadImg(this, 1);">
                        <input type="file" name="file2" id="file2" onchange="loadImg(this, 2);">
                        <input type="file" name="file3" id="file3" onchange="loadImg(this, 3);">
                        <input type="file" name="file4" id="file4" onchange="loadImg(this, 4);">
                        <input type="file" name="file5" id="file5" onchange="loadImg(this, 5);">
                    </div>
                </div>
                <div id="write-poster-footer" style="margin-top: 10px;">
                    <div id="writer-poster-submit">
                        <input type="button" class="btn btn-secondary" value="등록" onclick="postSubmit();">
                    </div>
                    <div id="admin-private" style="display: none;">
                        <input type="checkbox" id="notice-check" name="noticeUp" value="Y">
                        <label for="notice-check" id="notice-check-text" style="font-size: 11px;">상단고정</label>
                    </div>
                </div>
            </div>
            <input type="hidden" id="hiddenTag" name="tag">
        </form>
        <script>
            /* 해시태그 스크립트 */
            $(function () { 
                
                $(document).on('keydown', '.tag-input', function () {
                    $(this).css('width', 20);
                    let value = $(this).val();
                    $('.tag-input-area').append('<div class="virtual">' + value + '</div>')
                    
                    let inputWidth = $(this).siblings('.virtual').width()
                    $(this).css('width', inputWidth + 20);
                    $('.virtual').remove();
                    
                })
                $(document).on('click', '.delete-tag', function () {
                    let tagLength = $('.tag-input').length;
                    let ti = $('.tag-input').get()  
                    if(($(".delete-tag").index(this)==tagLength-1) && (ti[tagLength-1]).value==''){    // 지금누른 버튼이 마지막 인덱스의 버튼일떄
                        $(this).prev().val('');
                    }else{
                        $(this).parent().parent().remove();
                    }
                })      
                $(document).on('change', '.tag-input', function () {
                        
                        let tagLength = $('.tag-input').length;
                        let ti = $('.tag-input').get()  
                        if(ti[tagLength-1].value != ''){
                            $(document).on('click', '.delete-tag', function () {
                                return;
                            })
    
                            $('#input-tag').append("<span class='parent-span'><span>#</span><div class='tag-input-area'><input class='tag-input' type='text' maxlength='50' placeholder='태그입력'><button type='button' class='delete-tag'>x</button></div></span>");
                            $('.tag-input')[tagLength].focus();
                        }
                })
                
                
            })
            // 등록하기 버튼 클릭시 폼 전송하는 함수
            function postSubmit(){
            	
            	let hashtag = $(".parent-span input");
            	let hashlist = [];
            	for(i = 0 ; i < hashtag.length-1; i++){
            		
					hashlist.push(hashtag[i].value)
            	}
                $("#hiddenTag").val(hashlist)

                if($("#write-post-title").val()==""){
                    alert("제목은 필수 입력사항 입니다.")
                    $("#write-post-title").focus()
                }else if($("#write-post").val()==""){
                    alert("내용은 필수 입력사항 입니다.")
                    $("#write-post").focus()
                }else{
                    console.log($("#write-post-title").val())
                    let formSelect = $("form").submit();
                }
            }

            // select option에서 공지사항을 클릭했을때 상단게시체크박스가 나타나는 함수
            function clickNoticeOption(str){
				if(str=='N'){
					console.log("되나")
					document.getElementById("admin-private").style.display='';
                }else{
					document.getElementById("admin-private").style.display='none';
                    
                }
            }

            function chooseFile(i){
                $("#file" + i).click(); 
            }
            function loadImg(inputFile,i){
            	if(inputFile.files.length == 1){
            		const reader = new FileReader();

                    reader.readAsDataURL(inputFile.files[0]);

                    reader.onload = function(e){
                        switch(i){
                            case 1: $("#contentImg1").attr("src", e.target.result); break;
                            case 2: $("#contentImg2").attr("src", e.target.result); break;
                            case 3: $("#contentImg3").attr("src", e.target.result); break;
                            case 4: $("#contentImg4").attr("src", e.target.result); break;
                            case 5: $("#contentImg5").attr("src", e.target.result); break;
                        }
                    }
                }else{	
                    switch(i){
                    case 1: $("#contentImg1").attr("src", null); break;
                    case 2: $("#contentImg2").attr("src", null); break;
                    case 3: $("#contentImg3").attr("src", null); break;
                    case 4: $("#contentImg4").attr("src", null); break;
                    case 5: $("#contentImg5").attr("src", null); break;
                    
                    }
            	}
            }

        </script>

    </div>

</body>
</html>