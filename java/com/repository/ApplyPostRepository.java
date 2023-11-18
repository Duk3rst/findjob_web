package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.ApplyPost;

@Repository("applypostrepository")
public interface ApplyPostRepository extends JpaRepository<ApplyPost, Integer> {

}
