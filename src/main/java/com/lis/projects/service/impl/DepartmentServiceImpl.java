package com.lis.projects.service.impl;

import com.lis.projects.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import com.lis.projects.repository.DepartmentRepository;
import com.lis.projects.service.EntityService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class DepartmentServiceImpl implements EntityService<com.lis.projects.entity.Department> {
    private DepartmentRepository repository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Department> getAll() {
        return repository.findAll(Sort.by("name"));
    }

    public Collection<Department> getByName(String name) { return repository.findAllByName(Sort.by("name"), name); }

    @Override
    public com.lis.projects.entity.Department getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public com.lis.projects.entity.Department save(com.lis.projects.entity.Department department) {
        return repository.save(department);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
