package com.lis.projects.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.lis.projects.repository.PatientRepository;
import com.lis.projects.service.EntityService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.lis.projects.entity.Patient;
import java.util.Collection;

@Service
public class PatientServiceImpl implements EntityService<com.lis.projects.entity.Patient> {
    private PatientRepository repository;

    @Autowired
    public PatientServiceImpl(PatientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Patient> getAll() {
        return repository.findAll(Sort.by("firstName"));
    }

    @Override
    public Patient getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Patient save(Patient patient) {
        return repository.save(patient);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
