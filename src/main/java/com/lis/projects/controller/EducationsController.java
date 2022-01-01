package com.lis.projects.controller;

import com.lis.projects.exception.EmptyCollectionException;
import com.lis.projects.exception.EntityNotFoundException;
import com.lis.projects.exception.GetDoubleArgumentException;
import com.lis.projects.exception.UndefinedRequestBodyException;
import org.springframework.beans.factory.annotation.Autowired;
import com.lis.projects.service.impl.EducationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lis.projects.entity.Education;
import java.util.LinkedHashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/educations")
public class EducationsController {
    private final EducationServiceImpl EDUCATION_SERVICE;

    @Autowired
    public EducationsController(EducationServiceImpl EDUCATION_SERVICE) {
        this.EDUCATION_SERVICE = EDUCATION_SERVICE;
    }

    @GetMapping
    public ResponseEntity<Set<Education>> getAll() {
        Set<Education> educations = new LinkedHashSet<>(EDUCATION_SERVICE.getAll());

        if (educations.size() == 0) {
            throw new EmptyCollectionException("Education collection contains no items");
        }

        return new ResponseEntity<>(educations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Education> getById(@PathVariable Long id) {
        Education education = EDUCATION_SERVICE.getById(id);

        if (education == null) {
            throw new EntityNotFoundException("There is no education with id="+ id);
        }

        return new ResponseEntity<>(education, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Education> add(@RequestBody Education education) {
        Set<Education> educations = new LinkedHashSet<>(EDUCATION_SERVICE.getAll());

        if (education == null) {
            throw new UndefinedRequestBodyException("Requested body is not recognized");

        } else if (educations.contains(education)) {
            throw new GetDoubleArgumentException("The record of such education already exists in the system");
        }

        return new ResponseEntity<>(EDUCATION_SERVICE.save(education), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Education> update(@RequestBody Education education) {

        if (education == null) {
            throw new UndefinedRequestBodyException("Requested body is not recognized");
        }

        return new ResponseEntity<>(EDUCATION_SERVICE.save(education), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        EDUCATION_SERVICE.deleteById(id);
    }
}
