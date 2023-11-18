package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Applypost")
public class ApplyPost {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "created_at")
    private String created_at;
    
    @Column(name = "name_cv")
    private String name_cv;
    
    @Column(name="status")
    private int status;
    
    @Column(name = "text")
    private String text;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private User users;
    
    @ManyToOne
    @JoinColumn(name="recruiment_id")
    private Recruitment recruitment;

	public ApplyPost(int id, String created_at, String name_cv, int status, String text, User users,
			Recruitment recruitment) {
		super();
		this.id = id;
		this.created_at = created_at;
		this.name_cv = name_cv;
		this.status = status;
		this.text = text;
		this.users = users;
		this.recruitment = recruitment;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getName_cv() {
		return name_cv;
	}

	public void setName_cv(String name_cv) {
		this.name_cv = name_cv;
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

	public Recruitment getRecruitment() {
		return recruitment;
	}

	public void setRecruitment(Recruitment recruitment) {
		this.recruitment = recruitment;
	}
    
    public ApplyPost() {
    	
    }
}
