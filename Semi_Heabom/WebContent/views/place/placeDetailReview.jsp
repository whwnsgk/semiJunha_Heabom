<%@page import="com.heabom.place.model.vo.Place"%>
<%@page import="com.heabom.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath1 = request.getContextPath();
	Member loginMember1 = new Member();
	if((Member)session.getAttribute("loginMember") != null){
		loginMember1 =  (Member)session.getAttribute("loginMember");
	}
%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Heabom</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"/>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<style>
    div{border: 0px solid red;}
    .yj_place_area{
        width: 900px;
        height: auto;
        margin: auto;
        margin-top: 50px;
    }

    .yj_place_review{
        width: 900px;
        margin: auto;
        margin-top: 50px;
    }

    p{
        margin: 0;
    }

    .preview_detail{
        margin-bottom: 10px;
    }

    .reviewText{

        cursor: pointer;
    }

    .reviewText:hover{
        color: darkgray;
    }

</style>
</head>
<body>
<div class="yj_place_area" align="center">
    <form id="uploadForm" action="<%=contextPath1%>/review.pl" id="enroll-form" method="post" enctype="multipart/form-data">
            <input type="file" id="file1" name="file1" style="display:none;">
            <div class="place_text" align="center">
                <textarea name="content" id="content" cols="118" rows="5" style="resize: none;" placeholder="해봄은 여러분의 소중한 리뷰를 기다리고 있습니다."></textarea>
            </div>
            <div class="text_btn" align="center" style="float: left; width: 900px;">
            <% if(loginMember1.getMemNo() != null) { %>
                <div class="options" align="center" style="text-align: right;">
                    <button type="button" id="uploadBtn">파일첨부</button>
                    &lt; 별점 &gt;
                    <input type="hidden" name="star" id="star">
                    <input type="hidden" name="refNo" id="refNo" value="<%=place.getPlaceNo()%>">
                    <input type="hidden" name="writer" id="writer" value="<%=loginMember1.getMemNo()%>">
                    <select name="starpoint" id="starpoint">
                            <option value="5" selected>5점</option>
                            <option value="4">4점</option>
                            <option value="3">3점</option>
                            <option value="2">2점</option>
                            <option value="1">1점</option>
                        </select>
                        <input type="hidden" id="getstar" onclick="getStar(event);">
                        <button type="button" class="btn btn-sm btn-info" onclick="insertReview();">리뷰등록</button>
                        <button class="btn btn-sm btn-danger" id="allreset" type="reset">초기화</button>
                </div>
            <% } %>
            </div>
        </form>
</div>
<div class="yj_place_review" align="center">
    <div class="preview">

    </div>
</div>

<!-- 신고용 Modal -->

<script>
$(function(){ 
	selectReplyList();
	setInterval(selectReplyList, 100000);
    $("#uploadBtn").click(function(){
        $("#file1").click();
    })
    
    $(document).on('click','.reviewText',function(){
    $(this).next().css("display","")
	})
	
});

function uploadFile(){
    var form = $("#uploadForm")[0];
    var formData = new FormData(form);
    
    $.ajax({
        url:"review.pl",
        type:"post",
        data : formData,
        contentType : false,
        processData : false,
        success:function(){
            console.log("리뷰 사진 통신 성공!!!")
        },
        error:function(){
            console.log("리뷰 사진 통신 실패ㅠㅠ")
        }
    });
}

function getStar(event) {
    event.preventDefault();
    let star = $("#starpoint option:selected").val();
    $("#star").val(star);
}



