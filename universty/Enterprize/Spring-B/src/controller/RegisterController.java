package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import week11.RegisterRequest;

@Controller
//week11 RegisterRequest at Dao or javaClass
public class RegisterController {

	@RequestMapping("/step1")
	public String handleStep1(@RequestParam("path") String path, @RequestParam("view") String view) {
		String viewName = path + "/" + view;
		return viewName;
		// return "week11/registerStep1";
	}

	@RequestMapping(value = "/step2", method = RequestMethod.POST)
	public String handleStep2(@RequestParam("path") String path, @RequestParam("view") String view,
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model) {
		String viewName;
		// value = agree 에서 요청 속 param 값을 받지 못하면 false값을 리턴한다 따라서 if문 false타입에 걸려
		// return문을 다르게 받는다
		if (!agree) {
			viewName = path + "/" + view + "1";
			return viewName;
		}
		model.addAttribute("registerRequest", new RegisterRequest());
		viewName = path + "/" + view + "2";
		return viewName;
		// return "week11/registerStep2";
	}

	private boolean errorFlag = false;

	@PostMapping("/step3")
	public String handleStep3(@ModelAttribute("registerRequest") RegisterRequest regReq, Errors errors) {
		String viewName;
		viewName = regReq.getPath() + "/" + regReq.getView();

		if (!errorFlag) {
			return viewName += "3";
		}
		return viewName += "3";
	}

	@ModelAttribute("registerRequest")
	public RegisterRequest initCommand(HttpServletRequest Request) {
		RegisterRequest cm = new RegisterRequest();
		cm.setName("한글을 입력해주세요");
		return cm;
	}

	@RequestMapping(value = "/initCommand", method = RequestMethod.GET)
	public String initForm() {
		return "week11/registerStep2";
	}
}
