package kr.board.model;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.board.db.SqlSessionManager;

public class BoardDAO {

	
	private SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	
	// 게시글 전체를 가지고 오는 메소드
	public ArrayList<BoardDTO> getBoard() {
	
		SqlSession session = sqlSessionFactory.openSession(true);		
		ArrayList<BoardDTO> list =(ArrayList)session.selectList("getBoard");
		session.close();
		
		return list;
				
	}
	
	// 게시글 등록 메소드
	public int insertBoard(BoardDTO dto) {
		
		SqlSession session = sqlSessionFactory.openSession(true);
		
		int row = session.insert("insertBoard", dto);
		session.close();
		
		return row;
	}
	// 게시글 하나를 가지고 오는 메소드
	public BoardDTO getBoardDetail(int num) {
		
		SqlSession session = sqlSessionFactory.openSession(true);	
		BoardDTO dto = session.selectOne("getBoardDetail", num);		
		session.close();
		
		return dto;
	}
	
	
	// 게시글 하나 삭제하는 메소드 /-> 삭제 되었는지 확인하는 절차 없이 리턴없는 void로도 가능
	public void deleteBoard(int num) {
		
		SqlSession session = sqlSessionFactory.openSession(true);
		
		session.delete("deleteBoard", num);
		session.close();
		
		
	}
	
}
