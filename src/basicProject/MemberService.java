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

	
	
//	public static void main(String[] args) {
//		List<MemberVO> list = MemberDAO.getInstance().searchMembers("");
//		for (MemberVO vo : list) {
//			System.out.println(vo);
//		}
//	}
}
