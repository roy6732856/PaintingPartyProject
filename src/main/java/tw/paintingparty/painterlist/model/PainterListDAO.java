package tw.paintingparty.painterlist.model;


import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.paintingparty.model.Cases;
import tw.paintingparty.model.Member;


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

		List<Member> listMemberInfo = null;
		Session session = sessionFactory.getCurrentSession();
		// SELECT * from member where tag_personal like '%1% ' or tag_personal like '%2%'
		String hql = "FROM Member m WHERE m.tag_personal like :select1 and tag_personal like :select2";
			try {
				Query<Member> query  = session.createQuery(hql,Member.class)
								.setParameter("select1", "%"+ select1 + "%")
								.setParameter("select2", "%"+ select2 + "%");
				
				listMemberInfo = query.list();
			} catch(NoResultException e) {
				listMemberInfo = null;
			} 
		return listMemberInfo;
	}
	
	
	public Member selectId(int memberid) {
		Session session = sessionFactory.getCurrentSession();
		Member oneMem = session.get(Member.class,memberid);
		return oneMem;		
	}
	
	//---------------------------------------------	
	
	
}