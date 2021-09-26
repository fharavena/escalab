package com.escalab.mediappbackend.repository;

import com.escalab.mediappbackend.dto.SaleSimpleListDTO;
import com.escalab.mediappbackend.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(value="SELECT venta.id, venta.fecha,venta.cliente_id,cliente.nombre FROM venta inner join cliente on venta.cliente_id = cliente.id", nativeQuery = true)
    List<SaleSimpleListDTO> findSales();

}
