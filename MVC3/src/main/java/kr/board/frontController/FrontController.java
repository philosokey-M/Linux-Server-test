package kr.board.frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.controller.Controller;


public class FrontController extends HttpServlet {



	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 1-1 요청이 들어온 주소확인
		String reqURI = request.getRequestURI();
		System.out.println("URI: "+reqURI);		
		
		String reqQuery =request.getQueryString();
		System.out.println("쿼리스트링: "+reqQuery);	
		
		// 1-2 반복되는 contextPath 찾기
		String contextPath = request.getContextPath();
		System.out.println("contextPath: "+contextPath);		
		//con -> BoardListController
		
		// 1-3 잘라내서 요청값만 확인(변수명 : result) 
		String result = reqURI.substring(contextPath.length()+1);
		System.out.println(result);
		
		// 2.Handler Mapping에게 어떤 POJO(은행창구)를 호출시켜야하는지 물어보기
		HandlerMapping mappings = new HandlerMapping();
		Controller con = mappings.getController(result); // result : 요청들어온 주소값
		System.out.println(con);
		// 3. 해당 POJO 실행시키기 -> 이동해야할 viewname을 반환
		String moveURL = con.requestHandler(request, response);
		// boardMain(미완성)
		System.out.println(moveURL);
		System.out.println("-------------");
		
		
		// 5. 페이지 이동
		// jsp로 이동 -> forward 방식 사용
		// controller(POJO)로 이동 -> redirect방식 사용
		if(moveURL !=null) {
			
			// 5-1. POJO로 이동할 때 
			if(moveURL.contains(":/")) {
				response.sendRedirect(moveURL.split(":/")[1]); 
				// redirect:/boardList.do <- 원래 moveURL은 이런 모양
				// split(기호) : 기호를 기준으로 나눠서 배열로 반환
				// 항상 뒤에있는 1번째 문자로 페이지 요청			
			}
			// 5-2. jsp로 이동할 때  			
			else {
				
				// 4. ViewResolver 통해서 viewname 완성
				// static영역에 있을 땐 객체 생성하지 않아도 사용 가능
				moveURL =ViewResolver.makeViewName(moveURL);
				// WEB-INF/views/BoardMain.jsp
				System.out.println(moveURL);
				
				RequestDispatcher rd = request.getRequestDispatcher(moveURL);
				rd.forward(request, response);	


			}
			
		}
		
		
		
	}

}
