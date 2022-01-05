package com.lis.projects.service.impl;

import com.lis.projects.entity.Department;
import com.lis.projects.repository.DepartmentRepository;
import com.lis.projects.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class DepartmentServiceImpl implements EntityService<Department> {
    private final DepartmentRepository REPOSITORY;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.REPOSITORY = repository;
    }

    @Override
    public Collection<Department> getAll() { return REPOSITORY.findAll(); }

    @Override
    public Department getById(Long id) {
        return REPOSITORY.findById(id).orElse(null);
    }

    @Override
    public Department save(Department department) {
        return REPOSITORY.save(department);
    }

    @Override
    public void deleteById(Long id) {
        REPOSITORY.deleteById(id);
    }

    public Page<Department> getAll(Pageable pageable) {
        return REPOSITORY.findAll(pageable);
    }

    public Page<Department> getByName(String name, Pageable pageable) { return REPOSITORY.findAllByName(name, pageable); }
}
