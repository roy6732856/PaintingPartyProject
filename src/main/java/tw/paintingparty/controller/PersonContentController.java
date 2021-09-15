package tw.paintingparty.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tw.paintingparty.model.Member;
import tw.paintingparty.service.PersonContentService;

@Controller
public class PersonContentController {

	@Autowired
	private PersonContentService personContentService;
	
	//初始頁面
	@RequestMapping(path="/backend/personcontent", method=RequestMethod.GET)
	public String processPersonContent(HttpServletRequest request, Model m) {
		
		HttpSession session = request.getSession();
		int memOneId=(int) session.getAttribute("login");
		System.out.println("login="+memOneId);

		Member oneMem = personContentService.selectOne(memOneId);
		if(oneMem.getMember_status().equals("畫師")!=true) {
			m.addAttribute("memberStatusName", "委託者");
		}else {
			m.addAttribute("memberStatusName", "畫師");
		}
		
		m.addAttribute("oneMemProfile_content", oneMem.getProfile_content());
//		m.addAttribute("memberStatusName", "委託者");
		
		System.out.println("oneMemProfile_content");
		System.out.println("oneMemProfile_content="+oneMem.getProfile_content());
		
		return "PersonContent";
	}
	
	//painter身分切換
	@RequestMapping(path="/backend/personcontentpainterchange", method=RequestMethod.GET)
	public String processPersonContentPainterChange(HttpServletRequest request, Model m) {
		
		HttpSession session = request.getSession();
		int memOneId=(int) session.getAttribute("login");
//		Member oneMem = personContentService.selectOne(memOneId);
		
		personContentService.updateOneMemberStatus(memOneId);
		Member oneMem = personContentService.selectOne(memOneId);
		
		if(oneMem.getMember_status().equals("畫師")!=true) {
			m.addAttribute("memberStatusName", "委託者");
		}else {
			m.addAttribute("memberStatusName", "畫師");
		}
		System.out.println("login="+memOneId);

		m.addAttribute("oneMemProfile_content", oneMem.getProfile_content());
		System.out.println("oneMemProfile_content");
		System.out.println("oneMemProfile_content="+oneMem.getProfile_content());
		
//		personContentService.updateOneMemberStatus(memOneId);
		System.out.println("畫師");
		
		return "PersonContent";
	}
			
	//圖檔上傳
	@RequestMapping(path="/backend/personcontentchange", method=RequestMethod.POST)
	public String processPersonContentChange(@RequestParam("headShot") MultipartFile mf, @ModelAttribute("oneMemProfile_content") String oneMemProfile_content,HttpServletRequest request, Model m) throws IOException {
		
		//取得連線與JavaBean
		HttpSession session = request.getSession();
		int memOneId=(int) session.getAttribute("login");
		Member oneMem = personContentService.selectOne(memOneId);
		
		//判斷身分
		if(oneMem.getMember_status().equals("畫師")!=true) {
			m.addAttribute("memberStatusName", "委託者");
		}else {
			m.addAttribute("memberStatusName", "畫師");
		}

		//取得old大頭貼存檔路徑與檔案
		String odirPath = oneMem.getProfile_pic_path();
		String oFileName= oneMem.getProfile_pic();
		String ofilePath=odirPath+"\\"+oFileName;
		
		//日期轉換成字串
		Date date = new Date();
	    DateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmmss");
	    String dateString = dateformat.format(date).toString();
	    
	    //定義存放路徑與檔案名稱並存檔
	    String fileName = mf.getOriginalFilename();
	    String dirPath="C:\\PaintingImg\\HeadShot";
	    String updateFileName=dateString+fileName;
		String filePath=dirPath+"\\"+updateFileName;
		File imageHeadShot = new File(filePath);		
		mf.transferTo(imageHeadShot);
		
		//將存放路徑與檔案名稱update至資料庫
		personContentService.updateOneProfilePic(memOneId, updateFileName);
		personContentService.updateOneProfilePicPath(memOneId, dirPath);
		
		//刪除資料夾舊檔		
		File oimageHeadShot = new File(ofilePath);
		oimageHeadShot.delete();
		
        //自我簡介變動	
		personContentService.updateOneProfileContent(memOneId, oneMemProfile_content);
		m.addAttribute("oneProfile_content", oneMemProfile_content);
		
		return "PersonContent";
	}
	
	//抓取圖檔與圖檔顯示
	@RequestMapping(path="/backend/personcontentpersoncontentimage", method = RequestMethod.GET)
	public void processResponseImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		int memOneId=(int) session.getAttribute("login");
		
		Member oneMem = personContentService.selectOne(memOneId);
		String profilePicPath=oneMem.getProfile_pic_path();
		String profilePic=oneMem.getProfile_pic();		
		String imagePath=profilePicPath+"\\"+profilePic;
		
		InputStream in = new FileInputStream(new File(imagePath));
		IOUtils.copy(in, response.getOutputStream());
	}
	
}
