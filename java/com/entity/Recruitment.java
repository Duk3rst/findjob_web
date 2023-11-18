package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recruitment")
public class Recruitment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "create_at")
    private String create_at;
    
    @Column(name = "deadline")
    private String deadline;
    
    @Column(name = "descript")	
    private String descript;
    
    @Column(name = "experience")
    private String experience;
    
    @Column(name = "quantity")
    private int quantity;
    
    @Column(name = "salary")
    private String salary;
    
    @Column(name = "status")
    private int status;
    
    @Column(name = "tittle")
    private String tittle;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;
    
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "recruitment")
    private List<Save_job> save_jobs;

	public Recruitment(int id, String address, String create_at, String deadline, String descript, String experience,
			int quantity, String salary, int status, String tittle, Company company, Category category,
			List<Save_job> save_jobs) {
		super();
		this.id = id;
		this.address = address;
		this.create_at = create_at;
		this.deadline = deadline;
		this.descript = descript;
		this.experience = experience;
		this.quantity = quantity;
		this.salary = salary;
		this.status = status;
		this.tittle = tittle;
		this.company = company;
		this.category = category;
		this.save_jobs = save_jobs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreate_at() {
		return create_at;
	}

	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Save_job> getSave_jobs() {
		return save_jobs;
	}

	public void setSave_jobs(List<Save_job> save_jobs) {
		this.save_jobs = save_jobs;
	}
    
    public Recruitment() {
    	
    }
}
