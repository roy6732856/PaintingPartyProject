package tw.paintingparty.painterlist.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.paintingparty.model.Cases;
import tw.paintingparty.model.Member;
import tw.paintingparty.painterlist.model.PainterListDAO;
import tw.paintingparty.painterlist.service.PainterListPageService;
import tw.paintingparty.painterlist.service.PainterListService;


@Controller
public class PainterListController {
	
	@Autowired
	private PainterListService plService;
	
	@Autowired
	private PainterListPageService plpService;
	
	@Autowired
	private PainterListDAO painterListDAO;
	
	@RequestMapping(path = "/painterlist", method = RequestMethod.GET)
	public String painterListAction(Model m) {

		Long Member = plpService.TotalPage();
		
		Long totalPages;
		
		if(Member%8==0) {
			Long total = (Member/8);
			totalPages = total;
		}else {
			Long total = (Member/8)+1;
			totalPages = total;
		}
		
		
		m.addAttribute("totalCases",Member);
		m.addAttribute("totalPages",totalPages);
		
		
		return "PainterList";
	}
	
	@RequestMapping(path = "/FindAll",method = RequestMethod.POST)
	@ResponseBody
	public List<Member> processFildAllMemberAction() {
		
		return plService.FindAll();
		
	
	}
	
	@RequestMapping(path ="/queryByPage/{pageNo}",method = RequestMethod.POST)
	@ResponseBody
	public List<Member> processQueryAllPages(@PathVariable("pageNo")int pageNo){
		
		return plpService.QueryByPage(pageNo-1);
				
	}
	
	@RequestMapping(path="/painterimage", method = RequestMethod.GET)
	//畫師照片顯示
	public void prosessPainterImgById(HttpServletRequest request, HttpServletResponse response, Model m) throws IOException {
		HttpSession session = request.getSession();
		int memOneId=(int) session.getAttribute("login");

		Member oneMem = plService.selectOne(memOneId);	
	//	m.addAttribute("member_id", oneMem.getMember_id());
	//	m.addAttribute("Profile_pic_path", oneMem.getProfile_pic_path());
		String profilePicPath=oneMem.getProfile_pic_path();
		String profilePic=oneMem.getProfile_pic();		
		String imagePath=profilePicPath+"\\"+profilePic;
		
		InputStream in = new FileInputStream(new File(imagePath));
		IOUtils.copy(in, response.getOutputStream());
	}
	
	@RequestMapping("search")
	@ResponseBody
	//具體方法
	public   List<Member> getSearchResourcesProfiles(HttpServletRequest request) {
	     
	         String searchValue1 = request.getParameter("Select1");
	         String searchValue2 = request.getParameter("Select2");
	         
		 List<Member> lstMember = painterListDAO.search("1" , "2");
		 System.out.println("lstMember.size() => "+ lstMember.size());
		 System.out.println("lstMember[0] => "+ lstMember.get(0).getMember_name());

		 
	         return lstMember;
	}
}

