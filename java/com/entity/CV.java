package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cv")
public class CV {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "filename")
    private String filename;
    
    @OneToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User users;

	public CV(int id, String filename, User users) {
		super();
		this.id = id;
		this.filename = filename;
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "CV [id=" + id + ", filename=" + filename + ", cvs=" + users + "]";
	}
    
   public CV() {
	   
   }
}
