package com.escalab.mediappbackend.service;


import com.escalab.mediappbackend.model.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findByCantidadGreaterThan(Double zero);

    Product getById(Long id);

    List<Product> findByName(String name);

    Object save(Product product);

    void delete(Product byId);
}
