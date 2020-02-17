package net.yoon.service.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.yoon.service.IBoardService;

public class ManagerLogoutService implements IBoardService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ManagerLogoutService 실행됨");
		
		HttpSession session = request.getSession();
		session.invalidate();	// 무효화
				
		return "redirect:manager-login-form.yoon";
	}

}
