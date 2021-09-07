package tw.paintingparty.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "evaluation_b2a")
@Component("evaluation_b2a") 
public class EvaluationB2A implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer evaluation_id;
	
	@Transient
	private Integer case_id;
	
	@Transient
	private Integer member_id_s; 
	
	@Transient
	private Integer member_id_r; 
	
	private String evaluation_star;
	
	private String evaluation_content;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="case_id") 
	private Cases casesbean;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="member_id_s")
	private Member memberbean_s; //發案者資訊
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="member_id_r") 
	private Member memberbean_r; //接案者資訊

	public Integer getEvaluation_id() {
		return evaluation_id;
	}

	public void setEvaluation_id(Integer evaluation_id) {
		this.evaluation_id = evaluation_id;
	}

	public String getEvaluation_star() {
		return evaluation_star;
	}

	public void setEvaluation_star(String evaluation_star) {
		this.evaluation_star = evaluation_star;
	}

	public String getEvaluation_content() {
		return evaluation_content;
	}

	public void setEvaluation_content(String evaluation_content) {
		this.evaluation_content = evaluation_content;
	}



	public Cases getCasesbean() {
		return casesbean;
	}

	public void setCasesbean(Cases casesbean) {
		this.casesbean = casesbean;
	}

	public Member getMemberbean_s() {
		return memberbean_s;
	}

	public void setMemberbean_s(Member memberbean_s) {
		this.memberbean_s = memberbean_s;
	}

	public Member getMemberbean_r() {
		return memberbean_r;
	}

	public void setMemberbean_r(Member memberbean_r) {
		this.memberbean_r = memberbean_r;
	}


}
