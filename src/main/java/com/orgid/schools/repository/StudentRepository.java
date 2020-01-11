/**
 * 
 */
package com.orgid.schools.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.orgid.schools.model.Student;

/**
 * @author Jawahar Dath Thangirala
 * Jan 7, 2020
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	    
//    @Query("SELECT x FROM Student x ORDER BY x.firstname, x.lastname")
//    Page<Student> findAllOrderByName(Pageable pageable);
    
    @Query("SELECT x FROM Student x ORDER BY x.firstname, x.lastname")
    List<Student> findAllOrderByName(Pageable pageable);

	/**
	 * @param studentid
	 * @return
	 */
	Boolean existsBystudentid(String studentid);

	Optional<Student> findById(Long id);
	
	List<Student> findUserById(Long id, Pageable pageable);
}
