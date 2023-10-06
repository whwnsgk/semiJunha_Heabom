<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Heabom</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Noto+Sans+KR&display=swap');
        
        .footer{
            /* background-color: rgb(240, 240, 240); */
            /* background-color: #ffebeb; */
            /* background-color: rgb(248, 238, 226); */
            width: 100%;
            height: auto;
            margin: auto;
        }

        .footer_detail {
            text-align: center;
        }

        .footer_detail label {
            font-size: 12px;
        }

        .footer_bottom:hover{
            cursor: pointer;
            color: pink;
        }
        .footer label{
        	margin: 0px;
        }
        .footer *{
            font-family: 'Black Han Sans', sans-serif;
            font-family: 'Noto Sans KR', sans-serif;
        }
    </style>
</head>
<body>
    <div class="footer" align="center">
        <table border="0" class="footer_detail">
            <tr>
                <td colspan="3" style="text-align: left;"><label><strong>대표자 : 이원종 | 책임자 : 박용진 | 개인정보 관리책임자 : 조준하 | 운영총괄 : 장희주</strong></label></td>
            </tr>
            <tr>
                <td style="text-align: left;"><label>주소 : 서울시 강남구 역삼동 원종타워 8층 801호</label></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td style="text-align: left;"><label>고객센터 02-6682-1547</label></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td style="text-align: left;"><label>문의사항 : SunSpring@Heabom.com</label></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td width="1000" colspan="3"><label class="footer_bottom">서비스 이용약관</label> | <label class="footer_bottom">전자금융거래 약관</label> | <label class="footer_bottom">개인정보 처리방침</label> | <label class="footer_bottom">면책 공고</label> | <label class="footer_bottom">개인정보 수집항목</label> | <label class="footer_bottom"><strong>ⓒ HEABOM Corp.</strong></label></td>
            </tr>
            <tr>
                <td colspan="3" height="40"><label for=""><strong>COPYRIGHT © 2023 HeaBom ALL RIGHT RESERVED</strong></label></td>
            </tr>
        </table>
    </div>
</body>
</html>