package tw.paintingparty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CaseFormApplyController {
	
	@RequestMapping(path = "/CaseFormApplyPage",method = RequestMethod.GET)
	public String processCaseFromPage() {
		return "CaseForm";
	}
}
