package tw.paintingparty.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.paintingparty.model.Member;
import tw.paintingparty.service.MemberService;
import tw.paintingparty.service.TestService;



@Controller
public class TestDemoController {
	
	@Autowired
	private TestService tService;
	@Autowired
	private MemberService mService;
	
	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public String test(Model m) {
		//皜祈岫��鞈�澈
//		Member mem1 = tService.test();
//		m.addAttribute("userid", mem1.getMember_id());
//		m.addAttribute("username", mem1.getMember_name());
		
		return "/login";
	}
	
	
//	@RequestMapping(path = "/test2", method = RequestMethod.GET)
//	//皜祈岫���������
//	public String test2(Model m) {
//		Member mem1 = mService.showLoginUsername();
//		m.addAttribute("member_name", mem1.getMember_name());
//		return "MemberPage";
//	}

	@RequestMapping(path = "/backend/test3", method = RequestMethod.GET)
	//皜祈岫敺�������
	public String test3(Model m) {
		Member mem1 = mService.showLoginUsername();
		m.addAttribute("member_name", mem1.getMember_name());
		return "CaseManage";
	}
	
	

}
