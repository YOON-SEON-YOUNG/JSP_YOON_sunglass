package net.yoon.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.yoon.domain.ReviewVo;
import net.yoon.persistence.ReviewDao;
import net.yoon.service.IBoardService;

public class MemberUpdateFormService implements IBoardService {
	
	private ReviewDao reviewDao = ReviewDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardUpdateFormService 실행됨");
		
		int review_num = Integer.parseInt(request.getParameter("review_num"));
		ReviewVo reviewVo = reviewDao.getReviewContentByNum(review_num);
		request.setAttribute("reviewVo", reviewVo);
		
		return "/WEB-INF/views/board/board_review_update_form.jsp";
	}

}
