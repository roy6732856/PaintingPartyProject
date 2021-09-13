package tw.paintingparty.casemanage.model;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.paintingparty.model.CaseApply;
import tw.paintingparty.model.Member;
import tw.paintingparty.model.Orders;


@Repository("caseManageDao")
@Transactional
public class CaseManageDAO {

	@Autowired
    public SessionFactory sessionfactory;
	
	//---------------------------------------------
	
	public List<MyPostedAllCasesBean> selectMyPostedCases( int myId ) {
		//我發布的 => 所有案件
		Session session = sessionfactory.getCurrentSession();
		String hql = "select new tw.paintingparty.casemanage.model.MyPostedAllCasesBean"
				+ "(c.case_id , c.case_title , c.upload_date , c.price_min , c.price_max , c.case_status) from Cases as c "
				+ "where c.postedmemberbean.member_id=:memid";
		Query query = session.createQuery(hql).setParameter("memid", myId);
		List<MyPostedAllCasesBean> list = query.list();
		
//		for(MyPostedAllCasesBean mpacb : list){  
//		int id = mpacb.getCase_id();  
//		String name = mpacb.getCase_title();  
//		System.out.println(id + " : " + name); 
//		}

		
		return list;
	
	}
	
//---------------------------------------------
	
	public List<MyPostedOrdersBean> selectMyPostedOrders( int myId ) {
//    	我發布的>已成立訂單
//		利用自己ID茶案件表，查出來的是自己全部的案件，在用案件ID去查訂單表，相符的就是自己發過的案件有成例的所有訂單。
//      印出案件表的案件標題、在印出訂單的任一欄位
		
		Session session = sessionfactory.getCurrentSession();
    	String sql = "select o.* "
    			+ "from cases as c , orders as o "
    			+ "where c.member_id = :memid and c.case_id = o.case_id ";

    	
    	NativeQuery addEntity = session.createSQLQuery(sql).addEntity(Orders.class).setParameter("memid", myId);
    	List<Orders> resultList = addEntity.getResultList();
    	List<MyPostedOrdersBean> mpoblist = new ArrayList<MyPostedOrdersBean>();

    	//以下手動封裝(因為是用createSQLQuery)
    	for( Orders o : resultList ) {
    		MyPostedOrdersBean mpob = new MyPostedOrdersBean();
    		mpob.setOrder_id(o.getOrder_id());
    		mpob.setCase_id(o.getOcasesbean().getCase_id());
    		mpob.setCase_title(o.getOcasesbean().getCase_title());
    		mpob.setBmember_name(o.getBmemberbean().getMember_name());
    		mpob.setOrder_status(o.getOrder_status());
    		mpob.setOrder_date(o.getOrder_date());
    		mpob.setPrice(o.getPrice());
    		mpob.setEvaluation_status_a2b(o.getEvaluation_status_a2b());
    		mpob.setBmember_id(o.getBmemberbean().getMember_id());
    		
    		mpoblist.add(mpob);
    	}

		return mpoblist;
	
	}
	
//---------------------------------------------
	
