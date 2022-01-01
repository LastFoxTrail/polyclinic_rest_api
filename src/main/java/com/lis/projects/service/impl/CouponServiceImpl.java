package com.lis.projects.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.lis.projects.repository.CouponRepository;
import com.lis.projects.service.EntityService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.lis.projects.entity.Coupon;
import java.util.Collection;

@Service
public class CouponServiceImpl implements EntityService<com.lis.projects.entity.Coupon> {
    private CouponRepository repository;

    @Autowired
    public CouponServiceImpl(CouponRepository repository) {
        this.repository = repository;
    }

    public Collection<Coupon> getAllByPatientId(Long id) {
        return repository.findByPatientId(Sort.by("dateOfReceipt"), id);
    }
    
    @Override
    public Collection<Coupon> getAll() {
        return repository.findAll(Sort.by("dateOfReceipt"));
    }

    @Override
    public Coupon getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Coupon save(Coupon coupon) {
        return repository.save(coupon);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}