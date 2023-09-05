package kr.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.model.BoardDAO;
import kr.board.model.BoardDTO;

public class BoardDetailController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("---보드디테일 컨트롤러---");
		
		// 게시글 고유번호 num 받아오기
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("num : "+num);
		
		//1. DB에서 데이터 가져오기
		BoardDTO dto = new BoardDAO().getBoardDetail(num);
		
		//2. View에서 불러오기 위해 request객체에 객체바인딩
		request.setAttribute("boarddto", dto);
		
		// 3. BoardMain으로 가기위해 viewname 반환		
		return "BoardDetail";
		
		
		
	}

}
