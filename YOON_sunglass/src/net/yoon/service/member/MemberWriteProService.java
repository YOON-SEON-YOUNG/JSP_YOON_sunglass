package net.yoon.service.member;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import net.yoon.domain.ReviewVo;
import net.yoon.persistence.ReviewDao;
import net.yoon.service.IBoardService;
import net.yoon.util.FileUploader;

public class MemberWriteProService implements IBoardService {

	private ReviewDao reviewDao = ReviewDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardWriteProService 실행됨");
		
		MultipartRequest multi = FileUploader.upload(request);
		
		String review_subject 	= multi.getParameter("review_subject");
		String board_content 	= multi.getParameter("board_content");
		
		HttpSession session = request.getSession();
		String mem_id = (String)session.getAttribute("mem_id");
		
		Enumeration<?> enumer = multi.getFileNames();	// 파일명을 얻는게 아닌
														// <input type="file">인 요소의 name 속성의 값을 얻는다.
		String filename = (String)enumer.nextElement();	// name="board_filename"의 값
		System.out.println("filename: " + filename);
		String review_filename = multi.getFilesystemName(filename);	// 실제 저장된 이름
		
		ReviewVo reviewVo = new ReviewVo();
		reviewVo.setReview_subject	(review_subject);
		reviewVo.setReview_content	(board_content);
		reviewVo.setReview_writer	(mem_id);
		reviewVo.setReview_filename	(review_filename);
		System.out.println("BoardWriteProService, reviewVo: " + reviewVo);
		
		reviewDao.write(reviewVo);
		
		return "redirect:board-review.board";
	}

}
