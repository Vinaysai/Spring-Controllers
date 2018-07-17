package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.StudentCommand;
import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

public class StudentUpdateController extends SimpleFormController {
	private StudentService service;

	public void setService(StudentService service) {
		this.service = service;
	}
	@Override
	protected Object formBackingObject(HttpServletRequest req) throws Exception {
		int sno;
		StudentDTO dto=null;
		StudentCommand cmd=null;
		//read sno
		
		sno=Integer.parseInt(req.getParameter("id"));
		
		//use service
		dto=service.getStudent(sno);
		cmd=new StudentCommand();
		cmd.setSno(dto.getSno());
		cmd.setSname(dto.getSname());
		cmd.setSadd(dto.getSadd());
		
		
		
		return cmd;
	}
	@Override
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse res, Object command,
			BindException errors) throws Exception {
		StudentCommand cmd=null;
		StudentDTO dto=null;
		String result=null;
		//type casting
		cmd=(StudentCommand)command;
		//convert command to dto
		dto=new StudentDTO();
		dto.setSno(cmd.getSno());
		dto.setSname(cmd.getSname());
		dto.setSadd(cmd.getSadd());
		//use Service 
		result=service.update(dto);
		return new ModelAndView("liststudents","Result",result);
	}
}
