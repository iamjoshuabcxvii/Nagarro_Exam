package com.job.technicalexam.controller;

import com.job.technicalexam.model.exception.ErrorException;
import com.job.technicalexam.service.MainInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    MainInterface mainInterface;

    @GetMapping(value = "/searchapi", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchProducts(@RequestParam String searchTerm) {
        return new ResponseEntity<>(mainInterface.searchApi(searchTerm), HttpStatus.OK);
    }

    @GetMapping(value = "/productapi/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> productSearch(@PathVariable int id) throws ErrorException {
        return new ResponseEntity<>(mainInterface.productApi(id), HttpStatus.OK);
    }

    @GetMapping(value = "/combinedapi", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> combinedSearch(@RequestParam String searchTerm) {

        return new ResponseEntity<>(mainInterface.combinedApi(searchTerm), HttpStatus.OK);
    }
}
