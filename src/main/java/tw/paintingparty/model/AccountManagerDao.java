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
	
<<<<<<< HEAD
	
	public Member selectOne(int oneMemId) {
		Session session = factory.getCurrentSession();
		Member oneMem = session.get(Member.class, oneMemId);
		return oneMem;		
	}
	
	
	public String UpdateOne(int oneMemId, String oneMemEmail, String oneMenBank_account, String oneMemPixiv) {

		Session session = factory.getCurrentSession();
		
		String hql1="update Member as m set m.email = :mememail where m.member_id = :memid";
		Query query1 = session.createQuery(hql1).setParameter("mememail", oneMemEmail).setParameter("memid", oneMemId);
		query1.executeUpdate();
		
		String hql2="update Member as m set m.bank_account = :membank_account where m.member_id = :memid";
		Query query2 = session.createQuery(hql2).setParameter("membank_account", oneMenBank_account).setParameter("memid", oneMemId);
		query2.executeUpdate();
		
		String hql3="update Member as m set m.pixiv = :mempixiv where m.member_id = :memid";
		Query query3 = session.createQuery(hql3).setParameter("mempixiv", oneMemPixiv).setParameter("memid", oneMemId);
		query3.executeUpdate();
		
		return "Success";
=======
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
>>>>>>> 4ae3bdb1b74598cec010cc2f96a6e4d52729f866
	}
	
	
}
