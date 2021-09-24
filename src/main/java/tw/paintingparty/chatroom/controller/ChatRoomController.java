package tw.paintingparty.chatroom.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.paintingparty.casemanage.model.MyPostedAllCasesBean;
import tw.paintingparty.chatroom.model.ChatRoomDAO;
import tw.paintingparty.chatroom.model.MeAndWhoChatHistoryBean;
import tw.paintingparty.chatroom.model.MyChatConnBean;
import tw.paintingparty.model.ChatConn;
import tw.paintingparty.model.Member;
import tw.paintingparty.service.MemberService;
import tw.teamUtil.Util01;

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
	
	
	@GetMapping(path = "/backend/gotochat/{toid}") //按下思訓，建立連結
	public void GoToChat( @PathVariable("toid") Integer toid , HttpServletRequest request , HttpServletResponse response) throws IOException, ParseException {
		
		Util01 util01 = new Util01();
		Member mem1 = mService.showLoginUsername();
		Object myid = request.getSession().getAttribute("session_member_id");
		util01.insertNewConnToDBToMe( (Integer) myid, toid);
		
		

		response.sendRedirect( request.getContextPath() + "/backend/chatroom");
		
	}
	
	
	@PostMapping(path = "/backend/chatconnlist") 
	@ResponseBody
	public List<MyChatConnBean> ChatConnList( HttpServletRequest request ) { //得到我與誰連接
		
		
		Object myid = request.getSession().getAttribute("session_member_id");
		List<MyChatConnBean> selectAllMyConn = crDao.selectAllMyConn( (Integer)myid );
		
		return selectAllMyConn ;
	}
	
	
	@PostMapping(path = "/backend/chathistory/{toid}") 
	@ResponseBody
	public List<MeAndWhoChatHistoryBean> ChatHistory( @PathVariable("toid") Integer toid , HttpServletRequest request ) { //得到我與那個連接者的歷史訊息
		
		Object myid = request.getSession().getAttribute("session_member_id");
		
		List<MeAndWhoChatHistoryBean> selectChatHistory = crDao.selectChatHistory( (Integer)myid , toid );
		
		return selectChatHistory ;
	}
	
	
	//----------
	
	//下載大頭照的URL:/backend/headshotdownloader/{memid}，在CASEMANAGE的控制器
	
	//----------
	

}
