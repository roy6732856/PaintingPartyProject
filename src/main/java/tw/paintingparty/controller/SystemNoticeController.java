package tw.paintingparty.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.paintingparty.model.OrderNotice;
import tw.paintingparty.model.SystemNotice;
import tw.paintingparty.service.SystemNoticeService;

	 @Controller 
	 @SessionAttributes(names = {"sysTotalPages","sysTotalElements","ordTotalPages","ordTotalElements"})
	 public class SystemNoticeController {
	  
		 @Autowired 
		 private SystemNoticeService snService;
		 
		 @Autowired 
		 private SystemNoticeService onService;
		    
		 @RequestMapping(path = "/backend/systemnoticemainpage", method = RequestMethod.GET)		
		 public String systemnoticemainpage(HttpServletRequest request, HttpServletResponse response, Model m){
			 List<SystemNotice> systemAll = snService.systemAll();

			 int sysElement = systemAll.size();
			 int sysPage;
			 
			 if(sysElement%3!=0) {
				 sysPage = (int)((sysElement/3)+1);
			 }else {
				 sysPage = (int)(sysElement/3);
			 }
			 
			 List<OrderNotice> orderAll = onService.order();			 
			 
			 int ordElement = orderAll.size();
			 int ordPage;
			 
			 if(ordElement%3!=0) {
				 ordPage = (int)(ordElement/3)+1; 
			 }else {
				 ordPage = (int)(ordElement/3);
			 }
			 
		     m.addAttribute("sysTotalPages", sysPage);
		     m.addAttribute("sysTotalElements", sysElement);
		     m.addAttribute("ordTotalPages", ordPage);
		     m.addAttribute("ordTotalElements", ordElement);		     
			 return "SystemNotice";
		 }  
		    
		 @RequestMapping(path = "/backend/systemnotice/{pageNo}", method = RequestMethod.POST)
		 @ResponseBody
		 public List<SystemNotice> systemnotice(@PathVariable("pageNo") int pageNo, HttpServletRequest request, HttpServletResponse response, Model m) { 
		     List<SystemNotice> systemAll = snService.systemAll();
			 HttpSession session = request.getSession();
			 
			 int sysTotalPages=(int) session.getAttribute("sysTotalPages");
			 int sysTotalElements=(int) session.getAttribute("sysTotalElements");
			 int initCount;
			 int endCount;

		     List<SystemNotice> systemAllFeedback = new ArrayList<SystemNotice>();
		     
		     if(pageNo==sysTotalPages) {
			     initCount=(pageNo-1)*3;
			     endCount=sysTotalElements;
			     
			     systemAllFeedback.clear();
			     for(int i=initCount;i<endCount;i++) {
			    	 systemAllFeedback.add(systemAll.get(i));				     
			     }		     
		     }else {
			     systemAllFeedback.clear();
			     initCount=(pageNo-1)*3;
			     endCount=pageNo*3;
			     for(int i=initCount;i<endCount;i++) {
			    	 systemAllFeedback.add(systemAll.get(i));
			     }		    	 
		     }
		     		     		     
		     return systemAllFeedback; 
		 }
		  
		 @RequestMapping(path = "/backend/ordernotice/{pageNo}", method = RequestMethod.POST)
		 @ResponseBody
		 public List<OrderNotice> ordernotice(@PathVariable("pageNo") int pageNo, HttpServletRequest request, HttpServletResponse response, Model o) { 
			 List<OrderNotice> orderAll = onService.order();
			 HttpSession session = request.getSession();
			 
			 int ordTotalPages=(int) session.getAttribute("ordTotalPages");
			 int ordTotalElements=(int) session.getAttribute("ordTotalElements");
			 int initCount;
			 int endCount;
			 
		     List<OrderNotice> orderAllFeedback = new ArrayList<OrderNotice>();
			 
		     if(pageNo==ordTotalPages) {
			     orderAllFeedback.clear();		    	 
			     initCount=(pageNo-1)*3;
			     endCount=ordTotalElements;

			     for(int i=initCount;i<endCount;i++) {
			    	 orderAllFeedback.add(orderAll.get(i));				     
			     }
		     
		     }else {		    	 
		    	 orderAllFeedback.clear();
		    	 
			     initCount=(pageNo-1)*3;
			     endCount=pageNo*3;
			     for(int i=initCount;i<endCount;i++) {
			    	 orderAllFeedback.add(orderAll.get(i));
			     }		    	 
		     }
		     		     
			 return orderAllFeedback; 
		 }	  
	  }
  
  
  
  
  
  
  
  
 