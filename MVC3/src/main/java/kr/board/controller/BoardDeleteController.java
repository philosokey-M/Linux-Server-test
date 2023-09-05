package kr.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.model.BoardDAO;
import kr.board.model.BoardDTO;

public class BoardDeleteController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("---delete 컨트롤러---");
		
		
		
		
		// 사용자가 입력한 값 받아오기
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("num : "+num);


				
		new BoardDAO().deleteBoard(num);
		

		
		// Insert를 하고나서 boardMain으로 바로 가게 되면 request에 데이터가 없기 때문에 
		// 빈화면만 보여진다. 따라서 boardList를 가지고 오는 Controller인
		// boardListController를 실행(호출) 위해서 boardList.do를 요청
		return "redirect:/boardList.do";	
		

	}

}
