package tw.paintingparty.chatroom.model;

import java.text.ParseException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.paintingparty.casemanage.model.MyPostedAllCasesBean;
import tw.paintingparty.model.ChatConn;
import tw.paintingparty.model.Member;

@Repository("chatRoomDao")
@Transactional
public class ChatRoomDAO {
	
	@Autowired
    public SessionFactory sessionfactory;
	
	//---------------------------------------------
	
	
	public List<MyChatConnBean> selectAllMyConn( Integer myid ) { //我連接了誰
	
		Session session = sessionfactory.getCurrentSession();
		
//		String hql = "from ChatConn as cc where cc.amemberbean.member_id = :myid";
		
		String hql = "select new tw.paintingparty.chatroom.model.MyChatConnBean "
				+ "(cc.bmemberbean.member_id , cc.bmemberbean.member_name , cc.bmemberbean.profile_pic , cc.conn_date ) "
				+ "from ChatConn as cc"
				+ " where cc.amemberbean.member_id = :myid "
				+ " order by cc.conn_date desc ";
		
		
		Query<MyChatConnBean> query = session.createQuery(hql,MyChatConnBean.class).setParameter("myid", myid);
		List<MyChatConnBean> resultList = query.getResultList();
		
//		Query<ChatConn> query = session.createQuery(hql,ChatConn.class).setParameter("myid", myid);
//		List<ChatConn> resultList = query.getResultList();
		
		return resultList;
	
	}
}
