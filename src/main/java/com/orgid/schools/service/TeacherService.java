/**
 * 
 */
package com.orgid.schools.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgid.schools.dao.TeacherDao;
import com.orgid.schools.model.Teacher;
import com.orgid.schools.repository.TeacherRepository;
import com.orgid.schools.vo.TeacherVo;

/**
 * @author Jawahar Dath Thangirala
 * Jan 10, 2020
 */
@Service
@Transactional
public class TeacherService {

	@Autowired
	private TeacherDao teacherDao;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	/**
	 * @param teacherVo
	 * @return
	 */
	public List<TeacherVo> getTeacher(TeacherVo vo) {
		
		return teacherDao.getTeacher(vo);
	}

	/**
	 * @param teacherid
	 * @return
	 */
	public boolean existsByteacherid(String teacherid) {
		return teacherRepository.existsByteacherid(teacherid);
	}

	/**
	 * @param teacher
	 * @return
	 */
	public Teacher insertTeacher(Teacher teacher) {		
		return teacherRepository.save(teacher);
	}

}
