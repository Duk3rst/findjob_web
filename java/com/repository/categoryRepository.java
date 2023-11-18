package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Category;

@Repository("categoryrepository")
public interface categoryRepository extends JpaRepository<Category,Integer>{
	Category findById (int id);
}
