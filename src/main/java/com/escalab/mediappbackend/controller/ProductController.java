package com.escalab.mediappbackend.controller;

import com.escalab.mediappbackend.model.Product;
import com.escalab.mediappbackend.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping(value = "")
    public ResponseEntity<?> list() {
        Map<String, Object> response = new HashMap<>();

        response.put("data", productService.findByCantidadGreaterThan(0.0));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();

        Product product  = productService.getById(id);


        response.put("data", product);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping(value = "findbyname/{name}")
    public ResponseEntity<?> findByName(@PathVariable("name") String name) {
        Map<String, Object> response = new HashMap<>();

         List<Product> products = productService.findByName(name);

        response.put("status", "success");
        response.put("data", products);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> create(@RequestBody(required = true) Product product) {
        Map<String, Object> response = new HashMap<>();

        if (product.getId() != null) {
            response.put("error","viene el id en el body");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        response.put("status", "success");
        response.put("data", productService.save(product));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping(value = "")
    public ResponseEntity<?> update(@RequestBody(required = true) Product product) {
        Map<String, Object> response = new HashMap<>();

        if (product.getId() == null) {
            response.put("error","no viene el id en el body");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        response.put("data", productService.save(product));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        productService.delete(productService.getById(id));
        response.put("data", "Success");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }



}
