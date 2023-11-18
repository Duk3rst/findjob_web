package com.repository;

import java.util.List;

import com.entity.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository("recruitmentrepository")
public interface RecruitmentRepository extends JpaRepository<Recruitment, Integer>{
	
	@Query(value = "SELECT * from asm02.recruitment WHERE tittle LIKE %:keyword% ", nativeQuery = true)
	public List<Recruitment> search(@Param("keyword") String keyword);
	
	
	@Query(value = "SELECT * from asm02.recruitment WHERE address LIKE %:keyword% ", nativeQuery = true)
	public List<Recruitment> search1(@Param("keyword") String keyword);
	
	Recruitment findById (int id);
}
