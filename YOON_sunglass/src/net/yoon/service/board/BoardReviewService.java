package net.yoon.service.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.yoon.domain.ReviewVo;
import net.yoon.domain.SunglassesVo;
import net.yoon.persistence.MemberDao;
import net.yoon.persistence.ReviewDao;
import net.yoon.service.IBoardService;

public class BoardReviewService implements IBoardService {
	
	private ReviewDao reviewDao = ReviewDao.getInstance();
	private MemberDao memberDao = MemberDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardListService 실행됨");
		
		List<ReviewVo> reviewList = reviewDao.getReviewList();
		
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		
		
		request.setAttribute("reviewList", reviewList);
		
		return "/WEB-INF/views/board/board_review.jsp";	// forward
	}

}
