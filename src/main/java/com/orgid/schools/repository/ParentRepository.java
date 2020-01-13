package com.orgid.schools.repository;

import com.orgid.schools.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jawahar Dath Thangirala
 * 1/13/2020
 */
@Repository
public interface ParentRepository extends JpaRepository<Parent, Long>  {
    Boolean existsByparentid(String parentid);
}
