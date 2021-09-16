package tw.paintingparty.casemanage.model;

import java.io.Serializable;

public class HireBMemberReceiveBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer case_id;
	
	private Integer bmember_id;
	
	private Integer price_expected;

	public Integer getCase_id() {
		return case_id;
	}

	public void setCase_id(Integer case_id) {
		this.case_id = case_id;
	}

	public Integer getBmember_id() {
		return bmember_id;
	}

	public void setBmember_id(Integer bmember_id) {
		this.bmember_id = bmember_id;
	}

	public Integer getPrice_expected() {
		return price_expected;
	}

	public void setPrice_expected(Integer price_expected) {
		this.price_expected = price_expected;
	}
	
	
	
	
}
