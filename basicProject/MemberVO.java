package basicProject;

public class MemberVO {
	private String memId;
	private String memPw;
	private String memName;
	private String memBir;
	private String memPh;
	//생성자
	public MemberVO(String memId, String memPw) {
		super();
		this.memId = memId;
		this.memPw = memPw;
	}
	
	public MemberVO(String memId, String memPw, String memName) {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
	}

	public MemberVO(String memId, String memPw, String memName, String memBir) {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
		this.memBir = memBir;
	}
	
	public MemberVO(String memId, String memPw, String memName, String memBir, String memPh) {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
		this.memBir = memBir;
		this.memPh = memPh;
	}
	
	//게터세터
	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemBir() {
		return memBir;
	}

	public void setMemBir(String memBir) {
		this.memBir = memBir;
	}

	public String getMemPh() {
		return memPh;
	}

	public void setMemPh(String memPh) {
		this.memPh = memPh;
	}

	@Override
	public String toString() {
		return String.format("%d\t%d\t%d\t%d\t%d\t%d", memBir, memId, memPw, memName, memBir, memPh );
	}
		
}

