package com.lis.projects.repository;

import com.lis.projects.entity.TypeOfDiagnostic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticRepository extends JpaRepository<TypeOfDiagnostic, Long>, PagingAndSortingRepository<TypeOfDiagnostic, Long> {
    @Override
    Page<TypeOfDiagnostic> findAll(Pageable pageable);
}
