package com.sist.editor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

@Controller
public class BbsController {

	@Autowired
	private BbsDAO b_dao;
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		
		// 표현할 목록 가져오기
		BbsVO[] b_ar = b_dao.getList("bbs",1,10);
		mv.addObject("b_ar", b_ar);
		
		
		return mv;
	}
	
	@RequestMapping("/write")
	public String write() {
		return "write";
	}
	
	
}
