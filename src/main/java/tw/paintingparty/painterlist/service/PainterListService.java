package tw.paintingparty.painterlist.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.paintingparty.model.Member;
import tw.paintingparty.painterlist.model.PainterListDAO;

@Service
@Transactional
public class PainterListService {
	
	@Autowired
	private PainterListDAO plDAO;
	
	public Member getMember(int id) {
		return plDAO.getMember(id);
	}
	
	public List<Member>FindAll() {
		return plDAO.FindAll();
	}
	
	public Member selectOne(int memId) {
		
		Member oneMem = plDAO.selectOne(memId);
		return oneMem;
	}


	

				
	
}
