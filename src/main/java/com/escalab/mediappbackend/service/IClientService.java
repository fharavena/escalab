package com.escalab.mediappbackend.service;


import com.escalab.mediappbackend.model.Client;

import java.util.List;

public interface IClientService {
    List<Client> findByEstado(Integer state);

    Client getById(Long id);

    List<Client> findByName(String name);

    Object save(Client client);

    void delete(Client byId);
}
