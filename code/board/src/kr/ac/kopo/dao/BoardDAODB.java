package kr.ac.kopo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;
/**
 * 
 * 
 * DB로 게시물을 관리하는 DAO
 * @author HP
 *
 */
import kr.ac.kopo.vo.BoardVO;

public class BoardDAODB {
	
	/**
	 * 전체 게시글 조회
	 * @return
	 * @throws Exception
	 */
	public List<BoardVO> 전체게시글조회() throws Exception {
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
			sql.append(" from tbl_board  ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String regDate = rs.getString("reg_date");
				
				BoardVO vo = new BoardVO(no, title, writer, regDate);
				list.add(vo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return list;
	}
	
	/**
	 * 글번호로 게시글 조회
	 * @param no
	 * @return
	 * @throws Exception
	 */
	public BoardVO 글번호조회(int no) throws Exception {
		return null;
	}
	
	/**
	 * 새글 등록
	 * @param newBoard
	 */
	public void 새글등록(BoardVO newBoard) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("insert into tbl_board(no, title, writer) ");
			sql.append("values(seq_tbl_board_no.nextval, ?, ?) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, newBoard.getTitle());
			pstmt.setString(2, newBoard.getWriter());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}
	
	/**
	 * 게시글 수정
	 * @param board : 제목과 글번호만 수정하면 되지만, 
	 * 만약 수정할 항목이 늘어날 경우에 대비해서 유연하게 코드를 짜기 위해 매개변수를 BoardVO로 잡은 것이다.
	 */
	public void 게시글수정(BoardVO board) { 
	}
	
	/**
	 * 게시물 삭제
	 * @param no
	 */
	public void 게시글삭제(int no) {
	}
}
