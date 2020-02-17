package net.yoon.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.yoon.persistence.ReviewDao;
import net.yoon.service.IBoardService;
import net.yoon.util.FileUploader;

public class MemberDeleteProService implements IBoardService {

	private ReviewDao reviewDao = ReviewDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardDeleteProService 실행됨");
		
		int review_num = Integer.parseInt(request.getParameter("review_num"));
		String review_writer = request.getParameter("review_writer");
		
		// 글 작성자와 로그인한 사용자가 같은지를 판별
		HttpSession seisson = request.getSession();
		String mem_id = (String) seisson.getAttribute("mem_id");
		
		if(!review_writer.equals(mem_id)) {
			return "redirect:board-review-content.board?review_num=" + review_num + "&msg=invalid_id";
		}
		
		// tbl_board 에서 데이터 삭제
		boolean result = reviewDao.delete(review_num);
		
		String msg = "fail";
		if (result == true) {
			msg = "success";
			
			// upload 폴더에 있는 파일 삭제
			String review_filname = reviewDao.getReviewFilename(review_num);
			FileUploader.deleteFile(request, review_filname);
		}
		
		return "redirect:board-review.board?msg=" + msg;
	}

}
