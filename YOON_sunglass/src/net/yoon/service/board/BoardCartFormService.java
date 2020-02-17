package net.yoon.service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.yoon.service.IBoardService;

public class BoardCartFormService implements IBoardService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardCartFormService 실행");
		
		return "/WEB-INF/views/board/board_cart_form.jsp";
	}

}
