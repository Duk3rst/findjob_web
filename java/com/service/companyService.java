package com.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.entity.Company;
import com.repository.CompanyRepository;

@Service
@Component("companyService")
public class companyService {
	
	@Autowired
	private CompanyRepository companyrepository;
	
	public List<Company> getCompanies(){
		return companyrepository.findAll();
	}
	public Company findById(int id) {
		return companyrepository.findById(id);
	}
	
	@Transactional
	public List<Company> seacomList(String keyword){
		if(keyword!=null) {
			return companyrepository.search(keyword);
		}
		return companyrepository.findAll();
	}
	
	@Transactional
	public void updatecompa(Company company, String email,String namecompa,String address,String phone,String descript) {
		if (company == null) {
			company = new Company();
		}
		
		company.setEmail(email);
		company.setName_company(namecompa);
		company.setAddress(address);
		company.setPhone(phone);
		company.setDescript(descript);

		companyrepository.save(company);
		System.out.println("Update Company successfully");
	}
}
