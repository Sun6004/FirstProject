package basicProject;

import java.util.List;

public class DesignerService {
	private static DesignerService instance = new DesignerService();

	private DesignerService() {
	}

	public static DesignerService getInstance() {
		return instance;
	}

	private DesignerDAO dao = DesignerDAO.getInstance();

	public List<DesignerVO> allDesigner() {
		return dao.allDesigner();
	}

	public int deleteDsigner(String name) {
		return dao.deleteDsigner(name);
	}

	public List<DesignerVO> retire() {
		return dao.retire();
	}
}