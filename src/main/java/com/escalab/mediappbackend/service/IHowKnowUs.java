package com.escalab.mediappbackend.service;

import com.escalab.mediappbackend.model.HowKnowUs;

import java.util.List;

public interface IHowKnowUs {
    HowKnowUs getById(Long id);
    List<HowKnowUs> getAll();
    Object save(HowKnowUs product);
    void delete(HowKnowUs byId);
}
