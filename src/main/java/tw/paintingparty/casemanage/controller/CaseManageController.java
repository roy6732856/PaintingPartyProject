package tw.paintingparty.casemanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CaseManageController {
	
	@RequestMapping(path = "/backend/casemanage2", method = RequestMethod.GET)
	public String backendcasemanage() {
		return "CaseManage";
	}
	
	
}
