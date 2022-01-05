package com.lis.projects.repository;

import com.lis.projects.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>, PagingAndSortingRepository<Department, Long> {
    Page<Department> findAllByName(String name, Pageable pageable);
    @Override
    Page<Department> findAll(Pageable pageable);
}