package net.yoon.service.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.yoon.domain.SunglassesVo;
import net.yoon.persistence.SunglassesDao;
import net.yoon.service.IBoardService;

public class ManagerContentService implements IBoardService {

	private SunglassesDao sunglassesDao = SunglassesDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ManagerContentService 실행됨");
		
		int sunglasses_num = Integer.parseInt(request.getParameter("sunglasses_num"));
		SunglassesVo sunglassesVo = sunglassesDao.getContentByNum(sunglasses_num);
		request.setAttribute("sunglassesVo", sunglassesVo);
		
		return "/WEB-INF/views/manager/manager_content.jsp";
	}

}
