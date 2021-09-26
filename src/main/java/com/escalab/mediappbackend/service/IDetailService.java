package com.escalab.mediappbackend.service;



import com.escalab.mediappbackend.model.Detail;
import java.util.List;

public interface IDetailService {
    Detail getById(Long id);
    List<Detail> getAll();
    Object save(Detail product);
    void delete(Detail byId);
}
