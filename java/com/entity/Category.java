package com.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "num_choose")
    private int num_choose;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    private List<Recruitment> recruitments;



	public List<Recruitment> getRecruitments() {
		return recruitments;
	}

	public void setRecruitments(List<Recruitment> recruitments) {
		this.recruitments = recruitments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum_choose() {
		return num_choose;
	}

	public void setNum_choose(int num_choose) {
		this.num_choose = num_choose;
	}
	
	public Category() {
		super();
	}

	public Category(int id, String name, int num_choose, List<Recruitment> recruitments) {
		super();
		this.id = id;
		this.name = name;
		this.num_choose = num_choose;
		this.recruitments = recruitments;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", num_choose=" + num_choose + ", recruitments=" + recruitments
				+ "]";
	}


}
