package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

public class ListStudentsController extends AbstractController {
	
	private StudentService service;
	
	public void setService(StudentService service) {
		this.service = service;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav=null;
		List<StudentDTO> listDTO=null;
		HttpSession ses=null;
		
		listDTO=service.listStudents();
		
		mav=new ModelAndView();
		ses=req.getSession();
		mav.setViewName("liststudents");
		//mav.addObject("stList", listDTO);
		ses.setAttribute("stList", listDTO);
		
		return mav;
	}

}
