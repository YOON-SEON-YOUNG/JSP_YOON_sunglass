package net.yoon.service.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.yoon.service.IBoardService;

public class ManagerOrderedFormService implements IBoardService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			System.out.println("ManagerOrderedFormService 실행됨");
		
		return "/WEB-INF/views/manager/orderList.jsp";
	}

}
