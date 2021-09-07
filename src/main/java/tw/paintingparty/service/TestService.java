package tw.paintingparty.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.paintingparty.model.Member;
import tw.paintingparty.model.TestDAO;

@Service
@Transactional
public class TestService {

	@Autowired
    private TestDAO testDao;
	
	public Member test() {
		return testDao.test();
	}
	
	
}
