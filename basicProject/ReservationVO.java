package basicProject;

public class ReservationVO {
	private String rDate;
	private String memId;
	private String memName;
	private String dsiNo;
	private String dsiName;
	private String menuName;
	private String rNo;

	private int price;
	
	
	public ReservationVO(String rDate, String memId, String dsiNo) {
		super();
		this.rDate = rDate;
		this.memId = memId;
		this.dsiNo = dsiNo;
	}
	//고객이 예약정보 확인할때
	public ReservationVO(String rDate, String memName, String dsiName, String menuName, String rNo, int price) {
		super();
		this.rDate = rDate;
		this.memName = memName;
		this.dsiName = dsiName;
		this.menuName = menuName;
		this.rNo = rNo;
		this.price = price;
	}
	//디자이너가 예약스케줄 확인할때
	public ReservationVO(String rDate, String memName, String dsiName, String menuName, String rNo) {
		super();
		this.rDate = rDate;
		this.memName = memName;
		this.dsiName = dsiName;
		this.menuName = menuName;
		this.rNo = rNo;
	}
	
	//GetterSetter
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
	public String getrNo() {
		return rNo;
	}

	public void setrNo(String rNo) {
		this.rNo = rNo;
	}

	
	
	@Override
	public String toString() {
		return String.format("%d\t%d\t%d\t%d\t%d\t%d",rNo, memName, dsiName, menuName, rDate, price);
	}
	
	

}
