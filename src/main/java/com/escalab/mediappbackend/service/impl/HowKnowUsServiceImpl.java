package com.escalab.mediappbackend.service.impl;

import com.escalab.mediappbackend.model.HowKnowUs;
import com.escalab.mediappbackend.repository.HowKnowUsRepository;
import com.escalab.mediappbackend.service.IHowKnowUs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HowKnowUsServiceImpl implements IHowKnowUs {
    @Autowired
    HowKnowUsRepository howKnowUsRepository;

    @Override
    public HowKnowUs getById(Long id) {
        return howKnowUsRepository.findById(id).orElse(null);
    }

    @Override
    public List<HowKnowUs> getAll() {
        return howKnowUsRepository.findAll();
    }

    @Override
    public Object save(HowKnowUs howKnowUs) {
        return howKnowUsRepository.save(howKnowUs);
    }

    @Override
    public void delete(HowKnowUs byId) {
        howKnowUsRepository.delete(byId);
    }
}
