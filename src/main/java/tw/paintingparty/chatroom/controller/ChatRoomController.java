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
import tw.paintingparty.chatroom.model.ChatRoomDAO;
import tw.paintingparty.chatroom.model.MyChatConnBean;
import tw.paintingparty.model.ChatConn;
import tw.paintingparty.model.Member;
import tw.paintingparty.service.MemberService;

@Controller
public class ChatRoomController {
	
	@Autowired
	private MemberService mService;
	
	@Autowired
	private ChatRoomDAO crDao;
	
	@GetMapping(path = "/backend/chatroom") 
	public String ChatRoom(Model m) {
		Member mem1 = mService.showLoginUsername();

		m.addAttribute("member_name", mem1.getMember_name());
		
		return "ChatRoom" ;
	}
	
	
	@PostMapping(path = "/backend/chatconnlist") 
	@ResponseBody
	public List<MyChatConnBean> ChatConnList( HttpServletRequest request ) { //得到我與誰連接
		
		
		Object myid = request.getSession().getAttribute("session_member_id");
		List<MyChatConnBean> selectAllMyConn = crDao.selectAllMyConn( (Integer)myid );
		
		return selectAllMyConn ;
	}
	
	
	//----------
	
	//下載大頭照的URL:/backend/headshotdownloader/{memid}，在CASEMANAGE的控制器
	
	//----------
	

}
