package com.lis.projects.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.lis.projects.entity.Coupon;
import java.util.Collection;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long>, PagingAndSortingRepository<Coupon, Long> {
    Collection<Coupon> findByPatientId(Sort sort, Long id);
}