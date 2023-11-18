package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.entity.Folow_company;
import com.repository.followcompanyRepository;

@Service
@Component(value = "followcompanyservice")
public class followcompanyService {
	@Autowired
	private followcompanyRepository followcompanyrepository;
	
	@Transactional
	public List<Folow_company> gFolow_companies(){
		return followcompanyrepository.findAll();
	}
	
	@Transactional
	 public void savefolowcompa(Folow_company folow_company) {
		followcompanyrepository.save(folow_company);
	}
}
