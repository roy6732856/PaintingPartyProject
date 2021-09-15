package tw.paintingparty.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.paintingparty.model.Member;
import tw.paintingparty.service.AccountManagerService;

@Controller
public class AccountManagerController {

	@Autowired
	private AccountManagerService accountManagerService;
	
	@RequestMapping(path="/backend/accountmanager", method=RequestMethod.GET)
	public String processAccountManager(HttpServletRequest request, Model m) {
		
		HttpSession session = request.getSession();
		int memOneId=(int) session.getAttribute("login");
		System.out.println("login="+memOneId);

		Member oneMem = accountManagerService.selectOne(memOneId);
		m.addAttribute("oneMemEmail", oneMem.getEmail());
		m.addAttribute("oneMenBank_account", oneMem.getBank_account());
		m.addAttribute("oneMemPixiv", oneMem.getPixiv());
		
		return "AccountManager";
	}
	
	@RequestMapping(path="/backend/accountmanagerchange", method=RequestMethod.POST)
	public String processAccountManagerChange(HttpServletRequest request, Model m) {
		
		HttpSession session = request.getSession();
		int memOneId=(int) session.getAttribute("login");
		
		System.out.println("login="+memOneId);
		
		String oneMemEmail=(String) request.getParameter("oneMemEmail");
		String oneMenBank_account=(String) request.getParameter("oneMenBank_account");
		String oneMemPixiv=(String) request.getParameter("oneMemPixiv");
		
		System.out.println(oneMemEmail+":"+oneMenBank_account+":"+oneMemPixiv);
		
<<<<<<< HEAD
		String result = accountManagerService.updateOne(memOneId, oneMemEmail, oneMenBank_account, oneMemPixiv);		
		System.out.println(result);
		
		m.addAttribute("oneMemEmail", oneMemEmail);
		m.addAttribute("oneMenBank_account", oneMenBank_account);
		m.addAttribute("oneMemPixiv", oneMemPixiv);
		
		return "AccountManager";
=======

		Member oneMem = accountManagerService.updateOne(memOneId, oneMemEmail, oneMenBank_account, oneMemPixiv);
		
		System.out.println("update");
		System.out.println(oneMem.getEmail()+":"+oneMem.getBank_account()+":"+oneMem.getPixiv());
		
		m.addAttribute("oneMemEmail", oneMem.getEmail());
		m.addAttribute("oneMenBank_account", oneMem.getBank_account());
		m.addAttribute("oneMemPixiv", oneMem.getPixiv());
		
		System.out.println("update2");
		System.out.println(m.getAttribute("oneMemEmail")+":"+m.getAttribute("oneMenBank_account")+":"+m.getAttribute("oneMemPixiv"));
		
		return "TestResponse";
>>>>>>> 4ae3bdb1b74598cec010cc2f96a6e4d52729f866
	}
	
	
}
