package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.StudentCommand;
import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

public class StudentInsertController extends SimpleFormController {

	private StudentService service;
	
	public void setService(StudentService service) {
		this.service = service;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse res, Object command,
			BindException errors) throws Exception {
		
		StudentCommand cmd=null;
		StudentDTO dto=null;
		String result=null;
		//type casting
		cmd=(StudentCommand)command;
		dto=new StudentDTO();
		dto.setSno(cmd.getSno());
		dto.setSname(cmd.getSname());
		dto.setSadd(cmd.getSadd());
		//use service
		result=service.register(dto);
		return new ModelAndView("liststudents","Result",result);
	}
	@Override
	protected ModelAndView handleInvalidSubmit(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		return new ModelAndView("dblpost");
	}
}
