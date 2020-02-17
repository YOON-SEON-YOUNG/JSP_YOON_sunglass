package net.yoon.service.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.yoon.service.IBoardService;

public class ManagerMainService implements IBoardService {
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ManagerMainService 실행됨");
		
		
		return "/WEB-INF/views/manager/manager_main.jsp";	// forward
	}

}
