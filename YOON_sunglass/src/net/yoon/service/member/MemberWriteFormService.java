package net.yoon.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.yoon.service.IBoardService;

public class MemberWriteFormService implements IBoardService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardWriteFormService 실행됨");
		return "/WEB-INF/views/board/board_review_write_form.jsp";
	}

}
