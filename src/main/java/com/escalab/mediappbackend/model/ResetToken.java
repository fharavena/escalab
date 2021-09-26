package com.escalab.mediappbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class ResetToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = false)
    private String token;

    @OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "id_usuario")
    private Usuario user;

    @Column(nullable = false)
    private LocalDateTime expiracion;

    @Column(name = "intentos")
    private Integer count;

    public void setExpiracion(int minutos) {
        LocalDateTime hoy = LocalDateTime.now();
        LocalDateTime exp = hoy.plusMinutes(minutos);
        this.expiracion = exp;
    }

    public boolean estaExpirado() {
        return LocalDateTime.now().isAfter(this.expiracion);
    }
}
