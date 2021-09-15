package tw.paintingparty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberPageController {
	
	@RequestMapping(path="/painterlist")
	public String xxx() {
		return "PainterList";
	}
	
	@RequestMapping(path="/memberpage")
	public String processMemberPage() {
		return "MemberPage";
	}
}
