package tw.paintingparty.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.paintingparty.model.Member;
import tw.paintingparty.model.MemberDao;
import tw.paintingparty.model.PainterTag;
import tw.paintingparty.model.Tag;

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
	public Member SelectMemberById(int memberId) {
		return memberDao.selectMemberById(memberId);
	}
	
	public List<PainterTag> selectTagIdByMemberId(int memberId) {
		return memberDao.selectTagIdByMemberId(memberId);
	}
	public Tag selectTagContentByTagId(int tagid) {
		return memberDao.selectTagContentByTagId(tagid);
	}
}
