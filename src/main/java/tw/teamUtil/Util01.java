package tw.teamUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Util01 {

	public static void main(String[] args) {
//		測試區
//		Util01 util01 = new Util01();
//		Map priceStage = util01.PriceDivideByThree(259);
//		System.out.println(priceStage.get("Stage1"));
//		System.out.println(priceStage.get("Stage2"));
//		System.out.println(priceStage.get("Stage3"));
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	String nowTimeing = formatter.format( LocalDateTime.now() ).toString();
    	System.out.println(nowTimeing);
	}
	
	
	private void saveFile(String safeFilePath) throws IOException {
		
		FileInputStream is = new FileInputStream(safeFilePath); 
		byte[] b = new byte[is.available()];
		is.read(b);//把檔案讀進暫存B
		is.close();
//		p1.setPicture(b); //把暫存B SET進照片物件
//		
//		pService.insert(p1);
	}
	
	
	public String fileNameUtil( String originalFileName ) { 
		//把檔名給加上日期，例如aaa.jpg => 1202008200912aaa.jpg
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    	String nowTimeing = formatter.format( LocalDateTime.now() ).toString();
    	String export = nowTimeing + originalFileName;
    	
		return export;
	}
	
	
	public String getCurrentDate ( ) {
//		得到現在的日期，格式為yyyy-MM-dd
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	String date = formatter.format( LocalDateTime.now() ).toString();
    	return date;
	}
	
	
	public String dateFormatToStringYYYYMMDD ( Date date ) {
		//把DATE的內容，去掉分秒，只剩下年月日，並轉成字串
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String format = sdf.format(date);
		return format;
	}
	
	
	public Map PriceDivideByThree( int price ) { 
		//訂單稿酬除以三，若無法除盡，兩個商一樣，最後一個要自動補滿稿酬
		
		Map<String,Integer> priceMap = new HashMap<String,Integer>();
		Integer priceInteger = price;
		Integer PriceStage1and2 = priceInteger/3;
		Integer PriceStage3 = price - (PriceStage1and2*2);
		priceMap.put("Stage1", PriceStage1and2);
		priceMap.put("Stage2", PriceStage1and2);
		priceMap.put("Stage3", PriceStage3);
		
		return priceMap;
	}
	
	
	
	public void insertImgInfoToDB (  String ImgName , String ImgRoot ) { 
		//當客戶端上傳檔案，伺服端把檔案讀進伺服端硬碟時，同步把圖片的存放位置寫到資料庫
		//因為HIBERNATE的HQL語句無法實現INSERT，所以這邊我們還是用JDBC去做
		String url = "jdbc:sqlserver://localhost:1433;databaseName=test";
		
		String user = "sa";
		String password = "as";
		
		String sql = "insert into imginfo (imgname , imgroot) values (?,?) ";
		
		try(Connection conn = DriverManager.getConnection(url, user, password);) {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, ImgName );
			pstmt.setString(2, ImgRoot );
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
