package com.escalab.mediappbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "comonosconoce")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class HowKnowUs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shortdescription;

}
