package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//Week10
public class XMLHelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		// / view / week10 / hello.jsp
		mav.setViewName("week10/hello"); // view 이름을 'hello' 로 지정
		mav.addObject("greeting", "좋은 오후 입니다."); //'greeting' 이름에 값을 지정 (View에서 해당 명으로 값 전달)
		return mav;
	}
	

}
