package basicProject;

public class MenuVO {
	private String menuNo;
	private String menuName;
	
	//생성자
	public MenuVO(String menuNo, String menuName) {
		super();
		this.menuNo = menuNo;
		this.menuName = menuName;
	}
	
	//GetterSetter
	public String getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

}