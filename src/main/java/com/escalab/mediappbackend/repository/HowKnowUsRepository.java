package com.escalab.mediappbackend.repository;

import com.escalab.mediappbackend.model.HowKnowUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HowKnowUsRepository extends JpaRepository<HowKnowUs, Long> {

}
