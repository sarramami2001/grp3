package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.ICrudService;

@RestController
public class CrudController<T, ID> {

    @Autowired
    private ICrudService<T, ID> service;

    @GetMapping
    // Retrieve all entities
    public ResponseEntity<List<T>> getAll() {
        try {
            List<T> entities = service.getAll();
            return new ResponseEntity<>(entities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    // Add a new entity
    public ResponseEntity<String> add(@RequestBody T entity) {
        try {
            service.add(entity);
            return new ResponseEntity<>("Entity added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add entity", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    // Update an existing entity
    public ResponseEntity<String> update(@RequestBody T entity) {
        try {
            service.update(entity);
            return new ResponseEntity<>("Entity updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update entity", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    // Delete an entity by ID
    public ResponseEntity<String> delete(@PathVariable ID id) {
        try {
            service.delete(id);
            return new ResponseEntity<>("Entity deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete entity", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/all")
    // Add a list of entities
    public ResponseEntity<String> addAll(@RequestBody List<T> list) {
        try {
            service.saveAll(list);
            return new ResponseEntity<>("Entities added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add entities", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
