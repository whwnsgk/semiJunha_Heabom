package com.heabom.course.model.dao;

import static com.heabom.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.heabom.course.model.vo.Course;
import com.heabom.place.model.vo.Place;
import com.heabom.search.model.dao.SearchDao;

public class CourseDao {
	private Properties prop = new Properties();
	public CourseDao() {
		String filePath = SearchDao.class.getResource("/db/sql/course-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 조준하
	 * 코스짜는곳에서 보여줄 place list 조회
	 * @param conn
	 * @param lNo
	 * @param cNo
	 * @return
	 */
	public ArrayList<Place> selectCourse(Connection conn , int lNo , int cNo){
		ArrayList<Place> list = new ArrayList<Place>();
		
		ResultSet rset = null ;
		PreparedStatement pstmt = null ;
		
		String sql = prop.getProperty("selectCourse");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lNo);
			pstmt.setInt(2, cNo);
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
	
	
	
	public ArrayList<Place> selectCoursePlaceList(Connection conn , ArrayList<String> courseList){
		//rset
		ResultSet rset = null ;
		PreparedStatement pstmt = null ;
		ArrayList<Place> plist = new ArrayList<Place>();
		String sql = prop.getProperty("selectCoursePlaceList");
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0 ; i<courseList.size(); i ++) {
				pstmt.setString(1, courseList.get(i));
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
					plist.add(p);
				}
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return plist;
		
	}
	
	public ArrayList<Course> myCourseSelect(Connection conn,String memNo){
		ArrayList<Course> clist = new ArrayList<Course>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("myCourseSelect");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				clist.add(new Course(
						rset.getString("PALCE1"),
						rset.getString("COURSE_NO"),
						rset.getString("TITLEIMG"),
						rset.getString("LOCATION_NAME")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return clist;
	}

	/**
	 * 조준하
	 * @param conn
	 * @param pl1
	 * @return
	 */
	public int saveCourse1(String writer ,Connection conn , String pl1 , int time , int money) {
		int result = 0 ; 
		PreparedStatement pstmt = null ;
		String sql = prop.getProperty("saveCourse1");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, pl1);
			pstmt.setInt(3, time);
			pstmt.setInt(4, money);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result ;
		
	}
	
	public int saveCourse2(String writer ,Connection conn , String pl1 , String pl2 , int time , int money) {
		int result = 0 ; 
		PreparedStatement pstmt = null ;
		String sql = prop.getProperty("saveCourse2");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, pl1);
			pstmt.setString(3, pl2);
			pstmt.setInt(4, time);
			pstmt.setInt(5, money);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result ;
	}
	
	public int saveCourse3(String writer , Connection conn , String pl1 , String pl2 , String pl3 , int time , int money) {
		int result = 0 ; 
		PreparedStatement pstmt = null ;
		String sql = prop.getProperty("saveCourse3");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, pl1);
			pstmt.setString(3, pl2);
			pstmt.setString(4, pl3);
			pstmt.setInt(5, time);
			pstmt.setInt(6, money);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result ;
	}
	
	/**
	 * 마이페이지에서 코스 보기 눌렀을때 가져올 PLACELIST
	 * @param conn
	 * @param cNo
	 * @return
	 */
	public ArrayList<Place> loadCourse(Connection conn , String cNo){
		ResultSet rset = null ;
		PreparedStatement pstmt = null ;
		String sql = prop.getProperty("loadCourse");
		ArrayList<Place> list = new ArrayList<Place>();
		
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cNo);
			pstmt.setString(2, cNo);
			pstmt.setString(3, cNo);
			
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
	
	
}








