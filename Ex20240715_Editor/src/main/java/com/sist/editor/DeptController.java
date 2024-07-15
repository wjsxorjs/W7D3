package com.sist.editor;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.DeptDAO;
import mybatis.vo.DeptVO;

@Controller
public class DeptController {

	@Autowired
	private DeptDAO d_dao;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private ServletContext application;
	
	@RequestMapping("/dept")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		
		// 표현할 목록 가져오기
		DeptVO[] d_ar = d_dao.getList();
		mv.addObject("d_ar", d_ar);
		
		mv.setViewName("dept");
		
		return mv;
	}
	
	@RequestMapping(value="/dept",method = RequestMethod.POST)
	public ModelAndView search(String searchType, String searchValue) {
		ModelAndView mv = new ModelAndView();
		
		// 표현할 목록 가져오기
		DeptVO[] d_ar = d_dao.search(searchType,searchValue);
		mv.addObject("d_ar", d_ar);
		mv.addObject("searchType", searchType);
		mv.addObject("searchValue", searchValue);
		
		mv.setViewName("dept");
		
		return mv;
	}
	
	
	
	
}
