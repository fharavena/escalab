package com.escalab.mediappbackend.service.impl;


import com.escalab.mediappbackend.model.Detail;
import com.escalab.mediappbackend.repository.DetailRepository;
import com.escalab.mediappbackend.service.IDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DetailService implements IDetailService {
    @Autowired
    DetailRepository detailRepository;

    @Override
    public Detail getById(Long id) {
        return detailRepository.findById(id).orElse(null);
    }

    @Override
    public List<Detail> getAll() {
        return detailRepository.findAll();
    }

    @Override
    public Object save(Detail detail) {

        return detailRepository.save(detail);
    }

    @Override
    public void delete(Detail byId) {
        detailRepository.delete(byId);
    }
}
