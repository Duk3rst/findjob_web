package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Company;


@Repository("Companyrepository")
public interface CompanyRepository extends JpaRepository<Company, Integer>{
	Company findById(int id);
	
	@Query(value = "SELECT * from asm02.company WHERE name_company LIKE %:keyword% ", nativeQuery = true)
	public List<Company> search(@Param("keyword") String keyword);
}
