package com.entity;

import javax.persistence.*;

@Entity()
@Table(name = "role")
public class Role {
    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name="role_name")
    private String role_name;

    
    public Role(int id,String role_name){
        this.id=id;
        this.role_name=role_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_name() {
        return role_name;
    }
    
    public Role() {

	}

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role_name='" + role_name + 
                '}';
    }
}
