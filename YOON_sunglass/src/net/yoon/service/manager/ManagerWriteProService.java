package net.yoon.service.manager;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import net.yoon.domain.SunglassesVo;
import net.yoon.persistence.SunglassesDao;
import net.yoon.service.IBoardService;
import net.yoon.util.FileUploader;

public class ManagerWriteProService implements IBoardService {

	private SunglassesDao sunglassesDao = SunglassesDao.getInstance();
			
			
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ManagerWriteProService 실행됨");
		
		MultipartRequest multi = FileUploader.upload(request);
		
		String sunglasses_kind 		= multi.getParameter("sunglasses_kind");
		String sunglasses_name 		= multi.getParameter("sunglasses_name");
		int sunglasses_price 		= Integer.parseInt(multi.getParameter("sunglasses_price"));
		int sunglasses_count 		= Integer.parseInt(multi.getParameter("sunglasses_count"));
		String sunglasses_content 	= multi.getParameter("sunglasses_content");
//		Timestamp reg_date 			= multi.getParameter("reg_date").substring("");
		
		HttpSession session = request.getSession();
		String manager_id = (String)session.getAttribute("manager_id");
		
		Enumeration<?> enumer = multi.getFileNames();	// 파일명을 얻는게 아닌
														// <input type="file">인 요소의 name 속성의 값을 얻는다.
		String filename = (String)enumer.nextElement();	// name="board_filename"의 값
		System.out.println("filename: " + filename);
		String sunglasses_img = multi.getFilesystemName(filename);	// 실제 저장된 이름
		
		SunglassesVo sunglassesVo = new SunglassesVo();
		sunglassesVo.setSunglasses_kind(sunglasses_kind);
		sunglassesVo.setSunglasses_name(sunglasses_name);
		sunglassesVo.setSunglasses_price(sunglasses_price);
		sunglassesVo.setSunglasses_count(sunglasses_count);
		sunglassesVo.setSunglasses_img(sunglasses_img);
		sunglassesVo.setSunglasses_content(sunglasses_content);
		sunglassesVo.setSunglasses_writer(manager_id);
//		sunglassesVo.setReg_date(reg_date);
		
		System.out.println("ManagerWriteProService, sunglassesVo: " + sunglassesVo);
		
		sunglassesDao.write(sunglassesVo);
		
		return "redirect:manager-list.yoon";
	}

}
