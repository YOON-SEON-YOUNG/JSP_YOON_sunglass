package net.yoon.service.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.yoon.persistence.SunglassesDao;
import net.yoon.service.IBoardService;
import net.yoon.util.FileUploader;

public class ManagerDeleteProService implements IBoardService {

	private SunglassesDao sunglassesDao = SunglassesDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ManagerDeleteProService 실행됨");
		
		int sunglasses_num = Integer.parseInt(request.getParameter("sunglasses_num"));
		String sunglasses_writer = request.getParameter("sunglasses_writer");
		
		// 글 작성자와 로그인한 사용자가 같은지를 판별
		HttpSession seisson = request.getSession();
		String manager_id = (String) seisson.getAttribute("manager_id");
		
		if(!sunglasses_writer.equals(manager_id)) {
			return "redirect:manager-content.yoon?sunglasses_num=" + sunglasses_num + "&msg=invalid_id";
		}
		
		// sunglasses 에서 데이터 삭제
		boolean result = sunglassesDao.delete(sunglasses_num);
		
		String msg = "fail";
		if (result == true) {
			msg = "success";
			
			// upload 폴더에 있는 파일 삭제
			String sunglasses_img = sunglassesDao.getImage(sunglasses_num);
			FileUploader.deleteFile(request, sunglasses_img);
		}
		
		return "redirect:manager-sunglasses-list.yoon?msg=" + msg;
	}

}
