package com.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.entity.Recruitment;
import com.repository.RecruitmentRepository;

@Service
@Component(value = "recruitmentservice")
public class recruitmentService {

	@Autowired
	private RecruitmentRepository recruitmentrepository;
	
	@Transactional
	public List<Recruitment> geRecruitments(){
		return recruitmentrepository.findAll();
	}
	
	@Transactional
	public List<Recruitment> seaList(String keyword){
		if(keyword!=null) {
			return recruitmentrepository.search(keyword);
		}
		return recruitmentrepository.findAll();
	}
	
	@Transactional
	public List<Recruitment> seaList2(String keyword){
		if(keyword!=null) {
			return recruitmentrepository.search1(keyword);
		}
		return recruitmentrepository.findAll();
	}
	
	@Transactional
	public Recruitment findbyid(int id) {
		return recruitmentrepository.findById(id);
	}
	
	@Transactional
	public void saverec(Recruitment rec) {
		recruitmentrepository.save(rec);
	}
	
	@Transactional
	public void updaterec(int id,String title,String descript,String exp,int quantity,String address,String deadline,String salary,int cat_id) {
		Recruitment recruitment = recruitmentrepository.findById(id);
		if (recruitment == null) {
			recruitment = new Recruitment();
		}
		recruitment.setTittle(title);
		recruitment.setDescript(descript);
		recruitment.setExperience(exp);
		recruitment.setQuantity(quantity);
		recruitment.setAddress(address);
		recruitment.setDeadline(deadline);
		recruitment.setSalary(salary);
		recruitment.setStatus(1);

		recruitmentrepository.save(recruitment);
		System.out.println("Update recruitment successfully");
	}
	
	@Transactional 
	public void delrec(int id) {
		recruitmentrepository.deleteById(id);
	}
}
