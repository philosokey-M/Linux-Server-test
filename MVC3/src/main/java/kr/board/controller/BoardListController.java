package kr.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.model.BoardDAO;
import kr.board.model.BoardDTO;

public class BoardListController implements Controller {

	@Override
	// JSPServlet 시간의 execute메소드와 같은 역할
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1. DB에서 데이터 가져오기
		ArrayList<BoardDTO> list = new BoardDAO().getBoard();
		
		//2. View에서 불러오기 위해 request객체에 객체바인딩
		request.setAttribute("boardList", list);
		
		// 3. BoardMain으로 가기위해 viewname 반환		
		return "BoardMain";
		
	}

}
