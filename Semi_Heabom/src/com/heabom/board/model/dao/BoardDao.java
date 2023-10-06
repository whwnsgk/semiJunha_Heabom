package com.heabom.board.model.dao;

import static com.heabom.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.heabom.board.model.vo.Board;
import com.heabom.board.model.vo.PrevNextPage;
import com.heabom.board.model.vo.Reply;
import com.heabom.common.model.vo.File;
import com.heabom.common.model.vo.HashTag;
import com.heabom.common.model.vo.PageInfo;

public class BoardDao {
	
	private Properties prop = new Properties();
	
	public BoardDao() {
		try {
			prop.loadFromXML(new FileInputStream(BoardDao.class.getResource("/db/sql/board-mapper.xml").getPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int selectListCount(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
		
	}
	public int checkHash(Connection conn,String boardNo) {
		
		int checkyn = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("checkyn");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				checkyn = rset.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return checkyn;
		
	}
	public int selectKeyWordCount(Connection conn, String keyWord) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectKeyWordCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%' + keyWord + '%');
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
		
	}
	
	public ArrayList<Board> selectList(Connection conn, PageInfo pi){
		
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		// 1페이지 일때 0 부터, 2페이지 일때 11 부터
		
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit() + 1;
		
		// 1 페이지 일때 9까지 2페이지 일때 19 까지
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
//				Board b = new Board();
//				b.setBoardNo(rset.getString("board_no"));
				list.add(new Board(rset.getString("board_no")
								 , rset.getString("board_title")
								 , rset.getString("mem_id")
								 , rset.getInt("board_count")
								 , rset.getString("create_date")
								 , rset.getInt("count")
								 ));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	public ArrayList<Board> selectList(Connection conn, PageInfo pi, String keyWord){
		
		System.out.println(pi.getBoardLimit());
		
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectKeyWord");
		
		// 1페이지 일때 0 부터, 2페이지 일때 11 부터
		
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit() + 1;
		
		// 1 페이지 일때 9까지 2페이지 일때 19 까지
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%' + keyWord + '%');
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
//				Board b = new Board();
//				b.setBoardNo(rset.getString("board_no"));
				list.add(new Board(rset.getString("board_no")
						, rset.getString("board_title")
						, rset.getString("mem_id")
						, rset.getInt("board_count")
						, rset.getString("create_date")
						, rset.getInt("count")
						));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	
//	public int countReply(Connection conn, String boardNo) {
//		
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		int countReply = 0;
//		
//		String sql = prop.getProperty("countReply");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, boardNo);
//			
//			rset=pstmt.executeQuery();
//			
//			if(rset.next()) {
//				countReply = rset.getInt("count");
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			close(rset);
//			close(pstmt);
//		}
//		return countReply;
//	}
	
	public int insertBoard(Connection conn, Board b) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
//			b.getBoardNo().substring(0, 1);
//			if(b.getBoardCategory().equals("F")) {
			if(b.getBoardNo().equals("F")) {
				pstmt.setString(1, "F");
				
			}else {
				pstmt.setString(1, "N");
				
			}
			pstmt.setString(2, b.getBoardTitle());
			pstmt.setString(3, b.getWriter());
			pstmt.setString(4, b.getBoardContent());
//			pstmt.setString(5, b.getBoardCategory());
			pstmt.setString(5, b.getBoardup());
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public int insertFile(Connection conn, ArrayList<File> list, Board b) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertFile");
		
		try {
			for(File f:list) {
				System.out.println(f+"제발제발제발");
			
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, f.getOriginName());
				pstmt.setString(2, f.getChangeName());
				pstmt.setString(3, f.getFilePath());
				pstmt.setString(4, b.getBoardNo());
				result = pstmt.executeUpdate();
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	
	}
	
	public String returnBoardNo(Connection conn) {
		
		PreparedStatement pstmt = null;
		String boardNo = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("returnBoardNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			System.out.println(rset);
			if(rset.next()) {
				boardNo = rset.getString("board_no");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return boardNo;
		
	}
	
	public int insertHash(Connection conn, HashTag ht) {
		
		PreparedStatement pstmt = null;
		int result = 0;
	
		String sql = prop.getProperty("insertHash");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ht.getCategoryNo());
			pstmt.setString(2, ht.getHashTagName());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	public int updateHash(Connection conn, HashTag ht) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("updateHash");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ht.getHashTagName());
			pstmt.setString(2, ht.getCategoryNo());
			System.out.println("여기까지오냐"+ ht.getHashTagName()+ ht.getCategoryNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public int increaseCount(Connection conn, String bno) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public Board selectBoard(Connection conn, String bno) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBoard");
		
		Board b = new Board();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno.substring(0));
			rset = pstmt.executeQuery();
			System.out.println("DAO에서의 bno : " + bno.substring(0));
			if(rset.next()) {
				b.setBoardNo(rset.getString("board_no"));
				b.setBoardTitle(rset.getString("board_title"));
				b.setWriter(rset.getString("mem_id"));
				b.setBoardContent(rset.getString("board_content"));
				b.setBoardCount(rset.getInt("board_count"));
				b.setCreateDate(rset.getString("create_date"));
				b.setHashTagName(rset.getString("hashtag_name"));
				b.setCountReply(rset.getInt("count"));
				b.setReportWriter(rset.getString("WRITER"));
				b.setBoardup(rset.getString("board_up"));
				
			}
			System.out.println(b + "진짜어이가없네");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return b;
	}
	
	public ArrayList<File> selectFileList(Connection conn, String bno) {
		
		ArrayList<File> list = new ArrayList<File>();
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
				
		String sql = prop.getProperty("selectFileList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				File f = new File();
				f.setChangeName(rset.getString("change_name"));
				f.setFilePath(rset.getString("file_path"));
				list.add(f);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Reply> selectReplyList(Connection conn, String boardNo){
		
		ArrayList<Reply> rlist = new ArrayList<Reply>();
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		String sql = prop.getProperty("selectReplyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			rset=pstmt.executeQuery();
			
			
			while(rset.next()) {
				rlist.add(new Reply(
									rset.getString("RE_NO")
								  , rset.getString("RE_WRITER")
								  , rset.getString("RE_REF_NO")
								  , rset.getString("RE_CONTENT")
								  , rset.getInt("RE_LIKE_STAR")
								  , rset.getString("RE_DATE")
								  , rset.getString("RE_STATUS")
								  , rset.getString("NICKNAME")
								  ));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return rlist;
		
	}
	
	public int insertReply(Connection conn, Reply r) {
		
		PreparedStatement pstmt = null;
		
		int result = 0 ;
		
		String sql = prop.getProperty("insertReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getBoardNo());
			pstmt.setString(2, r.getReplyWriter());
			pstmt.setString(3, r.getReplyContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
//	public int minBo(Connection conn) {
//		
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		int minBo = 0;
//		
//		String sql = prop.getProperty("minBo");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			rset = pstmt.executeQuery();
//			if(rset.next()) {
//				minBo = rset.getInt("minbo");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			close(rset);
//			close(pstmt);
//		}
//		return minBo;
//	}
//	public int maxBo(Connection conn) {
//		
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		int maxBo = 0;
//		
//		String sql = prop.getProperty("maxBo");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			rset = pstmt.executeQuery();
//			if(rset.next()) {
//				maxBo = rset.getInt("maxbo");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			close(rset);
//			close(pstmt);
//		}
//		return maxBo;
//	}
	
	public PrevNextPage prevNextBo(Connection conn, int bno) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		PrevNextPage p = new PrevNextPage();
		
		String sql = prop.getProperty("prevNextBo");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				p.setCurrentPage(bno);
				p.setNextPage(rset.getInt("next"));
				p.setPrevPage(rset.getInt("prev"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			
		}
		return p;
		
	}
	
	public ArrayList<Board> selectAllList(Connection conn){
		
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
//				Board b = new Board();
//				b.setBoardNo(rset.getString("board_no"));
				list.add(new Board(rset.getString("board_no")
								 , rset.getString("board_title")
								 , rset.getString("mem_id")
								 , rset.getInt("board_count")
								 , rset.getString("create_date")
								 , rset.getInt("count")
								 ));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int deleteBoard(Connection conn, String BoardNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, BoardNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public ArrayList<Board> myBoardSelect(Connection conn,String memNo){
		ArrayList<Board> blist = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("myBoardSelect");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				blist.add(new Board(rset.getString("BOARD_NO"),
						            rset.getString("BOARD_TITLE"),
						            rset.getString("BOARD_CONTENT"),
						            rset.getString("CREATE_DATE"),
						            rset.getInt("BOARD_COUNT"),
						            rset.getString("BOARD_IMG"),
						            rset.getString("HASHTAG_NAME")
						            ));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return blist;
	}
	
	public ArrayList<File> selectAttachmentList(Connection conn, String boardNo){
		PreparedStatement pstmt = null;
		ArrayList<File> list = new ArrayList<File>();
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAttachmentList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				File f = new File();
				f.setFileNo(rset.getString("file_no"));
				f.setOriginName(rset.getString("origin_name"));
				f.setChangeName(rset.getString("change_name"));
				f.setFilePath(rset.getString("file_path"));
				
				list.add(f);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return list;
	}
	
	public HashTag selectHashTag(Connection conn, String boardNo) {
		PreparedStatement pstmt = null;
		HashTag htag = new HashTag();
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectHashTag");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				htag.setCategoryNo(rset.getString("place_no"));
				htag.setHashTagName(rset.getString("hashtag_name"));				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return htag;
		
		
	}
	
	public int updateBoard(Connection conn, Board b) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setString(3, b.getBoardup());
			pstmt.setString(4, b.getBoardNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
		
	}
	
	public int deleteReply(Connection conn, String rpNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rpNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
		
	}
	
	public int updateFile(Connection conn, File f) {
		
		PreparedStatement pstmt = null;
		int result = 1;
		String sql = prop.getProperty("updateFile");
		try {
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, f.getFileNo());
				pstmt.setString(2, f.getOriginName());
				pstmt.setString(3, f.getChangeName());
				pstmt.setString(4, f.getFilePath());
				pstmt.setString(5, f.getFileNo());

				result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public int updateFileStatus(Connection conn, File f) {
		
		PreparedStatement pstmt = null;
		int result = 1;
		String sql = prop.getProperty("updateFileStatus");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "N");

			pstmt.setString(2, f.getFileNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	
//	public File selectFile(Connection conn, String fileNo) {
//		
//		PreparedStatement pstmt = null;
//		File f = new File();
//		String sql = prop.getProperty("selectFile");
//		ResultSet rset = null;
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, fileNo);
//			
//			rset = pstmt.executeQuery();
//			if(rset.next()) {
//				f.setOriginName(rset.getString("ORIGIN_NAME"));
//				f.setChangeName(rset.getString("CHANGE_NAME"));
//				f.setFilePath(rset.getString("FILE_PATH"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			close(conn);
//		}
//		return f;
//		
//		
//		
//	}
	
	public int insertFile2(Connection conn, File f, String boardNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertFile2");
		
		try {
		
				System.out.println(f+"제발제발제발");
			
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, f.getOriginName());
				pstmt.setString(2, f.getChangeName());
				pstmt.setString(3, f.getFilePath());
				pstmt.setString(4, boardNo);
				result = pstmt.executeUpdate();
				
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	
	}
	
	public int replyLikeUp(Connection conn,String rpno,String loginMem) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("replyLikeUp");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginMem);
			pstmt.setString(2, rpno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	public int replyLikeDown(Connection conn,String rpno,String loginMem) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("replyLikeDown");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginMem);
			pstmt.setString(2, rpno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public int replyLikeCount(Connection conn, String rpno) {
		PreparedStatement pstmt = null;
		int replyLikeCount = 0;
		ResultSet rset = null;
		String sql = prop.getProperty("replyLikeCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rpno);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				replyLikeCount = Integer.parseInt(rset.getString("count"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return replyLikeCount;
	}
	
	public int updateReplyCount(Connection conn, String rpno) {
		PreparedStatement pstmt = null;
		int replyLikeCount = 0;
		String sql = prop.getProperty("updateReplyCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rpno);
			pstmt.setString(2, rpno);
			
			replyLikeCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return replyLikeCount;
	}

//	public int replyLikeCount(Connection conn, String rpno) {	// tb_like에서 가져오기
//		PreparedStatement pstmt = null;
//		int replyLikeCount = 0;
//		ResultSet rset = null;
//		String sql = prop.getProperty("replyLikeCount");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, rpno);
//			rset = pstmt.executeQuery();
//			
//			if(rset.next()) {
//				replyLikeCount = Integer.parseInt(rset.getString("count"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			close(rset);
//			close(pstmt);
//		}
//		return replyLikeCount;
//	}
	
//	public int updateLike(Connection conn, String loginMem, String rpno) {
//		
//		PreparedStatement pstmt = null;
//		int result = 0;
//		String sql = prop.getProperty("updateLike");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, loginMem);
//			pstmt.setString(2, rpno);
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			close(pstmt);
//		}
//		return result;
//		
//	
//	}
//	public int deleteLike(Connection conn, String loginMem, String rpno) {
//		
//		PreparedStatement pstmt = null;
//		int result = 0;
//		String sql = prop.getProperty("deleteLike");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, loginMem);
//			pstmt.setString(2, rpno);
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			close(pstmt);
//		}
//		return result;
//		
//		
//	}
	
	public ArrayList selectLikeList(Connection conn, String mno) {
		PreparedStatement pstmt = null;
		ArrayList lList = new ArrayList();
		ResultSet rset = null;
		String sql = prop.getProperty("selectLikeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mno);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				String s = rset.getString("likeno");
				lList.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return lList;
	}
	

	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
