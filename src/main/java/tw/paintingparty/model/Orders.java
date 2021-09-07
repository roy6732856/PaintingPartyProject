package tw.paintingparty.model;

import java.io.Serializable;
import java.util.Date;

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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "orders")
@Component("orders") 
public class Orders implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer order_id;
	
	@Transient 
	private Integer case_id;
	
	@Transient 
	private Integer member_id; //接案者ID
	
	private String order_status;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date order_date;

	private Integer price;
	
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name ="case_id") //本訂單的案件
	private Cases ocasesbean;
	
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name ="member_id") //接案者資訊(乙方為b表示)
	private Member bmemberbean;

	


	public Member getBmemberbean() {
		return bmemberbean;
	}

	public void setBmemberbean(Member bmemberbean) {
		this.bmemberbean = bmemberbean;
	}




	public Cases getOcasesbean() {
		return ocasesbean;
	}

	public void setOcasesbean(Cases ocasesbean) {
		this.ocasesbean = ocasesbean;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}



	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	
	
	
}