	public List<MyAppliedAllCasesBean> selectMyAppliedAllCases( int myId ) {
//    	我應徵的 > 所有案件
		
		Session session = sessionfactory.getCurrentSession();
		
		String hql = "select new tw.paintingparty.casemanage.model.MyAppliedAllCasesBean"
				+ "(ca.applycasesbean.case_id , ca.applycasesbean.case_title , ca.apply_date , ca.price_expected , ca.case_time , ca.applycasesbean.postedmemberbean.member_name , ca.applycasesbean.postedmemberbean.member_id ) "
				+ "from CaseApply as ca"
				+ " where ca.applymemberbean.member_id = :memid ";
		Query query = session.createQuery(hql).setParameter("memid", myId);
		List<MyAppliedAllCasesBean> list = query.list();

		
		  	
//		for(MyAppliedAllCasesBean ca : list) {
//			System.out.println("發案人名稱: " + ca.getAmember_name());
//			System.out.println("案件標題: " + ca.getCase_title());
//		}
		
		
		return list;
		
	}
	
	
	
	
	public List<MyAppliedOrdersBean> selectMyAppliedOrders( int myId ) {
//    	我應徵的 > 已成立訂單
		
		Session session = sessionfactory.getCurrentSession();
		
		String hql = "select new tw.paintingparty.casemanage.model.MyAppliedOrdersBean"
				+ "(o.order_id , o.ocasesbean.case_id , o.ocasesbean.case_title , o.ocasesbean.postedmemberbean.member_name , o.order_status , o.order_date , o.price ,o.ocasesbean.postedmemberbean.member_id , o.evaluation_status_b2a ) "
				+ "from Orders as o"
				+ " where o.bmemberbean.member_id = :memid ";
		
		Query query = session.createQuery(hql).setParameter("memid", myId);
		List<MyAppliedOrdersBean> list = query.list();
		
		
//		for(MyAppliedOrdersBean mob : list) {
//			System.out.println("發案人名稱: " + mob.getAmember_name());
//			System.out.println("案件標題: " +  mob.getCase_title() );
//		}
		
		
		return list;
		
	}
	
	
	
	
	public void PassTheStage( Integer orderId ) {
//    	過稿
		
		Session session = sessionfactory.getCurrentSession();
		
		String hql = "from Orders as o where o.order_id = :orderid";
		Query<Orders> query = session.createQuery(hql,Orders.class).setParameter("orderid", orderId);
		Orders thisorder = query.getSingleResult();
		String nextStage = "";
		
		
		switch ( thisorder.getOrder_status() ) {
		
			case "第一階段" :
				nextStage = "第二階段";
				break;

			case "第二階段" :
				nextStage = "第三階段";
				break;
				
			case "第三階段" :
				nextStage = "已完成";
				break;
				
			default:
				nextStage = "錯誤";
				break;
		
		}
		thisorder.setOrder_status(nextStage);
		
		
	}
	
	
	public void CancelTheOrder( Integer orderId ) {
//    	終止交易
		
		Session session = sessionfactory.getCurrentSession();
		
		String hql = "from Orders as o where o.order_id = :orderid";
		Query<Orders> query = session.createQuery(hql,Orders.class).setParameter("orderid", orderId);
		Orders thisorder = query.getSingleResult();
		
		thisorder.setOrder_status("已取消");
		
		
	}
	
	
//    	評價A2B
	public void EvaluationA2B( EvaluationA2BBean evaa2b ) {
		
		Session session = sessionfactory.getCurrentSession();
		
		
		String sql = "insert into evaluation_a2b (case_id , member_id_s , member_id_r , evaluation_star , evaluation_content)  "
				+ "values( ? , ? , ? , ? , ? )";

    	
    	NativeQuery addEntity = session.createSQLQuery(sql);
    	addEntity.setParameter(1, evaa2b.getCase_id());
    	addEntity.setParameter(2, evaa2b.getMember_id_s());
    	addEntity.setParameter(3, evaa2b.getMember_id_r());
    	addEntity.setParameter(4, evaa2b.getEvaluation_star());
    	addEntity.setParameter(5, evaa2b.getEvaluation_content());

    	addEntity.executeUpdate();
		
		
		String hql = "update Orders as o set o.evaluation_status_a2b = :evaa2b where o.order_id = :orderid";
		Query query = session.createQuery(hql);
		query.setParameter("evaa2b", "已評價").setParameter("orderid", evaa2b.getOrder_id());
		
		query.executeUpdate();
		
		
	}
	
	
//    	評價B2A
	public void EvaluationB2A( EvaluationB2ABean evab2a ) {
		
		Session session = sessionfactory.getCurrentSession();
		
		
		String sql = "insert into evaluation_b2a (case_id , member_id_s , member_id_r , evaluation_star , evaluation_content)  "
				+ "values( ? , ? , ? , ? , ? )";
		
		
		NativeQuery addEntity = session.createSQLQuery(sql);
		addEntity.setParameter(1, evab2a.getCase_id());
		addEntity.setParameter(2, evab2a.getMember_id_s());
		addEntity.setParameter(3, evab2a.getMember_id_r());
		addEntity.setParameter(4, evab2a.getEvaluation_star());
		addEntity.setParameter(5, evab2a.getEvaluation_content());
		
		addEntity.executeUpdate();
		
		
		String hql = "update Orders as o set o.evaluation_status_b2a = :evab2a where o.order_id = :orderid";
		Query query = session.createQuery(hql);
		query.setParameter("evab2a", "已評價").setParameter("orderid", evab2a.getOrder_id());
		
		query.executeUpdate();
		
		
	}
	
	
	public PayInfoBean GetBmemberPayInfo( Integer bmemid ) {
//    	匯款資訊
		
		Session session = sessionfactory.getCurrentSession();
		
		String hql = "select new tw.paintingparty.casemanage.model.PayInfoBean"
				+ "(m.member_id , m.member_name , m.profile_pic , m.profile_pic_path , m.bank_account ) "
				+ "from Member as m"
				+ " where m.member_id = :bmemberid ";
		
		Query<PayInfoBean> query = session.createQuery(hql,PayInfoBean.class).setParameter("bmemberid", bmemid);
		PayInfoBean thisMemberInfo = query.getSingleResult();
		
		return thisMemberInfo;
		
	}
	
	public HeadShotBean HeadShotDownloader( Integer memid ) {
//    	大頭照印出
		
		Session session = sessionfactory.getCurrentSession();
		
		String hql = "from Member as m where m.member_id = :memberid";
		Query<Member> query = session.createQuery(hql,Member.class).setParameter("memberid", memid);
		Member thisMemberInfo = query.getSingleResult();
		HeadShotBean headShotBean = new HeadShotBean();
		headShotBean.setProfile_pic( thisMemberInfo.getProfile_pic() );
		headShotBean.setProfile_pic_path(thisMemberInfo.getProfile_pic_path());
		
		
		return headShotBean;
		
	}
	
	
	
	//--------------------------------------------
	
	public String UpdateDemo( ) {
//    	測試UPDATE
		
		Session session = sessionfactory.getCurrentSession();
		
		String hql = "update Member as m set m.member_name = :memname where m.member_id = :memid";

		Query query = session.createQuery(hql).setParameter("memname", "jeff").setParameter("memid", 1);
		query.executeUpdate();
		
		
		return "update seccess!";
		
	}
	
	
	
public void InsertDemo( ) {
		
		Session session = sessionfactory.getCurrentSession();
		
		
		String sql = "insert into case_apply (member_id , case_id , price_expected , case_time , apply_date )  "
				+ "values( ? , ? , ? , ? , ? )";
    	
    	NativeQuery addEntity = session.createSQLQuery(sql);
    	addEntity.setParameter(1,1);
    	addEntity.setParameter(2, 2);
    	addEntity.setParameter(3, 400);
    	addEntity.setParameter(4, 6);
    	addEntity.setParameter(5, "2021-10-11");

    	addEntity.executeUpdate();
		
		
//		String hql = "update Orders as o set o.evaluation_status_a2b = :evaa2b where o.order_id = :orderid";
//		Query query = session.createQuery(hql);
//		query.setParameter("evaa2b", "已評價").setParameter("orderid", evaa2b.getOrder_id());
//		
//		query.executeUpdate();
//		
		
	}
	
	
	
	
}
