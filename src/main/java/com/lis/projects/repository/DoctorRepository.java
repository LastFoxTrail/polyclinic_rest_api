package com.lis.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.lis.projects.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>,
        PagingAndSortingRepository<Doctor, Long> {
}