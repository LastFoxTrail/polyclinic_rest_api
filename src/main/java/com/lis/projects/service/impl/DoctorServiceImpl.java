package com.lis.projects.service.impl;

import com.lis.projects.entity.Doctor;
import com.lis.projects.repository.DoctorRepository;
import com.lis.projects.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class DoctorServiceImpl implements EntityService<Doctor> {
    private final DoctorRepository REPOSITORY;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        REPOSITORY = doctorRepository;
    }

    @Override
    public Collection<Doctor> getAll() { return REPOSITORY.findAll(); }

    @Override
    public Doctor getById(Long id) {
        return REPOSITORY.findById(id).orElse(null);
    }

    @Override
    public Doctor save(Doctor doctor) {
        return REPOSITORY.save(doctor);
    }

    @Override
    public void deleteById(Long id) {
        REPOSITORY.deleteById(id);
    }

    public Page<Doctor> getAll(Pageable pageable) {
        return REPOSITORY.findAll(pageable);
    }
}
