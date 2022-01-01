package com.lis.projects.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.lis.projects.repository.DiagnosticRepository;
import com.lis.projects.entity.TypeOfDiagnostic;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.lis.projects.service.EntityService;
import java.util.Collection;

@Service
public class DiagnosticServiceImpl implements EntityService<com.lis.projects.entity.TypeOfDiagnostic> {
    private DiagnosticRepository repository;

    @Autowired
    public DiagnosticServiceImpl(DiagnosticRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<TypeOfDiagnostic> getAll() {
        return repository.findAll(Sort.by("typeName"));
    }

    @Override
    public TypeOfDiagnostic getById(Long id) {
        TypeOfDiagnostic type = repository.findById(id).orElse(null);

        return type;
    }

    @Override
    public TypeOfDiagnostic save(TypeOfDiagnostic diagnostic) {
        return repository.save(diagnostic);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
