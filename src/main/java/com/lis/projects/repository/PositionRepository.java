package com.lis.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.lis.projects.entity.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long>,
        PagingAndSortingRepository<Position, Long> {
}
