package com.lis.projects.service.impl;

import com.lis.projects.entity.Education;
import com.lis.projects.repository.EducationRepository;
import com.lis.projects.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class EducationServiceImpl implements EntityService<Education> {
    private final EducationRepository REPOSITORY;

    @Autowired
    public EducationServiceImpl(EducationRepository repository) {
        this.REPOSITORY = repository;
    }

    @Override
    public Collection<Education> getAll() { return REPOSITORY.findAll(); }

    @Override
    public Education getById(Long id) {
        return REPOSITORY.findById(id).orElse(null);
    }

    @Override
    public Education save(Education education) {
        return REPOSITORY.save(education);
    }

    @Override
    public void deleteById(Long id) {
        REPOSITORY.deleteById(id);
    }

    public Page<Education> getAll(Pageable pageable) { return REPOSITORY.findAll(pageable); }
}