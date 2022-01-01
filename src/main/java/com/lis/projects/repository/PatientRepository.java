package com.lis.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lis.projects.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
