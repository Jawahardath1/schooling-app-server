/**
 * 
 */
package com.orgid.schools.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.orgid.schools.vo.TeacherVo;

/**
 * @author Jawahar Dath Thangirala
 * Jan 10, 2020
 */
@Mapper
public interface TeacherDao {
	
	/**
	 * @param vo
	 * @return
	 */
	public List<TeacherVo> getTeacher(TeacherVo vo);

	public int updateTeacher(TeacherVo vo);
}
