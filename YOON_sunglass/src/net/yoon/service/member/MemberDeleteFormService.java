package net.yoon.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.yoon.service.IBoardService;

public class MemberDeleteFormService implements IBoardService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardDeleteFormService 실행됨");
		
		int review_num = Integer.parseInt(request.getParameter("review_num"));
		request.setAttribute("review_num", review_num);
		
		return "/WEB-INF/views/board/board_delete_form.jsp";
	}

}
