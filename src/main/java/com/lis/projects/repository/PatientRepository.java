package com.lis.projects.repository;

import com.lis.projects.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>, PagingAndSortingRepository<Patient, Long> {
    @Override
    Page<Patient> findAll(Pageable pageable);
}
