package com.lis.projects.controller;

import com.lis.projects.exception.EmptyCollectionException;
import com.lis.projects.exception.EntityNotFoundException;
import com.lis.projects.exception.GetDoubleArgumentException;
import com.lis.projects.exception.UndefinedRequestBodyException;
import org.springframework.beans.factory.annotation.Autowired;
import com.lis.projects.service.impl.DepartmentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lis.projects.entity.Department;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentsController {
    private final DepartmentServiceImpl DEPARTMENT_SERVICE;

    @Autowired
    public DepartmentsController(DepartmentServiceImpl DEPARTMENT_SERVICE) {
        this.DEPARTMENT_SERVICE = DEPARTMENT_SERVICE;
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAll() {
        List<Department> departments = new ArrayList<>(DEPARTMENT_SERVICE.getAll());

        if (departments.size() == 0) {
            throw new EmptyCollectionException("Department collection contains no items");
        }

        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getById(@PathVariable Long id) {
        Department department = DEPARTMENT_SERVICE.getById(id);

        if (department == null) {
            throw new EntityNotFoundException("There is no department with id="+ id);
        }

        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Department>> getByName(@PathVariable String name) {
        List<Department> departments = new ArrayList<>(DEPARTMENT_SERVICE.getByName(name));

        if (departments == null) {
            throw new EntityNotFoundException("There is no department with name="+ name);
        }

        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Department> add(@RequestBody Department department) {
        List<Department> departments = new ArrayList<>(DEPARTMENT_SERVICE.getAll());

        if (department == null) {
            throw new UndefinedRequestBodyException("Requested body is not recognized");

        } else if (departments.contains(department)) {
            throw new GetDoubleArgumentException("The record of such department already exists in the system");
        }

        return new ResponseEntity<>(DEPARTMENT_SERVICE.save(department), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Department> update(@RequestBody Department department) {

        if (department == null) {
            throw new UndefinedRequestBodyException("Requested body is not recognized");
        }

        return new ResponseEntity<>(DEPARTMENT_SERVICE.save(department), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        DEPARTMENT_SERVICE.deleteById(id);
    }
}
