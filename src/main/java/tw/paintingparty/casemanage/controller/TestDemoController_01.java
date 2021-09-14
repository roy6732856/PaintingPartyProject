package tw.paintingparty.casemanage.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.paintingparty.casemanage.model.CaseManageDAO;
import tw.paintingparty.casemanage.model.EvaluationA2BBean;
import tw.paintingparty.casemanage.model.EvaluationB2ABean;
import tw.paintingparty.casemanage.model.FileContentReceiveBeanB;
import tw.paintingparty.casemanage.model.FileContentSendBeanB;
import tw.paintingparty.casemanage.model.HeadShotBean;
import tw.paintingparty.casemanage.model.MyAppliedAllCasesBean;
import tw.paintingparty.casemanage.model.MyAppliedOrdersBean;
import tw.paintingparty.casemanage.model.MyPostedAllCasesBean;
import tw.paintingparty.casemanage.model.MyPostedOrdersBean;
import tw.paintingparty.casemanage.model.PayInfoBean;
import tw.paintingparty.casemanage.model.PayInfoIdBean;
import tw.paintingparty.model.CaseApply;
import tw.paintingparty.model.Member;
import tw.paintingparty.model.Product;
import tw.teamUtil.Util01;



@Controller
public class TestDemoController_01 {
	
	@Autowired
	private CaseManageDAO cmDao;
	
	
	@RequestMapping(path = "/backend/filecontent", method = RequestMethod.GET)
	//測試後台的靜態資源引入
	public String test4(Model m) {
		return "FileContent";
	}
	
	@RequestMapping(path = "/backend/caseapply", method = RequestMethod.GET)
	//測試後台的靜態資源引入
	public String test5(Model m) {
		return "CaseApply";
	}
	

	
	@RequestMapping(path = "/backend/editcase", method = RequestMethod.GET)
	//測試後台的靜態資源引入
	public String test8(Model m) {
		return "EditCase";
	}
	
	//--------------------------------------------------------
	
	@RequestMapping(path = "/backend/casemanage2", method = RequestMethod.GET)
	//測試CASEMANAGE的靜態資源成功與否
	public String test9(Model m) {
		return "CaseManage2";
	}
	
	//------------------------------
	
	
	@RequestMapping(path = "/backend/mypostedallcases", method = RequestMethod.GET)
	public String test10(HttpServletRequest request, Model m ) throws JsonProcessingException {
		
		Object myid = request.getSession().getAttribute("session_member_id");
		
		List<MyPostedAllCasesBean> selectAllMyPostedCases = cmDao.selectMyPostedCases( (Integer)myid );
		ObjectMapper om1 = new ObjectMapper();
		String writeValueAsString = om1.writeValueAsString( selectAllMyPostedCases ); //BEAN轉JSON

		m.addAttribute("userid", writeValueAsString );
		
		return "MyPostedAllCases";
	}
	
	
	
	
	@PostMapping(path = "/backend/mypostedallcases2") //AJAX請求處理，回應JSON
	@ResponseBody
	public List<MyPostedAllCasesBean> test10_2( HttpServletRequest request ) {
		
		Object myid = request.getSession().getAttribute("session_member_id");
		List<MyPostedAllCasesBean> selectAllMyPostedCases = cmDao.selectMyPostedCases( (Integer)myid );
		
		return selectAllMyPostedCases ;
	}
	
	
	
	
	
	@GetMapping(path = "/backend/casebackstage/{caseid}") //案件管理頁面
	@ResponseBody
	public String test10_3(@PathVariable("caseid") String caseid , HttpServletRequest request ) {
		String welcom = "casebackstage: " + caseid;
		
		return welcom ;
	}
	
	
	
	//-----------------------------------------------
	@RequestMapping(path = "/backend/mypostedorders", method = RequestMethod.GET)
	public String test11(HttpServletRequest request, Model m ) throws JsonProcessingException {
		Object myid = request.getSession().getAttribute("session_member_id");
		ObjectMapper om1 = new ObjectMapper();
		
		List<MyPostedOrdersBean> selectMyPostedOrders = cmDao.selectMyPostedOrders( (Integer)myid );
		String writeValueAsString = om1.writeValueAsString( selectMyPostedOrders ); //BEAN轉JSON		
		m.addAttribute("userid", writeValueAsString );
		
		return "MyPostedOrders";
	}
	
	
	
	@PostMapping(path = "/backend/mypostedorders2")
	@ResponseBody
	public List<MyPostedOrdersBean> test11_2( HttpServletRequest request ) {
		
		Object myid = request.getSession().getAttribute("session_member_id");
		List<MyPostedOrdersBean> selectMyPostedOrders = cmDao.selectMyPostedOrders( (Integer)myid );
		
		return selectMyPostedOrders ;
	}
	
	
	
