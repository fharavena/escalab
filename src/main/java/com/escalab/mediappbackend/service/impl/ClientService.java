package com.escalab.mediappbackend.service.impl;


import com.escalab.mediappbackend.model.Client;
import com.escalab.mediappbackend.repository.ClientRepository;
import com.escalab.mediappbackend.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Client> findByEstado(Integer state) {
        return (List<Client>) clientRepository.findByEstado(state);
    }

    @Override
    public Client getById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> findByName(String name) {
        return clientRepository.findByName(name);
    }

    @Override
    public Object save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void delete(Client id) {
        clientRepository.delete(id);
    }
}
