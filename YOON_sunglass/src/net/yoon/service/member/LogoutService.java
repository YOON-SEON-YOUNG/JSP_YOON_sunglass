package net.yoon.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.yoon.service.IBoardService;

public class LogoutService implements IBoardService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.print("LogoutService 실행");
		
		HttpSession session = request.getSession();
		session.invalidate();	// 무효화
				
		return "redirect:board-list.board";
	}

}
