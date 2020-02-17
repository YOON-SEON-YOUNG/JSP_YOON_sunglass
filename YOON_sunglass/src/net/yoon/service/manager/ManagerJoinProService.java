package net.yoon.service.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.yoon.domain.ManagerVo;
import net.yoon.persistence.ManagerDao;
import net.yoon.service.IBoardService;

public class ManagerJoinProService implements IBoardService {

	private	ManagerDao managerDao = ManagerDao.getInstance(); 
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String manager_id = request.getParameter("manager_id");
		String manager_pw = request.getParameter("manager_pw");
		String manager_name = request.getParameter("manager_name");
		
		
		ManagerVo managerVo = new ManagerVo();
		managerVo.setManager_id(manager_id);
		managerVo.setManager_pw(manager_pw);
		managerVo.setManager_pw(manager_name);
		
		System.out.println("managerVo: " + managerVo);
		
//		boolean result = true;
		boolean result = managerDao.insertManager(managerVo);
		
		String redirectPath = "redirect:";
		if(result == true) {
			redirectPath += "manager-login-form.yoon?msg=manager_join_success";
		} else {
			redirectPath += "manager-join-form.yoon?msg=manager_join_fail";
		}
	
		
		return redirectPath;
	}

}
