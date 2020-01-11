/**
 * 
 */
package com.orgid.schools.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgid.schools.dao.StudentDao;
import com.orgid.schools.model.Student;
import com.orgid.schools.payload.StudentRequest;
import com.orgid.schools.repository.StudentRepository;
import com.orgid.schools.vo.StudentVo;

/**
 * @author Jawahar Dath Thangirala
 * Jan 8, 2020
 */
@Service
@Transactional
public class StudentService {
	
	private static final int PAGE = 0;
	private static final int PAGE_SIZE = 10;

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentDao studentDao;
	
//	public Page<Student> findAll(Pageable pageable) {
//        return studentRepository.findAllOrderByName(pageable);
//    }
	
	public List<Student> findAll() {
        return studentRepository.findAllOrderByName(PageRequest.of(PAGE, PAGE_SIZE));
    }
	
	public Optional<Student> findById(Long id) {			
		return studentRepository.findById(id);
	}
	
	public List<Student> findUserById(Long id) {
		return studentRepository.findUserById(id, PageRequest.of(PAGE, PAGE_SIZE) );
	}
	
	public Student create(StudentRequest studentRequest) {
		
		Student student = new Student();
		student.setStudentid(studentRequest.getStudentid());
		student.setFirstname(studentRequest.getFirstname());
		student.setLastname(studentRequest.getLastname());
		student.setMiddlename(studentRequest.getMiddlename());
		student.setAddress(studentRequest.getAddress());
		student.setCity(studentRequest.getCity());
		student.setZipcode(studentRequest.getZipcode());
		student.setCountry(studentRequest.getCountry());
		
        return studentRepository.save(student);
    }

	/**
	 * @param studentid
	 * @return
	 */
	public boolean existsBystudentid(String studentid) {
		return studentRepository.existsBystudentid(studentid);
	}

	/**
	 * @param vo
	 * @return
	 */
	public List<StudentVo> getStudentInfo(StudentVo vo) {
		return studentDao.getStudent(vo);
	}

	/**
	 * @param student
	 * @return
	 */
	public Student insertStudent(Student student) {		
		return studentRepository.save(student);
	}

	/**
	 * @param student
	 * @return
	 */
	public int updateStudent(StudentVo vo) {		
		return studentDao.updateStudent(vo);
	}
	
}
