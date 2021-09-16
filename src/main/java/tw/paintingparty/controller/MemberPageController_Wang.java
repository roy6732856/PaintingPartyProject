package tw.paintingparty.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.paintingparty.model.Member;
import tw.paintingparty.model.PainterTag;
import tw.paintingparty.service.MemberService;

@Controller
public class MemberPageController_Wang {
	
	@Autowired
	private MemberService mService;
	
//	@RequestMapping(path="/painterlist")
//	public String xxx() {
//		return "PainterList";
//	}
	
	@RequestMapping(path="/memberpage/{id}")
	public String Memberpage(@PathVariable("id") int memberId,Model m) {
		//this for 右上角username
		Member mem1 = mService.showLoginUsername();
		m.addAttribute("member_name", mem1.getMember_name());
		
		//有可能我登入a帳號, 但拜訪b帳號的memberpage
		m.addAttribute("member_id",memberId ); //這是url傳送過來的id,for 讀取大頭貼
		Member memberForVisited = mService.SelectMemberById(memberId);
		String member_name = memberForVisited.getMember_name();
		
		List<PainterTag> tagId = mService.selectTagIdByMemberId(memberId);
		for(int i=0;i<tagId.size();i++) {
			PainterTag painterTag=tagId.get(i);
			String tag_content = painterTag.getTagbean().getTag_content();
//			String x = "tag_content"+i;
//			Map<K, V> map = new HashMap<K, V>();
			m.addAttribute("tag_content"+i, tag_content);
		}
		m.addAttribute("tagIdSize", tagId.size());
//		PainterTag painterTag = tagId.get(2);
		
		
		
		return "MemberPage";
		
	}
	
	
	@RequestMapping(path="/memberpageshowpic/{id}") 
	//從painterlist.和CasePage.和casemanage.jsp,傳來的id
	
	public void memberPageShowpic(@PathVariable("id") int memberId,Model m,HttpServletResponse response) throws IOException {

		
		//抓會員大頭貼
		Member mem1 = mService.SelectMemberById(memberId);
		String profile_pic_path = mem1.getProfile_pic_path();
		String profile_pic = mem1.getProfile_pic();
		String imagePath=profile_pic_path+"\\"+profile_pic;
//		m.addAttribute("imagePath", imagePath);
		
		FileInputStream in = new FileInputStream(new File(imagePath));
		IOUtils.copy(in, response.getOutputStream());
		
//		return "MemberPage";
	}
}
