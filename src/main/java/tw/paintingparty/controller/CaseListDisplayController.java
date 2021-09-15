package tw.paintingparty.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.paintingparty.model.CaseListPageDAO;
import tw.paintingparty.model.Cases;
import tw.paintingparty.service.CaseListPageService;
import tw.paintingparty.service.CasePageDisplayService;

@Controller
public class CaseListDisplayController {
	
	
	@Autowired
	private CasePageDisplayService capdService;
	
	@Autowired
	private CaseListPageService clpService;
	
	@RequestMapping(path = "/caselistpage.controller",method = RequestMethod.GET)
	public String processCaseListDisplayAction(Model m) {
		
		//總共有多少Pages
		Long cases = clpService.TotalPage();
		
		Long totalPages;
		
		if(cases%8==0) {
			Long total = (cases/8);
			totalPages = total;
		}else {
			Long total = (cases/8)+1;
			totalPages = total;
		}
		
		
		m.addAttribute("totalCases",cases);
		m.addAttribute("totalPages",totalPages);
		
		return "CaseList3";
	}
	
	@RequestMapping(path = "/findAll",method = RequestMethod.POST)
	@ResponseBody
	public List<Cases> processFildAllCasesAction() {
		
		return capdService.findAll();
	}
	
	@RequestMapping(path ="/queryByPage/{pageNo}",method = RequestMethod.POST)
	@ResponseBody
	public List<Cases> processQueryAllPages(@PathVariable("pageNo")int pageNo){
		
		return clpService.QueryByPage(pageNo-1);
				
	}
	
	@RequestMapping(path ="/queryByTags/{Tags}",method = RequestMethod.POST)
	@ResponseBody
	public List<Cases> processQueryByTags(@PathVariable("Tags")int Tags){
		
		return clpService.QueryByTags(Tags);
				
	}
	
	@ResponseBody
	@RequestMapping(path = "/ajaxRequest",method = RequestMethod.POST)
	public Cases ajaxRequest(@RequestBody Cases cases) {
		System.out.println("CaseTag:"+cases.getCase_tag());
		System.out.println("Min_Price:" + cases.getPrice_min());
		System.out.println("Max_Price:" + cases.getPrice_max());
		return cases;
		
	}
	
	
}
