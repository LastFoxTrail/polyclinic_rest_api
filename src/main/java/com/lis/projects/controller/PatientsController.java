package com.lis.projects.controller;

import com.lis.projects.exception.EmptyCollectionException;
import com.lis.projects.exception.EntityNotFoundException;
import com.lis.projects.exception.UndefinedRequestBodyException;
import org.springframework.beans.factory.annotation.Autowired;
import com.lis.projects.service.impl.PatientServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lis.projects.entity.Patient;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientsController {
    private final PatientServiceImpl PATIENT_SERVICE;

    @Autowired
    public PatientsController(PatientServiceImpl PATIENT_SERVICE) {
        this.PATIENT_SERVICE = PATIENT_SERVICE;
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAll() {
        List<Patient> patients = new ArrayList<>(PATIENT_SERVICE.getAll());

        if (patients.size() == 0) {
            throw new EmptyCollectionException("Patient collection contains no items");
        }

        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getById(@PathVariable Long id) {
        Patient patient = PATIENT_SERVICE.getById(id);

        if (patient == null) {
            throw new EntityNotFoundException("There is no patient with id="+ id);
        }

        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Patient> add(@RequestBody Patient patient) {

        if (patient == null) {
            throw new UndefinedRequestBodyException("Requested body is not recognized");
        }

        return new ResponseEntity<>(PATIENT_SERVICE.save(patient), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Patient> update(@RequestBody Patient patient) {

        if (patient == null) {
            throw new UndefinedRequestBodyException("Requested body is not recognized");
        }

        return new ResponseEntity<>(PATIENT_SERVICE.save(patient), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        PATIENT_SERVICE.deleteById(id);
    }
}
