package com.escalab.mediappbackend.controller;


import com.escalab.mediappbackend.dto.SaleInputDTO;
import com.escalab.mediappbackend.model.Sale;
import com.escalab.mediappbackend.repository.SaleRepository;
import com.escalab.mediappbackend.service.ISaleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/sale")
@Validated
public class SaleController {

    @Autowired
    private ISaleService saleService;
    @Autowired
    private SaleRepository saleRepository;

    @GetMapping(value = "")
    public ResponseEntity<?> list() {

        Map<String, Object> response = new HashMap<>();

        response.put("status", "success");
        response.put("data", saleService.findSales());
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();

        Sale sale = saleRepository.findById(id).orElse(null);

        if (sale == null) {
            response.put("status", "error");
            response.put("message", "Producto con id no encontrado");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        response.put("status", "success");
        response.put("data", sale);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PostMapping(path = "")
    public ResponseEntity<?> create(@Valid @RequestBody(required = true) SaleInputDTO saleInput) {
        Map<String, Object> response = new HashMap<>();
        if (saleInput == null) {
            response.put("status", "error");
            response.put("message", "Producto con id no encontrado");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        Map<String, Object> output = saleService.saveSale(saleInput);

        if (output.containsKey("error")) {
            output.put("status", "error");
            return new ResponseEntity<Map<String, Object>>(output, HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity<Map<String, Object>>(output, HttpStatus.CREATED);
    }

    @PostMapping(path = "/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody(required = true) Sale saleInput) {
        Map<String, Object> response = new HashMap<>();
        if (saleInput == null) {
            response.put("error", "body vacio");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        Map<String, Object> output = saleService.editSale(saleInput);

        if (output.containsKey("error")) {
            return new ResponseEntity<Map<String, Object>>(output, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Map<String, Object>>(output, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        Map<String, Object> output = saleService.deleteSale(id);

        if (output.containsKey("error")) {
            return new ResponseEntity<Map<String, Object>>(output, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Map<String, Object>>(output, HttpStatus.CREATED);
    }


}
