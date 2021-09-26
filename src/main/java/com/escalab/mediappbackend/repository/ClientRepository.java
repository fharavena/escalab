package com.escalab.mediappbackend.repository;

import com.escalab.mediappbackend.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    public List<Client> findByEstado(Integer estado);

    @Query(value="SELECT * FROM cliente c where c.nombre like %:name% and estado = 1 limit 3", nativeQuery = true)
    List<Client> findByName(String name);

}
