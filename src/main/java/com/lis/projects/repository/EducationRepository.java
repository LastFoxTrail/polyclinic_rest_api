package com.lis.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.lis.projects.entity.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long>,
        PagingAndSortingRepository<Education, Long> {
}