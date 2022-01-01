package com.lis.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.lis.projects.entity.TypeOfDiagnostic;

@Repository
public interface DiagnosticRepository extends JpaRepository<TypeOfDiagnostic, Long>,
        PagingAndSortingRepository<TypeOfDiagnostic, Long> {
}
