package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	private JdbcTemplate jt;
	private static final String GET_ALL_STUDENTS_QRY="SELECT SNO,SNAME,SADD FROM STUDENT3";
	private static final String INSERT_STUDENT_QRY="INSERT INTO STUDENT3 VALUES(?,?,?)";
	private static final String GET_STUDENT_DETAILS="SELECT SNO,SNAME,SADD FROM STUDENT3 WHERE SNO=?";
	private static final String UPDATE_STUDENT_QRY="UPDATE STUDENT3 SET SNAME=?,SADD=? WHERE SNO=?";
	private static final String DELETE_STUDET_QRY="DELETE FROM STUDENT3 WHERE SNO=?";
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}



	@Override
	public List<StudentBO> listStudents() {
		List<StudentBO> listBO=null;
		listBO=jt.query(GET_ALL_STUDENTS_QRY, new StudentRowMapper());
		return listBO;
	}
	
	public class StudentRowMapper implements RowMapper<StudentBO>
	{

		@Override
		public StudentBO mapRow(ResultSet rs, int pos) throws SQLException {
			StudentBO bo=null;
			bo=new StudentBO();
			bo.setSno(rs.getInt(1));
			bo.setSname(rs.getString(2));
			bo.setSadd(rs.getString(3));
			
			return bo;
		}
		
	}

	@Override
	public int insertStudent(StudentBO bo) {
		int result=0;
		
		result=jt.update(INSERT_STUDENT_QRY, bo.getSno(),bo.getSname(),bo.getSadd());
		return result;
	}



	@Override
	public StudentBO getStudent(int no) {
		StudentBO bo=null;
		bo=jt.queryForObject(GET_STUDENT_DETAILS,  new StudentRowMapper(),no);
		return bo;
	}


	@Override
	public int  updateStudentBySno(StudentBO bo) {
		int cnt=0;
		cnt=jt.update(UPDATE_STUDENT_QRY,bo.getSname(),bo.getSadd(),bo.getSno());
		return cnt;
	}



	@Override
	public int delete(int no) {
		int cnt=0;
		cnt=jt.update(DELETE_STUDET_QRY, no);
		return cnt;
	}

}
