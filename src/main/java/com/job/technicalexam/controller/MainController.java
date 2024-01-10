package com.job.technicalexam.controller;

import com.job.technicalexam.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    MainService mainService;

    @GetMapping(value = "/searchapi", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchProducts(@RequestParam String searchTerm) {


        return new ResponseEntity<>(mainService.searchProducts(searchTerm), HttpStatus.OK);

    }
}
