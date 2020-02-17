package net.yoon.service.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.yoon.persistence.ManagerDao;
import net.yoon.service.IBoardService;

public class ManagerCheckIdService implements IBoardService {

	private ManagerDao managerDao = ManagerDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String manager_id = request.getParameter("manager_id");

		boolean result = managerDao.checkDupManagerId(manager_id);	// Dao에서 리턴 받은 값
		
		String msg = "";
		if (result == true) {
			msg = "used_id";
		} else {
			msg = "available_id";
		}
		request.setAttribute("data", msg);
		
		return "/WEB-INF/views/data.jsp"; // forward
	}

}
