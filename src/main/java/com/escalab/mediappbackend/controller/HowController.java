package com.escalab.mediappbackend.controller;

import com.escalab.mediappbackend.model.HowKnowUs;
import com.escalab.mediappbackend.service.IHowKnowUs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/how")
public class HowController {

    @Autowired
    private IHowKnowUs hotKnowUsService;

    @GetMapping(value="")
    public ResponseEntity<?> List(){
        Map<String, Object> response = new HashMap<>();
        response.put("data", hotKnowUsService.getAll());
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<?> List(@PathVariable("id") Long id){
        Map<String, Object> response = new HashMap<>();
        response.put("data", hotKnowUsService.getById(id));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> create(@RequestBody(required = true) HowKnowUs howKnowUs) {
        Map<String, Object> response = new HashMap<>();
        if (howKnowUs.getId() != null) {
            response.put("error","viene el id en el body");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        response.put("status", "success");
        response.put("data", hotKnowUsService.save(howKnowUs));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping(value = "")
    public ResponseEntity<?> update(@RequestBody(required = true) HowKnowUs howKnowUs) {
        Map<String, Object> response = new HashMap<>();
        if (howKnowUs.getId() == null) {
            response.put("error","no viene el id en el body");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        response.put("status", "success");
        response.put("data", hotKnowUsService.save(howKnowUs));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        hotKnowUsService.delete(hotKnowUsService.getById(id));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
