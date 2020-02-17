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

public class ManagerUpdateProService implements IBoardService {
	
	private SunglassesDao sunglassesDao = SunglassesDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ManagerUpdateProService 실행됨");
		
		SunglassesVo sunglassesVo = new SunglassesVo();
		
		String isBinary = request.getParameter("isBinary");
		
		// 글 작성자와 로그인한 사용자가 같은지를 판별
		HttpSession seisson = request.getSession();
		String manager_id = (String) seisson.getAttribute("manager_id");
		String sunglasses_writer = "";
		String sunglasses_img = "";
		String fileSystemName = "";
		
		int sunglasses_num = 0;
		
		if(isBinary != null && isBinary.equals("N")) {
			sunglasses_num = Integer.parseInt(request.getParameter("sunglasses_num"));
			String sunglasses_kind = request.getParameter("sunglasses_kind");
			String sunglasses_name = request.getParameter("sunglasses_name");
			int sunglasses_price = Integer.parseInt(request.getParameter("sunglasses_price"));
			int sunglasses_count = Integer.parseInt(request.getParameter("sunglasses_count"));
			String sunglasses_content = request.getParameter("sunglasses_content");
			sunglasses_writer  = request.getParameter("sunglasses_writer");	// 위에서 얻음
			
			sunglassesVo.setSunglasses_num(sunglasses_num);
			sunglassesVo.setSunglasses_kind(sunglasses_kind);
			sunglassesVo.setSunglasses_name(sunglasses_name);
			sunglassesVo.setSunglasses_price(sunglasses_price);
			sunglassesVo.setSunglasses_count(sunglasses_count);
			sunglassesVo.setSunglasses_content(sunglasses_content);
			sunglassesVo.setSunglasses_writer(manager_id);
			
		} else {
			MultipartRequest multi = FileUploader.upload(request);
			sunglasses_img = multi.getParameter("sunglasses_img");
			
			sunglasses_num = Integer.parseInt(multi.getParameter("sunglasses_num"));
			String sunglasses_kind = multi.getParameter("sunglasses_kind");
			String sunglasses_name = multi.getParameter("sunglasses_name");
			int sunglasses_price = Integer.parseInt(multi.getParameter("sunglasses_price"));
			int sunglasses_count = Integer.parseInt(multi.getParameter("sunglasses_count"));
			String sunglasses_content = multi.getParameter("sunglasses_content");
			sunglasses_writer  = multi.getParameter("sunglasses_writer");		// 위에서 얻음
			
			Enumeration<?> enumer = multi.getFileNames();
			String filename = (String)enumer.nextElement();
			fileSystemName = multi.getFilesystemName(filename);
			
			sunglassesVo.setSunglasses_num(sunglasses_num);
			sunglassesVo.setSunglasses_kind(sunglasses_kind);
			sunglassesVo.setSunglasses_name(sunglasses_name);
			sunglassesVo.setSunglasses_price(sunglasses_price);
			sunglassesVo.setSunglasses_count(sunglasses_count);
			sunglassesVo.setSunglasses_content(sunglasses_content);
			sunglassesVo.setSunglasses_writer(manager_id);
			
			sunglassesVo.setSunglasses_img(fileSystemName);
		}
		
		// 글 작성자와 로그인한 사용자가 같은지를 판별
//		if(!board_writer.equals(mem_id)) {
//			FileUploader.deleteFile(request, fileSystemName);
//			return "redirect:content.kh?board_num=" + board_num + "&msg=invalid_id";
//		}
		
		FileUploader.deleteFile(request, sunglasses_img);	// 삭제요청
		
		sunglassesDao.update(sunglassesVo);
		
		return "redirect:manager-content.yoon?sunglasses_num=" + sunglasses_num;
	}

}
