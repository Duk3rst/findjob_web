package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Folow_company;

@Repository("followcompanyRepository")
public interface followcompanyRepository extends JpaRepository<Folow_company, Integer> {

}
