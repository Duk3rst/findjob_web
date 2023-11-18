package com.entity;

import java.util.Set;

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
@Table(name = "user")
public class User {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "descript")
    private String descript;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "fullname")
    private String fullname;
    
    @Column(name = "image")
    private String image;
    
    @Column(name = "password")
    private String password;
    
    @Column(name="phone")
    private String phone;
    
    @Column(name = "status") //(0 ngung hoat dong , 1 hoat dong) 
    private int status;
    
    @ManyToOne
    @JoinColumn(name="role_id") 
    private Role role;
    
    @OneToOne(mappedBy = "users")
    private CV CVlists;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "users")
    private Set<ApplyPost> listapplyPosts;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "users")
    private Company company;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "users")
    private Set<Save_job> save_jobs;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Folow_company> fList;

    public User() {

	}

	public User(String address, String descript, String email, String fullname, String image, String password,
			String phone, int status, Role role, CV cVlists, Set<ApplyPost> listapplyPosts, Company company,
			Set<Save_job> save_jobs, Set<Folow_company> fList) {
		this.address = address;
		this.descript = descript;
		this.email = email;
		this.fullname = fullname;
		this.image = image;
		this.password = password;
		this.phone = phone;
		this.status = status;
		this.role = role;
		CVlists = cVlists;
		this.listapplyPosts = listapplyPosts;
		this.company = company;
		this.save_jobs = save_jobs;
		this.fList = fList;
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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	

	public Company getCompany() {
		return company;
	}



	public void setCompany(Company company) {
		this.company = company;
	}


	public Set<Folow_company> getfList() {
		return fList;
	}

	public void setfList(Set<Folow_company> fList) {
		this.fList = fList;
	}


	public CV getCVlists() {
		return CVlists;
	}

	public void setCVlists(CV cVlists) {
		CVlists = cVlists;
	}

	public Set<ApplyPost> getListapplyPosts() {
		return listapplyPosts;
	}

	public void setListapplyPosts(Set<ApplyPost> listapplyPosts) {
		this.listapplyPosts = listapplyPosts;
	}

	public Set<Save_job> getSave_jobs() {
		return save_jobs;
	}

	public void setSave_jobs(Set<Save_job> save_jobs) {
		this.save_jobs = save_jobs;
	}
    
    
}
