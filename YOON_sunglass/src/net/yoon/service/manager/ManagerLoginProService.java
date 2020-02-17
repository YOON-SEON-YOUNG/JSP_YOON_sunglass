package net.yoon.service.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.yoon.domain.ManagerLoginDto;
import net.yoon.persistence.ManagerDao;
import net.yoon.service.IBoardService;

public class ManagerLoginProService implements IBoardService {

	private ManagerDao managerDao = ManagerDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String manager_id = request.getParameter("manager_id");
		String manager_pw = request.getParameter("manager_pw");
		
		ManagerLoginDto managerLoginDto = new ManagerLoginDto(manager_id, manager_pw);
		boolean result = managerDao.checkManager(managerLoginDto);
		
		HttpSession session = request.getSession();	// 로그인 정보 남기기..
		if(result == true) {
			session.setAttribute("manager_id", manager_id);
			session.setAttribute("msg", "manager_login_success");
		} else {
			session.setAttribute("msg", "manager_login_fail");
		}
		
		String redirectPath = "redirect:";
		if(result == true) {
			redirectPath += "manager-main.yoon?msg=manager_login_success";
		} else {
			redirectPath += "manager-login-form.yoon?msg=manager_login_fail";
		}
		
//		return "redirect:manager-main.yoon";
		
		return redirectPath;
	}

}
