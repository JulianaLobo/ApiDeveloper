package com.iftm.ApiDeveloper.controllers;

import com.iftm.ApiDeveloper.models.Developer;
import com.iftm.ApiDeveloper.models.dtos.DeveloperDTO;
import com.iftm.ApiDeveloper.services.DeveloperService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/developers")
public class DeveloperController {

    @Autowired
    private DeveloperService service;

    @GetMapping
    public ResponseEntity<List<DeveloperDTO>> findAll() {
        return service.findAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<DeveloperDTO> findById(@PathVariable("id") ObjectId id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<DeveloperDTO> create(@RequestBody Developer developer) {
        return service.save(developer);
    }

    @PutMapping
    public ResponseEntity<DeveloperDTO> update(@RequestBody DeveloperDTO developer) {
        return service.update(developer);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") ObjectId id) {
        return service.delete(id);
    }
}
