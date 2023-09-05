package kr.board.frontController;

public class ViewResolver {

	
	// ViewResolver : POJO가 반납한 Viewname 을 풀네임으로 만들어준 역할
	// BoardMain -> MVC3/WEB-INF/views/BoardMain.jsp
	
	// static을 붙이면 객체생성을 하지 않아도 불러올 수 있음!
	public static String makeViewName(String viewname) {
		
		
		return "WEB-INF/views/"+viewname+".jsp";
	}
	
	
}
