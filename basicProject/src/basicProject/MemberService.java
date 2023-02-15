package basicProject;

import java.util.List;

public class MemberService {
	private static MemberService instance = new MemberService();

	private MemberService() {
	}

	public static MemberService getInstance() {
		return instance;
	}

	private MemberDAO dao = MemberDAO.getInstance();

	public int login(MemberVO vo) {
		return dao.login(vo);
	}

	public int signUpMember(MemberVO vo) {
		return dao.signUpMember(vo);
	}

	public MemberVO myInfo(String memId) {
		return dao.myInfo(memId);
	}

	public int checkId(String id) {
		return dao.checkId(id);
	}
}
