package kr.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardWriteController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// BoardWriteController는 BoardWrite.jsp로 이동 시켜주는 역할
		// 코드작성 필요X
		// return 값만 작성
		return "BoardWrite";
	}

}
