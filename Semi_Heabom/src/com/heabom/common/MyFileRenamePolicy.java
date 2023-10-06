package com.heabom.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{
	//인터페이스 추상 메서드 오랜만이고
	//원본파일 전달 받아서 파일명 수정작업 후 수정된 파일을 반환시켜주는 메서드 
	@Override
	public File rename(File originFile) {
		//원본파일명 ("aaa.jpg")
		String originName = originFile.getName();
		//수정파일명 ("2023081712253012345.jpg")
		//파일을 업로드 한 시간(년 월 일 시 분 초 ) + 5자리 랜덤값 (10000~99999) +원본파일 확장자
		
		//1.파일 업로드 시간(년 월 일 시 분 초 형태 ) String currentTime
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		//2. 5자리 랜덤값 int ranNum
		int ranNum = (int)(Math.random()*90000+10000);
		//3. 원본파일의 확장자를 구해보자
		String ext = originName.substring(originName.lastIndexOf("."));
		
		String changeName = currentTime + ranNum + ext ; 
		
		return new File(originFile.getParent(),changeName);
		//원본의 디렉토리를 알아낸후에 변경된 이름으로 저장하는 메서드.. 어 ..음 .. 뭔개소리야
		
	}
	
	
}