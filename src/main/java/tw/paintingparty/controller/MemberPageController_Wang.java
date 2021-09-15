package tw.paintingparty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.paintingparty.model.Member;
import tw.paintingparty.service.MemberService;

@Controller
public class MemberPageController_Wang {
	
	@Autowired
	private MemberService mService;
	
//	@RequestMapping(path="/painterlist")
//	public String xxx() {
//		return "PainterList";
//	}
	
	@RequestMapping(path="/memberpage2")
	public String processMemberPage(Model m ) {
		Member mem1 = mService.showLoginUsername();
		m.addAttribute("member_name", mem1.getMember_name());
		return "MemberPage";
	}
}
