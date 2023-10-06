package com.heabom.common.model.service;

import static com.heabom.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.heabom.common.model.dao.Maindao;
import com.heabom.place.model.vo.Place;

public class MainService {
	
	
	public ArrayList<Place> selectPlaceList(){
	Connection conn = getConnection();
	ArrayList<Place> list = new Maindao().selectPlaceList(conn);
	//ArrayList<Place> list = new ArrayList<Place>();
	close(conn);
	return list ;
	
	}
	
	
	
	
	
	public Place selectBestPlace(String pNo) {
		Connection conn = getConnection();
		Place p = new Maindao().selectBestPlace(conn , pNo);
		close(conn);
		return p ; 
	}
}
