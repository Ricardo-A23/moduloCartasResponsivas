package org.gobierno.carta.responsiva.proyecto.entities;

import jakarta.persistence.*;

@Entity
@Table(name="aplicaciones")
public class Aplicacion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique=true)
    private String nombre;

    @Column(length = 400)
    private String descripcion;

    @Column(length = 200)
    private String urlAcceso;

    private String version;
}
