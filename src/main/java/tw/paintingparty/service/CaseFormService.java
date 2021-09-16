package tw.paintingparty.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import tw.paintingparty.model.CaseFormDao;
import tw.paintingparty.model.Cases;

@Service
@Transactional
public class CaseFormService {

	@Autowired
	private CaseFormDao cfDAO;
	
	public Cases addForm(Cases bean) {
		
		return cfDAO.addForm(bean);
	}
}
