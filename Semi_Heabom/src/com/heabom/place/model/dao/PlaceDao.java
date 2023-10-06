package com.heabom.place.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.heabom.common.JDBCTemplate.*;

import com.heabom.board.model.vo.Board;
import com.heabom.common.model.vo.File;
import com.heabom.member.model.vo.MemberAttachment;
import com.heabom.place.model.vo.Place;
import com.heabom.place.model.vo.Review;

public class PlaceDao {
	private Properties prop = new Properties();
	
	public PlaceDao() {
		String filePath = PlaceDao.class.getResource("/db/sql/place-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Place> selectPlace(Connection conn,String memNo){
		ArrayList<Place> plist = new ArrayList<Place>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectPlace");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				plist.add(new Place(rset.getString("PLACE_NO"),
						rset.getString("PLACE_TITLE"),
						rset.getDate("MAKE_DATE"),
						rset.getString("PLACE_CONTENT"),
						rset.getInt("VIEW_COUNT"),
						rset.getInt("STAR_POINT"),
						rset.getString("HASHTAG_NAME"),
						rset.getString("IMGPATH")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return plist;
	}
	
	public int insertPlace(Connection conn , Place p ) {
		//insert 문 이니까 result 있어야 함
		int result = 0 ; 
		PreparedStatement pstmt = null ;
		String sql = prop.getProperty("insertPlace");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,p.getPlaceTitle());
			pstmt.setInt(2, p.getCategoryNo());
			pstmt.setString(3, p.getWriter());
			pstmt.setInt(4, p.getLocationNo());
			pstmt.setString(5, p.getPhone());
			pstmt.setString(6, p.getAddress());
			pstmt.setString(7, p.getPlaceContent());
			pstmt.setInt(8, p.getStartTime());
			pstmt.setInt(9, p.getEndTime());
			pstmt.setInt(10, p.getStarPoint());
			pstmt.setString(11, p.getPlaceUrl());
			pstmt.setInt(12, p.getUseTime());
			pstmt.setInt(13, p.getUsePrice());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result ; 
	}
	
