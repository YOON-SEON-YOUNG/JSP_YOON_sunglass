package net.yoon.service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.yoon.domain.LoginDto;
import net.yoon.persistence.MemberDao;
import net.yoon.service.IBoardService;

public class MemberLoginProService implements IBoardService {

	private MemberDao memberDao = MemberDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberLoginProService 실행됨");
		
//		int num = Integer.parseInt(request.getParameter("num"));
		
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		
		LoginDto loginDto = new LoginDto(mem_id, mem_pass);
		boolean result = memberDao.checkMember(loginDto);
		
		HttpSession session = request.getSession();	// 로그인 정보 남기기..
		if(result == true) {
			session.setAttribute("mem_id", mem_id);
			session.setAttribute("msg", "login_success");
		} else {
			session.setAttribute("msg", "login_fail");
		}
		
		return "redirect:board-list.board";
	}

}
