package com.nt.dao;

import java.util.List;

import com.nt.bo.StudentBO;
import com.nt.dto.StudentDTO;

public interface StudentDAO {
	public List<StudentBO> listStudents();
	public int insertStudent(StudentBO bo);
	public StudentBO getStudent(int no);
	public int updateStudentBySno(StudentBO bo);
	public int delete(int no);

}
