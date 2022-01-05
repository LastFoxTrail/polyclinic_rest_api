package com.lis.projects.repository;

import com.lis.projects.entity.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long>, PagingAndSortingRepository<Position, Long> {
    @Override
    Page<Position> findAll(Pageable pageable);
}
