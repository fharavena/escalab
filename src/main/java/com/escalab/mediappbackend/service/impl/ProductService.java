package com.escalab.mediappbackend.service.impl;


import com.escalab.mediappbackend.model.Product;
import com.escalab.mediappbackend.repository.ProductRepository;
import com.escalab.mediappbackend.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findByCantidadGreaterThan(Double zero) {
        return (List<Product>) productRepository.findByCantidadGreaterThan(zero);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Object save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Product id) {
        productRepository.delete(id);
    }
}
