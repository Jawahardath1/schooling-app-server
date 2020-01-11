package com.orgid.schools.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.orgid.schools.vo.StudentVo;

/**
 * 
 * @author Jawahar Dath Thangirala
 * Jan 9, 2019
 */

@Mapper
public interface StudentDao {
	// public StudentVo getStudent(StudentVo vo);
	
	public List<StudentVo> getStudent(StudentVo vo);
	
	//public List<StudentVo> getUserList(StudentVo vo);

	//public int insertUser(StudentVo vo);
	
	public int updateStudent(StudentVo vo);
	
	//public int deleteUser(StudentVo vo);

}
