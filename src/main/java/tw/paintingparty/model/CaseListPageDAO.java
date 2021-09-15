package tw.paintingparty.model;

import java.util.Iterator;
import java.util.List;
import java.util.Map;import javax.persistence.criteria.CriteriaBuilder.Case;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("castListDao")
@Transactional
public class CaseListPageDAO {
	
	@Autowired
	private SessionFactory factory;
	
	public Long TotalPage() {
		
		Session session = factory.getCurrentSession();
		
		String hql = "select count(c.case_id) from Cases c";
		
		Query query = session.createQuery(hql);
		
		Long maxId = (Long) query.uniqueResult();
		
		return maxId;
		
	}
	
	public List<Cases> QueryByPage(int pageNo){
		
		Session session = factory.getCurrentSession();
		
		int nowPage = (pageNo*8)+1;
		
		String hql = "from Cases c where c.case_id >= :nowPage";
		
		Query<Cases> query = session.createQuery(hql,Cases.class);
		
		query.setParameter("nowPage", nowPage);
		
		//最大筆數setMaxResults(8)
		List<Cases> list = query.setMaxResults(8).getResultList();
		
		return list;
	}
	
	public List<Cases> QueryByTags(int tags){
		
		Session session = factory.getCurrentSession();
		
		String sql = "select * from cases c where c.case_id in(select ct.case_id from case_tag ct where ct.tag_id = :tags)";
		
		Query<Cases> query = session.createSQLQuery(sql).addEntity(Cases.class);
		
		query.setParameter("tags", tags);
		
		List<Cases> list = query.setFirstResult(0).setMaxResults(8).getResultList();
		
		return list;
	}
	
	//執行複合&多查詢
//	public List<Cases> QueryByTags(Map<String,Object>pram){
//		
//		Session session = factory.getCurrentSession();
//		
//		String sql = "select * from cases where 1=1 ";
//		
//		if(!pram.isEmpty()) {
//			Iterator<String> it = pram.keySet().iterator();
//			while(it.hasNext()) {
//				String key = it.next();
//				sql = sql + "and case_tag like '%" + key + "%'" ;
//			}
//		}
//		System.out.println(sql);
//		
//		NativeQuery query = session.createSQLQuery(sql).addEntity(Cases.class);
//		
//		List<Cases> list = query.setFirstResult(0).setMaxResults(8).getResultList();
//		
//		return list;
//	}
}
