package net.yoon.service.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.yoon.service.IBoardService;

public class ManagerDeleteFormService implements IBoardService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ManagerDeleteFormService 실행됨");
		
		int sunglasses_num = Integer.parseInt(request.getParameter("sunglasses_num"));
		request.setAttribute("sunglasses_num", sunglasses_num);
		
		return "/WEB-INF/views/manager/manager_delete_form.jsp";
	}

}