	/**
	 * 조준하
	 * 장소 사진 리스트 tb_file 에 저장
	 * @param conn
	 * @param list
	 * @return
	 */
	public int insertFileList(Connection conn , ArrayList<File> list) {
		//insert 문
		int result = 0 ;
		PreparedStatement pstmt = null ;
		String sql = prop.getProperty("insertFileList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			for(int i = 0 ; i< list.size() ; i ++) {
				pstmt.setString(1, list.get(i).getOriginName());
				pstmt.setString(2, list.get(i).getChangeName());
				pstmt.setString(3, list.get(i).getFilePath());
				pstmt.setInt(4, list.get(i).getFileLevel());
				result = pstmt.executeUpdate();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result ; 
		
	}
	
	
	/**
	 * 조준하
	 * 검색후 장소조건에 맞는 장소list 반환
	 * @param conn
	 * @param lNo
	 * @return
	 */
	public ArrayList<Place>  selectPlaceList(Connection conn , int lNo) {
		//select 문 resultset 객체 필요
		
		ArrayList<Place> list = new ArrayList<Place>();
		
		ResultSet rset = null ;
		PreparedStatement pstmt = null ;
		
		String sql = prop.getProperty("selectPlaceList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Place p = new Place();
				p.setPlaceNo(rset.getString("PLACE_NO"));
				p.setPlaceTitle(rset.getString("PLACE_TITLE"));
				p.setCategoryNo(rset.getInt("CATEGORY_NO"));
				p.setWriter(rset.getString("WRITER"));
				p.setLocationNo(rset.getInt("LOCATION_NO"));
				p.setMakeDate(rset.getDate("MAKE_DATE"));
				p.setStatus(rset.getString("STATUS"));
				p.setPhone(rset.getString("PHONE"));
				p.setAddress(rset.getString("ADDRESS"));
				p.setPlaceContent(rset.getString("PLACE_CONTENT"));
				p.setStartTime(rset.getInt("START_TIME"));
				p.setEndTime(rset.getInt("END_TIME"));
				p.setStarPoint(rset.getInt("STAR_POINT"));
				p.setPlaceUrl(rset.getString("PLACE_URL"));
				p.setViewCount(rset.getInt("VIEW_COUNT"));
				p.setUseTime(rset.getInt("USE_TIME"));
				p.setUsePrice(rset.getInt("USE_PRICE"));
				p.setBestStatus(rset.getString("BEST_STATUS"));
				p.setTitleImg(rset.getString("TITLEIMG"));
				p.setLikeCount(rset.getInt("LIKECOUNT"));
				list.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list ;
		
	}
	
	/**
	 * 조준하
	 * 장소 detailview 에 표시할 사진들을 우루루 가져올꺼임
	 * @return
	 */
	public ArrayList<File> selectFileList(Connection conn, String pNo){
		//select 문 resultset 필요
		ResultSet rset= null ;
		PreparedStatement pstmt = null ; 
		ArrayList<File> fileList = new ArrayList<File>();
		
		String sql = prop.getProperty("selectFileList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				File f = new File();
				f.setFileNo(rset.getInt("FILE_NO")+ "");
				f.setOriginName(rset.getString("ORIGIN_NAME"));
				f.setFilePath(rset.getString("IMG"));
				fileList.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return fileList;
		
		
		
	}
	
	
	/**
	 * 좋아요 증가
	 * @return
	 */
	public int likeUp(Connection conn , String pNo) {
		int result = 0 ;
		PreparedStatement pstmt = null ;
		String sql = prop.getProperty("likeUp");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result ;
	}
	
	/**
	 * 좋아요수 가져오기 
	 * @return
	 */
	public int likeCount(Connection conn , String pNo) {
		ResultSet rset = null; 
		PreparedStatement pstmt = null ;
		int result = 0 ; 
		String sql = prop.getProperty("likeCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("LIKECOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return result ;
		
	}
	
	public int likeCheck(Connection conn , String memNo , String pNo) {
		ResultSet rset = null; 
		PreparedStatement pstmt = null ;
		int result = 0 ; 
		String sql = prop.getProperty("likeCheck");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memNo);
			pstmt.setString(2, pNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = 1 ; //값이 있음
			}else {
				result = 0 ; //값이 없음
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		//System.out.println("dao에서의 result " + result);
		return result; 
		
		
	}
	
	/**
	 * 조준하
	 * 좋아요테이블에 삽입
	 * @param conn
	 * @param memNo
	 * @param pNo
	 * @return
	 */
	public int likeInput(Connection conn , String memNo , String pNo) { 
		int result = 0 ; 
		PreparedStatement pstmt = null ;
		String sql = prop.getProperty("likeInput");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memNo);
			pstmt.setString(2, pNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	/**
	 * 박용진 : 리뷰등록
	 * 230901/0338
	 * @param conn
	 * @param re
	 * @return
	 */
	public int insertReview(Connection conn,Review re) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReview");
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("여기는 리뷰 dao : "+ re.getReRefNo());
			pstmt.setString(1, re.getReRefNo());
			pstmt.setString(2, re.getReWriter());
			pstmt.setString(3, re.getReContent());
			pstmt.setInt(4, re.getReRefStar());
			System.out.println("1번 : " + re.getReRefNo());
			System.out.println("2번 : " + re.getReWriter());
			System.out.println("3번 : " + re.getReContent());
			System.out.println("4번 : " + re.getReRefStar());
			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertReviewAttachment(Connection conn,Review re, MemberAttachment at) {
		int result = 0;
		PreparedStatement pstmt = null;
		System.out.println(re.getReNo());
		String sql = prop.getProperty("insertReviewAttachment");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			//pstmt.setString(4, re.getReNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Review> selectReplyList(Connection conn, String pNo){
		ArrayList<Review> rlist = new ArrayList<Review>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReplyList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				rlist.add(new Review(rset.getString("RE_NO"),
						             rset.getString("RE_WRITER"),
						             rset.getString("NICKNAME"),
						             rset.getString("RE_CONTENT"),
						             rset.getInt("RE_LIKE_STAR"),
						             rset.getInt("RE_REF_STAR"),
						             rset.getString("RE_DATE"),
						             rset.getString("IMGPATH"),
						             rset.getString("USERIMGPATH")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return rlist;
	}
	
	public int upGrade(Connection conn, String writer) {
		int result = 0 ; 
		PreparedStatement pstmt = null ;
		String sql = prop.getProperty("upGrade");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, writer);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result ;
		
	}
	
	/**
	 * 좋아요 눌르면 글 쓴 작가의 포인트 증가
	 * @param conn
	 * @param writer
	 * @return
	 */
	public int upPoint(Connection conn , String writer) {
		int result = 0 ; 
		PreparedStatement pstmt = null ;
		String sql = prop.getProperty("upPoint");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result ;
		
	}
	public Place selectMyPlace(Connection conn,String pNo) {
		Place p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMyPlace");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				p = new Place();
				p.setPlaceNo(rset.getString("PLACE_NO"));
				p.setPlaceTitle(rset.getString("PLACE_TITLE"));
				p.setCategoryNo(rset.getInt("CATEGORY_NO"));
				p.setWriter(rset.getString("WRITER"));
				p.setLocationNo(rset.getInt("LOCATION_NO"));
				p.setMakeDate(rset.getDate("MAKE_DATE"));
				p.setStatus(rset.getString("STATUS"));
				p.setPhone(rset.getString("PHONE"));
				p.setAddress(rset.getString("ADDRESS"));
				p.setPlaceContent(rset.getString("PLACE_CONTENT"));
				p.setStartTime(rset.getInt("START_TIME"));
				p.setEndTime(rset.getInt("END_TIME"));
				p.setStarPoint(rset.getInt("STAR_POINT"));
				p.setPlaceUrl(rset.getString("PLACE_URL"));
				p.setViewCount(rset.getInt("VIEW_COUNT"));
				p.setUseTime(rset.getInt("USE_TIME"));
				p.setUsePrice(rset.getInt("USE_PRICE"));
				p.setBestStatus(rset.getString("BEST_STATUS"));
				p.setTitleImg(rset.getString("TITLEIMG"));
				p.setLikeCount(rset.getInt("LIKECOUNT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return p;
	}
	
	public ArrayList<Place> myFavorSelect(Connection conn,String memNo) {
		ArrayList<Place> fList = new ArrayList<Place>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql =  prop.getProperty("myFavorSelect");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				fList.add(new Place(rset.getString("PLACE_NO"),
									rset.getString("WRITER"),
									rset.getString("PLACE_TITLE"),
						            rset.getInt("LOCATION_NO"),
						            rset.getString("MAKE_DATE"),
						            rset.getString("STATUS"),
						            rset.getString("PHONE"),
						            rset.getString("ADDRESS"),
						            rset.getString("PLACE_CONTENT"),
						            rset.getInt("START_TIME"),
						            rset.getInt("END_TIME"),
						            rset.getInt("STAR_POINT"),
						            rset.getString("PLACE_URL"),
						            rset.getInt("USE_TIME"),
						            rset.getInt("USE_PRICE"),
						            rset.getString("BEST_STATUS"),
						            rset.getInt("LIKECOUNT"),
						            rset.getString("TITLEIMG"),
						            rset.getString("LOCATION_NAME")
						            ));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return fList;
	}
	
}










