package tw.paintingparty.model;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("caseFormDAO")
@Transactional
public class CaseFormDao {

	@Autowired
	private SessionFactory factory;
	
	public Cases addForm(Cases bean) {
		
		Session session = factory.getCurrentSession();
		
		String sql = "insert into cases (member_id , case_title , upload_date , price_min , price_max , case_tag , demand) values ( ? , ? , ? , ? , ? , ? , ? )";
		
		NativeQuery addEntity = session.createSQLQuery(sql);
		
		addEntity.setParameter(1, bean.getMember_id());

		addEntity.setParameter(2, bean.getCase_title());

		addEntity.setParameter(3, bean.getUpload_date());
		
		addEntity.setParameter(4, bean.getPrice_min());

		addEntity.setParameter(5, bean.getPrice_max());

		addEntity.setParameter(6, bean.getCase_tag());

		addEntity.setParameter(7, bean.getDemand());
	
		addEntity.executeUpdate();

		
		
//		String sql = "insert into cases (memeber_id , case_title , price_min , price_max , publics , case_tag , demand , case_status )  "
//				+ "values( ? , ? , ? , ? , ? , ? , ? ,? )";
//			
//		
//		NativeQuery addEntity = session.createSQLQuery(sql);
//		
//		addEntity.setParameter(1, bean.getMember_id());
//		
//		addEntity.setParameter(2, bean.getCase_title());
//
//		addEntity.setParameter(3, bean.getPrice_min());
//
//		addEntity.setParameter(4, bean.getPrice_max());
//
//		addEntity.setParameter(5, bean.getPublics());
//
//		addEntity.setParameter(6, bean.getCase_tag());
//
//		addEntity.setParameter(7, bean.getDemand());
//
//		addEntity.setParameter(8, bean.getCase_status());
//
//		addEntity.executeUpdate();
		
		return bean;
	}

	
}
