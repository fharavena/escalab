package com.escalab.mediappbackend.service;


import com.escalab.mediappbackend.dto.SaleInputDTO;
import com.escalab.mediappbackend.dto.SaleSimpleListDTO;
import com.escalab.mediappbackend.model.Sale;

import java.util.List;
import java.util.Map;

public interface ISaleService {
    public List<SaleSimpleListDTO> findSales();
    public Map<String, Object> saveSale(SaleInputDTO saleInput);
    public Map<String, Object> editSale(Sale saleInput);
    public Map<String, Object> deleteSale(Long id);
}
