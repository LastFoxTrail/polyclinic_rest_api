package com.lis.projects.repository;

import com.lis.projects.entity.Education;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long>, PagingAndSortingRepository<Education, Long> {
    @Override
    Page<Education> findAll(Pageable pageable);
}