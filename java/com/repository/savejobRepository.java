package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Save_job;

@Repository(value = "savejobRepository")
public interface savejobRepository extends JpaRepository<Save_job, Integer> {

}
