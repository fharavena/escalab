package com.escalab.mediappbackend.repository;

import com.escalab.mediappbackend.model.Client;
import com.escalab.mediappbackend.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetailRepository extends JpaRepository<Detail, Long> {
    @Query(value="SELECT * FROM cliente c where c.nombre like %:name% and estado = 1 limit 3", nativeQuery = true)
    List<Client> findByName(String name);
}
