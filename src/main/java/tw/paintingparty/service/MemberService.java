package tw.paintingparty.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.paintingparty.model.Member;
import tw.paintingparty.model.MemberDao;

@Service
@Transactional
public class MemberService {
	@Autowired
    private MemberDao memberDao;
	@Autowired
	public HttpServletRequest request;
	public Member showLoginUsername() {
		return memberDao.showLoginUsername(request);
	}
}
