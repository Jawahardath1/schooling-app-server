/**
 * 
 */
package com.orgid.schools.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orgid.schools.model.Teacher;


/**
 * @author Jawahar Dath Thangirala
 * Jan 10, 2020
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

	/**
	 * @param teacherid
	 * @return
	 */
	Boolean existsByteacherid(String teacherid);

}
