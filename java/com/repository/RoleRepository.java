package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Role;

@Repository("RoleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
