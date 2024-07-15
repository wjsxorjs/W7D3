package com.sist.editor;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;
import spring.vo.ImgVO;

@Controller
public class BbsController {

	@Autowired
	private BbsDAO b_dao;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private ServletContext application;
	
	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		
		// 표현할 목록 가져오기
		BbsVO[] b_ar = b_dao.getList("bbs",1,10);
		mv.addObject("b_ar", b_ar);
		
		mv.setViewName("list");
		
		return mv;
	}
	
	@RequestMapping("/write")
	public String write() {
		return "write";
	}
	
	@RequestMapping(value="/saveImg", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> saveImg(ImgVO ivo) {
		Map<String, String> i_map = new HashMap<String, String>();
		
		MultipartFile f = ivo.getFile();
		if(f.getSize()>0) {
			// 파일이 있는 경우
			// 파일을 저장할 위치, 절대 경로를 만들자	
			
			String realPath = application.getRealPath("/resources/editor_img");
			try {
				f.transferTo(new File(realPath, f.getOriginalFilename()));
				i_map.put("fname",f.getOriginalFilename());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		String c_path = request.getContextPath()+"/resources/editor_img";
		i_map.put("url", c_path);
		
		
		
		return i_map;
		//요청한 곳으로 보내진다.
		// 이때, JSON으로 보내기 위해 @ResponseBody으로 지정해준다.
	}
	
	
}
