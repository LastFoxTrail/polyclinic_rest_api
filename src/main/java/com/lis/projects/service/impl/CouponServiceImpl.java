package com.lis.projects.service.impl;

import com.lis.projects.entity.Coupon;
import com.lis.projects.repository.CouponRepository;
import com.lis.projects.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class CouponServiceImpl implements EntityService<Coupon> {
    private final CouponRepository REPOSITORY;

    @Autowired
    public CouponServiceImpl(CouponRepository repository) {
        this.REPOSITORY = repository;
    }

    @Override
    public Collection<Coupon> getAll() { return REPOSITORY.findAll(); }

    @Override
    public Coupon getById(Long id) {
        return REPOSITORY.findById(id).orElse(null);
    }

    @Override
    public Coupon save(Coupon coupon) {
        return REPOSITORY.save(coupon);
    }

    @Override
    public void deleteById(Long id) {
        REPOSITORY.deleteById(id);
    }

    public Page<Coupon> getAll(Pageable pageable) {
        return REPOSITORY.findAll(pageable);
    }

    public Page<Coupon> getAllByPatientId(Long id, Pageable pageable) {
        return REPOSITORY.findByPatientId(id, pageable);
    }
}