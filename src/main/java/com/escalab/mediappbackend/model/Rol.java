package com.escalab.mediappbackend.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    private Integer idRol;

    @Column(name = "nombre")
    private String nombre;
}
