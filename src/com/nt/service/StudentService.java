package com.nt.service;

import java.util.List;

import com.nt.dto.StudentDTO;

public interface StudentService {
	public List<StudentDTO> listStudents();
	public String register(StudentDTO dto);
	public StudentDTO getStudent(int no);
	public String update(StudentDTO dto);
	public String delete(int no);
}
