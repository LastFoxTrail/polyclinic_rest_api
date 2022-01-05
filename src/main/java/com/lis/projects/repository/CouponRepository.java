package com.lis.projects.repository;

import com.lis.projects.entity.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long>, PagingAndSortingRepository<Coupon, Long> {
    Page<Coupon> findByPatientId(Long id, Pageable pageable);
    @Override
    Page<Coupon> findAll(Pageable pageable);
}