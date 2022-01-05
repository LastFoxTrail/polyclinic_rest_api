package com.lis.projects.service.impl;

import com.lis.projects.entity.TypeOfDiagnostic;
import com.lis.projects.repository.DiagnosticRepository;
import com.lis.projects.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class DiagnosticServiceImpl implements EntityService<TypeOfDiagnostic> {
    private final DiagnosticRepository REPOSITORY;

    @Autowired
    public DiagnosticServiceImpl(DiagnosticRepository repository) {
        this.REPOSITORY = repository;
    }

    @Override
    public Collection<TypeOfDiagnostic> getAll() { return REPOSITORY.findAll(); }

    @Override
    public TypeOfDiagnostic getById(Long id) {
        TypeOfDiagnostic type = REPOSITORY.findById(id).orElse(null);

        return type;
    }

    @Override
    public TypeOfDiagnostic save(TypeOfDiagnostic diagnostic) {
        return REPOSITORY.save(diagnostic);
    }

    @Override
    public void deleteById(Long id) {
        REPOSITORY.deleteById(id);
    }

    public Page<TypeOfDiagnostic> getAll(Pageable pageable) {
        return REPOSITORY.findAll(pageable);
    }
}
