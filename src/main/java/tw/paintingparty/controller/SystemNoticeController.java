package tw.paintingparty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.paintingparty.model.OrderNotice;
import tw.paintingparty.model.SystemNotice;
import tw.paintingparty.service.SystemNoticeService;



  @Controller public class SystemNoticeController {
  
  @Autowired private SystemNoticeService snService;
  
  
  
  @RequestMapping(path = "/backend/systemnotice", method = RequestMethod.GET)
 
  public String systemnotice(Model m) { 
	  List<SystemNotice> systemAll = snService.systemAll();
  
    return "SystemNotice";
  
  }
  
  @Autowired private SystemNoticeService onService;
  
  @RequestMapping(path = "/backend/ordernotice", method = RequestMethod.GET)
  
  public String ordernotice(Model o) { 
	  List<OrderNotice> order = onService.order();
  
  return "SystemNotice";
  
  }
  
  }
 