package basicProject;

import java.text.NumberFormat;

public class ReservationVO {
	private String rNo; //예약 번호
	private String rDate; // 예약날짜
	private String memId; // 회원아이디
	private String memName; // 회원 이름
	private String dsiNo; // 디자이너 넘버
	private String dsiName; // 디자이너 이름
	private String menuName; // 시술이름
	private String position;
	private String menuNo;
	private int price; // 가격
	NumberFormat nf = NumberFormat.getInstance();
	public String getMenuNo() {
		return menuNo;
	}


	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}


	
	
	//사용자가 시술이름 이랑 가격볼수 있음
	public ReservationVO(String menuName, int price) {
		this.menuName = menuName;
		this.price = price;
	}
	

	public ReservationVO(String dsiNo, String dsiName, String position) {
		this.dsiNo = dsiNo;
		this.dsiName = dsiName;
		this.position = position;
	}


	public ReservationVO(String menuName, String menuNo, int price) {
		this.menuName = menuName;
		this.menuNo = menuNo;
		this.price = price;
	}
	

	public ReservationVO(String rDate, String memId, String dsiNo, String menuNo) {
		this.rDate = rDate.replaceAll("^(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})$", "$1-$2-$3 $4:$5");
		this.memId = memId;
		this.dsiNo = dsiNo;
		this.menuNo = menuNo;
	}


	public ReservationVO(String rNo, String rDate, String memName, String dsiName, String menuName, int price) {
		this.rNo = rNo;
		this.rDate = rDate.replaceAll("^(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})$", "$1-$2-$3 $4:$5");
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


	public String getPrice() {
		return nf.format(price);
	}


	public void setPrice(int price) {
		this.price = price;
	}
	


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	@Override
	public String toString() {
		return String.format(" %s    %s    %s    %s    %7s    %s", rNo, rDate, memName, dsiName, nf.format(price), menuName);
	}

}
