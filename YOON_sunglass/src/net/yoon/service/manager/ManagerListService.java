package net.yoon.service.manager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.yoon.domain.PagingDto;
import net.yoon.domain.SearchDto;
import net.yoon.domain.SunglassesVo;
import net.yoon.persistence.SunglassesDao;
import net.yoon.service.IBoardService;

public class ManagerListService implements IBoardService {
	
	private SunglassesDao sunglassesDao = SunglassesDao.getInstance();
//	private ManagerDao managerDao = ManagerDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ManagerListService 실행됨");
		
		int perPage = 10;
		String strPerPage = request.getParameter("perPage");
		if (strPerPage != null) {
			perPage = Integer.parseInt(strPerPage);
		}
		System.out.println("perPage: " + perPage);
		
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		SearchDto searchDto = new SearchDto(searchType, keyword);
		System.out.println("searchDto: " + searchDto);
		
		int nowPage = 1;
		String strPage = request.getParameter("nowPage");
		if (strPage != null && !strPage.equals("")) {
			nowPage = Integer.parseInt(strPage);
		}
		
		PagingDto pagingDto = new PagingDto(nowPage, searchDto, perPage);
		System.out.println("pagingDto: " + pagingDto);
		
		List<SunglassesVo> list = sunglassesDao.getList(pagingDto, searchDto);
		request.setAttribute("list", list);
		request.setAttribute("pagingDto", pagingDto);
		request.setAttribute("searchDto", searchDto);
		
		return "/WEB-INF/views/manager/manager_list.jsp";	// forward
		
		
	}

}
