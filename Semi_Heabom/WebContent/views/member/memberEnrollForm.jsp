<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //String contextPath = request.getContextPath();
    %>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Heabom</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    
    
        <style>
            #yak{
                border: 1px solid black; background-color: white; 
                width: 100%; height: 50px; line-height: 50px; 
                text-align: center; 
                border-radius: 0px; 
                margin: auto;
                cursor: pointer;
                 /*이거 중요*/
            }

            p{
                
                border: 0px solid lightgray;
                background-color: white;
                width: 100%;
                height: 100%;
                margin: auto;
                margin-top: 5px;
                padding: 10px;
                box-sizing: border-box;
                display: none;
                z-index: 30;
               
            }
    
              #wrap{
                width: 1900px;
                height: 800px;
                border: 0px solid black;
                box-sizing: border-box;
                margin: auto;
                margin-top: 30px;
    
            }

            /*
            div{
                border: 0px solid black;
                float: left;
                height: 100%;
                box-sizing: border-box;
            }
            */
            
            /*

            #header{
                float: none;
                height: 10%;
                box-sizing: border-box;
            }
            #header_1{
               
               height: 100%;
               width: 8%;
            }
            #header_2{
                height: 100%;
                width: 92%;
            }

            */
            /*
            #content{
                float: none;
                height: 90%;
                background-color: rgb(252, 252, 252);
            }

            

            #div1{
                width: 30%;
                
               
            }
            #div2{
                width: 40%;
                box-sizing: border-box;
                
            }
            #div3{
                width: 30%;
                
            }
    
            #div1-1{
                width: 95%;
    
            } 
            #div1-2{
                width: 5%;
                background-color: rgb(255, 232, 236);
            }
    
            */

    
            #div2>div{
                
               float: none;
               border: 0px solid black;
               width: 100%;
            }
    
    
            #div2-1{
                height: 30%;
                
                box-sizing: border-box;
            }
    
     
    
            #div2-2{

                height: 70%;
                box-sizing: border-box;
            }
            
         
            img{
                width: 100%;
                height: 70%;
            }
    
        
        #enroll-form table{
           
            margin: auto;
            width: 45%;
            background-color: white;
            
        } 
        
        #enroll-form input{
            margin: 10px;
            background-color: white;
           
           
        }
    
        input{
    
             border-top: none;
             border-left: none;
             border-right: none;
             
         }
    
    
         button{
            
            border-radius: 30px;
            
         }

         #memberEnrollFormTable {
            text-align: center;
         }
    
        </style>
    </head>
    <body>
    <%@include file="../common/header.jsp"%>
        <div id="wrap">
    
    
            <div id="content">
                <div id = "div1">
                    <div id="div1-1"></div>
                    <div id="div1-2"></div>
                </div>
        
        
                <div id = "div2">
                    
                    <div id ="div2-1">
                         <div id = "yak">회원가입 약관읽기</div>
                            <p id = "yak2">제 1 장 총칙
                                <br><br>
                                ① 이 약관은 서비스 화면이나 기타의 방법으로 이용고객에게 공지함으로써 효력을 발생합니다.
② 사이트는 이 약관의 내용을 변경할 수 있으며, 변경된 약관은 제1항과 같은 방법으로 공지 또는 통지함으로써 효력을 발생합니다.
<br><br>
 

제 3 조 (용어의 정의)
이 약관에서 사용하는 용어의 정의는 다음과 같습니다.
① 회원 : 사이트와 서비스 이용계약을 체결하거나 이용자 아이디(ID)를 부여받은 개인 또는 단체를 말합니다.
② 신청자 : 회원가입을 신청하는 개인 또는 단체를 말합니다.
③ 아이디(ID) : 회원의 식별과 서비스 이용을 위하여 회원이 정하고 사이트가 승인하는 문자와 숫자의 조합을 말합니다.
④ 비밀번호 : 회원이 부여 받은 아이디(ID)와 일치된 회원임을 확인하고, 회원 자신의 비밀을 보호하기 위하여 회원이 정한 문자와 숫자의 조합을 말합니다.
⑤ 해지 : 사이트 또는 회원이 서비스 이용계약을 취소하는 것을 말합니다.
<br><br>
 

제 2 장 서비스 이용계약
<br><br>
 

제 4 조 (이용계약의 성립)
① 이용약관 하단의 동의 버튼을 누르면 이 약관에 동의하는 것으로 간주됩니다.
② 이용계약은 서비스 이용희망자의 이용약관 동의 후 이용 신청에 대하여 사이트가 승낙함으로써 성립합니다.

