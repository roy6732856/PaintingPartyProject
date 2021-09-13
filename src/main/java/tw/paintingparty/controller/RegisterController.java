package tw.paintingparty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class RegisterController {
	@RequestMapping(path="register")
	public String processRegister() {
		return "/register";
	}
}
