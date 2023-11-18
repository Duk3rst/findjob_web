package com.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name="address")
    private String address;
    
    @Column(name="descript")
    private String descript;
    
    @Column(name="email")
    private String email;
    
    @Column(name="logo")
    private String logo;
    
    @Column(name = "name_company")
    private String name_company;
    
    @Column(name="phone")
    private String phone;
    
    @Column(name="status")
    private int status;
    
    @OneToOne
    @JoinColumn(name="user_id")
    private User users;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "company")
    private Recruitment recruitment;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
    private Set<Folow_company> folow_companies;


	public Set<Folow_company> getFolow_companies() {
		return folow_companies;
	}

	public void setFolow_companies(Set<Folow_company> folow_companies) {
		this.folow_companies = folow_companies;
	}

	public Recruitment getRecruitment() {
		return recruitment;
	}

	public void setRecruitment(Recruitment recruitment) {
		this.recruitment = recruitment;
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

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public String getName_company() {
		return name_company;
	}

	public void setName_company(String name_company) {
		this.name_company = name_company;
	}

	
    public Company(int id, String address, String descript, String email, String logo, String name_company,
			String phone, int status, User users, Recruitment recruitment, Set<Folow_company> folow_companies) {
		super();
		this.id = id;
		this.address = address;
		this.descript = descript;
		this.email = email;
		this.logo = logo;
		this.name_company = name_company;
		this.phone = phone;
		this.status = status;
		this.users = users;
		this.recruitment = recruitment;
		this.folow_companies = folow_companies;
	}

	public Company() {
    	super();
    }
}
