package com.heabom.place.model.service;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.util.ArrayList;

import static com.heabom.common.JDBCTemplate.*;

import com.heabom.board.model.dao.BoardDao;
import com.heabom.board.model.vo.Board;
import com.heabom.common.model.vo.File;
import com.heabom.member.model.vo.MemberAttachment;
import com.heabom.place.model.dao.PlaceDao;
import com.heabom.place.model.vo.Place;
import com.heabom.place.model.vo.Review;

	public class PlaceService {
		
		
		public ArrayList<Place> selectPlace(String memNo){
			Connection conn = getConnection();
			ArrayList<Place> plist = new PlaceDao().selectPlace(conn, memNo);
			close(conn);
			return plist;
		}
		
		
		
		/**
		 * 조준하
		 * 장소삽입
		 * @param p
		 * @return
		 */
		public int insertPlace(Place p , ArrayList<File> list ) {
			Connection conn = getConnection();
			int result1 = 0 ; 
			result1 = new PlaceDao().insertPlace(conn,p);
			int result2= new PlaceDao().insertFileList(conn, list);
			
			
			if (result1 > 0 && result2 > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			return result1*result2 ;
			
		}
		
		/**
		 * 조준하
		 * 장소에 따른 장소리스트 조회
		 * @param lNo
		 * @return
		 */
		public ArrayList<Place> selectPlaceList(int lNo){
			Connection conn = getConnection();
			ArrayList<Place> list = new PlaceDao().selectPlaceList(conn, lNo);
			close(conn);
			return list ;
		}
		
		
		/**
		 * 조준하
		 * 장소 detailview 에 표시할 사진들을 우루루 가져올꺼임
		 * @return
		 */
		public ArrayList<File> selectFileList(String pNo){
			Connection conn = getConnection();
			ArrayList<File> fileList = new PlaceDao().selectFileList(conn , pNo);
			close(conn);
			return fileList ;
			
		}
		
		/**
		 * 조준하
		 * 좋아요 수 증가
		 * @param pNo
		 * @return
		 */
		public int likeUp(String pNo) {
			Connection conn = getConnection();
			int result = new PlaceDao().likeUp(conn, pNo);
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			return result ;
		}
		
		/**
		 * 조준하
		 * 좋아요수 가져오기
		 * @return
		 */
		public int likeCount(String pNo) {
			Connection conn = getConnection();
			int result = new PlaceDao().likeCount(conn ,pNo);
			close(conn);
			return result ;
		}
	
	
		/**
		 * 조준하
		 * 좋아요 있나없나 확인
		 * @return
		 */
		public int likeCheck(String memNo , String pNo) {
			Connection conn = getConnection();
			int result = new PlaceDao().likeCheck(conn, memNo ,pNo );
			close(conn);
			return result ;
		}
		
		/**
		 * 조준하
		 * 좋아요 테이블에 삽입
		 * @param memNo
		 * @param pNo
		 * @return
		 */
		public int likeInput(String memNo , String pNo) {
			Connection conn = getConnection();
			int result = new PlaceDao().likeInput(conn, memNo ,pNo );
			close(conn);
			return result ;
		}
		
		public int insertReview(Review re,MemberAttachment at) {
			Connection conn = getConnection();
			int result1 = new PlaceDao().insertReview(conn, re);
			System.out.println("여기는 service : " + re.getReNo());
			int result2 = 1;
			if(at != null) {
				result2 = new PlaceDao().insertReviewAttachment(conn, re, at);
			}
			if (result1 > 0 && result2 > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			return result1*result2 ; 
		}
		
		public ArrayList<Review> selectReplyList(String pNo){
			Connection conn = getConnection();
			ArrayList<Review> rlist = new PlaceDao().selectReplyList(conn, pNo);
			close(conn);
			return rlist;
		}
	
		
		/**
		 * 좋아요에 따른 등급 업그레이드 해보자
		 * @return
		 */
		public int upGrade(String writer) {
			Connection conn = getConnection();
			int result = new PlaceDao().upGrade(conn,writer);
			if (result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			return result ;
		}
		
		/**
		 * 좋아요가 눌리면 글쓴놈 포인트가 올라가야겠지?
		 * 조준하
		 * @param writer
		 * @return
		 */
		public int upPoint(String writer) {
			Connection conn = getConnection();
			int result = new PlaceDao().upPoint(conn , writer);
			if (result >0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			return result ;
		}
		
		public Place selectMyPlace(String pNo) {
			Connection conn = getConnection();
			Place p = new PlaceDao().selectMyPlace(conn, pNo);
			close(conn);
			return p;
		}
		
		public ArrayList<Place> myFavorSelect(String memNo){
			Connection conn = getConnection();
			ArrayList<Place> fList = new PlaceDao().myFavorSelect(conn, memNo);
			close(conn);
			return fList;
		}

}
