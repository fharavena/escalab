package com.escalab.mediappbackend.controller;

import com.escalab.mediappbackend.model.Detail;
import com.escalab.mediappbackend.service.IDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/detail")
public class DetailController {
    @Autowired
    private IDetailService detailService;

    @GetMapping(value="")
    public ResponseEntity<?> List(){
        Map<String, Object> response = new HashMap<>();
        response.put("data", detailService.getAll());
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<?> List(@PathVariable("id") Long id){
        Map<String, Object> response = new HashMap<>();
        Detail detail = detailService.getById(id);
        response.put("data",detail);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> create(@RequestBody(required = true) Detail detail) {
        Map<String, Object> response = new HashMap<>();
        if (detail.getId() != null) {
            response.put("error","viene el id en el body");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        response.put("status", "success");
        response.put("data", detailService.save(detail));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping(value = "")
    public ResponseEntity<?> update(@RequestBody(required = true) Detail detail) {
        Map<String, Object> response = new HashMap<>();

        if (detail.getId() == null) {
            response.put("error","no viene el id en el body");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        response.put("status", "success");
        response.put("data", detailService.save(detail));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        detailService.delete(detailService.getById(id));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
