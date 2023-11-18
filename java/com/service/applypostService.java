package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.entity.ApplyPost;
import com.repository.ApplyPostRepository;

@Service
@Component(value = "applypostservice")
public class applypostService {
	
	@Autowired
	private ApplyPostRepository applypostrepository;
	
	@Transactional
	public List<ApplyPost> applyPosts(){
		return applypostrepository.findAll();
	}
	
	@Transactional
	public void saveApplypost(ApplyPost applypost) {
		applypostrepository.save(applypost);
	}
}