<br><br>
 

                            <input type="checkbox" id = "check">동의합니다
                            </p>
                    </div>
                  
                    <div id ="div2-2">
                        <form id = "enroll-form" action="<%=contextPath%>/insert.me" method="post"  enctype="multipart/form-data">
            
           <!-- enctype="multipart/form-data" -->  
                            <table border="1" id="memberEnrollFormTable">
                                <tr>
                                    
                                    <td>아이디<input type="text" id ="userId" name="userId" maxlength="12" placeholder="첫글자 영문자로 영문자 숫자 조합하여 총 4~12자"  size = 40   required ></td>
                                    <td><button type="button" onclick="idCheck();">중복확인</button></td>
                                    <!-- <td><button type="button" onclick="idCheck();">중복확인</button></td> -->
                                </tr>
                                <tr>
                                    
                                    <td>비번<input type="password" id="userPwd" name="userPwd"  placeholder="영문자 (대소문자) , 숫자 , 특수문자 (!@#$%^&*) 로 총 8~15글자로 이루어져야함" size = 40  maxlength="15" required></td>
                                    
                                </tr>
                                <tr>
                                    
                                    <td><input type="password"  id="checkPwd" placeholder="비번확인" size = 40  maxlength="15" required></td>
                                    
                                </tr>
                                <tr>
                                    
                                    <td><input type="text" id = "userName" name="userName" placeholder="이름" size = 40  maxlength="6" required></td>
                                    
                                </tr>
                                <tr>
                                    
                                    <td><input type="text" name="phone" size = 40  placeholder=" 전화번호- 포함해서 입력"></td>
                                    
                                </tr>
                                <tr>
                                    
                                    <td><input type="email" size = 40  placeholder="이메일" name="email"></td>
                                   
                                </tr>
                                <tr>
                                    
                                    <td><input type="text" size = 40  placeholder="mbti" name="mbti"></td>
                                    
                                </tr>
                            </tr>
                            <tr>
                                
                                <td><input type="text" size = 40  placeholder="닉네임" name="nickName"></td>
                               
                            </tr>
                            <tr>
                                <td><input type="file" name = "upfile">프사</td>
                            </tr>
                            
                                <tr>
                                    <th> <button id="hi" type="submit" onclick=" return validate();" style="display: none;">회원가입</button><button type="reset" >초기화</button></th>
                                   
                                </tr>
            
                                
                            </table>
                
                        </form>
                    </div>
    
    
    
        <script>

            const userId = document.getElementById("userId"); //아이디 값 가져오기 
            const userPwd = document.getElementById("userPwd"); //아이디 값 가져오기 
            const checkPwd = document.getElementById("checkPwd"); //아이디 값 가져오기 
            const userName = document.getElementById("userName"); //아이디 값 가져오기 
            $(function(){

                $("#enroll-form").css('display','none');
                $("#yak").click(function(){
                    //클릭한 요소의 바로 뒤 요소 기억나지? 동위!
                    //같은레벨에 있는거 알쥐
                    //보여지는 상태면 안보이게 안보이는 상태면 보여지게 하자
                    const p = $(this).next(); //p는 jquery방식으로 선택된 요소를 담아둘때 앞에 $를 붙일떄도 있음
                    //뭐 없어도 됨
    
                    if(p.css("display") == "none"){ //속성명만 주면 반환한다! 굿 잘 했어 none 에 큰따옴표가 필요하네..
                        //none 도 하나의 속성이라서 큰따옴표가 필요해
    
                        //기존건 닫히고 지금것만 열리게 하고 싶어? ㅇㅋㅇㅋ
                        $(this).siblings("p").slideUp();
    
                        p.slideDown();
                    }else{
                        p.slideUp();
                    }
                    //p.slideToggle(); //위에껄 통합한게 toggle좋네
                
                    //slide가 굉장히 세련된다. 토스같네
    
                })
    
            })
    
            $("#check").click(function(){
                    $("#yak").css('display','none');
                    $("#yak2").css('display','none');
                    $("#enroll-form").css('display','block');
    
                    if ( $("#check").is(':checked')){
                        $("#hi").attr('disabled',false);
                       
                    }else{
                        $("#hi").attr('disabled',true);
                    }
    
                    
                })
                
        
                function validate(){
                    
                    //1)아이디 검사
                    let regExp = /^[a-z][a-z\d]{3,11}$/;
                    if(!regExp.test(userId.value)){
                        alert("아이디 가 이상해");
                        userId.select();
                        return false ; 
                    }
                    regExp = /^[a-z\d!@#$%^&*]{8,15}$/i;
                    if(!regExp.test(userPwd.value)){
                        alert("비밀번호가 유효하지 않음");
                        userPwd.value = null; 
                        userPwd.focus();
                        return false ;
                   }

                //3)비밀번호가 같나요?
                    if(userPwd.value != checkPwd.value){
                        alert("비밀번호가 동일하지 않습니다.")
                        checkPwd.value = "";
                        checkPwd.focus();
                        return false;
                    }
                    //4)이름이 제대로 되었나요? 한글이어야 하고 2글자 이상
                    regExp = /^[가-힣]{2,}$/;
                    if (!regExp.test(userName.value)){
                        alert("이름이 제대로 되지 않았습니다");
                        userName.value = "똑바로 입력해";
                        userName.focus();
                        
                        return false ; 
                    }

                }  

            function idCheck(){
            //중복확인 버튼을 클릭을 하면 사용자가 입력한 아이디를 넘겨서 조회요청을 할꺼여
            //실습 시켜주십쇼
            //1) 메세지로 너 이거 못쓴다 다시 입력할수 있도록 유도하겠다
            //2) 진짜 사용하겠냐고 물어볼꺼고
            //3) 사용하겠다 라고 하면 더이상 아이디 수정 못하게끔 수정불가로 만들고
            //4) 회원가입 버튼 누르게 할꺼임
            //5) 사용안한다고 하면 다시 입력하게 유도한다.
            //const $idInput = $("#userId");
      
            $.ajax({
                url : "idCheck.me",
                data : {checkId : $("#userId").val()},
                success : function(result){
                    
                    if(result == 'NNNNN'){
                    	//사용불가능
                    	alert("이미 존재하거나 탈퇴한 회원의 아이디 일수 있음");
                    	$idInput.focus();
                    }else{
                    	//사용가능
                    	if(confirm("사용가능한 아이디 입니다. 사용하시겠습니까?")){
                    		$("#hi").css("display","block");
                    		$("#userId").attr("readonly","true");
                    	}else{
                    		$idInput.focus();
                    	}
                    }
                    
                    
                },
                error : function(){
                    console.log("아이디 중복체크용 ajax통신 실패..ㅠ")
                }
                
            })
        }
         
        </script>
    </body>
    </html>