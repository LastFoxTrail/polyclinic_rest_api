package com.lis.projects.service.impl;

import com.lis.projects.entity.Position;
import com.lis.projects.repository.PositionRepository;
import com.lis.projects.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class PositionServiceImpl implements EntityService<Position> {
    private final PositionRepository REPOSITORY;

    @Autowired
    public PositionServiceImpl(PositionRepository repository) {
        this.REPOSITORY = repository;
    }

    @Override
    public Collection<Position> getAll() {
        return REPOSITORY.findAll();
    }

    @Override
    public Position getById(Long id) {
        return REPOSITORY.findById(id).orElse(null);
    }

    @Override
    public Position save(Position position) {
        return REPOSITORY.save(position);
    }

    @Override
    public void deleteById(Long id) {
        REPOSITORY.deleteById(id);
    }

    public Page<Position> getAll(Pageable pageable) { return REPOSITORY.findAll(pageable);}
}