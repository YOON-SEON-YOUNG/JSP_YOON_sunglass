package net.yoon.service.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.yoon.service.IBoardService;

public class ManagerJoinFormService implements IBoardService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "/WEB-INF/views/manager/manager_join_form.jsp";
	}

}
