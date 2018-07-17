package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.service.StudentService;

public class StudentDeleteController extends AbstractController {
	private StudentService service;
	
	public void setService(StudentService service) {
		this.service = service;
	}

/*	@Override
	protected ModelAndView handle(HttpServletRequest req, HttpServletResponse res, Object arg2, BindException arg3)
			throws Exception {
		int no=0;
		String delMsg=null;
		//getting request data
		no=Integer.parseInt(req.getParameter("id"));
		System.out.println(no);
		//use service
		delMsg=service.delete(no);
		return new ModelAndView("delete_result","delResult",delMsg);
	}
	
*/	
	/*@Override
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse res, Object command,
			BindException errors) throws Exception {
		int no=0;
		String delMsg=null;
		//getting request data
		no=Integer.parseInt(req.getParameter("id"));
		System.out.println(no);
		//use service
		delMsg=service.delete(no);
		return new ModelAndView("delete_result","delResult",delMsg);
	
	}
*/
@Override
protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
	int no=0;
	String result=null;
	//getting request data
	no=Integer.parseInt(req.getParameter("id"));
	System.out.println(no);
	//use service
	result=service.delete(no);
	return new ModelAndView("liststudents","Result",result);	
}
	
}
