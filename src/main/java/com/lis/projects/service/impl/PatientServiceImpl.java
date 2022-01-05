package com.lis.projects.service.impl;

import com.lis.projects.entity.Patient;
import com.lis.projects.repository.PatientRepository;
import com.lis.projects.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class PatientServiceImpl implements EntityService<Patient> {
    private final PatientRepository REPOSITORY;

    @Autowired
    public PatientServiceImpl(PatientRepository repository) {
        this.REPOSITORY = repository;
    }

    @Override
    public Collection<Patient> getAll() {
        return REPOSITORY.findAll();
    }

    @Override
    public Patient getById(Long id) {
        return REPOSITORY.findById(id).orElse(null);
    }

    @Override
    public Patient save(Patient patient) {
        return REPOSITORY.save(patient);
    }

    @Override
    public void deleteById(Long id) {
        REPOSITORY.deleteById(id);
    }

    public Page<Patient> getAll(Pageable pageable) { return REPOSITORY.findAll(pageable); }
}
