package net.yoon.service.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.yoon.domain.SunglassesVo;
import net.yoon.persistence.MemberDao;
import net.yoon.persistence.SunglassesDao;
import net.yoon.service.IBoardService;

public class BoardListService implements IBoardService {
	
	private SunglassesDao sunglassesDao = SunglassesDao.getInstance();
	private MemberDao memberDao = MemberDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardListService 실행됨");
		
//		List<SunglassesVo> list = sunglassesDao.getList();
		
//		HttpSession session = request.getSession();
//		String mem_id = (String) session.getAttribute("mem_id");
		
		
//		request.setAttribute("list", list);
		
		return "/WEB-INF/views/board/board_list.jsp";	// forward
	}

}
