package tw.paintingparty.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import tw.paintingparty.model.Cases;
import tw.paintingparty.service.CaseFormService;

@Controller
public class CaseFormApplyController {
	
	@RequestMapping(path = "/CaseFormApplyPage/{memberid}",method = RequestMethod.GET)
	public String processCaseFromPage(HttpSession session,@PathVariable("memberid")int memberid) {
		
		session.setAttribute("memberid", memberid);
		
		System.out.println("顯示發布案件時的memberid:" + memberid);
		
		return "CaseForm";
	}
	
	@Autowired
	private CaseFormService cfService;
	
	@RequestMapping(path = "/addform.controller" , method = RequestMethod.POST)
	public String processCaseFormInsertAction(@RequestParam("inputCaseName") String inputcaseName,
			@RequestParam("inputLowBudget")Integer inputLowBudget,
			@RequestParam("inputHighBudget")Integer inputHighBudget,
			@RequestParam("commissionExplain")String commissionExplain,HttpSession session) {
			
		
		int memberid = (int) session.getAttribute("memberid");
		
		//測試
//		String publics = (String) session.getAttribute("publics");
//		String demand = (String) session.getAttribute("demand");
		String case_tag = (String) session.getAttribute("case_tag");
		
		System.out.println("顯示執行表單送出時的memberid: "+ memberid);
		
		System.out.println("成功接收");
		System.out.println("inputCaseName：" + inputcaseName);
		System.out.println("inputLowBudget：" + inputLowBudget);
		System.out.println("inputHighBudget：" + inputHighBudget);
		
		Cases cf1 = new Cases();
		cf1.setCase_title(inputcaseName);
		cf1.setPrice_min(inputLowBudget);
		cf1.setPrice_max(inputHighBudget);
		cf1.setDemand(commissionExplain);
		
		cf1.setMember_id(2);
		
		//測試
//		cf1.setPublics("是");
//		cf1.setDemand("長頭髮");
		cf1.setCase_tag("1,8");
		
		//將util.Date轉成sql.Date
				Date utilDate = new Date();
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				
				cf1.setUpload_date(sqlDate);
				//由於還沒法抓到這是第幾個member根第幾個case
				
		
				cfService.addForm(cf1);
		

				
		return "success";
	}
	
	
	
	
	
	
	
	
	
	
	
//	測試連線網頁用
//	@RequestMapping(path = "/quotation1",method = RequestMethod.GET)
//	public String quotation1() {
//		return "Quotation";
//	}
//	
//	@RequestMapping(path = "/quotation2",method = RequestMethod.GET)
//	public String quotation2() {
//		return "Quotation2";
//	}
}