	@GetMapping(path = "/backend/filecontent/{orderid}") //檔案內容
	@ResponseBody
	public String test11_3(@PathVariable("orderid") String orderid , HttpServletRequest request ) {
		String welcom = "filecontent: " + orderid;
		
		return welcom ;
	}
	
	
	
	
	@PostMapping(path = "/backend/passthestage/{orderid}") //過稿
	public String test11_7(@PathVariable("orderid") String orderid , HttpServletRequest request ) {
		
		int orderInt = Integer.parseInt(orderid);
		
		cmDao.PassTheStage(orderInt);
		
		
			return "CaseManage2" ;
		
	}
	
	
	
	
	
	@PostMapping(path = "/backend/cancelorder/{orderid}") //終止交易
	public String test11_5(@PathVariable("orderid") String orderid , HttpServletRequest request ) {
		
		int orderInt = Integer.parseInt(orderid);
		
		cmDao.CancelTheOrder(orderInt);
		
		return "CaseManage2" ;
	}
	
	
	@PostMapping(path = "/backend/evaluationa2b") //給評價A給B
	public void test11_6(@RequestBody EvaluationA2BBean evaa2b ) {
		
		cmDao.EvaluationA2B(evaa2b);
		
	}
	
	@PostMapping(path = "/backend/payInfo") //查看對方的匯款資訊
	@ResponseBody
	public PayInfoBean test11_7(@RequestBody PayInfoIdBean pmemid ) {
		
//		System.out.println(pbmemid.getPmemid());
		PayInfoBean getBmemberPayInfo = cmDao.GetBmemberPayInfo(pmemid.getPmemid());
		
		return getBmemberPayInfo;
		
	}
	
	@GetMapping(path = "/backend/headshotdownloader/{memid}")
	public void test11_8(@PathVariable("memid") Integer memberid , HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(memberid);
		
		HeadShotBean headShotDownloader = cmDao.HeadShotDownloader(memberid);
		String filePath = headShotDownloader.getProfile_pic_path() + "\\" + headShotDownloader.getProfile_pic();
		
		FileInputStream fis = new FileInputStream(filePath);
		IOUtils.copy(fis, response.getOutputStream()); //由IOUtils來幫我們讀寫，會自己幫我們用暫存、關串流，但檔案超出2G還5G似乎會出事(?)
		
	}
	
	//-------------------------------------------------
	
	@RequestMapping(path = "/backend/myappliedallcases", method = RequestMethod.GET)
	public String test12(HttpServletRequest request , Model m) throws JsonProcessingException {
		Object myid = request.getSession().getAttribute("session_member_id");
		ObjectMapper om1 = new ObjectMapper();
		
		List<MyAppliedAllCasesBean> selectMyAppliedAllCases = cmDao.selectMyAppliedAllCases( (Integer)myid );
		String writeValueAsString = om1.writeValueAsString( selectMyAppliedAllCases ); //BEAN轉JSON		
		m.addAttribute("userid", writeValueAsString );
		
		return "MyAppliedAllCases";
	}
	
	
	
	
	@PostMapping(path = "/backend/myappliedallcases2")
	@ResponseBody
	public List<MyAppliedAllCasesBean> test12_2( HttpServletRequest request ) {
		
		Object myid = request.getSession().getAttribute("session_member_id");
		List<MyAppliedAllCasesBean> selectMyPostedOrders = cmDao.selectMyAppliedAllCases( (Integer)myid );
		
		return selectMyPostedOrders ;
	}
	
	
	
	
	//-------------------------------------------------
	
	
	
	
	
	@RequestMapping(path = "/backend/myappliedorders", method = RequestMethod.GET)
	public String test13( HttpServletRequest request , Model m ) throws JsonProcessingException {
		
		Object myid = request.getSession().getAttribute("session_member_id");
		ObjectMapper om1 = new ObjectMapper();
		List<MyAppliedOrdersBean> selectMyAppliedOrders = cmDao.selectMyAppliedOrders( (Integer)myid );
		String writeValueAsString = om1.writeValueAsString( selectMyAppliedOrders ); //BEAN轉JSON		
		m.addAttribute("userid", writeValueAsString );
		
		return "MyAppliedOrders";
	}
	
	
	

	
	@PostMapping(path = "/backend/myappliedorders2")
	@ResponseBody
	public List<MyAppliedOrdersBean> test13_2( HttpServletRequest request ) {
		
		Object myid = request.getSession().getAttribute("session_member_id");
		List<MyAppliedOrdersBean> selectMyPostedOrders = cmDao.selectMyAppliedOrders( (Integer)myid );
		
		return selectMyPostedOrders ;
	}
	
	
	
