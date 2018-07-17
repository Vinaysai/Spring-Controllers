package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {
	private StudentDAO dao;
	
	public void setDao(StudentDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<StudentDTO> listStudents() {
		List<StudentBO> listBO=null;
		List<StudentDTO> listDTO=null;
		StudentDTO dto=null;
		listBO=dao.listStudents();
		//converting listbo to listdto
		listDTO=new ArrayList<StudentDTO>();
		for(StudentBO bo:listBO)
		{
			dto=new StudentDTO();
			dto.setSno(bo.getSno());
			dto.setSname(bo.getSname());
			dto.setSadd(bo.getSadd());
			listDTO.add(dto);
		}
		return listDTO;
	}

	@Override
	public String register(StudentDTO dto) {
		StudentBO bo=null;
		String result=null;
		int cnt=0;
		//convert dto to bo
		bo=new StudentBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setSadd(dto.getSadd());
		//use dao
		cnt=dao.insertStudent(bo);
		if(cnt==0)
			return "Student Registration Failed";
		else
			return "Student Registration Success";
	}

	@Override
	public StudentDTO getStudent(int no) {
		StudentDTO dto=null;
		StudentBO bo=null;

		//use dao
		bo=dao.getStudent(no);
		
		//convert bo to dto
		dto=new StudentDTO();
		dto.setSno(bo.getSno());
		dto.setSname(bo.getSname());
		dto.setSadd(bo.getSadd());
		
		return dto;
	}

	@Override
	public String update(StudentDTO dto) {
		StudentBO bo=null;
		int cnt=0;
		//convert dto to bo
		bo=new StudentBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setSadd(dto.getSadd());
		
		//use dao
		cnt=dao.updateStudentBySno(bo);
		if(cnt==0)
			return "Student Updation Failed";
		else
			return "Student Updation Success";
	}

	@Override
	public String delete(int no) {
		int cnt=0;
		cnt=dao.delete(no);
		if(cnt==0)
			return "Student Record Not Deleted";
		else
			return "Student Record Deleted";
	}

}
