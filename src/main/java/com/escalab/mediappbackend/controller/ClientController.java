package com.escalab.mediappbackend.controller;

import com.escalab.mediappbackend.model.Client;
import com.escalab.mediappbackend.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private IClientService clientService;

    @GetMapping(value="")
    public ResponseEntity<?> list(){
        Map<String, Object> response = new HashMap<>();

        response.put("status", "success");
        response.put("data", clientService.findByEstado(1));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();

        Client client  = clientService.getById(id);

        response.put("status", "success");
        response.put("data", client);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping(value = "findbyname/{name}")
    public ResponseEntity<?> findByName(@PathVariable("name") String name) {
        Map<String, Object> response = new HashMap<>();

        List<Client> client = clientService.findByName(name);

        response.put("status", "success");
        response.put("data", client);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> create(@RequestBody(required = true) Client client) {
        Map<String, Object> response = new HashMap<>();

        if (client.getId() != null) {
            response.put("error","viene el id en el body");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        response.put("status", "success");
        response.put("data", clientService.save(client));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping(value = "")
    public ResponseEntity<?> update(@RequestBody(required = true) Client client) {
        Map<String, Object> response = new HashMap<>();

        if (client.getId() == null) {
            response.put("error","no viene el id en el body");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        response.put("data", clientService.save(client));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        clientService.delete(clientService.getById(id));
        response.put("data", "Success");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


}