function selectReplyList(){
    $.ajax({
    	url:"rlist.pl",
    	type:"post",
    	data:{
    		pNo:$("#refNo").val()
    	},
        success:function(list){
        	console.log(list);
            console.log("ajax 리뷰조회 성공 !!!")
            let result = "";
            $(".preview").html("");
            for(let i=0; i<list.length; i++){
             
                result += `<table class="preview_detail" border="2">
			                <tr>
			                    <td rowspan="2" width="80" height="80">
			                    	<div align="center">`
			                    	if(list[i].userImgPath && list[i].userImgPath.length < 5) {
			    						result +=	`<img src="<%=contextPath1%>/resource/img/profile/기본이미지.png" name="viewTitleImg" style="width: 75px; height: 75px; border-radius: 20px;">`
			                            } else {
			                            result += 	`<img src="<%=contextPath1%>/\${list[i].userImgPath}" name="viewTitleImg" style="width: 75px; height: 75px; border-radius: 20px;">`
			    						}
			    						result += `</div>
			                    </td>
			                    <td colspan="2">
			                    별점(`
			                    	for(let j = 0; j<list[i].reRefStar; j++) { 
			                    	result += `⭐`
			                    	}
			                    	result += `)\${list[i].reRefStar}
			                    </td>
			                </tr>
			                <tr>
			                    <td colspan="2">\${list[i].nickname} | \${list[i].reDate} | <a href="" data-toggle="modal" data-target="#reportModal\${i}" >신고</a>
			                    
			                    </td>
			                    <td>
			                    <div class="modal" id = "reportModal\${i}" align="center">
				                <div class="modal-dialog">
				                    <div class="modal-content">

				                        <!-- Modal Header -->
				                        <div class="modal-header">
				                            <h4 class="modal-title">리뷰신고</h4>
				                            <button type="button" class="close" data-dismiss="modal">&times;</button>
				                        </div>

				                        <!-- Modal body -->
				                        <div class="modal-body">
                                            <form action="<%=contextPath1%>/insert1.rp" method="post">
				                            <input type="hidden" name="userId" value="">
				                            <b>부적절한 댓글 및 사용자에 대해서 신고를 할 수 있습니다.<br>
				                                아래의 신고 내용을 참고 해서 작성해 주세요<br><br> </b>
				                                <table class="reportForm" border="0">
				                                    <tr>
				                                        <th>신고대상:</th>
				                                        <td><input type="text" id="xUser" name="xUser" value="\${list[i].nickname}" readonly style="background-color: lightgray;"></td>
				                                    </tr>
				                                    <tr>
				                                        <th>
				                                            신고글:
				                                        </th>
				                                        <td>
				                                            <textarea name="xContent" id="xContent" cols="30" rows="5" readonly style="background-color:lightgray; resize: none;"> \${list[i].reContent} </textarea>
				                                        </td>
				                                    </tr>
				                                    <input type="hidden" name="reNo" value="\${list[i].reNo}">
				                                    <input type="hidden" name="reporter" value="<%=loginMember1.getMemNo()%>">
				                                    <input type="hidden" name="reported" value="\${list[i].reWriter}">
				                                    <tr>
				                                        <th>신고종류 : </th>
				                                        <td>
				                                        	<input name="reprotTypeSelect" type="hidden" onclick="getReportType(event)" value="">
				                                            <select name="reportType" id="reportType">
				                                                <option value="비방">비방</option>
				                                                <option value="불법광고">불법광고</option>
				                                                <option value="허위게시글">허위게시글</option>
				                                            </select>
				                                        </td>
				                                    </tr>
				                                    <tr>
				                                        <th>신고내용 : </th>
				                                        <td>
				                                            <textarea name="reportContent" id="reportContent" cols="30" rows="5" style="resize: none;" minlength="1" required placeholder="신고내용은 신고종류에 맞게 작성해주세요. 부적절한 신고 내용은 신고자가 재제의 대상이 됩니다."></textarea>
				                                        </td>
				                                    </tr>
				                                    <tr>
				                                        <th colspan="2">
				                                            <p style="color: red; margin: 0; text-align: center;">무고한 신고는 신고자 계정이 재제 당할 수 있습니다.<input id="userReportCheck" type="checkbox" onclick="reportCheck();"></p>
				                                        </th>
				                                    </tr>
				                                </table>
				                                <br>
				                                <button type="button" id="thorwReport" class="btn btn-sm btn-danger" onclick="insertReport()" disabled>신고하기</button>
				                                <button type="submit" id="thorwReporter" style="display: none;"></button>
				                                <button type="reset" class="btn btn-sm btn-info">초기화</button>
				                            </form>
				                        </div>

				                    </div>
				                </div>
				            </div>
			                    </td>
			                    
			                   
			                </tr>`
			                
			                


			                if( list[i].imgPath != "/") {
			                result +=  `<tr>
			                    <td colspan="2" width="550">
			                        <p class="reviewText"> \${list[i].reContent}</p>
			                        <div class="noneImg" align="center" style="display:none">
			                            <img src="<%=contextPath1%>/\${list[i].imgPath}" alt="" width="350" height="300">  
			                        </div>
			                    </td>
			                    <td width="130" height="130">
			                        <img src="<%=contextPath1%>/\${list[i].imgPath}" alt="" width="130" height="130">  
			                    </td>
			                </tr>
			            </table>`
			            
			            } else {
			            result += `<tr>
			                    <td colspan="2" width="680" height="50">
			                    <p style="padding: 10px;"> \${list[i].reContent} </p>
			                    </td>
			                </tr>
			            </table>`
			            }    
			            console.log(i)
            }
            $(".preview").html(result);
            
            
        },
        error:function(){
            console.log("ajax 리뷰죠회 실패 ㅠㅠ")
        }
    })
}

// 등록 및 동기화
async function insertReview() {
	insertReview1();
    const result = await selectReplyList1();
};

function selectReplyList1(){
    return new Promise((resolve) => {
        setTimeout(() => {
            selectReplyList();
        }, 100);
    })
};


function insertReview1(){
    $("#getstar").click();
    uploadFile();

    var form = $("#uploadForm")[0];
    var formData = new FormData(form);
    
    console.log(form)
    console.log(formData)
      
	$.ajax({
		url:"review.pl",
		data:{
			content:$("#content").val(),
			star:$("#star").val(),
			refNo:$("#refNo").val(),
			writer:$("#writer").val(),
            file:formData,
		},
		contentType:false,
        processData:false,
		type:"post",
		success:function(result){
				// 한번더 불러줘서 갱신된 글을 불러 준다.
			console.log(result);
            console.log("리뷰작성 ajax 통신 성공!!!");
            $("#content").val("");
             
			if(result > 0){ // 댓글작성 성공! => 갱신된 댓글 리스트 조회
				$("#allreset").click(); // 정상적으로 입력했으면, 초기화 해준다.
			}else{
				console.log("result 문제발생!!!!");	
			}
			
		},
		error:function(){
			console.log("리뷰작성 ajax 통신 실패 ㅠㅠ");
		}
			  
	})
}


</script>


<!-- 체크박스 checked 하면 신고버튼 활성화 -->
<script>
    function reportCheck() {
        var checkbox = document.getElementById("userReportCheck");
        var reportButton = document.getElementById("thorwReport");

        if (checkbox.checked) {
            reportButton.removeAttribute("disabled");
        } else {
            reportButton.setAttribute("disabled", "disabled");
        }
    }
    
    function getReportType(event) {
        event.preventDefault();
        let reportSelect = $("#reportType option:selected").val();
        $("#reprotTypeSelect").val(reportSelect);
    }

    function insertReport(){
        $("#reprotTypeSelect").click();
        $("#thorwReporter").click();
    }
</script>

</body>
</html>