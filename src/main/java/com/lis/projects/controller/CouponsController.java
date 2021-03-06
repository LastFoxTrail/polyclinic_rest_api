package com.lis.projects.controller;

import com.lis.projects.entity.Coupon;
import com.lis.projects.exception.EmptyCollectionException;
import com.lis.projects.exception.EntityNotFoundException;
import com.lis.projects.exception.UndefinedRequestBodyException;
import com.lis.projects.service.impl.CouponServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/coupons")
public class CouponsController {
    private final CouponServiceImpl COUPON_SERVICE;

    @Autowired
    public CouponsController(CouponServiceImpl COUPON_SERVICE) {
        this.COUPON_SERVICE = COUPON_SERVICE;
    }

    @GetMapping
    public ResponseEntity<List<Coupon>> getAll(
            @PageableDefault(value = 0, size = 2, sort = {"dateOfReceipt"}) Pageable pageable) {
        Page<Coupon> coupons = COUPON_SERVICE.getAll(pageable);

        if (coupons.getContent().size() == 0) {
            throw new EmptyCollectionException("Coupon collection contains no items");
        }

        return new ResponseEntity<>(coupons.getContent(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coupon> getById(@PathVariable Long id) {
        Coupon coupon = COUPON_SERVICE.getById(id);

        if (coupon == null) {
            throw new EntityNotFoundException("There is no coupon with id="+ id);
        }

        return new ResponseEntity<>(coupon, HttpStatus.OK);
    }

    @GetMapping("/{patientId}/all")
    public ResponseEntity<List<Coupon>> getByPatientId(@PathVariable Long patientId,
                                                       @PageableDefault(
                                                               value = 0,
                                                               size = 2,
                                                               sort = {"dateOfReceipt"}) Pageable pageable) {
        Page<Coupon> coupons = COUPON_SERVICE.getAllByPatientId(patientId, pageable);

        if (coupons.getContent().size() == 0) {
            throw new EmptyCollectionException("Patient has no registered coupons");
        }

        return new ResponseEntity<>(coupons.getContent(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Coupon> add(@RequestBody Coupon coupon) {

        if (coupon == null) {
            throw new UndefinedRequestBodyException("Requested body is not recognized");
        }

        return new ResponseEntity<>(COUPON_SERVICE.save(coupon), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Coupon> update(@RequestBody Coupon coupon) {

        if (coupon == null) {
            throw new UndefinedRequestBodyException("Requested body is not recognized");
        }

        return new ResponseEntity<>(COUPON_SERVICE.save(coupon), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        COUPON_SERVICE.deleteById(id);
    }
}