package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.entity.Save_job;
import com.repository.savejobRepository;

@Service
@Component(value = "savejobservice")
public class savejobService {
	
	@Autowired 
	private savejobRepository save_jobRepository;
	
	public List<Save_job> gsave_jobs(){
		return save_jobRepository.findAll();
	}
	
}
