package com.capgemini.app.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.app.entity.Test;

@Repository
public interface TestRepositery extends JpaRepository<Test,Long>{
	
}
