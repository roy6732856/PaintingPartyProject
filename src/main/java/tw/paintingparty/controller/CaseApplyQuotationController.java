package tw.paintingparty.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.paintingparty.model.CaseApply;
import tw.paintingparty.model.Member;
import tw.paintingparty.service.CaseApplyQuotationService;
import tw.paintingparty.service.MemberService;

@Controller
public class CaseApplyQuotationController {
	
	 @Autowired
	 private MemberService mService;
	
	@RequestMapping(path = "/caseapplymainpage.controller/{caseid}",method = RequestMethod.GET)
	public String processCaseApplyQuotationMainPage(HttpSession session,@PathVariable("caseid")int caseid,Model m) {
		//把收到的caseid 放進"caseid"這個參數中
		session.setAttribute("caseid", caseid);
		System.out.println("顯示報價單時的caseid:" + caseid);
		
		Member mem1 = mService.showLoginUsername();
		m.addAttribute("member_name", mem1.getMember_name());
		
		return "Quotation";
	}
	
	@Autowired
	private CaseApplyQuotationService caqService;
	
	@RequestMapping(path = "/addapply.controller",method = RequestMethod.POST)
	public String processCaseApplyQuotaitonInsertAction(@RequestParam("spendDay")int spendDay,
			@RequestParam("expectedBudget")int expectedBudget,HttpSession session) {
		
		//由上一個controllerg收過來的caseid
		//session等級較適合用在關掉瀏覽器之前都需要存在的物件  ex.登入的會員ID...
		int caseid = (int) session.getAttribute("caseid");
		int memid = (int)session.getAttribute("session_member_id");
		System.out.println("顯示執行表單送出時的caseid: "+ caseid);
		System.out.println("顯示執行表單送出時的memberid: "+ memid);
		
		
		//一個新的apply 先設定case_time   還有setprice_expected
		CaseApply c1 = new CaseApply();
		c1.setCase_time(spendDay);
		c1.setPrice_expected(expectedBudget);
		c1.setCase_id(caseid);
		//memberid要由登入那邊取得
		c1.setMember_id(memid);
		
		//將util.Date轉成sql.Date
		Date utilDate = new Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		c1.setApply_date(sqlDate);
		//由於還沒法抓到這是第幾個member根第幾個case
		
		
		caqService.addApply(c1);
		
		
//		
		return "success";
	}
	
	
	
//	@GetMapping(path = "/addapply.controller2")
//	@ResponseBody
//	public String processCaseApplyQuotaitonInsertAction() {
//		
////		CaseApply c1 =new CaseApply();
//		
////		caqService.addApply();
////		
//		return "success";
//	}
	
	
	
	
}
