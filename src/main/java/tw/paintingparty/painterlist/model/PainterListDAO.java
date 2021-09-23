package tw.paintingparty.painterlist.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.paintingparty.model.Cases;
import tw.paintingparty.model.Member;
import tw.paintingparty.model.PainterTag;


@Repository("painterListDAO")
@Transactional
public class PainterListDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Member getMember(int memberId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		
		Member m1 = session.get(Member.class,memberId);
		
		return m1;
	}

	//--------------------------------------------	
	
	public List<Member> SelectAllMember(){
		
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "from Member";
				  // + "select * from member where member_status like '%畫師%'";
		
		Query<Member> query = session.createQuery(hql,Member.class);
		
		List<Member> list = query.list();
		
		return list;		
	}
	
	//---------------------------------------------		
	
	public List<Member> search(String select1 , String select2){

		
		Session session = sessionFactory.getCurrentSession(); 
		// step 01 : select distinct member_id from painter_tag where tag_id=1 or tag_id =2;

		List<PainterTag> lstPainterTag = null;
		List<Integer> lstmemberId = null;
	//	int select1 = 1;
	//	int select2 = 2;
		
		if("".equals(select1) && "".equals(select2)) {// 預設起始是全部的資料
			String hql1="from PainterTag";
			try {
				Query<PainterTag> query  = session.createQuery(hql1,PainterTag.class);
				lstPainterTag = query.getResultList();
			} catch(NoResultException e) {
				lstPainterTag = null;
			} 
		}else {// 點擊按鈕查條件
			String hql1="from PainterTag where tag_id=:select1 or tag_id = :select2";
			try {
				Query<PainterTag> query  = session.createQuery(hql1,PainterTag.class)
								.setParameter("select1", select1 )
								.setParameter("select2", select2 );
				lstPainterTag = query.getResultList();
			} catch(NoResultException e) {
				lstPainterTag = null;
			} 
		}
		
		
	//	System.out.println("lstPainterTag.size() => " + lstPainterTag.size());
		
		// 過濾重複的物件
		Map<Integer, Member> map = new HashMap<Integer,Member>();
		for(int i = 0 ;i<lstPainterTag.size();i++) {
			System.out.println("lstPainterTag.memberBean => " + lstPainterTag.get(i).getMemberbean().getMember_id());
			Integer key = lstPainterTag.get(i).getMemberbean().getMember_id();
			if(map.get(key) == null) { // 判斷是否已經儲存
				// 未存在
				if("畫師".equals(lstPainterTag.get(i).getMemberbean().getMember_status())) {
					map.put(key , lstPainterTag.get(i).getMemberbean());
				}
			}
		}
		System.out.println("map.size() => " + map.size());
		List<Member> listMemberInfo = new ArrayList<Member>(map.values());
		return listMemberInfo;
	}
	
	
	//---------------------------------------------	
	
	public Member selectId(int memberid) {
		Session session = sessionFactory.getCurrentSession();
		Member oneMem = session.get(Member.class,memberid);
		return oneMem;		
	}
	
	//---------------------------------------------	
	
	
}