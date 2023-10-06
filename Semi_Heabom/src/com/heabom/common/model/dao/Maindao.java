package com.heabom.common.model.dao;

import static com.heabom.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.heabom.place.model.vo.Place;


public class Maindao {
	
private Properties prop = new Properties();
	
	public Maindao() {
		String filePath = Maindao.class.getResource("/db/sql/main-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 조준하
	 * 메인 배너에 띄울 좋아요 많은 장소 가져오기 
	 * @param conn
	 * @return
	 */
	public ArrayList<Place> selectPlaceList(Connection conn){
		ArrayList<Place> list = new ArrayList<Place>();
		ResultSet rset = null ;
		PreparedStatement pstmt = null; 
		String sql = prop.getProperty("selectPlaceList");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Place p = new Place();
				p.setPlaceNo(rset.getString("PLACE_NO"));
				p.setPlaceTitle(rset.getString("PLACE_TITLE"));
				p.setTitleImg(rset.getString("TITLE_IMG"));
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
	
	public Place selectBestPlace(Connection conn , String pNo) {
		ResultSet rset = null ;
		PreparedStatement pstmt = null ;
		Place p = new Place();
		String sql = prop.getProperty("selectBestPlace");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
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
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return p;
		
	
	}
	
}







