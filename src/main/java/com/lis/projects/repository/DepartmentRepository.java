package com.lis.projects.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.lis.projects.entity.Department;
import java.util.Collection;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>, PagingAndSortingRepository<Department, Long> {
    Collection<Department> findAllByName(Sort sort, String name);
}