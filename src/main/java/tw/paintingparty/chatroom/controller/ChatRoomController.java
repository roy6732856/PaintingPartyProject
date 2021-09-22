package tw.paintingparty.chatroom.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.paintingparty.casemanage.model.MyPostedAllCasesBean;
import tw.paintingparty.model.Member;
import tw.paintingparty.service.MemberService;

@Controller
public class ChatRoomController {
	
	@Autowired
	private MemberService mService;
	
	
	@GetMapping(path = "/backend/chatroom") 
	public String ChatRoom(Model m) {
		Member mem1 = mService.showLoginUsername();

		m.addAttribute("member_name", mem1.getMember_name());
		
		return "ChatRoom" ;
	}

}
