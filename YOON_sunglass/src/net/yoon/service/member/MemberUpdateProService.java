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

public class MemberUpdateProService implements IBoardService {
	
	private ReviewDao reviewDao = ReviewDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardUpdateProService 실행됨");
		
		ReviewVo reviewVo = new ReviewVo();
		
		String isBinary = request.getParameter("isBinary");
		
		// 글 작성자와 로그인한 사용자가 같은지를 판별
		HttpSession seisson = request.getSession();
		String mem_id = (String) seisson.getAttribute("mem_id");
		String review_writer = "";
		String review_filename = "";
		String fileSystemName = "";
		
		int review_num = 0;
		
		if(isBinary != null && isBinary.equals("N")) {
			review_num = Integer.parseInt(request.getParameter("review_num"));
			String review_subject = request.getParameter("review_subject");
			String review_content = request.getParameter("review_content");
			review_writer  = request.getParameter("review_writer");	// 위에서 얻음
			
			reviewVo.setReview_num		(review_num);
			reviewVo.setReview_subject	(review_subject);
			reviewVo.setReview_content	(review_content);
			reviewVo.setReview_writer	(mem_id);
			
		} else {
			MultipartRequest multi = FileUploader.upload(request);
			review_filename = multi.getParameter("review_filename");
			
			review_num = Integer.parseInt(request.getParameter("review_num"));
			String review_subject = request.getParameter("review_subject");
			String review_content = request.getParameter("review_content");
			review_writer  = request.getParameter("review_writer");	// 위에서 얻음
			review_filename  = request.getParameter("review_filename");	// 위에서 얻음
			
			Enumeration<?> enumer = multi.getFileNames();
			String filename = (String)enumer.nextElement();
			fileSystemName = multi.getFilesystemName(filename);
			
			reviewVo.setReview_num		(review_num);
			reviewVo.setReview_subject	(review_subject);
			reviewVo.setReview_content	(review_content);
			reviewVo.setReview_writer	(mem_id);
			reviewVo.setReview_filename	(fileSystemName);
			
		}
		
		FileUploader.deleteFile(request, review_filename);	// 삭제요청
		
		reviewDao.update(reviewVo);
		
		return "redirect:board-review-content.board?review_num=" + review_num;
	}

}
