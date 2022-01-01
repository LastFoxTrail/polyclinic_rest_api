package com.lis.projects.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.lis.projects.repository.PositionRepository;
import com.lis.projects.service.EntityService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class PositionServiceImpl implements EntityService<com. lis.projects.entity.Position> {
    private PositionRepository repository;

    @Autowired
    public PositionServiceImpl(PositionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<com.lis.projects.entity.Position> getAll() {
        return repository.findAll(Sort.by("name"));
    }

    @Override
    public com.lis.projects.entity.Position getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public com.lis.projects.entity.Position save(com.lis.projects.entity.Position position) {
        return repository.save(position);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}