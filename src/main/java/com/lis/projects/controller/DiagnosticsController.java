package com.lis.projects.controller;

import com.lis.projects.exception.EmptyCollectionException;
import com.lis.projects.exception.EntityNotFoundException;
import com.lis.projects.exception.GetDoubleArgumentException;
import com.lis.projects.exception.UndefinedRequestBodyException;
import org.springframework.beans.factory.annotation.Autowired;
import com.lis.projects.service.impl.DiagnosticServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lis.projects.entity.TypeOfDiagnostic;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/diagnostics_types")
public class DiagnosticsController {
    private final DiagnosticServiceImpl DIAGNOSTIC_SERVICE;

    @Autowired
    public DiagnosticsController(DiagnosticServiceImpl diagnosticService) {
        this.DIAGNOSTIC_SERVICE = diagnosticService;
    }

    @GetMapping
    public ResponseEntity<List<TypeOfDiagnostic>> getAll() {
        List<TypeOfDiagnostic> diagnostics = new ArrayList<>(DIAGNOSTIC_SERVICE.getAll());

        if (diagnostics.size() == 0) {
            throw new EmptyCollectionException("Diagnostic collection contains no items");
        }

        return new ResponseEntity<>(diagnostics, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeOfDiagnostic> getById(@PathVariable Long id) {
        TypeOfDiagnostic type = DIAGNOSTIC_SERVICE.getById(id);

        if (type == null) {
            throw new EntityNotFoundException("There is no type of diagnostic with id="+ id);
        }

        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TypeOfDiagnostic> add(@RequestBody TypeOfDiagnostic diagnostic) {
        List<TypeOfDiagnostic> diagnostics = new ArrayList<>(DIAGNOSTIC_SERVICE.getAll());

        if (diagnostic == null) {
            throw new UndefinedRequestBodyException("Requested body is not recognized");

        } else if (diagnostics.contains(diagnostic)) {
            throw new GetDoubleArgumentException("The record of such diagnostic already exists in the system");
        }

        return new ResponseEntity<>(DIAGNOSTIC_SERVICE.save(diagnostic), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TypeOfDiagnostic> update(@RequestBody TypeOfDiagnostic diagnostic) {

        if (diagnostic == null) {
            throw new UndefinedRequestBodyException("Requested body is not recognized");
        }

        return new ResponseEntity<>(DIAGNOSTIC_SERVICE.save(diagnostic), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        DIAGNOSTIC_SERVICE.deleteById(id);
    }
}
