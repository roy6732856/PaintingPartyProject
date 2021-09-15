package tw.paintingparty.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("accountManagerDao")
@Transactional
public class AccountManagerDao {

	@Autowired
	private SessionFactory factory;
	
	@Transactional
	public Member selectOne(int oneMemId) {
		Session session = factory.openSession();
		Member oneMem = session.get(Member.class, oneMemId);
		session.close();
		return oneMem;		
	}
	@Transactional
	public Member UpdateOne(int oneMemId, String oneMemEmail, String oneMenBank_account, String oneMemPixiv) {

		Session session = factory.openSession();
//		Member oneMem = session.get(Member.class, oneMemId);
		
//		oneMem.setEmail(oneMemEmail);
//		oneMem.setBank_account(oneMenBank_account);
//		oneMem.setPixiv(oneMemPixiv);
//		session.save(oneMem);
		
		String hql = "from Member where member_id=1 ";
		Query<Member> query = session.createQuery(hql, Member.class);
		query.setParameter("pixiv", "pixiv");
		query.executeUpdate();
		Member result = query.uniqueResult();
		
		
//		String hql = "from Member where member_id=1 ";
//		Query<Member> query = session.createQuery(hql, Member.class);
//		query.setParameter("pixiv", "pixiv");
//		query.executeUpdate();
//		Member result = query.uniqueResult();		
		return result;		
	}
	
	
}
