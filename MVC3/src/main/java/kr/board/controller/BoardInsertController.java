package kr.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.model.BoardDAO;
import kr.board.model.BoardDTO;

public class BoardInsertController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// BoardInsertController : DB에 사용자가 입력한 게시물 내용 insert
		
		// post 방식 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 사용자가 입력한 값 받아오기
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		System.out.println(title);
		System.out.println(writer);
		System.out.println(content);

		//BoardDTO로 묶기
		BoardDTO dto = new BoardDTO(0, title, writer, null, content, null);
		
		int row = new BoardDAO().insertBoard(dto);
		
		if(row>0) {
			System.out.println("insert성공");
		}else {
			System.out.println("insert실패");
		}
		
		// Insert를 하고나서 boardMain으로 바로 가게 되면 request에 데이터가 없기 때문에 
		// 빈화면만 보여진다. 따라서 boardList를 가지고 오는 Controller인
		// boardListController를 실행(호출) 위해서 boardList.do를 요청
		return "redirect:/boardList.do";
	}

}
