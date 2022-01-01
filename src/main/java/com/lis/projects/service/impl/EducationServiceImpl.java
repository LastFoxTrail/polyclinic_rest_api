package com.lis.projects.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.lis.projects.repository.EducationRepository;
import com.lis.projects.service.EntityService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.lis.projects.entity.Education;
import java.util.Collection;

@Service
public class EducationServiceImpl implements EntityService<com.lis.projects.entity.Education> {
    private EducationRepository repository;

    @Autowired
    public EducationServiceImpl(EducationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Education> getAll() {
        return repository.findAll(Sort.by("name"));
    }

    @Override
    public Education getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Education save(Education education) {
        return repository.save(education);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
