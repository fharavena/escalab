package com.escalab.mediappbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "usuario")
public class Usuario {
    @Id
    private Integer idUsuario;

    @Column(name = "nombre")
    private String userName;

    @Column(name = "clave")
    private String password;

    @Column(name = "estado")
    private boolean estado;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_rol",
            joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol"))
    private List<Rol> rols;

    public Integer getIdUsuario() {
        return idUsuario;
    }
}
