package kr.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

	// POJO가 공통적으로 가지고 있어야하는 추상메소드 생성
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException;
	
	
	
	
	
}
