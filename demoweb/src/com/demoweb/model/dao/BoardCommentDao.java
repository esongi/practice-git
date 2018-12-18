package com.demoweb.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.demoweb.model.dto.Board;
import com.demoweb.model.dto.BoardComment;

public class BoardCommentDao {
	
	
	public ArrayList<BoardComment> getBoardList(int start, int last) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;//조회 결과에 접근하는 참조 변수
		//데이터베이스의 데이터를 읽어서 저장할 객체 컬렉션
		ArrayList<BoardComment> comments  = new ArrayList<BoardComment>();
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			StringBuffer sql = new StringBuffer(500);
			sql.append("SELECT * ");
			sql.append("FROM ");
			
			 sql.append("( ");
		      sql.append("    SELECT ");
		      sql.append("        rownum idx, s.* ");
		      sql.append("    FROM ");

		      sql.append("    ( ");
		      sql.append("        SELECT ");
		      sql.append("            commentno, boardno, writer, content, regdate ");
		      sql.append("        FROM ");
		      sql.append("            boardcomment ");
		      sql.append("    ) s ");
			
			sql.append(") ");
			
			sql.append("WHERE idx >= ? AND idx < ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, start);
			pstmt.setInt(2, last);
			rs = pstmt.executeQuery();			
			
			while (rs.next()) {
		        BoardComment boardComment = new BoardComment();
		        boardComment.setCommentNo(rs.getInt(2));
		        boardComment.setBoardNo(rs.getInt(3));
		        boardComment.setWriter(rs.getString(4));
		        boardComment.setContent(rs.getString(5));
		        boardComment.setRegDate(rs.getDate(6));
				
				comments.add(boardComment);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결닫기
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
		
		return comments;
	}
	//게시물 총 건수를 조회, 반환
	public int getBoardCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "SELECT COUNT(*) FROM board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				count = rs.getInt(1);
			
		} catch (Exception ex) {
			count = 0;
			ex.printStackTrace();			
		} finally {
			try { if (rs != null) rs.close(); } catch (Exception ex) { }
			try { if (pstmt != null) pstmt.close(); } catch (Exception ex) { }
			try { if (conn != null) conn.close(); } catch (Exception ex) { }
		}
		return count;
	}
	
	public Board getBoardByBoardNo(int number) {
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      Board board = null;
      
      try {
          conn = ConnectionHelper.getConnection("oracle");
          StringBuffer sql = new StringBuffer(300);
          sql.append("SELECT "); 
          sql.append("boardno, title, writer, content, ");
          sql.append("regdate, readcount, ");
          sql.append("deleted, groupno, step, depth ");
          sql.append("FROM board ");
          sql.append("WHERE boardno = ? AND deleted = '0'");
          pstmt = conn.prepareStatement(sql.toString());
          pstmt.setInt(1, number);
          rs = pstmt.executeQuery();
          if (rs.next()) {
              board = new Board();
              board.setBoardNo(rs.getInt(1));
              board.setTitle(rs.getString(2));
              board.setWriter(rs.getString(3));
              board.setContent(rs.getString(4));
              board.setRegDate(rs.getDate(5));
              board.setReadCount(rs.getInt(6));
              board.setDeleted(rs.getBoolean(7));
              board.setGroupNo(rs.getInt(8));
              board.setStep(rs.getInt(9));
              board.setDepth(rs.getInt(10));
          }           
      } catch (Exception ex) {
          ex.printStackTrace();
      } finally {
          try { if (rs != null) rs.close(); } catch (Exception ex) { }
          try { if (pstmt != null) pstmt.close(); } catch (Exception ex) { }
          try { if (conn != null) conn.close(); } catch (Exception ex) { }
      }
      return board;
  }

}

