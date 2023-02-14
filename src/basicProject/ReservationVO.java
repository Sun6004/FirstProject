package basicProject;

public class ReservationVO {
	private String rNo; //예약 번호
	private String rDate; // 예약날짜
	private String memId; // 회원아이디
	private String memName; // 회원 아이디
	private String dsiNo; // 디자이너 넘버
	private String dsiName; // 디자이너 이름
	private String menuName; // 시술이름
	private int price; // 가격
	
	
	//사용자가 시술이름 이랑 가격볼수 있음
	public ReservationVO(String menuName, int price) {
		this.menuName = menuName;
		this.price = price;
	}
	
	
	public ReservationVO(String rNo, String rDate, String memName, String dsiName, String menuName, int price) {
		this.rNo = rNo;
		this.rDate = rDate;
		this.memName = memName;
		this.dsiName = dsiName;
		this.menuName = menuName;
		this.price = price;
	}

	

	public String getrNo() {
		return rNo;
	}


	public void setrNo(String rNo) {
		this.rNo = rNo;
	}


	public String getrDate() {
		return rDate;
	}


	public void setrDate(String rDate) {
		this.rDate = rDate;
	}


	public String getMemId() {
		return memId;
	}


	public void setMemId(String memId) {
		this.memId = memId;
	}


	public String getMemName() {
		return memName;
	}


	public void setMemName(String memName) {
		this.memName = memName;
	}


	public String getDsiNo() {
		return dsiNo;
	}


	public void setDsiNo(String dsiNo) {
		this.dsiNo = dsiNo;
	}


	public String getDsiName() {
		return dsiName;
	}


	public void setDsiName(String dsiName) {
		this.dsiName = dsiName;
	}


	public String getMenuName() {
		return menuName;
	}


	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return String.format("", null);
	}

}
