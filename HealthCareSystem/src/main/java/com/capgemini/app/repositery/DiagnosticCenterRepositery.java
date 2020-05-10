package com.capgemini.app.repositery;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.app.entity.DiagnosticCenter;

@Repository
public interface DiagnosticCenterRepositery extends JpaRepository<DiagnosticCenter,Long> {
	
}
