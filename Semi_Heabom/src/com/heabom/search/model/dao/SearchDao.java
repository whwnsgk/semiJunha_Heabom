package com.heabom.search.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SearchDao {
	private Properties prop = new Properties();
	
	public SearchDao() {
		String filePath = SearchDao.class.getResource("/db/sql/search-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
