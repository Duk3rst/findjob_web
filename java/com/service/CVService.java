package com.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.entity.CV;
import com.repository.CVRepository;

@Service
@Component(value = "cvservice")
public class CVService {
	@Autowired
	private CVRepository cvRepository;
	
	@Transactional
	public CV findbyid(int id) {
		return cvRepository.findById(id);
	}
	@Transactional
	public void saveCV(CV cv){
		cvRepository.save(cv);
	}
}