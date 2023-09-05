package kr.board.frontController;

import java.util.HashMap;

import kr.board.controller.BoardDeleteController;
import kr.board.controller.BoardDetailController;
import kr.board.controller.BoardInsertController;
import kr.board.controller.BoardListController;
import kr.board.controller.BoardWriteController;
import kr.board.controller.Controller;

public class HandlerMapping {

	
	// HandlerMapping : FrontController 에게 어떤 POJO를 호출해야하는지 알려주는 역할
	
	// boardList.do -> BoardListController
	// boardInsert.do -> BoardInsertController
	
	// 검색이 빠른 자료구조인 HashMap 사용
	// HashMap : Key(String) & Value(Controller)
	// key : 요청이 들어온 주소 값
	// value : POJO를 통합할 수 있는 Controller(인터페이스)
	
	private HashMap<String, Controller> mappings;
	
	// 생성자 만들기 -> 객체가 생성 될 때 key, value를 등록하기 위한 생성자
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
	
		mappings.put("boardList.do", new BoardListController());
		mappings.put("boardWrite.do", new BoardWriteController());
		mappings.put("boardInsert.do", new BoardInsertController());
		mappings.put("boardDetail.do", new BoardDetailController());
		mappings.put("boardDelete.do", new BoardDeleteController());
	};
	
	// value 값을 FrontController 에게 return해줄 메소드
	public Controller getController(String result) {
	
		// HashMap에서 get메소드 : 해당 key의 value값을 호출하는 메소드
		// boardList.do -> BoardListController()
		return mappings.get(result);
	}


}
