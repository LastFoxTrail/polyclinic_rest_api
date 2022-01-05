package com.lis.projects.repository;

import com.lis.projects.entity.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>, PagingAndSortingRepository<Doctor, Long> {
    @Override
    Page<Doctor> findAll(Pageable pageable);
}