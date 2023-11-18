package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.CV;
@Repository("cvrepository")
public interface CVRepository extends JpaRepository<CV, Integer> {
	CV findById (int id);
}
