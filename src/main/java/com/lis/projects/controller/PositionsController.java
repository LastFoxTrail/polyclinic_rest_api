package com.lis.projects.controller;

import com.lis.projects.entity.Position;
import com.lis.projects.exception.EmptyCollectionException;
import com.lis.projects.exception.EntityNotFoundException;
import com.lis.projects.exception.GetDoubleArgumentException;
import com.lis.projects.exception.UndefinedRequestBodyException;
import com.lis.projects.service.impl.PositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/positions")
public class PositionsController {
    private final PositionServiceImpl POSITION_SERVICE;

    @Autowired
    public PositionsController(PositionServiceImpl POSITION_SERVICE) {
        this.POSITION_SERVICE = POSITION_SERVICE;
    }

    @GetMapping
    public ResponseEntity<List<Position>> getAll(@PageableDefault(
            value = 0,
            size = 2,
            sort = {"name"}) Pageable pageable) {

        Page<Position> positions = POSITION_SERVICE.getAll(pageable);

        if (positions.getContent().size() == 0) {
            throw new EmptyCollectionException("Position collection contains no items");
        }

        return new ResponseEntity<>(positions.getContent(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Position> getById(@PathVariable Long id) {
        Position position = POSITION_SERVICE.getById(id);

        if (position == null) {
            throw new EntityNotFoundException("There is no position with id="+ id);
        }

        return new ResponseEntity<>(position, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Position> add(@RequestBody Position position) {
        List<Position> positions = new ArrayList<>(POSITION_SERVICE.getAll());

        if (position == null) {
            throw new UndefinedRequestBodyException("Requested body is not recognized");

        } else if (positions.contains(position)) {
            throw new GetDoubleArgumentException("The record of such position already exists in the system");
        }

        return new ResponseEntity<>(POSITION_SERVICE.save(position), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Position> update(@RequestBody Position position) {

        if (position == null) {
            throw new UndefinedRequestBodyException("Requested body is not recognized");
        }

        return new ResponseEntity<>(POSITION_SERVICE.save(position), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        POSITION_SERVICE.deleteById(id);
    }
}