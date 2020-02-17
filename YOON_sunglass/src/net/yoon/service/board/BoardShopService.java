package net.yoon.service.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.yoon.domain.PagingDto;
import net.yoon.domain.SearchDto;
import net.yoon.domain.SunglassesVo;
import net.yoon.persistence.MemberDao;
import net.yoon.persistence.SunglassesDao;
import net.yoon.service.IBoardService;

public class BoardShopService implements IBoardService {
	
	private SunglassesDao sunglassesDao = SunglassesDao.getInstance();
	private MemberDao memberDao = MemberDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardListService 실행됨");
		
		
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
		
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		
		request.setAttribute("list", list);
		request.setAttribute("pagingDto", pagingDto);
		request.setAttribute("searchDto", searchDto);
		
		return "/WEB-INF/views/board/board_shop.jsp";	// forward
	}

}
