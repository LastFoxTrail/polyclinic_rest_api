package com.lis.projects.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.lis.projects.repository.DoctorRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.lis.projects.service.EntityService;
import java.util.Collection;

@Service
public class DoctorServiceImpl implements EntityService<com.lis.projects.entity.Doctor> {
    private DoctorRepository repository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        repository = doctorRepository;
    }

    @Override
    public Collection<com.lis.projects.entity.Doctor> getAll() {
        return repository.findAll(Sort.by("department"));
    }

    @Override
    public com.lis.projects.entity.Doctor getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public com.lis.projects.entity.Doctor save(com.lis.projects.entity.Doctor doctor) {
        return repository.save(doctor);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
