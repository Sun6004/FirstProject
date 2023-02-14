package basicProject;

public class DesignerVO {
	private String dsiNo;
	private String dsiName;
	private String dsiBir;
	private String dsiPh;
	private String dsiAdd;
	private String dsiPosi;
	private String hireDate;

	// 생성자
	public DesignerVO(String dsiNo, String dsiName) {
		super();
		this.dsiNo = dsiNo;
		this.dsiName = dsiName;
	}

	public DesignerVO(String dsiNo, String dsiName, String dsiBir) {
		super();
		this.dsiNo = dsiNo;
		this.dsiName = dsiName;
		this.dsiBir = dsiBir;
	}

	public DesignerVO(String dsiNo, String dsiName, String dsiBir, String dsiPh) {
		super();
		this.dsiNo = dsiNo;
		this.dsiName = dsiName;
		this.dsiBir = dsiBir;
		this.dsiPh = dsiPh;
	}

	public DesignerVO(String dsiNo, String dsiName, String dsiBir, String dsiPh, String dsiPosi) {
		this.dsiNo = dsiNo;
		this.dsiName = dsiName;
		this.dsiBir = dsiBir;
		this.dsiPh = dsiPh;
		this.dsiPosi = dsiPosi;
	}

	

	public DesignerVO(String dsiNo, String dsiName, String dsiBir, String dsiPh, String dsiPosi, String hireDate) {
		this.dsiNo = dsiNo;
		this.dsiName = dsiName;
		this.dsiBir = dsiBir;
		this.dsiPh = dsiPh;
		this.dsiPosi = dsiPosi;
		this.hireDate = hireDate;
	}

	public DesignerVO(String dsiNo, String dsiName, String dsiBir, String dsiPh, String dsiAdd, String dsiPosi,
			String hireDate) {
		this.dsiNo = dsiNo;
		this.dsiName = dsiName;
		this.dsiBir = dsiBir;
		this.dsiPh = dsiPh;
		this.dsiAdd = dsiAdd;
		this.dsiPosi = dsiPosi;
		this.hireDate = hireDate;
	}

	// getter setter
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

	public String getDsiBir() {
		return dsiBir;
	}

	public void setDsiBir(String dsiBir) {
		this.dsiBir = dsiBir;
	}

	public String getDsiPh() {
		return dsiPh;
	}

	public void setDsiPh(String dsiPh) {
		this.dsiPh = dsiPh;
	}

	public String getDsiAdd() {
		return dsiAdd;
	}

	public void setDsiAdd(String dsiAdd) {
		this.dsiAdd = dsiAdd;
	}

	public String getDsiPosi() {
		return dsiPosi;
	}

	public void setDsiPosi(String dsiPosi) {
		this.dsiPosi = dsiPosi;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return String.format("%s\t%s\t%s\t%s\t%s\t%s\t", dsiNo, dsiName, dsiBir, dsiPh, dsiPosi, hireDate);

	}
}