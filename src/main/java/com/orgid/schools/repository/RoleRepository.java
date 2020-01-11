/**
 * 
 */
package com.orgid.schools.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orgid.schools.model.Role;
import com.orgid.schools.model.RoleName;

/**
 * @author Jawahar Dath Thangirala
 * Sep 9, 2019
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}