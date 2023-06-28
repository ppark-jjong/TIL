package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerEx {
	// week 10
	@RequestMapping("/AnnotationMVC")
	public ModelAndView hello(HttpServletRequest request) {
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext(),
				FrameworkServlet.SERVLET_CONTEXT_PREFIX + "dispatcher");
		String greeting = (String)context.getBean("getGreeting");
		ModelAndView mav = new ModelAndView();
		mav.addObject("greeting", greeting);
		mav.setViewName("week10/hello");
		return mav;

	}
}
