package com.lis.projects.controller;

import com.lis.projects.exception.EmptyCollectionException;
import com.lis.projects.exception.EntityNotFoundException;
import com.lis.projects.exception.UndefinedRequestBodyException;
import org.springframework.beans.factory.annotation.Autowired;
import com.lis.projects.service.impl.DoctorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lis.projects.entity.Doctor;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorsController {
    private final DoctorServiceImpl DOCTOR_SERVICE;

    @Autowired
    public DoctorsController(DoctorServiceImpl DOCTOR_SERVICE) {
        this.DOCTOR_SERVICE = DOCTOR_SERVICE;
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAll() {
        List<Doctor> doctors = new ArrayList<>(DOCTOR_SERVICE.getAll());

        if (doctors.size() == 0) {
            throw new EmptyCollectionException("Doctors collection contains no items");
        }

        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getById(@PathVariable Long id) {
        Doctor doctor = DOCTOR_SERVICE.getById(id);

        if (doctor == null) {
            throw new EntityNotFoundException("There is no doctor with id="+ id);
        }

        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Doctor> add(@RequestBody Doctor doctor) {

        if (doctor == null) {
            throw new UndefinedRequestBodyException("Requested body is not recognized");
        }

        return new ResponseEntity<>(DOCTOR_SERVICE.save(doctor), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Doctor> update(@RequestBody Doctor doctor) {

        if (doctor == null) {
            throw new UndefinedRequestBodyException("Requested body is not recognized");
        }

        return new ResponseEntity<>(DOCTOR_SERVICE.save(doctor), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        DOCTOR_SERVICE.deleteById(id);
    }
}
