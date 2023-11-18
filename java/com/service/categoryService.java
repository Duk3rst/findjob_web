package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.entity.Category;
import com.repository.categoryRepository;

@Service
@Component(value = "categoryService")
public class categoryService {
    
	@Autowired
    private categoryRepository categoryrepository; 
	
	@Transactional
	public List<Category> getCategories(){
		return categoryrepository.findAll();
	}
	
	@Transactional
	public Category findcatebyid(int id) {
		return categoryrepository.findById(id);
	}
}