	@GetMapping(path = "/backend/uploadfile/{orderid}") //畫家上傳成品檔案
	@ResponseBody
	public String test13_3(@PathVariable("orderid") String orderid , HttpServletRequest request ) {
		String welcom = "uploadfile: " + orderid;
		
		return welcom ;
	}
	
	
	@PostMapping(path = "/backend/evaluationb2a") //給評價A給B
	public void test13_4(@RequestBody EvaluationB2ABean evab2a ) {
		
		cmDao.EvaluationB2A(evab2a);
		
	}
	
	
	
	@PostMapping(path = "/backend/productuploader") //給評價A給B
	@ResponseBody
	public void test13_5(@RequestParam(value="productupload") MultipartFile file,@RequestParam(value="proorderid") Integer orderid,@RequestParam(value="procomment") String comments) throws IOException {
//		BufferedReader br;
//		String line;
//		InputStream is = multipart.getInputStream();
//		br = new BufferedReader(new InputStreamReader(is));
//		//讀取檔案並印出
//		while ((line = br.readLine()) != null) {
//			System.out.println("line="+line);
//		}
		
		Util01 util01 = new Util01();
		String fileName = util01.fileNameUtil( file.getOriginalFilename());
		String savePath = "C:\\PaintingImg\\Product";
		String finalPath = savePath + "\\" + fileName;
		
		
		//儲存圖片至硬碟
		File saveFile = new File(finalPath);
//		System.out.println("savePath:" + finalPath);
		if (fileName != null && fileName.length() != 0) { 
			file.transferTo(saveFile);
		 }
		
		Product product = new Product();
		product.setOrder_id(orderid);
		product.setProduct_name(fileName);
		product.setProduct_path(savePath);
		product.setPainter_message(comments);
		
		cmDao.ProductUpload(product);
		
//		System.out.println(fileName);
//		System.out.println(file);
//		System.out.println(orderid);
//		System.out.println(comments);
		
		System.out.println("接收成功");
		
		
		
	}
	
	
	@PostMapping(path = "/backend/filecontentb") //檔案內容(AB共用)
	@ResponseBody
	public List<FileContentSendBeanB> test13_6(@RequestBody FileContentReceiveBeanB fcrbb) {
		
		System.out.println("接收成功");
		System.out.println(fcrbb.getOrder_id());
		System.out.println(fcrbb.getBmember_id());
		List<FileContentSendBeanB> fileContentB = cmDao.FileContentB(fcrbb);
		
		return fileContentB;
	}
	
	
	//**************************
	
	@GetMapping(path = "/backend/productimg/{imgfilename}") //檔案內容的圖片(AB共用)
	@ResponseBody
	public void test13_7(@PathVariable("imgfilename") String imgFileName , HttpServletRequest request, HttpServletResponse response ) throws IOException {
		
		System.out.println(imgFileName);
		String filePath = "C:\\PaintingImg\\Product" + "\\" + imgFileName;
	
		FileInputStream fis = new FileInputStream(filePath);
		IOUtils.copy(fis, response.getOutputStream()); //由IOUtils來幫我們讀寫，會自己幫我們用暫存、關串流，但檔案超出2G還5G似乎會出事(?)
		
	}
	
	
	
	
	//--------------------------------------------------------------
	@RequestMapping(path = "/DEMO", method = RequestMethod.GET)
	@ResponseBody
	public List<MyAppliedOrdersBean> test15( HttpServletRequest request , Model m ) throws JsonProcessingException {
		
		List<MyAppliedOrdersBean> selectMyAppliedOrders = cmDao.selectMyAppliedOrders( 4 );
		
		return selectMyAppliedOrders;
	}
	
	
	@RequestMapping(path = "/DEMO2", method = RequestMethod.GET)
	public String test16( HttpServletRequest request , Model m ) throws JsonProcessingException {
		
		
		
		return "sss哈哈";
	}
	
	
	
	
	
	
	//=======================================================
	
	@GetMapping(path = "/backend/updatedemo")
	@ResponseBody
	public String test14( Model m) {
		
		String resultStr = cmDao.UpdateDemo();	
		m.addAttribute("userid", resultStr );
		
		return resultStr ;
	}
	
	@GetMapping(path = "/backend/systemdemo")
	public String test15( Model m) {
		
		
		return "SystemNotice" ;
	}
	
	
	@GetMapping(path = "/backend/testinsert")
	@ResponseBody
	public String test16( Model m) {
		
		cmDao.InsertDemo();
		return "success!" ;
	}
	
	

	
	
}
