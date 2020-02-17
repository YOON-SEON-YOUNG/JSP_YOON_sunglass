package net.yoon.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.yoon.domain.MemberVo;
import net.yoon.persistence.MemberDao;
import net.yoon.service.IBoardService;

public class MemberJoinProService implements IBoardService {

	private	MemberDao memberDao = MemberDao.getInstance(); 
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberJoinProService 실행됨");
		
		
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		String mem_name = request.getParameter("mem_name");
		
		
		
		MemberVo memberVo = new MemberVo();
		memberVo.setMem_id(mem_id);
		memberVo.setMem_pass(mem_pass);
		memberVo.setMem_name(mem_name);
		
		System.out.println("memberVo: " + memberVo);
		
		boolean result = memberDao.insertMember(memberVo);
		
		String redirectPath = "redirect:";
		if(result == true) {
			redirectPath += "board-login-form.board?msg=mem_join_success";
		} else {
			redirectPath += "member-join-form.mem?msg=mem_join_fail";
		}
	
//		return "redirect:board-login-form.board";
		return redirectPath;
	}

}
