package tw.paintingparty.util;

public class CaseByTags {

	public String ToGetTheTagName(String tags) {
		
		int tagid = Integer.parseInt(tags);
		
			switch(tagid) {
				case 1:
					return "插畫類型";
				case 2:
					return "貼圖類型";
				case 3:
					return "貼圖類型";
				case 4:
					return "漫畫類型";
				case 5:
					return "UI類型";
				case 6:
					return "人物設計類型";
				case 7:
					return "風景類型";
				case 8:
					return "日系風格";
				case 9:
					return "歐美風格";
				case 10:
					return "武俠風格";
				case 11:
					return "Q版風格";
				case 12:
					return "寫實風格";
				case 13:
					return "3D風格";
				case 14:
					return "水墨風格";
				case 15:
					return "水彩風格";
				case 16:
					return "像素風格";
					
			}
			return "輸入錯誤";
	}
}
