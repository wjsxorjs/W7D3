package com.sist.ex2;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.EmpDAO;
import mybatis.vo.EmpVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private EmpDAO e_dao;
	
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping("/")
	public ModelAndView emp_list() {
		ModelAndView mv = new ModelAndView();
		
		EmpVO[] e_ar = e_dao.getList();
		
		mv.addObject("e_ar", e_ar);
		
		mv.setViewName("emp_list");
		
		return mv;
	}
	
}
